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
	private static final AttributeModifier swiftnessEnchantmentLv4 = new AttributeModifier(UUID.fromString("555e5f0d-8ff4-4759-9492-2bf9e45f46a4"), "swiftnessEnchantmentLv4", 0.04, AttributeModifier.Operation.ADDITION);
	private static final AttributeModifier swiftnessEnchantmentLv5 = new AttributeModifier(UUID.fromString("dd4b4090-fbcf-438c-bdad-be0e010e951f"), "swiftnessEnchantmentLv5", 0.05, AttributeModifier.Operation.ADDITION);
	private static final AttributeModifier swiftnessEnchantmentLv6 = new AttributeModifier(UUID.fromString("1e5a0d60-aa5d-42a7-a02b-73ef612b2b68"), "swiftnessEnchantmentLv6", 0.06, AttributeModifier.Operation.ADDITION);
	private static final AttributeModifier swiftnessEnchantmentLv7 = new AttributeModifier(UUID.fromString("d464dda3-1c63-45dd-9d62-80cc6c98328c"), "swiftnessEnchantmentLv7", 0.07, AttributeModifier.Operation.ADDITION);

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
			else if (attributeInstance != null && event.getFrom().getEnchantmentTags().getAsString().contains("{id:\"mo_enchants:swiftness\",lvl:4s}") && attributeInstance.hasModifier(swiftnessEnchantmentLv4)) {
				attributeInstance.removePermanentModifier(swiftnessEnchantmentLv4.getId());
			}
			else if (attributeInstance != null && event.getFrom().getEnchantmentTags().getAsString().contains("{id:\"mo_enchants:swiftness\",lvl:5s}") && attributeInstance.hasModifier(swiftnessEnchantmentLv5)) {
				attributeInstance.removePermanentModifier(swiftnessEnchantmentLv5.getId());
			}
			else if (attributeInstance != null && event.getFrom().getEnchantmentTags().getAsString().contains("{id:\"mo_enchants:swiftness\",lvl:6s}") && attributeInstance.hasModifier(swiftnessEnchantmentLv6)) {
				attributeInstance.removePermanentModifier(swiftnessEnchantmentLv6.getId());
			}
			else if (attributeInstance != null && event.getFrom().getEnchantmentTags().getAsString().contains("{id:\"mo_enchants:swiftness\",lvl:7s}") && attributeInstance.hasModifier(swiftnessEnchantmentLv7)) {
				attributeInstance.removePermanentModifier(swiftnessEnchantmentLv7.getId());
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
			else if (attributeInstance != null && event.getTo().getEnchantmentTags().getAsString().contains("{id:\"mo_enchants:swiftness\",lvl:4s}") && !attributeInstance.hasModifier(swiftnessEnchantmentLv4)) {
				attributeInstance.addPermanentModifier(swiftnessEnchantmentLv4);
			}
			else if (attributeInstance != null && event.getTo().getEnchantmentTags().getAsString().contains("{id:\"mo_enchants:swiftness\",lvl:5s}") && !attributeInstance.hasModifier(swiftnessEnchantmentLv5)) {
				attributeInstance.addPermanentModifier(swiftnessEnchantmentLv5);
			}
			else if (attributeInstance != null && event.getTo().getEnchantmentTags().getAsString().contains("{id:\"mo_enchants:swiftness\",lvl:6s}") && !attributeInstance.hasModifier(swiftnessEnchantmentLv6)) {
				attributeInstance.addPermanentModifier(swiftnessEnchantmentLv6);
			}
			else if (attributeInstance != null && event.getTo().getEnchantmentTags().getAsString().contains("{id:\"mo_enchants:swiftness\",lvl:7s}") && !attributeInstance.hasModifier(swiftnessEnchantmentLv7)) {
				attributeInstance.addPermanentModifier(swiftnessEnchantmentLv7);
			}
		}
	}
}
