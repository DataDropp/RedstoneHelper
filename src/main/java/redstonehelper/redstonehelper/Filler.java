package redstonehelper.redstonehelper;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.block.Block;
import org.bukkit.block.data.Levelled;
import org.bukkit.block.data.type.EndPortalFrame;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class Filler implements Listener {
    RedstoneHelper plugin;
    public Filler(RedstoneHelper instance) {
        plugin = instance;
    }
    @EventHandler
    public void onBlockClick(PlayerInteractEvent event) {
        if(!event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) return;
        if(!event.getHand().equals(EquipmentSlot.HAND)) return;
        if(!event.getPlayer().isSneaking()) return;

        if(event.getClickedBlock().getType().toString().equals("COMPOSTER")){
            event.setCancelled(true);
            Block block = event.getClickedBlock();
            Levelled level = (Levelled) block.getBlockData();
            if(level.getLevel() < 7){
                level.setLevel(level.getLevel()+1);
                event.getClickedBlock().setBlockData(level);
                event.getClickedBlock().getState().update();
            } else {
                level.setLevel(0);
                event.getClickedBlock().setBlockData(level);
                event.getClickedBlock().getState().update();
            }
            event.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§cComposter level: §a"+ level.getLevel()));
        } else if(event.getClickedBlock().getType().toString().equals("END_PORTAL_FRAME")){
            event.setCancelled(true);
            EndPortalFrame block = (EndPortalFrame) event.getClickedBlock().getBlockData();
            if(block.hasEye()) {
                block.setEye(false);
            } else {
                block.setEye(true);
            }
            event.getClickedBlock().setBlockData(block);
            event.getClickedBlock().getState().update();
            event.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§cEye: §a"+ block.hasEye()));
        }
    }
}