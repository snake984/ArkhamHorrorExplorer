enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        includeBuild("plugins")
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Arkham_Horror_Explorer"
include(":androidApp")
include(":shared")
include(":domain")
include(":api")
include(":features:home")
include(":libraries:designsystem")
include(":repositories")
include(":libraries:coroutines")
include(":libraries:parcelable")
