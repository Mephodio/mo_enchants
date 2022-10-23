package net.ldm.mo_enchants;

import net.ldm.mo_enchants.init.MoEnchantsBlocks;
import net.ldm.mo_enchants.init.MoEnchantsEnchantments;
import net.ldm.mo_enchants.init.MoEnchantsItems;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Mod("mo_enchants")
public class MoEnchantsMod {
	public static final Logger LOGGER = LogManager.getLogger(MoEnchantsMod.class);
	public static final String MODID = "mo_enchants";
	private static final String PROTOCOL_VERSION = "1";
	public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(new ResourceLocation(MODID, MODID), () -> PROTOCOL_VERSION,
			PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
	private static int messageID = 0;

	public MoEnchantsMod() {

		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		MoEnchantsBlocks.REGISTRY.register(bus);
		MoEnchantsItems.REGISTRY.register(bus);

		MoEnchantsEnchantments.REGISTRY.register(bus);

	}

	public static <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, T> decoder,
			BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
		PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
		messageID++;
	}
}
