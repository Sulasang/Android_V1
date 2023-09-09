plugins {
    `kotlin-dsl`
}

group = "com.lsakee.convention"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("JavaLibraryPlugin") {
            id = "lsakee.plugin.java.library"
            implementationClass = "JavaLibraryConventionPlugin"
        }
        register("AndroidHiltPlugin") {
            id = "lsakee.plugin.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }
        register("AndroidLibraryPlugin") {
            id = "lsakee.plugin.android-library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("AndroidApplicationPlugin") {
            id = "lsakee.plugin.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("FeaturePlugin") {
            id = "lsakee.plugin.feature"
            implementationClass = "FeatureConventionPlugin"
        }
    }
}