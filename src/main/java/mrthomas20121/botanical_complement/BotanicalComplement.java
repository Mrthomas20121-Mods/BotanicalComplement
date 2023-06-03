package mrthomas20121.botanical_complement;

//import mrthomas20121.botanical_complement.datagen.BotanicalRecipesProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(BotanicalComplement.MOD_ID)
public class BotanicalComplement {

	public static final String MOD_ID = "botanical_complement";
	public static final Logger LOGGER = LogManager.getLogger();

	public BotanicalComplement() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		BotanicalComplementItems.ITEMS.register(bus);

		bus.addListener(this::datagen);
	}

	public void datagen(GatherDataEvent event) {
		//event.getGenerator().addProvider(event.includeServer(), new BotanicalRecipesProvider(event.getGenerator()));
	}
}
