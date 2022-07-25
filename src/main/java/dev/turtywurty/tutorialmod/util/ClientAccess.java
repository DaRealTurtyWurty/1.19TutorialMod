package dev.turtywurty.tutorialmod.util;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;

import java.util.List;

public class ClientAccess {
    private static final String PURPLE = "\u00A75";
    private static final String WHITE = "\u00A7f";

    public static void advancedItemTooltip(Level level, List<Component> components) {
        if(!Screen.hasShiftDown()) {
            components.add(Component.literal("Press " + PURPLE + "SHIFT " + WHITE + "for more information!"));
        } else {
            components.add(Component.literal("Beans! " + level.isRaining()));
        }
    }
}
