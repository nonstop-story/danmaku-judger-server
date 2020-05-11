package com.nonstop.judger

import io.ktor.http.*
import kotlin.test.*
import io.ktor.server.testing.*

@ExperimentalStdlibApi
class ApplicationTest {
    @Test
    fun testRoot() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "/").apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals("hello world!", response.content)
            }
        }
    }
}
