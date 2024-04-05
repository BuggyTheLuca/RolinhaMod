package feiosocabeludo.rolinhamod.services;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import feiosocabeludo.rolinhamod.RolinhaMod;
import feiosocabeludo.rolinhamod.utils.enums.rpgClassEnum;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.EnumValue;
import org.apache.commons.lang3.tuple.Pair;


import java.nio.file.Path;
import java.nio.file.Paths;


public class RPGScreenService {

    private static final RPGScreenService INSTANCE;

    /**
     * The {@link ForgeConfigSpec} instance for this mod's configuration
     */
    private static final ForgeConfigSpec SPEC;

    /**
     * {@link Path} to the configuration file of this mod
     */
    private static final Path CONFIG_PATH =
            Paths.get("config", RolinhaMod.MOD_ID + ".toml");

    static {
        Pair<RPGScreenService, ForgeConfigSpec> specPair =
                new ForgeConfigSpec.Builder().configure(RPGScreenService::new);
        INSTANCE = specPair.getLeft();
        SPEC = specPair.getRight();
        CommentedFileConfig config = CommentedFileConfig.builder(CONFIG_PATH)
                .sync()
                .autoreload()
                .build();
        config.load();
        config.save();
        SPEC.setConfig(config);
    }

    private final EnumValue<rpgClassEnum> currentClass;

    private boolean isClassSelected = false;



    public RPGScreenService(ForgeConfigSpec.Builder configSpecBuilder){
        currentClass = configSpecBuilder
                .translation("rolinhamod.RPGgui.currentClass.title")
                .defineEnum("currentClass", rpgClassEnum.UNSELECTED);
    }

    public boolean isClassSelected(){
        return isClassSelected;
    }

    public void blockClassSelect(){
        isClassSelected = true;

    }

    public static RPGScreenService getInstance() {
        return INSTANCE;
    }

    public rpgClassEnum currentClass() {
        return currentClass.get();
    }

    public void changeCurrentClass(rpgClassEnum value){
        currentClass.set(value);
    }
}
