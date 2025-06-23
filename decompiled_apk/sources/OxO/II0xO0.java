package OxO;

import android.R;
import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

/* loaded from: classes12.dex */
public class II0xO0 {
    public static PopupWindow oIX0oI(@NonNull Context context, @NonNull View view) {
        PopupWindow popupWindow = new PopupWindow(context);
        popupWindow.setContentView(view);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setWidth(-2);
        popupWindow.setHeight(-2);
        popupWindow.setAnimationStyle(R.style.Animation.Dialog);
        popupWindow.setBackgroundDrawable(ContextCompat.getDrawable(context, com.sma.smartv3.co_fit.R.drawable.popup_window_transparent));
        return popupWindow;
    }
}
