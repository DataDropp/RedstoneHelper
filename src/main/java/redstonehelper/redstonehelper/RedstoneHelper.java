package redstonehelper.redstonehelper;

import dev.jorel.commandapi.CommandAPI;
import dev.jorel.commandapi.CommandAPICommand;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class RedstoneHelper extends JavaPlugin implements Listener, CommandExecutor {
    @Override
    public void onLoad(){
        CommandAPI.onLoad(true);
        new CommandAPICommand("redstonehelper")
                .withSubcommand(new CommandAPICommand("reload")
                        .withPermission("redstonehelper.reload")
                        .executes((sender, args) -> {
                            sender.sendMessage(ChatColor.GREEN + "Redstonehelper reloaded");
                            saveDefaultConfig();
                            reloadConfig();
                        }))
                .executes((sender,args) -> {
                    sender.sendMessage(ChatColor.GREEN + "Redstonehelper " + getDescription().getVersion() + ChatColor.RED + "\nAuthor: 1Gigabyte" + "\nGithub: https://github.com/1Gigabit/RedstoneHelper");
                })
                .register();
    }
    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        this.reloadConfig();
        if(this.getConfig().getBoolean("enabled")) {
            getServer().getPluginManager().registerEvents(this, this);
            CommandAPI.onEnable(this);
            Bukkit.getLogger().info("[RedstoneHelper] Hello bukkit! :)");
            if (this.getConfig().getBoolean("reverse.enabled")){
                getServer().getPluginManager().registerEvents(new flip(this), this);
            }
            if(this.getConfig().getBoolean("fillables.enabled")){
                getServer().getPluginManager().registerEvents(new fill(this),this);
            }
            if(this.getConfig().getBoolean("level.enabled")) {
                getServer().getPluginManager().registerEvents(new level(this),this);
            }
        }
    }
    @Override
    public void onDisable() {
    }
}
