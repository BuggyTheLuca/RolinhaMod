package feiosocabeludo.rolinhamod.items;

import feiosocabeludo.rolinhamod.RolinhaMod;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, RolinhaMod.MOD_ID);

    // Aqui você associa o item ao grupo de itens personalizado
    public static final RegistryObject<Item> ROLINHA_SEED = ITEMS.register("rolinha_seed", RolinhaSeedItem::new);

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
