package net.ldm.mo_enchants.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.ldm.mo_enchants.block.LiquefyingMagmaBlock;
import net.ldm.mo_enchants.MoEnchantsMod;

public class MoEnchantsBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, MoEnchantsMod.MODID);
	public static final RegistryObject<Block> LIQUEFYING_MAGMA_BLOCK = REGISTRY.register("liquefying_magma_block", LiquefyingMagmaBlock::new);
}
