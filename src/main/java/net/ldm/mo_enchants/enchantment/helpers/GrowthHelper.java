package net.ldm.mo_enchants.enchantment.helpers;

import net.ldm.mo_enchants.MoEnchantsMod;
import net.ldm.mo_enchants.enchantment.GrowthEnchantment;
import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;

import java.util.UUID;

public class GrowthHelper {

	private static final UUID legacyUUIDs[] = {
			UUID.fromString("4ff57341-51ff-4b44-a528-d667d28e6842"),
			UUID.fromString("86298a5e-7b75-486d-8aa6-ab7ac453b1ba"),
			UUID.fromString("9b4b6e29-3c81-45e6-99b0-34d970b06d64"),
			UUID.fromString("f77f759c-f31d-45ae-a877-395ad1ebc44b")
	};
	private static final UUID slotHead = UUID.fromString("f8f4f00b-b4ad-4346-8650-2bfba7d901be");
	private static final UUID slotChest = UUID.fromString("f8ad0280-f369-4634-adbd-35efeca3ce2b");
	private static final UUID slotLegs = UUID.fromString("e921227b-c7c0-4111-9a76-167687231713");
	private static final UUID slotFeet = UUID.fromString("dacc8f05-61eb-4d51-a075-122008903cff");

	public static void execute(LivingEquipmentChangeEvent event) {
		EquipmentSlot slot = event.getSlot();
		if (slot.equals(EquipmentSlot.HEAD) || slot.equals(EquipmentSlot.CHEST) ||
				slot.equals(EquipmentSlot.LEGS) || slot.equals(EquipmentSlot.FEET)) {
			final AttributeInstance attributeInstance = event.getEntity().getAttributes().getInstance(Attributes.MAX_HEALTH);
			if (attributeInstance == null) return;

			for (UUID id : legacyUUIDs) {
                attributeInstance.removePermanentModifier(id);
			}

			int enchantmentLevel = EnchantmentHelper.getTagEnchantmentLevel(MoEnchantsEnchantments.GROWTH.get(), event.getTo());

			UUID slotUUID =  slot.equals(EquipmentSlot.HEAD) ? slotHead :
								slot.equals(EquipmentSlot.CHEST) ? slotChest :
								slot.equals(EquipmentSlot.LEGS) ? slotLegs : slotFeet;

			attributeInstance.removePermanentModifier(slotUUID);

			if (enchantmentLevel > 0) {
				AttributeModifier modifier = new AttributeModifier(slotUUID, "growthEnchantment", enchantmentLevel, AttributeModifier.Operation.ADDITION);
				attributeInstance.addPermanentModifier(modifier);
			}
		}
	}
}