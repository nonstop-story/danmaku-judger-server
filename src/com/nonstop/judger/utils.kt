package com.nonstop.judger

fun Boolean.runIf(block: () -> Unit) {
    if (this) {
        block()
    }
}