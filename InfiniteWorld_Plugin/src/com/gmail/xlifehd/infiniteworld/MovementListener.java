package com.gmail.xlifehd.infiniteworld;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MovementListener implements Listener {
	
	@EventHandler
	public void onPlayerMove (PlayerMoveEvent event) {
		FileConfiguration config = InfiniteWorld.getPlugin().getConfig();
		int boundary = config.getInt("Boundary");
		int offsetx = config.getInt("X-Offset");
		int offsetz = config.getInt("Z-Offset");
		int bufferzone = config.getInt("Bufferzone");
		
		Location loc = event.getTo();
		int x = (int) loc.getX() - offsetx;
		int z = (int) loc.getZ() - offsetz;
		
		//X-Coordinate Handler
		if ( x >= boundary ) { 
			loc.setX( -boundary + bufferzone + offsetx );
		} else if ( x <= -boundary ) { 
			loc.setX( boundary - bufferzone + offsetx ); 
		}
		
		//Y-Coordinate Handler
		if ( z >= boundary ) { 
			loc.setZ( -boundary + bufferzone + offsetz ); 
		} else if ( z <= -boundary ) { 
			loc.setZ( boundary - bufferzone + offsetz ); 
		}
	}
	 
}
