package de.lulkas_.vanilla_addons.event.custom;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;

public interface TickCallback {
    Event<TickCallback> EVENT = EventFactory.createArrayBacked(TickCallback.class,
            (listeners) -> () -> {
                for(TickCallback listener : listeners) {
                    listener.onTick();
                }
            });

    void onTick();
}
