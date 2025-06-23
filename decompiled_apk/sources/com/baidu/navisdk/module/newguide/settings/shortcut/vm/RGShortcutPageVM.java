package com.baidu.navisdk.module.newguide.settings.shortcut.vm;

import android.app.Application;
import android.os.Bundle;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.function.b;
import com.baidu.navisdk.module.newguide.settings.shortcut.beans.a;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes7.dex */
public class RGShortcutPageVM extends AndroidViewModel {
    private static final String TAG = "RGShortcutPageVM";
    private boolean isNewEnergyCar;
    private MutableLiveData<SparseArray<a>> mAllShortcutList;
    private MutableLiveData<ArrayList<a>> mCustomShortcutList;
    private com.baidu.navisdk.module.newguide.settings.shortcut.repository.a mRepository;
    private MutableLiveData<a> mShortcutFuncStateChange;

    public RGShortcutPageVM(Application application, Bundle bundle) {
        super(application);
        boolean z;
        this.isNewEnergyCar = false;
        this.mRepository = new com.baidu.navisdk.module.newguide.settings.shortcut.repository.a();
        this.mCustomShortcutList = new MutableLiveData<>();
        this.mAllShortcutList = new MutableLiveData<>();
        this.mShortcutFuncStateChange = new MutableLiveData<>();
        if (bundle != null) {
            this.isNewEnergyCar = bundle.getBoolean("is_new_energy_car", false);
        }
        ArrayList<a> filterShortcutList = getFilterShortcutList();
        ArrayList<a> b = this.mRepository.b();
        filtrationShortcutList(b, filterShortcutList);
        this.mCustomShortcutList.setValue(b);
        SparseArray<a> a2 = this.mRepository.a();
        if (a2 != null) {
            if (filterShortcutList != null) {
                Iterator<a> it = filterShortcutList.iterator();
                while (it.hasNext()) {
                    a2.remove(it.next().f7279a);
                }
            }
            for (int i = 0; i < a2.size(); i++) {
                a valueAt = a2.valueAt(i);
                if (valueAt != null) {
                    if (b != null && b.contains(valueAt)) {
                        z = true;
                    } else {
                        z = false;
                    }
                    valueAt.g = z;
                }
            }
        }
        this.mAllShortcutList.setValue(a2);
    }

