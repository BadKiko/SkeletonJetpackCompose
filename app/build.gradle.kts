@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    kotlin("kapt")
    id("com.google.dagger.hilt.android") version "2.46" apply true
    id("com.google.devtools.ksp") version "1.8.10-1.0.9"
}

android {
    namespace = "com.pogachacha.educationgames"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.pogachacha.educationgames"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    kapt {
        correctErrorTypes = true
    }
}

dependencies {
    implementation(libs.destinationCore)
    ksp(libs.destinationKsp)

    // DI
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)
    implementation(libs.androidx.hilt.navigation.compose)


    implementation(libs.core.ktx)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.activity.compose)
    implementation(platform(libs.compose.bom))
    implementation(libs.ui)
    implementation(libs.ui.graphics)
    implementation(libs.ui.tooling.preview)
    implementation(libs.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.ui.test.junit4)
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)
}




/*

dependencies {
    //DI
    implementation "com.google.dagger:hilt-android:2.46"
    kapt "com.google.dagger:hilt-android-compiler:2.46"
    implementation "androidx.hilt:hilt-navigation-compose:1.1.0-alpha01"
    implementation("com.squareup:javapoet:1.13.0")

    //NAVIGATION
    implementation("io.github.raamcosta.compose-destinations:core:1.9.42-beta")
    ksp("io.github.raamcosta.compose-destinations:ksp:1.9.42-beta")

    //COMPOSE & TEST
    implementation 'androidx.compose.material3:material3:1.0.1'
    implementation 'androidx.core:core-ktx:1.10.0'
    implementation 'androidx.compose.ui:ui:1.4.2'
    implementation 'androidx.compose.ui:ui-tooling-preview:1.5.0-alpha03'
    implementation 'androidx.lifecycle:lifecycle-runtime-ktx:2.6.1'
    implementation 'androidx.activity:activity-compose:1.7.1'
    testImplementation 'junit:junit:4.13.2'
    testImplementation 'org.junit.jupiter:junit-jupiter:5.9.3'
    androidTestImplementation 'androidx.test.ext:junit:1.1.5'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'
    androidTestImplementation 'androidx.compose.ui:ui-test-junit4:1.4.2'
    debugImplementation 'androidx.compose.ui:ui-tooling:1.4.2'
}*/
