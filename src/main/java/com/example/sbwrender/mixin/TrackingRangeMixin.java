package com.example.sbwrender.mixin;

import com.example.sbwrender.Config;
import net.minecraft.server.level.ChunkMap;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ChunkMap.class)
public class TrackingRangeMixin {

    @Inject(method = "getEntityTrackingRange", at = @At("HEAD"), cancellable = true)
    private static void modifyTrackingRange(Entity entity, CallbackInfoReturnable<Integer> cir) {
        if (entity instanceof Player) {
            cir.setReturnValue(Config.playerRange);
        } else if (entity.getType().toString().contains("vehicle") || 
                   entity.getType().toString().contains("tank") || 
                   entity.getType().toString().contains("helicopter")) {
            cir.setReturnValue(Config.vehicleRange);
        }
    }
}
