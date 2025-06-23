package androidx.room;

import androidx.annotation.RequiresApi;

/* loaded from: classes.dex */
public final class FtsOptions {

    @OXOo.OOXIXo
    public static final FtsOptions INSTANCE = new FtsOptions();

    @OXOo.OOXIXo
    public static final String TOKENIZER_ICU = "icu";

    @OXOo.OOXIXo
    public static final String TOKENIZER_PORTER = "porter";

    @OXOo.OOXIXo
    public static final String TOKENIZER_SIMPLE = "simple";

    @OXOo.OOXIXo
    @RequiresApi(21)
    public static final String TOKENIZER_UNICODE61 = "unicode61";

    /* loaded from: classes.dex */
    public enum MatchInfo {
        FTS3,
        FTS4
    }

    /* loaded from: classes.dex */
    public enum Order {
        ASC,
        DESC
    }

    private FtsOptions() {
    }
}
