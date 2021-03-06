package nightkosh.gravestone_extended.crafting;

import net.minecraft.item.ItemStack;
import nightkosh.gravestone.api.grave.EnumGraveMaterial;
import nightkosh.gravestone.api.grave.EnumGraveType;
import nightkosh.gravestone.api.grave.IEnumGraveMaterial;
import nightkosh.gravestone.api.grave.IEnumGraveType;
import nightkosh.gravestone.block.enums.EnumGraves;
import nightkosh.gravestone_extended.block.enums.EnumMemorials;
import nightkosh.gravestone_extended.core.GSBlock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GravesCraftingManager {


    private static final List<GravestoneRecipe> GRAVES_RECIPES = new ArrayList<>();
    private static final List<GravestoneRecipe> MEMORIALS_RECIPES = new ArrayList<>();
    public static final GravesCraftingManager INSTANCE = new GravesCraftingManager();

    private GravesCraftingManager() {
        addGravesRecipesForAllMaterials(EnumGraveType.VERTICAL_PLATE);
        addGravesRecipesForAllMaterials(EnumGraveType.CROSS);
        addGravesRecipesForAllMaterials(EnumGraveType.OBELISK);
        addGravesRecipesForAllMaterials(EnumGraveType.CELTIC_CROSS);
        addGravesRecipesForAllMaterials(EnumGraveType.HORIZONTAL_PLATE);
        addGravesRecipesForAllMaterials(EnumGraveType.VILLAGER_STATUE);
        addGravesRecipesForAllMaterials(EnumGraveType.DOG_STATUE);
        addGravesRecipesForAllMaterials(EnumGraveType.CAT_STATUE);
        addGravesRecipesForAllMaterials(EnumGraveType.HORSE_STATUE);
        addGravesRecipesForAllMaterials(EnumGraveType.CREEPER_STATUE);
        //TODO EnumGraves.EnumGraveType.SWORD

        // Memorials
        addMemorialsRecipesForAllMaterials(EnumMemorials.EnumMemorialType.CROSS, 6);
        addMemorialsRecipesForAllMaterials(EnumMemorials.EnumMemorialType.OBELISK, 6);
        addMemorialsRecipesForAllMaterials(EnumMemorials.EnumMemorialType.CELTIC_CROSS, 5);
        addMemorialsRecipesForAllMaterials(EnumMemorials.EnumMemorialType.STEVE_STATUE, 3);
        addMemorialsRecipesForAllMaterials(EnumMemorials.EnumMemorialType.VILLAGER_STATUE, 3);
        addMemorialsRecipesForAllMaterials(EnumMemorials.EnumMemorialType.ANGEL_STATUE, 3);
        addMemorialsRecipesForAllMaterials(EnumMemorials.EnumMemorialType.DOG_STATUE, 2);
        addMemorialsRecipesForAllMaterials(EnumMemorials.EnumMemorialType.CAT_STATUE, 2);
        addMemorialsRecipesForAllMaterials(EnumMemorials.EnumMemorialType.CREEPER_STATUE, 3);
    }

    private static void addGravesRecipesForAllMaterials(EnumGraveType graveType) {
        for (int i = 0; i <= EnumGraveMaterial.ICE.ordinal(); i++) {
            EnumGraveMaterial material = EnumGraveMaterial.values()[i];
            addRecipeForAllMaterials(true, graveType, EnumGraves.getByTypeAndMaterial(graveType, material).ordinal(), material, 1);
        }
    }

    private static void addMemorialsRecipesForAllMaterials(EnumMemorials.EnumMemorialType memorialType, int amountOfBlocks) {
        for (int i = 0; i <= EnumGraveMaterial.ICE.ordinal(); i++) {
            EnumGraveMaterial material = EnumGraveMaterial.values()[i];
            addRecipeForAllMaterials(false, memorialType, EnumMemorials.getByTypeAndMaterial(memorialType, material).ordinal(), material, amountOfBlocks);
        }
    }

    private static void addRecipeForAllMaterials(boolean isGravestone, IEnumGraveType type, int graveType, EnumGraveMaterial material, int amountOfBlocks) {
        int meta = 0;
        if (material == EnumGraveMaterial.DIORITE) {
            meta = IEnumGraveMaterial.DIORITE_META;
        } else if (material == EnumGraveMaterial.ANDESITE) {
            meta = IEnumGraveMaterial.DIORITE_META;
        } else if (material == EnumGraveMaterial.GRANITE) {
            meta = IEnumGraveMaterial.DIORITE_META;
        }

        (isGravestone ? GRAVES_RECIPES : MEMORIALS_RECIPES).add(new GravestoneRecipe(isGravestone, type, material,
                Arrays.asList(new ItemStack(material.getBlock(), amountOfBlocks, meta)),
                getStackWithNTB((isGravestone) ? GSBlock.GRAVE_STONE : GSBlock.MEMORIAL, graveType)));
    }

    public List<ItemStack> findMatchingRecipe(boolean isGravestone, EnumGraveType graveType, EnumMemorials.EnumMemorialType memorialType,
                                              EnumGraveMaterial material, boolean isEnchanted, boolean isMossy) {
        for (GravestoneRecipe recipe : (isGravestone ? GRAVES_RECIPES : MEMORIALS_RECIPES)) {
            if (recipe.match((isGravestone) ? graveType : memorialType, material, isMossy)) {
                return recipe.getRequiredItems(isEnchanted, isMossy);
            }
        }
        return Collections.EMPTY_LIST;
    }

    public ItemStack findCraftingResult(List<ItemStack> items, boolean isGravestone, EnumGraveType graveType,
                                        EnumMemorials.EnumMemorialType memorialType, EnumGraveMaterial material,
                                        boolean isEnchanted, boolean isMossy) {
        for (GravestoneRecipe recipe : (isGravestone ? GRAVES_RECIPES : MEMORIALS_RECIPES)) {
            if (recipe.matchCrafting((isGravestone) ? graveType : memorialType, material, isEnchanted, isMossy, items)) {
                return recipe.getResultItem(items, isEnchanted, isMossy);
            }
        }
        return ItemStack.EMPTY;
    }

    public List<GravestoneRecipe> getGravesRecipes() {
        return GRAVES_RECIPES;
    }

    public List<GravestoneRecipe> getMemorialsRecipes() {
        return MEMORIALS_RECIPES;
    }

    private static ItemStack getStackWithNTB(net.minecraft.block.Block block, int graveType) {
        return new ItemStack(block, 1, graveType);
    }
}
