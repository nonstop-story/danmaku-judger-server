package com.nonstop.judger

import com.emmmer.killer.DanmakuDB
import org.junit.Test

@ExperimentalStdlibApi
class DanmakuTest {
    @Test
    fun testRandomQuestion() {
        val db = DanmakuDB("database/file.txt")
        repeat(10) {
            println(db.randomQuestion())
        }
    }
}
