package net.ldm.mo_enchants.enchantment.helpers;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;

public class NightVisionHelper {
	public static void execute(LivingEquipmentChangeEvent event) {
		if (event.getSlot().equals(EquipmentSlot.HEAD) && event.getEntity() instanceof Player) {
			if (EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.NIGHT_VISION.get(), event.getTo()) >= 1) {
				event.getEntity().addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 2147483647, 0, false, false, false));
			} else if (EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.NIGHT_VISION.get(), event.getFrom()) >= 1) {
				event.getEntity().removeEffect(MobEffects.NIGHT_VISION);
			}
		}
	}
}