plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    kotlin("plugin.serialization") version Versions.KOTLIN_VERSION
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.lsakee.suwon_sulasang"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.lsakee.suwon_sulasang"
        minSdk = 26
        targetSdk = 33
        versionCode = 2
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
}

dependencies {

    implementation(project(":feature"))
    implementation(project(":core-ui"))
    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(project(":data-remote"))
    implementation(project(":di"))

    // Matrial Design
    implementation(Google.MATERIAL)

    // Test Dependency
    androidTestImplementation(TestDependencies.EXT_JUNIT)
    androidTestImplementation(TestDependencies.ESPRESSO_CORE)
    testImplementation(TestDependencies.JUNIT)

    //Hilt
    implementation(Google.HILT_ANDROID)
    kapt(Google.HILT_ANDROID_COMPILER)

    // Third-Party
    implementation(Jakewharton.TIMBER)
}