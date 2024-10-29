plugins {
    alias(libs.plugins.appname.android.library)
    alias(libs.plugins.appname.android.hilt)
}

android {
    namespace = "com.tasnimulhasan.notifications"
}

dependencies {
    //api(projects.core.model)

    implementation(projects.core.common)

    compileOnly(platform(libs.androidx.compose.bom))
    compileOnly(libs.androidx.compose.runtime)
}