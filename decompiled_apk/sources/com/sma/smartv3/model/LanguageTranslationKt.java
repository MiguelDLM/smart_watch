package com.sma.smartv3.model;

import OXOo.OOXIXo;
import com.garmin.fit.OxXXx0X;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.utils.bc;
import com.kuaishou.weapon.p0.t;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.util.UtilsKt;
import com.szabh.smable3.entity.Languages;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.Xo0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nLanguageTranslation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LanguageTranslation.kt\ncom/sma/smartv3/model/LanguageTranslationKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,586:1\n1#2:587\n*E\n"})
/* loaded from: classes12.dex */
public final class LanguageTranslationKt {

    @OOXIXo
    private static final ArrayList<LanguageTranslationData> languageList = new ArrayList<>();

    public static final void clearTranslationLanguageList() {
        languageList.clear();
    }

    @OOXIXo
    public static final String detectLanguage(@OOXIXo String text) {
        Object obj;
        IIX0o.x0xO0oo(text, "text");
        if (text.length() == 0) {
            return "unknown";
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Set OxxIIOOXO2 = Xo0.OxxIIOOXO((char) 224, (char) 226, (char) 231, (char) 232, (char) 233, (char) 234, (char) 235, (char) 238, (char) 239, (char) 244, (char) 249, (char) 251, (char) 252, (char) 255, (char) 339, (char) 230, (char) 192, (char) 194, (char) 199, (char) 200, (char) 201, (char) 202, (char) 203, (char) 206, (char) 207, (char) 212, (char) 217, (char) 219, (char) 220, (char) 376, (char) 338, (char) 198);
        Set OxxIIOOXO3 = Xo0.OxxIIOOXO((char) 228, (char) 246, (char) 252, (char) 223, (char) 196, (char) 214, (char) 220);
        Set OxxIIOOXO4 = Xo0.OxxIIOOXO((char) 225, (char) 233, (char) 237, (char) 243, (char) 250, (char) 252, (char) 241, (char) 191, (char) 161, (char) 193, (char) 201, (char) 205, (char) 211, (char) 218, (char) 220, (char) 209);
        Set OxxIIOOXO5 = Xo0.OxxIIOOXO((char) 227, (char) 245, (char) 225, (char) 233, (char) 237, (char) 243, (char) 250, (char) 234, (char) 244, (char) 231, (char) 195, (char) 213, (char) 193, (char) 201, (char) 205, (char) 211, (char) 218, (char) 202, (char) 212, (char) 199);
        Set OxxIIOOXO6 = Xo0.OxxIIOOXO((char) 287, (char) 286, (char) 305, (char) 304, (char) 351, (char) 350, (char) 231, (char) 199);
        Set OxxIIOOXO7 = Xo0.OxxIIOOXO((char) 224, (char) 232, (char) 233, (char) 236, (char) 242, (char) 249, (char) 192, (char) 200, (char) 201, (char) 204, (char) 210, (char) 217);
        Set OxxIIOOXO8 = Xo0.OxxIIOOXO((char) 261, (char) 263, (char) 281, (char) 322, (char) 324, (char) 243, (char) 347, (char) 378, (char) 380, (char) 260, (char) 262, (char) 280, (char) 321, (char) 323, (char) 211, (char) 346, (char) 377, (char) 379);
        Set OxxIIOOXO9 = Xo0.OxxIIOOXO((char) 235, (char) 239, (char) 203, (char) 207);
        int length = text.length();
        for (int i = 0; i < length; i++) {
            char charAt = text.charAt(i);
            if (19968 <= charAt && charAt < 40960) {
                inc(linkedHashMap, Languages.DEFAULT_LANGUAGE_ZH);
            } else if (12352 <= charAt && charAt < 12448) {
                inc(linkedHashMap, "ja");
            } else if (12448 <= charAt && charAt < 12544) {
                inc(linkedHashMap, "ja");
            } else if (44032 <= charAt && charAt < 55216) {
                inc(linkedHashMap, "ko");
            } else if (1024 <= charAt && charAt < 1280) {
                inc(linkedHashMap, "ru");
            } else if (880 <= charAt && charAt < 1024) {
                inc(linkedHashMap, t.n);
            } else if (1536 <= charAt && charAt < 1792) {
                inc(linkedHashMap, "ar");
            } else if (1424 <= charAt && charAt < 1536) {
                inc(linkedHashMap, "he");
            } else if (3584 <= charAt && charAt < 3712) {
                inc(linkedHashMap, "th");
            } else if (3712 <= charAt && charAt < 3840) {
                inc(linkedHashMap, "lo");
            } else if (4096 <= charAt && charAt < 4256) {
                inc(linkedHashMap, "my");
            } else if (4256 <= charAt && charAt < 4352) {
                inc(linkedHashMap, "ka");
            } else if (1328 <= charAt && charAt < 1424) {
                inc(linkedHashMap, "hy");
            } else if (6016 <= charAt && charAt < 6144) {
                inc(linkedHashMap, "km");
            } else if (2304 <= charAt && charAt < 2432) {
                inc(linkedHashMap, "hi");
            } else if (2432 <= charAt && charAt < 2560) {
                inc(linkedHashMap, "bn");
            } else if (2560 <= charAt && charAt < 2688) {
                inc(linkedHashMap, "pa");
            } else if (2688 <= charAt && charAt < 2816) {
                inc(linkedHashMap, "gu");
            } else if (2816 <= charAt && charAt < 2944) {
                inc(linkedHashMap, "or");
            } else if (2944 <= charAt && charAt < 3072) {
                inc(linkedHashMap, "ta");
            } else if (3072 <= charAt && charAt < 3200) {
                inc(linkedHashMap, "te");
            } else if (3200 <= charAt && charAt < 3328) {
                inc(linkedHashMap, "kn");
            } else if (3328 <= charAt && charAt < 3456) {
                inc(linkedHashMap, "ml");
            } else if (3456 <= charAt && charAt < 3584) {
                inc(linkedHashMap, "si");
            } else if (OxxIIOOXO3.contains(Character.valueOf(charAt))) {
                inc(linkedHashMap, "de");
            } else if (OxxIIOOXO2.contains(Character.valueOf(charAt))) {
                inc(linkedHashMap, "fr");
            } else if (OxxIIOOXO4.contains(Character.valueOf(charAt))) {
                inc(linkedHashMap, "es");
            } else if (OxxIIOOXO5.contains(Character.valueOf(charAt))) {
                inc(linkedHashMap, "pt");
            } else if (OxxIIOOXO6.contains(Character.valueOf(charAt))) {
                inc(linkedHashMap, "tr");
            } else if (OxxIIOOXO7.contains(Character.valueOf(charAt))) {
                inc(linkedHashMap, "it");
            } else if (OxxIIOOXO8.contains(Character.valueOf(charAt))) {
                inc(linkedHashMap, "pl");
            } else if (OxxIIOOXO9.contains(Character.valueOf(charAt))) {
                inc(linkedHashMap, "nl");
            } else if (charAt >= 0 && charAt < 128) {
                inc(linkedHashMap, Languages.DEFAULT_LANGUAGE);
            } else if (128 > charAt || charAt >= 256) {
                if ((7680 <= charAt && charAt < 7936) || charAt == 416 || charAt == 417 || charAt == 431 || charAt == 432 || charAt == 208 || charAt == 272) {
                    inc(linkedHashMap, "vi");
                }
            } else if (!OxxIIOOXO2.contains(Character.valueOf(charAt)) && !OxxIIOOXO3.contains(Character.valueOf(charAt)) && !OxxIIOOXO4.contains(Character.valueOf(charAt)) && !OxxIIOOXO5.contains(Character.valueOf(charAt)) && !OxxIIOOXO6.contains(Character.valueOf(charAt)) && !OxxIIOOXO7.contains(Character.valueOf(charAt)) && !OxxIIOOXO8.contains(Character.valueOf(charAt)) && !OxxIIOOXO9.contains(Character.valueOf(charAt))) {
                inc(linkedHashMap, Languages.DEFAULT_LANGUAGE);
            }
        }
        Iterator it = linkedHashMap.entrySet().iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                int intValue = ((Number) ((Map.Entry) next).getValue()).intValue();
                do {
                    Object next2 = it.next();
                    int intValue2 = ((Number) ((Map.Entry) next2).getValue()).intValue();
                    if (intValue < intValue2) {
                        next = next2;
                        intValue = intValue2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        Map.Entry entry = (Map.Entry) obj;
        String str = entry != null ? (String) entry.getKey() : null;
        if (str == null) {
            return "unknown";
        }
        switch (str.hashCode()) {
            case OxXXx0X.f13243xOoIIIoXI /* 3121 */:
                return !str.equals("ar") ? "unknown" : "ar-SA";
            case 3148:
                return !str.equals("bn") ? "unknown" : "bn-BD";
            case 3201:
                return !str.equals("de") ? "unknown" : "de-DE";
            case 3239:
                return !str.equals(t.n) ? "unknown" : "el-GR";
            case 3241:
                return !str.equals(Languages.DEFAULT_LANGUAGE) ? "unknown" : "en-US";
            case OxXXx0X.f13039OOOox /* 3246 */:
                return !str.equals("es") ? "unknown" : "es-ES";
            case 3276:
                return !str.equals("fr") ? "unknown" : "fr-FR";
            case 3310:
                return !str.equals("gu") ? "unknown" : "gu-IN";
            case 3325:
                return !str.equals("he") ? "unknown" : "he-IL";
            case 3329:
                return !str.equals("hi") ? "unknown" : "hi-IN";
            case 3345:
                return !str.equals("hy") ? "unknown" : "hy-AM";
            case 3371:
                return !str.equals("it") ? "unknown" : "it-IT";
            case 3383:
                return !str.equals("ja") ? "unknown" : "ja-JP";
            case 3414:
                return !str.equals("ka") ? "unknown" : "ka-GE";
            case 3426:
                return !str.equals("km") ? "unknown" : "km-KH";
            case 3427:
                return !str.equals("kn") ? "unknown" : "kn-IN";
            case 3428:
                return !str.equals("ko") ? "unknown" : "ko-KR";
            case 3459:
                return !str.equals("lo") ? "unknown" : "lo-LA";
            case 3487:
                return !str.equals("ml") ? "unknown" : "ml-IN";
            case OxXXx0X.f13024OIII0O /* 3500 */:
                return !str.equals("my") ? "unknown" : "my-MM";
            case 3518:
                return !str.equals("nl") ? "unknown" : "nl-NL";
            case 3555:
                return !str.equals("or") ? "unknown" : "or-IN";
            case 3569:
                return !str.equals("pa") ? "unknown" : "pa-IN";
            case 3580:
                return !str.equals("pl") ? "unknown" : "pl-PL";
            case 3588:
                return !str.equals("pt") ? "unknown" : "pt-PT";
            case 3651:
                return !str.equals("ru") ? "unknown" : "ru-RU";
            case 3670:
                return !str.equals("si") ? "unknown" : "si-LK";
            case 3693:
                return !str.equals("ta") ? "unknown" : "ta-IN";
            case 3697:
                return !str.equals("te") ? "unknown" : "te-IN";
            case 3700:
                return !str.equals("th") ? "unknown" : "th-TH";
            case 3710:
                return !str.equals("tr") ? "unknown" : "tr-TR";
            case 3763:
                return !str.equals("vi") ? "unknown" : "vi-VN";
            case 3886:
                return !str.equals(Languages.DEFAULT_LANGUAGE_ZH) ? "unknown" : bc.Code;
            default:
                return "unknown";
        }
    }

    @OOXIXo
    public static final String getTranslationLanguageASRLanguage(@OOXIXo String rtasrLanguage) {
        Object obj;
        String asrLanguage;
        IIX0o.x0xO0oo(rtasrLanguage, "rtasrLanguage");
        Iterator<T> it = getTranslationLanguageList().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (IIX0o.Oxx0IOOO(((LanguageTranslationData) obj).getRtasrLanguage(), rtasrLanguage)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        LanguageTranslationData languageTranslationData = (LanguageTranslationData) obj;
        if (languageTranslationData == null || (asrLanguage = languageTranslationData.getAsrLanguage()) == null) {
            return "zh-cn";
        }
        return asrLanguage;
    }

    @OOXIXo
    public static final List<LanguageTranslationData> getTranslationLanguageList() {
        ProductManager productManager = ProductManager.f20544oIX0oI;
        if (productManager.XI0IXoo()) {
            ArrayList<LanguageTranslationData> arrayList = languageList;
            if (!arrayList.isEmpty() && arrayList.size() != 0) {
                if (!IIX0o.Oxx0IOOO(arrayList.get(0).getTtsViuceName(), "zh-CN-XiaoxiaoNeural")) {
                    microsoftLanguage();
                }
            } else {
                microsoftLanguage();
            }
        } else if (productManager.oO0OX0()) {
            ArrayList<LanguageTranslationData> arrayList2 = languageList;
            if (!arrayList2.isEmpty() && arrayList2.size() != 0) {
                if (!IIX0o.Oxx0IOOO(arrayList2.get(0).getTtsViuceName(), "x4_lingxiaolu_en")) {
                    sparkChainLanguage();
                }
            } else {
                sparkChainLanguage();
            }
        } else {
            ArrayList<LanguageTranslationData> arrayList3 = languageList;
            if (!arrayList3.isEmpty() && arrayList3.size() != 0) {
                if (!IIX0o.Oxx0IOOO(arrayList3.get(0).getTtsViuceName(), "zh-CN-XiaoxiaoNeural")) {
                    microsoftLanguage();
                }
            } else {
                microsoftLanguage();
            }
        }
        return languageList;
    }

    @OOXIXo
    public static final String getTranslationLanguageTtsName(@OOXIXo String rtasrLanguage) {
        Object obj;
        String ttsViuceName;
        IIX0o.x0xO0oo(rtasrLanguage, "rtasrLanguage");
        Iterator<T> it = getTranslationLanguageList().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (IIX0o.Oxx0IOOO(((LanguageTranslationData) obj).getRtasrLanguage(), rtasrLanguage)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        LanguageTranslationData languageTranslationData = (LanguageTranslationData) obj;
        if (languageTranslationData == null || (ttsViuceName = languageTranslationData.getTtsViuceName()) == null) {
            return "x4_enus_catherine_profnews";
        }
        return ttsViuceName;
    }

    public static final void inc(@OOXIXo Map<String, Integer> map, @OOXIXo String key) {
        int i;
        IIX0o.x0xO0oo(map, "<this>");
        IIX0o.x0xO0oo(key, "key");
        Integer num = map.get(key);
        if (num != null) {
            i = num.intValue();
        } else {
            i = 0;
        }
        map.put(key, Integer.valueOf(i + 1));
    }

    private static final void microsoftLanguage() {
        languageList.addAll(CollectionsKt__CollectionsKt.X00IoxXI(new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_chinese), bc.Code, "zh-Hans", "zh-CN-XiaoxiaoNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_english), "en-US", Languages.DEFAULT_LANGUAGE, "en-US-AvaMultilingualNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_russian), "ru-RU", "ru", "ru-RU-SvetlanaNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_korean), "ko-KR", "ko", "ko-KR-SunHiNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_german), "de-DE", "de", "de-DE-KatjaNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_japanese), "ja-JP", "ja", "ja-JP-NanamiNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_vietnamese), "vi-VN", "vi", "vi-VN-HoaiMyNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_arabic), "ar-SA", "ar", "ar-SA-ZariyahNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_nepali), "ne-NP", "ne", "ne-NP-HemkalaNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_romanian), "ro-RO", "ro", "ro-RO-AlinaNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_hindi), "hi-IN", "hi", "hi-IN-AaravNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_kazakh_language), "kk-KZ", "kk", "kk-KZ-AigulNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_jkazakh_neh), "kk-KZ", "kk", "kk-KZ-AigulNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_swedish_language), "sv-SE", "sv", "sv-SE-SofieNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_polish), "pl-PL", "pl", "pl-PL-AgnieszkaNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_slovenian), "sl-SI", "sl", "sl-SI-PetraNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_zulu), "zu-ZA", "zu", "zu-ZA-ThandoNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_lao), "lo-LA", "lo", "lo-LA-KeomanyNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_norwegian_language), "nb-NO", "nb", "nb-NO-PernilleNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_french), "fr-FR", "fr", "fr-FR-DeniseNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_portuguese), "pt-PT", "pt", "pt-PT-RaquelNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_brazilian_portuguese), "pt-BR", "pt", "pt-BR-FranciscaNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_spanish), "es-ES", "es", "es-ES-ElviraNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_urdu), "ur-IN", x.cL, "ur-IN-GulNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_mongol), "mn-MN", "mn", "mn-MN-YesuiNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_marathi), "mr-IN", "mr", "mr-IN-AarohiNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_pashto), "ps-AF", "ps", "ps-AF-LatifaNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_farsi), "fa-IR", "fa", "fa-IR-DilaraNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_danish), "da-DK", "da", "da-DK-ChristelNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_hungarian), "hu-HU", "hu", "hu-HU-NoemiNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_telugu), "te-IN", "te", "te-IN-ShrutiNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_hebrew), "he-IL", "he", "he-IL-HilaNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_island), "is-IS", "is", "is-IS-GudrunNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_slovakia), "sk-SK", "sk", "sk-SK-ViktoriaNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_serbian), "sr-RS", "sr-Latn", "sr-Latn-RS-NicholasNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_georgian), "ka-GE", "ka", "ka-GE-EkaNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_croatian), "hr-HR", "hr", "hr-HR-GabrijelaNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_uzbek), "uz-UZ", "uz", "uz-UZ-MadinaNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_malay), "ms-MY", "ms", "ms-MY-YasminNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_bulgarian), "bg-BG", "bg", "bg-BG-KalinaNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_filipino), "fil-PH", "fil", "fil-PH-BlessicaNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_tamil), "ta-IN", "ta", "ta-IN-PallaviNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_turkish), "tr-TR", "tr", "tr-TR-EmelNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_swahili), "sw-KE", "sw", "sw-KE-ZuriNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_dutch), "nl-NL", "nl", "nl-NL-FennaNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_finnish), "fi-FI", "fi", "fi-FI-SelmaNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_catalan), "ca-ES", "ca", "ca-ES-JoanaNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_azerbaijani), "az-AZ", "az", "az-AZ-BanuNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_amharic), "am-ET", "am", "am-ET-MekdesNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_czech), "cs-CZ", "cs", "cs-CZ-VlastaNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_italian), "it-IT", "it", "it-IT-ElsaNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_thai), "th-TH", "th", "th-TH-PremwadeeNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_armenian), "hy-AM", "hy", "hy-AM-AnahitNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_sinhala), "si-LK", "si", "si-LK-ThiliniNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_bengali), "bn-IN", "bn", "bn-IN-TanishaaNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_burmese), "my-MM", "my", "my-MM-NilarNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_ukrainian), "uk-UA", "uk", "uk-UA-PolinaNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_malayalam), "ml-IN", "ml", "ml-IN-SobhanaNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_latvian), "lv-LV", "lv", "lv-LV-EveritaNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_lithuanian), "lt-LT", "lt", "lt-LT-OnaNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_khmer), "km-KH", "km", "km-KH-SreymomNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_greek), "el-GR", t.n, "el-GR-AthinaNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_assamese), "as-IN", "as", "as-IN-YashicaNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_bosnian), "bs-BA", "bs", "bs-BA-VesnaNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_welsh), "cy-GB", "cy", "cy-GB-NiaNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_estonian), "et-EE", "et", "et-EE-AnuNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_basque), "eu-ES", "eu", "eu-ES-AinhoaNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_irish), "ga-IE", "ga", "ga-IE-OrlaNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_galician), "gl-ES", "gl", "gl-ES-SabelaNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_gujarati), "gu-IN", "gu", "gu-IN-DhwaniNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_javanese), "jv-ID", "jv", "jv-ID-SitiNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_kannada), "kn-IN", "kn", "kn-IN-SapnaNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_macedonian), "mk-MK", "mk", "mk-MK-MarijaNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_maltese), "mt-MT", "mt", "mt-MT-JosephNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_iriya), "or-IN", "or", "or-IN-SukantNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_punjabi), "pa-IN", "pa", "pa-IN-OjasNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_somali), "so-SO", "so", "so-SO-UbaxNeural", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_albanian), "sq-AL", "sq", "sq-AL-AnilaNeural", false, 0, null, 0, 240, null)));
    }

    private static final void sparkChainLanguage() {
        languageList.addAll(CollectionsKt__CollectionsKt.X00IoxXI(new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_chinese), "zh-cn", "cn", "x4_lingxiaolu_en", true, 0, null, 0, 224, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_english), "en_us", Languages.DEFAULT_LANGUAGE, "x4_enus_catherine_profnews", true, 0, null, 0, 224, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_russian), "ru-ru", "ru", "x2_ruru_keshu", true, 0, null, 0, 224, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_korean), "ko_kr", "ko", "x2_kokr_miya", true, 0, null, 0, 224, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_german), "de_DE", "de", "x2_dede_christiane", true, 0, null, 0, 224, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_japanese), "ja_jp", "ja", "x2_jajp_zhongcun", true, 0, null, 0, 224, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_vietnamese), "vi_VN", "vi", "x2_vivn_thuhien", true, 0, null, 0, 224, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_arabic), "ar_il", "ar", "x2_aren_rania", true, 0, null, 0, 224, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_nepali), "ne_np", "ne", null, false, 0, null, 0, 248, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_romanian), "ro_ro", "ro", "x2_roro_miruna", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_hindi), "hi_in", "hi", "x2_hiin_mohita", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_kazakh_language), "kk_KZ", "kk", null, false, 0, null, 0, 248, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_jkazakh_neh), "kk_cn", "kk", null, false, 0, null, 0, 248, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_swedish_language), "sv_SE", "sv", "x2_svse_michaela", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_polish), "pl_pl", "pl", "x2_natali", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_slovenian), "sl_si", "sl", null, false, 0, null, 0, 248, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_zulu), "zu_za", "zu", null, false, 0, null, 0, 248, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_lao), "lo_LA", "lo", null, false, 0, null, 0, 248, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_norwegian_language), "nb_NO", "nb", null, false, 0, null, 0, 248, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_french), "fr_fr", "fr", "x2_mariane", true, 0, null, 0, 224, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_portuguese), "pt_PT", "pt", "maria", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_brazilian_portuguese), "pt_BR", "pt", "sonia", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_spanish), "es_es", "es", "x2_spes_aurora", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_urdu), "ur_IN", x.cL, "baili", true, 0, null, 0, 224, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_mongol), "mn_MN", "mn", null, true, 0, null, 0, 232, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_marathi), "mr_in", "mr", null, false, 0, null, 0, 248, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_pashto), "ps_ar", "ps", null, false, 0, null, 0, 248, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_hausa), "ha_NG", "ha", "x2_hang_zainab", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_farsi), "fa_IR", "fa", "x2_fair_saheli", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_danish), "da_DK", "da", null, false, 0, null, 0, 248, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_indonesian), "id_ID", "id", "x2_IdId_Fira", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_hungarian), "hu_hu", "hu", null, false, 0, null, 0, 248, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_telugu), "te_in", "te", null, false, 0, null, 0, 248, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_hebrew), "he_il", "he", null, false, 0, null, 0, 248, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_island), "is_IS", "is", null, false, 0, null, 0, 248, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_slovakia), "sk_sk", "sk", null, false, 0, null, 0, 248, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_serbian), "sr_RS", "sr", null, false, 0, null, 0, 248, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_georgian), "ka_ge", "ka", null, false, 0, null, 0, 248, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_croatian), "hr_hr", "hr", null, false, 0, null, 0, 248, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_uzbek), "uz_UZ", "uz", "x2_uzuz_nigina", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_malay), "ms_MY", "ms", "x2_msmy_hashim", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_bulgarian), "bg_bg", "bg", "x2_bgbg_zlati", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_filipino), "fil_PH", "tl", "x2_tlph_grace", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_tamil), "ta_in", "ta", "x2_tain_udaya", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_turkish), "tr_TR", "tr", "x2_trtr_ersoy", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_swahili), "sw_KE", "sw", "x2_swtz_hamdan", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_dutch), "nl_NL", "nl", "x2_nlnl_robin", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_finnish), "fi_fi", "fi", null, false, 0, null, 0, 248, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_catalan), "ca_es", "ca", null, false, 0, null, 0, 248, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_azerbaijani), "az_AZ", "az", null, false, 0, null, 0, 248, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_afrikaans), "af_za", "af", null, false, 0, null, 0, 248, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_amharic), "am_et", "am", null, false, 0, null, 0, 248, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_czech), "cs_CZ", "cs", "x2_cscz_petra", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_italian), "it_IT", "it", "x2_itit_anna", true, 0, null, 0, 224, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_thai), "th_TH", "th", "yingying", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_tajik), "tg_tg", "tg", null, false, 0, null, 0, 248, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_armenian), "hy_AM", "hy", null, false, 0, null, 0, 248, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_sinhala), "si_lk", "si", null, false, 0, null, 0, 248, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_bengali), "bn_BD", "bn", "x2_bnbd_elmy", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_burmese), "my_mm", "my", null, false, 0, null, 0, 248, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_ukrainian), "uk_UA", "uk", "x2_ukua_halyna", false, 0, null, 0, 240, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_malayalam), "ml_in", "ml", null, false, 0, null, 0, 248, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_latvian), "lv_lv", "lv", null, false, 0, null, 0, 248, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_lithuanian), "lt_LT", "lt", null, false, 0, null, 0, 248, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_turkmen), "tm_tk", "tm", null, false, 0, null, 0, 248, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_khmer), "km_KH", "km", null, false, 0, null, 0, 248, null), new LanguageTranslationData(UtilsKt.oI0IIXIo(R.string.language_greek), "el_GR", t.n, "x2_elgr_dimitra", false, 0, null, 0, 240, null)));
    }

    public static final void main() {
        PrintStream printStream = System.out;
        printStream.println((Object) "--- Basic Tests ---");
        printStream.println((Object) ("'你好世界' is detected as: " + detectLanguage("你好世界")));
        printStream.println((Object) ("'Hello World' is detected as: " + detectLanguage("Hello World")));
        printStream.println((Object) ("'こんにちは、世界' is detected as: " + detectLanguage("こんにちは、世界")));
        printStream.println((Object) ("'안녕하세요 세계' is detected as: " + detectLanguage("안녕하세요 세계")));
        printStream.println((Object) ("'Привет, мир!' is detected as: " + detectLanguage("Привет, мир!")));
        printStream.println((Object) ("'สวัสดีชาวโลก' is detected as: " + detectLanguage("สวัสดีชาวโลก")));
        printStream.println((Object) ("'Bonjour le monde' is detected as: " + detectLanguage("Bonjour le monde")));
        printStream.println((Object) ("'café au lait' is detected as: " + detectLanguage("café au lait")));
        printStream.println((Object) ("'Hallo Welt' is detected as: " + detectLanguage("Hallo Welt")));
        printStream.println((Object) ("'Straße des Glücks' is detected as: " + detectLanguage("Straße des Glücks")));
        printStream.println((Object) ("'Hola Mundo' is detected as: " + detectLanguage("Hola Mundo")));
        printStream.println((Object) ("'¿Qué tal?' is detected as: " + detectLanguage("¿Qué tal?")));
        printStream.println((Object) ("'Olá Mundo' is detected as: " + detectLanguage("Olá Mundo")));
        printStream.println((Object) ("'Xin chào thế giới' is detected as: " + detectLanguage("Xin chào thế giới")));
        printStream.println((Object) "\n--- Other Script Tests ---");
        printStream.println((Object) ("'Γειά σου Κόσμε' is detected as: " + detectLanguage("Γειά σου Κόσμε")));
        printStream.println((Object) ("'مرحبا بالعالم' is detected as: " + detectLanguage("مرحبا بالعالم")));
        printStream.println((Object) ("'שלום עולם' is detected as: " + detectLanguage("שלום עולם")));
        printStream.println((Object) ("'नमस्ते दुनिया' is detected as: " + detectLanguage("नमस्ते दुनिया")));
        printStream.println((Object) ("'হ্যালো ওয়ার্ল্ড' is detected as: " + detectLanguage("হ্যালো ওয়ার্ল্ড")));
        printStream.println((Object) ("'வணக்கம் உலகம்' is detected as: " + detectLanguage("வணக்கம் உலகம்")));
        printStream.println((Object) ("'ሰላም ልዑል' is detected as: " + detectLanguage("ሰላም ልዑል")));
        printStream.println((Object) ("'你好 Hello こんにちは' is detected as: " + detectLanguage("你好 Hello こんにちは")));
        printStream.println((Object) ("'Merhaba Dünya' is detected as: " + detectLanguage("Merhaba Dünya")));
        printStream.println((Object) ("'Ciao mondo è bello' is detected as: " + detectLanguage("Ciao mondo è bello")));
        printStream.println((Object) ("'Witaj świecie' is detected as: " + detectLanguage("Witaj świecie")));
        printStream.println((Object) ("'Hallo wereld met ëen' is detected as: " + detectLanguage("Hallo wereld met ëen")));
        printStream.println((Object) "\n--- Edge Cases ---");
        printStream.println((Object) ("'' (Empty string) is detected as: " + detectLanguage("")));
        printStream.println((Object) ("'12345 @#$%^' is detected as: " + detectLanguage("12345 @#$%^")));
        printStream.println((Object) ("'你好123' is detected as: " + detectLanguage("你好123")));
    }
}
