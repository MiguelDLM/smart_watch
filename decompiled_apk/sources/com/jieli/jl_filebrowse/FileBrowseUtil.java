package com.jieli.jl_filebrowse;

import androidx.exifinterface.media.ExifInterface;
import com.jieli.jl_filebrowse.bean.FileStruct;
import com.jieli.jl_filebrowse.bean.PathData;
import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.JL_Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes10.dex */
public class FileBrowseUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final String f17826a = "FileBrowseUtil";
    public static byte b = 0;
    public static final byte[] c = {-2, -36, -70};
    public static final byte d = -17;

    public static byte[] coverPathDataToCmd(PathData pathData) {
        if (pathData == null) {
            return new byte[0];
        }
        byte[] data = pathData.toData();
        if (data != null && data.length != 0) {
            short length = (short) (data.length + 1);
            byte[] bArr = new byte[length + 8];
            System.arraycopy(c, 0, bArr, 0, 3);
            bArr[3] = -64;
            bArr[4] = 12;
            bArr[5] = (byte) (length >> 8);
            bArr[6] = (byte) (length & 255);
            byte b2 = b;
            b = (byte) (b2 + 1);
            bArr[7] = b2;
            System.arraycopy(data, 0, bArr, 8, data.length);
            bArr[length + 7] = -17;
            JL_Log.d(f17826a, "coverPathDataToCmd", "data : " + CHexConver.byte2HexStr(bArr));
            return bArr;
        }
        return new byte[0];
    }

    public static String getDevName(int i) {
        switch (i) {
            case 0:
                return "USB";
            case 1:
                return "SD Card 0";
            case 2:
                return "SD Card 1";
            case 3:
                return ExifInterface.TAG_FLASH;
            case 4:
                return "LineIn";
            case 5:
                return "Flash2";
            case 6:
                return "Flash3";
            default:
                return String.format(Locale.ENGLISH, "Unknown Type[%d]", Integer.valueOf(i));
        }
    }

    public static List<FileStruct> parseData(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            ArrayList arrayList = new ArrayList();
            FileStruct.parseFileStruct(bArr, 0, arrayList);
            return arrayList;
        }
        return new ArrayList();
    }

    public static List<FileStruct> parseDataHasPacket(byte[] bArr) {
        if (bArr != null && bArr.length >= 10) {
            int length = bArr.length - 10;
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 9, bArr2, 0, length);
            return parseData(bArr2);
        }
        return new ArrayList();
    }
}
