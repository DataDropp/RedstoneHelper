package redstonehelper.redstonehelper;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Directional;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import static org.bukkit.block.BlockFace.*;

public class Reverser implements Listener {
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        String type = event.getBlock().getType().toString();
        if(type.equals("PISTON") || type.equals("STICKY_PISTON") || type.equals("REPEATER") || type.equals("REDSTONE_WALL_TORCH") || type.equals("DROPPER") || type.equals("DISPENSER") || type.equals("COMPARATOR") || type.equals("OBSERVER")) {
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
