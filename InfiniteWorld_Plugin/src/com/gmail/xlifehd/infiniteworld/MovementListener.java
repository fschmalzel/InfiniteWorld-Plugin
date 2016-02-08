package com.gmail.xlifehd.infiniteworld;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MovementListener implements Listener {
	
	@EventHandler
	public void onPlayerMove (PlayerMoveEvent event) {
		
		//Loading Config
		FileConfiguration config = InfiniteWorld.getPlugin().config;
		int boundary = config.getInt("Boundary");
		int offsetx = config.getInt("X-Offset");
		int offsetz = config.getInt("Z-Offset");
		int bufferzone = config.getInt("Bufferzone");
		
		//Getting current Location
		Location loc = event.getTo();
		int x = loc.getBlockX() - offsetx;
		int z = loc.getBlockZ() - offsetz;
		
		//X-Coordinate Handler
		if ( x >= boundary ) { 
			loc.setX( -boundary + bufferzone + offsetx );
		} else if ( x <= -boundary ) { 
			loc.setX( boundary - bufferzone + offsetx ); 
		}
		
		//Z-Coordinate Handler
		if ( z >= boundary ) { 
			loc.setZ( -boundary + bufferzone + offsetz ); 
		} else if ( z <= -boundary ) { 
			loc.setZ( boundary - bufferzone + offsetz ); 
		}
	}
	 
}
