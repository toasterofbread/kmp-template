plugins {
    id("kmp-conventions")
    id("publishing-conventions")

    alias(libs.plugins.kotlin)
    alias(libs.plugins.publish)
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {

            }
        }
    }
}

val projectName: String = libs.versions.project.name.get()
val projectVersion: String = project.libs.versions.project.name.get()
val artifactName: String = "library"

android {
    namespace = "dev.toastbits.$projectName.$artifactName"
}

mavenPublishing {
    coordinates("dev.toastbits.$projectName", artifactName, projectVersion)
}
