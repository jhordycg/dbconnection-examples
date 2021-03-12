import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.4.3" apply false
    id("io.spring.dependency-management") version "1.0.11.RELEASE" apply false
    kotlin("plugin.spring") version "1.4.30" apply false
    kotlin("jvm") version "1.4.30"
}

allprojects {
    repositories{
        mavenCentral()
    }
}

subprojects {

    apply {
        plugin("org.jetbrains.kotlin.jvm")
        plugin("org.jetbrains.kotlin.plugin.spring")
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")
        from(file("${rootProject.rootDir}/gradle/heroku/stage.gradle.kts"))
    }

    group = "dev.jhordycg.examples${rootProject.name}"
    java.sourceCompatibility = JavaVersion.VERSION_11
    buildDir = rootProject.buildDir

    dependencies {
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

        // https://mvnrepository.com/artifact/com.oracle.database.jdbc/ucp
        implementation("com.oracle.database.jdbc:ucp:19.10.0.0")
        // https://mvnrepository.com/artifact/com.oracle.database.security/osdt_cert
        implementation("com.oracle.database.security:osdt_cert:19.10.0.0")
        // https://mvnrepository.com/artifact/com.oracle.database.security/osdt_core
        implementation("com.oracle.database.security:osdt_core:19.10.0.0")
        // https://mvnrepository.com/artifact/com.oracle.database.security/oraclepki
        implementation("com.oracle.database.security:oraclepki:19.10.0.0")

        // https://mvnrepository.com/artifact/com.oracle.database.jdbc/ojdbc10
        runtimeOnly("com.oracle.database.jdbc", "ojdbc10", "19.10.0.0")
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "11"
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}
