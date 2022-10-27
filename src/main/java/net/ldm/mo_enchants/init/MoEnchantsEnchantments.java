package net.ldm.mo_enchants.init;

import net.ldm.mo_enchants.enchantment.*;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.enchantment.Enchantment;

import net.ldm.mo_enchants.MoEnchantsMod;

public class MoEnchantsEnchantments {
	public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, MoEnchantsMod.MODID);
	public static final RegistryObject<Enchantment> HARMING_CURSE = REGISTRY.register("harming_curse", CurseOfHarmingEnchantment::new);
	public static final RegistryObject<Enchantment> ULTIMATE_FINISH = REGISTRY.register("ultimate_finish", UltimateFinishEnchantment::new);
	public static final RegistryObject<Enchantment> SCORCHING_CURSE = REGISTRY.register("scorching_curse", CurseOfScorchingEnchantment::new);
	public static final RegistryObject<Enchantment> VENOMFANG = REGISTRY.register("venomfang", ToxicAspectEnchantment::new);
	public static final RegistryObject<Enchantment> SMELTING_TOUCH = REGISTRY.register("smelting_touch", SmeltingTouchEnchantment::new);
	public static final RegistryObject<Enchantment> LIFE_STEAL = REGISTRY.register("life_steal", LifeStealEnchantment::new);
	public static final RegistryObject<Enchantment> FREEZING_ASPECT = REGISTRY.register("freezing_aspect", FreezingAspectEnchantment::new);
	public static final RegistryObject<Enchantment> LIFEFORCE_DISCHARGE_CURSE = REGISTRY.register("lifeforce_discharge_curse", LifeforceDischargeCurseEnchantment::new);
	public static final RegistryObject<Enchantment> PANIC = REGISTRY.register("panic", PanicEnchantment::new);
	public static final RegistryObject<Enchantment> CONDUCTION = REGISTRY.register("conduction", ConductionEnchantment::new);
	public static final RegistryObject<Enchantment> SAVING_GRACE = REGISTRY.register("saving_grace", SavingGraceEnchantment::new);
	public static final RegistryObject<Enchantment> FROST = REGISTRY.register("frost", FrostEnchantment::new);
	public static final RegistryObject<Enchantment> AQUA_SLASH = REGISTRY.register("aqua_slash", BonusDamageEnchantment::new);
	public static final RegistryObject<Enchantment> HUNTER = REGISTRY.register("hunter", BonusDamageEnchantment::new);
	public static final RegistryObject<Enchantment> SWIFTNESS = REGISTRY.register("swiftness", SwiftnessEnchantment::new);
	public static final RegistryObject<Enchantment> BOILING_CURSE = REGISTRY.register("boiling_curse", BoilingCurseEnchantment::new);
	public static final RegistryObject<Enchantment> FREEZING_CURSE = REGISTRY.register("freezing_curse", FreezingCurseEnchantment::new);
	public static final RegistryObject<Enchantment> BAD_DREAMS_CURSE = REGISTRY.register("bad_dreams_curse", BadDreamsCurseEnchantment::new);
	public static final RegistryObject<Enchantment> ANGELS_BLESSING = REGISTRY.register("angels_blessing", AngelsBlessingEnchantment::new);
	public static final RegistryObject<Enchantment> ROCK_MENDING = REGISTRY.register("rock_mending", RockMendingEnchantment::new);
	public static final RegistryObject<Enchantment> LEVITATING = REGISTRY.register("levitating", LevitatingEnchantment::new);
	public static final RegistryObject<Enchantment> DETONATION = REGISTRY.register("detonation", DetonationEnchantment::new);
	public static final RegistryObject<Enchantment> NIGHT_VISION = REGISTRY.register("night_vision", NightVisionEnchantment::new);
	public static final RegistryObject<Enchantment> AQUAPHOBIA_CURSE = REGISTRY.register("aquaphobia_curse", AquaphobiaCurseEnchantment::new);
	public static final RegistryObject<Enchantment> WEIGHTLESS = REGISTRY.register("weightless", WeightlessEnchantment::new);
	public static final RegistryObject<Enchantment> DENSITY_CURSE = REGISTRY.register("density_curse", DensityCurseEnchantment::new);
	public static final RegistryObject<Enchantment> REACH = REGISTRY.register("reach", ReachEnchantment::new);
	public static final RegistryObject<Enchantment> BLOODTHIRST = REGISTRY.register("bloodthirst", BloodthirstEnchantment::new);
	public static final RegistryObject<Enchantment> REVENANT = REGISTRY.register("revenant", RevenantEnchantment::new);
	public static final RegistryObject<Enchantment> MAGMA_WALKER = REGISTRY.register("magma_walker", MagmaWalkerEnchantment::new);
	public static final RegistryObject<Enchantment> FIRE_COATING = REGISTRY.register("fire_coating", FireCoatingEnchantment::new);
	public static final RegistryObject<Enchantment> GROWTH = REGISTRY.register("growth", GrowthEnchantment::new);
	public static final RegistryObject<Enchantment> DEVASTATION = REGISTRY.register("devastation", () -> new CriticalHitEnchantment(3));
	public static final RegistryObject<Enchantment> FIRST_STRIKE = REGISTRY.register("first_strike", () -> new CriticalHitEnchantment(1));
	public static final RegistryObject<Enchantment> CAREFUL = REGISTRY.register("careful", () -> new CarefulEnchantment(EquipmentSlot.MAINHAND));
}
