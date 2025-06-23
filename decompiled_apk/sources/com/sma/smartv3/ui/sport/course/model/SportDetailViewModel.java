package com.sma.smartv3.ui.sport.course.model;

import OXOo.OOXIXo;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.blankj.utilcode.util.LogUtils;
import com.sma.smartv3.model.CustomLatLng;
import com.sma.smartv3.util.TextConvertKt;
import java.util.ArrayList;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class SportDetailViewModel extends ViewModel {

    @OOXIXo
    private final MutableLiveData<ArrayList<CustomLatLng>> markLiveData = new MutableLiveData<>();

    @OOXIXo
    private final ArrayList<CustomLatLng> customLatLng = new ArrayList<>();

    @OOXIXo
    public final ArrayList<CustomLatLng> getCustomLatLng() {
        return this.customLatLng;
    }

    public final void getIntiLocationList(@OOXIXo ArrayList<CustomLatLng> locationList, int i) {
        IIX0o.x0xO0oo(locationList, "locationList");
        if (this.customLatLng.isEmpty()) {
            this.customLatLng.addAll(TextConvertKt.OxI(locationList, 0.0f, i, 2, null));
            LogUtils.i("customLatLng.size = " + this.customLatLng.size());
        }
    }

    public final void getMarkList(@OOXIXo ArrayList<CustomLatLng> locationList, int i) {
        IIX0o.x0xO0oo(locationList, "locationList");
        LogUtils.i("customLatLng.size2 = " + this.customLatLng.size());
        if (this.customLatLng.isEmpty()) {
            this.customLatLng.addAll(TextConvertKt.OxI(locationList, 0.0f, i, 2, null));
            this.markLiveData.postValue(this.customLatLng);
        } else {
            this.markLiveData.postValue(this.customLatLng);
        }
    }

    @OOXIXo
    public final MutableLiveData<ArrayList<CustomLatLng>> getMarkLiveData() {
        return this.markLiveData;
    }
}
