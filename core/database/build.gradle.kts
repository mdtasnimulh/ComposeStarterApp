plugins {
    alias(libs.plugins.appname.android.library)
    alias(libs.plugins.appname.android.library.compose)
    alias(libs.plugins.appname.android.hilt)
}

android {
    namespace = "com.tasnimulhasan.database"
}

dependencies {
    implementation(projects.core.domain)

    implementation(libs.kotlinx.datetime)
    implementation(libs.bundles.room.dependencies)
    implementation(libs.room.common)
    ksp(libs.room.compiler)
}