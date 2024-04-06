package feiosocabeludo.rolinhamod.Player;

import feiosocabeludo.rolinhamod.utils.enums.rpgClassEnum;

public class ModPlayer {

    private rpgClassEnum currentClass;

    private long level;

    public rpgClassEnum getCurrentClass(){
        return currentClass;
    }

    public long getLevel(){
        return level;
    }

    public ModPlayer(rpgClassEnum currentClass, long level){
        this.currentClass = currentClass;
        this.level = level;
    }

    public String toString(){
        return "Classe: " + currentClass + ", level: " + level;
    }
}
