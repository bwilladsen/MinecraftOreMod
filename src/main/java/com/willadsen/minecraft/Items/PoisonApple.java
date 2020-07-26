package com.willadsen.minecraft.Items;

import com.willadsen.minecraft.OreMod;

import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.item.Food;

public class PoisonApple extends Item {

    public PoisonApple() {
        super(new Item.Properties()
                .group(OreMod.TAB)
                .food(new Food.Builder()
                        .hunger(4)
                        .saturation(1.2f)
                        .effect(new EffectInstance(Effects.NAUSEA, 300, 1), 1)
                        .effect(new EffectInstance(Effects.POISON, 300, 2), 1)
                        .effect(new EffectInstance(Effects.HUNGER, 300, 2), 0.3f)
                        .setAlwaysEdible()
                        .build()));
    }

}