package com.Infinity.Nexus.Mod.item;

import com.Infinity.Nexus.Mod.InfinityNexusMod;
import com.Infinity.Nexus.Mod.utils.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier INFINITY = TierSortingRegistry.registerTier(
            new ForgeTier(
                    7,
                    -1,
                    30,
                    -1,
                    70,
                    BlockTags.NEEDS_DIAMOND_TOOL, () -> Ingredient.of(ModItemsAdditions.INFINITY_INGOT.get())),
            new ResourceLocation(InfinityNexusMod.MOD_ID, "infinity"), List.of(Tiers.NETHERITE), List.of());

    public static final Tier IMPERIAL = TierSortingRegistry.registerTier(
            new ForgeTier(
                    8,
                    -1,
                    35,
                    -1,
                    80,
                    BlockTags.NEEDS_DIAMOND_TOOL, () -> Ingredient.of(ModItemsAdditions.INFINITY_INGOT.get())),
            new ResourceLocation(InfinityNexusMod.MOD_ID, "imperial"), List.of(Tiers.NETHERITE), List.of());

}