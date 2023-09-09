
plugins {
    id("lsakee.plugin.java.library")
    id("org.jetbrains.kotlin.plugin.serialization")
}


dependencies {

    implementation(project(":domain"))

    implementation(libs.bundles.coroutine)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.kotlin.serialization)
    implementation(libs.okhttp.logging)

    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.hilt.core)


    testImplementation(libs.junit4)
}