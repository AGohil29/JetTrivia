package com.goldmedal.jettrivia.repository

import android.util.Log
import com.goldmedal.jettrivia.data.DataOrException
import com.goldmedal.jettrivia.model.QuestionItem
import com.goldmedal.jettrivia.network.QuestionApi
import javax.inject.Inject

class QuestionRepository @Inject constructor(private val api: QuestionApi) {
    private val dataOrException = DataOrException<ArrayList<QuestionItem>, Boolean, Exception>()

    suspend fun getAllQuestions(): DataOrException<ArrayList<QuestionItem>, Boolean, Exception> {
        try {
            dataOrException.loading = true
            dataOrException.data = api.getAllQuestions()
            if (dataOrException.data.toString().isNotEmpty()) dataOrException.loading = false
        } catch (e: Exception) {
            dataOrException.exception = e
            Log.d("Exception", "getAllQuestions: ${dataOrException.exception!!.localizedMessage}")
        }
        return dataOrException
    }
}