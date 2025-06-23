package skin.support.app;

import IIXOxIxOo.I0Io;
import OoxxX.II0xO0;
import OoxxX.oIX0oI;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.LayoutInflaterCompat;
import oIxOXo.II0XooXoX;
import oIxOXo.X0o0xo;
import xx0O.oxoX;

@Deprecated
/* loaded from: classes6.dex */
public class SkinCompatActivity extends AppCompatActivity implements II0xO0 {
    private oxoX mSkinDelegate;

    @NonNull
    public oxoX getSkinDelegate() {
        if (this.mSkinDelegate == null) {
            this.mSkinDelegate = oxoX.II0xO0(this);
        }
        return this.mSkinDelegate;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        LayoutInflaterCompat.setFactory2(getLayoutInflater(), getSkinDelegate());
        super.onCreate(bundle);
        updateStatusBarColor();
        updateWindowBackground();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        I0Io.IXxxXO().I0Io(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        I0Io.IXxxXO().oIX0oI(this);
    }

    @Override // OoxxX.II0xO0
    public void updateSkin(oIX0oI oix0oi, Object obj) {
        updateStatusBarColor();
        updateWindowBackground();
        getSkinDelegate().oIX0oI();
    }

    public void updateStatusBarColor() {
    }

    public void updateWindowBackground() {
        Drawable oIX0oI2;
        int II0XooXoX2 = X0o0xo.II0XooXoX(this);
        if (xxoXO.I0Io.II0xO0(II0XooXoX2) != 0 && (oIX0oI2 = II0XooXoX.oIX0oI(this, II0XooXoX2)) != null) {
            getWindow().setBackgroundDrawable(oIX0oI2);
        }
    }
}
