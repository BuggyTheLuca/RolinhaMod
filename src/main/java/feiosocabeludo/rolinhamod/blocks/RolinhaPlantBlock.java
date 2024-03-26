package feiosocabeludo.rolinhamod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class RolinhaPlantBlock extends Block {
    public RolinhaPlantBlock() {
        super(Properties.create(Material.PLANTS)// Define o material da planta
                .sound(SoundType.CROP) // Define o som ao andar na planta
                .tickRandomly() // Ativa atualizações aleatórias para crescimento
                .setLightLevel((state) -> 0)); // Define o nível de luz emitido pela planta (0 = nenhuma luz)
    }
}
