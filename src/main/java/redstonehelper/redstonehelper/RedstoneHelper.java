package redstonehelper.redstonehelper;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
public final class RedstoneHelper extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        this.reloadConfig();
        if(this.getConfig().getBoolean("enabled")) {
            Bukkit.getLogger().info("[RedstoneHelper] Hello bukkit! :)");
            if (this.getConfig().getBoolean("reverse.enabled")){
                getServer().getPluginManager().registerEvents(new Reverser(this), this);
            }
            if(this.getConfig().getBoolean("fillables.enabled")){
                getServer().getPluginManager().registerEvents(new Filler(this),this);
            }
            if(this.getConfig().getBoolean("level.enabled")) {
                getServer().getPluginManager().registerEvents(new FetchInfo(this),this);
            }
        }
    }
    @Override
    public void onDisable() {
    }
}
