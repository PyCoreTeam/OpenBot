pluginManagement {
    repositories {
        maven("https://maven.aliyun.com/repository/public")
        maven("https://maven.aliyun.com/repository/gradle-plugin")
        gradlePluginPortal()
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

buildCache {
    local {
        directory = File(rootDir, "./gradle/build-cache")
        removeUnusedEntriesAfterDays = 7
    }
}
rootProject.name = "OpenBot"

