package net.ldm.mo_enchants.enchantment.helpers;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;

import java.util.UUID;

public class SwiftnessHelper {
	private static final AttributeModifier swiftnessEnchantmentLv1 = new AttributeModifier(UUID.fromString("7a738a54-6d1f-423d-ba6d-282c405c46ea"), "swiftnessEnchantmentLv1", 0.01, AttributeModifier.Operation.ADDITION);
	private static final AttributeModifier swiftnessEnchantmentLv2 = new AttributeModifier(UUID.fromString("430f19d0-3003-462d-a368-a7657ce2e34a"), "swiftnessEnchantmentLv2", 0.02, AttributeModifier.Operation.ADDITION);
	private static final AttributeModifier swiftnessEnchantmentLv3 = new AttributeModifier(UUID.fromString("af804924-997d-42df-b85b-aa58553fb127"), "swiftnessEnchantmentLv3", 0.03, AttributeModifier.Operation.ADDITION);

	public static void execute(LivingEquipmentChangeEvent event) {
		if (event.getSlot().equals(EquipmentSlot.FEET)) {
			final AttributeInstance attributeInstance = event.getEntity().getAttributes().getInstance(Attributes.MOVEMENT_SPEED);

			if (attributeInstance != null && event.getFrom().getEnchantmentTags().getAsString().contains("{id:\"mo_enchants:swiftness\",lvl:1s}") && attributeInstance.hasModifier(swiftnessEnchantmentLv1)) {
				attributeInstance.removePermanentModifier(swiftnessEnchantmentLv1.getId());
			}
			else if (attributeInstance != null && event.getFrom().getEnchantmentTags().getAsString().contains("{id:\"mo_enchants:swiftness\",lvl:2s}") && attributeInstance.hasModifier(swiftnessEnchantmentLv2)) {
				attributeInstance.removePermanentModifier(swiftnessEnchantmentLv2.getId());
			}
			else if (attributeInstance != null && event.getFrom().getEnchantmentTags().getAsString().contains("{id:\"mo_enchants:swiftness\",lvl:3s}") && attributeInstance.hasModifier(swiftnessEnchantmentLv3)) {
				attributeInstance.removePermanentModifier(swiftnessEnchantmentLv3.getId());
			}

			if (attributeInstance != null && event.getTo().getEnchantmentTags().getAsString().contains("{id:\"mo_enchants:swiftness\",lvl:1s}") && !attributeInstance.hasModifier(swiftnessEnchantmentLv1)) {
				attributeInstance.addPermanentModifier(swiftnessEnchantmentLv1);
			}
			else if (attributeInstance != null && event.getTo().getEnchantmentTags().getAsString().contains("{id:\"mo_enchants:swiftness\",lvl:2s}") && !attributeInstance.hasModifier(swiftnessEnchantmentLv2)) {
				attributeInstance.addPermanentModifier(swiftnessEnchantmentLv2);
			}
			else if (attributeInstance != null && event.getTo().getEnchantmentTags().getAsString().contains("{id:\"mo_enchants:swiftness\",lvl:3s}") && !attributeInstance.hasModifier(swiftnessEnchantmentLv3)) {
				attributeInstance.addPermanentModifier(swiftnessEnchantmentLv3);
			}
		}
	}
}
