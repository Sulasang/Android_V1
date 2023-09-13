plugins {
    id("lsakee.plugin.application")
    id("lsakee.plugin.hilt")
}

android {
    namespace = "com.lsakee.suwon_sulasang"

    defaultConfig {
        applicationId = "com.lsakee.suwon_sulasang"
        minSdk = 26
        targetSdk = 33
        versionCode =3
        versionName = "1.0.1"
        testInstrumentationRunner ="androidx.test.runner.AndroidJUnitRunner"
    }


    viewBinding.enable = true
    dataBinding.enable = true
}

dependencies {

    implementation(project(":feature"))
    implementation(project(":feature-compose"))
    implementation(project(":core-ui"))
    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(project(":data-remote"))
    implementation(project(":di"))

    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.splashscreen)
    implementation(libs.bundles.androidx.navigation)

    implementation(libs.retrofit.core)
    implementation(libs.retrofit.kotlin.serialization)
    implementation(libs.okhttp.logging)
    implementation(libs.bundles.coroutine)
    implementation(libs.kotlinx.serialization.json)

    implementation(libs.timber)

    testImplementation(libs.junit4)
    androidTestImplementation(libs.junit)
    androidTestImplementation(libs.espresso.core)
}