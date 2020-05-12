package com.emmmer.killer

import java.io.File

@Suppress("MemberVisibilityCanBePrivate")
data class Danmaku(val rawText: String) {
    val uid: Long
    val text: String

    init {
        val array = rawText.split(":", limit = 3)
        uid = array[1].toLong()
        text = array[2]
    }

    override fun toString(): String {
        return "Danmaku{uid: $uid, text: $text}"
    }
}

@ExperimentalStdlibApi
class DanmakuDB(file: String) {
    private val data = File(file).readLines()
        .filter { line -> line.count { it == ':' } >= 2 }
        .map { Danmaku(it) }
        .toList()

    fun randomQuestion(): Danmaku? = data.randomOrNull()
}

data class BlockedUser(val uid: Long)

@ExperimentalStdlibApi
class BlackDB(private val file: String) {
    private val data = File(file).readLines()
        .map { BlockedUser(it.toLong()) }
        .toMutableList()

    fun add(uid: Long) = data.add(BlockedUser(uid))

    fun size() = data.size

    fun saveToFile() = File(file).writer().use { stream ->
        data.forEach {
            stream.write("${it.uid}\n")
        }
    }
}
