package net.ldm.mo_enchants.helpers;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.block.CropBlock;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class CarefulEnchantmentHelper {
    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
       if (EnchantmentHelper.getEnchantmentLevel(MoEnchantsEnchantments.CAREFUL.get(), event.getPlayer()) >= 1 &&
                event.getState().is(BlockTags.create(new ResourceLocation("mo_enchants", "ungrown_crops"))) &&
               event.getState().getBlock() instanceof CropBlock && event.getState().getValue(CropBlock.AGE) <= 6) {
            event.setCanceled(true);
        }
    }
}