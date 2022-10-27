package net.ldm.mo_enchants.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ScorchingCurseHelper {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity());
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (EnchantmentHelper.getItemEnchantmentLevel(MoEnchantsEnchantments.SCORCHING_CURSE.get(),
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY)) > 0
				|| EnchantmentHelper.getItemEnchantmentLevel(MoEnchantsEnchantments.SCORCHING_CURSE.get(),
						(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY)) > 0
				|| EnchantmentHelper.getItemEnchantmentLevel(MoEnchantsEnchantments.SCORCHING_CURSE.get(),
						(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY)) > 0
				|| EnchantmentHelper.getItemEnchantmentLevel(MoEnchantsEnchantments.SCORCHING_CURSE.get(),
						(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY)) > 0) {
			entity.setSecondsOnFire(5);
		}
	}
}
