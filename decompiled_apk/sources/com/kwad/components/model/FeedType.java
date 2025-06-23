package com.kwad.components.model;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.b.a;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes11.dex */
public enum FeedType {
    FEED_TYPE_UNKNOWN(0),
    FEED_TYPE_TEXT_IMMERSE(1),
    FEED_TYPE_TEXT_LEFT(2),
    FEED_TYPE_TEXT_RIGHT(3),
    FEED_TYPE_TEXT_ABOVE(4),
    FEED_TYPE_TEXT_BELOW(5),
    FEED_TYPE_TEXT_ABOVE_GROUP(6),
    FEED_TYPE_TEXT_NEW(7),
    FEED_TYPE_CONTENT_11(11),
    FEED_TYPE_CONTENT_12(12),
    FEED_TYPE_CONTENT_13(13);

    private int type;

    FeedType(int i) {
        this.type = i;
    }

    public static boolean checkTypeValid(@NonNull AdTemplate adTemplate) {
        int bd = a.bd(e.dS(adTemplate));
        int i = adTemplate.type;
        FeedType feedType = FEED_TYPE_TEXT_ABOVE_GROUP;
        if (i > feedType.type) {
            return true;
        }
        FeedType fromInt = fromInt(i);
        if (bd != 1) {
            if (bd != 2) {
                if (bd != 3) {
                    if (bd != 8) {
                        return false;
                    }
                } else {
                    if (fromInt != FEED_TYPE_UNKNOWN) {
                        return true;
                    }
                    return false;
                }
            } else {
                if (fromInt != FEED_TYPE_UNKNOWN && fromInt != feedType) {
                    return true;
                }
                return false;
            }
        }
        if (fromInt == FEED_TYPE_TEXT_ABOVE || fromInt == FEED_TYPE_TEXT_BELOW || fromInt == FEED_TYPE_TEXT_IMMERSE) {
            return true;
        }
        return false;
    }

    @NonNull
    public static FeedType fromInt(int i) {
        for (FeedType feedType : values()) {
            if (feedType.type == i) {
                return feedType;
            }
        }
        if (isH5Type(i)) {
            return FEED_TYPE_TEXT_NEW;
        }
        return FEED_TYPE_UNKNOWN;
    }

    private static boolean isH5Type(int i) {
        return i == 7 || i == 8 || i == 14 || i == 15 || i == 16 || i == 17 || i == 18 || i == 19 || i >= 2000;
    }

    public final int getType() {
        return this.type;
    }
}
