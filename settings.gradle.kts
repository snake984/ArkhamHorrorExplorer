enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
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
include(":desktopApp")
include(":shared")
include(":domain")
include(":api")
include(":features:home")
include(":repositories")
include(":libraries:designsystem")
include(":libraries:coroutines")
include(":libraries:parcelable")
