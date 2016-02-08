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
		int boundary = config.getInt("Radius");
		int offsetx = config.getInt("X-Offset");
		int offsetz = config.getInt("Z-Offset");
		int bufferzone = config.getInt("Bufferzone");
		String type = config.getString("Type");
		Location loc = event.getTo();
		if (type == "circle") {
			circleBorder(loc, boundary, offsetx, offsetz, bufferzone);
		} else {
			rectangleBorder(loc, boundary, offsetx, offsetz, bufferzone);
		}
	}
	
	private void circleBorder(Location loc, int boundary, int offsetx, int offsetz, int bufferzone) {
		int x = loc.getBlockX() - offsetx;
		int z = loc.getBlockZ() - offsetz;
		if ( Math.sqrt( x^2 + z^2 ) >= boundary ) {
			
			if ( x >= 0 ) { 
				loc.setX( -x + bufferzone + offsetx );
			} else if ( x <= 0 ) { 
				loc.setX( -x - bufferzone + offsetx ); 
			}
			
			if ( z >= 0 ) { 
				loc.setZ( -z + bufferzone + offsetz ); 
			} else if ( z <= 0 ) { 
				loc.setZ( z - bufferzone + offsetz ); 
			}
			
		}
	}
	
	private void rectangleBorder(Location loc, int boundary, int offsetx, int offsetz, int bufferzone) {
		//Getting current Location
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
