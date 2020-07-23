package com.willadsen.minecraft.Tools;

import java.util.function.Supplier;

import com.willadsen.minecraft.util.RegistryHandler;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

public enum ModItemTier implements IItemTier {


    // Attack Damage Calculation 1 (all items start at 1) + base damage + item damage.

    // Harvet Level, Maximum Uses, Efficiency, Attack Damage
    RUBY(3, 800, 7.0f, 3.0f, 12, () -> {
        return Ingredient.fromItems(RegistryHandler.RUBY_SWORD.get());
    });

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairMaterial;

    ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability,
            Supplier<Ingredient> repairMaterial) {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public float getAttackDamage() {
        return attackDamage;
    }

    @Override
    public float getEfficiency() {
        return efficiency;
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public int getHarvestLevel() {
        return harvestLevel;
    }

    @Override
    public int getMaxUses() {
        return maxUses;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return repairMaterial.get();
    }

}