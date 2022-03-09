plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.compose") version Dependency.COMPOSE_MULTIPLATFORM_VERSION
    id("kotlin-kapt")
}

android {

    compileSdk = ProjectSetting.PROJECT_COMPILE_SDK

    defaultConfig {
        applicationId = ProjectSetting.PROJECT_APP_ID
        minSdk = ProjectSetting.PROJECT_MIN_SDK
        targetSdk = ProjectSetting.PROJECT_TARGET_SDK
        versionCode = ProjectSetting.PROJECT_VERSION_CODE
        versionName = ProjectSetting.PROJECT_VERSION_NAME

        multiDexEnabled = true
        vectorDrawables.useSupportLibrary = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        // Naming APK // AAB
        setProperty("archivesBaseName", "${ProjectSetting.NAME_APK}(${versionName})")

    }

    signingConfigs {
        create("release") {
            // You need to specify either an absolute path or include the
            // keystore file in the same directory as the build.gradle file.
            // [PROJECT FOLDER NAME/app/[COPY YOUT KEY STORE] .jks in here
            storeFile = file(ProjectSetting.PLAYSTORE_STORE_FILE)
            storePassword = ProjectSetting.PLAYSTORE_STORE_PASSWORD
            keyAlias = ProjectSetting.PLAYSTORE_KEY_ALIAS
            keyPassword = ProjectSetting.PLAYSTORE_KEY_PASSWORD
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false

            // Generated Signed APK / AAB
            signingConfig = signingConfigs.getByName("release")

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

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_11.toString()
        }
    }

}

dependencies {

    implementation(project(":frogorecyclerview"))

    implementation(compose.ui)
    implementation(compose.runtime)
    implementation(compose.preview)
    implementation(compose.uiTooling)
    implementation(compose.material)
    implementation(compose.materialIconsExtended)

    implementation(Androidx.appCompat)
    implementation(Androidx.constraintLayout)
    implementation(Androidx.Core.ktx)
    implementation(Androidx.Work.runtime)
    implementation(Androidx.Work.runtimeKtx)
    implementation(Androidx.Lifecycle.runtimeKtx)

    implementation(Compose.activity)

    implementation(Google.material)

    implementation(Util.glide)

    implementation("com.github.frogobox:frogo-ui:0.0.1-beta04")
    implementation("com.github.frogobox:frogo-consume-api:2.0.1")
    implementation("com.github.amirisback:frogo-log:2.0.9")

    kapt(Util.glideCompiler)

    debugImplementation(compose.ui)
    debugImplementation(compose.uiTooling)

}
