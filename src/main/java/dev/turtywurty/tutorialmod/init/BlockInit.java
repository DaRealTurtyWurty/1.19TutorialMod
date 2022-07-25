package dev.turtywurty.tutorialmod.init;

import dev.turtywurty.tutorialmod.TutorialMod;
import dev.turtywurty.tutorialmod.blocks.AdvancedBlock;
import dev.turtywurty.tutorialmod.items.AdvancedItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MODID);

    public static final RegistryObject<Block> EXAMPLE_BLOCK = register("example_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.AMETHYST).friction(0.5f).strength(1f, 5f).requiresCorrectToolForDrops()),
                  new Item.Properties().tab(TutorialMod.TAB));
    public static final RegistryObject<Block> EXAMPLE2_BLOCK = register("example2_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.DIRT).strength(2.5f, 18f).requiresCorrectToolForDrops()),
                  new Item.Properties().tab(TutorialMod.TAB));

    public static final RegistryObject<Block> EXAMPLE_ANIMATED = register("example_animated",
            () -> new Block(BlockBehaviour.Properties.of(Material.GRASS)),
                  new Item.Properties().tab(TutorialMod.TAB));

    public static final RegistryObject<FlowerBlock> EXAMPLE_FLOWER = register("example_flower",
            () -> new FlowerBlock(MobEffects.DIG_SPEED, 300, BlockBehaviour.Properties.copy(Blocks.DANDELION)),
                  new Item.Properties().tab(TutorialMod.TAB));

    public static final RegistryObject<AdvancedBlock> ADVANCED_BLOCK = register("advanced_block",
            () -> new AdvancedBlock(BlockBehaviour.Properties.copy(Blocks.DIRT).randomTicks()),
                  new Item.Properties().tab(TutorialMod.TAB));

    public static final RegistryObject<FlowerPotBlock> EXAMPLE_FLOWER_POT = BLOCKS.register("example_flower_pot",
            () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, BlockInit.EXAMPLE_FLOWER, BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> supplier, Item.Properties properties) {
        RegistryObject<T> block = BLOCKS.register(name, supplier);
        ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(), properties));
        return block;
    }

    public static class Tags {
        public static final TagKey<Block> NEEDS_EXAMPLE_TOOL = create("mineable/needs_example_tool");

        private static TagKey<Block> create(String location) {
            return BlockTags.create(new ResourceLocation(TutorialMod.MODID, location));
        }
    }
}
