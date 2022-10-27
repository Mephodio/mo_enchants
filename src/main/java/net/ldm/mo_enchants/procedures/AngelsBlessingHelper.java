package net.ldm.mo_enchants.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;

import javax.annotation.Nullable;

import java.util.Map;

@Mod.EventBusSubscriber
public class AngelsBlessingHelper {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(),
					event.getAmount());
		}
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, double amount) {
		if (entity == null)
			return;
		double oldEnchLv = 0;
		if (amount > (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.TOTEM_OF_UNDYING
					&& EnchantmentHelper.getItemEnchantmentLevel(MoEnchantsEnchantments.ANGELS_BLESSING.get(),
							(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
				if (entity instanceof LivingEntity livingEntity) {
					livingEntity.setHealth(1);
					livingEntity.removeAllEffects();
					livingEntity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 900, 1));
					livingEntity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 100, 1));
					livingEntity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 800, 0));
				}
				TotemlikeAnimationMainhandProcedure.execute(world, entity);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.totem.use")),
								SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.totem.use")),
								SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (EnchantmentHelper.getItemEnchantmentLevel(MoEnchantsEnchantments.ANGELS_BLESSING.get(),
						(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) == 1) {
					{
						Map<Enchantment, Integer> _enchantments = EnchantmentHelper
								.getEnchantments((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY));
						if (_enchantments.containsKey(MoEnchantsEnchantments.ANGELS_BLESSING.get())) {
							_enchantments.remove(MoEnchantsEnchantments.ANGELS_BLESSING.get());
							EnchantmentHelper.setEnchantments(_enchantments,
									(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY));
						}
					}
				} else {
					oldEnchLv = EnchantmentHelper.getItemEnchantmentLevel(MoEnchantsEnchantments.ANGELS_BLESSING.get(),
							(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY));
					{
						Map<Enchantment, Integer> _enchantments = EnchantmentHelper
								.getEnchantments((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY));
						if (_enchantments.containsKey(MoEnchantsEnchantments.ANGELS_BLESSING.get())) {
							_enchantments.remove(MoEnchantsEnchantments.ANGELS_BLESSING.get());
							EnchantmentHelper.setEnchantments(_enchantments,
									(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY));
						}
					}
					((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))
							.enchant(MoEnchantsEnchantments.ANGELS_BLESSING.get(), (int) (oldEnchLv - 1));
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Items.TOTEM_OF_UNDYING
					&& EnchantmentHelper.getItemEnchantmentLevel(MoEnchantsEnchantments.ANGELS_BLESSING.get(),
							(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY)) != 0) {
				if (entity instanceof LivingEntity livingEntity) {
					livingEntity.setHealth(1);
					livingEntity.removeAllEffects();
					livingEntity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 900, 1));
					livingEntity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 100, 1));
					livingEntity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 800, 0));
				}
				TotemlikeAnimationOffhandProcedure.execute(world, entity);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.totem.use")),
								SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.totem.use")),
								SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (EnchantmentHelper.getItemEnchantmentLevel(MoEnchantsEnchantments.ANGELS_BLESSING.get(),
						(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY)) == 1) {
					{
						Map<Enchantment, Integer> _enchantments = EnchantmentHelper
								.getEnchantments((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY));
						if (_enchantments.containsKey(MoEnchantsEnchantments.ANGELS_BLESSING.get())) {
							_enchantments.remove(MoEnchantsEnchantments.ANGELS_BLESSING.get());
							EnchantmentHelper.setEnchantments(_enchantments,
									(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY));
						}
					}
				} else {
					oldEnchLv = EnchantmentHelper.getItemEnchantmentLevel(MoEnchantsEnchantments.ANGELS_BLESSING.get(),
							(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY));
					{
						Map<Enchantment, Integer> _enchantments = EnchantmentHelper
								.getEnchantments((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY));
						if (_enchantments.containsKey(MoEnchantsEnchantments.ANGELS_BLESSING.get())) {
							_enchantments.remove(MoEnchantsEnchantments.ANGELS_BLESSING.get());
							EnchantmentHelper.setEnchantments(_enchantments,
									(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY));
						}
					}
					((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY))
							.enchant(MoEnchantsEnchantments.ANGELS_BLESSING.get(), (int) (oldEnchLv - 1));
				}
			}
		}
	}
}
