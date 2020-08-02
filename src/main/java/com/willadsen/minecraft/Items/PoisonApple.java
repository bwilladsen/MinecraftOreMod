package com.willadsen.minecraft.Items;

import com.willadsen.minecraft.OreMod;

import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.item.Food;

import java.util.function.Supplier;

public class PoisonApple extends Item {

    private static final Supplier<EffectInstance> nausea = () -> new EffectInstance(Effects.NAUSEA, 300, 1);
    private static final Supplier<EffectInstance> poison = () -> new EffectInstance(Effects.POISON, 300, 1);
    private static final Supplier<EffectInstance> hunger = () -> new EffectInstance(Effects.HUNGER, 300, 1);

    public PoisonApple() {
        super(new Item.Properties()
                .group(OreMod.TAB)
                .food(new Food.Builder()
                        .hunger(4)
                        .saturation(1.2f)
                        .effect(nausea, 1)
                        .effect(poison, 1)
                        .effect(hunger, 0.3f)
                        .setAlwaysEdible()
                        .build()));
    }
}