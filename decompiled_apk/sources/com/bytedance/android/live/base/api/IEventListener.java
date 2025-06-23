package com.bytedance.android.live.base.api;

import java.util.HashMap;

/* loaded from: classes8.dex */
public interface IEventListener {

    /* loaded from: classes8.dex */
    public static class Event {
        public static final String KEY_ENTER_FROM_TOB = "enter_from_tob";
        public static final String KEY_OPEN_ROOM_ID = "open_room_id";
        public static final String KEY_SEC_ROOM_ID = "sec_room_id";
        public static final int TYPE_COMMENT = 4;
        public static final int TYPE_ENTER = 1;
        public static final int TYPE_EXIT = 2;
        public static final int TYPE_FOLLOW = 3;
        public static final int TYPE_LIVE_CHANNEL_ITEM_DURATION = 8;
        public static final int TYPE_ORDER = 5;
        public static final int TYPE_ORDER_PAYMENT_SUCCESS = 7;
        public static final int TYPE_ORDER_PAYMENT_SUCCESS_PAGE_SHOW = 6;
        public static final int TYPE_UNKNOWN = 0;
        public HashMap<String, String> extra = new HashMap<>();
        public long time;
        public int type;

        public Event() {
        }

        public Event(int i, long j) {
            this.type = i;
            this.time = j;
        }
    }

    /* loaded from: classes8.dex */
    public static class TypeEvent {
        public static final int TYPE_ACTIVITY_FINISH_BY_BACKGROUND_AND_SCREEN = 1000;
    }

    void onEvent(Event event);
}
