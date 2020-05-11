package com.nonstop.judger

import com.emmmer.killer.BlackDB
import org.junit.Test

@ExperimentalStdlibApi
class BlackTest {
    @Test
    fun testRandomQuestion() {
        val db = BlackDB("database/black.txt")
        repeat(10) {
            println(db.creatBlackList())
        }
    }
}
