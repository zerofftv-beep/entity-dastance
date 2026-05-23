package com.example.sbwrender;

import com.example.sbwrender.command.RenderDistanceCommand;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(SBWRenderDistance.MODID)
public class SBWRenderDistance {
    public static final String MODID = "sbwrender";

    public SBWRenderDistance() {
        FMLJavaModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.SPEC);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onRegisterCommands(RegisterCommandsEvent event) {
        RenderDistanceCommand.register(event.getDispatcher());
    }
}
