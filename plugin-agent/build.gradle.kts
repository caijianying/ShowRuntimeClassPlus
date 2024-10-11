import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    kotlin("jvm") version "1.9.23"
    id("java")
    id("com.github.johnrengelman.shadow") version("8.1.1")
}



group = "com.xiaobaicai.plugin"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}

tasks.withType<ShadowJar> {
    manifest {
        attributes(
            "Manifest-Version" to "1.0",
            "Premain-Class" to "com.xiaobaicai.plugin.agent.PluginAgent",
            "Agent-Class" to "com.xiaobaicai.plugin.agent.PluginAgent",
            "Can-Redefine-Classes" to true,
            "Can-Retransform-Classes" to true
        )
    }
}

tasks.register("prepareKotlinBuildScriptModel") {
    // No specific action required
}