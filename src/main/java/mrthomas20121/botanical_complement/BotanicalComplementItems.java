package mrthomas20121.botanical_complement;

import mrthomas20121.botanical_complement.items.*;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static cofh.toolscomplement.ToolsComplement.TCOM_GROUP;

public class BotanicalComplementItems {

    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BotanicalComplement.MOD_ID);

    public static Item.Properties properties = new Item.Properties().tab(TCOM_GROUP);

    public static RegistryObject<Item> MANASTEEL_EXCAVATOR = ITEMS.register("manasteel_excavator", ManasteelExcavatorItem::new);
    public static RegistryObject<Item> MANASTEEL_HAMMER = ITEMS.register("manasteel_hammer", ManasteelHammerItem::new);
    public static RegistryObject<Item> MANASTEEL_KNIFE = ITEMS.register("manasteel_knife", ManasteelKnifeItem::new);
    public static RegistryObject<Item> MANASTEEL_SICKLE = ITEMS.register("manasteel_sickle", ManasteelSickleItem::new);

    public static RegistryObject<Item> ELEMENTIUM_EXCAVATOR = ITEMS.register("elementium_excavator", ElementiumlExcavatorItem::new);
    public static RegistryObject<Item> ELEMENTIUM_HAMMER = ITEMS.register("elementium_hammer", ElementiumlHammerItem::new);
    public static RegistryObject<Item> ELEMENTIUM_KNIFE = ITEMS.register("elementium_knife", ElementiumlKnifeItem::new);
    public static RegistryObject<Item> ELEMENTIUM_SICKLE = ITEMS.register("elementium_sickle", ElementiumlSickleItem::new);

    public static RegistryObject<Item> TERRASTEEL_EXCAVATOR = ITEMS.register("terrasteel_excavator", ElementiumlExcavatorItem::new);
    public static RegistryObject<Item> TERRASTEEL_HAMMER = ITEMS.register("terrasteel_hammer", ElementiumlHammerItem::new);
    public static RegistryObject<Item> TERRASTEEL_KNIFE = ITEMS.register("terrasteel_knife", ElementiumlKnifeItem::new);
    public static RegistryObject<Item> TERRASTEEL_SICKLE = ITEMS.register("terrasteel_sickle", ElementiumlSickleItem::new);

    public static RegistryObject<Item> ALFSTEEL_EXCAVATOR = ITEMS.register("alfsteel_excavator", ElementiumlExcavatorItem::new);
    public static RegistryObject<Item> ALFSTEEL_HAMMER = ITEMS.register("alfsteel_hammer", ElementiumlHammerItem::new);
    public static RegistryObject<Item> ALFSTEEL_KNIFE = ITEMS.register("alfsteel_knife", ElementiumlKnifeItem::new);
    public static RegistryObject<Item> ALFSTEEL_SICKLE = ITEMS.register("alfsteel_sickle", ElementiumlSickleItem::new);
}