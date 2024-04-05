package feiosocabeludo.rolinhamod.services.handlers;

import feiosocabeludo.rolinhamod.Player.ModPlayer;
import feiosocabeludo.rolinhamod.gameObjects.items.ItemsRegister;
import feiosocabeludo.rolinhamod.services.RPGScreenService;
import feiosocabeludo.rolinhamod.Player.PlayerData;
import feiosocabeludo.rolinhamod.Player.PlayerDataManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import feiosocabeludo.rolinhamod.utils.enums.rpgClassEnum;

@Mod.EventBusSubscriber
public class PlayerSpawnEventHandler {

    private static final RPGScreenService rpgScreenService = RPGScreenService.getInstance();

    @SubscribeEvent
    public static void onPlayerDisconnect(PlayerEvent.PlayerLoggedOutEvent event) {
        PlayerEntity player = event.getPlayer();
        PlayerData playerData = PlayerDataManager.loadData(player);
        playerData.setModPlayer(new ModPlayer(rpgClassEnum.LADINO, 99));
        PlayerDataManager.saveData(player, playerData);

        System.out.println(playerData.getModPlayer().toString());
    }

    // Carregar dados quando o jogador entrar no jogo
    @SubscribeEvent
    public static void onPlayerConnect(PlayerEvent.PlayerLoggedInEvent event) {
        PlayerEntity player = event.getPlayer();
        PlayerData playerData = PlayerDataManager.loadData(player);

        System.out.println(playerData.getModPlayer().toString());


        /*boolean isFirstLogin = playerData.isFirstLogin();

        if(isFirstLogin){
            // Crie uma pilha de itens com o item
            ItemStack itemStack = new ItemStack(Items.DIAMOND_SWORD);

            // Adicione a pilha de itens ao inventário do jogador
            player.inventory.addItemStackToInventory(itemStack);
        }else{
            // Crie uma pilha de itens com o item
            ItemStack itemStack = new ItemStack(ItemsRegister.ROLINHA_SEED.get());

            // Adicione a pilha de itens ao inventário do jogador
            player.inventory.addItemStackToInventory(itemStack);
        }*/
    }


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
            Item startingItem = ItemsRegister.ROLINHA_MADURA.get();

            // Crie uma pilha de itens com o item
            ItemStack itemStack = new ItemStack(startingItem);

            // Adicione a pilha de itens ao inventário do jogador
            player.inventory.addItemStackToInventory(itemStack);
        }
    }
}