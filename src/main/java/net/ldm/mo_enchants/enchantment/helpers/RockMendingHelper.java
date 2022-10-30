package net.ldm.mo_enchants.enchantment.helpers;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.block.state.BlockState;

public class RockMendingHelper {
	public static void execute(Entity entity, BlockState state) {
		if (!(entity instanceof LivingEntity livingEntity)) return;

		ItemStack usedItemStack = livingEntity.getUseItem();
		int enchLevel = EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.ROCK_MENDING.get(), usedItemStack);

		if (enchLevel > 0) return;
		if (state.getMaterial() != net.minecraft.world.level.material.Material.STONE) return;
		if (usedItemStack.getDamageValue() > usedItemStack.getMaxDamage()) return;

		double rand = Math.round(Math.random() * 10);

		if (rand < (enchLevel*2)) {
			if (usedItemStack.hurt(-1, RandomSource.create(), null)) {
				usedItemStack.shrink(1);
				usedItemStack.setDamageValue(0);
			}
		}
	}
}