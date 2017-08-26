package com.buuz135.industrial.tile.block;

import com.buuz135.industrial.config.CustomConfiguration;
import com.buuz135.industrial.tile.mob.MobRelocatorTile;
import com.buuz135.industrial.utils.RecipeUtils;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import net.ndrei.teslacorelib.items.MachineCaseItem;

public class MobRelocatorBlock extends CustomOrientedBlock<MobRelocatorTile> {

    private float essenceMultiplier;

    public MobRelocatorBlock() {
        super("mob_relocator", MobRelocatorTile.class, Material.ROCK, 1000, 40);
    }

    @Override
    public void getMachineConfig() {
        super.getMachineConfig();
        essenceMultiplier = CustomConfiguration.config.getFloat("essenceMultiplier", "machines" + Configuration.CATEGORY_SPLITTER + this.getRegistryName().getResourcePath().toString(), 1, 0, Integer.MAX_VALUE, "Mob essence multiplier based on the mob health. Essence mb = mobHealth*essenceMultiplier");
    }

    public float getEssenceMultiplier() {
        return essenceMultiplier;
    }

    public void createRecipe() {
        RecipeUtils.addShapedRecipe(new ItemStack(this), "psp", "bmb", "grg",
                'p', "itemRubber",
                's', Items.IRON_SWORD,
                'b', Items.BOOK,
                'm', MachineCaseItem.INSTANCE,
                'g', "gearGold",
                'r', Items.REDSTONE);
    }
}
