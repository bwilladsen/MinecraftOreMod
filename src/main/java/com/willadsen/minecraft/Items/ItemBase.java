package com.willadsen.minecraft.Items;

import com.willadsen.minecraft.OreMod;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ItemBase extends Item {
    public ItemBase() {
        super(new Item.Properties().group(OreMod.TAB));
    }
    
}