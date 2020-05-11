package com.nonstop.judger

import com.emmmer.killer.DanmakuDB
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.client.HttpClient
import io.ktor.client.features.auth.Auth
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logging
import io.ktor.features.ContentNegotiation
import io.ktor.gson.gson
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@ExperimentalStdlibApi
@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(ContentNegotiation) {
        gson {
        }
    }

    val client = HttpClient() {
        install(Auth) {
        }
        install(JsonFeature) {
            serializer = GsonSerializer()
        }
        install(Logging) {
            level = LogLevel.HEADERS
        }
    }

    val db = DanmakuDB("database/file.txt")

    routing {
        get("/") {
            call.respondText("hello world!")
        }

        get("/questions/one") {
            call.respond(db.randomQuestion() ?: HttpStatusCode.NoContent)
        }

        get("/greetings") {
            call.respond(
                mapOf(
                    "server" to "DanmakuJudger",
                    "version" to 0.1,
                    "database-by" to "Emmmer",
                    "server-by" to "kiva",
                    "server-time" to System.currentTimeMillis()
                )
            )
        }
    }
}
