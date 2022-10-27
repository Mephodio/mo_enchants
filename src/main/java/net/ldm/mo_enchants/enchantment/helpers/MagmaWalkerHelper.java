package net.ldm.mo_enchants.enchantment.helpers;

import net.ldm.mo_enchants.init.MoEnchantsBlocks;
import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;

public class MagmaWalkerHelper {
	public static void execute( LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.MAGMA_WALKER.get(),
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY)) != 0) {
			if ((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.LAVA
					|| (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.LAVA) {
				world.setBlock(new BlockPos(x, y - 1, z), MoEnchantsBlocks.LIQUEFYING_MAGMA_BLOCK.get().defaultBlockState(), 3);
			} else if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.LAVA
					|| (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.LAVA) {
				world.setBlock(new BlockPos(x, y, z), MoEnchantsBlocks.LIQUEFYING_MAGMA_BLOCK.get().defaultBlockState(), 3);
				{
					entity.teleportTo(x, (y + 1), z);
					if (entity instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(x, (y + 1), z, entity.getYRot(), entity.getXRot());
				}
			}
		}
	}
}