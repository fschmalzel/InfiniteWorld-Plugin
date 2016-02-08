package com.gmail.xlifehd.infiniteworld;

import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new MovementListener(), this);
	}
	
	@Override
	public void onDisable() {
		
	}
	
}
