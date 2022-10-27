package net.ldm.mo_enchants.enchantment.helpers;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class HarmingCurseHelper {
	public static void execute(@Nullable Event event, Entity sourceentity) {
		if (sourceentity == null)
			return;
		if (EnchantmentHelper.getItemEnchantmentLevel(MoEnchantsEnchantments.HARMING_CURSE.get(),
				(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) > 0) {
			if (sourceentity instanceof LivingEntity _entity)
				_entity.hurt(new DamageSource("curse.harming").bypassArmor(), 6);
		}
	}
}