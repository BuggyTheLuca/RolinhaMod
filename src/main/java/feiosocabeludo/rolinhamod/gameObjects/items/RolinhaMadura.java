package feiosocabeludo.rolinhamod.gameObjects.items;

import net.minecraft.item.Food;
import net.minecraft.item.Item;

public class RolinhaMadura extends Item {
    public RolinhaMadura() {
        super(new Item.Properties()
                .food(new Food.Builder()
                        .hunger(3) // Define o nível de fome que o alimento satisfaz
                        .saturation(0.1f) // Define a saturação do alimento
                        .fastToEat() // Permite que o jogador coma rapidamente o alimento
                        .build())
                .group(RolinhaItemGroup.ROLINHA_GROUP)); // Define o grupo de itens para o item
    }
}
