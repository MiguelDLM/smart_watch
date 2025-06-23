package OOxOI;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.content.Context;
import android.graphics.Typeface;
import com.sma.smartv3.view.text.MyTypeface;
import java.util.HashMap;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class oIX0oI {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public static final oIX0oI f1804oIX0oI = new oIX0oI();

    /* renamed from: II0xO0, reason: collision with root package name */
    @oOoXoXO
    public static final HashMap<String, Typeface> f1803II0xO0 = new HashMap<>();

    @oOoXoXO
    public final Typeface II0xO0(@OOXIXo String fontName, @OOXIXo Context context) {
        Typeface typeface;
        IIX0o.x0xO0oo(fontName, "fontName");
        IIX0o.x0xO0oo(context, "context");
        HashMap<String, Typeface> hashMap = f1803II0xO0;
        if (hashMap != null) {
            typeface = hashMap.get(fontName);
        } else {
            typeface = null;
        }
        if (typeface == null) {
            try {
                typeface = Typeface.createFromAsset(context.getAssets(), fontName);
                if (hashMap != null) {
                    hashMap.put(fontName, typeface);
                }
            } catch (Exception unused) {
            }
        }
        return typeface;
    }

    @oOoXoXO
    public final Typeface oIX0oI(@OOXIXo MyTypeface myTypeface, @OOXIXo Context context) {
        Typeface typeface;
        IIX0o.x0xO0oo(myTypeface, "myTypeface");
        IIX0o.x0xO0oo(context, "context");
        HashMap<String, Typeface> hashMap = f1803II0xO0;
        if (hashMap != null) {
            typeface = hashMap.get(myTypeface.getFontName());
        } else {
            typeface = null;
        }
        if (typeface == null) {
            try {
                typeface = Typeface.createFromAsset(context.getAssets(), myTypeface.getFontName());
                if (hashMap != null) {
                    hashMap.put(myTypeface.getFontName(), typeface);
                }
            } catch (Exception unused) {
            }
        }
        return typeface;
    }
}
