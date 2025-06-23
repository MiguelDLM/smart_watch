package okhttp3;

import OXOo.OOXIXo;
import java.io.IOException;

/* loaded from: classes6.dex */
public interface Callback {
    void onFailure(@OOXIXo Call call, @OOXIXo IOException iOException);

    void onResponse(@OOXIXo Call call, @OOXIXo Response response) throws IOException;
}
