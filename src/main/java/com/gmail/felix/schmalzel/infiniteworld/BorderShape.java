package com.gmail.felix.schmalzel.infiniteworld;

import org.bukkit.Location;

public enum BorderShape {
    CIRCLE {
        @Override
        public void checkAndTeleport(Location location, int radius, int xOffset, int zOffset, int padding) {
            double x = location.getX() - xOffset;
            double z = location.getZ() - zOffset;
            if (Math.sqrt(x * x + z * z) >= radius) {
                location.setX(Math.cos(Math.atan2(z, x)) * - (radius - padding));
                location.setZ(Math.sin(Math.atan2(z, x)) * - (radius - padding));
            }
        }
    },
    SQUARE {
        @Override
        public void checkAndTeleport(Location location, int radius, int xOffset, int zOffset, int padding) {
            //Getting current Location
            int x = location.getBlockX() - xOffset;
            int z = location.getBlockZ() - zOffset;

            //X-Coordinate Handler
            if (x >= radius) {
                location.setX(-radius + padding + xOffset);
            } else if (x <= -radius) {
                location.setX(radius - padding + xOffset);
            }

            //Z-Coordinate Handler
            if (z >= radius) {
                location.setZ(-radius + padding + zOffset);
            } else if (z <= -radius) {
                location.setZ(radius - padding + zOffset);
            }
        }
    },
    DISABLED {
        @Override
        public void checkAndTeleport(Location location, int radius, int xOffset, int zOffset, int padding) {
            // NOOP
        }
    };

    public abstract void checkAndTeleport(Location location, int radius, int xOffset, int zOffset, int padding);
}
