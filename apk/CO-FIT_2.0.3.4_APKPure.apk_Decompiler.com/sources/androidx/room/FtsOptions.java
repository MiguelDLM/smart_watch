package androidx.room;

import OXOo.OOXIXo;
import androidx.annotation.RequiresApi;

public final class FtsOptions {
    @OOXIXo
    public static final FtsOptions INSTANCE = new FtsOptions();
    @OOXIXo
    public static final String TOKENIZER_ICU = "icu";
    @OOXIXo
    public static final String TOKENIZER_PORTER = "porter";
    @OOXIXo
    public static final String TOKENIZER_SIMPLE = "simple";
    @RequiresApi(21)
    @OOXIXo
    public static final String TOKENIZER_UNICODE61 = "unicode61";

    public enum MatchInfo {
        FTS3,
        FTS4
    }

    public enum Order {
        ASC,
        DESC
    }

    private FtsOptions() {
    }
}
