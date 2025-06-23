package kotlinx.coroutines;

@kotlin.o0
/* loaded from: classes6.dex */
public class O0X extends JobSupport implements XI0IXoo {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public final boolean f29732IXxxXO;

    public O0X(@OXOo.oOoXoXO oXIO0o0XI oxio0o0xi) {
        super(true);
        IIX0(oxio0o0xi);
        this.f29732IXxxXO = OX();
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean I0() {
        return this.f29732IXxxXO;
    }

    @Override // kotlinx.coroutines.XI0IXoo
    public boolean I0Io(@OXOo.OOXIXo Throwable th) {
        return XIXIxO(new xxX(th, false, 2, null));
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001f, code lost:
    
        r0 = r0.XIXIX();
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0025, code lost:
    
        if ((r0 instanceof kotlinx.coroutines.xoXoI) == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0027, code lost:
    
        r0 = (kotlinx.coroutines.xoXoI) r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
    
        if (r0 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
    
        r0 = r0.OxI();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
    
        if (r0 != null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002a, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x001d, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0014, code lost:
    
        if (r0 != null) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
    
        if (r0.I0() == false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean OX() {
        /*
            r4 = this;
            kotlinx.coroutines.IIXOooo r0 = r4.XIXIX()
            boolean r1 = r0 instanceof kotlinx.coroutines.xoXoI
            r2 = 0
            if (r1 == 0) goto Lc
            kotlinx.coroutines.xoXoI r0 = (kotlinx.coroutines.xoXoI) r0
            goto Ld
        Lc:
            r0 = r2
        Ld:
            r1 = 0
            if (r0 == 0) goto L33
            kotlinx.coroutines.JobSupport r0 = r0.OxI()
            if (r0 != 0) goto L17
            goto L33
        L17:
            boolean r3 = r0.I0()
            if (r3 == 0) goto L1f
            r0 = 1
            return r0
        L1f:
            kotlinx.coroutines.IIXOooo r0 = r0.XIXIX()
            boolean r3 = r0 instanceof kotlinx.coroutines.xoXoI
            if (r3 == 0) goto L2a
            kotlinx.coroutines.xoXoI r0 = (kotlinx.coroutines.xoXoI) r0
            goto L2b
        L2a:
            r0 = r2
        L2b:
            if (r0 == 0) goto L33
            kotlinx.coroutines.JobSupport r0 = r0.OxI()
            if (r0 != 0) goto L17
        L33:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.O0X.OX():boolean");
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean OX00O0xII() {
        return true;
    }

    @Override // kotlinx.coroutines.XI0IXoo
    public boolean complete() {
        return XIXIxO(kotlin.oXIO0o0XI.f29392oIX0oI);
    }
}
