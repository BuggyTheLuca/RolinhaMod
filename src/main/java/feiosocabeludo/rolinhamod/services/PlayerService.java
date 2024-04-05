package feiosocabeludo.rolinhamod.services;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;

public class PlayerService {
    // Método para salvar os dados do jogador
    public static void saveData(PlayerEntity player, PlayerDataService data) {
        CompoundNBT playerData = data.serializeNBT();
        player.getPersistentData().put("rolinhamodPlayerData", playerData);
    }

    // Método para carregar os dados do jogador
    public static PlayerDataService loadData(PlayerEntity player) {
        CompoundNBT playerData = player.getPersistentData().getCompound("rolinhamodPlayerData");
        PlayerDataService data = new PlayerDataService();
        data.deserializeNBT(playerData);
        return data;
    }
}