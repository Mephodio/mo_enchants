package net.ldm.mo_enchants.procedures;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class NightVisionHelperProcedure {
	@SubscribeEvent
	public static void OnEquipmentChange( LivingEquipmentChangeEvent event ) {
		if (event.getSlot().equals(EquipmentSlot.HEAD) && EnchantmentHelper.getItemEnchantmentLevel(MoEnchantsEnchantments.NIGHT_VISION.get(), event.getTo()) >= 1 &&
		event.getEntityLiving() instanceof Player) {
			event.getEntityLiving().addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 2147483647, 0, false, false, false));
		}

		if (event.getSlot().equals(EquipmentSlot.HEAD) && EnchantmentHelper.getItemEnchantmentLevel(MoEnchantsEnchantments.NIGHT_VISION.get(), event.getFrom()) >= 1 &&
				event.getEntityLiving() instanceof Player)
			event.getEntityLiving().removeEffect(MobEffects.NIGHT_VISION);
	}
}
