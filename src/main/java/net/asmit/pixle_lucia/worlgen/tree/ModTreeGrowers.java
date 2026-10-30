package net.asmit.pixle_lucia.worlgen.tree;

import net.asmit.pixle_lucia.Pixle_Lucia;
import net.asmit.pixle_lucia.worlgen.ModConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import javax.swing.text.html.Option;
import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower BALSA = new TreeGrower(Pixle_Lucia.MOD_ID + ":balsa",
            Optional.empty(), Optional.of(ModConfiguredFeatures.BALSA_KEY),Optional.empty());
}
