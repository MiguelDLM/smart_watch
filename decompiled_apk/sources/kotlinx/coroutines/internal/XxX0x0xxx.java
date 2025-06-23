package kotlinx.coroutines.internal;

import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.coroutines.CoroutineContext;
import kotlin.oXIO0o0XI;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.I0oOIX;
import kotlinx.coroutines.XoX;
import kotlinx.coroutines.o0oIxOo;

@kotlin.jvm.internal.XX({"SMAP\nMainDispatchers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainDispatchers.kt\nkotlinx/coroutines/internal/MissingMainCoroutineDispatcher\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,134:1\n1#2:135\n*E\n"})
/* loaded from: classes6.dex */
public final class XxX0x0xxx extends o0oIxOo implements kotlinx.coroutines.XoX {

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.oOoXoXO
    public final String f30290Oo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.oOoXoXO
    public final Throwable f30291XO;

    public /* synthetic */ XxX0x0xxx(Throwable th, String str, int i, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(th, (i & 2) != 0 ? null : str);
    }

    @Override // kotlinx.coroutines.o0oIxOo
    @OXOo.OOXIXo
    public o0oIxOo IIXOooo() {
        return this;
    }

    @Override // kotlinx.coroutines.XoX
    @OXOo.OOXIXo
    public I0oOIX Oxx0xo(long j, @OXOo.OOXIXo Runnable runnable, @OXOo.OOXIXo CoroutineContext coroutineContext) {
        X0IIOO();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.XoX
    @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
    @OXOo.oOoXoXO
    public Object OxxIIOOXO(long j, @OXOo.OOXIXo kotlin.coroutines.I0Io<? super oXIO0o0XI> i0Io) {
        return XoX.oIX0oI.oIX0oI(this, j, i0Io);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0023, code lost:
    
        if (r1 == null) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Void X0IIOO() {
        /*
            r4 = this;
            java.lang.Throwable r0 = r4.f30291XO
            if (r0 == 0) goto L36
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Module with the Main dispatcher had failed to initialize"
            r0.append(r1)
            java.lang.String r1 = r4.f30290Oo
            if (r1 == 0) goto L25
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = ". "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            if (r1 != 0) goto L27
        L25:
            java.lang.String r1 = ""
        L27:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.Throwable r2 = r4.f30291XO
            r1.<init>(r0, r2)
            throw r1
        L36:
            kotlinx.coroutines.internal.xxX.X0o0xo()
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.XxX0x0xxx.X0IIOO():java.lang.Void");
    }

    @Override // kotlinx.coroutines.XoX
    @OXOo.OOXIXo
    /* renamed from: XIxXXX0x0, reason: merged with bridge method [inline-methods] */
    public Void OOXIXo(long j, @OXOo.OOXIXo kotlinx.coroutines.oO<? super oXIO0o0XI> oOVar) {
        X0IIOO();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(@OXOo.OOXIXo CoroutineContext coroutineContext) {
        X0IIOO();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.o0oIxOo, kotlinx.coroutines.CoroutineDispatcher
    @OXOo.OOXIXo
    public CoroutineDispatcher limitedParallelism(int i) {
        X0IIOO();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @OXOo.OOXIXo
    /* renamed from: o00, reason: merged with bridge method [inline-methods] */
    public Void dispatch(@OXOo.OOXIXo CoroutineContext coroutineContext, @OXOo.OOXIXo Runnable runnable) {
        X0IIOO();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.o0oIxOo, kotlinx.coroutines.CoroutineDispatcher
    @OXOo.OOXIXo
    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Dispatchers.Main[missing");
        if (this.f30291XO != null) {
            str = ", cause=" + this.f30291XO;
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(']');
        return sb.toString();
    }

    public XxX0x0xxx(@OXOo.oOoXoXO Throwable th, @OXOo.oOoXoXO String str) {
        this.f30291XO = th;
        this.f30290Oo = str;
    }
}
