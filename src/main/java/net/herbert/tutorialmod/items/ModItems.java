package net.herbert.tutorialmod.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.herbert.tutorialmod.TutorialMod;
import net.herbert.tutorialmod.blocks.ModBlocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    // Items
    public static final Item RUBY = new Item(new Item.Settings().group(ItemGroup.MATERIALS));


    // Block Items
    public static final BlockItem RUBY_BLOCK = new BlockItem(ModBlocks.RUBY_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));


    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(TutorialMod.MOD_ID, "ruby"), RUBY);
        Registry.register(Registry.ITEM, new Identifier(TutorialMod.MOD_ID, "ruby_block"), RUBY_BLOCK);
        System.out.println("Registering Mod Items for " + TutorialMod.MOD_ID);
    }

}
