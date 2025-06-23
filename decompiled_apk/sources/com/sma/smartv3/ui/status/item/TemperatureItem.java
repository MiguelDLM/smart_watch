package com.sma.smartv3.ui.status.item;

import android.view.View;
import com.angcyo.dsladapter.DslViewHolder;
import com.bestmafen.androidbase.dsl.BaseDslItem;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.google.gson.Gson;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.TemperatureDao;
import com.sma.smartv3.db.entity.Temperature;
import com.sma.smartv3.model.AppUser;
import com.sma.smartv3.util.TextConvertKt;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.x0xO0oo;
import com.sma.smartv3.view.text.DINCondBold;
import com.sma.smartv3.view.text.PFRegular;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nTemperatureItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TemperatureItem.kt\ncom/sma/smartv3/ui/status/item/TemperatureItem\n+ 2 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n1#1,53:1\n19#2:54\n15#2:55\n*S KotlinDebug\n*F\n+ 1 TemperatureItem.kt\ncom/sma/smartv3/ui/status/item/TemperatureItem\n*L\n34#1:54\n34#1:55\n*E\n"})
/* loaded from: classes12.dex */
public final class TemperatureItem extends BaseDslItem {
    private DINCondBold tempLastTime;
    private DINCondBold tempLastValue;
    private PFRegular tmpUnit;

    @OXOo.OOXIXo
    private final TemperatureDao mTemperatureDao = MyDb.INSTANCE.getMDatabase().temperatureDao();
    private final boolean initEvent = true;

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void bindView(@OXOo.OOXIXo DslViewHolder itemHolder) {
        IIX0o.x0xO0oo(itemHolder, "itemHolder");
        View v = itemHolder.v(R.id.tempLastTime);
        IIX0o.ooOOo0oXI(v);
        this.tempLastTime = (DINCondBold) v;
        View v2 = itemHolder.v(R.id.tempLastValue);
        IIX0o.ooOOo0oXI(v2);
        this.tempLastValue = (DINCondBold) v2;
        View v3 = itemHolder.v(R.id.tmpUnit);
        IIX0o.ooOOo0oXI(v3);
        this.tmpUnit = (PFRegular) v3;
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public boolean getInitEvent() {
        return this.initEvent;
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public void initView() {
        boolean z;
        int i;
        SPUtils XO2 = Xo0.f24349oIX0oI.XO();
        Object appUser = new AppUser(0, null, null, null, null, null, null, 0, 0, 0.0f, 0.0f, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0, null, null, null, null, null, 67108863, null);
        Object fromJson = new Gson().fromJson(XO2.getString(AppUser.class.getName()), (Class<Object>) AppUser.class);
        if (fromJson != null) {
            appUser = fromJson;
        }
        AppUser appUser2 = (AppUser) appUser;
        List<Temperature> lastData = this.mTemperatureDao.getLastData();
        PFRegular pFRegular = null;
        if (lastData.isEmpty()) {
            DINCondBold dINCondBold = this.tempLastTime;
            if (dINCondBold == null) {
                IIX0o.XOxIOxOx("tempLastTime");
                dINCondBold = null;
            }
            dINCondBold.setText(R.string.data_none);
            DINCondBold dINCondBold2 = this.tempLastValue;
            if (dINCondBold2 == null) {
                IIX0o.XOxIOxOx("tempLastValue");
                dINCondBold2 = null;
            }
            dINCondBold2.setText(R.string.data_none);
        } else {
            DINCondBold dINCondBold3 = this.tempLastTime;
            if (dINCondBold3 == null) {
                IIX0o.XOxIOxOx("tempLastTime");
                dINCondBold3 = null;
            }
            dINCondBold3.setText(TimeUtils.millis2String(((Temperature) CollectionsKt___CollectionsKt.O0OOX0IIx(lastData)).getMTime(), com.sma.smartv3.util.xoIox.oo0xXOI0I()));
            DINCondBold dINCondBold4 = this.tempLastValue;
            if (dINCondBold4 == null) {
                IIX0o.XOxIOxOx("tempLastValue");
                dINCondBold4 = null;
            }
            float mTemperature = ((Temperature) CollectionsKt___CollectionsKt.O0OOX0IIx(lastData)).getMTemperature() / 10.0f;
            if (TextConvertKt.XI0IXoo(appUser2.getUnit()) == 1) {
                z = true;
            } else {
                z = false;
            }
            dINCondBold4.setText(String.valueOf(TextConvertKt.XIxXXX0x0(mTemperature, z)));
        }
        PFRegular pFRegular2 = this.tmpUnit;
        if (pFRegular2 == null) {
            IIX0o.XOxIOxOx("tmpUnit");
        } else {
            pFRegular = pFRegular2;
        }
        if (TextConvertKt.XI0IXoo(appUser2.getUnit()) == 1) {
            i = R.string.fahrenheit;
        } else {
            i = R.string.degree_centigrade;
        }
        pFRegular.setText(i);
    }

    @Override // com.bestmafen.androidbase.dsl.BaseDslItem
    public int layoutId() {
        return R.layout.status_item_temperature;
    }

    @XO0.XO(tag = x0xO0oo.f24600Oxx0IOOO)
    public final void onTemperatureChanged(@OXOo.OOXIXo Object data) {
        IIX0o.x0xO0oo(data, "data");
        LogUtils.v("onTemperatureChanged");
        initView();
    }
}
