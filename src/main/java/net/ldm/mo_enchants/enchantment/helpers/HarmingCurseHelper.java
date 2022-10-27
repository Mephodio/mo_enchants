package net.ldm.mo_enchants.enchantment.helpers;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;

public class HarmingCurseHelper {
	public static void execute( Entity sourceEntity) {
		if (sourceEntity == null)
			return;
		if (EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.HARMING_CURSE.get(),
				(sourceEntity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) > 0) {
			if (sourceEntity instanceof LivingEntity _entity)
				_entity.hurt(new DamageSource("curse.harming").bypassArmor(), 6);
		}
	}
}