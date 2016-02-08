package com.gmail.xlifehd.infiniteworld;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class CommandConfig implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (sender instanceof Player ) {
			
			FileConfiguration config = InfiniteWorld.getPlugin().config;
			Player player = (Player) sender;

			config.set("X-Offset", player.getLocation().getBlockX());
			config.set("Z-Offset", player.getLocation().getBlockZ());
			
			if ( args.length >= 1 ) {
				config.set("Type", args[0]);
			}
			
			if ( args.length >= 2 ) {
				config.set("Radius", Integer.parseUnsignedInt(args[1]));
			}
			
			if ( args.length >= 3 ) {
				config.set("Bufferzone", Integer.parseUnsignedInt(args[2]));
			}
			
			config.options().copyDefaults(true);
			InfiniteWorld.getPlugin().saveConfig();
			player.chat("[InfiniteWorld] Config updated!");
			
			return true;
			
		} else return false;
		
	}
	
}