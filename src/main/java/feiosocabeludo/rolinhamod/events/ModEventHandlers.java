package feiosocabeludo.rolinhamod.events;

import feiosocabeludo.rolinhamod.RolinhaMod;
import feiosocabeludo.rolinhamod.blocks.ModBlocks;
import feiosocabeludo.rolinhamod.items.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RolinhaMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEventHandlers {

    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        World world = event.getWorld();
        BlockPos pos = event.getPos();
        PlayerEntity player = event.getPlayer();
        Hand hand = event.getHand();
        ItemStack heldItem = player.getHeldItem(hand);

        // Verifica se o jogador está segurando a semente da rolinha
        if (heldItem.getItem() == ModItems.ROLINHA_SEED.get()) {
            BlockState clickedBlockState = world.getBlockState(pos);
            BlockPos upPos = pos.up();

            // Verifica se o bloco clicado é solo arado e se há espaço acima para plantar a semente
            if (clickedBlockState.getBlock() == Blocks.FARMLAND && world.isAirBlock(upPos)) {
                // Planta a semente e diminui a quantidade no inventário do jogador
                world.setBlockState(upPos, ModBlocks.ROLINHA_PLANT_BLOCK.get().getDefaultState());
                if (!player.isCreative()) {
                    heldItem.shrink(1);
                }
                event.setCancellationResult(ActionResultType.SUCCESS);
                event.setCanceled(true);
            }
        }
    }
}