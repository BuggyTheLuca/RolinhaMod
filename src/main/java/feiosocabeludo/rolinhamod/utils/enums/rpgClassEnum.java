package feiosocabeludo.rolinhamod.utils.enums;

import java.util.Objects;

public enum rpgClassEnum {

        UNSELECTED("rolinhamod.rpg_class.unselected"),

        LADINO("rolinhamod.rpg_class.ladino"),

        GUERREIRO("rolinhamod.rpg_class.guerreiro"),

        ARQUEIRO("rolinhamod.rpg_class.arqueiro"),

        MAGO("rolinhamod.rpg_class.mago"),

        NECROMANTE("rolinhamod.rpg_class.necromante"),

        CLERIGO("rolinhamod.rpg_class.clerigo");


        private final String translateKey;

        /**
         * Constructs a new constant of Bed Wars Dream mode games.
         *
         * @param translateKey translate key for the name of this Dream mode game
         * @throws NullPointerException if {@code translateKey == null}
         */
        rpgClassEnum(String translateKey) {
            this.translateKey =
                    Objects.requireNonNull(translateKey, "translateKey");
        }

        /**
         * Returns the translate key for the name of this Dream mode game.
         *
         * @return the translate key for the name of this Dream mode game
         */
        public String getTranslateKey() {
            return this.translateKey;
        }
}
