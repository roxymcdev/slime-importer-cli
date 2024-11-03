import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "2.0.20"
    id("com.gradleup.shadow") version "8.3.5"
}

repositories {
    mavenCentral()
    maven("https://repo.roxymc.net/releases")
    maven("https://repo.roxymc.net/snapshots")
}

dependencies {
    implementation("net.roxymc.slimeloader:importer-anvil:1.0-SNAPSHOT")
    implementation("com.github.ajalt.clikt:clikt:5.0.1")
}

kotlin {
    jvmToolchain(17)
}

tasks {
    withType<KotlinCompile> {
        dependsOn(clean)
    }

    withType<Jar> {
        manifest {
            attributes["Main-Class"] = "net.roxymc.slime.importer.cli.MainKt"
        }

        archiveClassifier = null
    }
}
