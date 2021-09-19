plugins {
    id("com.android.library")
    kotlin("android")
    id("kotlin-kapt")
    `maven-publish`
}

android {

    compileSdk = ProjectSetting.PROJECT_COMPILE_SDK

    defaultConfig {
        minSdk = ProjectSetting.PROJECT_MIN_SDK
        targetSdk = ProjectSetting.PROJECT_TARGET_SDK

        multiDexEnabled = true
        vectorDrawables.useSupportLibrary = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        consumerProguardFile("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        viewBinding = true
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Dependency.compose_version
        kotlinCompilerVersion = Dependency.kotlin_version
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_11.toString()
            useIR = true
        }
    }

    packagingOptions {
        exclude("META-INF/AL2.0")
        exclude("META-INF/LGPL2.1")
    }

}

dependencies {

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Dependency.kotlin_version}")

    implementation("androidx.compose.ui:ui:${Dependency.compose_version}")
    implementation("androidx.compose.material:material:${Dependency.compose_version}")
    implementation("androidx.compose.ui:ui-tooling-preview:${Dependency.compose_version}")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
    implementation("androidx.activity:activity-compose:1.3.1")

    // google recycler-view
    implementation("androidx.recyclerview:recyclerview:1.2.1")

    // facebook shimmer
    implementation("com.facebook.shimmer:shimmer:0.5.0")

    // github lib circle-image-view
    implementation("de.hdodenhof:circleimageview:3.1.0")

    // library frogo-android-ui-kit
    implementation("com.github.frogobox:frogo-android-ui-kit:1.0.4")

    // library frogo-log
    implementation("com.github.amirisback:frogo-log:2.0.4")

    androidTestImplementation("androidx.compose.ui:ui-test-junit4:${Dependency.compose_version}")
    debugImplementation("androidx.compose.ui:ui-tooling:${Dependency.compose_version}")

}

afterEvaluate {
    publishing {
        publications {

            // Creates a Maven publication called "release".
            register("release", MavenPublication::class) {

                // Applies the component for the release build variant.
                // NOTE : Delete this line code if you publish Native Java / Kotlin Library
                from(components["release"])

                // Library Package Name (Example : "com.frogobox.androidfirstlib")
                // NOTE : Different GroupId For Each Library / Module, So That Each Library Is Not Overwritten
                groupId = ProjectSetting.PROJECT_LIB_ID

                // Library Name / Module Name (Example : "androidfirstlib")
                // NOTE : Different ArtifactId For Each Library / Module, So That Each Library Is Not Overwritten
                artifactId = ProjectSetting.NAME_APK

                // Version Library Name (Example : "1.0.0")
                version = ProjectSetting.PROJECT_VERSION_NAME

            }
        }
    }
}