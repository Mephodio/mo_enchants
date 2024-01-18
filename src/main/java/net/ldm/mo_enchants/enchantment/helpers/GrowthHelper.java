package net.ldm.mo_enchants.enchantment.helpers;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;

import java.util.UUID;

public class GrowthHelper {
	private static final AttributeModifier growthEnchantmentLv1 = new AttributeModifier(UUID.fromString("4ff57341-51ff-4b44-a528-d667d28e6842"), "growthEnchantmentLv1", 1, AttributeModifier.Operation.ADDITION);
	private static final AttributeModifier growthEnchantmentLv2 = new AttributeModifier(UUID.fromString("86298a5e-7b75-486d-8aa6-ab7ac453b1ba"), "growthEnchantmentLv2", 2, AttributeModifier.Operation.ADDITION);
	private static final AttributeModifier growthEnchantmentLv3 = new AttributeModifier(UUID.fromString("9b4b6e29-3c81-45e6-99b0-34d970b06d64"), "growthEnchantmentLv3", 3, AttributeModifier.Operation.ADDITION);
	private static final AttributeModifier growthEnchantmentLv4 = new AttributeModifier(UUID.fromString("f77f759c-f31d-45ae-a877-395ad1ebc44b"), "growthEnchantmentLv4", 4, AttributeModifier.Operation.ADDITION);
	private static final AttributeModifier growthEnchantmentLv5 = new AttributeModifier(UUID.fromString("869f2f63-2ca6-4176-991d-74b4df2aa50f"), "growthEnchantmentLv5", 5, AttributeModifier.Operation.ADDITION);
	private static final AttributeModifier growthEnchantmentLv6 = new AttributeModifier(UUID.fromString("43b38a44-b323-4238-8d8f-58c286709f95"), "growthEnchantmentLv6", 6, AttributeModifier.Operation.ADDITION);
	private static final AttributeModifier growthEnchantmentLv7 = new AttributeModifier(UUID.fromString("e193a8b5-12cc-4186-82c8-4bedb83fb775"), "growthEnchantmentLv7", 7, AttributeModifier.Operation.ADDITION);
	private static final AttributeModifier growthEnchantmentLv8 = new AttributeModifier(UUID.fromString("7e88580f-f71d-4001-88b4-8ed5723653b4"), "growthEnchantmentLv8", 7, AttributeModifier.Operation.ADDITION);

