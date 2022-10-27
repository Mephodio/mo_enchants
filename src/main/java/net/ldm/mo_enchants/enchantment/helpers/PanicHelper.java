package net.ldm.mo_enchants.enchantment.helpers;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.client.Minecraft;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.LevelAccessor;

public class PanicHelper {
	public static void execute(LevelAccessor world, Player entity) {
		if (entity == null)
			return;
		if (EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.PANIC.get(), (entity.getItemBySlot(EquipmentSlot.FEET))) >= 1 && entity.getHealth() < 4) {
			entity.setHealth(5);
			entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION,
					(EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.PANIC.get(), (entity.getItemBySlot(EquipmentSlot.FEET))) * 200),
					(EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.PANIC.get(), (entity.getItemBySlot(EquipmentSlot.FEET))))));
			entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION,
					(EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.PANIC.get(), (entity.getItemBySlot(EquipmentSlot.FEET))) * 150),
					(EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.PANIC.get(), (entity.getItemBySlot(EquipmentSlot.FEET))))));
			if (entity instanceof ServerPlayer) {
				if (world.isClientSide())
					Minecraft.getInstance().gameRenderer.displayItemActivation(
							(entity.getItemBySlot(EquipmentSlot.FEET)));
			} {
				ItemStack item = (entity.getItemBySlot(EquipmentSlot.FEET));
				if (item.hurt(15, RandomSource.create(), null)) {
					item.shrink(1);
					item.setDamageValue(0);
				}
			}
		}
	}
}