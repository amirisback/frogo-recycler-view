import org.gradle.kotlin.dsl.`kotlin-dsl`

repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
}

plugins {
    `kotlin-dsl`
}

dependencies{
    // library frogo-build-src
    implementation("com.github.frogobox:open-build-src:1.0.1")
}