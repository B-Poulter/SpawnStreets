pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven("https://papermc.io")
    }
}

dependencyResolutionManagement {
    // GEÄNDERT: Erlaubt dem Projekt, eigene Repositories zu definieren
    repositoriesMode.set(RepositoriesMode.PREFER_PROJECT)
    repositories {
        mavenCentral()
        maven("https://papermc.io")
    }
}

rootProject.name = "SpawnStreets"
