package com.lsakee.suwon_sulasang.design_system.style.util
internal inline fun <T> T.runIf(condition: Boolean, run: T.() -> T) = if (condition) {
    run()
} else this