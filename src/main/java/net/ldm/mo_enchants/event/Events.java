package net.ldm.mo_enchants.event;

import net.ldm.mo_enchants.enchantment.helpers.*;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class Events {
    @SubscribeEvent
    public static void onEntityAttacked( LivingHurtEvent event) {
        if (event != null && event.getEntity() != null) {
            AngelsBlessingHelper.execute(event.getEntity().level, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getAmount());
        }
    }

    @SubscribeEvent
    public static void onPlayerTick( TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            SavingGraceHelper.execute(event, event.player.level, event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
        }
    }
}
