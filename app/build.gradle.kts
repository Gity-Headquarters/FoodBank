plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")

    id("kotlin-parcelize")
}

android {
    namespace = "com.gity.foodbank"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.gity.foodbank"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    //    Retrofit
    val retrofitVersion = "2.9.0"
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")

    //    Okhttp
    val okhttpVersion = "4.11.0"
    implementation("com.squareup.okhttp3:logging-interceptor:$okhttpVersion")

    //    ViewModel
    val viewModelVersion = "2.6.2"
    val activityKtxVersion = "1.7.2"
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$viewModelVersion")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$viewModelVersion")
    implementation("androidx.activity:activity-ktx:$activityKtxVersion")

    //    Coroutine
    val coroutineVersion = "1.3.9"
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutineVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutineVersion")

    //    Glide
    val glideVersion = "4.16.0"
    implementation("com.github.bumptech.glide:glide:$glideVersion")

    //    Event Bus
    val eventBusVersion = "3.2.0"
    implementation("org.greenrobot:eventbus:$eventBusVersion")

    //    View Pager 2
    val viewPager2Version = "1.0.0"
    implementation("androidx.viewpager2:viewpager2:$viewPager2Version")

    //    Datastore
    val dataStoreVersion = "1.0.0"
    implementation("androidx.datastore:datastore-preferences:$dataStoreVersion")

    //    Chip Bottom Navigation
    val chipBottomNavigationVersion = "1.4.0"
    implementation("com.github.ismaeldivita:chip-navigation-bar:$chipBottomNavigationVersion")

    //    Lottie Animation
    val lottieVersion = "6.2.0"
    implementation("com.airbnb.android:lottie:$lottieVersion")


    //    Blurry Activity
    val blurryVersion = "4.0.0"
    implementation("jp.wasabeef:blurry:$blurryVersion")




    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}