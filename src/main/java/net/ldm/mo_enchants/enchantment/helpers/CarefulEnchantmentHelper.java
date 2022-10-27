package net.ldm.mo_enchants.enchantment.helpers;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.block.CropBlock;
import net.minecraftforge.event.level.BlockEvent;

import javax.annotation.Nullable;

public class CarefulEnchantmentHelper {
    public static void execute(@Nullable BlockEvent.BreakEvent event) {
        if (EnchantmentHelper.getEnchantmentLevel(MoEnchantsEnchantments.CAREFUL.get(), event.getPlayer()) >= 1 &&
                event.getState().is(BlockTags.create(new ResourceLocation("mo_enchants", "ungrown_crops"))) &&
                event.getState().getBlock() instanceof CropBlock && event.getState().getValue(CropBlock.AGE) <= 6) {
            event.setCanceled(true);
        }
    }
}