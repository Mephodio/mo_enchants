
package net.ldm.mo_enchants.enchantment;

import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;

public class FreezingAspectEnchantment extends Enchantment {
	public FreezingAspectEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.WEAPON, slots);
	}

	@Override
	public int getMaxLevel() {
		return 3;
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		if (ench == Enchantments.FIRE_ASPECT)
			return false;
		if (ench == MoEnchantsEnchantments.VENOMFANG.get())
			return false;
		if (ench == MoEnchantsEnchantments.LIFE_STEAL.get())
			return false;
		return true;
	}

	@Override
	public boolean isTradeable() {
		return false;
	}
}
