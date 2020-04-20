package com.gmail.felix.schmalzel.infiniteworld;

import com.gmail.felix.schmalzel.infiniteworld.command.ConfigCommandExecutor;
import com.gmail.felix.schmalzel.infiniteworld.listener.MovementListener;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class InfiniteWorld extends JavaPlugin {

	public static final String pluginPrefix = ChatColor.DARK_GRAY + "["
			+ ChatColor.AQUA + ChatColor.BOLD + "Infinite" + ChatColor.GREEN
			+ "World" + ChatColor.RESET + ChatColor.DARK_GRAY + "] "
			+ ChatColor.WHITE;
	
	@Override
	public void onEnable() {
		// Configuration
		InfiniteWorldConfig config = new InfiniteWorldConfig(this);

		//Registering
		getServer().getPluginManager().registerEvents(new MovementListener(config), this);
		this.getCommand("IWset").setExecutor(new ConfigCommandExecutor(config));
	}
	
	@Override
	public void onDisable() {
		
	}
	
}
