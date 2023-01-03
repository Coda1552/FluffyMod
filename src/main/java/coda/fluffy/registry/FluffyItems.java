package coda.fluffy.registry;

import coda.fluffy.FluffyMod;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FluffyItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FluffyMod.MOD_ID);
    public static final CreativeModeTab GROUP = new CreativeModeTab(FluffyMod.MOD_ID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(FluffyItems.FLUFFY_SPAWN_EGG.get());
        }
    };

    public static final RegistryObject<Item> FLUFFY_SPAWN_EGG = ITEMS.register("fluffy_spawn_egg", () -> new ForgeSpawnEggItem(FluffyEntities.FLUFFY, 0xf4d8ac, 0xaa8d6a, new Item.Properties().tab(GROUP)));

}
