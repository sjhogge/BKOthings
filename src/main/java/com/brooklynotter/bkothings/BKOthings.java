package com.brooklynotter.bkothings;

import com.brooklynotter.bkothings.util.RegistryHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/* Ideas
- Death Counter
- Spawn Random Mob
- Passive Otter Mob
- Streamer Ores (emotes can be mined)
 */

@Mod("bkothings")
public class BKOthings
{
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "bkothings";

    public BKOthings() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        RegistryHandler.init();

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) { }

    private void doClientStuff(final FMLClientSetupEvent event) { }
}
