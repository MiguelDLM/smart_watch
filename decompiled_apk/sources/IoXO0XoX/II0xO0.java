package IoXO0XoX;

import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IO;

/* loaded from: classes6.dex */
public final class II0xO0 {
    public static final /* synthetic */ <T extends Parcelable> Parcelable.Creator<T> oIX0oI() {
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        Parcelable.Creator<T> creator = null;
        Object obj = Parcelable.class.getDeclaredField("CREATOR").get(null);
        if (obj instanceof Parcelable.Creator) {
            creator = (Parcelable.Creator) obj;
        }
        if (creator != null) {
            return creator;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Could not access CREATOR field in class ");
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        sb.append(IO.oxoX(Parcelable.class).xoXoI());
        throw new IllegalArgumentException(sb.toString());
    }
}
