package com.gmail.xlifehd.infiniteworld;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandConfig implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player ) {
			Player player = (Player) sender;
			Bukkit.broadcastMessage("Command: " + cmd + " | Label: " + label);
			Bukkit.broadcastMessage("Called by " + player.getDisplayName() + ".");
			InfiniteWorld.getPlugin().config.set("X-Offset", player.getLocation().getBlockX());
			InfiniteWorld.getPlugin().config.set("Z-Offset", player.getLocation().getBlockZ());
			InfiniteWorld.getPlugin().saveConfig();
			InfiniteWorld.getPlugin().config.options().copyDefaults(true);
		}
		return true;
	}
	
}