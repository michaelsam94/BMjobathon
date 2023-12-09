package com.example.bmjobathon.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.example.bmjobathon.data.local.model.DataModel

data class GetDataDto(
    @SerializedName("result")
    val result: String
)

fun GetDataDto.toDataModel(): DataModel {
    return DataModel(result = this.result)
}
