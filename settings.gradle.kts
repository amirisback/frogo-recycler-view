pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven("https://jitpack.io")
        maven {
            url = uri("https://maven.pkg.github.com/frogobox/kick-start-library")
        }
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
        maven {
            url = uri("https://maven.pkg.github.com/frogobox/kick-start-library")
        }
    }
}

rootProject.name = "FrogoRecyclerView"
include(":app", ":frogorecyclerview")