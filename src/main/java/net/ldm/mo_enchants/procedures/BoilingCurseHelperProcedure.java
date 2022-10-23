package net.ldm.mo_enchants.procedures;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.Tags;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;

@Mod.EventBusSubscriber
public class BoilingCurseHelperProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event.player.level, new BlockPos(event.player.getX(), event.player.getY(), event.player.getZ()), event.player);
		}
	}

	private static void execute(LevelAccessor world, BlockPos pos, Entity entity) {
		if (entity == null)
			return;
		world.getBiome(pos).value();
		Holder<Biome> biome = world.getBiome(pos);
		if (biome.is(Tags.Biomes.IS_DRY) || biome.is(Tags.Biomes.IS_HOT) || entity.level.dimension() == Level.NETHER
				&& (EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.BOILING_CURSE.get(),
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY)) != 0
						|| EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.BOILING_CURSE.get(),
				(entity instanceof LivingEntity _entGetArmor
						? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST)
						: ItemStack.EMPTY)) != 0
						|| EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.BOILING_CURSE.get(),
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY)) != 0
						|| EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.BOILING_CURSE.get(),
				(entity instanceof LivingEntity _entGetArmor
						? _entGetArmor.getItemBySlot(EquipmentSlot.FEET)
						: ItemStack.EMPTY)) != 0)) {
			entity.setSecondsOnFire(3);
		}
	}
}
