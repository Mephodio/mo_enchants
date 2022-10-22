
package net.ldm.mo_enchants.enchantment;

import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.EquipmentSlot;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;

public class LevitatingEnchantment extends Enchantment {
	public LevitatingEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.RARE, EnchantmentCategory.BREAKABLE, slots);
	}

	@Override
	public int getMaxLevel() {
		return 3;
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		if (ench == Enchantments.FLAMING_ARROWS)
			return false;
		if (ench == MoEnchantsEnchantments.FROST.get())
			return false;
		if (ench == MoEnchantsEnchantments.CONDUCTION.get())
			return false;
		if (ench == MoEnchantsEnchantments.DETONATION.get())
			return false;
		return true;
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		if (stack.getItem() == Items.BOW)
			return true;
		if (stack.getItem() == Items.CROSSBOW)
			return true;
		return false;
	}
}
