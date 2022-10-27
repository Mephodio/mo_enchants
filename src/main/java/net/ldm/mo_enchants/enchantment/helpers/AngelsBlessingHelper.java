package net.ldm.mo_enchants.enchantment.helpers;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.client.Minecraft;
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
	public static void execute(LevelAccessor world, double x, double y, double z, Entity rawEntity, double amount) {
		if (!(rawEntity instanceof LivingEntity entity) || amount < entity.getHealth()) return;

		if (entity.getMainHandItem().getItem() == Items.TOTEM_OF_UNDYING && EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.ANGELS_BLESSING.get(), entity.getMainHandItem()) >= 1) {
			entity.setHealth(1);
			entity.removeAllEffects();
			entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 900, 1));
			entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 100, 1));
			entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 800, 0));
			totemAnimation(world, entity, false);

			if (world instanceof Level level) {
				if (!level.isClientSide()) {
					level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.totem.use")),
							SoundSource.NEUTRAL, 1, 1);
				} else {
					level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.totem.use")),
							SoundSource.NEUTRAL, 1, 1, false);
				}
			}

			if (EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.ANGELS_BLESSING.get(), entity.getMainHandItem()) == 1) {
				Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(entity.getMainHandItem());
				if (enchantments.containsKey(MoEnchantsEnchantments.ANGELS_BLESSING.get())) {
					enchantments.remove(MoEnchantsEnchantments.ANGELS_BLESSING.get());
					EnchantmentHelper.setEnchantments(enchantments, entity.getMainHandItem());
				}
			} else {
				int oldEnchLv = EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.ANGELS_BLESSING.get(), entity.getMainHandItem());
				Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(entity.getMainHandItem());
				if (enchantments.containsKey(MoEnchantsEnchantments.ANGELS_BLESSING.get())) {
					enchantments.remove(MoEnchantsEnchantments.ANGELS_BLESSING.get());
					EnchantmentHelper.setEnchantments(enchantments, entity.getMainHandItem());
				}
				entity.getMainHandItem().enchant(MoEnchantsEnchantments.ANGELS_BLESSING.get(), oldEnchLv - 1);
			}
		} else if (entity.getOffhandItem().getItem() == Items.TOTEM_OF_UNDYING && EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.ANGELS_BLESSING.get(), entity.getOffhandItem()) >= 1) {
			entity.setHealth(1);
			entity.removeAllEffects();
			entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 900, 1));
			entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 100, 1));
			entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 800, 0));
			totemAnimation(world, entity, true);

			if (world instanceof Level level) {
				if (!level.isClientSide()) {
					level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.totem.use")),
							SoundSource.NEUTRAL, 1, 1);
				} else {
					level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.totem.use")),
							SoundSource.NEUTRAL, 1, 1, false);
				}
			}

			if (EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.ANGELS_BLESSING.get(), entity.getOffhandItem()) == 1) {
				Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(entity.getOffhandItem());
				if (enchantments.containsKey(MoEnchantsEnchantments.ANGELS_BLESSING.get())) {
					enchantments.remove(MoEnchantsEnchantments.ANGELS_BLESSING.get());
					EnchantmentHelper.setEnchantments(enchantments, entity.getOffhandItem());
				}
			} else {
				int oldEnchLv = EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.ANGELS_BLESSING.get(), entity.getOffhandItem());
				Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(entity.getOffhandItem());
				if (enchantments.containsKey(MoEnchantsEnchantments.ANGELS_BLESSING.get())) {
					enchantments.remove(MoEnchantsEnchantments.ANGELS_BLESSING.get());
					EnchantmentHelper.setEnchantments(enchantments, entity.getOffhandItem());
				}
				entity.getOffhandItem().enchant(MoEnchantsEnchantments.ANGELS_BLESSING.get(), oldEnchLv - 1);
			}
		}
	}

	private static void totemAnimation(LevelAccessor world, Entity entity, boolean getFromOffHand) {
		if (entity == null) return;
		if (world.isClientSide())
			if (getFromOffHand)
				Minecraft.getInstance().gameRenderer.displayItemActivation((entity instanceof LivingEntity livingEntity ? livingEntity.getOffhandItem() : ItemStack.EMPTY));
			else
				Minecraft.getInstance().gameRenderer.displayItemActivation((entity instanceof LivingEntity livingEntity ? livingEntity.getMainHandItem() : ItemStack.EMPTY));
	}
}
