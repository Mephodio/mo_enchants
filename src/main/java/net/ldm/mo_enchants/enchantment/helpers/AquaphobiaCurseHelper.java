package net.ldm.mo_enchants.enchantment.helpers;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import javax.annotation.Nullable;

public class AquaphobiaCurseHelper {
	public static void execute( LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (((world.getBlockState(new BlockPos(x, y, z))).getBlock() instanceof LiquidBlock _liquid
				? new ItemStack(_liquid.getFluid().getBucket())
				: ItemStack.EMPTY).getItem() == Items.WATER_BUCKET
				&& (EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.AQUAPHOBIA_CURSE.get(),
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY)) != 0
						|| EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.AQUAPHOBIA_CURSE.get(),
				(entity instanceof LivingEntity _entGetArmor
						? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST)
						: ItemStack.EMPTY)) != 0
						|| EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.AQUAPHOBIA_CURSE.get(),
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY)) != 0
						|| EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.AQUAPHOBIA_CURSE.get(),
				(entity instanceof LivingEntity _entGetArmor
						? _entGetArmor.getItemBySlot(EquipmentSlot.FEET)
						: ItemStack.EMPTY)) != 0)) {
			if (!entity.getPersistentData().getBoolean("aquaphobiaDamageCooldown")) {
				if (entity instanceof LivingEntity _entity)
					_entity.hurt(new DamageSource("curse.aquaphobia").bypassArmor(), 1);
				entity.getPersistentData().putBoolean("aquaphobiaDamageCooldown", (true));
			} else {
				new Object() {
					private int ticks = 0;
					private float waitTicks;
					private LevelAccessor world;

					public void start(LevelAccessor world, int waitTicks) {
						this.waitTicks = waitTicks;
						MinecraftForge.EVENT_BUS.register(this);
						this.world = world;
					}

					@SubscribeEvent
					public void tick(TickEvent.ServerTickEvent event) {
						if (event.phase == TickEvent.Phase.END) {
							this.ticks += 1;
							if (this.ticks >= this.waitTicks)
								run();
						}
					}

					private void run() {
						entity.getPersistentData().putBoolean("aquaphobiaDamageCooldown", (false));
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, 10);
			}
		}
	}
}
