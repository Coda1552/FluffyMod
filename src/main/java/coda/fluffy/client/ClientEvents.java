package coda.fluffy.client;

import coda.fluffy.FluffyMod;
import coda.fluffy.client.model.FluffyModel;
import coda.fluffy.client.render.FluffyRenderer;
import coda.fluffy.registry.FluffyEntities;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = FluffyMod.MOD_ID)
public class ClientEvents {

    @SubscribeEvent
	public static void registerEntityRenders(EntityRenderersEvent.RegisterRenderers event) {
    	event.registerEntityRenderer(FluffyEntities.FLUFFY.get(), FluffyRenderer::new);
    }
    
    @SubscribeEvent
	public static void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions event) {
    	event.registerLayerDefinition(FluffyModelLayers.FLUFFY, FluffyModel::createBodyLayer);
    }
}
