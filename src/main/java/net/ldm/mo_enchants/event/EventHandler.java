package net.ldm.mo_enchants.event;

import net.ldm.mo_enchants.enchantment.helpers.*;
import net.minecraft.core.BlockPos;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class EventHandler {
    @SubscribeEvent
    public static void onEntityAttacked( LivingHurtEvent event) {
        if (event != null && event.getEntity() != null) {
            AngelsBlessingHelper.execute(event.getEntity().level, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getAmount());
            ConductionHelper.execute(event.getEntity().level, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getSource().getEntity());
            FreezingAspectHelper.execute(event.getEntity(), event.getSource().getEntity());
        }
    }

    @SubscribeEvent
    public static void onPlayerTick( TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            AquaphobiaCurseHelper.execute(event.player.level, event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
            SavingGraceHelper.execute(event, event.player.level, event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
            BoilingCurseHelper.execute(event.player.level, new BlockPos(event.player.getX(), event.player.getY(), event.player.getZ()), event.player);
            DensityCurseHelper.execute(event.player);
        }
    }

    @SubscribeEvent
    public static void onPlayerInBed( PlayerSleepInBedEvent event) {
        BadDreamsCurseHelper.execute(event.getEntity());
    }

    @SubscribeEvent
    public static void onRightClickItem( PlayerInteractEvent.RightClickItem event) {
        if (event.getHand() != event.getEntity().getUsedItemHand())
            return;
        BloodthirstHelper.execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
    }

    @SubscribeEvent
    public static void onBlockBreak( BlockEvent.BreakEvent event) {
        CarefulEnchantmentHelper.execute(event);
    }

    @SubscribeEvent
    public static void onEntityDeath( LivingDeathEvent event) {
        if (event != null && event.getEntity() != null) {
            DetonationHelper.execute(event.getEntity().level, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getSource().getEntity());
        }
    }
}