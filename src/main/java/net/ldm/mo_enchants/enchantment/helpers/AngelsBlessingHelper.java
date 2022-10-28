package net.ldm.mo_enchants.enchantment.helpers;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;

import java.util.Map;

public class AngelsBlessingHelper {
	public static void execute(Entity rawEntity, double amount) {
		if (!(rawEntity instanceof LivingEntity entity) || amount < entity.getHealth()) return;
		if (entity.getMainHandItem().getItem() == Items.TOTEM_OF_UNDYING && EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.ANGELS_BLESSING.get(), entity.getMainHandItem()) >= 1) {
			totemAction(entity, true);
			decrementLevel(entity, true);
		} else if (entity.getOffhandItem().getItem() == Items.TOTEM_OF_UNDYING && EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.ANGELS_BLESSING.get(), entity.getOffhandItem()) >= 1) {
			totemAction(entity, false);
			decrementLevel(entity, false);
		}
	}

	private static void totemAction(LivingEntity entity, boolean mainHand) {
		if (entity instanceof ServerPlayer serverPlayer) {
			serverPlayer.awardStat(Stats.ITEM_USED.get(Items.TOTEM_OF_UNDYING), 1);
			if (mainHand)
				CriteriaTriggers.USED_TOTEM.trigger(serverPlayer, entity.getMainHandItem());
			else
				CriteriaTriggers.USED_TOTEM.trigger(serverPlayer, entity.getOffhandItem());
		}

		entity.setHealth(1.0F);
		entity.removeAllEffects();
		entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 900, 1));
		entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 100, 1));
		entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 800, 0));
		entity.level.broadcastEntityEvent(entity, (byte)35);
	}

	private static void decrementLevel(LivingEntity entity, boolean mainHand) {
		if (mainHand) {
			if (EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.ANGELS_BLESSING.get(), entity.getMainHandItem()) == 1) {
				Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(entity.getMainHandItem());
				if (enchantments.containsKey(MoEnchantsEnchantments.ANGELS_BLESSING.get())) {
					enchantments.remove(MoEnchantsEnchantments.ANGELS_BLESSING.get());
					EnchantmentHelper.setEnchantments(enchantments, entity.getMainHandItem());
				}
			} else {
				int oldEnchLv = EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.ANGELS_BLESSING.get(), entity.getMainHandItem());
				Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(entity.getMainHandItem());
				if (enchantments.containsKey(MoEnchantsEnchantments.ANGELS_BLESSING.get())) {
					enchantments.remove(MoEnchantsEnchantments.ANGELS_BLESSING.get());
					EnchantmentHelper.setEnchantments(enchantments, entity.getMainHandItem());
				}
				entity.getMainHandItem().enchant(MoEnchantsEnchantments.ANGELS_BLESSING.get(), oldEnchLv - 1);
			}
		} else {
			if (EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.ANGELS_BLESSING.get(), entity.getOffhandItem()) == 1) {
				Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(entity.getOffhandItem());
				if (enchantments.containsKey(MoEnchantsEnchantments.ANGELS_BLESSING.get())) {
					enchantments.remove(MoEnchantsEnchantments.ANGELS_BLESSING.get());
					EnchantmentHelper.setEnchantments(enchantments, entity.getOffhandItem());
				}
			} else {
				int oldEnchLv = EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.ANGELS_BLESSING.get(), entity.getOffhandItem());
				Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(entity.getOffhandItem());
				if (enchantments.containsKey(MoEnchantsEnchantments.ANGELS_BLESSING.get())) {
					enchantments.remove(MoEnchantsEnchantments.ANGELS_BLESSING.get());
					EnchantmentHelper.setEnchantments(enchantments, entity.getOffhandItem());
				}
				entity.getOffhandItem().enchant(MoEnchantsEnchantments.ANGELS_BLESSING.get(), oldEnchLv - 1);
			}
		}
	}
}