	public static void execute(LivingEquipmentChangeEvent event) {
		if (event.getSlot().equals(EquipmentSlot.HEAD) || event.getSlot().equals(EquipmentSlot.CHEST) ||
				event.getSlot().equals(EquipmentSlot.LEGS) || event.getSlot().equals(EquipmentSlot.FEET)) {
			final AttributeInstance attributeInstance = event.getEntity().getAttributes().getInstance(Attributes.MAX_HEALTH);

			if (attributeInstance != null && event.getFrom().getEnchantmentTags().getAsString().contains("{id:\"mo_enchants:growth\",lvl:1s}") && attributeInstance.hasModifier(growthEnchantmentLv1)) {
				attributeInstance.removePermanentModifier(growthEnchantmentLv1.getId());
			}
			else if (attributeInstance != null && event.getFrom().getEnchantmentTags().getAsString().contains("{id:\"mo_enchants:growth\",lvl:2s}") && attributeInstance.hasModifier(growthEnchantmentLv2)) {
				attributeInstance.removePermanentModifier(growthEnchantmentLv2.getId());
			}
			else if (attributeInstance != null && event.getFrom().getEnchantmentTags().getAsString().contains("{id:\"mo_enchants:growth\",lvl:3s}") && attributeInstance.hasModifier(growthEnchantmentLv3)) {
				attributeInstance.removePermanentModifier(growthEnchantmentLv3.getId());
			}
			else if (attributeInstance != null && event.getFrom().getEnchantmentTags().getAsString().contains("{id:\"mo_enchants:growth\",lvl:4s}") && attributeInstance.hasModifier(growthEnchantmentLv4)) {
				attributeInstance.removePermanentModifier(growthEnchantmentLv4.getId());
			}
			else if (attributeInstance != null && event.getFrom().getEnchantmentTags().getAsString().contains("{id:\"mo_enchants:growth\",lvl:5s}") && attributeInstance.hasModifier(growthEnchantmentLv5)) {
				attributeInstance.removePermanentModifier(growthEnchantmentLv5.getId());
			}
			else if (attributeInstance != null && event.getFrom().getEnchantmentTags().getAsString().contains("{id:\"mo_enchants:growth\",lvl:6s}") && attributeInstance.hasModifier(growthEnchantmentLv6)) {
				attributeInstance.removePermanentModifier(growthEnchantmentLv6.getId());
			}
			else if (attributeInstance != null && event.getFrom().getEnchantmentTags().getAsString().contains("{id:\"mo_enchants:growth\",lvl:7s}") && attributeInstance.hasModifier(growthEnchantmentLv7)) {
				attributeInstance.removePermanentModifier(growthEnchantmentLv7.getId());
			}
			else if (attributeInstance != null && event.getFrom().getEnchantmentTags().getAsString().contains("{id:\"mo_enchants:growth\",lvl:8s}") && attributeInstance.hasModifier(growthEnchantmentLv8)) {
				attributeInstance.removePermanentModifier(growthEnchantmentLv8.getId());
			}

			if (attributeInstance != null && event.getTo().getEnchantmentTags().getAsString().contains("{id:\"mo_enchants:growth\",lvl:1s}") && !attributeInstance.hasModifier(growthEnchantmentLv1)) {
				attributeInstance.addPermanentModifier(growthEnchantmentLv1);
			}
			else if (attributeInstance != null && event.getTo().getEnchantmentTags().getAsString().contains("{id:\"mo_enchants:growth\",lvl:2s}") && !attributeInstance.hasModifier(growthEnchantmentLv2)) {
				attributeInstance.addPermanentModifier(growthEnchantmentLv2);
			}
			else if (attributeInstance != null && event.getTo().getEnchantmentTags().getAsString().contains("{id:\"mo_enchants:growth\",lvl:3s}") && !attributeInstance.hasModifier(growthEnchantmentLv3)) {
				attributeInstance.addPermanentModifier(growthEnchantmentLv3);
			}
			else if (attributeInstance != null && event.getTo().getEnchantmentTags().getAsString().contains("{id:\"mo_enchants:growth\",lvl:4s}") && !attributeInstance.hasModifier(growthEnchantmentLv4)) {
				attributeInstance.addPermanentModifier(growthEnchantmentLv4);
			}
			else if (attributeInstance != null && event.getTo().getEnchantmentTags().getAsString().contains("{id:\"mo_enchants:growth\",lvl:5s}") && !attributeInstance.hasModifier(growthEnchantmentLv5)) {
				attributeInstance.addPermanentModifier(growthEnchantmentLv5);
			}
			else if (attributeInstance != null && event.getTo().getEnchantmentTags().getAsString().contains("{id:\"mo_enchants:growth\",lvl:6s}") && !attributeInstance.hasModifier(growthEnchantmentLv6)) {
				attributeInstance.addPermanentModifier(growthEnchantmentLv6);
			}
			else if (attributeInstance != null && event.getTo().getEnchantmentTags().getAsString().contains("{id:\"mo_enchants:growth\",lvl:7s}") && !attributeInstance.hasModifier(growthEnchantmentLv7)) {
				attributeInstance.addPermanentModifier(growthEnchantmentLv7);
			}
			else if (attributeInstance != null && event.getTo().getEnchantmentTags().getAsString().contains("{id:\"mo_enchants:growth\",lvl:8s}") && !attributeInstance.hasModifier(growthEnchantmentLv8)) {
				attributeInstance.addPermanentModifier(growthEnchantmentLv8);
			}
		}
	}
}