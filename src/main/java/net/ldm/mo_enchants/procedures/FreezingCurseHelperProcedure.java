package net.ldm.mo_enchants.procedures;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.BlockPos;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;

@Mod.EventBusSubscriber
public class FreezingCurseHelperProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event.player.level, new BlockPos(event.player.getX(), event.player.getY(), event.player.getZ()), event.player);
		}
	}

	static TagKey<Biome> IS_FROZEN = TagKey.create(Registry.BIOME_REGISTRY, new ResourceLocation("mo_enchants", "is_frozen"));

	private static void execute(LevelAccessor world, BlockPos pos, Entity entity) {
		if (entity == null)
			return;
		Holder<Biome> biome = world.getBiome(pos);
		if (biome.is(IS_FROZEN) && (EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.FREEZING_CURSE.get(),
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY)) == 0
				&& EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.FREEZING_CURSE.get(),
				(entity instanceof LivingEntity _entGetArmor
						? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST)
						: ItemStack.EMPTY)) == 0 && EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.FREEZING_CURSE.get(),
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY)) == 0)) {
			EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.FREEZING_CURSE.get(),
					(entity instanceof LivingEntity _entGetArmor
							? _entGetArmor.getItemBySlot(EquipmentSlot.FEET)
							: ItemStack.EMPTY));
		} {
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 140, 1, (false), (false)));
		}
	}
}
