package net.ldm.mo_enchants.procedures;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.UUID;

@Mod.EventBusSubscriber
public class ReachHelperProcedure {
	private static final AttributeModifier reachEnchantmentLv1 = new AttributeModifier(UUID.fromString("9964fc09-999f-47a5-bf38-76f714fb447c"), "reachEnchantmentLv1", 1, AttributeModifier.Operation.ADDITION);
	private static final AttributeModifier reachEnchantmentLv2 = new AttributeModifier(UUID.fromString("3b027877-2a5d-4ca2-bbbc-1dfff5386c12"), "reachEnchantmentLv2", 2, AttributeModifier.Operation.ADDITION);
	private static final AttributeModifier reachEnchantmentLv3 = new AttributeModifier(UUID.fromString("cc16cf93-9913-4026-8722-d5232c27bdee"), "reachEnchantmentLv3", 3, AttributeModifier.Operation.ADDITION);

	@SubscribeEvent
	public static void onEquipmentChange( LivingEquipmentChangeEvent event) {
		if (event.getSlot().equals(EquipmentSlot.MAINHAND)) {
			final AttributeInstance attributeInstance = event.getEntity().getAttributes().getInstance(ForgeMod.REACH_DISTANCE.get());

			if (attributeInstance != null && event.getTo().getEnchantmentTags().getAsString().contains("{id:\"mo_enchants:reach\",lvl:1s}") && !attributeInstance.hasModifier(reachEnchantmentLv1)) {
				attributeInstance.addPermanentModifier(reachEnchantmentLv1);
			}

			if (attributeInstance != null && event.getFrom().getEnchantmentTags().getAsString().contains("{id:\"mo_enchants:reach\",lvl:1s}") && attributeInstance.hasModifier(reachEnchantmentLv1)) {
				attributeInstance.removePermanentModifier(UUID.fromString("9964fc09-999f-47a5-bf38-76f714fb447c"));
			}

			if (attributeInstance != null && event.getTo().getEnchantmentTags().getAsString().contains("{id:\"mo_enchants:reach\",lvl:2s}") && !attributeInstance.hasModifier(reachEnchantmentLv2)) {
				attributeInstance.addPermanentModifier(reachEnchantmentLv2);
			}

			if (attributeInstance != null && event.getFrom().getEnchantmentTags().getAsString().contains("{id:\"mo_enchants:reach\",lvl:2s}") && attributeInstance.hasModifier(reachEnchantmentLv2)) {
				attributeInstance.removePermanentModifier(UUID.fromString("3b027877-2a5d-4ca2-bbbc-1dfff5386c12"));
			}

			if (attributeInstance != null && event.getTo().getEnchantmentTags().getAsString().contains("{id:\"mo_enchants:reach\",lvl:3s}") && !attributeInstance.hasModifier(reachEnchantmentLv3)) {
				attributeInstance.addPermanentModifier(reachEnchantmentLv3);
			}

			if (attributeInstance != null && event.getFrom().getEnchantmentTags().getAsString().contains("{id:\"mo_enchants:reach\",lvl:3s}") && attributeInstance.hasModifier(reachEnchantmentLv3)) {
				attributeInstance.removePermanentModifier(UUID.fromString("cc16cf93-9913-4026-8722-d5232c27bdee"));
			}
		}
	}
}
