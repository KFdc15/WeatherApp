import com.android.sdklib.AndroidVersion.VersionCodes.LOLLIPOP
import com.android.sdklib.AndroidVersion.VersionCodes.VANILLA_ICE_CREAM

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation(libs.androidx.activity.compose)
}

android {
    namespace = "vn.ac.vju.mad.converter"
    compileSdk = VANILLA_ICE_CREAM
    defaultConfig {
        minSdk = LOLLIPOP
        targetSdk = VANILLA_ICE_CREAM
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}
