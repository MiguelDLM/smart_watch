package okhttp3;

import OXOo.OOXIXo;
import java.io.IOException;
import okio.Timeout;

/* loaded from: classes6.dex */
public interface Call extends Cloneable {

    /* loaded from: classes6.dex */
    public interface Factory {
        @OOXIXo
        Call newCall(@OOXIXo Request request);
    }

    void cancel();

    @OOXIXo
    Call clone();

    void enqueue(@OOXIXo Callback callback);

    @OOXIXo
    Response execute() throws IOException;

    boolean isCanceled();

    boolean isExecuted();

    @OOXIXo
    Request request();

    @OOXIXo
    Timeout timeout();
}
