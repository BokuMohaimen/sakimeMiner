package sakime.sakimelove;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.slf4j.Logger;

import java.util.Random;

public final class Sakimelove extends JavaPlugin implements Listener {

    Random r = new Random();

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(this,this);
    }

    @Override
    public Logger getSLF4JLogger() {
        return null;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        if(e.getBlock().getType() == Material.STONE){
            if (r.nextInt(123) == 0){
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "minecraft:give " + e.getPlayer().getName() + " minecraft:player_head{SkullOwner:\"sakime123\"}");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mtitle &x&f&f&0&0&f&fさきめさんの頭当選！ " + e.getPlayer().getName() + " 1 5 1");
                e.getPlayer().sendMessage("§a§lさきめさんの頭を獲得！");
                e.getPlayer().spawnParticle(Particle.HEART,e.getPlayer().getLocation().getX()+0,e.getPlayer().getLocation().getY()+2,e.getPlayer().getLocation().getZ()+0,20); }
        }
    }
}
