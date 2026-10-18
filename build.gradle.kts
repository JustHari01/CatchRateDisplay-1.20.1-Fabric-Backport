plugins {
    id("architectury-plugin") version "3.4-SNAPSHOT"
    id("dev.architectury.loom") version "1.9.424" apply false
    kotlin("jvm") version "2.0.21" apply false
    java
}

val minecraftVersion = findProperty("minecraft_version")?.toString() ?: "1.21.1"
val mavenGroup = findProperty("maven_group")?.toString() ?: "com.catchrate"
val modVersion = findProperty("mod_version")?.toString() ?: "1.2.33"

architectury {
    minecraft = minecraftVersion
}

allprojects {
    group = mavenGroup
    version = modVersion
}

subprojects {
    apply(plugin = "architectury-plugin")
    apply(plugin = "dev.architectury.loom")
    apply(plugin = "org.jetbrains.kotlin.jvm")

    val loom = extensions.getByName<net.fabricmc.loom.api.LoomGradleExtensionAPI>("loom")

    val minecraftVersion = findProperty("minecraft_version")?.toString() ?: "1.20.1"
    val parchmentVersion = findProperty("parchment_version")?.toString() ?: "2024.07.28"

    repositories {
        mavenCentral()
        maven("https://maven.architectury.dev/")
        maven("https://maven.fabricmc.net/")
        maven("https://maven.neoforged.net/releases/")
        maven("https://maven.impactdev.net/repository/development/")
        maven("https://oss.sonatype.org/content/repositories/snapshots")
    }

    @Suppress("UnstableApiUsage")
    dependencies {
        "minecraft"("com.mojang:minecraft:$minecraftVersion")
        "mappings"(loom.layered {
            officialMojangMappings()
            parchment("org.parchmentmc.data:parchment-$minecraftVersion:$parchmentVersion")
        })
    }

    tasks.withType<JavaCompile> {
        options.release.set(17)
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
        }
    }

    java {
        withSourcesJar()
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
