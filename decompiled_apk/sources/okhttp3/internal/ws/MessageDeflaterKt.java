package okhttp3.internal.ws;

import OXOo.OOXIXo;
import okio.ByteString;

/* loaded from: classes6.dex */
public final class MessageDeflaterKt {

    @OOXIXo
    private static final ByteString EMPTY_DEFLATE_BLOCK = ByteString.Companion.decodeHex("000000ffff");
    private static final int LAST_OCTETS_COUNT_TO_REMOVE_AFTER_DEFLATION = 4;
}
