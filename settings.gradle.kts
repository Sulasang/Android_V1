pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
}

rootProject.name = "Suwon_Sulasang"
include(":app")
include(":feature")
include(":core-ui")
include(":data")
include(":domain")
include(":data-remote")
include(":di")
include(":feature-compose")
include(":design-system")
