package net.ldm.mo_enchants.enchantment.helpers;

import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.core.BlockPos;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class SmeltingTouchHelper {
	public static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.SMELTING_TOUCH.get(),
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) > 0
				&& (world instanceof Level _lvlCanSmelt
						? _lvlCanSmelt.getRecipeManager()
								.getRecipeFor(RecipeType.SMELTING,
										new SimpleContainer((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))), _lvlCanSmelt)
								.isPresent()
						: false)) {
			world.levelEvent(2001, new BlockPos(x, y, z), Block.getId((world.getBlockState(new BlockPos(x, y, z)))));
			if (world instanceof Level _level && !_level.isClientSide()) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z,
						((world instanceof Level _lvlSmeltResult && _lvlSmeltResult.getRecipeManager().getRecipeFor(RecipeType.SMELTING,
								new SimpleContainer((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))), _lvlSmeltResult)
								.isPresent())
										? _lvlSmeltResult.getRecipeManager()
												.getRecipeFor(RecipeType.SMELTING,
														new SimpleContainer((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock()))),
														_lvlSmeltResult)
												.get().getResultItem().copy()
										: ItemStack.EMPTY));
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
			if (world instanceof Level _level && !_level.isClientSide())
				_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, (int) 0.8));
			world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
		}
	}
}