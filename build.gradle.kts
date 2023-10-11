import net.minecrell.pluginyml.paper.PaperPluginDescription

plugins {
    id("cc.mewcraft.repo-conventions")
    id("cc.mewcraft.java-conventions")
    id("cc.mewcraft.deploy-conventions")
    alias(libs.plugins.pluginyml.paper)
}

project.ext.set("name", "MMOExt")

group = "co.mcsky.mmoext.RPGBridgePlugin"
version = "2.8.0"
description = "An extension of the RPG plugins on our server"

dependencies {
    // server
    compileOnly(libs.server.paper)

    // helper
    compileOnly(libs.helper)

    // standalone plugins
    compileOnly(libs.itemsadder)
    compileOnly(libs.mythicmobs)
    compileOnly(libs.towny)

    // internal
    implementation(project(":spatula:bukkit:message"))
    implementation(project(":spatula:bukkit:utils"))
}

paper {
    main = "co.mcsky.mmoext.RPGBridge"
    name = project.ext.get("name") as String
    version = "${project.version}"
    description = project.description
    apiVersion = "1.19"
    authors = listOf("Nailm")
    serverDependencies {
        register("helper") {
            required = true
            load = PaperPluginDescription.RelativeLoadOrder.BEFORE
        }
        register("Towny") {
            required = false
            load = PaperPluginDescription.RelativeLoadOrder.BEFORE
        }
        register("MythicMobs") {
            required = false
            load = PaperPluginDescription.RelativeLoadOrder.BEFORE
        }
        register("ItemsAdder") {
            required = false
            load = PaperPluginDescription.RelativeLoadOrder.BEFORE
        }
    }
}
