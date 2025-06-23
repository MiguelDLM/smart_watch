package oIoxI0xx;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import skin.support.constraint.SkinCompatConstraintLayout;
import xx0O.XO;

/* loaded from: classes6.dex */
public class oIX0oI implements XO {
    @Override // xx0O.XO
    public View oIX0oI(Context context, String str, AttributeSet attributeSet) {
        str.hashCode();
        if (!str.equals("androidx.constraintlayout.widget.ConstraintLayout")) {
            return null;
        }
        return new SkinCompatConstraintLayout(context, attributeSet);
    }
}
