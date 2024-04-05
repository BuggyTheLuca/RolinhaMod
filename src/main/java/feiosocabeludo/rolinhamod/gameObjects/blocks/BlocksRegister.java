package feiosocabeludo.rolinhamod.gameObjects.blocks;

import feiosocabeludo.rolinhamod.RolinhaMod;
import feiosocabeludo.rolinhamod.gameObjects.items.ItemsRegister;
import feiosocabeludo.rolinhamod.gameObjects.items.RolinhaItemGroup;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = RolinhaMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlocksRegister {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, RolinhaMod.MOD_ID);

    // Aqui você associa o item ao grupo de itens personalizado
    public static final RegistryObject<Block> ROLINHA_PLANT_BLOCK = registerBlock("rolinha_plant",
            () -> new RolinhaPlantBlock(AbstractBlock.Properties.from(Blocks.WHEAT)));

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);

        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
        ItemsRegister.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(RolinhaItemGroup.ROLINHA_GROUP)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
