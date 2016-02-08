package com.gmail.xlifehd.infiniteworld;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import com.gmail.xlifehd.infiniteworld.main;;

public class MovementListener implements Listener {
	
	@EventHandler
	public void onPlayerMove (PlayerMoveEvent event) {
		
		main Main = new main();
		int boundary = Main.config.getInt("Boundary");
		int offsetx = Main.config.getInt("X-Offset");
		int offsetz = Main.config.getInt("Z-Offset");
		int bufferzone = Main.config.getInt("Bufferzone");
		
		Location loc = event.getTo();
		int x = (int) loc.getX() - offsetx;
		int z = (int) loc.getZ() - offsetz;
		
		/*Debug
		 * 		 if ( Math.abs(x) >= boundary || Math.abs(z) >= boundary ) {
			Bukkit.broadcastMessage("X: " + x + " | Z: " + z);
		}
		 */
		
		//X-Coordinate Handler
		if ( x >= boundary ) { 
			loc.setX( -x + offsetx + bufferzone );
		} else if ( x <= -boundary ) { 
			loc.setX( -x + offsetx - bufferzone ); 
		}
		
		//Y-Coordinate Handler
		if ( z >= boundary ) { 
			loc.setZ( -z + offsetz + bufferzone ); 
		} else if ( z <= -boundary ) { 
			loc.setZ( -z + offsetz - bufferzone ); 
		}
	}
	 
}
