package mrthomas20121.botanical_complement.items;

import cofh.core.item.SickleItem;
import mrthomas20121.botanical_complement.BotanicalComplementItems;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.common.item.equipment.CustomDamageItem;
import vazkii.botania.common.item.equipment.tool.ToolCommons;

import java.util.function.Consumer;

public class ElementiumlSickleItem extends SickleItem implements CustomDamageItem {

    public ElementiumlSickleItem() {
        super(BotaniaAPI.instance().getElementiumItemTier(), 3, BotanicalComplementItems.properties);
    }

    public int getManaPerDamage() {
        return 60;
    }

    @Override
    public <T extends LivingEntity> int damageItem(ItemStack stack, int amount, T entity, Consumer<T> onBroken) {
        int manaPerDamage = ((ElementiumlSickleItem) stack.getItem()).getManaPerDamage();
        return ToolCommons.damageItemIfPossible(stack, amount, entity, manaPerDamage);
    }
}
