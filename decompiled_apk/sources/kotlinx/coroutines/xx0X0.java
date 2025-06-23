package kotlinx.coroutines;

import org.apache.commons.lang3.ObjectUtils;

/* loaded from: classes6.dex */
public abstract class xx0X0 extends xXxxox0I implements I0oOIX, ooOx {

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public JobSupport f30492Oxx0xo;

    public final void O0xOxO(@OXOo.OOXIXo JobSupport jobSupport) {
        this.f30492Oxx0xo = jobSupport;
    }

    @OXOo.OOXIXo
    public final JobSupport OxI() {
        JobSupport jobSupport = this.f30492Oxx0xo;
        if (jobSupport != null) {
            return jobSupport;
        }
        kotlin.jvm.internal.IIX0o.XOxIOxOx("job");
        return null;
    }

    @Override // kotlinx.coroutines.I0oOIX
    public void dispose() {
        OxI().X0xII0I(this);
    }

    @Override // kotlinx.coroutines.ooOx
    @OXOo.oOoXoXO
    public XIXIxO getList() {
        return null;
    }

    @Override // kotlinx.coroutines.ooOx
    public boolean isActive() {
        return true;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    @OXOo.OOXIXo
    public String toString() {
        return OI0.oIX0oI(this) + ObjectUtils.f32506oIX0oI + OI0.II0xO0(this) + "[job@" + OI0.II0xO0(OxI()) + ']';
    }
}
