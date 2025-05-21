package de.lulkas_.vanilla_addons.datagen;

import de.lulkas_.vanilla_addons.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.EMERALD_BOOTS)
                .add(ModItems.EMERALD_LEGGINGS)
                .add(ModItems.EMERALD_CHESTPLATE)
                .add(ModItems.EMERALD_HELMET)
                .add(ModItems.COPPER_BOOTS)
                .add(ModItems.COPPER_LEGGINGS)
                .add(ModItems.COPPER_CHESTPLATE)
                .add(ModItems.COPPER_HELMET);
    }
}
