package net.ldm.mo_enchants.enchantment.helpers;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;

import java.util.UUID;

public class DensityCurseHelper {
	private static final AttributeModifier densityCurse = new AttributeModifier(UUID.fromString("703bede5-84db-4991-bbe9-3ac943c68fff"), "densityCurse", 0.025, AttributeModifier.Operation.ADDITION);

	public static void execute(LivingEquipmentChangeEvent event) {
		if (event.getSlot().equals(EquipmentSlot.HEAD) || event.getSlot().equals(EquipmentSlot.CHEST) || event.getSlot().equals(EquipmentSlot.LEGS) || event.getSlot().equals(EquipmentSlot.FEET)) {
			final AttributeInstance attributeInstance = event.getEntity().getAttributes().getInstance(ForgeMod.ENTITY_GRAVITY.get());

			if (attributeInstance != null && event.getFrom().getEnchantmentTags().getAsString().contains("{id:\"mo_enchants:density_curse\",lvl:1s}") && attributeInstance.hasModifier(densityCurse)) {
				attributeInstance.removePermanentModifier(densityCurse.getId());
			}

			if (attributeInstance != null && event.getTo().getEnchantmentTags().getAsString().contains("{id:\"mo_enchants:density_curse\",lvl:1s}") && !attributeInstance.hasModifier(densityCurse)) {
				attributeInstance.addPermanentModifier(densityCurse);
			}
		}
	}
}
