package net.ldm.mo_enchants.enchantment.helpers;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;

public class RevenantHelper {
	public static void execute( Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.REVENANT.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0
				&& (entity instanceof LivingEntity _livEnt && _livEnt.getMobType() == MobType.UNDEAD)
				&& !entity.getType().is(TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation("minecraft:bosses")))) {
			if (Math.round(Math.random() * 100) < EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.REVENANT.get(),
					_livEnt.getMainHandItem()) + 1) {
				LivingEntity hurt = (LivingEntity) entity;
				entity.hurt(DamageSource.GENERIC, hurt.getHealth());
			}
		}
	}
}