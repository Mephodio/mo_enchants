
package net.ldm.mo_enchants.enchantment;

import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;

public class ToxicAspectEnchantment extends Enchantment {
	public ToxicAspectEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.RARE, EnchantmentCategory.WEAPON, slots);
	}

	@Override
	public int getMaxLevel() {
		return 2;
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		if (ench == MoEnchantsEnchantments.FREEZING_ASPECT.get())
			return false;
		if (ench == Enchantments.FIRE_ASPECT)
			return false;
		if (ench == MoEnchantsEnchantments.LIFE_STEAL.get())
			return false;
		return true;
	}
}
