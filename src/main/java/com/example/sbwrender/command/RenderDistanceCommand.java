package com.example.sbwrender.command;

import com.example.sbwrender.Config;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;

public class RenderDistanceCommand {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("renderdistance")
            .requires(source -> source.hasPermission(2))
            .then(Commands.literal("players")
                .then(Commands.argument("range", IntegerArgumentType.integer(64, 512))
                    .executes(ctx -> {
                        int range = IntegerArgumentType.getInteger(ctx, "range");
                        Config.playerRange = range;
                        ctx.getSource().sendSuccess(() -> 
                            Component.literal("Player tracking range set to " + range), true);
                        return 1;
                    })))
            .then(Commands.literal("vehicles")
                .then(Commands.argument("range", IntegerArgumentType.integer(64, 512))
                    .executes(ctx -> {
                        int range = IntegerArgumentType.getInteger(ctx, "range");
                        Config.vehicleRange = range;
                        ctx.getSource().sendSuccess(() -> 
                            Component.literal("Vehicle tracking range set to " + range), true);
                        return 1;
                    })))
        );
    }
}