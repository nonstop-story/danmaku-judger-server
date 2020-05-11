package com.emmmer.killer

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonSubTypes(
    JsonSubTypes.Type(JudgeResult.White::class, name = "white"),
    JsonSubTypes.Type(JudgeResult.Black::class, name = "black")
)
sealed class JudgeResult {
    class White(val uid: Long) : JudgeResult()
    class Black(val uid: Long) : JudgeResult()

    fun typeString(): String = when (this) {
        is White -> "white"
        is Black -> "black"
    }

    fun uid(): Long = when (this) {
        is White -> this.uid
        is Black -> this.uid
    }
}
