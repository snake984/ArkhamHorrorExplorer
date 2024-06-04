package com.pandora.extensions

import org.gradle.api.artifacts.VersionCatalog

val VersionCatalog.androidSdkCompile: Int
    get() = Integer.parseInt(findVersion("android.sdk.compile").get().requiredVersion)

val VersionCatalog.androidSdkMin: Int
    get() = Integer.parseInt(findVersion("android.sdk.min").get().requiredVersion)

val VersionCatalog.jvmToolchain: Int
    get() = Integer.parseInt(findVersion("jvmToolchain").get().requiredVersion)