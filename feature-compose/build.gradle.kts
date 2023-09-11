@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)

    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.lsakee.feature_compose"
    compileSdk = 33

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(project(":core-ui"))
    implementation(project(":domain"))
    // Kotlin
    implementation(KotlinX.KOTLINX_SERIALIZATION)

    implementation(Compose.COMPOSE_ACTIVITY)
    implementation(Compose.COMPOSE_MATERIAL)
    implementation(Compose.COMPOSE_PREVIEW)
    implementation(Compose.COMPOSE_UI)
    implementation(Compose.COMPOSE_NAV)
    implementation(Compose.COMPOSE_ANI_NAV)
    implementation(Compose.COMPOSE_LANDSCAPIST)
    implementation(Compose.COMPOSE_HILT_NAV)
    implementation(Compose.COMPOSE_WEBVOEW)

    // Test Dependency
    androidTestImplementation(TestDependencies.EXT_JUNIT)
    androidTestImplementation(TestDependencies.ESPRESSO_CORE)
    testImplementation(TestDependencies.JUNIT)

    //Hilt
    implementation(Google.HILT_ANDROID)
    kapt(Google.HILT_ANDROID_COMPILER)

    // Third-Party
    implementation(SquareUp.RETROFIT2)
    implementation(SquareUp.RETROFIT2_CONVERTER_GSON)
    implementation(SquareUp.OKHTTP3)
    implementation(SquareUp.OKHTTP3_LOGGING)
    implementation(SquareUp.OKHTTP3_BOM)
    implementation(Jakewharton.TIMBER)
    implementation(Jakewharton.CONVERTER)
    implementation(ThirdParty.COIL)
    implementation(ThirdParty.ZXING)
}