package feiosocabeludo.rolinhamod.Player;

import com.google.gson.Gson;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.INBTSerializable;

public class PlayerData implements INBTSerializable<CompoundNBT> {

    private ModPlayer player;
    private Gson jsonCompiler;

    public PlayerData(){
        jsonCompiler = new Gson();
    }

    public void setModPlayer(ModPlayer player){
        this.player = player;
    }

    public ModPlayer getModPlayer(){
        return player;
    }

    // Serialização para salvar os dados
    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT compound = new CompoundNBT();
        compound.putString("player", jsonCompiler.toJson(player));
        return compound;
    }

    // Desserialização para carregar os dados
    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        this.player = jsonCompiler.fromJson(nbt.getString("player"), ModPlayer.class);
    }
}
