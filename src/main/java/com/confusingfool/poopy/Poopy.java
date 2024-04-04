package com.confusingfool.poopy;

import com.confusingfool.poopy.block.ModBlocks;
import com.confusingfool.poopy.effect.ModEffects;
import com.confusingfool.poopy.item.ModCreativeModeTab;
import com.confusingfool.poopy.item.ModItems;
import com.confusingfool.poopy.potion.ModPotions;
import com.confusingfool.poopy.util.BetterBrewingRecipe;
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Poopy.MOD_ID)
public class Poopy
{
    public static final String MOD_ID = "poopy";
    private static final Logger LOGGER = LogUtils.getLogger();
    public Poopy()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        ModPotions.register(modEventBus);
        ModEffects.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }


    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD,
                    ModItems.DRIED_POOPY.get(), ModPotions.POOPY_ESSENCE.get()));
            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.POOPY_ESSENCE.get(),
                    ModItems.MOLTEN_JASPER.get(), ModPotions.DYSENTERY_CURE.get()));
        });
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event)
    {
        if (event.getTab() == ModCreativeModeTab.POOPY_TAB)
        {
            event.accept(ModItems.POOPY);
            event.accept(ModItems.DRIED_POOPY);
            event.accept(ModItems.HARDENED_POOPY);
            event.accept(ModItems.FOUL_POOPY);
            event.accept(ModItems.JASPER_CRYSTAL);
            event.accept(ModItems.MOLTEN_JASPER);
            event.accept(ModItems.POOPY_DIAMOND);
            event.accept(ModItems.FLESH);
            event.accept(ModItems.POOPY_IN_A_BLANKET);
            event.accept(ModItems.POOPY_DIAMOND_SWORD);
            event.accept(ModItems.HARDENED_POOPY_HELMET);
            event.accept(ModItems.HARDENED_POOPY_CHESTPLATE);
            event.accept(ModItems.HARDENED_POOPY_LEGGINGS);
            event.accept(ModItems.HARDENED_POOPY_BOOTS);
            event.accept(ModBlocks.POOPY_BLOCK);
        }

        if (event.getTab() == CreativeModeTabs.NATURAL_BLOCKS)
        {
            event.accept(ModBlocks.POOPY_BLOCK);
        }

        if (event.getTab() == CreativeModeTabs.COMBAT)
        {
            event.accept(ModItems.POOPY_DIAMOND_SWORD);
            event.accept(ModItems.HARDENED_POOPY_HELMET);
            event.accept(ModItems.HARDENED_POOPY_CHESTPLATE);
            event.accept(ModItems.HARDENED_POOPY_LEGGINGS);
            event.accept(ModItems.HARDENED_POOPY_BOOTS);
        }

        if (event.getTab() == CreativeModeTabs.FOOD_AND_DRINKS)
        {
            event.accept(ModItems.DRIED_POOPY);
            event.accept(ModItems.POOPY_IN_A_BLANKET);
        }

        if (event.getTab() == CreativeModeTabs.INGREDIENTS)
        {
            event.accept(ModItems.POOPY);
            event.accept(ModItems.HARDENED_POOPY);
            event.accept(ModItems.FOUL_POOPY);
            event.accept(ModItems.JASPER_CRYSTAL);
            event.accept(ModItems.MOLTEN_JASPER);
            event.accept(ModItems.POOPY_DIAMOND);
            event.accept(ModItems.FLESH);
        }
    }


    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
