package feiosocabeludo.rolinhamod.gameObjects.items;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class RolinhaItemGroup extends ItemGroup {
    public static final RolinhaItemGroup ROLINHA_GROUP = new RolinhaItemGroup();

    public RolinhaItemGroup() {
        super("rolinha_group");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ItemsRegister.ROLINHA_MADURA.get());
    }
}