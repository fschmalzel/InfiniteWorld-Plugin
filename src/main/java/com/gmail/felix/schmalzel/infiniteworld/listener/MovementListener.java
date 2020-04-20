package com.gmail.felix.schmalzel.infiniteworld.listener;

import com.gmail.felix.schmalzel.infiniteworld.BorderShape;
import com.gmail.felix.schmalzel.infiniteworld.InfiniteWorldConfig;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MovementListener implements Listener {

	private final InfiniteWorldConfig config;

	public MovementListener(InfiniteWorldConfig config) {
		this.config = config;
	}
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event) {
		int radius = config.getRadius();
		int xOffset = config.getxOffset();
		int zOffset = config.getzOffset();
		int padding = config.getPadding();
		BorderShape shape = config.getShape();
		Location loc = event.getTo();

		shape.checkAndTeleport(loc, radius, xOffset, zOffset, padding);
	}
}