    private void changeAllShortcutState(a aVar, boolean z) {
        MutableLiveData<SparseArray<a>> mutableLiveData;
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "changeAllShortcutState:" + aVar + ", isSelected:" + z);
        }
        if (aVar != null && (mutableLiveData = this.mAllShortcutList) != null) {
            SparseArray<a> value = mutableLiveData.getValue();
            if (value != null && value.size() != 0) {
                a aVar2 = value.get(aVar.f7279a);
                if (aVar2 != null) {
                    aVar2.g = z;
                }
                this.mShortcutFuncStateChange.setValue(aVar2);
                return;
            }
            if (gVar.c()) {
                gVar.c(TAG, "changeAllShortcutState funDataList null");
                return;
            }
            return;
        }
        if (gVar.c()) {
            gVar.e(TAG, "changeAllShortcutState null");
        }
    }

    private void filtrationShortcutList(ArrayList<a> arrayList, ArrayList<a> arrayList2) {
        if (arrayList != null && !arrayList.isEmpty() && arrayList2 != null && !arrayList2.isEmpty()) {
            Iterator<a> it = arrayList2.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    arrayList.remove(next);
                }
            }
        }
    }

    @Nullable
    private ArrayList<a> getFilterShortcutList() {
        ArrayList<a> arrayList = new ArrayList<>(2);
        if (!b.FUNC_AR.a() || !com.baidu.navisdk.module.abtest.model.a.y()) {
            arrayList.add(new a(9));
        }
        if (this.isNewEnergyCar) {
            arrayList.add(new a(8));
        }
        return arrayList;
    }

    public void addCustomShortcut(int i) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "addCustomShortcut shortcutId:" + i);
        }
        if (i <= 0) {
            return;
        }
        MutableLiveData<SparseArray<a>> mutableLiveData = this.mAllShortcutList;
        if (mutableLiveData == null) {
            if (gVar.c()) {
                gVar.c(TAG, "addCustomShortcut null");
                return;
            }
            return;
        }
        SparseArray<a> value = mutableLiveData.getValue();
        if (value != null && value.size() != 0) {
            addCustomShortcut(value.get(i));
        } else if (gVar.d()) {
            gVar.e(TAG, "addCustomShortcut funDataList is null ");
        }
    }

    public void changeCustomShortcutPosition(ArrayList<a> arrayList) {
        MutableLiveData<ArrayList<a>> mutableLiveData;
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "changeCustomShortcutPosition:" + arrayList);
        }
        if (arrayList != null && (mutableLiveData = this.mCustomShortcutList) != null) {
            if (!arrayList.equals(mutableLiveData.getValue())) {
                this.mCustomShortcutList.setValue(arrayList);
            }
            com.baidu.navisdk.module.newguide.settings.shortcut.repository.a aVar = this.mRepository;
            if (aVar != null) {
                aVar.a(arrayList);
                return;
            }
            return;
        }
        if (gVar.d()) {
            gVar.e(TAG, "changeCustomShortcutPosition null");
        }
    }

    public MutableLiveData<SparseArray<a>> getAllShortcutLiveData() {
        return this.mAllShortcutList;
    }

    public MutableLiveData<ArrayList<a>> getCustomShortcutLiveData() {
        return this.mCustomShortcutList;
    }

    public MutableLiveData<a> getShortcutStateChangeLiveData() {
        return this.mShortcutFuncStateChange;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        g gVar = g.PRO_NAV;
        if (gVar.c()) {
            gVar.e(TAG, "onCleared");
        }
    }

    public boolean removeCustomShortcut(int i) {
        a aVar;
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "removeCustomShortcut: " + i);
        }
        if (i <= 0) {
            return false;
        }
        MutableLiveData<ArrayList<a>> mutableLiveData = this.mCustomShortcutList;
        if (mutableLiveData == null) {
            if (gVar.d()) {
                gVar.e(TAG, "removeCustomShortcut mCustomShortcutList is null ");
            }
            return false;
        }
        ArrayList<a> value = mutableLiveData.getValue();
        if (value != null && !value.isEmpty()) {
            Iterator<a> it = value.iterator();
            while (true) {
                if (!it.hasNext()) {
                    aVar = null;
                    break;
                }
                aVar = it.next();
                if (aVar != null && aVar.f7279a == i) {
                    break;
                }
            }
            return removeCustomShortcut(aVar);
        }
        if (gVar.d()) {
            gVar.e(TAG, "removeCustomShortcut funDataList is null ");
        }
        return false;
    }

    public void restoreDefaultCustom() {
        ArrayList<a> arrayList;
        BNCommSettingManager.getInstance().saveProCustomShortcutFun("");
        com.baidu.navisdk.module.newguide.settings.shortcut.repository.a aVar = this.mRepository;
        if (aVar != null) {
            arrayList = aVar.c();
            this.mCustomShortcutList.setValue(arrayList);
        } else {
            arrayList = null;
        }
        SparseArray<a> value = this.mAllShortcutList.getValue();
        if (arrayList != null && value != null) {
            int size = value.size();
            for (int i = 0; i < size; i++) {
                a valueAt = value.valueAt(i);
                if (valueAt != null) {
                    valueAt.g = arrayList.contains(valueAt);
                }
            }
        }
        this.mAllShortcutList.setValue(value);
    }

    public void addCustomShortcut(a aVar) {
        MutableLiveData<ArrayList<a>> mutableLiveData;
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "addCustomShortcut:" + aVar);
        }
        if (aVar != null && (mutableLiveData = this.mCustomShortcutList) != null) {
            ArrayList<a> value = mutableLiveData.getValue();
            if (value == null) {
                value = new ArrayList<>();
            }
            if (value.contains(aVar)) {
                TipTool.onCreateToastDialog(getApplication(), JarUtils.getResources().getString(R.string.nsdk_custom_shortcut_added_tips, aVar.b));
                return;
            }
            if (value.size() >= 11) {
                TipTool.onCreateToastDialog(getApplication(), JarUtils.getResources().getString(R.string.nsdk_custom_shortcut_add_max_tips));
                return;
            }
            a a2 = com.baidu.navisdk.module.newguide.settings.shortcut.a.a(aVar.f7279a);
            a2.c = com.baidu.navisdk.module.newguide.settings.shortcut.a.c(aVar.f7279a);
            value.add(a2);
            this.mCustomShortcutList.setValue(value);
            com.baidu.navisdk.module.newguide.settings.shortcut.repository.a aVar2 = this.mRepository;
            if (aVar2 != null) {
                aVar2.a(value);
            }
            changeAllShortcutState(aVar, true);
            return;
        }
        if (gVar.c()) {
            gVar.c(TAG, "addCustomShortcut null");
        }
    }

    private boolean removeCustomShortcut(a aVar) {
        MutableLiveData<ArrayList<a>> mutableLiveData;
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e(TAG, "removeCustomShortcut:" + aVar);
        }
        if (aVar != null && (mutableLiveData = this.mCustomShortcutList) != null) {
            ArrayList<a> value = mutableLiveData.getValue();
            if (value == null) {
                return false;
            }
            value.remove(aVar);
            this.mCustomShortcutList.setValue(value);
            com.baidu.navisdk.module.newguide.settings.shortcut.repository.a aVar2 = this.mRepository;
            if (aVar2 != null) {
                aVar2.a(value);
            }
            changeAllShortcutState(aVar, false);
            return true;
        }
        if (gVar.c()) {
            gVar.c(TAG, "delCustomShortcut null");
        }
        return false;
    }
}
