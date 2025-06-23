package androidx.core.net;

import androidx.annotation.NonNull;

public class ParseException extends RuntimeException {
    @NonNull
    public final String response;

    public ParseException(@NonNull String str) {
        super(str);
        this.response = str;
    }
}
