package net.bikerboys.zombiesattackanything.util;

import net.bikerboys.zombiesattackanything.ExampleMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class ModTags {
    public class EntityTypes {

        public static final TagKey<EntityType<?>> ZOMBIE_FRIENDLY_TYPE = tag("zombie_friendly_type");

        private static TagKey<EntityType<?>> tag(String name) {
            return TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(ExampleMod.MODID, name));

        }

    }
}
