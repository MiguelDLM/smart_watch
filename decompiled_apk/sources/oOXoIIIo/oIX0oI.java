package oOXoIIIo;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.WindowManager;
import androidx.annotation.AnyRes;
import androidx.annotation.FloatRange;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bestmafen.androidbase.SimpleWebViewActivity;
import com.blankj.utilcode.util.LogUtils;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,202:1\n87#1,7:203\n94#1,3:211\n70#1,7:214\n97#1:221\n99#1,7:222\n106#1,3:230\n79#1,7:233\n109#1:240\n70#1,2:242\n72#1,5:245\n70#1,2:251\n72#1,5:254\n79#1,2:260\n81#1,5:263\n79#1,2:269\n81#1,5:272\n143#1,2:278\n145#1,5:281\n143#1,2:287\n145#1,5:290\n154#1,2:296\n156#1,5:299\n154#1,2:305\n156#1,5:308\n1#2:210\n1#2:229\n1#2:241\n1#2:244\n1#2:250\n1#2:253\n1#2:259\n1#2:262\n1#2:268\n1#2:271\n1#2:277\n1#2:280\n1#2:286\n1#2:289\n1#2:295\n1#2:298\n1#2:304\n1#2:307\n*S KotlinDebug\n*F\n+ 1 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n*L\n55#1:203,7\n55#1:211,3\n55#1:214,7\n55#1:221\n65#1:222,7\n65#1:230,3\n65#1:233,7\n65#1:240\n96#1:242,2\n96#1:245,5\n96#1:251,2\n96#1:254,5\n108#1:260,2\n108#1:263,5\n108#1:269,2\n108#1:272,5\n182#1:278,2\n182#1:281,5\n182#1:287,2\n182#1:290,5\n194#1:296,2\n194#1:299,5\n194#1:305,2\n194#1:308,5\n55#1:210\n65#1:229\n96#1:244\n96#1:253\n108#1:262\n108#1:271\n182#1:280\n182#1:289\n194#1:298\n194#1:307\n*E\n"})
/* loaded from: classes8.dex */
public final class oIX0oI {
    public static final void I0Io(@OOXIXo Activity activity, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        IIX0o.x0xO0oo(activity, "<this>");
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        attributes.alpha = f;
        activity.getWindow().setAttributes(attributes);
    }

