package de.lulkas_.vanilla_addons.enchantment;

import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Hand;

public class TotemReplaceSchedule {
    private int ticks;
    private final int level;
    private final Hand hand;
    private boolean isProcessed = false;
    private final ServerPlayerEntity player;

    public TotemReplaceSchedule(Hand hand, ServerPlayerEntity player, int ticks, int level) {
        this.hand = hand;
        this.player = player;
        this.ticks = ticks;
        this.level = level;
    }

    public void tick() {
        this.ticks--;
    }

    public boolean isReady() {
        return this.ticks <= 0;
    }

    public Hand getHand() {
        return hand;
    }

    public ServerPlayerEntity getPlayer() {
        return player;
    }

    public void process() {
        isProcessed = true;
    }

    public int getLevel() {
        return level;
    }

    public boolean shouldTick() {
        return !isProcessed;
    }
}
