package com.jieli.jl_rcsp.util;

import com.jieli.jl_rcsp.model.device.health.HealthData;
import com.tenmeter.smlibrary.utils.FileUtils;

/* loaded from: classes10.dex */
public class HealthDataUtil {

    /* loaded from: classes10.dex */
    public interface ParseResult<T> {
        void onResult(T t);
    }

    public static void parseAirPressure(HealthData healthData, ParseResult<Integer> parseResult, ParseResult<Integer> parseResult2, ParseResult<Integer> parseResult3) {
        if (healthData.version != 0 || healthData.type != 1) {
            return;
        }
        byte b = healthData.subMask;
        if ((b & 255) == 255) {
            return;
        }
        byte[] bArr = healthData.data;
        int i = 0;
        if ((b & 1) == 1) {
            if (parseResult != null) {
                parseResult.onResult(Integer.valueOf(CHexConver.bytesToInt(bArr[0], bArr[1])));
            }
            i = 2;
        }
        if ((healthData.subMask & 2) == 2) {
            if (parseResult2 != null) {
                parseResult2.onResult(Integer.valueOf(CHexConver.bytesToInt(bArr[i], bArr[i + 1])));
            }
            i += 2;
        }
        if ((healthData.subMask & 4) == 4 && parseResult3 != null) {
            parseResult3.onResult(Integer.valueOf(CHexConver.bytesToInt(bArr[i], bArr[i + 1])));
        }
    }

    public static void parseAltitude(HealthData healthData, ParseResult<Double> parseResult, ParseResult<Double> parseResult2, ParseResult<Double> parseResult3) {
        if (healthData.version != 0 || healthData.type != 2) {
            return;
        }
        byte b = healthData.subMask;
        if ((b & 255) == 255) {
            return;
        }
        byte[] bArr = healthData.data;
        int i = 0;
        if ((b & 1) == 1) {
            if (parseResult != null) {
                parseResult.onResult(Double.valueOf(Double.parseDouble(CHexConver.bytesToInt(bArr[0], bArr[1]) + FileUtils.FILE_EXTENSION_SEPARATOR + CHexConver.bytesToInt(bArr[2], bArr[3]))));
            }
            i = 4;
        }
        if ((healthData.subMask & 2) == 2) {
            if (parseResult2 != null) {
                parseResult2.onResult(Double.valueOf(Double.parseDouble(CHexConver.bytesToInt(bArr[i], bArr[i + 1]) + FileUtils.FILE_EXTENSION_SEPARATOR + CHexConver.bytesToInt(bArr[i + 2], bArr[i + 3]))));
            }
            i += 4;
        }
        if ((healthData.subMask & 4) == 4 && parseResult3 != null) {
            parseResult3.onResult(Double.valueOf(Double.parseDouble(CHexConver.bytesToInt(bArr[i], bArr[i + 1]) + FileUtils.FILE_EXTENSION_SEPARATOR + CHexConver.bytesToInt(bArr[i + 2], bArr[i + 3]))));
        }
    }

    public static void parseBloodOxygen(HealthData healthData, ParseResult<Integer> parseResult) {
        if (healthData.version != 0 || healthData.type != 5) {
            return;
        }
        byte b = healthData.subMask;
        if ((b & 255) == 255) {
            return;
        }
        byte[] bArr = healthData.data;
        if ((b & 1) == 1 && parseResult != null) {
            parseResult.onResult(Integer.valueOf(bArr[0] & 255));
        }
    }

    public static void parseHeartRate(HealthData healthData, ParseResult<Integer> parseResult, ParseResult<Integer> parseResult2, ParseResult<Integer> parseResult3) {
        if (healthData.version != 0 || healthData.type != 0) {
            return;
        }
        byte b = healthData.subMask;
        if ((b & 255) == 255) {
            return;
        }
        int i = 1;
        if ((b & 1) == 1) {
            if (parseResult != null) {
                parseResult.onResult(Integer.valueOf(healthData.data[0] & 255));
            }
        } else {
            i = 0;
        }
        if ((healthData.subMask & 2) == 2) {
            if (parseResult2 != null) {
                parseResult2.onResult(Integer.valueOf(healthData.data[i] & 255));
            }
            i++;
        }
        if ((healthData.subMask & 4) == 4 && parseResult3 != null) {
            parseResult3.onResult(Integer.valueOf(healthData.data[i] & 255));
        }
    }

    public static void parseMaxOxygenUptake(HealthData healthData, ParseResult<Integer> parseResult) {
        if (healthData.version != 0 || healthData.type != 7) {
            return;
        }
        byte b = healthData.subMask;
        if ((b & 255) == 255) {
            return;
        }
        byte[] bArr = healthData.data;
        if ((b & 1) == 1 && parseResult != null) {
            parseResult.onResult(Integer.valueOf(bArr[0] & 255));
        }
    }

    public static void parsePressure(HealthData healthData, ParseResult<Integer> parseResult) {
        if (healthData.version != 0 || healthData.type != 4) {
            return;
        }
        byte b = healthData.subMask;
        if ((b & 255) == 255) {
            return;
        }
        byte[] bArr = healthData.data;
        if ((b & 1) == 1 && parseResult != null) {
            parseResult.onResult(Integer.valueOf(bArr[0] & 255));
        }
    }

    public static void parseSportRecoveryTime(HealthData healthData, ParseResult<Float> parseResult) {
        if (healthData.version != 0 || healthData.type != 8) {
            return;
        }
        byte b = healthData.subMask;
        if ((b & 255) == 255) {
            return;
        }
        byte[] bArr = healthData.data;
        if ((b & 1) == 1) {
            float f = (r3 >> 2) + (((bArr[0] & 255) * 15.0f) / 60.0f);
            if (parseResult != null) {
                parseResult.onResult(Float.valueOf(f));
            }
        }
    }

    public static void parseStep(HealthData healthData, ParseResult<Integer> parseResult, ParseResult<Integer> parseResult2) {
        if (healthData.version != 0 || healthData.type != 3) {
            return;
        }
        byte b = healthData.subMask;
        if ((b & 255) == 255) {
            return;
        }
        byte[] bArr = healthData.data;
        int i = 0;
        if ((b & 1) == 1) {
            if (parseResult != null) {
                parseResult.onResult(Integer.valueOf(CHexConver.bytesToInt(bArr, 0, 4)));
            }
            i = 4;
        }
        if ((healthData.subMask & 2) == 2 && parseResult2 != null) {
            parseResult2.onResult(Integer.valueOf(CHexConver.bytesToInt(bArr, i, 4)));
        }
    }

    public static void parseTrainingLoad(HealthData healthData, ParseResult<Integer> parseResult) {
        if (healthData.version != 0 || healthData.type != 6) {
            return;
        }
        byte b = healthData.subMask;
        if ((b & 255) == 255) {
            return;
        }
        byte[] bArr = healthData.data;
        if ((b & 1) == 1 && parseResult != null) {
            parseResult.onResult(Integer.valueOf(bArr[0] & 255));
        }
    }
}
