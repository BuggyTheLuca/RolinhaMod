package feiosocabeludo.rolinhamod.gameObjects.player;

import feiosocabeludo.rolinhamod.utils.enums.rpgClassEnum;
import net.minecraftforge.common.ForgeConfigSpec;

public class playerData {

    private ForgeConfigSpec.EnumValue<rpgClassEnum> currentClass;

    private long level;

    private boolean isFirstLogin;

    public playerData (ForgeConfigSpec.EnumValue<rpgClassEnum> currentClass, long level){
        this.currentClass = currentClass;
        this.level = level;
    }
}
