# RedstoneHelper Spigot/Bukkit Plugin
Makes working with redstone less difficult.


# Usage
Hold shift & place a supported block that has a direction, and it'll flip the direction upon placement.


Hold shift & right click a composter or end portal frame to fill it. Will also show you if it is filled or how much level is in the composter on the player's action bar.



# Features
### Reverse direction
Allows players to reverse (flip) the direction a block when placed.
![](https://i.imgur.com/8ahGKFT.gif)

Supported blocks:
* Piston
* Sticky piston
* Repeater
* Redstone torch (walls)
* Dropper
* Dispenser
* Comparator
* Observer

Adding your own supported blocks is easy. Just go into config.yml and add the block.

Refer to [this](https://hub.spigotmc.org/javadocs/bukkit/org/bukkit/Material.html) for correct block names.
### Filler
Allows players to shift + right click these blocks to change their "fullness"
![](https://i.imgur.com/FpcGduH.gif)
Supported blocks are:
* Composter
* End portal frame

### Other features
* Allows players to shift + right click a redstone wire then it'll output the power level to the action bar.
![](https://s8.gifyu.com/images/Peek-2020-11-02-08-56.gif)

### Commands & permissions
| Command | Permission | Description |
| :---: | :---: | :---: |
| /redstonehelp | none | Shows information about the plugin |
| /redstonehelp reload | redstonehelp.reload | Reloads the plugin configuration |
### Default configuration
```yaml
# RedstoneHelper v1.4
# Enable or disable the functions of the plugin
enabled: true
reverse:
  # Enable or disable ALL reversals.
  enabled: true
  #You can add your own types here.
  #Refer to https://hub.spigotmc.org/javadocs/bukkit/org/bukkit/Material.html for the correct block names
    types:
    - "PISTON"
    - "STICKY_PISTON"
    - "REPEATER"
    - "REDSTONE_WALL_TORCH"
    - "DROPPER"
    - "DISPENSER"
    - "COMPARATOR"
    - "OBSERVER"
fillables:
  #Enable or disable the fill function of this plugin
  enabled: true
  types:
    # Enable or disable the supported blocks
    # Do not add your own here, will not do anything.
    COMPOSTER:
      enabled: true
    END_PORTAL_FRAME:
      enabled: true
level:
  # Enable or disable fetching the level of a redstone wire
  enabled: true
  types:
    # Do not add your own here, will not do anything.
    REDSTONE_WIRE:
      enabled: true
```
# Tested versions
* 1.16.3

# Contributing
You may pull request if you feel you can contribute to the plugin's development.

### Todo
* Filling support for furnaces.
