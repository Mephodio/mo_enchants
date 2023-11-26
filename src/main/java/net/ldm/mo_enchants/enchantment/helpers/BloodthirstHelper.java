package net.ldm.mo_enchants.enchantment.helpers;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
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

		if (entity.getLevel().getGameTime() - entity.getPersistentData().getLong("bloodthirstAbilityTriggerTime")
				> 240) {
			entity.getPersistentData().putLong("bloodthirstAbilityTriggerTime", entity.getLevel().getGameTime());

			if (entity instanceof LivingEntity livingEntity) {
				livingEntity.hurt(new DamageSource("enchantment.bloodthirst").bypassArmor(), 5);
				livingEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 240, EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.BLOODTHIRST.get(), livingEntity.getMainHandItem())));
				livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 240, 0));
				livingEntity.getUseItem().hurt(15, RandomSource.create(), null);
				livingEntity.getUseItem().shrink(1);
				livingEntity.getUseItem().setDamageValue(0);
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
		} else {
			if (entity instanceof Player player && !player.level.isClientSide())
				player.displayClientMessage(Component.translatable("cooldown.input", Component.translatable("enchantment.mo_enchants.bloodthirst")), true);
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
