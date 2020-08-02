package com.willadsen.minecraft.Tools;

import java.util.function.Supplier;

import com.willadsen.minecraft.util.RegistryHandler;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

public enum ModItemTier implements IItemTier {
    // Harvest Level, Maximum Uses, Efficiency, Attack Damage
    RUBY(3, 800, 7.0f, 3.0f, 12, () -> {
        return Ingredient.fromItems(RegistryHandler.RUBY.get());
    });

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairMaterial;

    ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
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
    @MethodsReturnNonnullByDefault
    public Ingredient getRepairMaterial() {
        return repairMaterial.get();
    }

}