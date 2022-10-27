package net.ldm.mo_enchants.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class HarmingCurseHelper {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getSource().getEntity());
		}
	}

	public static void execute(Entity sourceentity) {
		execute(null, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity sourceentity) {
		if (sourceentity == null)
			return;
		if (EnchantmentHelper.getItemEnchantmentLevel(MoEnchantsEnchantments.HARMING_CURSE.get(),
				(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) > 0) {
			if (sourceentity instanceof LivingEntity _entity)
				_entity.hurt(new DamageSource("curse.harming").bypassArmor(), 6);
		}
	}
}
