package com.nonstop.judger

import io.ktor.http.*
import io.ktor.server.testing.handleRequest
import io.ktor.server.testing.setBody
import io.ktor.server.testing.withTestApplication
import kotlin.test.Test
import kotlin.test.assertEquals

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

    @Test
    fun testPostJson() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Post, "/questions/one") {
                addHeader(HttpHeaders.ContentType, ContentType.Application.Json.toString())
                // language=JSON
                setBody("""{"@type": "white", "uid": 10001}""")
            }.apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals("""
                    {"result":"OK","type":"white","uid":10001}
                """.trimIndent(), response.content)
            }
        }
    }
}
