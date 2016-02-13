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
		String shape = config.getString("Shape");
		Location loc = event.getTo();
		
		if ( shape.equalsIgnoreCase("circle") ) {
			circleBorder(loc, boundary, offsetx, offsetz, bufferzone);
		} else if ( shape.equalsIgnoreCase("square") ) {
			squareBorder(loc, boundary, offsetx, offsetz, bufferzone);
		}
		
	}
	
	private void circleBorder(Location loc, int boundary, int offsetx, int offsetz, int bufferzone) {
		double x = loc.getX() - offsetx;
		double z = loc.getZ() - offsetz;
		if ( Math.sqrt( x*x + z*z ) >= boundary ) {
			loc.setX( Math.cos( Math.atan2(z, x) ) * - ( boundary - bufferzone ) );
			loc.setZ( Math.sin( Math.atan2(z, x) ) * - ( boundary - bufferzone ) ); 
		}
	}
	
	private void squareBorder(Location loc, int boundary, int offsetx, int offsetz, int bufferzone) {
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
