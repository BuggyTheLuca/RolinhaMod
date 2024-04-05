package feiosocabeludo.rolinhamod.screens;

import com.mojang.blaze3d.matrix.MatrixStack;
import feiosocabeludo.rolinhamod.services.RPGScreenService;
import feiosocabeludo.rolinhamod.utils.enums.rpgClassEnum;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.list.OptionsRowList;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.IteratableOption;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;



public final class RPGScreen extends Screen {
    /** Distance from top of the screen to this GUI's title */
    private static final int TITLE_HEIGHT = 8;
    /** Distance from top of the screen to the options row list's top */
    private static final int OPTIONS_LIST_TOP_HEIGHT = 24;
    /** Distance from bottom of the screen to the options row list's bottom */
    private static final int OPTIONS_LIST_BOTTOM_OFFSET = 32;
    /** Height of each item in the options row list */
    private static final int OPTIONS_LIST_ITEM_HEIGHT = 25;
    /** Width of a button */
    private static final int BUTTON_WIDTH = 200;
    /** Height of a button */
    private static final int BUTTON_HEIGHT = 20;
    /** Distance from bottom of the screen to the "Done" button's top */
    private static final int DONE_BUTTON_TOP_OFFSET = 26;

    private static final RPGScreenService rpgScreenService = RPGScreenService.getInstance();


    /** List of options rows shown on the screen */
    // Not a final field because this cannot be initialized in the constructor,
    // as explained below
    private OptionsRowList optionsRowList;

    public RPGScreen() {
        // Use the super class' constructor to set the screen's title
        super(new TranslationTextComponent("rolinhamod.RPGgui.title",
                "rolinhamod"));
    }


    @Override
    protected void init() {
        // Create the options row list
        // It must be created in this method instead of in the constructor,
        // or it will not be displayed properly
        this.optionsRowList = new OptionsRowList(
                this.minecraft, this.width, this.height,
                OPTIONS_LIST_TOP_HEIGHT,
                this.height - OPTIONS_LIST_BOTTOM_OFFSET,
                OPTIONS_LIST_ITEM_HEIGHT
        );

        // Add the options row list as this screen's child
        // If this is not done, users cannot click on items in the list
        this.children.add(this.optionsRowList);

        this.optionsRowList.addOption(new IteratableOption(
                "rolinhamod.RPGgui.currentClass.title",
                (unused, newValue) ->{
                    if(!rpgScreenService.isClassSelected()){
                        rpgScreenService.changeCurrentClass(rpgClassEnum.values()[
                                (rpgScreenService.currentClass().ordinal() + newValue)
                                        % rpgClassEnum.values().length]);
                        System.out.println(rpgScreenService.isClassSelected());
                    }
                },
                (unused, option) -> new StringTextComponent(I18n.format(
                        "rolinhamod.RPGgui.currentClass.title"
                ) + ": " + I18n.format(
                        rpgScreenService.currentClass().getTranslateKey()
                ))
        ));

        // Add the "Done" button
        this.addButton(new Button(
                (this.width - BUTTON_WIDTH) / 2,
                this.height - DONE_BUTTON_TOP_OFFSET,
                BUTTON_WIDTH, BUTTON_HEIGHT,
                // Text shown on the button
                new TranslationTextComponent("gui.done"),
                // Action performed when the button is pressed
                button -> this.closeScreen()
        ));
    }

    @Override
    public void render(MatrixStack matrixStack,
                       int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        // Options row list must be rendered here,
        // otherwise the GUI will be broken
        this.optionsRowList.render(matrixStack, mouseX, mouseY, partialTicks);
        drawCenteredString(matrixStack, this.font, this.title.getString(),
                this.width / 2, TITLE_HEIGHT, 0xFFFFFF);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
    }

    @Override
    public void onClose() {
        rpgScreenService.blockClassSelect();
        super.onClose();
    }
}