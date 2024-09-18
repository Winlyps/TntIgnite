package winlyps.tntIgnite

import org.bukkit.plugin.java.JavaPlugin

class TntIgnite : JavaPlugin() {

    override fun onEnable() {
        // Register the event listener
        server.pluginManager.registerEvents(TntPlaceListener(this), this)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}