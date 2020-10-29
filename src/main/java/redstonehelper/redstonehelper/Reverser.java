package redstonehelper.redstonehelper;

import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Directional;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import java.util.Arrays;
import static org.bukkit.block.BlockFace.*;

public class Reverser implements Listener {
    RedstoneHelper plugin;
    public Reverser(RedstoneHelper instance) {
        plugin = instance;
    }
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        String type = event.getBlock().getType().toString();
        Object[] types = plugin.getConfig().getStringList("reverse.types").toArray();
        if(Arrays.asList(types).contains(type)) {
            if (event.getPlayer().isSneaking()) {
                Directional direction = (Directional)event.getBlock().getBlockData();
                switch (direction.getFacing()) {
                    case NORTH:
                        direction.setFacing(BlockFace.SOUTH);
                        event.getBlock().setBlockData(direction.clone());
                        event.getBlock().getState().update();
                        break;
                    case WEST:
                        direction.setFacing(BlockFace.EAST);
                        event.getBlock().setBlockData(direction.clone());
                        event.getBlock().getState().update();
                        break;
                    case EAST:
                        direction.setFacing(BlockFace.WEST);
                        event.getBlock().setBlockData(direction.clone());
                        event.getBlock().getState().update();
                        break;
                    case SOUTH:
                        direction.setFacing(NORTH);
                        event.getBlock().setBlockData(direction.clone());
                        event.getBlock().getState().update();
                        break;
                    case UP:
                        direction.setFacing(DOWN);
                        event.getBlock().setBlockData(direction.clone());
                        event.getBlock().getState().update();
                        break;
                    case DOWN:
                        direction.setFacing(UP);
                        event.getBlock().setBlockData(direction.clone());
                        event.getBlock().getState().update();
                        break;
                }
            }
        }
    }
}
