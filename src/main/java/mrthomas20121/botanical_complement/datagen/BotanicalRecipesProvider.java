package mrthomas20121.botanical_complement.datagen;

import cofh.lib.data.RecipeProviderCoFH;
import mrthomas20121.botanical_complement.BotanicalComplement;
import mrthomas20121.botanical_complement.BotanicalComplementItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import vazkii.botania.common.block.BotaniaBlocks;
import vazkii.botania.common.item.BotaniaItems;

import java.util.function.Consumer;

public class BotanicalRecipesProvider extends RecipeProviderCoFH {

    public BotanicalRecipesProvider(DataGenerator generatorIn) {
        super(generatorIn, BotanicalComplement.MOD_ID);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {

        excavatorRecipe(consumer, BotanicalComplementItems.MANASTEEL_EXCAVATOR.get(), BotaniaBlocks.manasteelBlock, BotaniaItems.manaSteel, BotaniaItems.livingwoodTwig);
        excavatorRecipe(consumer, BotanicalComplementItems.ELEMENTIUM_EXCAVATOR.get(), BotaniaBlocks.elementiumBlock, BotaniaItems.elementium, BotaniaItems.dreamwoodTwig);
        excavatorRecipe(consumer, BotanicalComplementItems.TERRASTEEL_EXCAVATOR.get(), BotaniaBlocks.terrasteelBlock, BotaniaItems.terrasteel, BotaniaItems.livingwoodTwig);

        hammerRecipe(consumer, BotanicalComplementItems.MANASTEEL_HAMMER.get(), BotaniaBlocks.manasteelBlock, BotaniaItems.manaSteel, BotaniaItems.livingwoodTwig);
        hammerRecipe(consumer, BotanicalComplementItems.ELEMENTIUM_HAMMER.get(), BotaniaBlocks.elementiumBlock, BotaniaItems.elementium, BotaniaItems.dreamwoodTwig);
        hammerRecipe(consumer, BotanicalComplementItems.TERRASTEEL_HAMMER.get(), BotaniaBlocks.terrasteelBlock, BotaniaItems.terrasteel, BotaniaItems.livingwoodTwig);

        sickleRecipe(consumer, BotanicalComplementItems.MANASTEEL_SICKLE.get(), BotaniaItems.manaSteel, BotaniaItems.livingwoodTwig);
        sickleRecipe(consumer, BotanicalComplementItems.ELEMENTIUM_SICKLE.get(), BotaniaItems.elementium, BotaniaItems.dreamwoodTwig);
        sickleRecipe(consumer, BotanicalComplementItems.TERRASTEEL_SICKLE.get(), BotaniaItems.terrasteel, BotaniaItems.livingwoodTwig);

        knifeRecipe(consumer, BotanicalComplementItems.MANASTEEL_KNIFE.get(), BotaniaItems.manaSteel, BotaniaItems.livingwoodTwig);
        knifeRecipe(consumer, BotanicalComplementItems.ELEMENTIUM_KNIFE.get(), BotaniaItems.elementium, BotaniaItems.dreamwoodTwig);
        knifeRecipe(consumer, BotanicalComplementItems.TERRASTEEL_KNIFE.get(), BotaniaItems.terrasteel, BotaniaItems.livingwoodTwig);
    }

    public ShapedRecipeBuilder toolRecipe(ItemLike output, Item material, Item stick) {
        return ShapedRecipeBuilder.shaped(output)
                .define('M', material)
                .define('S', stick)
                .unlockedBy(getHasName(material), has(material));
    }

    public void hammerRecipe(Consumer<FinishedRecipe> consumer, ItemLike output, ItemLike block, Item material, Item stick) {
        toolRecipe(output, material, stick)
                .define('B', block)
                .pattern("MBM")
                .pattern("MSM")
                .pattern(" S ")
                .save(consumer);
    }

    public void sickleRecipe(Consumer<FinishedRecipe> consumer, ItemLike output, Item material, Item stick) {
        toolRecipe(output, material, stick)
                .pattern(" M ")
                .pattern("  M")
                .pattern("SM ")
                .save(consumer);
    }

    public void excavatorRecipe(Consumer<FinishedRecipe> consumer, ItemLike output, ItemLike block, Item material, Item stick) {
        toolRecipe(output, material, stick)
                .define('B', block)
                .pattern(" B ")
                .pattern("MSM")
                .pattern(" S ")
                .save(consumer);
    }

    public void knifeRecipe(Consumer<FinishedRecipe> consumer, ItemLike output, Item material, Item stick) {
        toolRecipe(output, material, stick)
                .pattern(" M")
                .pattern("S ")
                .save(consumer);
    }
}
