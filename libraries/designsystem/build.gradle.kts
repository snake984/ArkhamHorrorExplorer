import com.pandora.extensions.setFrameworkBaseName

plugins {
    id("com.pandora.multiplatform")
    alias(libs.plugins.compose)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    setFrameworkBaseName("designsystem")

    sourceSets {
        commonMain.dependencies {
            implementation(libs.koin.compose.jb)
            implementation(compose.runtime)
            implementation(compose.material)
            implementation(compose.material3)
            implementation(libs.kamel.image)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.pandora.designsystem"
}
