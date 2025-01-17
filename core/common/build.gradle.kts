plugins {
    alias(libs.plugins.appname.android.library)
    alias(libs.plugins.appname.android.library.compose)
}

android {
    namespace = "com.tasnimulhasan.common"
}

dependencies {
    implementation(projects.core.sharedPreference)
    implementation(projects.core.designSystem)
    implementation(projects.core.model.entity)
    implementation(libs.timber)
    implementation(libs.bundles.androidx.core.dependencies)
    implementation(libs.bundles.androidx.material.dependencies)
    implementation(libs.bundles.androidx.lifecycle.dependencies)
    implementation(libs.bundles.androidx.navigation.dependencies)
}