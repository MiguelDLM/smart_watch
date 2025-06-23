package com.szabh.smable3.entity;

import OI0.oIX0oI;
import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.facebook.appevents.UserDataStore;
import com.huawei.openalliance.ad.constant.x;
import com.kuaishou.weapon.p0.t;
import com.tenmeter.smlibrary.utils.DateFormatUtils;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import kotlin.Xo0;
import kotlin.collections.o0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.oxxXoxO;

/* loaded from: classes13.dex */
public final class Languages {
    public static final int DEFAULT_CODE = 1;
    public static final int INVALID_CODE = 31;

    @OOXIXo
    public static final Languages INSTANCE = new Languages();

    @OOXIXo
    public static final String DEFAULT_LANGUAGE_ZH = "zh";

    @OOXIXo
    public static final String DEFAULT_LANGUAGE = "en";

    @OOXIXo
    private static final Map<String, Integer> LANGUAGES = o0.XX(Xo0.oIX0oI(DEFAULT_LANGUAGE_ZH, 0), Xo0.oIX0oI(DEFAULT_LANGUAGE, 1), Xo0.oIX0oI("tr", 2), Xo0.oIX0oI("ru", 4), Xo0.oIX0oI("es", 5), Xo0.oIX0oI("it", 6), Xo0.oIX0oI("ko", 7), Xo0.oIX0oI("pt", 8), Xo0.oIX0oI("de", 9), Xo0.oIX0oI("fr", 10), Xo0.oIX0oI("nl", 11), Xo0.oIX0oI("pl", 12), Xo0.oIX0oI("cs", 13), Xo0.oIX0oI("hu", 14), Xo0.oIX0oI("sk", 15), Xo0.oIX0oI("ja", 16), Xo0.oIX0oI("da", 17), Xo0.oIX0oI("fi", 18), Xo0.oIX0oI("no", 19), Xo0.oIX0oI("sv", 20), Xo0.oIX0oI("sr", 21), Xo0.oIX0oI("th", 22), Xo0.oIX0oI("hi", 23), Xo0.oIX0oI(t.n, 24), Xo0.oIX0oI("Hant", 25), Xo0.oIX0oI("lt", 26), Xo0.oIX0oI("vi", 27), Xo0.oIX0oI("ar", 28), Xo0.oIX0oI("in", 29), Xo0.oIX0oI("uk", 30), Xo0.oIX0oI("iw", 32), Xo0.oIX0oI("bn", 33), Xo0.oIX0oI("et", 34), Xo0.oIX0oI("sl", 35), Xo0.oIX0oI("fa", 36), Xo0.oIX0oI("ro", 37), Xo0.oIX0oI("bg", 38), Xo0.oIX0oI("hr", 39), Xo0.oIX0oI(x.cL, 40), Xo0.oIX0oI("ms", 41), Xo0.oIX0oI("jv", 48), Xo0.oIX0oI("mr", 49), Xo0.oIX0oI("lv", 50), Xo0.oIX0oI("la", 51), Xo0.oIX0oI(UserDataStore.PHONE, 52), Xo0.oIX0oI(DateFormatUtils.MIN, 53), Xo0.oIX0oI("ta", 54), Xo0.oIX0oI("te", 55), Xo0.oIX0oI("kn", 56), Xo0.oIX0oI("ne", 57), Xo0.oIX0oI("lo", 64), Xo0.oIX0oI("km", 65), Xo0.oIX0oI("bs", 66), Xo0.oIX0oI("uz", 67), Xo0.oIX0oI("az", 68), Xo0.oIX0oI("ku", 69), Xo0.oIX0oI("kk", 70), Xo0.oIX0oI("sw", 71), Xo0.oIX0oI("ka", 72), Xo0.oIX0oI("zu", 73), Xo0.oIX0oI("pt_BR", 80), Xo0.oIX0oI("mn", 81), Xo0.oIX0oI("ps", 82), Xo0.oIX0oI("ha", 83), Xo0.oIX0oI("is", 84), Xo0.oIX0oI("kk_cn", 85), Xo0.oIX0oI("ca", 86), Xo0.oIX0oI("af", 87), Xo0.oIX0oI("am", 88), Xo0.oIX0oI("tg", 89), Xo0.oIX0oI("hy", 96), Xo0.oIX0oI("si", 97), Xo0.oIX0oI("mi", 98), Xo0.oIX0oI("tm", 99));

