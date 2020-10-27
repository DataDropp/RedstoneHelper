package redstonehelper.redstonehelper;

import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Directional;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import java.util.Arrays;
import static org.bukkit.block.BlockFace.*;

public class Reverser implements Listener {
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        String type = event.getBlock().getType().toString();
        String[] types = {"PISTON","STICKY_PISTON","REPEATER","REDSTONE_WALL_TORCH","DROPPER","DISPENSER","COMPARATOR","OBSERVER","CHEST","ENDER_CHEST","LEVER","FURNACE","TRAPPED_CHEST"};
        if(Arrays.stream(types).anyMatch(type::equals)) {
            if (event.getPlayer().isSneaking()) {
                Directional direction = (Directional)event.getBlock().getBlockData();
                switch (direction.getFacing()){
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
