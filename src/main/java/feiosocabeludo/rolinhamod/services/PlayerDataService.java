package feiosocabeludo.rolinhamod.services;

import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.INBTSerializable;

public class PlayerDataService implements INBTSerializable<CompoundNBT> {
    private boolean isFirstLogin;

    // Construtor
    public PlayerDataService() {
        this.isFirstLogin = true; // Define como true por padrão
    }

    // Método para definir se é a primeira vez que o jogador está logando
    public void setFirstLogin(boolean isFirstLogin) {
        this.isFirstLogin = isFirstLogin;
    }

    // Método para verificar se é a primeira vez que o jogador está logando
    public boolean isFirstLogin() {
        return isFirstLogin;
    }

    // Serialização para salvar os dados
    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT compound = new CompoundNBT();
        compound.putBoolean("isFirstLogin", isFirstLogin);
        return compound;
    }

    // Desserialização para carregar os dados
    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        this.isFirstLogin = nbt.getBoolean("isFirstLogin");
    }
}
