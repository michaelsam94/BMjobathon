package com.example.bmjobathon.domain.repository

import com.example.bmjobathon.data.local.model.DataModel
import com.example.bmjobathon.data.remote.dto.RatesResponse
import com.example.bmjobathon.util.Resource

interface DataRepo {
    suspend fun getRates(): Resource<RatesResponse>
}
