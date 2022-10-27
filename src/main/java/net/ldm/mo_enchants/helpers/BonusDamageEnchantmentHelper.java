package net.ldm.mo_enchants.helpers;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.MagmaCube;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber
public class BonusDamageEnchantmentHelper {
	@SubscribeEvent
	public static void onLivingDamage( LivingDamageEvent event ) {
		if (event.getEntity() instanceof Animal && event.getSource().getEntity() != null &&
				event.getSource().getEntity() instanceof LivingEntity attacker) {
			if (EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.HUNTER.get(), attacker.getMainHandItem()) >= 1) {
				event.setAmount((float) (event.getAmount() + EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.AQUA_SLASH.get(), attacker.getMainHandItem()) * 2.5));
			}
			return;
		}

		if (event.getEntity().getHealth() == event.getEntity().getMaxHealth() && event.getSource().getEntity() != null &&
				event.getSource().getEntity() instanceof LivingEntity attacker) {
			if (EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.FIRST_STRIKE.get(), attacker.getMainHandItem()) >= 1) {
				event.setAmount((float) (event.getAmount() * 1.25));
				Level level = event.getSource().getEntity().getLevel();
				float x = (float) event.getSource().getEntity().getX();
				float y = (float) event.getSource().getEntity().getY();
				float z = (float) event.getSource().getEntity().getZ();
				if (!level.isClientSide()) {
					level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.trident.throw")),
							SoundSource.PLAYERS, 1, 2);
				} else {
					level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.trident.throw")), SoundSource.PLAYERS, 1, 2, false);
				}
			}
		}

		if (event.getSource().getEntity() != null && event.getSource().getEntity() instanceof LivingEntity attacker) {
			if (EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.DEVASTATION.get(), attacker.getMainHandItem()) >= 1 &&
					Math.random() >= 0.1* EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.DEVASTATION.get(), attacker.getMainHandItem())) {
				event.setAmount((float) (event.getAmount() *1.5));
				Level level = event.getSource().getEntity().getLevel();
				float x = (float) event.getSource().getEntity().getX();
				float y = (float) event.getSource().getEntity().getY();
				float z = (float) event.getSource().getEntity().getZ();
				if (!level.isClientSide()) {
					level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.trident.throw")),
							SoundSource.PLAYERS, 1, 2);
				} else {
					level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.trident.throw")), SoundSource.PLAYERS, 1, 2, false);
				}
			}
		}

		if (event.getEntity() instanceof EnderMan || event.getEntity() instanceof Blaze ||
				event.getEntity() instanceof MagmaCube && event.getSource().getEntity() != null &&
						event.getSource().getEntity() instanceof LivingEntity) {
			LivingEntity attacker = (LivingEntity) event.getSource().getEntity();
			if (EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.AQUA_SLASH.get(), attacker.getMainHandItem()) >= 1) {
				event.setAmount((float) (event.getAmount() + EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.AQUA_SLASH.get(), attacker.getMainHandItem()) * 2.5));
			}
		}
	}
}
