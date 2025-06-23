package kotlinx.coroutines.internal;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.coroutines.CoroutineContext;

/* loaded from: classes6.dex */
public final class II0XooXoX implements kotlinx.coroutines.xII {

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final CoroutineContext f30222XO;

    public II0XooXoX(@OXOo.OOXIXo CoroutineContext coroutineContext) {
        this.f30222XO = coroutineContext;
    }

    @Override // kotlinx.coroutines.xII
    @OXOo.OOXIXo
    public CoroutineContext getCoroutineContext() {
        return this.f30222XO;
    }

    @OXOo.OOXIXo
    public String toString() {
        return "CoroutineScope(coroutineContext=" + getCoroutineContext() + HexStringBuilder.COMMENT_END_CHAR;
    }
}
