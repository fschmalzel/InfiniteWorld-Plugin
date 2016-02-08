package com.gmail.xlifehd.infiniteworld;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MovementListener implements Listener {
	
	 @EventHandler
	 public void onPlayerMove(PlayerMoveEvent event) {
		 
		 Location loc = event.getTo();
		 int boundary = 100;
		 int offsetx = 0;
		 int offsetz = 0;
		 int safezone = 5;
		 int x = (int) loc.getX() - offsetx;
		 int z = (int) loc.getZ() - offsetz;
		 
		 /*Debug
		 if ( Math.abs(x) >= boundary || Math.abs(z) >= boundary ) {
			 Bukkit.broadcastMessage("X: " + x + " | Z: " + z);
		 }
		 */
		 
		 //X-Coordinate Handler
		 if ( x >= boundary ) { 
			 loc.setX( -x + offsetx + safezone );
		 } else if ( x <= -boundary ) { 
			 loc.setX( -x + offsetx - safezone ); 
		 }
		 
		 //Y-Coordinate Handler
		 if ( z >= boundary ) { 
			 loc.setZ( -z + offsetz + safezone ); 
		 } else if ( z <= -boundary ) { 
			 loc.setZ( -z + offsetz - safezone ); 
		 }
		 

	 }
	 
}
