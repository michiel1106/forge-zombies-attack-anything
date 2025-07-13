package bikerboys.zombiesattackanything;

import net.fabricmc.api.ModInitializer;

import net.minecraft.entity.EntityType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZombiesAttackAnything implements ModInitializer {
	public static final String MOD_ID = "zombiesattackanything";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final TagKey<EntityType<?>> ZOMBIE_FRIENDLY = TagKey.of(RegistryKeys.ENTITY_TYPE, new Identifier(MOD_ID, "zombie_friendly_type"));

	@Override
	public void onInitialize() {

	}
}