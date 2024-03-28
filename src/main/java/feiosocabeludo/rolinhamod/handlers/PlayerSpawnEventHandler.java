package feiosocabeludo.rolinhamod.handlers;

import feiosocabeludo.rolinhamod.items.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class PlayerSpawnEventHandler {

    // Este método é chamado quando um novo jogador é registrado no mundo
    @SubscribeEvent
    public static void onPlayerJoin(PlayerEvent.PlayerLoggedInEvent event) {
        PlayerEntity player = event.getPlayer();

        // Verifique se o jogador não é nulo e está no servidor dedicado
        if (player != null && !player.world.isRemote()) {
            giveStartingItem(player);
        }
    }

    // Método para dar ao jogador o item inicial
    private static void giveStartingItem(PlayerEntity player) {
        // Verifique se o jogador não tem nenhum item no inventário
        if (player.inventory.isEmpty()) {
            // Crie o item que você deseja dar ao jogador
            Item startingItem = ModItems.ROLINHA_MADURA.get();

            // Crie uma pilha de itens com o item
            ItemStack itemStack = new ItemStack(startingItem);

            // Adicione a pilha de itens ao inventário do jogador
            player.inventory.addItemStackToInventory(itemStack);
        }
    }
}