package de.lulkas_.vanilla_addons.item;

import de.lulkas_.vanilla_addons.VanillaAddons;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup VANILLA_ADDONS_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(VanillaAddons.MOD_ID, "vanilla_addons"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(Items.GRASS_BLOCK))
                    .displayName(Text.translatable("item_group.vanilla_addons.vanilla_addons"))
                    .entries((displayContext, entries) -> {
                        ModItems.addItemGroupEntries(entries);
                    }).build()
    );

    public static void registerModItemGroups() {
        VanillaAddons.LOGGER.info("Registering Item Groups for Mod " + VanillaAddons.MOD_ID + " Mod");
    }
}
