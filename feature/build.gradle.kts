
plugins {
    id("lsakee.plugin.feature")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.serialization")
}

android {
    namespace = "com.lsakee.feature"
    dataBinding.enable = true
}

dependencies {

    implementation(project(":domain"))
    implementation(project(":feature-compose"))
    implementation(libs.kotlinx.serialization.json)
    implementation(project(mapOf("path" to ":core-ui")))

    testImplementation(libs.junit4)
    androidTestImplementation(libs.junit)
    androidTestImplementation(libs.espresso.core)
}