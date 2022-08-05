package dev.turtywurty.tutorialmod.init;

import dev.turtywurty.tutorialmod.TutorialMod;
import dev.turtywurty.tutorialmod.base.FuelItem;
import dev.turtywurty.tutorialmod.base.ModArmorMaterial;
import dev.turtywurty.tutorialmod.items.AdvancedItem;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
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
            () -> new FuelItem(props(), 500));

    public static final RegistryObject<Item> EXAMPLE_FOOD = ITEMS.register("example_food",
            () -> new Item(props().food(Foods.EXAMPLE_FOOD)));

    public static final RegistryObject<AdvancedItem> ADVANCED_ITEM = ITEMS.register("advanced_item",
            () -> new AdvancedItem(props()));

    public static final RegistryObject<Item> ITEM_CUSTOM_MODEL = ITEMS.register("item_custom_model",
            () -> new Item(props()));

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

    public static final RegistryObject<ArmorItem> EXAMPLE_HELMET = ITEMS.register("example_helmet",
            () -> new ArmorItem(ArmorTiers.EXAMPLE, EquipmentSlot.HEAD, props()));
    public static final RegistryObject<ArmorItem> EXAMPLE_CHESTPLATE = ITEMS.register("example_chestplate",
            () -> new ArmorItem(ArmorTiers.EXAMPLE, EquipmentSlot.CHEST, props()));
    public static final RegistryObject<ArmorItem> EXAMPLE_LEGGINGS = ITEMS.register("example_leggings",
            () -> new ArmorItem(ArmorTiers.EXAMPLE, EquipmentSlot.LEGS, props()));
    public static final RegistryObject<ArmorItem> EXAMPLE_BOOTS = ITEMS.register("example_boots",
            () -> new ArmorItem(ArmorTiers.EXAMPLE, EquipmentSlot.FEET, props()));

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
                BlockInit.Tags.NEEDS_EXAMPLE_TOOL,
                () -> Ingredient.of(ItemInit.EXAMPLE_ITEM.get()));
    }

    public static class ArmorTiers {
        public static final ArmorMaterial EXAMPLE = new ModArmorMaterial(
                "example",
                500,
                new int[] { 20, 40, 50, 10 },
                300,
                SoundEvents.ARMOR_EQUIP_DIAMOND,
                0.0f,
                0.0f,
                () -> Ingredient.of(ItemInit.EXAMPLE_ITEM.get()));
    }
}
