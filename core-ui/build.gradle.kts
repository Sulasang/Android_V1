@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("lsakee.plugin.android-library")
}
android {
    namespace = "com.lsakee.core_ui"
    buildFeatures {
        dataBinding = true
    }
}


dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.google.material)
    testImplementation(libs.junit4)
    androidTestImplementation(libs.junit)
    androidTestImplementation(libs.espresso.core)
}