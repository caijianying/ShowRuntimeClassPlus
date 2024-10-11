pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}
//plugins {
//    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
//}

rootProject.name = "ShowRuntimeClassPlus"
include("plugin-core")
include("plugin-agent")
