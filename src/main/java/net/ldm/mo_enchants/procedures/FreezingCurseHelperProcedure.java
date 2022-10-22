package net.ldm.mo_enchants.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class FreezingCurseHelperProcedure {
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
		if ((new ResourceLocation("ice_spikes").equals(world.getBiome(new BlockPos(x, y, z)).value().getRegistryName())
				|| new ResourceLocation("frozen_ocean").equals(world.getBiome(new BlockPos(x, y, z)).value().getRegistryName())
				|| new ResourceLocation("frozen_river").equals(world.getBiome(new BlockPos(x, y, z)).value().getRegistryName()))
				&& (EnchantmentHelper.getItemEnchantmentLevel(MoEnchantsEnchantments.FREEZING_CURSE.get(),
						(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY)) != 0
						|| EnchantmentHelper.getItemEnchantmentLevel(MoEnchantsEnchantments.FREEZING_CURSE.get(),
								(entity instanceof LivingEntity _entGetArmor
										? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST)
										: ItemStack.EMPTY)) != 0
						|| EnchantmentHelper.getItemEnchantmentLevel(MoEnchantsEnchantments.FREEZING_CURSE.get(),
								(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY)) != 0
						|| EnchantmentHelper.getItemEnchantmentLevel(MoEnchantsEnchantments.FREEZING_CURSE.get(),
								(entity instanceof LivingEntity _entGetArmor
										? _entGetArmor.getItemBySlot(EquipmentSlot.FEET)
										: ItemStack.EMPTY)) != 0)) {
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 140, 1, (false), (false)));
		}
	}
}
