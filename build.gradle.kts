plugins {
    id("java-library")
    // Das run-paper Plugin bleibt gleich, da es auch Folia ausführen kann
    id("xyz.jpenilla.run-paper") version "3.1.0"
}

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    // GEÄNDERT: Nutze die folia-api anstelle der paper-api
    compileOnly("dev.folia:folia-api:26.2.build.+")
}

java {
    toolchain.languageVersion = JavaLanguageVersion.of(25)
}

tasks {
    runServer {
        // GEÄNDERT: Sagt dem Plugin, dass es Folia statt Paper herunterladen soll
        folia.serverJar()

        // Konfiguriere die Minecraft-Version
        minecraftVersion("26.2")
        jvmArgs("-Xms2G", "-Xmx2G")
    }

    processResources {
        val props = mapOf("version" to version)
        filesMatching("plugin.yml") {
            expand(props)
        }
    }
}
