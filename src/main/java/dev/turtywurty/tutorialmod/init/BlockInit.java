package dev.turtywurty.tutorialmod.init;

import dev.turtywurty.tutorialmod.TutorialMod;
import dev.turtywurty.tutorialmod.blocks.AdvancedBlock;
import dev.turtywurty.tutorialmod.blocks.CrusherBlock;
import dev.turtywurty.tutorialmod.blocks.CustomModelBlock;
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

    public static final RegistryObject<Block> EXAMPLE_OVERWORLD_ORE = register("example_overworld_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)),
            new Item.Properties().tab(TutorialMod.TAB));

    public static final RegistryObject<Block> EXAMPLE_DEEPSLATE_OVERWORLD_ORE = register("example_deepslate_overworld_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_DIAMOND_ORE)),
            new Item.Properties().tab(TutorialMod.TAB));

    public static final RegistryObject<Block> EXAMPLE_NETHER_ORE = register("example_nether_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHER_QUARTZ_ORE)),
            new Item.Properties().tab(TutorialMod.TAB));

    public static final RegistryObject<Block> EXAMPLE_END_ORE = register("example_end_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE)),
            new Item.Properties().tab(TutorialMod.TAB));

    public static final RegistryObject<Block> BLOCK_CUSTOM_MODEL = register("block_custom_model",
            () -> new CustomModelBlock(BlockBehaviour.Properties.of(Material.DIRT).dynamicShape().noOcclusion()),
            new Item.Properties().tab(TutorialMod.TAB));

    public static final RegistryObject<CrusherBlock> CRUSHER = register("crusher",
            () -> new CrusherBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(5f, 20f)),
            new Item.Properties().tab(TutorialMod.TAB));

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
