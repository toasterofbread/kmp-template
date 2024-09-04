import org.jetbrains.kotlin.gradle.targets.js.dsl.KotlinWasmJsTargetDsl
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig
import util.configureAllComposeTargets

plugins {
    id("android-application-conventions")
    id("compose-conventions")

    alias(libs.plugins.kotlin)
}

kotlin {
    configureAllComposeTargets {
        when (this) {
            is KotlinWasmJsTargetDsl -> {
                browser {
                    commonWebpackConfig {
                        outputFileName = "client.js"
                        devServer = (devServer ?: KotlinWebpackConfig.DevServer()).apply {
                            static = (static ?: mutableListOf()).apply {
                                // Serve sources to debug inside browser
                                add(project.projectDir.path)
                                add(project.projectDir.path + "/commonMain/")
                                add(project.projectDir.path + "/wasmJsMain/")
                            }
                        }
                    }
                }
                binaries.executable()
            }
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(projects.library)

                implementation(libs.ktor.core)
            }
        }

        val jvmMain by getting {
            dependencies {
                implementation(compose.desktop.currentOs)
            }
        }

        val androidMain by getting {
            dependencies {
                implementation(libs.androidx.activity.compose)
            }
        }
    }
}
