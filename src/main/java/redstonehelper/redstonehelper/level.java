package redstonehelper.redstonehelper;


import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.block.data.AnaloguePowerable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class level implements Listener {
    RedstoneHelper plugin;
    public level(RedstoneHelper instance) {
        plugin = instance;
    }
    @EventHandler
    public void onClick(PlayerInteractEvent event) {
        if (!event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) return;
        if (!event.getHand().equals(EquipmentSlot.HAND)) return;
        if (!event.getPlayer().isSneaking()) return;
        if (plugin.getConfig().getBoolean("level.types.REDSTONE_WIRE.enabled") && event.getClickedBlock().getType().toString().equals("REDSTONE_WIRE")) {
            AnaloguePowerable power = (AnaloguePowerable) event.getClickedBlock().getBlockData();
            event.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§cPower: §a" + power.getPower()));
        }
    }
}