package com.jieli.jl_rcsp.model.command.file_op;

import android.text.TextUtils;
import com.jieli.jl_rcsp.model.base.BaseParameter;
import com.jieli.jl_rcsp.model.base.CommandWithParamAndResponse;
import com.jieli.jl_rcsp.model.base.CommonResponse;
import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.JL_Log;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/* loaded from: classes10.dex */
public class LargeFileTransferGetNameCmd extends CommandWithParamAndResponse<Param, CommonResponse> {
    private static final String TAG = "LargeFileTransferGetNameCmd";

    /* loaded from: classes10.dex */
    public static class Param extends BaseParameter {
        private String encodeType = StandardCharsets.UTF_16LE.name();
        private boolean isOtherEncode;
        public final String name;
        public final int renameTime;

        public Param(String str, int i) {
            this.name = str;
            this.renameTime = i;
        }

        private byte[] getNameData(String str, int i) {
            if (this.isOtherEncode) {
                return getNameDataByOther(str, i);
            }
            return getNameDataByDefault(str, i);
        }

        private byte[] getNameDataByDefault(String str, int i) {
            String str2;
            String str3;
            byte[] bytes;
            byte[] bytes2;
            String str4 = "";
            String replaceAll = str.replaceAll("[\\x00-\\x1f\\x2f\\x3a\\x3c\\x3e\\x5c\\x22]", "");
            int lastIndexOf = replaceAll.lastIndexOf(46);
            if (lastIndexOf != -1) {
                str2 = replaceAll.substring(0, lastIndexOf);
            } else {
                str2 = replaceAll;
            }
            if (lastIndexOf == -1) {
                str3 = "";
            } else {
                str3 = replaceAll.substring(lastIndexOf);
            }
            if (i > 0) {
                str4 = ("000" + i).substring(r2.length() - 3);
            }
            String str5 = str2 + str4;
            try {
                bytes = str5.getBytes("gbk");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                bytes = str5.getBytes();
            }
            if (bytes.length < 9 && str3.length() < 5) {
                String str6 = str5 + str3;
                try {
                    bytes2 = str6.getBytes("gbk");
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                    bytes2 = str6.getBytes();
                }
                JL_Log.i(LargeFileTransferGetNameCmd.TAG, "getNameDataByDefault", "获取文件名称 \tretryName = " + i + "\tname = " + replaceAll + "\tshortName = " + str6);
                byte[] bArr = new byte[bytes2.length + 2];
                System.arraycopy(bytes2, 0, bArr, 0, bytes2.length);
                return bArr;
            }
            String str7 = str2 + str4 + str3;
            JL_Log.i(LargeFileTransferGetNameCmd.TAG, "getNameDataByDefault", "获取文件名称 \tretryName = " + i + "\tname = " + replaceAll + "\tlenName = " + str7);
            byte[] bytes3 = "\\U".getBytes();
            byte[] bytes4 = str7.getBytes(StandardCharsets.UTF_16LE);
            byte[] bArr2 = new byte[bytes3.length + bytes4.length + 2];
            System.arraycopy(bytes3, 0, bArr2, 0, bytes3.length);
            System.arraycopy(bytes4, 0, bArr2, bytes3.length, bytes4.length);
            JL_Log.i(LargeFileTransferGetNameCmd.TAG, "getNameDataByDefault", "data : " + CHexConver.byte2HexStr(bArr2));
            return bArr2;
        }

        private byte[] getNameDataByOther(String str, int i) {
            String str2;
            String str3;
            String str4;
            if (TextUtils.isEmpty(this.encodeType)) {
                str2 = StandardCharsets.UTF_16LE.name();
            } else {
                str2 = this.encodeType;
            }
            String str5 = "";
            String replaceAll = str.replaceAll("[\\x00-\\x1f\\x2f\\x3a\\x3c\\x3e\\x5c\\x22]", "");
            int lastIndexOf = replaceAll.lastIndexOf(46);
            if (lastIndexOf != -1) {
                str3 = replaceAll.substring(0, lastIndexOf);
            } else {
                str3 = replaceAll;
            }
            if (lastIndexOf == -1) {
                str4 = "";
            } else {
                str4 = replaceAll.substring(lastIndexOf);
            }
            if (i > 0) {
                str5 = ("000" + i).substring(r4.length() - 3);
            }
            try {
                String str6 = str3 + str5 + str4;
                JL_Log.i(LargeFileTransferGetNameCmd.TAG, "getNameDataByOther", "获取文件名称 \tretryName = " + i + "\tname = " + replaceAll + "\tlenName = " + str6);
                byte[] bytes = "\\U".getBytes();
                byte[] bytes2 = str6.getBytes(str2);
                byte[] bArr = new byte[bytes.length + bytes2.length + 2];
                System.arraycopy(bytes, 0, bArr, 0, bytes.length);
                System.arraycopy(bytes2, 0, bArr, bytes.length, bytes2.length);
                JL_Log.i(LargeFileTransferGetNameCmd.TAG, "getNameDataByOther", "data : " + CHexConver.byte2HexStr(bArr));
                return bArr;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return new byte[0];
            }
        }

        public String getEncodeType() {
            return this.encodeType;
        }

        @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
        public byte[] getParamData() {
            String str = this.name;
            if (str != null && !str.isEmpty()) {
                return getNameData(this.name, this.renameTime);
            }
            return super.getParamData();
        }

        public boolean isOtherEncode() {
            return this.isOtherEncode;
        }

        public Param setEncodeType(String str) {
            this.encodeType = str;
            return this;
        }

        public Param setOtherEncode(boolean z) {
            this.isOtherEncode = z;
            return this;
        }
    }

    public LargeFileTransferGetNameCmd(Param param) {
        super(32, LargeFileTransferGetNameCmd.class.getSimpleName(), param);
    }
}
