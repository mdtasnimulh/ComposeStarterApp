plugins {
    alias(libs.plugins.appname.android.library)
    alias(libs.plugins.appname.android.library.compose)
}

android {
    namespace = "com.tasnimulhasan.ui"
}

dependencies {
    api(projects.core.designSystem)
    api(projects.core.common)

    api(libs.androidx.metrics)
    implementation(libs.coil.kt)
    implementation(libs.coil.kt.compose)
    implementation(libs.bundles.androidx.material.dependencies)
}