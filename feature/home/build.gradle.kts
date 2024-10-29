plugins {
    alias(libs.plugins.appname.android.feature)
    alias(libs.plugins.appname.android.library.compose)
}

android {
    namespace = "com.tasnimulhasan.home"
}

dependencies {
    implementation(libs.accompanist.permissions)
}