package com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.language;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.common.util.DeviceId;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.EncoderException;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.StringEncoder;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.tenmeter.smlibrary.utils.DateFormatUtils;
import com.vtrump.vtble.Oxx0IOOO;
import java.util.Locale;

/* loaded from: classes10.dex */
public class MatchRatingApproachEncoder implements StringEncoder {
    private static final String[] DOUBLE_CONSONANT = {"BB", "CC", "DD", "FF", "GG", DateFormatUtils.HH, "JJ", "KK", "LL", DateFormatUtils.MM, "NN", "PP", "QQ", "RR", "SS", GlobalSetting.TT_SDK_WRAPPER, "VV", "WW", "XX", "YY", "ZZ"};
    private static final int EIGHT = 8;
    private static final int ELEVEN = 11;
    private static final String EMPTY = "";
    private static final int FIVE = 5;
    private static final int FOUR = 4;
    private static final int ONE = 1;
    private static final String PLAIN_ASCII = "AaEeIiOoUuAaEeIiOoUuYyAaEeIiOoUuYyAaOoNnAaEeIiOoUuYyAaCcOoUu";
    private static final int SEVEN = 7;
    private static final int SIX = 6;
    private static final String SPACE = " ";
    private static final int THREE = 3;
    private static final int TWELVE = 12;
    private static final int TWO = 2;
    private static final String UNICODE = "ÀàÈèÌìÒòÙùÁáÉéÍíÓóÚúÝýÂâÊêÎîÔôÛûŶŷÃãÕõÑñÄäËëÏïÖöÜüŸÿÅåÇçŐőŰű";

    public String cleanName(String str) {
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        String[] strArr = {"\\-", "[&]", "\\'", "\\.", "[\\,]"};
        for (int i = 0; i < 5; i++) {
            upperCase = upperCase.replaceAll(strArr[i], "");
        }
        return removeAccents(upperCase).replaceAll("\\s+", "");
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.Encoder
    public final Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return encode((String) obj);
        }
        throw new EncoderException("Parameter supplied to Match Rating Approach encoder is not of type java.lang.String");
    }

    public String getFirst3Last3(String str) {
        int length = str.length();
        if (length > 6) {
            return str.substring(0, 3) + str.substring(length - 3, length);
        }
        return str;
    }

    public int getMinRating(int i) {
        if (i <= 4) {
            return 5;
        }
        if (i >= 5 && i <= 7) {
            return 4;
        }
        if (i < 8 || i > 11) {
            return i == 12 ? 2 : 1;
        }
        return 3;
    }

    public boolean isEncodeEquals(String str, String str2) {
        if (str == null || "".equalsIgnoreCase(str) || " ".equalsIgnoreCase(str) || str2 == null || "".equalsIgnoreCase(str2) || " ".equalsIgnoreCase(str2) || str.length() == 1 || str2.length() == 1) {
            return false;
        }
        if (str.equalsIgnoreCase(str2)) {
            return true;
        }
        String cleanName = cleanName(str);
        String cleanName2 = cleanName(str2);
        String removeVowels = removeVowels(cleanName);
        String removeVowels2 = removeVowels(cleanName2);
        String removeDoubleConsonants = removeDoubleConsonants(removeVowels);
        String removeDoubleConsonants2 = removeDoubleConsonants(removeVowels2);
        String first3Last3 = getFirst3Last3(removeDoubleConsonants);
        String first3Last32 = getFirst3Last3(removeDoubleConsonants2);
        if (Math.abs(first3Last3.length() - first3Last32.length()) >= 3) {
            return false;
        }
        if (leftToRightThenRightToLeftProcessing(first3Last3, first3Last32) < getMinRating(Math.abs(first3Last3.length() + first3Last32.length()))) {
            return false;
        }
        return true;
    }

    public boolean isVowel(String str) {
        if (!str.equalsIgnoreCase(ExifInterface.LONGITUDE_EAST) && !str.equalsIgnoreCase("A") && !str.equalsIgnoreCase(DeviceId.CUIDInfo.I_FIXED) && !str.equalsIgnoreCase(Oxx0IOOO.f27277xI) && !str.equalsIgnoreCase("U")) {
            return false;
        }
        return true;
    }

    public int leftToRightThenRightToLeftProcessing(String str, String str2) {
        char[] charArray = str.toCharArray();
        char[] charArray2 = str2.toCharArray();
        int length = str.length() - 1;
        int length2 = str2.length() - 1;
        int i = 0;
        while (i < charArray.length && i <= length2) {
            int i2 = i + 1;
            String substring = str.substring(i, i2);
            int i3 = length - i;
            String substring2 = str.substring(i3, i3 + 1);
            String substring3 = str2.substring(i, i2);
            int i4 = length2 - i;
            String substring4 = str2.substring(i4, i4 + 1);
            if (substring.equals(substring3)) {
                charArray[i] = TokenParser.SP;
                charArray2[i] = TokenParser.SP;
            }
            if (substring2.equals(substring4)) {
                charArray[i3] = TokenParser.SP;
                charArray2[i4] = TokenParser.SP;
            }
            i = i2;
        }
        String replaceAll = new String(charArray).replaceAll("\\s+", "");
        String replaceAll2 = new String(charArray2).replaceAll("\\s+", "");
        if (replaceAll.length() > replaceAll2.length()) {
            return Math.abs(6 - replaceAll.length());
        }
        return Math.abs(6 - replaceAll2.length());
    }

    public String removeAccents(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            int indexOf = UNICODE.indexOf(charAt);
            if (indexOf > -1) {
                sb.append(PLAIN_ASCII.charAt(indexOf));
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    public String removeDoubleConsonants(String str) {
        String upperCase = str.toUpperCase();
        for (String str2 : DOUBLE_CONSONANT) {
            if (upperCase.contains(str2)) {
                upperCase = upperCase.replace(str2, str2.substring(0, 1));
            }
        }
        return upperCase;
    }

    public String removeVowels(String str) {
        String substring = str.substring(0, 1);
        String replaceAll = str.replaceAll("A", "").replaceAll(ExifInterface.LONGITUDE_EAST, "").replaceAll(Oxx0IOOO.f27277xI, "").replaceAll(DeviceId.CUIDInfo.I_FIXED, "").replaceAll("U", "").replaceAll("\\s{2,}\\b", " ");
        if (isVowel(substring)) {
            return substring + replaceAll;
        }
        return replaceAll;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.StringEncoder
    public final String encode(String str) {
        if (str == null || "".equalsIgnoreCase(str) || " ".equalsIgnoreCase(str) || str.length() == 1) {
            return "";
        }
        return getFirst3Last3(removeDoubleConsonants(removeVowels(cleanName(str))));
    }
}
