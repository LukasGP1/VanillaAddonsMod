package de.lulkas_.vanilla_addons.event.custom;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;

public interface TotemUseCallback {
    Event<TotemUseCallback> EVENT = EventFactory.createArrayBacked(TotemUseCallback.class,
            (listeners) -> (entity, stack, hand) -> {
                for(TotemUseCallback listerner : listeners) {
                    listerner.onTotemUsed(entity, stack,hand);
                }
            });

    void onTotemUsed(LivingEntity entity, ItemStack stack, Hand hand);
}
