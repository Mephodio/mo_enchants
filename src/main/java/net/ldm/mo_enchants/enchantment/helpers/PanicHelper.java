package net.ldm.mo_enchants.enchantment.helpers;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.LevelAccessor;

public class PanicHelper {
	public static void execute(LevelAccessor world, LivingEntity entity) {
		if (entity == null) return;
		if (EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.PANIC.get(), (entity.getItemBySlot(EquipmentSlot.FEET))) <= 0 || entity.getHealth() >= 8) return;
		int enchLevel = EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.PANIC.get(), (entity.getItemBySlot(EquipmentSlot.FEET)));

		if (entity.getLevel().getGameTime() - entity.getPersistentData().getLong("panicEnchantmentTriggerTime")
				> 240 / enchLevel) {
			entity.getPersistentData().putLong("panicEnchantmentTriggerTime", entity.getLevel().getGameTime());

			entity.setHealth(7);
			entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, (enchLevel * 40), enchLevel));
			entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, (enchLevel * 40), enchLevel));
			if (entity instanceof ServerPlayer) {
				if (world.isClientSide())
					Minecraft.getInstance().gameRenderer.displayItemActivation(
							(entity.getItemBySlot(EquipmentSlot.FEET)));
			}
			ItemStack item = (entity.getItemBySlot(EquipmentSlot.FEET));
			if (item.hurt(15, RandomSource.create(), null)) {
				item.shrink(1);
				item.setDamageValue(0);
			}
		} else {
			if (entity instanceof Player player && !player.level.isClientSide())
				player.displayClientMessage(Component.translatable("cooldown.input", Component.translatable("enchantment.mo_enchants.panic")), true);
		}
	}
}