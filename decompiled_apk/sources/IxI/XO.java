package IxI;

import com.univocity.parsers.common.I0Io;
import com.univocity.parsers.fixed.FieldAlignment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes13.dex */
public class XO {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final List<Integer> f1071oIX0oI = new ArrayList();

    /* renamed from: II0xO0, reason: collision with root package name */
    public final List<String> f1069II0xO0 = new ArrayList();

    /* renamed from: I0Io, reason: collision with root package name */
    public final List<FieldAlignment> f1068I0Io = new ArrayList();

    /* renamed from: oxoX, reason: collision with root package name */
    public final List<Character> f1072oxoX = new ArrayList();

    /* renamed from: X0o0xo, reason: collision with root package name */
    public boolean f1070X0o0xo = true;

    public XO(LinkedHashMap<String, Integer> linkedHashMap) {
        if (linkedHashMap != null && !linkedHashMap.isEmpty()) {
            for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
                X0o0xo(entry.getKey(), entry.getValue().intValue());
            }
            return;
        }
        throw new IllegalArgumentException("Map of fields and their lengths cannot be null/empty");
    }

    public XO I0Io(int i, FieldAlignment fieldAlignment) {
        return II0XooXoX(null, i, fieldAlignment, (char) 0);
    }

    public XO II0XooXoX(String str, int i, FieldAlignment fieldAlignment, char c) {
        X0IIOO(str, i);
        this.f1071oIX0oI.add(Integer.valueOf(i));
        this.f1069II0xO0.add(str);
        this.f1072oxoX.add(Character.valueOf(c));
        if (str != null) {
            this.f1070X0o0xo = false;
        }
        this.f1068I0Io.add(fieldAlignment);
        return this;
    }

    public XO II0xO0(int i, char c) {
        return II0XooXoX(null, i, FieldAlignment.LEFT, c);
    }

    public void IIXOooo(String str, int i) {
        if (str != null) {
            int indexOf = this.f1069II0xO0.indexOf(str);
            if (indexOf != -1) {
                X0IIOO(str, i);
                this.f1071oIX0oI.set(indexOf, Integer.valueOf(i));
                return;
            } else {
                throw new IllegalArgumentException("Cannot find field with name '" + str + '\'');
            }
        }
        throw new IllegalArgumentException("Field name cannot be null");
    }

    public final void IXxxXO(int i, FieldAlignment fieldAlignment) {
        if (fieldAlignment != null) {
            O0xOxO(i);
            this.f1068I0Io.set(i, fieldAlignment);
            return;
        }
        throw new IllegalArgumentException("Alignment cannot be null");
    }

    public final void O0xOxO(int i) {
        if (i < 0 && i >= this.f1071oIX0oI.size()) {
            throw new IllegalArgumentException("No field defined at index " + i);
        }
    }

    public FieldAlignment[] OOXIXo() {
        List<FieldAlignment> list = this.f1068I0Io;
        return (FieldAlignment[]) list.toArray(new FieldAlignment[list.size()]);
    }

    public int Oo(String str) {
        if (!this.f1070X0o0xo) {
            if (str != null && !str.trim().isEmpty()) {
                String Oo2 = I0Io.Oo(str);
                Iterator<String> it = this.f1069II0xO0.iterator();
                int i = 0;
                while (it.hasNext()) {
                    if (I0Io.Oo(it.next()).equals(Oo2)) {
                        return i;
                    }
                    i++;
                }
                return -1;
            }
            throw new IllegalArgumentException("Field name cannot be null/empty");
        }
        throw new IllegalArgumentException("No field names defined");
    }

    public final void OxI(int i, char c) {
        if (c != 0) {
            O0xOxO(i);
            this.f1072oxoX.set(i, Character.valueOf(c));
            return;
        }
        throw new IllegalArgumentException("Cannot use the null character as padding");
    }

    public XO Oxx0IOOO(String str, int i, FieldAlignment fieldAlignment) {
        return II0XooXoX(str, i, fieldAlignment, (char) 0);
    }

    public void Oxx0xo(FieldAlignment fieldAlignment, int... iArr) {
        for (int i : iArr) {
            IXxxXO(i, fieldAlignment);
        }
    }

    public void OxxIIOOXO(int i, int i2) {
        O0xOxO(i);
        X0IIOO("at index " + i, i2);
        this.f1071oIX0oI.set(i, Integer.valueOf(i2));
    }

    public final void X0IIOO(String str, int i) {
        if (i < 1) {
            if (str == null) {
                throw new IllegalArgumentException("Invalid field length: " + i + " for field at index " + this.f1071oIX0oI.size());
            }
            throw new IllegalArgumentException("Invalid field length: " + i + " for field " + str);
        }
    }

    public XO X0o0xo(String str, int i) {
        return II0XooXoX(str, i, FieldAlignment.LEFT, (char) 0);
    }

    public XO XO(String str, int i, char c) {
        return II0XooXoX(str, i, FieldAlignment.LEFT, c);
    }

    public void o00(char c, String... strArr) {
        for (String str : strArr) {
            OxI(Oo(str), c);
        }
    }

    public void oI0IIXIo(FieldAlignment fieldAlignment, String... strArr) {
        for (String str : strArr) {
            IXxxXO(Oo(str), fieldAlignment);
        }
    }

    public XO oIX0oI(int i) {
        return II0XooXoX(null, i, FieldAlignment.LEFT, (char) 0);
    }

    public char[] oO(Oxx0IOOO oxx0IOOO) {
        char[] x0XOIxOo2 = x0XOIxOo();
        for (int i = 0; i < x0XOIxOo2.length; i++) {
            if (x0XOIxOo2[i] == 0) {
                x0XOIxOo2[i] = oxx0IOOO.x0xO0oo();
            }
        }
        return x0XOIxOo2;
    }

    public int[] oOoXoXO() {
        return I0Io.xoXoI(this.f1071oIX0oI);
    }

    public String[] ooOOo0oXI() {
        if (this.f1070X0o0xo) {
            return null;
        }
        List<String> list = this.f1069II0xO0;
        return (String[]) list.toArray(new String[list.size()]);
    }

    public XO oxoX(int i, FieldAlignment fieldAlignment, char c) {
        return II0XooXoX(null, i, fieldAlignment, c);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Integer num : this.f1071oIX0oI) {
            sb.append("\n\t\t");
            int i2 = i + 1;
            sb.append(i2);
            sb.append('\t');
            if (i < this.f1069II0xO0.size()) {
                sb.append(this.f1069II0xO0.get(i));
            }
            sb.append("length: ");
            sb.append(num);
            sb.append(", align: ");
            sb.append(this.f1068I0Io.get(i));
            sb.append(", padding: ");
            sb.append(this.f1072oxoX.get(i));
            i = i2;
        }
        return sb.toString();
    }

    public char[] x0XOIxOo() {
        return I0Io.IIXOooo(this.f1072oxoX);
    }

    public int x0xO0oo() {
        return this.f1071oIX0oI.size();
    }

    public FieldAlignment xoIox(String str) {
        int Oo2 = Oo(str);
        if (Oo2 != -1) {
            return xxIXOIIO(Oo2);
        }
        throw new IllegalArgumentException("Field '" + str + "' does not exist. Available field names are: " + this.f1069II0xO0);
    }

    public void xoXoI(char c, int... iArr) {
        for (int i : iArr) {
            OxI(i, c);
        }
    }

    public FieldAlignment xxIXOIIO(int i) {
        O0xOxO(i);
        return this.f1068I0Io.get(i);
    }

    public XO(String[] strArr, int[] iArr) {
        if (strArr != null && strArr.length != 0) {
            if (iArr != null && iArr.length != 0) {
                if (strArr.length == iArr.length) {
                    for (int i = 0; i < strArr.length; i++) {
                        X0o0xo(strArr[i], iArr[i]);
                    }
                    return;
                }
                throw new IllegalArgumentException("Sequence of headers and their respective lengths must match. Got " + strArr.length + " headers but " + iArr.length + " lengths");
            }
            throw new IllegalArgumentException("Field lengths cannot be null/empty");
        }
        throw new IllegalArgumentException("Headers cannot be null/empty");
    }

    public XO(int... iArr) {
        for (int i : iArr) {
            oIX0oI(i);
        }
    }
}
