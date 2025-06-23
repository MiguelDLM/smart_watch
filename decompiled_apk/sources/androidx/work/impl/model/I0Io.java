package androidx.work.impl.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes.dex */
public final /* synthetic */ class I0Io {
    public static void II0xO0(SystemIdInfoDao systemIdInfoDao, @OOXIXo WorkGenerationalId id) {
        IIX0o.x0xO0oo(id, "id");
        systemIdInfoDao.removeSystemIdInfo(id.getWorkSpecId(), id.getGeneration());
    }

    @oOoXoXO
    public static SystemIdInfo oIX0oI(SystemIdInfoDao systemIdInfoDao, @OOXIXo WorkGenerationalId id) {
        IIX0o.x0xO0oo(id, "id");
        return systemIdInfoDao.getSystemIdInfo(id.getWorkSpecId(), id.getGeneration());
    }
}
