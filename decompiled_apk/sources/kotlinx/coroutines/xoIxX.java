package kotlinx.coroutines;

/* loaded from: classes6.dex */
public final class xoIxX implements ooOx {

    /* renamed from: XO, reason: collision with root package name */
    public final boolean f30488XO;

    public xoIxX(boolean z) {
        this.f30488XO = z;
    }

    @Override // kotlinx.coroutines.ooOx
    @OXOo.oOoXoXO
    public XIXIxO getList() {
        return null;
    }

    @Override // kotlinx.coroutines.ooOx
    public boolean isActive() {
        return this.f30488XO;
    }

    @OXOo.OOXIXo
    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Empty{");
        if (isActive()) {
            str = "Active";
        } else {
            str = "New";
        }
        sb.append(str);
        sb.append('}');
        return sb.toString();
    }
}
