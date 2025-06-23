package androidx.work.impl.utils;

import Oox.oIX0oI;
import android.content.Context;
import androidx.work.ForegroundInfo;
import java.util.UUID;

public final /* synthetic */ class oI0IIXIo implements oIX0oI {

    /* renamed from: IXxxXO  reason: collision with root package name */
    public final /* synthetic */ ForegroundInfo f552IXxxXO;

    /* renamed from: Oo  reason: collision with root package name */
    public final /* synthetic */ UUID f553Oo;

    /* renamed from: Oxx0xo  reason: collision with root package name */
    public final /* synthetic */ Context f554Oxx0xo;

    /* renamed from: XO  reason: collision with root package name */
    public final /* synthetic */ WorkForegroundUpdater f555XO;

    public /* synthetic */ oI0IIXIo(WorkForegroundUpdater workForegroundUpdater, UUID uuid, ForegroundInfo foregroundInfo, Context context) {
        this.f555XO = workForegroundUpdater;
        this.f553Oo = uuid;
        this.f552IXxxXO = foregroundInfo;
        this.f554Oxx0xo = context;
    }

    public final Object invoke() {
        return this.f555XO.lambda$setForegroundAsync$0(this.f553Oo, this.f552IXxxXO, this.f554Oxx0xo);
    }
}
