package oIxxIo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import skin.support.design.widget.SkinMaterialAppBarLayout;
import skin.support.design.widget.SkinMaterialBottomNavigationView;
import skin.support.design.widget.SkinMaterialCollapsingToolbarLayout;
import skin.support.design.widget.SkinMaterialCoordinatorLayout;
import skin.support.design.widget.SkinMaterialFloatingActionButton;
import skin.support.design.widget.SkinMaterialNavigationView;
import skin.support.design.widget.SkinMaterialTabLayout;
import skin.support.design.widget.SkinMaterialTextInputEditText;
import skin.support.design.widget.SkinMaterialTextInputLayout;
import xx0O.XO;

/* loaded from: classes6.dex */
public class oIX0oI implements XO {
    @Override // xx0O.XO
    public View oIX0oI(@NonNull Context context, String str, @NonNull AttributeSet attributeSet) {
        if ("androidx.coordinatorlayout.widget.CoordinatorLayout".equals(str)) {
            return new SkinMaterialCoordinatorLayout(context, attributeSet);
        }
        if (!str.startsWith("com.google.android.material.")) {
            return null;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -2119513329:
                if (str.equals("com.google.android.material.tabs.TabLayout")) {
                    c = 0;
                    break;
                }
                break;
            case -533274696:
                if (str.equals("com.google.android.material.appbar.AppBarLayout")) {
                    c = 1;
                    break;
                }
                break;
            case -204374977:
                if (str.equals("com.google.android.material.appbar.CollapsingToolbarLayout")) {
                    c = 2;
                    break;
                }
                break;
            case 391764942:
                if (str.equals("com.google.android.material.floatingactionbutton.FloatingActionButton")) {
                    c = 3;
                    break;
                }
                break;
            case 827811731:
                if (str.equals("com.google.android.material.navigation.NavigationView")) {
                    c = 4;
                    break;
                }
                break;
            case 1589750150:
                if (str.equals("com.google.android.material.textfield.TextInputLayout")) {
                    c = 5;
                    break;
                }
                break;
            case 1634834867:
                if (str.equals("com.google.android.material.textfield.TextInputEditText")) {
                    c = 6;
                    break;
                }
                break;
            case 1949496211:
                if (str.equals("com.google.android.material.bottomnavigation.BottomNavigationView")) {
                    c = 7;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return new SkinMaterialTabLayout(context, attributeSet);
            case 1:
                return new SkinMaterialAppBarLayout(context, attributeSet);
            case 2:
                return new SkinMaterialCollapsingToolbarLayout(context, attributeSet);
            case 3:
                return new SkinMaterialFloatingActionButton(context, attributeSet);
            case 4:
                return new SkinMaterialNavigationView(context, attributeSet);
            case 5:
                return new SkinMaterialTextInputLayout(context, attributeSet);
            case 6:
                return new SkinMaterialTextInputEditText(context, attributeSet);
            case 7:
                return new SkinMaterialBottomNavigationView(context, attributeSet);
            default:
                return null;
        }
    }
}
