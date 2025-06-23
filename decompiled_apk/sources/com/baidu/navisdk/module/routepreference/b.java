package com.baidu.navisdk.module.routepreference;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.navisdk.model.datastruct.w;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

/* loaded from: classes7.dex */
public class b {
    private static final String TAG = "BNPlateModel";
    protected String areaPlate;
    private String plate = "";
    private String platePA = "";
    private String plateNumber = "";
    private final SparseArray<HashMap<String, String>> plateArray = new SparseArray<>(2);
    private String multiFlag = null;

    public void clone(b bVar) {
        if (bVar == null) {
            return;
        }
        bVar.areaPlate = this.areaPlate;
        bVar.multiFlag = this.multiFlag;
    }

    public void copyBaseParam(b bVar) {
        if (bVar == null) {
            return;
        }
        this.multiFlag = bVar.multiFlag;
        this.areaPlate = bVar.areaPlate;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return Objects.equals(this.plate, ((b) obj).plate);
        }
        return false;
    }

    @Nullable
    public String getAreaPlate() {
        return this.areaPlate;
    }

    public int getExtTag() {
        return 0;
    }

    public String getMultiFlag() {
        return this.multiFlag;
    }

    public Bundle[] getPassportBundleInfos(int i, String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList<w> passportInfos = getPassportInfos(i, str);
        for (int i3 = 0; i3 < passportInfos.size(); i3++) {
            String str2 = passportInfos.get(i3).f6945a;
            passportInfos.get(i3).l = i2;
            if (!TextUtils.isEmpty(str2)) {
                arrayList.add(passportInfos.get(i3).b());
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    public Bundle[] getPassportIds() {
        return null;
    }

    public ArrayList<w> getPassportInfos(int i, String str) {
        return w.a(com.baidu.navisdk.framework.b.a(i, str));
    }

    public String getPlate() {
        if (this.plateArray.size() >= 1) {
            if (this.plateArray.get(0) != null) {
                this.plate = this.plateArray.get(0).get("plate");
            } else {
                this.plate = this.plateArray.get(1).get("plate");
            }
        }
        return this.plate;
    }

    public String getPlateNumber(int i) {
        if (this.plateArray.size() >= 1) {
            if (this.plateArray.get(i) != null) {
                this.plateNumber = this.plateArray.get(i).get("plateNumber");
            } else if (i == 0 && this.plateArray.get(1) != null) {
                this.plateNumber = this.plateArray.get(1).get("plateNumber");
            }
        }
        return this.plateNumber;
    }

    public String getPlatePA(int i) {
        if (this.plateArray.size() >= 1) {
            if (this.plateArray.get(i) != null) {
                this.platePA = this.plateArray.get(i).get("platePA");
            } else if (i == 0 && this.plateArray.get(1) != null) {
                this.platePA = this.plateArray.get(1).get("platePA");
            }
        }
        return this.platePA;
    }

    public int hashCode() {
        String str = this.plate;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public boolean isPassportChanged(@NonNull String str, @NonNull String str2) {
        if (TextUtils.equals(str, str2)) {
            return false;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return true;
        }
        String[] split = str.replaceAll("[]\\[]|\\s*", "").split(",");
        String[] split2 = str2.replaceAll("[]\\[]|\\s*", "").split(",");
        if (split.length != split2.length) {
            return true;
        }
        Arrays.sort(split);
        Arrays.sort(split2);
        for (int i = 0; i < split.length; i++) {
            if (!TextUtils.equals(split[i], split2[i])) {
                return true;
            }
        }
        return false;
    }

    public void parseBaseParam(Bundle bundle) {
        if (bundle != null && !bundle.isEmpty()) {
            if (bundle.containsKey("multiFlag")) {
                this.multiFlag = bundle.getString("multiFlag", null);
            } else {
                this.multiFlag = null;
            }
            this.areaPlate = com.baidu.navisdk.module.plate.d.a(0, this.multiFlag);
            return;
        }
        this.areaPlate = null;
    }

    public Bundle[] parsePassportIds(String str) {
        Bundle b;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        String[] split = str.replaceAll("[]\\[]|\\s*", "").split(",");
        if (split.length > 0) {
            for (String str2 : split) {
                if (!TextUtils.isEmpty(str2) && (b = w.a(str2).b()) != null) {
                    arrayList.add(b);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    public void setPlateInfo(String str) {
        this.plate = str;
        if (!TextUtils.isEmpty(str)) {
            this.platePA = str.substring(0, 1);
            this.plateNumber = str.substring(1);
            if (LogUtil.LOGGABLE) {
                LogUtil.e(TAG, "fixPreferValue. mCalcPrefCarNo = " + str + " || carPA = " + this.platePA + " || carNum = " + this.plateNumber);
            }
        } else {
            this.platePA = "";
            this.plateNumber = "";
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("plate", this.plate);
        hashMap.put("platePA", this.platePA);
        hashMap.put("plateNumber", this.plateNumber);
        this.plateArray.put(0, hashMap);
    }

    public String toString() {
        return "BNPlateModel{fullPlateNumber='" + this.plate + "', platePA='" + this.platePA + "', plateNumber='" + this.plateNumber + "', areaPlate='" + this.areaPlate + "'}";
    }

    public String getPlate(int i) {
        if (this.plateArray.size() >= 1) {
            if (this.plateArray.get(i) != null) {
                this.plate = this.plateArray.get(i).get("plate");
            } else if (i == 0 && this.plateArray.get(1) != null) {
                this.plate = this.plateArray.get(1).get("plate");
            }
        }
        return this.plate;
    }

    public void setPlateInfo(String str, int i) {
        this.plate = str;
        if (!TextUtils.isEmpty(str)) {
            this.platePA = str.substring(0, 1);
            this.plateNumber = str.substring(1);
            if (LogUtil.LOGGABLE) {
                LogUtil.e(TAG, "setPlateInfo: fullPlateNumber = " + str + " || carPA = " + this.platePA + " || carNum = " + this.plateNumber);
            }
        } else {
            this.platePA = "";
            this.plateNumber = "";
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("plate", this.plate);
        hashMap.put("platePA", this.platePA);
        hashMap.put("plateNumber", this.plateNumber);
        this.plateArray.put(i, hashMap);
    }
}
