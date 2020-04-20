package com.gmail.felix.schmalzel.infiniteworld.command;

import com.gmail.felix.schmalzel.infiniteworld.BorderShape;
import com.gmail.felix.schmalzel.infiniteworld.InfiniteWorld;
import com.gmail.felix.schmalzel.infiniteworld.InfiniteWorldConfig;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class ConfigCommandExecutor implements CommandExecutor {

	private final InfiniteWorldConfig config;

	public ConfigCommandExecutor(InfiniteWorldConfig config) {
		this.config = config;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (sender instanceof Player && ( sender.hasPermission("IW.set") || sender.isOp() ) ) {
			Player player = (Player) sender;

			config.setxOffset(player.getLocation().getBlockX());
			config.setzOffset(player.getLocation().getBlockZ());
			
			if ( args.length >= 1 ) {
				if ( args[0].equalsIgnoreCase("help") ) {
					player.chat("/help iwset");
					return true;
				}

				// TODO exception handling
				BorderShape shape = BorderShape.valueOf((String) args[0]);

				config.setShape(shape);
			}
			
			if ( args.length >= 2 ) {
				config.setRadius(Integer.parseUnsignedInt(args[1]));
			}
			
			if ( args.length >= 3 ) {
				config.setPadding(Integer.parseUnsignedInt(args[2]));
			}

			config.save();
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