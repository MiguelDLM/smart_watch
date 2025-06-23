package com.sma.smartv3.pop.dial;

import OXOo.OOXIXo;
import android.app.Activity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter;
import com.sma.smartv3.model.ResourcesIdInfo;
import java.util.List;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public class BaseDialPop extends OOOI.oxoX {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OOXIXo
    public final LinearLayoutManager f21418II0XooXoX;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OOXIXo
    public final CommonAdapter<ResourcesIdInfo> f21419xxIXOIIO;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseDialPop(@OOXIXo Activity activity, @OOXIXo List<ResourcesIdInfo> colors, @OOXIXo com.sma.smartv3.util.OOXIXo<Integer> callback) {
        super(activity);
        IIX0o.x0xO0oo(activity, "activity");
        IIX0o.x0xO0oo(colors, "colors");
        IIX0o.x0xO0oo(callback, "callback");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        linearLayoutManager.setOrientation(0);
        this.f21418II0XooXoX = linearLayoutManager;
        this.f21419xxIXOIIO = new BaseDialPop$adapter$1(activity, colors, callback);
    }

    @OOXIXo
    public final CommonAdapter<ResourcesIdInfo> O0xOxO() {
        return this.f21419xxIXOIIO;
    }

    @OOXIXo
    public final LinearLayoutManager X0IIOO() {
        return this.f21418II0XooXoX;
    }
}
