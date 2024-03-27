package feiosocabeludo.rolinhamod.items;

import feiosocabeludo.rolinhamod.RolinhaMod;
import feiosocabeludo.rolinhamod.blocks.ModBlocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, RolinhaMod.MOD_ID);

    public static final RegistryObject<Item> ROLINHA_SEED = ITEMS.register("rolinha_seed",
            () -> new BlockItem(ModBlocks.ROLINHA_PLANT_BLOCK.get(), new Item.Properties().group(RolinhaItemGroup.ROLINHA_GROUP)));

    public static final RegistryObject<Item> ROLINHA_MADURA = ITEMS.register("rolinha_madura", RolinhaMadura::new);

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
