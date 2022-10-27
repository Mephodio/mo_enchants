package net.ldm.mo_enchants;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class BiomeTags {
    public static TagKey<Biome> IS_FROZEN = TagKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(MoEnchantsMod.MODID, "is_frozen"));
    public static TagKey<Biome> IS_HOT = TagKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(MoEnchantsMod.MODID, "is_hot"));
}
