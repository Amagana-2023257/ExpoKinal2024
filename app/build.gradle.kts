plugins {
    alias(libs.plugins.androidApplication)
    id("com.google.firebase.appdistribution")
    id("com.google.gms.google-services")
}

android {
    namespace = "org.amagana.System.Main"
    compileSdk = 34

    defaultConfig {
        applicationId = "org.amagana.System.Main"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.firebase.database)
    implementation(libs.firebase.firestore)
    implementation(libs.firebase.storage)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation ("com.google.zxing:core:3.3.3")
    implementation ("com.journeyapps:zxing-android-embedded:3.5.0")
    implementation ("com.squareup.picasso:picasso:2.71828")
}