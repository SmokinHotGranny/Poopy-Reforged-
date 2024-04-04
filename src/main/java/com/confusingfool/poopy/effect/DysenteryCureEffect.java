package com.confusingfool.poopy.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

public class DysenteryCureEffect extends MobEffect
{
    public DysenteryCureEffect(MobEffectCategory mobEffectCategory, int color) { super(mobEffectCategory, color); }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier)
    {
        pLivingEntity.removeEffect(ModEffects.DYSENTERY.get());
        pLivingEntity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200));

        super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier)
    {
        return true;
    }
}
