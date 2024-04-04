package com.confusingfool.poopy.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab
{
    public static final CreativeModeTab POOPY_TAB = new CreativeModeTab("poopytab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.POOPY_DIAMOND.get());
        }
    };
}
