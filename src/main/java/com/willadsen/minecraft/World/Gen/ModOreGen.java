package com.willadsen.minecraft.World.Gen;

import com.google.common.eventbus.Subscribe;
import com.willadsen.minecraft.Ore.RubyOre;
import com.willadsen.minecraft.OreMod;
import com.willadsen.minecraft.util.RegistryHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockMatcher;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = OreMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModOreGen {

    // You can use this technique to spawn ore next to other ore block.
    public static OreFeatureConfig.FillerBlockType END_STONE = OreFeatureConfig.FillerBlockType.create("END_STONE",
            "end_stone",new BlockMatcher(Blocks.END_STONE));

    @SubscribeEvent
    public static void GenerateOres(FMLLoadCompleteEvent events) {
        for(Biome biome : ForgeRegistries.BIOMES) {
            if (biome.getCategory() == Biome.Category.NETHER) {
                genOre(biome, 12, 5, 5, 80,
                        OreFeatureConfig.FillerBlockType.NETHERRACK, RegistryHandler.RUBY_ORE.get().getDefaultState(), 4);
            }

            else if (biome.getCategory() == Biome.Category.THEEND) {
                genOre(biome, 18, 3, 5, 80,
                        END_STONE, RegistryHandler.RUBY_ORE.get().getDefaultState(), 4);
            }

            else {
                genOre(biome, 15, 8, 5, 50,
                        OreFeatureConfig.FillerBlockType.NATURAL_STONE, RegistryHandler.RUBY_ORE.get().getDefaultState(), 6);
            }
        }
    }

    // howOftenToFindOre 1 - Rare, 20 - Everywhere
    // Ore will spawn between bottomOffset and (max - topOffset).  These are the Y values in the game.
    //      For example.  To spawm ore between 5 and 30, you would pass in bottomOffset = 5, topOffset = 5, max = 35
    private static void genOre(Biome biome, int howOftenToFindOre, int bottomOffset, int topOffset,
                               int max, OreFeatureConfig.FillerBlockType filler, BlockState defaultBlockState, int oreVeinSize) {
        CountRangeConfig range = new CountRangeConfig(howOftenToFindOre, bottomOffset, topOffset, max);
        OreFeatureConfig feature = new OreFeatureConfig(filler, defaultBlockState, oreVeinSize);

        ConfiguredPlacement config = Placement.COUNT_RANGE.configure(range);

        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(feature).withPlacement(config));
    }
}
