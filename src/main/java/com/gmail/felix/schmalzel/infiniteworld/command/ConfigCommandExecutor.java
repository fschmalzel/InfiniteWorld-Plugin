package com.gmail.felix.schmalzel.infiniteworld;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class CommandConfig implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (sender instanceof Player && ( sender.hasPermission("IW.set") || sender.isOp() ) ) {
			FileConfiguration config = InfiniteWorld.getPlugin().getConfig();
			Player player = (Player) sender;
			
			config.set("X-Offset", player.getLocation().getBlockX());
			config.set("Z-Offset", player.getLocation().getBlockZ());
			
			if ( args.length >= 1 ) {
				if ( args[0].equalsIgnoreCase("help") ) {
					player.chat("/help iwset");
					return true;
				}
				config.set("Shape", (String) args[0]);
			}
			
			if ( args.length >= 2 ) {
				config.set("Radius", Integer.parseUnsignedInt(args[1]));
			}
			
			if ( args.length >= 3 ) {
				config.set("Bufferzone", Integer.parseUnsignedInt(args[2]));
			}
			
			config.options().copyDefaults(true);
			InfiniteWorld.getPlugin().saveConfig();
			sender.sendMessage(InfiniteWorld.pluginPrefix + "Config updated!");
			
			return true;
		} else if ( sender instanceof Player ){
			sender.sendMessage(InfiniteWorld.pluginPrefix + "Not enough permissions.");
			return true;
		} else {
			sender.sendMessage(InfiniteWorld.pluginPrefix + "You have to be player.");
			return true;
		}
		
	}
	
}