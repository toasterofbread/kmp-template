@file:OptIn(ExperimentalKotlinGradlePluginApi::class, ExperimentalWasmDsl::class)

import com.vanniktech.maven.publish.SonatypeHost
import com.vanniktech.maven.publish.KotlinMultiplatform
import com.vanniktech.maven.publish.JavadocJar
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl

plugins {
    id("com.android.library")
    kotlin("multiplatform")
    id("org.jetbrains.dokka")
    id("com.vanniktech.maven.publish")
}

kotlin {
    jvm()

    androidTarget {
        publishLibraryVariants("release")
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    linuxX64()
    linuxArm64()
    mingwX64()

    wasmJs {
        browser()
    }
    
    applyDefaultHierarchyTemplate {
        common {
            group("jvm") {
                withAndroidTarget()
                withJvm()
            }
            withLinuxX64()
            withLinuxArm64()
            withMingwX64()
            withWasmJs()
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {

            }
        }
    }
}

android {
    namespace = "dev.toastbits.kmp"
    compileSdk = (findProperty("android.compileSdk") as String).toInt()
    defaultConfig {
        minSdk = (findProperty("android.minSdk") as String).toInt()
    }
}

mavenPublishing {
    coordinates("dev.toastbits.kmp", "ytmkt", "0.0.1")

    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
    signAllPublications()

    configure(KotlinMultiplatform(
        javadocJar = JavadocJar.Dokka("dokkaHtml"),
        sourcesJar = true
    ))

    pom {
        name.set("kmp-template")
        description.set("Kotlin Multiplatform library template")
        url.set("https:/github.com/toasterofbread/kmp-template")
        inceptionYear.set("2024")

        licenses {
           license {
                name.set("Apache-2.0")
                url.set("https://www.apache.org/licenses/LICENSE-2.0")
            }
        }
        developers {
            developer {
                id.set("toasterofbread")
                name.set("Talo Halton")
                email.set("talohalton@gmail.com")
                url.set("https://github.com/toasterofbread")
            }
        }
        scm {
            connection.set("https://github.com/toasterofbread/kmp-template.git")
            url.set("https://github.com/toasterofbread/kmp-template")
        }
        issueManagement {
            system.set("Github")
            url.set("https://github.com/toasterofbread/kmp-template/issues")
        }
    }
}
