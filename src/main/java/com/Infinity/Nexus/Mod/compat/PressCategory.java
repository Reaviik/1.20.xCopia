package com.Infinity.Nexus.Mod.compat;

import com.Infinity.Nexus.Mod.InfinityNexusMod;
import com.Infinity.Nexus.Mod.block.ModBlocksAdditions;
import com.Infinity.Nexus.Mod.recipe.PressRecipes;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class PressCategory implements IRecipeCategory<PressRecipes> {

    public static final ResourceLocation UID = new ResourceLocation(InfinityNexusMod.MOD_ID, "pressing");
    public static final ResourceLocation TEXTURE = new ResourceLocation(InfinityNexusMod.MOD_ID, "textures/gui/jei/press_gui.png");

    public static final RecipeType<PressRecipes> PRESS_TYPE = new RecipeType<>(UID, PressRecipes.class);

    private final IDrawable background;
    private final IDrawable icon;

    public PressCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 75);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocksAdditions.PRESS.get()));
    }

    @Override
    public RecipeType<PressRecipes> getRecipeType() {
        return PRESS_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.infinity_nexus_mod.press");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, PressRecipes recipe, IFocusGroup focuses) {

        ItemStack[] input = recipe.getIngredients().get(0).getItems();
        input[0].setCount(recipe.getCount());

        ItemStack output = recipe.getResultItem(null);
        output.setCount(recipe.getResultCount());

        builder.addSlot(RecipeIngredientRole.INPUT, 80, 11).addItemStack(input[0]);
        builder.addSlot(RecipeIngredientRole.INPUT, 80, 47).addIngredients(recipe.getIngredients().get(1));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 116, 29).addItemStack(output);

        builder.addSlot(RecipeIngredientRole.CATALYST, 24, 52).addItemStack(recipe.getComponent().copy());

    }
}
