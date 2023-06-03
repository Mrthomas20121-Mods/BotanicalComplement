package mrthomas20121.botanical_complement.datagen;

import cofh.lib.data.RecipeProviderCoFH;
import mrthomas20121.botanical_complement.BotanicalComplement;
import mrthomas20121.botanical_complement.BotanicalComplementItems;
import mythicbotany.register.ModBlocks;
import mythicbotany.register.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.UpgradeRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;
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

        alfsteelSmithing(withConditions(consumer).addCondition(new ModLoadedCondition("mythicbotany")), BotanicalComplementItems.TERRASTEEL_EXCAVATOR.get(), BotanicalComplementItems.ALFSTEEL_EXCAVATOR.get());
        alfsteelSmithing(withConditions(consumer).addCondition(new ModLoadedCondition("mythicbotany")), BotanicalComplementItems.TERRASTEEL_HAMMER.get(), BotanicalComplementItems.ALFSTEEL_HAMMER.get());
        alfsteelSmithing(withConditions(consumer).addCondition(new ModLoadedCondition("mythicbotany")), BotanicalComplementItems.TERRASTEEL_SICKLE.get(), BotanicalComplementItems.ALFSTEEL_SICKLE.get());
        alfsteelSmithing(withConditions(consumer).addCondition(new ModLoadedCondition("mythicbotany")), BotanicalComplementItems.TERRASTEEL_KNIFE.get(), BotanicalComplementItems.ALFSTEEL_KNIFE.get());
    }

    protected static void alfsteelSmithing(Consumer<FinishedRecipe> p_125995_, Item p_125996_, Item p_125997_) {
        UpgradeRecipeBuilder.smithing(Ingredient.of(p_125996_), Ingredient.of(ModItems.alfsteelIngot), p_125997_).unlocks("has_alfsteel_ingot", has(ModItems.alfsteelIngot)).save(p_125995_, getItemName(p_125997_) + "_smithing");
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
