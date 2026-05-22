package com.example.sbwrender.mixin;

import com.example.sbwrender.Config;
import net.minecraft.server.level.ChunkMap;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import net.minecraft.world.entity.vehicle.Boat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ChunkMap.TrackedEntity.class)
public class TrackingRangeMixin {

    @Inject(method = "getRange", at = @At("HEAD"), cancellable = true)
    private void modifyTrackingRange(CallbackInfoReturnable<Integer> cir) {
        // Проверяем тип entity через reflection (упрощённо)
        // В реальном моде лучше хранить entity в поле
        cir.setReturnValue(Math.max(cir.getReturnValue(), Config.playerRange));
    }
}