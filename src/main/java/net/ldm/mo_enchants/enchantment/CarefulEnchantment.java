package net.ldm.mo_enchants.enchantment;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class CarefulEnchantment extends Enchantment {
    public CarefulEnchantment( EquipmentSlot... slots ) {
        super(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.BREAKABLE, slots);
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public boolean canApplyAtEnchantingTable( ItemStack stack) {
        return stack.getItem() instanceof HoeItem;
    }
}
