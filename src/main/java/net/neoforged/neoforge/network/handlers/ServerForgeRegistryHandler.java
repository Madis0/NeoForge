package net.neoforged.neoforge.network.handlers;

import net.neoforged.neoforge.network.configuration.SyncRegistries;
import net.neoforged.neoforge.network.handling.ConfigurationPayloadContext;
import net.neoforged.neoforge.network.payload.FrozenRegistrySyncCompletePayload;

public class ServerForgeRegistryHandler {
    
    private static final ServerForgeRegistryHandler INSTANCE = new ServerForgeRegistryHandler();
    
    public static ServerForgeRegistryHandler getInstance() {
        return INSTANCE;
    }
    
    private ServerForgeRegistryHandler() {
    }
    
    public void handle(ConfigurationPayloadContext context, FrozenRegistrySyncCompletePayload payload) {
        context.taskCompletedHandler().onTaskCompleted(SyncRegistries.TYPE);
    }
}