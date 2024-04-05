package feiosocabeludo.rolinhamod.Player;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;

public class PlayerDataManager {
    // Método para salvar os dados do jogador
    public static void saveData(PlayerEntity player, PlayerData data) {
        CompoundNBT playerData = data.serializeNBT();
        player.getPersistentData().put("rolinhamodPlayerData", playerData);
    }

    // Método para carregar os dados do jogador
    public static PlayerData loadData(PlayerEntity player) {
        CompoundNBT playerData = player.getPersistentData().getCompound("rolinhamodPlayerData");
        PlayerData data = new PlayerData();
        data.deserializeNBT(playerData);
        return data;
    }
}