package net.dries007.tfc.jei.categories;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import mcp.MethodsReturnNonnullByDefault;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import net.dries007.tfc.api.types.Metal;
import net.dries007.tfc.api.util.TFCConstants;
import net.dries007.tfc.jei.wrappers.AnvilWrapper;
import net.dries007.tfc.objects.items.metal.ItemMetal;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class AnvilCategory extends TFCRecipeCategory<AnvilWrapper>
{
    private static final ResourceLocation ANVIL_TEXTURES = new ResourceLocation(TFCConstants.MOD_ID, "textures/gui/anvil.png");

    public AnvilCategory(IGuiHelper helper, String Uid)
    {
        super(helper.createDrawable(ANVIL_TEXTURES, 11, 7, 154, 80), Uid);
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, AnvilWrapper recipeWrapper, IIngredients ingredients)
    {
        IGuiItemStackGroup itemStackGroup = recipeLayout.getItemStacks();
        itemStackGroup.init(0, true, 19, 60);
        itemStackGroup.init(1, true, 117, 60);
        itemStackGroup.init(2, false, 19, 42);

        itemStackGroup.set(0, ingredients.getInputs(VanillaTypes.ITEM).get(0));
        itemStackGroup.set(1, new ItemStack(ItemMetal.get(Metal.WROUGHT_IRON, Metal.ItemType.HAMMER)));
        itemStackGroup.set(2, ingredients.getOutputs(VanillaTypes.ITEM).get(0));
    }
}
