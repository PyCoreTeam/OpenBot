plugins {
    kotlin("jvm") version "2.0.0"
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("java")
}
configurations.all {
    resolutionStrategy {
        // 强制升级 ASM 到 9.6（支持 Java 21）
        force("org.ow2.asm:asm:9.6")
        force("org.ow2.asm:asm-commons:9.6")
        force("org.ow2.asm:asm-tree:9.6")
    }
}

group = "cn.pycore"
version = "0.1.01-preview"

repositories {
    mavenCentral()
    maven("https://maven.aliyun.com/repository/public")
}

dependencies {
    implementation("org.apache.logging.log4j:log4j-core:2.24.3")
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:2.24.3")
    testImplementation(kotlin("test"))

}
tasks.shadowJar {
    archiveBaseName.set("OpenBot")
    archiveClassifier.set("")

    // META-INF
    manifest {
        attributes["Main-Class"] = "cn.pycore.openbot.OpenBotKt"
    }
    // Java 21 module
    exclude("module-info.class")
    mergeServiceFiles()

    minimize{
        exclude(dependency("org.apache.logging.log4j:.*:.*"))
    }
}
tasks.build {
    dependsOn(tasks.shadowJar)
}
tasks.test {
    useJUnitPlatform()
}


// Language settings
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

kotlin {
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_21)
        allWarningsAsErrors.set(true)
    }
}