
package net.ldm.mo_enchants.enchantment;

import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;

public class PanicEnchantment extends Enchantment {
	public PanicEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.RARE, EnchantmentCategory.ARMOR_FEET, slots);
	}

	@Override
	public int getMaxLevel() {
		return 2;
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		if (ench == MoEnchantsEnchantments.SWIFTNESS.get())
			return false;
		if (ench == Enchantments.SOUL_SPEED)
			return false;
		return true;
	}
}
