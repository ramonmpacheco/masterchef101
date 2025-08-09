plugins {
    kotlin("jvm") version "1.9.25"
    kotlin("plugin.spring") version "1.9.25"
    id("org.springframework.boot") version "3.5.4"
    id("io.spring.dependency-management") version "1.1.7"
    kotlin("plugin.jpa") version "1.9.25"
}

group = "br.techtalk"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    // Spring
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")

    //Jackson
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    // Banco
    runtimeOnly("com.h2database:h2")

    // Test dependencies
    testImplementation(kotlin("test"))
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    // Cucumber dependencies - versão mais estável (Opção 1)
    testImplementation("io.cucumber:cucumber-java:7.15.0")
    testImplementation("io.cucumber:cucumber-junit-platform-engine:7.15.0")
    testImplementation("io.cucumber:cucumber-spring:7.15.0")
    
    // JUnit Platform dependencies - versões compatíveis
    testImplementation("org.junit.platform:junit-platform-suite:1.12.2")
    testImplementation("org.junit.platform:junit-platform-suite-api:1.12.2")
    testImplementation("org.junit.platform:junit-platform-suite-engine:1.12.2")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

allOpen {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.MappedSuperclass")
    annotation("jakarta.persistence.Embeddable")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
