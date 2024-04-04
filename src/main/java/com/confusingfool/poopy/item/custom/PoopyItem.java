package com.confusingfool.poopy.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class PoopyItem extends Item
{
    public PoopyItem(Properties properties) { super(properties);}

    @Override
    public void appendHoverText(ItemStack stack, Level level, List<Component> components, TooltipFlag flag)
    {
        if (Screen.hasShiftDown())
        {
            components.add(Component.literal("You can make some very dangerous things with this item, partner... be careful! Also, if you craft it into a block, break the block with the correct tool and you have a shot at winning a poopy diamond!").withStyle(ChatFormatting.AQUA));
        } else {
            components.add(Component.literal("Press SHIFT for more info").withStyle(ChatFormatting.YELLOW));
        }



        super.appendHoverText(stack, level, components, flag);
    }
}
