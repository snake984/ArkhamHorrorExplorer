plugins {
    kotlin("jvm")
    alias(libs.plugins.compose)
    alias(libs.plugins.compose.compiler)
    application
}

dependencies {
    implementation(projects.shared)
    implementation(libs.koin.core)
    implementation(compose.runtime)
    implementation(compose.materialIconsExtended)
    implementation(compose.material)
    implementation(compose.material3)
    implementation(compose.components.resources)
    implementation(compose.desktop.currentOs)
    implementation(compose.desktop.common)
}

application {
    mainClass.set("com.pandora.MainKt")
}
