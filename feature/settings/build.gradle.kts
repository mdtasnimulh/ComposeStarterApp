plugins {
    alias(libs.plugins.appname.android.feature)
    alias(libs.plugins.appname.android.library.compose)
}

android {
    namespace = "com.tasnimulhasan.settings"
}

dependencies {
    implementation(libs.accompanist.permissions)
}