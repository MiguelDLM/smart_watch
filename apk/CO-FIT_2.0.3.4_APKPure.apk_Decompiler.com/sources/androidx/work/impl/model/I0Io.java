package androidx.work.impl.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import kotlin.jvm.internal.IIX0o;

public final /* synthetic */ class I0Io {
    public static void II0xO0(SystemIdInfoDao systemIdInfoDao, @OOXIXo WorkGenerationalId workGenerationalId) {
        IIX0o.x0xO0oo(workGenerationalId, "id");
        systemIdInfoDao.removeSystemIdInfo(workGenerationalId.getWorkSpecId(), workGenerationalId.getGeneration());
    }

    @oOoXoXO
    public static SystemIdInfo oIX0oI(SystemIdInfoDao systemIdInfoDao, @OOXIXo WorkGenerationalId workGenerationalId) {
        IIX0o.x0xO0oo(workGenerationalId, "id");
        return systemIdInfoDao.getSystemIdInfo(workGenerationalId.getWorkSpecId(), workGenerationalId.getGeneration());
    }
}
