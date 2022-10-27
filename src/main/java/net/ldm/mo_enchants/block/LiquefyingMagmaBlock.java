
package net.ldm.mo_enchants.block;

import net.ldm.mo_enchants.enchantment.helpers.LiquefyingMagmaBlockAddedProcedure;
import net.ldm.mo_enchants.enchantment.helpers.LiquefyingMagmaBlockDestroyedProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.HitResult;

public class LiquefyingMagmaBlock extends Block {
	public LiquefyingMagmaBlock() {
		super(Properties.of(Material.STONE).sound(SoundType.STONE).strength(0.5f, 0f).lightLevel(s -> 3).requiresCorrectToolForDrops()
				.hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).noLootTable());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter world, BlockPos pos, Player player) {
		return new ItemStack(Blocks.MAGMA_BLOCK);
	}

	@Override
	public boolean canHarvestBlock(BlockState state, BlockGetter world, BlockPos pos, Player player) {
		if (player.getInventory().getSelected().getItem() instanceof TieredItem tieredItem)
			return tieredItem.getTier().getLevel() >= 1;
		return false;
	}

	@Override
	public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
		super.onPlace(blockstate, world, pos, oldState, moving);
		LiquefyingMagmaBlockAddedProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public boolean onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
		boolean returnValue = super.onDestroyedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
		LiquefyingMagmaBlockDestroyedProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
		return returnValue;
	}
}
