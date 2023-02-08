rootProject.name = "UpDependencies"

pluginManagement {
    repositories {
        gradlePluginPortal()
    }
}

include(":plugin-velocity")
project(":plugin-velocity").name = "UpDependencies-Velocity"
include(":plugin-bukkit")
project(":plugin-bukkit").name = "UpDependencies-Bukkit"
