package net.ldm.mo_enchants.enchantment;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.DamageEnchantment;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class CriticalHitEnchantment extends Enchantment {
    private final int maxLevel;
    public CriticalHitEnchantment(int maxLevel, EquipmentSlot... slots) {
        super(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.WEAPON, slots);
        this.maxLevel = maxLevel;
    }

    @Override
    public int getMaxLevel() {
        return this.maxLevel;
    }

    @Override
    public boolean checkCompatibility( Enchantment ench ) {
        return !(ench instanceof CriticalHitEnchantment);
    }
}
