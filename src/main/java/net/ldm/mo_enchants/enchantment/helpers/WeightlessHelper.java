package net.ldm.mo_enchants.enchantment.helpers;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;

import java.util.UUID;

public class WeightlessHelper {
	private static final AttributeModifier weightlessEnchantmentLv1 = new AttributeModifier(UUID.fromString("2af7cbaa-5fbe-4e0b-99e0-b73c60da33d7"), "weightlessEnchantmentLv1", -0.01, AttributeModifier.Operation.ADDITION);
	private static final AttributeModifier weightlessEnchantmentLv2 = new AttributeModifier(UUID.fromString("c5cf8602-c4b3-4a3e-a785-3d9d3ac7b52e"), "weightlessEnchantmentLv2", -0.02, AttributeModifier.Operation.ADDITION);

	public static void execute(LivingEquipmentChangeEvent event) {
		if (event.getSlot().equals(EquipmentSlot.LEGS)) {
			final AttributeInstance attributeInstance = event.getEntity().getAttributes().getInstance(ForgeMod.ENTITY_GRAVITY.get());

			if (attributeInstance != null && event.getFrom().getEnchantmentTags().getAsString().contains("{id:\"mo_enchants:weightless\",lvl:1s}") && attributeInstance.hasModifier(weightlessEnchantmentLv1)) {
				attributeInstance.removePermanentModifier(weightlessEnchantmentLv1.getId());
			}
			else if (attributeInstance != null && event.getFrom().getEnchantmentTags().getAsString().contains("{id:\"mo_enchants:weightless\",lvl:2s}") && attributeInstance.hasModifier(weightlessEnchantmentLv2)) {
				attributeInstance.removePermanentModifier(weightlessEnchantmentLv2.getId());
			}

			if (attributeInstance != null && event.getTo().getEnchantmentTags().getAsString().contains("{id:\"mo_enchants:weightless\",lvl:1s}") && !attributeInstance.hasModifier(weightlessEnchantmentLv1)) {
				attributeInstance.addPermanentModifier(weightlessEnchantmentLv1);
			}
			else if (attributeInstance != null && event.getTo().getEnchantmentTags().getAsString().contains("{id:\"mo_enchants:weightless\",lvl:2s}") && !attributeInstance.hasModifier(weightlessEnchantmentLv2)) {
				attributeInstance.addPermanentModifier(weightlessEnchantmentLv2);
			}
		}
	}
}
