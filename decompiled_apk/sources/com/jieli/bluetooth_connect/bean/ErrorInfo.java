package com.jieli.bluetooth_connect.bean;

import android.bluetooth.BluetoothDevice;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import org.apache.commons.text.ooOOo0oXI;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class ErrorInfo {
    private int code;
    private BluetoothDevice device;
    private String message;

    /* loaded from: classes10.dex */
    public static class ErrorMsg {
        static final String KEY_CODE = "code";
        static final String KEY_DESC = "desc";
        static final String KEY_MESSAGE = "message";
        static final String KEY_SUB_CODE = "sub_code";
        private final int code;
        private final String desc;
        private final String message;
        private final int subCode;

        public ErrorMsg(int code) {
            this(code, ErrorInfo.getErrDesc(code), 0, null);
        }

        public static ErrorMsg parseJson(String string) {
            String str;
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(string);
                if (jSONObject.has("code") && jSONObject.has(KEY_SUB_CODE)) {
                    String str2 = "";
                    if (jSONObject.has("desc")) {
                        str2 = jSONObject.getString("desc");
                    }
                    if (jSONObject.has("message")) {
                        str = jSONObject.getString("message");
                    } else {
                        str = null;
                    }
                    return new ErrorMsg(jSONObject.getInt("code"), str2, jSONObject.getInt(KEY_SUB_CODE), str);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        public int getCode() {
            return this.code;
        }

        public String getDesc() {
            return this.desc;
        }

        public String getMessage() {
            return this.message;
        }

        public int getSubCode() {
            return this.subCode;
        }

        @NonNull
        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append("\"");
            sb.append("code");
            sb.append("\":");
            sb.append(this.code);
            if (!TextUtils.isEmpty(this.desc)) {
                sb.append(", \"");
                sb.append("desc");
                sb.append("\":\"");
                sb.append(this.desc);
                sb.append("\"");
            }
            sb.append(", \"");
            sb.append(KEY_SUB_CODE);
            sb.append("\":");
            sb.append(this.subCode);
            if (!TextUtils.isEmpty(this.message)) {
                sb.append(", \"");
                sb.append("message");
                sb.append("\":\"");
                sb.append(this.message);
                sb.append("\"");
            }
            sb.append(ooOOo0oXI.f33074oOoXoXO);
            return sb.toString();
        }

        public ErrorMsg(int code, int subCode, String message) {
            this(code, ErrorInfo.getErrDesc(code), subCode, message);
        }

        public ErrorMsg(int code, String desc, int subCode, String message) {
            this.code = code;
            this.subCode = subCode;
            this.desc = desc;
            this.message = message;
        }
    }

    public ErrorInfo() {
    }

    public static ErrorInfo buildError(int code) {
        return new ErrorInfo(code, new ErrorMsg(code).toString());
    }

    public static String getErrDesc(int code) {
        switch (code) {
            case 0:
                return "Success.";
            case 1:
                return "Parameter Error.";
            case 2:
                return "Bluetooth is not on.";
            case 3:
                return "Bluetooth pairing/unpairing operation failed.";
            case 4:
                return "Bluetooth pairing/unpairing timeout.";
            case 5:
                return "Bluetooth pairing/unpairing in progress.";
            case 6:
                return "Call reflection method exception.";
            case 7:
                return "Operation in progress.";
            case 8:
                return "A scan error occurred.";
            case 9:
                return "Timeout Exception.";
            case 10:
                return "The remote device is not connected.";
            default:
                return "";
        }
    }

    public int getCode() {
        return this.code;
    }

    public BluetoothDevice getDevice() {
        return this.device;
    }

    public String getMessage() {
        return this.message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setDevice(BluetoothDevice device) {
        this.device = device;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String toString() {
        return "ErrorInfo{code=" + this.code + ", message='" + this.message + "', device=" + this.device + '}';
    }

    public ErrorInfo(int code, String message) {
        setCode(code);
        setMessage(message);
    }

    public static ErrorInfo buildError(int code, int subCode, String message) {
        return new ErrorInfo(code, new ErrorMsg(code, subCode, message).toString());
    }
}
