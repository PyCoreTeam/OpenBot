plugins {
    kotlin("jvm") version "2.0.0"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "cn.pycore"
version = "0.1.01-preview"

repositories {
    mavenCentral()
    maven("https://maven.aliyun.com/repository/public")
}

dependencies {
    implementation("org.apache.logging.log4j:log4j-core:2.23.1")
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:2.23.1")
    testImplementation(kotlin("test"))

}
tasks.shadowJar {
    archiveBaseName.set("OpenBot")
    archiveClassifier.set("")
    archiveVersion.set(version)

    manifest {
        attributes["Main-Class"] = "cn.pycore.openbot.OpenBotKt"
    }
    minimize()
}
tasks.build {
    dependsOn(tasks.shadowJar)
}
tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}
