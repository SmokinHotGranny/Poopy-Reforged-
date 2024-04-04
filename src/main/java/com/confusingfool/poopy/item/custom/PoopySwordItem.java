package com.confusingfool.poopy.item.custom;

import com.confusingfool.poopy.effect.ModEffects;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class PoopySwordItem extends SwordItem
{

    public PoopySwordItem(Tier tier, int damageModifier, float attackSpeed, Properties properties) {
        super(tier, damageModifier, attackSpeed, properties);
    }


    @Override
    public boolean hurtEnemy(ItemStack itemStack, LivingEntity target, LivingEntity attacker)
    {
        target.addEffect(new MobEffectInstance(ModEffects.DYSENTERY.get(), 200), attacker);

        return super.hurtEnemy(itemStack, target, attacker);
    }


    @Override
    public void appendHoverText(ItemStack stack, Level level, List<Component> components, TooltipFlag flag)
    {
        if (Screen.hasShiftDown())
        {
            components.add(Component.literal("When you hit something, it gets Dysentery.").withStyle(ChatFormatting.AQUA));
        } else {
            components.add(Component.literal("Press SHIFT for more info").withStyle(ChatFormatting.YELLOW));
        }



        super.appendHoverText(stack, level, components, flag);
    }
}
