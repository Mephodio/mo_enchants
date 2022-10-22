
package net.ldm.mo_enchants.enchantment;

import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.EquipmentSlot;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;

public class ConductionEnchantment extends Enchantment {
	public ConductionEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.RARE, EnchantmentCategory.BOW, slots);
	}

	@Override
	protected boolean checkCompatibility(Enchantment ench) {
		if (ench == Enchantments.FLAMING_ARROWS)
			return false;
		if (ench == MoEnchantsEnchantments.FROST.get())
			return false;
		if (ench == MoEnchantsEnchantments.LEVITATING.get())
			return false;
		return ench != MoEnchantsEnchantments.DETONATION.get();
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		return stack.getItem() instanceof CrossbowItem || stack.getItem() instanceof BowItem;
	}

	@Override
	public boolean isTradeable() {
		return false;
	}
}
