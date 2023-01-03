package coda.fluffy.client;

import coda.fluffy.FluffyMod;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class FluffyModelLayers {
    public static ModelLayerLocation FLUFFY = create("fluffy");

    private static final ModelLayerLocation create(String name) {
        return new ModelLayerLocation(new ResourceLocation(FluffyMod.MOD_ID, name), name);
    }
}
