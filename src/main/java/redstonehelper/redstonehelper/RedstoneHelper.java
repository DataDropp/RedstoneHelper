package redstonehelper.redstonehelper;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
public final class RedstoneHelper extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new Reverser(),this);
        getServer().getPluginManager().registerEvents(new Filler(),this);
        Bukkit.getLogger().info("Hello bukkit! :)");
    }
    @Override
    public void onDisable() {
    }
}
