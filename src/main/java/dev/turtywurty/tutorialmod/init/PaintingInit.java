package dev.turtywurty.tutorialmod.init;

import dev.turtywurty.tutorialmod.TutorialMod;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PaintingInit {
    public static final DeferredRegister<PaintingVariant> PAINTINGS = DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, TutorialMod.MODID);

    public static final RegistryObject<PaintingVariant> DESERT = PAINTINGS.register("desert", () -> new PaintingVariant(16, 16));

    public static final RegistryObject<PaintingVariant> NETHER = PAINTINGS.register("nether", () -> new PaintingVariant(32, 16));
}
