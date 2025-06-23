package xx0O;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import skin.support.widget.SkinCompatCardView;

/* loaded from: classes6.dex */
public class I0Io implements XO {
    @Override // xx0O.XO
    public View oIX0oI(@NonNull Context context, String str, @NonNull AttributeSet attributeSet) {
        str.hashCode();
        if (!str.equals("androidx.cardview.widget.CardView")) {
            return null;
        }
        return new SkinCompatCardView(context, attributeSet);
    }
}
