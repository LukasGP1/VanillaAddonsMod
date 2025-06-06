package de.lulkas_.vanilla_addons.datagen;

import de.lulkas_.vanilla_addons.block.ModBlocks;
import de.lulkas_.vanilla_addons.datagen.util.RomanNumeralConverter;
import de.lulkas_.vanilla_addons.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLanguageProvider extends FabricLanguageProvider {
    public ModLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        ModItems.generateTranslations(translationBuilder);
        ModBlocks.generateTranslations(translationBuilder);
        translationBuilder.add("item_group.vanilla_addons.vanilla_addons", "Vanilla Addons");
        translationBuilder.add("tooltip.vanilla_addons.emerald_armor.first", "With full set:");
        translationBuilder.add("tooltip.vanilla_addons.emerald_armor.speed", "Speed");
        translationBuilder.add("enchantment.vanilla_addons.totem_savior", "Totem Savior");
        translationBuilder.add("gui.enchantment_upgrader.cost", "Cost: ");
        for(int level = 1; level <= 255; level++) {
            if(level < 11) {
                continue;
            }
            translationBuilder.add("enchantment.level." + level, RomanNumeralConverter.integerToRoman(level));
        }
    }
}
