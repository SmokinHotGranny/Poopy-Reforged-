package com.confusingfool.poopy;

import com.confusingfool.poopy.block.ModBlocks;
import com.confusingfool.poopy.effect.ModEffects;
import com.confusingfool.poopy.item.ModItems;
import com.confusingfool.poopy.potion.ModPotions;
import com.confusingfool.poopy.util.BetterBrewingRecipe;
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
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
