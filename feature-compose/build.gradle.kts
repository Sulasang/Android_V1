
plugins {
    id("lsakee.feature.compose")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.serialization")
}

android {
    namespace = "com.lsakee.feature_compose"
    compileSdk = 33
}


dependencies {

    implementation(project(":domain"))
    implementation(libs.kotlinx.serialization.json)
    implementation(project(mapOf("path" to ":core-ui")))

    testImplementation(libs.junit4)
    androidTestImplementation(libs.junit)
    androidTestImplementation(libs.espresso.core)
}