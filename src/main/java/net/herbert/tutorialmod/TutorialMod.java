package net.herbert.tutorialmod;

import net.fabricmc.api.ModInitializer;
import net.herbert.tutorialmod.blocks.ModBlocks;
import net.herbert.tutorialmod.items.ModItems;

public class TutorialMod implements ModInitializer {

	public static final String MOD_ID = "tutorialmod";

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		ModItems.registerItems();
		ModBlocks.registerBlocks();
		System.out.println("Hello This is my Mod!");
	}
}
