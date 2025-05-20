package de.lulkas_.vanilla_addons;

import de.lulkas_.vanilla_addons.item.ModItemGroups;
import de.lulkas_.vanilla_addons.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VanillaAddons implements ModInitializer {
	public static final String MOD_ID = "vanilla_addons";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModItemGroups.registerModItemGroups();
	}
}