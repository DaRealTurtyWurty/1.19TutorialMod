package dev.turtywurty.tutorialmod.init;

import com.google.common.base.Suppliers;
import dev.turtywurty.tutorialmod.TutorialMod;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class ConfiguredFeatureInit {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, TutorialMod.MODID);

    private static final Supplier<List<OreConfiguration.TargetBlockState>> EXAMPLE_OVERWORLD_REPLACEMENT = Suppliers.memoize(() ->
            List.of(
                    OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, BlockInit.EXAMPLE_OVERWORLD_ORE.get().defaultBlockState()),
                    OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, BlockInit.EXAMPLE_DEEPSLATE_OVERWORLD_ORE.get().defaultBlockState())
            )
    );

    private static final Supplier<List<OreConfiguration.TargetBlockState>> EXAMPLE_NETHER_REPLACEMENT = Suppliers.memoize(() ->
            List.of(
                    OreConfiguration.target(OreFeatures.NETHERRACK, BlockInit.EXAMPLE_NETHER_ORE.get().defaultBlockState())
            )
    );

    private static final Supplier<List<OreConfiguration.TargetBlockState>> EXAMPLE_END_REPLACEMENT = Suppliers.memoize(() ->
            List.of(
                    OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE), BlockInit.EXAMPLE_END_ORE.get().defaultBlockState())
            )
    );

    public static final RegistryObject<ConfiguredFeature<?, ?>> EXAMPLE_OVERWORLD_ORE = CONFIGURED_FEATURES.register("example_overworld_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(EXAMPLE_OVERWORLD_REPLACEMENT.get(), 11)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> EXAMPLE_NETHER_ORE = CONFIGURED_FEATURES.register("example_nether_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(EXAMPLE_NETHER_REPLACEMENT.get(), 7)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> EXAMPLE_END_ORE = CONFIGURED_FEATURES.register("example_end_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(EXAMPLE_END_REPLACEMENT.get(), 15)));
}
