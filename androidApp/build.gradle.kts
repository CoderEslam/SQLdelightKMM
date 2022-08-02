plugins {
    id("com.android.application")
    kotlin("android")
    id("com.squareup.sqldelight")
    id("kotlin-android-extensions")
}

android {
    compileSdk = 32
    defaultConfig {
        applicationId = "com.doubleclick.sqlightkmm.android"
        minSdk = 21
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.0")
    implementation("com.squareup.sqldelight:android-driver:1.5.3")
    implementation("com.squareup.sqldelight:coroutines-extensions-jvm:1.5.3")
}

sqldelight {

    database("PersonDatabase") {
        packageName = "com.doubleclick.databasekmm.android"
    }

}