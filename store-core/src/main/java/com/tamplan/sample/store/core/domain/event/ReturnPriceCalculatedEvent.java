package com.tamplan.sample.store.core.domain.event;

import com.tamplan.sample.store.lib.event.BaseEvent;

public class ReturnPriceCalculatedEvent extends BaseEvent {

    public ReturnPriceCalculatedEvent(String source) {
        super(source, StoreCoreEventType.RETURN_PRICE_CALCULATED.name());
    }
}
