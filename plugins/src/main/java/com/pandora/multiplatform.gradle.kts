package com.pandora

import com.pandora.extensions.androidSdkCompile
import com.pandora.extensions.androidSdkMin
import com.pandora.extensions.jvmToolchain
import org.gradle.api.JavaVersion
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

val libs: VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")

plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

@OptIn(ExperimentalKotlinGradlePluginApi::class)
kotlin {
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    jvm()
    jvmToolchain(libs.jvmToolchain)
    applyDefaultHierarchyTemplate()
    androidTarget {
        compilerOptions {
            apiVersion.set(KotlinVersion.KOTLIN_2_0)
        }
    }

    task("testClasses")
}

android {
    compileSdk = libs.androidSdkCompile
    defaultConfig {
        minSdk = libs.androidSdkMin
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}