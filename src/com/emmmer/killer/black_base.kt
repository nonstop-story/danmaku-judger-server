package com.emmmer.killer

import java.io.File;

data class Black(val rawText: String) {
    private val uid: Long = rawText.toLong()
    private val blackArray: Array<Long>? = null

    fun toArray(): Array<Long> {
        blackArray?.plus(uid)
    }
}

@ExperimentalStdlibApi
class BlackDB(file: String) {

    private val data = File(file).readLines()
        .map { Black(it) }
        .toList()

    fun creatBlackList(): Black? = data.randomOrNull()
}