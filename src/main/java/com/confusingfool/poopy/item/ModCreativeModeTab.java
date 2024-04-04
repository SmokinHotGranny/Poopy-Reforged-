package com.confusingfool.poopy.item;

import com.confusingfool.poopy.Poopy;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Poopy.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTab
{
    public static CreativeModeTab POOPY_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event)
    {
        POOPY_TAB = event.registerCreativeModeTab(new ResourceLocation(Poopy.MOD_ID, "poopy_tab"),
                builder -> builder.icon(() -> new ItemStack(ModItems.POOPY.get())).title(Component.literal("Poopy")).build());
    }
}
