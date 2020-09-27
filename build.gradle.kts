// Semantic build-versioning system for Gradle
// https://github.com/alcideio/gradle-semantic-build-versioning#introduction

buildscript {
    repositories {
        jcenter()
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }
    dependencies {
        classpath ("com.netflix.nebula:nebula-publishing-plugin:9.5.4")
    }
}

apply {
    plugin("nebula.maven-publish")
    plugin("nebula.javadoc-jar")
    plugin("nebula.source-jar")
}

plugins {
    java
    application
    id("nebula.release") version "15.2.0"
}

group = "com.elemency"
//version = "1.0-SNAPSHOT"

var javaVersion = JavaVersion.VERSION_1_8

java {
    sourceCompatibility = javaVersion
    targetCompatibility = javaVersion
//    withJavadocJar()
}

repositories {
    // Use jcenter for resolving dependencies.
    // You can declare any Maven/Ivy/file repository here.
    jcenter()

    maven {
        url = uri("https://oss.sonatype.org/content/groups/public")
    }
}

dependencies {
    implementation("junit:junit:4.12")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.3.1")
}

application {
    // Define the main class for the application.
    mainClassName = "com.elemency.NebulaTester.App"
}
