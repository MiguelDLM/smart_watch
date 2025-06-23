package XXO0;

import com.kuaishou.weapon.p0.t;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/* loaded from: classes6.dex */
public class oxoX {
    public static String II0xO0(String str, x0xOIoO.II0xO0 iI0xO0) throws BadHanyuPinyinOutputFormatCombination {
        x0xOIoO.I0Io i0Io = x0xOIoO.I0Io.f34098oxoX;
        if (i0Io == iI0xO0.II0xO0() && (x0xOIoO.oxoX.f34106I0Io == iI0xO0.I0Io() || x0xOIoO.oxoX.f34107II0xO0 == iI0xO0.I0Io())) {
            throw new BadHanyuPinyinOutputFormatCombination("tone marks cannot be added to v or u:");
        }
        if (x0xOIoO.I0Io.f34096I0Io == iI0xO0.II0xO0()) {
            str = str.replaceAll("[1-5]", "");
        } else if (i0Io == iI0xO0.II0xO0()) {
            str = oIX0oI(str.replaceAll("u:", t.c));
        }
        if (x0xOIoO.oxoX.f34106I0Io == iI0xO0.I0Io()) {
            str = str.replaceAll("u:", t.c);
        } else if (x0xOIoO.oxoX.f34108oxoX == iI0xO0.I0Io()) {
            str = str.replaceAll("u:", "ü");
        }
        if (x0xOIoO.oIX0oI.f34104II0xO0 == iI0xO0.oIX0oI()) {
            return str.toUpperCase();
        }
        return str;
    }

    public static String oIX0oI(String str) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.matches("[a-z]*[1-5]?")) {
            if (lowerCase.matches("[a-z]*[1-5]")) {
                int numericValue = Character.getNumericValue(lowerCase.charAt(lowerCase.length() - 1));
                char c = 'a';
                int indexOf = lowerCase.indexOf(97);
                int indexOf2 = lowerCase.indexOf(101);
                int indexOf3 = lowerCase.indexOf("ou");
                if (-1 == indexOf) {
                    if (-1 != indexOf2) {
                        indexOf = indexOf2;
                        c = 'e';
                    } else if (-1 != indexOf3) {
                        c = "ou".charAt(0);
                        indexOf = indexOf3;
                    } else {
                        indexOf = lowerCase.length() - 1;
                        while (true) {
                            if (indexOf >= 0) {
                                if (String.valueOf(lowerCase.charAt(indexOf)).matches("[aeiouv]")) {
                                    c = lowerCase.charAt(indexOf);
                                    break;
                                }
                                indexOf--;
                            } else {
                                c = '$';
                                indexOf = -1;
                                break;
                            }
                        }
                    }
                }
                if ('$' != c && -1 != indexOf) {
                    char charAt = "āáăàaēéĕèeīíĭìiōóŏòoūúŭùuǖǘǚǜü".charAt(("aeiouv".indexOf(c) * 5) + (numericValue - 1));
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(lowerCase.substring(0, indexOf).replaceAll(t.c, "ü"));
                    stringBuffer.append(charAt);
                    stringBuffer.append(lowerCase.substring(indexOf + 1, lowerCase.length() - 1).replaceAll(t.c, "ü"));
                    return stringBuffer.toString();
                }
                return lowerCase;
            }
            return lowerCase.replaceAll(t.c, "ü");
        }
        return lowerCase;
    }
}
