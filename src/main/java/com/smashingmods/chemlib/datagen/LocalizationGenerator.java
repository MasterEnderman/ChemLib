package com.smashingmods.chemlib.datagen;

import com.smashingmods.chemlib.ChemLib;
import com.smashingmods.chemlib.common.registry.ItemRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;

public class LocalizationGenerator extends LanguageProvider {

    public LocalizationGenerator(DataGenerator gen, String locale) {
        super(gen, ChemLib.MODID, locale);
    }

    @Override
    @SuppressWarnings("deprecation")
    protected void addTranslations() {

        ItemRegistry.ELEMENTS.stream().forEach(element -> add(String.format("item.chemlib.%s", element.getName()), StringUtils.capitalize(element.getName())));
        ItemRegistry.DUSTS.stream().forEach(dust -> add(String.format("item.chemlib.%s_dust", dust.getName()), WordUtils.capitalize(String.format("%s dust", dust.getName().replace("_", " ")))));
        ItemRegistry.NUGGETS.stream().forEach(nugget -> add(String.format("item.chemlib.%s_nugget", nugget.getName()), WordUtils.capitalize(String.format("%s nugget", nugget.getName()))));
        ItemRegistry.INGOTS.stream().forEach(ingot -> add(String.format("item.chemlib.%s_ingot", ingot.getName()), WordUtils.capitalize(String.format("%s ingot", ingot.getName()))));
        ItemRegistry.PLATES.stream().forEach(plate -> add(String.format("item.chemlib.%s_plate", plate.getName()), WordUtils.capitalize(String.format("%s plate", plate.getName()))));
        ItemRegistry.COMPOUNDS.stream().forEach(compound -> add(String.format("item.chemlib.%s", compound.getName()), WordUtils.capitalize(compound.getName().replace("_", " "))));
        ItemRegistry.BLOCK_ITEMS.stream().forEach(blockItem -> add(String.format("block.chemlib.%s", blockItem.getRegistryName().getPath()), WordUtils.capitalize(blockItem.getRegistryName().getPath().replace("_", " "))));
        
        add("itemGroup.chemlib", "Chemistry");
    }
}
