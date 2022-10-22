
package net.ldm.mo_enchants.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;

public class UltimateFinishEnchantment extends Enchantment {
	public UltimateFinishEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.WEAPON, slots);
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		if (ench == MoEnchantsEnchantments.LIFE_STEAL.get())
			return false;
		if (ench == MoEnchantsEnchantments.REVENANT.get())
			return false;
		return true;
	}

	@Override
	public boolean isTradeable() {
		return false;
	}
}
