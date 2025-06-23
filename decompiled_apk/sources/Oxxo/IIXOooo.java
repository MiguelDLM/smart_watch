package Oxxo;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.util.LinkedList;
import java.util.StringTokenizer;

/* loaded from: classes6.dex */
public class IIXOooo {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public LinkedList f3128oIX0oI = new LinkedList();

    public IIXOooo() {
    }

    public boolean I0Io() {
        if (this.f3128oIX0oI.size() == 0) {
            return true;
        }
        return false;
    }

    public II0xO0 II0xO0(int i) {
        return (II0xO0) this.f3128oIX0oI.get(i);
    }

    public int X0o0xo() {
        return this.f3128oIX0oI.size();
    }

    public void oIX0oI(II0xO0 iI0xO0) {
        this.f3128oIX0oI.addLast(iI0xO0);
    }

    public void oxoX() {
        this.f3128oIX0oI.clear();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("\n");
        stringBuffer.append("===========================\n");
        stringBuffer.append("CategoryPath:                   \n");
        stringBuffer.append("---------------------------\n");
        stringBuffer.append("\nCategoryPath:\n\t");
        if (X0o0xo() > 0) {
            for (int i = 0; i < X0o0xo(); i++) {
                stringBuffer.append(II0xO0(i).toString());
                stringBuffer.append("\n\t");
            }
        } else {
            stringBuffer.append("<<NONE>>");
        }
        stringBuffer.append("\n");
        stringBuffer.append("===========================\n");
        return stringBuffer.toString();
    }

    public IIXOooo(String str) {
        str = str == null ? "Debug" : str;
        str.replace(IOUtils.DIR_SEPARATOR_UNIX, '.');
        StringTokenizer stringTokenizer = new StringTokenizer(str.replace('\\', '.'), FileUtils.FILE_EXTENSION_SEPARATOR);
        while (stringTokenizer.hasMoreTokens()) {
            oIX0oI(new II0xO0(stringTokenizer.nextToken()));
        }
    }
}
