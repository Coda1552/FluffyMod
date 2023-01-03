package coda.fluffy.registry;

import coda.fluffy.FluffyMod;
import coda.fluffy.common.entities.Fluffy;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FluffyEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, FluffyMod.MOD_ID);

    public static final RegistryObject<EntityType<Fluffy>> FLUFFY = create("fluffy", EntityType.Builder.of(Fluffy::new, MobCategory.CREATURE).sized(0.75F, 0.5F));

    private static <T extends Entity> RegistryObject<EntityType<T>> create(String name, EntityType.Builder<T> builder) {
        return ENTITIES.register(name, () -> builder.build(FluffyMod.MOD_ID + "." + name));
    }
}
