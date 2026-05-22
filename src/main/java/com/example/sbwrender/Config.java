package com.example.sbwrender;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = SBWRenderDistance.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {

    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    public static final ForgeConfigSpec.IntValue PLAYER_TRACKING_RANGE = BUILDER
            .comment("Tracking range for players (in blocks). Default: 128, Recommended: 256-512")
            .defineInRange("playerTrackingRange", 256, 64, 512);

    public static final ForgeConfigSpec.IntValue VEHICLE_TRACKING_RANGE = BUILDER
            .comment("Tracking range for vehicles (in blocks)")
            .defineInRange("vehicleTrackingRange", 256, 64, 512);

    public static final ForgeConfigSpec SPEC = BUILDER.build();

    public static int playerRange = 256;
    public static int vehicleRange = 256;

    @SubscribeEvent
    public static void onLoad(final ModConfigEvent.Loading event) {
        playerRange = PLAYER_TRACKING_RANGE.get();
        vehicleRange = VEHICLE_TRACKING_RANGE.get();
    }

    @SubscribeEvent
    public static void onReload(final ModConfigEvent.Reloading event) {
        playerRange = PLAYER_TRACKING_RANGE.get();
        vehicleRange = VEHICLE_TRACKING_RANGE.get();
    }
}