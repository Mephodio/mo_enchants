package net.ldm.mo_enchants.enchantment.helpers;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
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

public class BloodthirstHelper {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null) return;
		if (EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.BLOODTHIRST.get(), (entity instanceof LivingEntity livingEntity ? livingEntity.getMainHandItem() : ItemStack.EMPTY)) <= 0) return;

		if (!entity.getPersistentData().getBoolean("bloodthirstAbilityCooldown")) {
			entity.getPersistentData().putBoolean("bloodthirstAbilityCooldown", true);

			// if not on cooldown - starts here
			if (entity instanceof LivingEntity livingEntity) {
				livingEntity.hurt(new DamageSource("enchantment.bloodthirst").bypassArmor(), 5);
				livingEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 240, EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.BLOODTHIRST.get(), livingEntity.getMainHandItem())));
				livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 240, 0));
			}

			if (world instanceof Level level) {
				if (!level.isClientSide()) {
					level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.knockback")),
							SoundSource.PLAYERS, 1, 0.8f);
				} else {
					level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.knockback")),
							SoundSource.PLAYERS, 1, 0.8f, false);
				}
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
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					entity.getPersistentData().putBoolean("bloodthirstAbilityCooldown", false);
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(240);
		} else {
			if (entity instanceof Player player && !player.level.isClientSide())
				player.displayClientMessage(Component.translatable("cooldown.input", Component.literal("Bloodthirst")), true);
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
