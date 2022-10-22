
package net.ldm.mo_enchants.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;

public class DensityCurseEnchantment extends Enchantment {
	public DensityCurseEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.ARMOR, slots);
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		if (ench == MoEnchantsEnchantments.WEIGHTLESS.get())
			return false;
		return true;
	}

	@Override
	public boolean isTreasureOnly() {
		return true;
	}

	@Override
	public boolean isCurse() {
		return true;
	}

	@Override
	public boolean isTradeable() {
		return false;
	}
}
