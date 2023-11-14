package net.neoforged.neoforge.network.registration.registrar;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.ConfigurationPayloadContext;
import net.neoforged.neoforge.network.handling.IConfigurationPayloadHandler;
import net.neoforged.neoforge.network.reading.IPayloadReader;
import net.neoforged.neoforge.network.reading.PayloadReadingContext;

import java.util.Optional;
import java.util.OptionalInt;

public record ConfigurationRegistration<T extends CustomPacketPayload>(
        IPayloadReader<T> reader,
        IConfigurationPayloadHandler<T> handler,
        OptionalInt version,
        OptionalInt minVersion,
        OptionalInt maxVersion,
        Optional<PacketFlow> flow,
        boolean optional
) implements IConfigurationPayloadHandler<CustomPacketPayload>, IPayloadReader<CustomPacketPayload> {
    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void handle(ConfigurationPayloadContext context, CustomPacketPayload payload) {
        ((IConfigurationPayloadHandler) handler).handle(context, payload);
    }
    
    @Override
    public CustomPacketPayload readPayload(FriendlyByteBuf buffer, PayloadReadingContext context) {
        return reader.readPayload(buffer, context);
    }
}