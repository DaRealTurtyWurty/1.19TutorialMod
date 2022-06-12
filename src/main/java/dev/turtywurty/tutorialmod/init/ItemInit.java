package dev.turtywurty.tutorialmod.init;

import dev.turtywurty.tutorialmod.TutorialMod;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MODID);

    public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("example_item",
            () -> new Item(props()));
    public static final RegistryObject<Item> EXAMPLE2_ITEM = ITEMS.register("example2_item",
            () -> new Item(props()));
    public static final RegistryObject<Item> EXAMPLE_FOOD = ITEMS.register("example_food",
            () -> new Item(props().food(Foods.EXAMPLE_FOOD)));

    public static final RegistryObject<SwordItem> EXAMPLE_SWORD = ITEMS.register("example_sword",
            () -> new SwordItem(ToolTiers.EXAMPLE, 5, 3.5f, props()));
    public static final RegistryObject<PickaxeItem> EXAMPLE_PICKAXE = ITEMS.register("example_pickaxe",
            () -> new PickaxeItem(ToolTiers.EXAMPLE, 4, 3.5f, props()));
    public static final RegistryObject<ShovelItem> EXAMPLE_SHOVEL = ITEMS.register("example_shovel",
            () -> new ShovelItem(ToolTiers.EXAMPLE, 3, 3.5f, props()));
    public static final RegistryObject<AxeItem> EXAMPLE_AXE = ITEMS.register("example_axe",
            () -> new AxeItem(ToolTiers.EXAMPLE, 7, 3.5f, props()));
    public static final RegistryObject<HoeItem> EXAMPLE_HOE = ITEMS.register("example_hoe",
            () -> new HoeItem(ToolTiers.EXAMPLE, 1, 3.5f, props()));

    private static Item.Properties props() {
        return new Item.Properties().tab(TutorialMod.TAB);
    }

    public static class Foods {
        public static final FoodProperties EXAMPLE_FOOD = new FoodProperties.Builder()
                .nutrition(6)
                .saturationMod(0.6f)
                .meat()
                .fast()
                .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 600, 3), 0.9f)
                .build();
    }

    public static class ToolTiers {
        public static final Tier EXAMPLE = new ForgeTier(
                2,
                800,
                1.5f,
                3,
                350,
                null,
                () -> Ingredient.of(ItemInit.EXAMPLE_ITEM.get()));
    }
}
