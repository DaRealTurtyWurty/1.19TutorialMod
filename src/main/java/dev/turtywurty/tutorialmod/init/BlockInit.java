package dev.turtywurty.tutorialmod.init;

import dev.turtywurty.tutorialmod.TutorialMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
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

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> supplier, Item.Properties properties) {
        RegistryObject<T> block = BLOCKS.register(name, supplier);
        ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(), properties));
        return block;
    }
}
