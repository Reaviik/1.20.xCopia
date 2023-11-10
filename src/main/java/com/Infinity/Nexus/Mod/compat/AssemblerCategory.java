package com.Infinity.Nexus.Mod.compat;

import com.Infinity.Nexus.Mod.InfinityNexusMod;
import com.Infinity.Nexus.Mod.block.ModBlocksAdditions;
import com.Infinity.Nexus.Mod.recipe.AssemblerRecipes;
import com.Infinity.Nexus.Mod.slots.ComponentSlot;
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

public class AssemblerCategory implements IRecipeCategory<AssemblerRecipes> {

    public static final ResourceLocation UID = new ResourceLocation(InfinityNexusMod.MOD_ID, "assembly");
    public static final ResourceLocation TEXTURE = new ResourceLocation(InfinityNexusMod.MOD_ID, "textures/gui/jei/assembly_gui.png");

    public static final RecipeType<AssemblerRecipes> ASSEMBLY_TYPE = new RecipeType<>(UID, AssemblerRecipes.class);

    private final IDrawable background;
    private final IDrawable icon;

    public AssemblerCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 75);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocksAdditions.ASSEMBLY.get()));
    }

    @Override
    public RecipeType<AssemblerRecipes> getRecipeType() {
        return ASSEMBLY_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.infinity_nexus_mod.assembly");
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
    public void setRecipe(IRecipeLayoutBuilder builder, AssemblerRecipes recipe, IFocusGroup focuses) {

        ItemStack output = recipe.getResultItem(null);
        output.setCount(recipe.getResultCount());

        builder.addSlot(RecipeIngredientRole.INPUT, 58 , 6).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 81 , 6).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.INPUT, 104, 6).addIngredients(recipe.getIngredients().get(2));
        builder.addSlot(RecipeIngredientRole.INPUT, 58 , 29).addIngredients(recipe.getIngredients().get(3));
        builder.addSlot(RecipeIngredientRole.INPUT, 104, 29).addIngredients(recipe.getIngredients().get(4));
        builder.addSlot(RecipeIngredientRole.INPUT, 58 , 52).addIngredients(recipe.getIngredients().get(5));
        builder.addSlot(RecipeIngredientRole.INPUT, 81 , 52).addIngredients(recipe.getIngredients().get(6));
        builder.addSlot(RecipeIngredientRole.INPUT, 104, 52).addIngredients(recipe.getIngredients().get(7));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 81 , 29).addItemStack(output);

        builder.addSlot(RecipeIngredientRole.CATALYST, 24, 52).addItemStack(recipe.getComponent().copy());

    }
}
