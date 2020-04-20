package com.gmail.felix.schmalzel.infiniteworld;

import org.bukkit.configuration.file.FileConfiguration;

import java.util.Optional;

public class InfiniteWorldConfig {

    private static final String CONFIG_VERSION = "CfgVersion";
    private static final String RADIUS = "Radius";
    private static final String X_OFFSET = "X-Offset";
    private static final String Z_OFFSET = "Z-Offset";
    private static final String PADDING = "Bufferzone";
    private static final String SHAPE = "Shape";

    private final InfiniteWorld pluginInstance;
    private final FileConfiguration config;

    private int radius;
    private int xOffset;
    private int zOffset;
    private int padding;
    private BorderShape shape;

    public InfiniteWorldConfig(InfiniteWorld pluginInstance) {
        this.pluginInstance = pluginInstance;
        this.config = pluginInstance.getConfig();
        initConfig();
    }

    private void initConfig() {
        config.addDefault(CONFIG_VERSION, 1);
        config.addDefault(RADIUS, 100);
        config.addDefault(X_OFFSET, 0);
        config.addDefault(Z_OFFSET, 0);
        config.addDefault(PADDING, 5);
        config.addDefault(SHAPE, "square");
        config.options().header("Config for InfiniteWorld");
        config.options().copyDefaults(true);

        pluginInstance.saveConfig();

        radius = config.getInt(RADIUS);
        xOffset = config.getInt(X_OFFSET);
        zOffset = config.getInt(Z_OFFSET);
        padding = config.getInt(PADDING);
        shape = Optional.ofNullable(config.getString(SHAPE))
                .map(String::toUpperCase)
                .map(shape -> {
                    try {
                        return BorderShape.valueOf(shape);
                    } catch (IllegalArgumentException | NullPointerException e) {
                        return null;
                    }
                }).orElse(BorderShape.CIRCLE);
    }

    public void save() {
        config.options().copyDefaults(true);
        pluginInstance.saveConfig();
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
        config.set(RADIUS, radius);
    }

    public int getxOffset() {
        return xOffset;
    }

    public void setxOffset(int xOffset) {
        this.xOffset = xOffset;
        config.set(X_OFFSET, xOffset);
    }

    public int getzOffset() {
        return zOffset;
    }

    public void setzOffset(int zOffset) {
        this.zOffset = zOffset;
        config.set(Z_OFFSET, zOffset);
    }

    public int getPadding() {
        return padding;
    }

    public void setPadding(int padding) {
        this.padding = padding;
        config.set(PADDING, padding);
    }

    public BorderShape getShape() {
        return shape;
    }

    public void setShape(BorderShape shape) {
        this.shape = shape;
        config.set(SHAPE, shape.toString());
    }
}
