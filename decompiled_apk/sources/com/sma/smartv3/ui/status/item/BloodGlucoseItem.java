package com.sma.smartv3.ui.status.item;

import android.view.View;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.dsl.BaseDslItem;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.BloodGlucoseDao;
import com.sma.smartv3.db.entity.BloodGlucose;
import com.sma.smartv3.util.x0xO0oo;
import com.sma.smartv3.view.text.DINCondBold;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.oxxXoxO;

/* loaded from: classes12.dex */
public final class BloodGlucoseItem extends BaseDslItem {
    private DINCondBold lastTime;
    private DINCondBold lastValue;

    @OXOo.OOXIXo
    private final BloodGlucoseDao mBloodGlucoseDao = MyDb.INSTANCE.getMDatabase().bloodGlucoseDao();
    private final boolean initEvent = true;

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void bindView(@OXOo.OOXIXo DslViewHolder itemHolder) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
        View v = itemHolder.v(R.id.lastTime);
        IIX0o.ooOOo0oXI(v);
        this.lastTime = (DINCondBold) v;
        View v2 = itemHolder.v(R.id.lastValue);
        IIX0o.ooOOo0oXI(v2);
        this.lastValue = (DINCondBold) v2;
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public boolean getInitEvent() {
        return this.initEvent;
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
        List<BloodGlucose> lastData = this.mBloodGlucoseDao.getLastData();
        DINCondBold dINCondBold = null;
        if (lastData.isEmpty()) {
            DINCondBold dINCondBold2 = this.lastTime;
            if (dINCondBold2 == null) {
                IIX0o.XOxIOxOx("lastTime");
                dINCondBold2 = null;
            }
            dINCondBold2.setText(R.string.data_none);
            DINCondBold dINCondBold3 = this.lastValue;
            if (dINCondBold3 == null) {
                IIX0o.XOxIOxOx("lastValue");
            } else {
                dINCondBold = dINCondBold3;
            }
            dINCondBold.setText(R.string.data_none);
            return;
        }
        DINCondBold dINCondBold4 = this.lastTime;
        if (dINCondBold4 == null) {
            IIX0o.XOxIOxOx("lastTime");
            dINCondBold4 = null;
        }
        dINCondBold4.setText(TimeUtils.millis2String(((BloodGlucose) CollectionsKt___CollectionsKt.O0OOX0IIx(lastData)).getMTime(), com.sma.smartv3.util.xoIox.oo0xXOI0I()));
        DINCondBold dINCondBold5 = this.lastValue;
        if (dINCondBold5 == null) {
            IIX0o.XOxIOxOx("lastValue");
        } else {
            dINCondBold = dINCondBold5;
        }
        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
        String format = String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(((BloodGlucose) CollectionsKt___CollectionsKt.O0OOX0IIx(lastData)).getMValue() / 10.0f)}, 1));
        IIX0o.oO(format, "format(...)");
        dINCondBold.setText(format);
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.status_item_blood_glucose;
    }

    @XO0.XO(tag = x0xO0oo.f24648x0XOIxOo)
    public final void onBloodGlucoseChanged(@OXOo.OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        LogUtils.v("onBloodGlucoseChanged");
        initView();
    }
}
