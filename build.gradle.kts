plugins {
    @Suppress("DSL_SCOPE_VIOLATION")
    alias(libs.plugins.android.application) apply false
    @Suppress("DSL_SCOPE_VIOLATION")
    alias(libs.plugins.android.library) apply false
    @Suppress("DSL_SCOPE_VIOLATION")
    alias(libs.plugins.kotlin.android) apply false
    @Suppress("DSL_SCOPE_VIOLATION")
    alias(libs.plugins.google.services) apply false
    @Suppress("DSL_SCOPE_VIOLATION")
    alias(libs.plugins.kotlin.jvm) apply false
    @Suppress("DSL_SCOPE_VIOLATION")
    alias(libs.plugins.kotlin.serialization) apply false
    @Suppress("DSL_SCOPE_VIOLATION")
    alias(libs.plugins.ksp) apply false
    @Suppress("DSL_SCOPE_VIOLATION")
    alias(libs.plugins.hilt) apply false
}

buildscript {
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
        maven(url = "https://devrepo.kakao.com/nexus/content/groups/public/")
    }

    dependencies {
        classpath(libs.android.gradlePlugin)
        classpath(libs.kotlin.gradlePlugin)
        classpath(libs.oss.gradlePlugin)
    }
}