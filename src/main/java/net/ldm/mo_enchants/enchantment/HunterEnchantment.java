
package net.ldm.mo_enchants.enchantment;

import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;

public class HunterEnchantment extends Enchantment {
	public HunterEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.RARE, EnchantmentCategory.WEAPON, slots);
	}

	@Override
	public int getMaxLevel() {
		return 5;
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		if (ench == Enchantments.SHARPNESS)
			return false;
		if (ench == Enchantments.BANE_OF_ARTHROPODS)
			return false;
		if (ench == Enchantments.SMITE)
			return false;
		if (ench == MoEnchantsEnchantments.AQUA_SLASH.get())
			return false;
		return true;
	}
}
