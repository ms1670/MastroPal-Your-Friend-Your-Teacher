plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)

    alias(libs.plugins.google.gms.google.services)

    id ("org.jetbrains.kotlin.plugin.serialization") version "2.0.21"

}

android {
    namespace = "com.example.tutorapp1"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.tutorapp1"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // splash screen
    implementation(libs.androidx.core.splashscreen)
    //M3
    implementation(libs.material3)

    //firebase
    implementation(libs.firebase.database)
//    implementation("androidx.core:core-splashscreen:1.0.0")
//    implementation("androidx.compose.material3:material3:1.0.0")

    // compose Navigation
    implementation(libs.androidx.navigation.compose)

    // Core KTX
    implementation(libs.androidx.core.ktx)

    // Fragment + Dynamic Features
    implementation(libs.androidx.fragment.ktx)

    // Material Icons (Extended)
    implementation(libs.androidx.material.icons.extended)

    // Accompanist Pager
    implementation(libs.accompanist.pager)
    implementation(libs.accompanist.pager.indicators)

    // Kotlinx Serialization
    implementation(libs.kotlinx.serialization.json)

    // Testing
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.ui.test.junit4)
    debugImplementation(libs.ui.test.manifest)

}