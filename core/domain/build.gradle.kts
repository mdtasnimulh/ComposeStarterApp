plugins {
    alias(libs.plugins.appname.android.library)
    alias(libs.plugins.appname.android.library.compose)
    alias(libs.plugins.appname.android.hilt)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.tasnimulhasan.domain"
}

dependencies {
    api(projects.core.model.entity)

    implementation(libs.kotlin.coroutines)
    implementation(libs.javax.inject)
    implementation(libs.bundles.androidx.core.dependencies)
    implementation(libs.bundles.androidx.material.dependencies)
    implementation(libs.bundles.room.dependencies)
}