package com.willadsen.minecraft.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class RainbowRubyBlock extends Block {
    public RainbowRubyBlock() {
        super(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(5.0f, 6.0f)
                .sound(SoundType.METAL)
                .harvestLevel(2) // Minimum required tool tier to harvest the block.  0 = Wood, 1 = Stone, 2 - Iron, 3 - Diamond
                .harvestTool(ToolType.PICKAXE)
        );
    }
}
