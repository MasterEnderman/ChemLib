package com.smashingmods.chemlib.datagen;

import com.smashingmods.chemlib.ChemLib;
import com.smashingmods.chemlib.common.registry.BlockRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeRegistryTagsProvider;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;

public class BlockTagGenerator extends ForgeRegistryTagsProvider<Block> {

    public BlockTagGenerator(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, ForgeRegistries.BLOCKS, ChemLib.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        BlockRegistry.BLOCKS.getEntries().forEach(blockRegistryObject -> {
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(blockRegistryObject.get());
            tag(BlockTags.NEEDS_STONE_TOOL).add(blockRegistryObject.get());
        });
    }

    @Override
    @Nonnull
    public String getName() {
        return null;
    }
}
