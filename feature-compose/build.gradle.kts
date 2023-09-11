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
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }

    buildFeatures {
        viewBinding = true
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.8"
    }
}

dependencies {

    implementation(project(":core-ui"))
    implementation(project(":domain"))
    implementation(project(":design-system"))
    // Kotlin
    implementation(KotlinX.KOTLINX_SERIALIZATION)

    implementation(libs.google.material)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.navigation.fragment.ktx)
    implementation(libs.navigation.ui.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.activity.compose)
    implementation(platform(libs.compose.bom))
    implementation(libs.ui)
    implementation(libs.ui.graphics)
    implementation(libs.ui.tooling.preview)
    implementation(libs.material3)

    // Test Dependency
    androidTestImplementation(TestDependencies.EXT_JUNIT)
    androidTestImplementation(TestDependencies.ESPRESSO_CORE)
    testImplementation(TestDependencies.JUNIT)

    //Hilt
    implementation(Google.HILT_ANDROID)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.ui.test.junit4)
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)
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