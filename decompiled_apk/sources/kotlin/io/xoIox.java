package kotlin.io;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.OxxIIOOXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.text.StringsKt__StringsKt;

@XX({"SMAP\nFilePathComponents.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FilePathComponents.kt\nkotlin/io/FilesKt__FilePathComponentsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,148:1\n1549#2:149\n1620#2,3:150\n*S KotlinDebug\n*F\n+ 1 FilePathComponents.kt\nkotlin/io/FilesKt__FilePathComponentsKt\n*L\n133#1:149\n133#1:150,3\n*E\n"})
/* loaded from: classes6.dex */
public class xoIox {
    @OXOo.OOXIXo
    public static final String I0Io(@OXOo.OOXIXo File file) {
        IIX0o.x0xO0oo(file, "<this>");
        String path = file.getPath();
        IIX0o.oO(path, "getPath(...)");
        String path2 = file.getPath();
        IIX0o.oO(path2, "getPath(...)");
        String substring = path.substring(0, II0xO0(path2));
        IIX0o.oO(substring, "substring(...)");
        return substring;
    }

    public static final int II0xO0(String str) {
        int XxIIOXIXx2;
        char c = File.separatorChar;
        int XxIIOXIXx3 = StringsKt__StringsKt.XxIIOXIXx(str, c, 0, false, 4, null);
        if (XxIIOXIXx3 == 0) {
            if (str.length() <= 1 || str.charAt(1) != c || (XxIIOXIXx2 = StringsKt__StringsKt.XxIIOXIXx(str, c, 2, false, 4, null)) < 0) {
                return 1;
            }
            int XxIIOXIXx4 = StringsKt__StringsKt.XxIIOXIXx(str, c, XxIIOXIXx2 + 1, false, 4, null);
            if (XxIIOXIXx4 >= 0) {
                return XxIIOXIXx4 + 1;
            }
            return str.length();
        }
        if (XxIIOXIXx3 > 0 && str.charAt(XxIIOXIXx3 - 1) == ':') {
            return XxIIOXIXx3 + 1;
        }
        if (XxIIOXIXx3 != -1 || !StringsKt__StringsKt.OXooXo(str, ':', false, 2, null)) {
            return 0;
        }
        return str.length();
    }

    @OXOo.OOXIXo
    public static final File X0o0xo(@OXOo.OOXIXo File file, int i, int i2) {
        IIX0o.x0xO0oo(file, "<this>");
        return XO(file).xoIox(i, i2);
    }

    @OXOo.OOXIXo
    public static final Oxx0IOOO XO(@OXOo.OOXIXo File file) {
        List list;
        IIX0o.x0xO0oo(file, "<this>");
        String path = file.getPath();
        IIX0o.ooOOo0oXI(path);
        int II0xO02 = II0xO0(path);
        String substring = path.substring(0, II0xO02);
        IIX0o.oO(substring, "substring(...)");
        String substring2 = path.substring(II0xO02);
        IIX0o.oO(substring2, "substring(...)");
        if (substring2.length() == 0) {
            list = CollectionsKt__CollectionsKt.ooXIXxIX();
        } else {
            List Xxx0oXX2 = StringsKt__StringsKt.Xxx0oXX(substring2, new char[]{File.separatorChar}, false, 0, 6, null);
            ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(Xxx0oXX2, 10));
            Iterator it = Xxx0oXX2.iterator();
            while (it.hasNext()) {
                arrayList.add(new File((String) it.next()));
            }
            list = arrayList;
        }
        return new Oxx0IOOO(new File(substring), list);
    }

    @OXOo.OOXIXo
    public static final File oIX0oI(@OXOo.OOXIXo File file) {
        IIX0o.x0xO0oo(file, "<this>");
        return new File(I0Io(file));
    }

    public static final boolean oxoX(@OXOo.OOXIXo File file) {
        IIX0o.x0xO0oo(file, "<this>");
        String path = file.getPath();
        IIX0o.oO(path, "getPath(...)");
        if (II0xO0(path) > 0) {
            return true;
        }
        return false;
    }
}
