package net.ldm.mo_enchants.enchantment.helpers;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;
public class LifeStealHelper {
	public static void execute(@Nullable Event event, Entity sourceentity) {
		if (sourceentity == null)
			return;
		double rand = 0;
		rand = Math.round(Math.random() * 10);
		if (EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.LIFE_STEAL.get(),
				(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) == 1 && rand == 1) {
			if (sourceentity instanceof LivingEntity _entity)
				_entity.setHealth((float) ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 2));
		} else if (EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.LIFE_STEAL.get(),
				(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) == 2 && rand < 3) {
			if (sourceentity instanceof LivingEntity _entity)
				_entity.setHealth((float) ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 3));
		} else if (EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.LIFE_STEAL.get(),
				(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) == 3 && rand < 4) {
			if (sourceentity instanceof LivingEntity _entity)
				_entity.setHealth((float) ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 4));
		}
	}
}