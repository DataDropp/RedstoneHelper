package redstonehelper.redstonehelper;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
public final class RedstoneHelper extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("[RedstoneHelper] Hello bukkit! :)");
        getServer().getPluginManager().registerEvents(new Reverser(),this);
        getServer().getPluginManager().registerEvents(new Filler(),this);
        this.saveDefaultConfig();
    }
    @Override
    public void onDisable() {
    }
}
