import com.pandora.extensions.setFrameworkBaseName

plugins {
    id("com.pandora.multiplatform")
    alias(libs.plugins.kotlin.serialization)
}

kotlin {
    setFrameworkBaseName("api")

    sourceSets {
        commonMain.dependencies {
            implementation(libs.koin.core)
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.kotlinx.serialization)
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.content.negociation)
            implementation(libs.ktor.client.logging)
            implementation(libs.ktor.serialization.kotlinx)
        }
        androidMain.dependencies {
            implementation(libs.ktor.client.okhttp)
        }
        jvmMain.dependencies {
            implementation(libs.ktor.client.okhttp)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.pandora.api"
}
