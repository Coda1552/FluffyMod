package coda.fluffy.client.render;

import coda.fluffy.FluffyMod;
import coda.fluffy.client.FluffyModelLayers;
import coda.fluffy.client.model.FluffyModel;
import coda.fluffy.common.entities.Fluffy;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class FluffyRenderer extends MobRenderer<Fluffy, EntityModel<Fluffy>> {
	public static final ResourceLocation TEXTURE = new ResourceLocation(FluffyMod.MOD_ID, "textures/entity/fluffy.png");

	public FluffyRenderer(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new FluffyModel<>(renderManagerIn.bakeLayer(FluffyModelLayers.FLUFFY)), 0.4F);
	}
	
	@Override
	public ResourceLocation getTextureLocation(Fluffy entity) {
		return TEXTURE;
	}
}
