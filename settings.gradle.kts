pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        maven(url="https://jitpack.io")
        mavenCentral()
    }
}

rootProject.name = "SkeletonJetpackCompose"
include(":app")
 