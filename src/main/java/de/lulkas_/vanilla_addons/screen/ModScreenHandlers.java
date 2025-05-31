package de.lulkas_.vanilla_addons.screen;

import de.lulkas_.vanilla_addons.VanillaAddons;
import de.lulkas_.vanilla_addons.screen.custom.EnchantmentUpgraderScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class ModScreenHandlers {
    public static final ScreenHandlerType<EnchantmentUpgraderScreenHandler> ENCHANTMENT_UPGRADER_SCREEN_HANDLER = Registry.register(Registries.SCREEN_HANDLER,
            Identifier.of(VanillaAddons.MOD_ID, "enchantment_upgrader_screen_handler"),
            new ExtendedScreenHandlerType<>(EnchantmentUpgraderScreenHandler::new, BlockPos.PACKET_CODEC));

    public static void registerModScreenHandlers() {
        VanillaAddons.LOGGER.info("Registering Screen Handlers for Mod " + VanillaAddons.MOD_ID);
    }
}
