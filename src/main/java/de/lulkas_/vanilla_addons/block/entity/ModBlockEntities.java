package de.lulkas_.vanilla_addons.block.entity;

import de.lulkas_.vanilla_addons.VanillaAddons;
import de.lulkas_.vanilla_addons.block.ModBlocks;
import de.lulkas_.vanilla_addons.block.entity.custom.EnchantmentUpgraderBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<EnchantmentUpgraderBlockEntity> ENCHANTMENT_UPGRADER_BE = Registry.register(Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(VanillaAddons.MOD_ID, "enchantment_upgrader_be"),
            BlockEntityType.Builder.create(EnchantmentUpgraderBlockEntity::new, ModBlocks.ENCHANTMENT_UPGRADER).build(null));

    public static void registerModBlockEntities() {
        VanillaAddons.LOGGER.info("Registering Block Entities for Mod " + VanillaAddons.MOD_ID);
    }
}
