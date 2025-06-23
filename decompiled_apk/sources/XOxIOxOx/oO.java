package XOxIOxOx;

import com.bestmafen.baseble.scanner.ScanMode;
import java.util.UUID;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class oO {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oO f3971oIX0oI = new oO();

    public static /* synthetic */ II0xO0 II0xO0(oO oOVar, UUID[] uuidArr, ScanMode scanMode, int i, Object obj) {
        if ((i & 1) != 0) {
            uuidArr = null;
        }
        if ((i & 2) != 0) {
            scanMode = ScanMode.BALANCED;
        }
        return oOVar.oIX0oI(uuidArr, scanMode);
    }

    @OXOo.OOXIXo
    public final II0xO0 oIX0oI(@OXOo.oOoXoXO UUID[] uuidArr, @OXOo.OOXIXo ScanMode scanMode) {
        IIX0o.x0xO0oo(scanMode, "scanMode");
        return new oOoXoXO(uuidArr, scanMode);
    }
}
