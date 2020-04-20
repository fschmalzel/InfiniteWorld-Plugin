package com.gmail.xlifehd.infiniteworld;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class InfiniteWorld extends JavaPlugin {
	
	private static InfiniteWorld instance;
	
	public static InfiniteWorld getPlugin() {
		return instance;
	}
	
	FileConfiguration config = getConfig();
	public static String pluginPrefix = ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + ChatColor.BOLD + "Infinite" + ChatColor.GREEN + "World" + ChatColor.RESET + ChatColor.DARK_GRAY + "] " + ChatColor.WHITE;
	
	@Override
	public void onEnable() {
		instance = this;
		//Configuration
		config.addDefault("CfgVersion", 1);
		config.addDefault("Radius", 100);
		config.addDefault("X-Offset", 0);
		config.addDefault("Z-Offset", 0);
		config.addDefault("Bufferzone", 5);
		config.addDefault("Shape", "square");
		config.options().header("Config for InfiniteWorld");
		config.options().copyDefaults(true);
		saveConfig();
		
		//Registering
		getServer().getPluginManager().registerEvents(new MovementListener(), this);
		this.getCommand("IWset").setExecutor(new CommandConfig());
	}
	
	@Override
	public void onDisable() {
		
	}
	
}
