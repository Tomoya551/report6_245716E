/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    id("buildlogic.java-application-conventions")
}

dependencies {
    implementation("org.apache.commons:commons-text")
    implementation(project(":utilities"))
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

application {
    // Define the main class for the application.
    mainClass = "org.example.app.App"
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "Main"
    }
}