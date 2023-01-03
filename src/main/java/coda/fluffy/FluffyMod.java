package coda.fluffy;

import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.biome.Biome;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import coda.fluffy.common.entities.Fluffy;
import coda.fluffy.registry.FluffyEntities;
import coda.fluffy.registry.FluffyItems;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(FluffyMod.MOD_ID)
@Mod.EventBusSubscriber(modid = FluffyMod.MOD_ID)
public class FluffyMod {
    public static final String MOD_ID = "fluffy";
    
    public static final Logger LOGGER = LogManager.getLogger();

    public FluffyMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		ModLoadingContext modLoadingContext = ModLoadingContext.get();

		bus.addListener(this::setup);

        FluffyEntities.ENTITIES.register(bus);
        FluffyItems.ITEMS.register(bus);

        bus.addListener(this::createAttributes);
    }

    private void createAttributes(EntityAttributeCreationEvent event) {
        event.put(FluffyEntities.FLUFFY.get(), Fluffy.createAttributes().build());
    }
    
	public void setup(final FMLCommonSetupEvent event) {
		SpawnPlacements.register(FluffyEntities.FLUFFY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
	}

	@SubscribeEvent
	public static void onBiomeLoad(BiomeLoadingEvent event) {
    	if (event.getCategory().equals(Biome.BiomeCategory.PLAINS)) {
    		event.getSpawns().addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(FluffyEntities.FLUFFY.get(), 4, 1, 1));
    	}
	}

    
}
