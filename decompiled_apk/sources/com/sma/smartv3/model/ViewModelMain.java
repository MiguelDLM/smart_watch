package com.sma.smartv3.model;

import OXOo.OOXIXo;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class ViewModelMain extends ViewModel {

    @OOXIXo
    public static final ViewModelMain INSTANCE = new ViewModelMain();

    @OOXIXo
    private static MutableLiveData<Boolean> isShowSuspenWindow = new MutableLiveData<>();

    @OOXIXo
    private static MutableLiveData<Boolean> isReSetList = new MutableLiveData<>();

    private ViewModelMain() {
    }

    @OOXIXo
    public final MutableLiveData<Boolean> isReSetList() {
        return isReSetList;
    }

    @OOXIXo
    public final MutableLiveData<Boolean> isShowSuspenWindow() {
        return isShowSuspenWindow;
    }

    public final void setReSetList(@OOXIXo MutableLiveData<Boolean> mutableLiveData) {
        IIX0o.x0xO0oo(mutableLiveData, "<set-?>");
        isReSetList = mutableLiveData;
    }

    public final void setShowSuspenWindow(@OOXIXo MutableLiveData<Boolean> mutableLiveData) {
        IIX0o.x0xO0oo(mutableLiveData, "<set-?>");
        isShowSuspenWindow = mutableLiveData;
    }
}
