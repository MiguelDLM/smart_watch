package com.facebook.gamingservices.internal;

import OXOo.OOXIXo;
import java.util.Arrays;

/* loaded from: classes8.dex */
public enum TournamentSortOrder {
    LowerIsBetter("LOWER_IS_BETTER"),
    HigherIsBetter("HIGHER_IS_BETTER");


    @OOXIXo
    private final String rawValue;

    TournamentSortOrder(String str) {
        this.rawValue = str;
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static TournamentSortOrder[] valuesCustom() {
        TournamentSortOrder[] valuesCustom = values();
        return (TournamentSortOrder[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
    }

    @OOXIXo
    public final String getRawValue() {
        return this.rawValue;
    }

    @Override // java.lang.Enum
    @OOXIXo
    public String toString() {
        return this.rawValue;
    }
}
