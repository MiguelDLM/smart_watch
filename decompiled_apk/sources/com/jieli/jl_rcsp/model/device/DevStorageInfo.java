package com.jieli.jl_rcsp.model.device;

import com.jieli.jl_rcsp.model.LtvBean;
import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.JL_Log;
import com.jieli.jl_rcsp.util.RcspUtil;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes10.dex */
public class DevStorageInfo {
    public static final int INDEX_FLASH = 3;
    public static final int INDEX_FLASH2 = 5;
    public static final int INDEX_FLASH3 = 6;
    public static final int INDEX_LINE_IN = 4;
    public static final int INDEX_SD0 = 1;
    public static final int INDEX_SD1 = 2;
    public static final int INDEX_USB = 0;
    private static final String TAG = "DevStorageInfo";
    private static final int TYPE_REUSE_STORAGE = 2;
    private static final int TYPE_STORAGE_INFO = 1;
    private boolean isStorageReuse;
    private final List<DevStorageState> storageStates = new ArrayList();
    private int version;

    private void parseNewVersion(byte[] bArr) {
        if (bArr[0] != -1) {
            return;
        }
        this.storageStates.clear();
        if (bArr.length <= 1) {
            return;
        }
        setVersion(CHexConver.byteToInt(bArr[1]));
        if (bArr.length <= 2) {
            return;
        }
        int length = bArr.length - 2;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 2, bArr2, 0, length);
        if (this.version == 0) {
            parseV0(bArr2);
        }
    }

    private void parseStorageInfo(byte[] bArr) {
        boolean z = false;
        byte b = bArr[0];
        this.storageStates.clear();
        int i = 1;
        for (int i2 = 0; i2 < 6; i2++) {
            DevStorageState index = new DevStorageState().setIndex(i2);
            index.setOnline(CHexConver.checkBitValue(b, i2));
            if (i2 != 4) {
                int i3 = i + 4;
                if (i3 > bArr.length) {
                    break;
                }
                index.setHandle(CHexConver.bytesToInt(bArr, i, 4));
                this.storageStates.add(index);
                i = i3;
            }
        }
        if (bArr.length >= i + 1) {
            if (CHexConver.byteToInt(bArr[i]) == 1) {
                z = true;
            }
            setStorageReuse(z);
        }
    }

    private void parseV0(byte[] bArr) {
        for (LtvBean ltvBean : RcspUtil.parseLTVData(bArr)) {
            byte[] data = ltvBean.getData();
            if (data != null && data.length != 0) {
                int type = ltvBean.getType();
                boolean z = true;
                if (type != 1) {
                    if (type == 2) {
                        if (CHexConver.byteToInt(data[0]) != 1) {
                            z = false;
                        }
                        setStorageReuse(z);
                    }
                } else {
                    int i = 0;
                    while (i < data.length) {
                        int length = data.length - i;
                        byte[] bArr2 = new byte[length];
                        System.arraycopy(data, i, bArr2, 0, length);
                        DevStorageState devStorageState = new DevStorageState();
                        int parseData = devStorageState.parseData(bArr2);
                        JL_Log.d(TAG, "parseV0", "size : " + parseData + ", " + devStorageState);
                        if (parseData == 0) {
                            break;
                        }
                        this.storageStates.add(devStorageState);
                        i += parseData;
                    }
                }
            }
        }
    }

    public List<DevStorageState> getStorageStates() {
        return new ArrayList(this.storageStates);
    }

    public int getVersion() {
        return this.version;
    }

    public boolean isStorageReuse() {
        return this.isStorageReuse;
    }

    public void parseData(byte[] bArr) {
        if (bArr != null && bArr.length >= 1) {
            if (bArr[0] == -1) {
                parseNewVersion(bArr);
            } else {
                parseStorageInfo(bArr);
            }
        }
    }

    public DevStorageInfo setStorageReuse(boolean z) {
        this.isStorageReuse = z;
        return this;
    }

    public DevStorageInfo setVersion(int i) {
        this.version = i;
        return this;
    }

    public String toString() {
        return "DevStorageInfo{storageStates=" + this.storageStates + ", isStorageReuse=" + this.isStorageReuse + '}';
    }
}
