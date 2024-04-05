package feiosocabeludo.rolinhamod.Player;

import feiosocabeludo.rolinhamod.utils.enums.rpgClassEnum;
import net.minecraftforge.common.ForgeConfigSpec;

public class ModPlayer {

    private rpgClassEnum currentClass;

    private long level;

    public ModPlayer(rpgClassEnum currentClass, long level){
        this.currentClass = currentClass;
        this.level = level;
    }

    public String toString(){
        return "Classe: " + currentClass + ", level: " + level;
    }
}
