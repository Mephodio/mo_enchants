package net.ldm.mo_enchants.enchantment.helpers;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class UltimateFinishHelper {
	public static void execute( LevelAccessor world, double x, double y, double z, Entity sourceentity ) {
		if (sourceentity == null)
			return;
		if (EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.ULTIMATE_FINISH.get(),
				(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) > 0) {
			if (sourceentity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2, 127, (false), (false)));
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, x, y, z, 3, Explosion.BlockInteraction.NONE);
		}
	}
}
