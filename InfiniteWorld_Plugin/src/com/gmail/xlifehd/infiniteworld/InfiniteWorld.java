package com.gmail.xlifehd.infiniteworld;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class InfiniteWorld extends JavaPlugin {
	
	private static InfiniteWorld instance;
	
	public static InfiniteWorld getPlugin() {
		return instance;
	}
	
	FileConfiguration config = getConfig();
	
	@Override
	public void onEnable() {
		instance = this;
		config.addDefault("Boundary", 100);
		config.addDefault("X-Offset", 0);
		config.addDefault("Z-Offset", 0);
		config.addDefault("Bufferzone", 5);
		config.options().copyDefaults(true);
		saveConfig();
		getServer().getPluginManager().registerEvents(new MovementListener(), this);
		this.getCommand("IWset").setExecutor(new CommandConfig());
	}
	
	@Override
	public void onDisable() {
		
	}
	
}
