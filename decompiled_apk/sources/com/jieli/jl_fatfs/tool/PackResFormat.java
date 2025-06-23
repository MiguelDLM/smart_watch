package com.jieli.jl_fatfs.tool;

import com.jieli.jl_fatfs.model.PackFileInfo;
import com.jieli.jl_rcsp.util.JL_Log;
import com.jieli.jl_rcsp.util.RcspUtil;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes10.dex */
public class PackResFormat {
    public static final String b = "PackResFormat";

    /* renamed from: a, reason: collision with root package name */
    public volatile long f17817a;

    static {
        try {
            System.loadLibrary("jl_pack_format");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public PackResFormat() {
        this.f17817a = 0L;
        this.f17817a = libInit();
        if (this.f17817a != 0) {
        } else {
            throw new RuntimeException("init lib failed.");
        }
    }

    public void destroy() {
        libDestroy(this.f17817a);
        this.f17817a = 0L;
    }

    public native byte[] getFileData(long j, String str);

    public byte[] getFileData(String str) {
        return getFileData(this.f17817a, str);
    }

    public native void libDestroy(long j);

    public native long libInit();

    public native ArrayList<PackFileInfo> uncompressData(long j, byte[] bArr);

    public ArrayList<PackFileInfo> uncompressPackDataFile(byte[] bArr) {
        return uncompressData(this.f17817a, bArr);
    }

    public byte[] getFileData(byte[] bArr, String str) {
        ArrayList<PackFileInfo> uncompressPackDataFile = uncompressPackDataFile(bArr);
        if (uncompressPackDataFile != null && !uncompressPackDataFile.isEmpty()) {
            JL_Log.i(b, "getFileData", RcspUtil.formatString("========= Unzip file :[%d], target : %s =========", Integer.valueOf(uncompressPackDataFile.size()), str));
            Iterator<PackFileInfo> it = uncompressPackDataFile.iterator();
            while (it.hasNext()) {
                JL_Log.d(b, "getFileData", it.next().toString());
            }
            JL_Log.i(b, "getFileData", "================= Unzip file End ===============");
            return getFileData(str);
        }
        JL_Log.e(b, "getFileData", "Did not extract the file.");
        return null;
    }
}
