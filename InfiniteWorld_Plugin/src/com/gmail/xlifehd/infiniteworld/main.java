package com.gmail.xlifehd.infiniteworld;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
	
	public FileConfiguration config = getConfig();
	
	@Override
	public void onEnable() {
		
		//Config
		config.addDefault("Boundary", 100);
		config.addDefault("X-Offset", 0);
		config.addDefault("Z-Offset", 0);
		config.addDefault("Bufferzone", 5);
		config.options().copyDefaults(true);
		saveConfig();
		
		getServer().getPluginManager().registerEvents(new MovementListener(), this);
		
	}
	
	@Override
	public void onDisable() {
		
	}
	
}
