package feiosocabeludo.rolinhamod.services;


import feiosocabeludo.rolinhamod.Player.ModPlayer;
import feiosocabeludo.rolinhamod.Player.PlayerData;
import feiosocabeludo.rolinhamod.Player.PlayerDataManager;
import feiosocabeludo.rolinhamod.services.handlers.PlayerSpawnEventHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class PlayerService {

    private World world;

    private static RPGScreenService rpgScreenService;

    private static final PlayerService INSTANCE = new PlayerService();

    public static PlayerService getInstance(){
        return INSTANCE;
    }

    public void setWorld(World world){
        this.world = world;
        rpgScreenService = RPGScreenService.getInstance();
    }

    public void loadData(){
        PlayerEntity player = world.getPlayerByUuid(PlayerSpawnEventHandler.playerUUID);
        PlayerData playerData = PlayerDataManager.loadData(player);
        rpgScreenService.changeCurrentClass(playerData.getModPlayer().getCurrentClass());

        System.out.println("\u001B[31m"+playerData.getModPlayer().toString());
    }

    public void saveData(){
        PlayerEntity player = world.getPlayerByUuid(PlayerSpawnEventHandler.playerUUID);
        PlayerData playerData = PlayerDataManager.loadData(player);
        PlayerDataManager.saveData(player, playerData);

        System.out.println("\u001B[31m"+playerData.getModPlayer().toString());
    }


    public ModPlayer loadModPlayer(){
        PlayerEntity player = world.getPlayerByUuid(PlayerSpawnEventHandler.playerUUID);
        PlayerData playerData = PlayerDataManager.loadData(player);

        return playerData.getModPlayer();
    }

    public void saveModPlayer(ModPlayer modPlayer){
        PlayerEntity player = world.getPlayerByUuid(PlayerSpawnEventHandler.playerUUID);
        PlayerData playerData = PlayerDataManager.loadData(player);
        playerData.setModPlayer(modPlayer);
        PlayerDataManager.saveData(player, playerData);
    }



}
