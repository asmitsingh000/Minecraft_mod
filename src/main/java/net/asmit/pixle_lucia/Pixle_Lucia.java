package net.asmit.pixle_lucia;

import net.asmit.pixle_lucia.additionaltab.Creativetab;
import net.asmit.pixle_lucia.item.Moditems;
import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Pixle_Lucia implements ModInitializer {
	public static final String MOD_ID = "pixle_lucia";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        Moditems.registerModitems();
        Creativetab.registerModcreativeTab();
	}
}
