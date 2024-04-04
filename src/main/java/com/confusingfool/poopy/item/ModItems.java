package com.confusingfool.poopy.item;

import com.confusingfool.poopy.Poopy;
import com.confusingfool.poopy.item.custom.*;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SnowballItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Poopy.MOD_ID);


    public static final RegistryObject<Item> POOPY = ITEMS.register("poopy",
            () -> new PoopyItem(new Item.Properties()));

    public static final RegistryObject<Item> HARDENED_POOPY = ITEMS.register("hardened_poopy",
            () -> new PoopyItem(new Item.Properties()));

    public static final RegistryObject<Item> POOPY_DIAMOND = ITEMS.register("poopy_diamond",
            () -> new PoopyDiamondItem(new Item.Properties()));

    public static final RegistryObject<Item> JASPER_CRYSTAL = ITEMS.register("jasper_crystal",
            () -> new JasperCrystalItem(new Item.Properties()));

    public static final RegistryObject<Item> DRIED_POOPY = ITEMS.register("dried_poopy",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationMod(2.4f).meat().fast().effect(() -> new MobEffectInstance(MobEffects.WITHER, 200, 1), 0.9f).effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 1), 0.9f).build())));

    public static final RegistryObject<Item> MOLTEN_JASPER = ITEMS.register("molten_jasper",
            () -> new MoltenJasperItem(new Item.Properties()));

    public static final RegistryObject<Item> FOUL_POOPY = ITEMS.register("foul_poopy",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> FLESH = ITEMS.register("flesh",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> POOPY_IN_A_BLANKET = ITEMS.register("poopy_in_a_blanket",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(5).build())));

    public static final RegistryObject<Item> POOPY_DIAMOND_SWORD = ITEMS.register("poopy_diamond_sword",
            () -> new PoopySwordItem(Tiers.DIAMOND, 2, 3f,
                    new Item.Properties()));

    public static final RegistryObject<Item> HARDENED_POOPY_HELMET = ITEMS.register("hardened_poopy_helmet",
            () -> new ArmorItem(ModArmorMaterials.HARDENED, net.minecraft.world.item.ArmorItem.Type.HELMET,
                    new Item.Properties()));
    public static final RegistryObject<Item> HARDENED_POOPY_CHESTPLATE = ITEMS.register("hardened_poopy_chestplate",
            () -> new ArmorItem(ModArmorMaterials.HARDENED, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties()));
    public static final RegistryObject<Item> HARDENED_POOPY_LEGGINGS = ITEMS.register("hardened_poopy_leggings",
            () -> new ArmorItem(ModArmorMaterials.HARDENED, ArmorItem.Type.LEGGINGS,
                    new Item.Properties()));
    public static final RegistryObject<Item> HARDENED_POOPY_BOOTS = ITEMS.register("hardened_poopy_boots",
            () -> new ArmorItem(ModArmorMaterials.HARDENED, ArmorItem.Type.BOOTS,
                    new Item.Properties()));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
