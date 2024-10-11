plugins {
    id("java")
    id("distribution")
    id("org.jetbrains.intellij.platform") version "2.1.0"
}

apply(from = "config.gradle")

group = "com.xiaobaicai.plugin"
// 242.23339.11
version "${rootProject.version}"

repositories {
    mavenCentral()
    intellijPlatform {
        defaultRepositories()
    }
}


dependencies {
//    implementation(project(":plugin-core"))
    implementation("cn.hutool:hutool-all:5.8.5")
    annotationProcessor("org.projectlombok:lombok:1.18.2")
    compileOnly("org.projectlombok:lombok:1.18.2")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.2")
    testCompileOnly("org.projectlombok:lombok:1.18.2")
    // 单测
    testCompileOnly("junit:junit:4.12")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.8.2")

    intellijPlatform {
        intellijIdeaCommunity("2024.2.3")
        pluginVerifier()
        zipSigner()
        instrumentationTools()
    }
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

intellijPlatform {
    pluginConfiguration {
        ideaVersion {
            sinceBuild = "223"
            untilBuild = "243.*"
        }
    }
}