import com.pandora.extensions.setFrameworkBaseName

plugins {
    id("com.pandora.multiplatform")
    alias(libs.plugins.compose)
    alias(libs.plugins.compose.compiler)
    id("com.pandora.kotlin-parcelable")
}

kotlin {
    setFrameworkBaseName("home")

    sourceSets {
        commonMain.dependencies {
            implementation(projects.domain)
            implementation(projects.libraries.coroutines)
            implementation(projects.libraries.designsystem)
            implementation(projects.libraries.parcelable)
            implementation(compose.runtime)
            implementation(compose.materialIconsExtended)
            implementation(compose.material)
            implementation(compose.material3)
            implementation(compose.components.resources)
            implementation(libs.koin.core)
            implementation(libs.koin.compose.jb)
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.androidx.lifecyle.viewmodel.compose)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }

        androidMain.dependencies {
            implementation(libs.koin.android)
        }
    }
}

android {
    namespace = "com.pandora.home"

    buildFeatures {
        compose = true
    }
}
