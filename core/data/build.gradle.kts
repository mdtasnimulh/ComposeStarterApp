plugins {
    alias(libs.plugins.appname.android.library)
    alias(libs.plugins.appname.android.library.compose)
    alias(libs.plugins.appname.android.hilt)
    id("kotlinx-serialization")
}

android {
    namespace = "com.tasnimulhasan.data"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.core.di)
    implementation(projects.core.database)
    implementation(projects.core.common)
    implementation(projects.core.model.entity)
    implementation(projects.core.model.apiResponse)
    implementation(projects.core.notifications)

    implementation(libs.kotlin.coroutines)
    testImplementation(libs.kotlinx.serialization.json)
}