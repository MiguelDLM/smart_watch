package IXIxx0;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oxxXoxO;

@XX({"SMAP\nDebugMetadata.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugMetadata.kt\nkotlin/coroutines/jvm/internal/DebugMetadataKt\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,134:1\n37#2,2:135\n*S KotlinDebug\n*F\n+ 1 DebugMetadata.kt\nkotlin/coroutines/jvm/internal/DebugMetadataKt\n*L\n131#1:135,2\n*E\n"})
/* loaded from: classes6.dex */
public final class X0o0xo {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final int f731oIX0oI = 1;

    public static final int I0Io(BaseContinuationImpl baseContinuationImpl) {
        Integer num;
        int i;
        try {
            Field declaredField = baseContinuationImpl.getClass().getDeclaredField(TTDownloadField.TT_LABEL);
            declaredField.setAccessible(true);
            Object obj = declaredField.get(baseContinuationImpl);
            if (obj instanceof Integer) {
                num = (Integer) obj;
            } else {
                num = null;
            }
            if (num != null) {
                i = num.intValue();
            } else {
                i = 0;
            }
            return i - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static final oxoX II0xO0(BaseContinuationImpl baseContinuationImpl) {
        return (oxoX) baseContinuationImpl.getClass().getAnnotation(oxoX.class);
    }

    @XO0OX.xxIXOIIO(name = "getStackTraceElement")
    @oxxXoxO(version = "1.3")
    @oOoXoXO
    public static final StackTraceElement X0o0xo(@OOXIXo BaseContinuationImpl baseContinuationImpl) {
        int i;
        String str;
        IIX0o.x0xO0oo(baseContinuationImpl, "<this>");
        oxoX II0xO02 = II0xO0(baseContinuationImpl);
        if (II0xO02 == null) {
            return null;
        }
        oIX0oI(1, II0xO02.v());
        int I0Io2 = I0Io(baseContinuationImpl);
        if (I0Io2 < 0) {
            i = -1;
        } else {
            i = II0xO02.l()[I0Io2];
        }
        String II0xO03 = Oxx0IOOO.f727oIX0oI.II0xO0(baseContinuationImpl);
        if (II0xO03 == null) {
            str = II0xO02.c();
        } else {
            str = II0xO03 + IOUtils.DIR_SEPARATOR_UNIX + II0xO02.c();
        }
        return new StackTraceElement(str, II0xO02.m(), II0xO02.f(), i);
    }

    public static final void oIX0oI(int i, int i2) {
        if (i2 <= i) {
            return;
        }
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i + ", got " + i2 + ". Please update the Kotlin standard library.").toString());
    }

    @XO0OX.xxIXOIIO(name = "getSpilledVariableFieldMapping")
    @oxxXoxO(version = "1.3")
    @oOoXoXO
    public static final String[] oxoX(@OOXIXo BaseContinuationImpl baseContinuationImpl) {
        IIX0o.x0xO0oo(baseContinuationImpl, "<this>");
        oxoX II0xO02 = II0xO0(baseContinuationImpl);
        if (II0xO02 == null) {
            return null;
        }
        oIX0oI(1, II0xO02.v());
        ArrayList arrayList = new ArrayList();
        int I0Io2 = I0Io(baseContinuationImpl);
        int[] i = II0xO02.i();
        int length = i.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i[i2] == I0Io2) {
                arrayList.add(II0xO02.s()[i2]);
                arrayList.add(II0xO02.n()[i2]);
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }
}
