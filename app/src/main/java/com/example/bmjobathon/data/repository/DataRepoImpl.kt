package com.example.bmjobathon.data.repository

import com.example.bmjobathon.data.remote.dto.RatesResponse
import com.example.bmjobathon.data.remote.webservice.WebService
import com.example.bmjobathon.domain.repository.DataRepo
import com.example.bmjobathon.util.ErrorType
import com.example.bmjobathon.util.Resource
import java.net.SocketTimeoutException
import javax.inject.Inject

class DataRepoImpl @Inject constructor(
    private val webService: WebService
) : DataRepo {
    override suspend fun getRates(): Resource<RatesResponse> {
        try {
            val task = webService.getRates()
            if (task.isSuccessful) {
                task.body()?.let {
                    return Resource.Success(data = it )
                } ?: return Resource.Error(errorType = ErrorType.EMPTY_DATA)
            } else {
                return Resource.Error()
            }
        } catch (e: SocketTimeoutException) {
            return Resource.Error(errorType = ErrorType.TIME_OUT)
        } catch (e: Exception) {
            return Resource.Error(message = e.localizedMessage)
        }
    }
}
