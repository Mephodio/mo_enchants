package net.ldm.mo_enchants.procedures;

import net.ldm.mo_enchants.BiomeTags;
import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class BoilingCurseHelperProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event.player.level, new BlockPos(event.player.getX(), event.player.getY(), event.player.getZ()), event.player);
		}
	}

	private static void execute(LevelAccessor world, BlockPos pos, Player entity) {
		if (entity == null)
			return;
		Holder<Biome> biome = world.getBiome(pos);
		if ((biome.is(BiomeTags.IS_HOT) || entity.level.dimension() == Level.NETHER)
				&& (EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.BOILING_CURSE.get(), entity.getItemBySlot(EquipmentSlot.HEAD)) >= 1)
				|| (EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.BOILING_CURSE.get(), entity.getItemBySlot(EquipmentSlot.CHEST)) >= 1)
				|| (EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.BOILING_CURSE.get(), entity.getItemBySlot(EquipmentSlot.LEGS)) >= 1)
				|| (EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.BOILING_CURSE.get(), entity.getItemBySlot(EquipmentSlot.FEET)) >= 1)) {
			entity.setSecondsOnFire(3);
		}
	}
}
