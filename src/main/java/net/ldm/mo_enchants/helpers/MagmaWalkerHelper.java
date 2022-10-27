package net.ldm.mo_enchants.helpers;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.ldm.mo_enchants.init.MoEnchantsBlocks;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class MagmaWalkerHelper {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (EnchantmentHelper.getItemEnchantmentLevel(MoEnchantsEnchantments.MAGMA_WALKER.get(),
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY)) != 0) {
			if ((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.LAVA
					|| (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.LAVA) {
				world.setBlock(new BlockPos(x, y - 1, z), MoEnchantsBlocks.LIQUEFYING_MAGMA_BLOCK.get().defaultBlockState(), 3);
			} else if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.LAVA
					|| (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.LAVA) {
				world.setBlock(new BlockPos(x, y, z), MoEnchantsBlocks.LIQUEFYING_MAGMA_BLOCK.get().defaultBlockState(), 3);
				{
					Entity _ent = entity;
					_ent.teleportTo(x, (y + 1), z);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(x, (y + 1), z, _ent.getYRot(), _ent.getXRot());
				}
			}
		}
	}
}
