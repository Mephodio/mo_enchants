package net.ldm.mo_enchants.enchantment.helpers;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Map;

public class AngelsBlessingHelper {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double amount) {
		if (entity == null)
			return;
		double oldEnchLv;
		if (amount > (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.TOTEM_OF_UNDYING
					&& EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.ANGELS_BLESSING.get(),
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
				if (EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.ANGELS_BLESSING.get(),
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
					oldEnchLv = EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.ANGELS_BLESSING.get(),
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
					&& EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.ANGELS_BLESSING.get(),
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
				if (EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.ANGELS_BLESSING.get(),
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
					oldEnchLv = EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.ANGELS_BLESSING.get(),
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
