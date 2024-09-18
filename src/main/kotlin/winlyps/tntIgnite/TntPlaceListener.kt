package winlyps.tntIgnite

import org.bukkit.Material
import org.bukkit.block.Block
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockPlaceEvent
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitRunnable

class TntPlaceListener(private val plugin: JavaPlugin) : Listener {

    @EventHandler
    fun onBlockPlace(event: BlockPlaceEvent) {
        val block = event.block
        if (block.type == Material.TNT) {
            // Ignite the TNT block
            igniteTnt(block)
        }
    }

    private fun igniteTnt(block: Block) {
        // Schedule the TNT to explode after the default delay (40 ticks or 2 seconds)
        object : BukkitRunnable() {
            override fun run() {
                block.type = Material.AIR // Remove the TNT block
                block.world.createExplosion(block.location, 4.0F, false, true) // Create an explosion
            }
        }.runTaskLater(plugin, 40L) // 40 ticks (2 seconds) delay
    }
}