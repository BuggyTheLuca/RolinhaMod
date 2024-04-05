package feiosocabeludo.rolinhamod.services.handlers;

import feiosocabeludo.rolinhamod.RolinhaMod;
import feiosocabeludo.rolinhamod.screens.RPGScreen;
import net.minecraft.client.Minecraft;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RolinhaMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class KeyInputHandler {
    private static boolean isKeyPressed = false;

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            if (!isKeyPressed && RolinhaMod.OPEN_RPG_GUI_KEY.isKeyDown()) {
                Minecraft.getInstance().displayGuiScreen(new RPGScreen());
                isKeyPressed = true;
            } else if (isKeyPressed && !RolinhaMod.OPEN_RPG_GUI_KEY.isKeyDown()) {
                isKeyPressed = false;
            }
        }
    }
}
