package feiosocabeludo.rolinhamod.blocks;

import com.sun.javafx.UnmodifiableArrayList;
import feiosocabeludo.rolinhamod.RolinhaMod;
import net.minecraft.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = RolinhaMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, RolinhaMod.MOD_ID);

    // Aqui você associa o item ao grupo de itens personalizado
    public static final RegistryObject<Block> ROLINHA_PLANT_BLOCK = BLOCKS.register("rolinha_plant_block", RolinhaPlantBlock::new);

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
