
package net.ldm.mo_enchants.enchantment;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.item.enchantment.DamageEnchantment;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class BonusDamageEnchantment extends Enchantment {

	public BonusDamageEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.WEAPON, slots);
	}

	@Override
	public int getMaxLevel() {
		return 4;
	}

	@Override
	public boolean checkCompatibility( Enchantment ench ) {
		return !(ench instanceof DamageEnchantment || ench instanceof BonusDamageEnchantment);
	}
}