    private Languages() {
    }

    public static /* synthetic */ Locale codeToLanguage$default(Languages languages, int i, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = DEFAULT_LANGUAGE;
        }
        return languages.codeToLanguage(i, str);
    }

    public static /* synthetic */ String formatAISparkTargetLang$default(Languages languages, int i, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = DEFAULT_LANGUAGE;
        }
        return languages.formatAISparkTargetLang(i, str);
    }

    public static /* synthetic */ String formatMicrosoftTargetLang$default(Languages languages, int i, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = DEFAULT_LANGUAGE;
        }
        return languages.formatMicrosoftTargetLang(i, str);
    }

    public static /* synthetic */ int languageToCode$default(Languages languages, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = Locale.getDefault().getLanguage();
            IIX0o.oO(str, "getLanguage(...)");
        }
        if ((i2 & 2) != 0) {
            i = 1;
        }
        return languages.languageToCode(str, i);
    }

    @oOoXoXO
    public final Locale codeToLanguage(int i, @OOXIXo String str) {
        String str2;
        IIX0o.x0xO0oo(str, "default");
        Iterator<Map.Entry<String, Integer>> it = LANGUAGES.entrySet().iterator();
        while (true) {
            if (it.hasNext()) {
                Map.Entry<String, Integer> next = it.next();
                str2 = next.getKey();
                if (next.getValue().intValue() == i) {
                    break;
                }
            } else {
                str2 = null;
                break;
            }
        }
        if (str2 != null) {
            str = str2;
        }
        if (IIX0o.Oxx0IOOO(str, "Hant")) {
            return new Locale.Builder().setLanguage(DEFAULT_LANGUAGE_ZH).setScript("Hant").build();
        }
        if (IIX0o.Oxx0IOOO(str, DEFAULT_LANGUAGE_ZH)) {
            return new Locale.Builder().setLanguage(DEFAULT_LANGUAGE_ZH).setScript("Hans").build();
        }
        return new Locale(str);
    }

    @OOXIXo
    public final String formatAISparkTargetLang(int i, @OOXIXo String str) {
        String str2;
        IIX0o.x0xO0oo(str, "default");
        Iterator<Map.Entry<String, Integer>> it = LANGUAGES.entrySet().iterator();
        while (true) {
            if (it.hasNext()) {
                Map.Entry<String, Integer> next = it.next();
                str2 = next.getKey();
                if (next.getValue().intValue() == i) {
                    break;
                }
            } else {
                str2 = null;
                break;
            }
        }
        if (str2 != null) {
            str = str2;
        }
        int hashCode = str.hashCode();
        if (hashCode != 3365) {
            if (hashCode != 3374) {
                if (hashCode != 3484) {
                    if (hashCode != 3488) {
                        if (hashCode != 3521) {
                            if (hashCode != 3576) {
                                if (hashCode != 3886) {
                                    if (hashCode != 93667967) {
                                        if (hashCode != 102098858) {
                                            if (hashCode == 106983531 && str.equals("pt_BR")) {
                                                return "pt";
                                            }
                                            return str;
                                        }
                                        if (str.equals("kk_cn")) {
                                            return "kk";
                                        }
                                        return str;
                                    }
                                    if (str.equals("bg_bg")) {
                                        return "bg";
                                    }
                                    return str;
                                }
                                if (str.equals(DEFAULT_LANGUAGE_ZH)) {
                                    return "cn";
                                }
                                return str;
                            }
                            if (str.equals(UserDataStore.PHONE)) {
                                return "tl";
                            }
                            return str;
                        }
                        if (str.equals("no")) {
                            return "nb";
                        }
                        return str;
                    }
                    if (str.equals(DateFormatUtils.MIN)) {
                        return "my";
                    }
                    return str;
                }
                if (str.equals("mi")) {
                    return "ml";
                }
                return str;
            }
            if (str.equals("iw")) {
                return "he";
            }
            return str;
        }
        if (str.equals("in")) {
            return "id";
        }
        return str;
    }

    @OOXIXo
    public final String formatMicrosoftTargetLang(int i, @OOXIXo String str) {
        String str2;
        IIX0o.x0xO0oo(str, "default");
        Iterator<Map.Entry<String, Integer>> it = LANGUAGES.entrySet().iterator();
        while (true) {
            if (it.hasNext()) {
                Map.Entry<String, Integer> next = it.next();
                str2 = next.getKey();
                if (next.getValue().intValue() == i) {
                    break;
                }
            } else {
                str2 = null;
                break;
            }
        }
        if (str2 != null) {
            str = str2;
        }
        switch (str.hashCode()) {
            case 3365:
                if (str.equals("in")) {
                    return "id";
                }
                return str;
            case 3374:
                if (str.equals("iw")) {
                    return "he";
                }
                return str;
            case 3484:
                if (str.equals("mi")) {
                    return "ml";
                }
                return str;
            case 3488:
                if (str.equals(DateFormatUtils.MIN)) {
                    return "my";
                }
                return str;
            case 3521:
                if (str.equals("no")) {
                    return "nb";
                }
                return str;
            case 3576:
                if (str.equals(UserDataStore.PHONE)) {
                    return "fil";
                }
                return str;
            case 3679:
                if (str.equals("sr")) {
                    return "sr-Latn";
                }
                return str;
            case 3886:
                if (str.equals(DEFAULT_LANGUAGE_ZH)) {
                    return "zh-Hans";
                }
                return str;
            case 93667967:
                if (str.equals("bg_bg")) {
                    return "bg";
                }
                return str;
            case 102098858:
                if (str.equals("kk_cn")) {
                    return "kk";
                }
                return str;
            case 106983531:
                if (str.equals("pt_BR")) {
                    return "pt";
                }
                return str;
            default:
                return str;
        }
    }

    public final int languageBriefToCode(@OOXIXo String language, int i) {
        IIX0o.x0xO0oo(language, "language");
        for (Map.Entry<String, Integer> entry : LANGUAGES.entrySet()) {
            String key = entry.getKey();
            int intValue = entry.getValue().intValue();
            if (IIX0o.Oxx0IOOO(key, language)) {
                return intValue;
            }
        }
        return i;
    }

    public final int languageToCode(@OOXIXo String language, int i) {
        String country;
        int hashCode;
        IIX0o.x0xO0oo(language, "language");
        if (IIX0o.Oxx0IOOO(DEFAULT_LANGUAGE_ZH, language) && (IIX0o.Oxx0IOOO("Hant", Locale.getDefault().getScript()) || ((country = Locale.getDefault().getCountry()) != null && ((hashCode = country.hashCode()) == 2339 ? country.equals("Hk") : !(hashCode == 2466 ? !country.equals("MO") : !(hashCode == 2691 && country.equals("TW"))))))) {
            language = "Hant";
        }
        Integer num = LANGUAGES.get(language);
        if (num != null) {
            i = num.intValue();
        }
        oIX0oI oix0oi = oIX0oI.f1507oIX0oI;
        StringBuilder sb = new StringBuilder();
        sb.append("Languages languageToCode -> language=");
        sb.append(language);
        sb.append(", code=");
        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
        String format = String.format("0x%02X", Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1));
        IIX0o.oO(format, "format(...)");
        sb.append(format);
        oix0oi.XO(sb.toString());
        return i;
    }
}
