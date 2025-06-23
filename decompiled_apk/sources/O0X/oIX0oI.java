package O0X;

import com.google.firebase.crashlytics.buildtools.ndk.NativeSymbolGenerator;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.FilenameUtils;

/* loaded from: classes10.dex */
public final /* synthetic */ class oIX0oI {
    static {
        String[] strArr = NativeSymbolGenerator.SYMBOL_FILE_SUFFIXES;
    }

    public static String oIX0oI(String str, String str2, String str3) {
        String removeExtension = FilenameUtils.removeExtension(str);
        if (removeExtension.startsWith(NativeSymbolGenerator.LIB_PREFIX)) {
            removeExtension = removeExtension.substring(3);
        }
        return String.format("%s-%s-%s", removeExtension, str2, str3);
    }
}
