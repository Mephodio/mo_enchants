package net.ldm.mo_enchants.enchantment.helpers;

import net.ldm.mo_enchants.BiomeTags;
import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.biome.Biome;

public class BoilingCurseHelper {
	public static void execute( LevelAccessor world, BlockPos pos, Player entity ) {
		if (entity == null)
			return;
		Holder<Biome> biome = world.getBiome(pos);
		if ((biome.is(BiomeTags.IS_HOT) || entity.level.dimension() == Level.NETHER)
				&& (EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.BOILING_CURSE.get(), entity.getItemBySlot(EquipmentSlot.HEAD)) >= 1)
				|| (EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.BOILING_CURSE.get(), entity.getItemBySlot(EquipmentSlot.CHEST)) >= 1)
				|| (EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.BOILING_CURSE.get(), entity.getItemBySlot(EquipmentSlot.LEGS)) >= 1)
				|| (EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.BOILING_CURSE.get(), entity.getItemBySlot(EquipmentSlot.FEET)) >= 1)) {
			entity.setSecondsOnFire(3);
		}
	}
}
