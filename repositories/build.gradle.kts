import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
}

@OptIn(ExperimentalKotlinGradlePluginApi::class)
kotlin {
    jvm()
    jvmToolchain(17)
    androidTarget {
        compilerOptions {
            apiVersion.set(KotlinVersion.KOTLIN_2_0)
        }
    }

    task("testClasses")
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "repositories"
            isStatic = true
        }
    }

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
    compileSdk = 34
    defaultConfig {
        minSdk = 26
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
