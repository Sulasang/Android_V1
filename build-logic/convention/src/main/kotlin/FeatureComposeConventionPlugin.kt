import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

internal class FeatureComposeConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("lsakee.plugin.android-library")
                apply("lsakee.plugin.hilt")
            }

            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            dependencies {
                "implementation"(project(":domain"))
                "implementation"(libs.findLibrary("kotlinx.coroutines.android").get())
                "implementation"(libs.findLibrary("kotlinx.coroutines.core").get())
                "implementation"(libs.findLibrary("timber").get())
            }
        }
    }
}