    public static /* synthetic */ void II0XooXoX(Activity activity, Bundle bundle, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bundle = null;
        }
        if ((i2 & 2) != 0) {
            i = -1;
        }
        IIX0o.x0xO0oo(activity, "<this>");
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        Intent intent = new Intent(activity, (Class<?>) Activity.class);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (i > 0) {
            intent.setFlags(i);
        }
        activity.startActivity(intent);
    }

    public static final int II0xO0(@OOXIXo Fragment fragment, @OOXIXo String name, @OOXIXo String defType, @AnyRes int i) {
        IIX0o.x0xO0oo(fragment, "<this>");
        IIX0o.x0xO0oo(name, "name");
        IIX0o.x0xO0oo(defType, "defType");
        FragmentActivity activity = fragment.getActivity();
        if (activity != null) {
            return oIX0oI(activity, name, defType, i);
        }
        return i;
    }

    public static final /* synthetic */ <T extends Activity> void IIXOooo(Fragment fragment, int i, Bundle bundle, int i2) {
        IIX0o.x0xO0oo(fragment, "<this>");
        FragmentActivity activity = fragment.getActivity();
        IIX0o.ooOOo0oXI(activity);
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        Intent intent = new Intent(activity, (Class<?>) Activity.class);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (i2 > 0) {
            intent.setFlags(i2);
        }
        fragment.startActivityForResult(intent, i);
    }

    public static /* synthetic */ void IXxxXO(Activity activity, String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = -1;
        }
        x0xO0oo(activity, str, i, i2);
    }

    public static /* synthetic */ void O0xOxO(Fragment fragment, int i, Bundle bundle, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            bundle = null;
        }
        if ((i3 & 4) != 0) {
            i2 = -1;
        }
        IIX0o.x0xO0oo(fragment, "<this>");
        FragmentActivity activity = fragment.getActivity();
        IIX0o.ooOOo0oXI(activity);
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        Intent intent = new Intent(activity, (Class<?>) Activity.class);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (i2 > 0) {
            intent.setFlags(i2);
        }
        fragment.startActivityForResult(intent, i);
    }

    public static /* synthetic */ void OOXIXo(Fragment fragment, String str, Integer num, Parcelable parcelable, Serializable serializable, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            num = null;
        }
        if ((i2 & 4) != 0) {
            parcelable = null;
        }
        if ((i2 & 8) != 0) {
            serializable = null;
        }
        if ((i2 & 16) != 0) {
            i = -1;
        }
        IIX0o.x0xO0oo(fragment, "<this>");
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", str);
        if (num != null) {
            bundle.putInt("mArg1", num.intValue());
        }
        bundle.putParcelable("mArg2", parcelable);
        bundle.putSerializable("mArg3", serializable);
        FragmentActivity activity = fragment.getActivity();
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        Intent intent = new Intent(activity, (Class<?>) Activity.class);
        intent.putExtras(bundle);
        if (i > 0) {
            intent.setFlags(i);
        }
        fragment.startActivity(intent);
    }

    public static final void Oo(@OOXIXo Fragment fragment, @OOXIXo String action, int i, int i2) {
        IIX0o.x0xO0oo(fragment, "<this>");
        IIX0o.x0xO0oo(action, "action");
        Intent intent = new Intent(action);
        if (i2 > 0) {
            intent.setFlags(i2);
        }
        FragmentActivity activity = fragment.getActivity();
        IIX0o.ooOOo0oXI(activity);
        if (intent.resolveActivity(activity.getPackageManager()) != null) {
            fragment.startActivityForResult(intent, i);
        }
    }

    public static /* synthetic */ void OxI(Activity activity, int i, String str, Integer num, Parcelable parcelable, Serializable serializable, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = null;
        }
        if ((i3 & 4) != 0) {
            num = null;
        }
        if ((i3 & 8) != 0) {
            parcelable = null;
        }
        if ((i3 & 16) != 0) {
            serializable = null;
        }
        if ((i3 & 32) != 0) {
            i2 = -1;
        }
        IIX0o.x0xO0oo(activity, "<this>");
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", str);
        if (num != null) {
            bundle.putInt("mArg1", num.intValue());
        }
        bundle.putParcelable("mArg2", parcelable);
        bundle.putSerializable("mArg3", serializable);
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        Intent intent = new Intent(activity, (Class<?>) Activity.class);
        intent.putExtras(bundle);
        if (i2 > 0) {
            intent.setFlags(i2);
        }
        activity.startActivityForResult(intent, i);
    }

    public static final /* synthetic */ <T extends Activity> void Oxx0IOOO(Fragment fragment, String str, Integer num, Parcelable parcelable, Serializable serializable, int i) {
        IIX0o.x0xO0oo(fragment, "<this>");
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", str);
        if (num != null) {
            bundle.putInt("mArg1", num.intValue());
        }
        bundle.putParcelable("mArg2", parcelable);
        bundle.putSerializable("mArg3", serializable);
        FragmentActivity activity = fragment.getActivity();
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        Intent intent = new Intent(activity, (Class<?>) Activity.class);
        intent.putExtras(bundle);
        if (i > 0) {
            intent.setFlags(i);
        }
        fragment.startActivity(intent);
    }

    public static /* synthetic */ void Oxx0xo(Fragment fragment, String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = -1;
        }
        Oo(fragment, str, i, i2);
    }

    public static final /* synthetic */ <T extends Activity> void OxxIIOOXO(Activity activity, int i, String str, Integer num, Parcelable parcelable, Serializable serializable, int i2) {
        IIX0o.x0xO0oo(activity, "<this>");
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", str);
        if (num != null) {
            bundle.putInt("mArg1", num.intValue());
        }
        bundle.putParcelable("mArg2", parcelable);
        bundle.putSerializable("mArg3", serializable);
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        Intent intent = new Intent(activity, (Class<?>) Activity.class);
        intent.putExtras(bundle);
        if (i2 > 0) {
            intent.setFlags(i2);
        }
        activity.startActivityForResult(intent, i);
    }

    public static /* synthetic */ void X0IIOO(Fragment fragment, int i, String str, Integer num, Parcelable parcelable, Serializable serializable, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = null;
        }
        if ((i3 & 4) != 0) {
            num = null;
        }
        if ((i3 & 8) != 0) {
            parcelable = null;
        }
        if ((i3 & 16) != 0) {
            serializable = null;
        }
        if ((i3 & 32) != 0) {
            i2 = -1;
        }
        IIX0o.x0xO0oo(fragment, "<this>");
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", str);
        if (num != null) {
            bundle.putInt("mArg1", num.intValue());
        }
        bundle.putParcelable("mArg2", parcelable);
        bundle.putSerializable("mArg3", serializable);
        FragmentActivity activity = fragment.getActivity();
        IIX0o.ooOOo0oXI(activity);
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        Intent intent = new Intent(activity, (Class<?>) Activity.class);
        intent.putExtras(bundle);
        if (i2 > 0) {
            intent.setFlags(i2);
        }
        fragment.startActivityForResult(intent, i);
    }

    public static final /* synthetic */ <T extends Activity> void X0o0xo(Activity activity, String str, Integer num, Parcelable parcelable, Serializable serializable, int i) {
        IIX0o.x0xO0oo(activity, "<this>");
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", str);
        if (num != null) {
            bundle.putInt("mArg1", num.intValue());
        }
        bundle.putParcelable("mArg2", parcelable);
        bundle.putSerializable("mArg3", serializable);
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        Intent intent = new Intent(activity, (Class<?>) Activity.class);
        intent.putExtras(bundle);
        if (i > 0) {
            intent.setFlags(i);
        }
        activity.startActivity(intent);
    }

    public static final /* synthetic */ <T extends Activity> void XI0IXoo(Fragment fragment, int i, Bundle bundle, int i2) {
        IIX0o.x0xO0oo(fragment, "<this>");
        FragmentActivity activity = fragment.getActivity();
        IIX0o.ooOOo0oXI(activity);
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        Intent intent = new Intent(activity, (Class<?>) Activity.class);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (i2 > 0) {
            intent.setFlags(i2);
        }
        FragmentActivity activity2 = fragment.getActivity();
        IIX0o.ooOOo0oXI(activity2);
        activity2.startActivityForResult(intent, i);
    }

    public static /* synthetic */ void XIxXXX0x0(Fragment fragment, int i, Bundle bundle, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            bundle = null;
        }
        if ((i3 & 4) != 0) {
            i2 = -1;
        }
        IIX0o.x0xO0oo(fragment, "<this>");
        FragmentActivity activity = fragment.getActivity();
        IIX0o.ooOOo0oXI(activity);
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        Intent intent = new Intent(activity, (Class<?>) Activity.class);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (i2 > 0) {
            intent.setFlags(i2);
        }
        FragmentActivity activity2 = fragment.getActivity();
        IIX0o.ooOOo0oXI(activity2);
        activity2.startActivityForResult(intent, i);
    }

    public static final /* synthetic */ <T extends Activity> void XO(Fragment fragment, Bundle bundle, int i) {
        IIX0o.x0xO0oo(fragment, "<this>");
        FragmentActivity activity = fragment.getActivity();
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        Intent intent = new Intent(activity, (Class<?>) Activity.class);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (i > 0) {
            intent.setFlags(i);
        }
        fragment.startActivity(intent);
    }

    public static final void XxX0x0xxx(@OOXIXo Fragment fragment, @OOXIXo String url) {
        IIX0o.x0xO0oo(fragment, "<this>");
        IIX0o.x0xO0oo(url, "url");
        try {
            ooOOo0oXI(fragment, "android.intent.action.VIEW", url);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.e("Exception: %s", e.getMessage(), e);
            Bundle bundle = new Bundle();
            bundle.putString("mArg0", url);
            bundle.putParcelable("mArg2", null);
            bundle.putSerializable("mArg3", null);
            Intent intent = new Intent(fragment.getActivity(), (Class<?>) SimpleWebViewActivity.class);
            intent.putExtras(bundle);
            fragment.startActivity(intent);
        }
    }

    public static /* synthetic */ void o00(Activity activity, int i, Bundle bundle, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            bundle = null;
        }
        if ((i3 & 4) != 0) {
            i2 = -1;
        }
        IIX0o.x0xO0oo(activity, "<this>");
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        Intent intent = new Intent(activity, (Class<?>) Activity.class);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (i2 > 0) {
            intent.setFlags(i2);
        }
        activity.startActivityForResult(intent, i);
    }

    public static final /* synthetic */ <T extends Activity> void oI0IIXIo(Activity activity, int i, Bundle bundle, int i2) {
        IIX0o.x0xO0oo(activity, "<this>");
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        Intent intent = new Intent(activity, (Class<?>) Activity.class);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (i2 > 0) {
            intent.setFlags(i2);
        }
        activity.startActivityForResult(intent, i);
    }

    public static final int oIX0oI(@OOXIXo Activity activity, @OOXIXo String name, @OOXIXo String defType, @AnyRes int i) {
        IIX0o.x0xO0oo(activity, "<this>");
        IIX0o.x0xO0oo(name, "name");
        IIX0o.x0xO0oo(defType, "defType");
        try {
            int identifier = activity.getResources().getIdentifier(name, defType, activity.getPackageName());
            if (identifier != 0) {
                return identifier;
            }
            return i;
        } catch (Exception unused) {
            return i;
        }
    }

    public static /* synthetic */ void oO(Fragment fragment, String str, Object obj, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        ooOOo0oXI(fragment, str, obj);
    }

    public static final void oOoXoXO(@OOXIXo Activity activity, @OOXIXo String action, @oOoXoXO Object obj) {
        IIX0o.x0xO0oo(activity, "<this>");
        IIX0o.x0xO0oo(action, "action");
        Intent intent = new Intent(action);
        if (obj != null) {
            if (obj instanceof Uri) {
                intent.setData((Uri) obj);
            } else if (obj instanceof String) {
                intent.setData(Uri.parse((String) obj));
            }
        }
        activity.startActivity(Intent.createChooser(intent, null));
    }

    public static final void ooOOo0oXI(@OOXIXo Fragment fragment, @OOXIXo String action, @oOoXoXO Object obj) {
        IIX0o.x0xO0oo(fragment, "<this>");
        IIX0o.x0xO0oo(action, "action");
        Intent intent = new Intent(action);
        if (obj != null) {
            if (obj instanceof Uri) {
                intent.setData((Uri) obj);
            } else if (obj instanceof String) {
                intent.setData(Uri.parse((String) obj));
            }
        }
        fragment.startActivity(Intent.createChooser(intent, null));
    }

    public static final /* synthetic */ <T extends Activity> void oxoX(Activity activity, Bundle bundle, int i) {
        IIX0o.x0xO0oo(activity, "<this>");
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        Intent intent = new Intent(activity, (Class<?>) Activity.class);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (i > 0) {
            intent.setFlags(i);
        }
        activity.startActivity(intent);
    }

    public static /* synthetic */ void x0XOIxOo(Activity activity, String str, Object obj, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        oOoXoXO(activity, str, obj);
    }

    public static final void x0xO0oo(@OOXIXo Activity activity, @OOXIXo String action, int i, int i2) {
        IIX0o.x0xO0oo(activity, "<this>");
        IIX0o.x0xO0oo(action, "action");
        Intent intent = new Intent(action);
        if (i2 > 0) {
            intent.setFlags(i2);
        }
        if (intent.resolveActivity(activity.getPackageManager()) != null) {
            activity.startActivityForResult(intent, i);
        }
    }

    public static /* synthetic */ void xoIox(Fragment fragment, Bundle bundle, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bundle = null;
        }
        if ((i2 & 2) != 0) {
            i = -1;
        }
        IIX0o.x0xO0oo(fragment, "<this>");
        FragmentActivity activity = fragment.getActivity();
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        Intent intent = new Intent(activity, (Class<?>) Activity.class);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (i > 0) {
            intent.setFlags(i);
        }
        fragment.startActivity(intent);
    }

    public static final /* synthetic */ <T extends Activity> void xoXoI(Fragment fragment, int i, String str, Integer num, Parcelable parcelable, Serializable serializable, int i2) {
        IIX0o.x0xO0oo(fragment, "<this>");
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", str);
        if (num != null) {
            bundle.putInt("mArg1", num.intValue());
        }
        bundle.putParcelable("mArg2", parcelable);
        bundle.putSerializable("mArg3", serializable);
        FragmentActivity activity = fragment.getActivity();
        IIX0o.ooOOo0oXI(activity);
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        Intent intent = new Intent(activity, (Class<?>) Activity.class);
        intent.putExtras(bundle);
        if (i2 > 0) {
            intent.setFlags(i2);
        }
        fragment.startActivityForResult(intent, i);
    }

    public static /* synthetic */ void xxIXOIIO(Activity activity, String str, Integer num, Parcelable parcelable, Serializable serializable, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            num = null;
        }
        if ((i2 & 4) != 0) {
            parcelable = null;
        }
        if ((i2 & 8) != 0) {
            serializable = null;
        }
        if ((i2 & 16) != 0) {
            i = -1;
        }
        IIX0o.x0xO0oo(activity, "<this>");
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", str);
        if (num != null) {
            bundle.putInt("mArg1", num.intValue());
        }
        bundle.putParcelable("mArg2", parcelable);
        bundle.putSerializable("mArg3", serializable);
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        Intent intent = new Intent(activity, (Class<?>) Activity.class);
        intent.putExtras(bundle);
        if (i > 0) {
            intent.setFlags(i);
        }
        activity.startActivity(intent);
    }

    public static final void xxX(@OOXIXo Activity activity, @OOXIXo String url) {
        IIX0o.x0xO0oo(activity, "<this>");
        IIX0o.x0xO0oo(url, "url");
        try {
            oOoXoXO(activity, "android.intent.action.VIEW", url);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.e("Exception: %s", e.getMessage(), e);
            Bundle bundle = new Bundle();
            bundle.putString("mArg0", url);
            bundle.putParcelable("mArg2", null);
            bundle.putSerializable("mArg3", null);
            Intent intent = new Intent(activity, (Class<?>) SimpleWebViewActivity.class);
            intent.putExtras(bundle);
            activity.startActivity(intent);
        }
    }
}
