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
import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class RevenantHelper {
	public static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.REVENANT.get(),
				(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0
				&& (entity instanceof LivingEntity _livEnt && _livEnt.getMobType() == MobType.UNDEAD)
				&& !entity.getType().is(TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation("minecraft:bosses")))
				&& Math.round(Math.random() * 100) < EnchantmentHelper.getItemEnchantmentLevel(MoEnchantsEnchantments.REVENANT.get(),
						(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) + 1) {
			entity.hurt(DamageSource.GENERIC, entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
		}
	}
}