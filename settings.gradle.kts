@file:Suppress("UnstableApiUsage")

include(":application:androidMain")


pluginManagement {
    includeBuild("build-logic")

    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

rootProject.name = "KmpTemplate"
include(":library")
include(":application")
