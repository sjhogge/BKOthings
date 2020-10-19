package com.brooklynotter.bkothings.world.gen;

import com.brooklynotter.bkothings.BKOthings;
import com.brooklynotter.bkothings.util.RegistryHandler;
import net.minecraft.block.BlockState;
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

import java.util.zip.CheckedOutputStream;

@Mod.EventBusSubscriber(modid= BKOthings.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class OreGen {

    @SubscribeEvent
    public static void generateOres(FMLLoadCompleteEvent event){
        for (Biome biome: ForgeRegistries.BIOMES){
            //Nether Generation
            if(biome.getCategory() == Biome.Category.NETHER){

            }
            //End Generation
            else if (biome.getCategory() == Biome.Category.THEEND){

            }
            //World Gen
            else{
                genOre(biome, 15, 8, 5, 50,
                        OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                        RegistryHandler.RUBY_ORE.get().getDefaultState(), 6);
            }
        }
    }

    private static void genOre(Biome biome, int count, int bottomOffset, int topOffset, int max,
                               OreFeatureConfig.FillerBlockType filler, BlockState defaultBlockState, int size){
        CountRangeConfig range = new CountRangeConfig(count, bottomOffset, topOffset, max);
        OreFeatureConfig feature = new OreFeatureConfig(filler, defaultBlockState, size);
        ConfiguredPlacement config = Placement.COUNT_RANGE.configure(range);
        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(feature).withPlacement(config));
    }
}
