import com.pandora.extensions.setFrameworkBaseName

plugins {
    id("com.pandora.multiplatform")
}

kotlin {
    setFrameworkBaseName("repositories")

    sourceSets {
        commonMain.dependencies {
            implementation(projects.api)
            implementation(projects.domain)
            implementation(libs.koin.core)
            implementation(libs.kotlinx.coroutines.core)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.pandora.repositories"
}
