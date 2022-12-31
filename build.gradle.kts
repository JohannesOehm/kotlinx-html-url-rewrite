import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.20"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("io.ktor:ktor-server-netty-jvm:2.2.1")
    implementation("io.ktor:ktor-server-html-builder-jvm:2.2.1")
    implementation("io.ktor:ktor-server-core-jvm:2.2.1")
    implementation("io.ktor:ktor-client-cio-jvm:2.2.1")
    implementation("org.jetbrains.kotlinx:kotlinx-html-jvm:0.8.0")

}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}