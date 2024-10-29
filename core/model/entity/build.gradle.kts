plugins {
    alias(libs.plugins.appname.android.library)
    alias(libs.plugins.appname.android.library.compose)
}

android {
    namespace = "com.tasnimulhasan.entity"
}

dependencies {
    implementation(libs.room.common)
    implementation(libs.gson)
}