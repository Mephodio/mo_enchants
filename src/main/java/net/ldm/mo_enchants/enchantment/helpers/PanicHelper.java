package net.ldm.mo_enchants.enchantment.helpers;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class PanicHelper {
	public static void execute(LevelAccessor world, LivingEntity entity, double x, double y, double z) {
		if (entity == null) return;
		if (EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.PANIC.get(), (entity.getItemBySlot(EquipmentSlot.FEET))) <= 0 || entity.getHealth() > 4) return;
		int enchLevel = EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.PANIC.get(), (entity.getItemBySlot(EquipmentSlot.FEET)));

		if (!entity.getPersistentData().getBoolean("panicEnchantmentCooldown")) {
			entity.getPersistentData().putBoolean("panicEnchantmentCooldown", true);

			// if not on cooldown - starts here
			entity.setHealth(5);
			entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, (enchLevel * 200), enchLevel));
			entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, (enchLevel * 150), enchLevel));
			if (entity instanceof ServerPlayer) {
				if (world.isClientSide())
					Minecraft.getInstance().gameRenderer.displayItemActivation(
							(entity.getItemBySlot(EquipmentSlot.FEET)));
			}
			ItemStack item = (entity.getItemBySlot(EquipmentSlot.FEET));
			if (item.hurt(15, RandomSource.create(), null)) {
				item.shrink(1);
				item.setDamageValue(0);
			}
			// if not on cooldown - ends here

			new Object() {
				private int ticks = 0;
				private float waitTicks;

				public void start(int waitTicks) {
					this.waitTicks = waitTicks;
					MinecraftForge.EVENT_BUS.register(this);
				}

				@SubscribeEvent
				public void tick( TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					entity.getPersistentData().putBoolean("panicEnchantmentCooldown", false);
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(200 / enchLevel);
		} else {
			if (entity instanceof Player player && !player.level.isClientSide())
				player.displayClientMessage(Component.translatable("cooldown.input", Component.translatable("enchantment.mo_enchants.panic")), true);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.enderman.teleport")),
							SoundSource.PLAYERS, 1, 0.5f);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.enderman.teleport")),
							SoundSource.PLAYERS, 1, 0.5f, false);
				}
			}
		}
	}
}