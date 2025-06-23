package com.sma.smartv3.model;

import OXOo.OOXIXo;
import kotlin.enums.I0Io;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes12.dex */
public final class AIFunctionType {
    private static final /* synthetic */ kotlin.enums.oIX0oI $ENTRIES;
    private static final /* synthetic */ AIFunctionType[] $VALUES;
    private final int type;
    public static final AIFunctionType AI = new AIFunctionType("AI", 0, 257);
    public static final AIFunctionType HEALTH_QA = new AIFunctionType("HEALTH_QA", 1, 258);
    public static final AIFunctionType PERSONAL_TRAINER = new AIFunctionType("PERSONAL_TRAINER", 2, 259);
    public static final AIFunctionType EAT_HEALTHY = new AIFunctionType("EAT_HEALTHY", 3, 260);
    public static final AIFunctionType DEAL_REVIEWS = new AIFunctionType("DEAL_REVIEWS", 4, 261);
    public static final AIFunctionType HIGH_EQ_RESPONSE = new AIFunctionType("HIGH_EQ_RESPONSE", 5, 262);
    public static final AIFunctionType SURNAME = new AIFunctionType("SURNAME", 6, 263);
    public static final AIFunctionType PSYCHOLOGICAL_COUNSELOR = new AIFunctionType("PSYCHOLOGICAL_COUNSELOR", 7, 264);
    public static final AIFunctionType COMPLIMENT_MASTERS = new AIFunctionType("COMPLIMENT_MASTERS", 8, 265);
    public static final AIFunctionType APOLOGIZE = new AIFunctionType("APOLOGIZE", 9, 266);
    public static final AIFunctionType DREAM_INTERPRETATION = new AIFunctionType("DREAM_INTERPRETATION", 10, 267);
    public static final AIFunctionType EVENT_PLANNING = new AIFunctionType("EVENT_PLANNING", 11, 513);
    public static final AIFunctionType SHORT_VIDEO_SCRIPTS = new AIFunctionType("SHORT_VIDEO_SCRIPTS", 12, 514);
    public static final AIFunctionType E_MARKET_COPY = new AIFunctionType("E_MARKET_COPY", 13, 515);
    public static final AIFunctionType DAILY_WEEKLY = new AIFunctionType("DAILY_WEEKLY", 14, 516);
    public static final AIFunctionType MARKET_ANALYSIS = new AIFunctionType("MARKET_ANALYSIS", 15, 517);
    public static final AIFunctionType MOMENTS_COPYWRITING = new AIFunctionType("MOMENTS_COPYWRITING", 16, 769);
    public static final AIFunctionType TRAVEL_GUIDES = new AIFunctionType("TRAVEL_GUIDES", 17, 770);
    public static final AIFunctionType LITTLE_RED_BOOK_STYLE = new AIFunctionType("LITTLE_RED_BOOK_STYLE", 18, 771);
    public static final AIFunctionType AI_TRANSLATION = new AIFunctionType("AI_TRANSLATION", 19, 1025);
    public static final AIFunctionType SIMULTANEOUS_INTERPRETATION = new AIFunctionType("SIMULTANEOUS_INTERPRETATION", 20, 1026);
    public static final AIFunctionType HEALTH_QA_ANALYZE = new AIFunctionType("HEALTH_QA_ANALYZE", 21, 1027);

    private static final /* synthetic */ AIFunctionType[] $values() {
        return new AIFunctionType[]{AI, HEALTH_QA, PERSONAL_TRAINER, EAT_HEALTHY, DEAL_REVIEWS, HIGH_EQ_RESPONSE, SURNAME, PSYCHOLOGICAL_COUNSELOR, COMPLIMENT_MASTERS, APOLOGIZE, DREAM_INTERPRETATION, EVENT_PLANNING, SHORT_VIDEO_SCRIPTS, E_MARKET_COPY, DAILY_WEEKLY, MARKET_ANALYSIS, MOMENTS_COPYWRITING, TRAVEL_GUIDES, LITTLE_RED_BOOK_STYLE, AI_TRANSLATION, SIMULTANEOUS_INTERPRETATION, HEALTH_QA_ANALYZE};
    }

    static {
        AIFunctionType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = I0Io.I0Io($values);
    }

    private AIFunctionType(String str, int i, int i2) {
        this.type = i2;
    }

    @OOXIXo
    public static kotlin.enums.oIX0oI<AIFunctionType> getEntries() {
        return $ENTRIES;
    }

    public static AIFunctionType valueOf(String str) {
        return (AIFunctionType) Enum.valueOf(AIFunctionType.class, str);
    }

    public static AIFunctionType[] values() {
        return (AIFunctionType[]) $VALUES.clone();
    }

    public final int getType() {
        return this.type;
    }
}
