import com.pandora.extensions.setFrameworkBaseName

plugins {
    id("com.pandora.multiplatform")
}

kotlin {
    setFrameworkBaseName("domain")

    sourceSets {
        commonMain.dependencies {
            implementation(libs.koin.core)
            implementation(libs.kotlinx.coroutines.core)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.pandora.domain"
}
