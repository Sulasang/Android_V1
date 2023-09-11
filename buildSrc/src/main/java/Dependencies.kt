object AndroidX {
    const val ACTIVITY = "androidx.activity:activity-ktx:1.1.0"
    const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"
    const val CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_KTX}"
    const val LIFECYCLE_RUNTIME =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE_RUNTIME}"

    const val FRAGMENT_KTX = "androidx.fragment:fragment-ktx:${Versions.FRAGMENT_KTX}"
    const val LIFECYCLE_VIEWMODEL_KTX =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE_VIEWMODEL_KTX}"

    const val SPLASH_SCREEN = "androidx.core:core-splashscreen:${Versions.SPLASHSCREEN}"
    const val PAGING = "androidx.paging:paging-runtime-ktx:${Versions.PAGING_VERSION}"

    const val NAVIGATION_CONPONENT_FRAGMENT =
        "androidx.navigation:navigation-fragment-ktx:${Versions.NAV_VERSION}"
    const val NAVIGATION_CONPONENT_UI =
        "androidx.navigation:navigation-ui-ktx:${Versions.NAV_VERSION}"

    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_VERSION}"
}

object TestDependencies {
    const val JUNIT = "junit:junit:${Versions.JUNIT}"
    const val EXT_JUNIT = "androidx.test.ext:junit:${Versions.EXT_JUNIT}"
    const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO_CORE}"

}

object Google {
    const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
    const val HILT_ANDROID = "com.google.dagger:hilt-android:${Versions.HILT}"
    const val HILT_ANDROID_COMPILER = "com.google.dagger:hilt-android-compiler:${Versions.HILT}"
    const val GOOGLE_PLAY =
        "com.google.android.gms:play-services-auth:${Versions.GOOGLE_PLAY_VERSION}"
}

object SquareUp {
    const val RETROFIT2 = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT_VERSION}"
    const val RETROFIT2_CONVERTER_GSON =
        "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT_VERSION}"
    const val OKHTTP3_BOM = "com.squareup.okhttp3:okhttp-bom:${Versions.OKHTTP3_BOM}"
    const val OKHTTP3 = "com.squareup.okhttp3:okhttp"
    const val OKHTTP3_LOGGING = "com.squareup.okhttp3:logging-interceptor"

}

object KotlinX {
    const val KOTLINX_COROUTINE =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.KOTLINX_COROUTINE}"
    const val KOTLINX_SERIALIZATION =
        "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.KOTLIN_SERIALIZATION_VERSION}"
}

object ThirdParty {
    const val COIL = "io.coil-kt:coil:${Versions.COIL}"
    const val ZXING = "com.journeyapps:zxing-android-embedded:${Versions.ZXING_VERSION}"
}

object Jakewharton {
    const val TIMBER = "com.jakewharton.timber:timber:${Versions.TIMBER}"
    const val CONVERTER = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0"
}

object Compose {
    const val COMPOSE_UI = "androidx.compose.ui:ui:${Versions.COMPOSE}"
    const val COMPOSE_MATERIAL = "androidx.compose.material:material:${Versions.COMPOSE}"
    const val COMPOSE_PREVIEW = "androidx.compose.ui:ui-tooling-preview:${Versions.COMPOSE}"
    const val COMPOSE_ACTIVITY = "androidx.activity:activity-compose:${Versions.ACTIVITY_COMPOSE}"
    const val COMPOSE_TEST = "androidx.compose.ui:ui-test-junit4:${Versions.COMPOSE}"
    const val COMPOSE_UI_TOOL = "androidx.compose.ui:ui-tooling:${Versions.COMPOSE}"
    const val COMPOSE_NAV = "androidx.navigation:navigation-compose:${Versions.NAV}"
    const val COMPOSE_ANI_NAV = "com.google.accompanist:accompanist-navigation-animation:${Versions.ANI_NAV}"
    const val COMPOSE_LANDSCAPIST = "com.github.skydoves:landscapist-glide:${Versions.LANDSCAPIST}"
    const val COMPOSE_HILT_NAV = "androidx.hilt:hilt-navigation-compose:${Versions.HILT_NAV}"
    const val COMPOSE_WEBVOEW = "com.google.accompanist:accompanist-webview:0.24.13-rc"
}