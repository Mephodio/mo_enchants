package net.ldm.mo_enchants.enchantment.helpers;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class ScorchingCurseHelper {
	public static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.SCORCHING_CURSE.get(),
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY)) > 0
				|| EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.SCORCHING_CURSE.get(),
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY)) > 0
				|| EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.SCORCHING_CURSE.get(),
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY)) > 0
				|| EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.SCORCHING_CURSE.get(),
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY)) > 0) {
			entity.setSecondsOnFire(5);
		}
	}
}