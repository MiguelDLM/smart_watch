package me.zheteng.countrycodeselector;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import java.util.ArrayList;
import java.util.List;
import me.zheteng.countrycodeselector.CountryCodeSelectorFragment;

/* loaded from: classes6.dex */
public class PhoneInputView extends FrameLayout {

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static final String f30983O0xOxO = "me.zheteng.countrycodeselector.extra.Country";

    /* renamed from: OxI, reason: collision with root package name */
    public static final String f30984OxI = "me.zheteng.countrycodeselector.action.SendResult";

    /* renamed from: X0IIOO, reason: collision with root package name */
    public static final String f30985X0IIOO = "me.zheteng.countrycodeselector.extra.ThemeColor";

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public static final String f30986XI0IXoo = "me.zheteng.countrycodeselector.extra.Type";

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public static final int f30987XIxXXX0x0 = 0;

    /* renamed from: xxX, reason: collision with root package name */
    public static final int f30988xxX = 1;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public final View.OnClickListener f30989IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public EditText f30990IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public int f30991Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public EditText f30992Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public TextView f30993OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    public int f30994XO;

    /* renamed from: o00, reason: collision with root package name */
    public TextWatcher f30995o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public Context f30996oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public BroadcastReceiver f30997xoXoI;

    /* loaded from: classes6.dex */
    public class I0Io implements TextWatcher {
        public I0Io() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (charSequence.length() != 0) {
                Country XO2 = PhoneInputView.this.XO(charSequence.toString());
                if (XO2 != null) {
                    PhoneInputView.this.f30993OxxIIOOXO.setText(XO2.X0o0xo());
                    PhoneInputView.this.f30990IXxxXO.requestFocus();
                    return;
                } else {
                    PhoneInputView.this.f30993OxxIIOOXO.setText(R.string.ccs_invalid_country_code);
                    return;
                }
            }
            PhoneInputView.this.f30993OxxIIOOXO.setText(R.string.ccs_choose_a_country);
        }
    }

    /* loaded from: classes6.dex */
    public class II0xO0 extends BroadcastReceiver {
        public II0xO0() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Country country = (Country) intent.getParcelableExtra(PhoneInputView.f30983O0xOxO);
            PhoneInputView.this.f30993OxxIIOOXO.setText(country.X0o0xo());
            PhoneInputView.this.f30992Oxx0xo.setText(country.oIX0oI());
            PhoneInputView.this.f30990IXxxXO.requestFocus();
        }
    }

    /* loaded from: classes6.dex */
    public @interface X0o0xo {
    }

    /* loaded from: classes6.dex */
    public class oIX0oI implements View.OnClickListener {
        public oIX0oI() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == PhoneInputView.this.f30993OxxIIOOXO) {
                PhoneInputView.this.Oxx0IOOO();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class oxoX implements CountryCodeSelectorFragment.oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public final /* synthetic */ CountryCodeSelectorFragment f31002oIX0oI;

        public oxoX(CountryCodeSelectorFragment countryCodeSelectorFragment) {
            this.f31002oIX0oI = countryCodeSelectorFragment;
        }

        @Override // me.zheteng.countrycodeselector.CountryCodeSelectorFragment.oIX0oI
        public void oIX0oI(Country country) {
            this.f31002oIX0oI.dismiss();
        }
    }

    public PhoneInputView(Context context) {
        this(context, null);
    }

    public final void Oxx0IOOO() {
        int i = this.f30991Oo;
        if (i == 0) {
            Intent intent = new Intent(this.f30996oI0IIXIo, (Class<?>) CountryCodeSelectorActivity.class);
            intent.putExtra(f30985X0IIOO, this.f30994XO);
            intent.putExtra(f30986XI0IXoo, 0);
            this.f30996oI0IIXIo.startActivity(intent);
            return;
        }
        if (i == 1) {
            Context context = this.f30996oI0IIXIo;
            if (context instanceof FragmentActivity) {
                Intent intent2 = new Intent();
                intent2.putExtra(f30985X0IIOO, this.f30994XO);
                intent2.putExtra(f30986XI0IXoo, 1);
                CountryCodeSelectorFragment newInstance = CountryCodeSelectorFragment.newInstance(intent2);
                newInstance.show(((FragmentActivity) context).getSupportFragmentManager(), "COUNTRY_CODE_PICKER");
                newInstance.setOnCountrySelectListener(new oxoX(newInstance));
                return;
            }
            throw new IllegalStateException("Activity should be instance of FragmentActivity");
        }
    }

    public final Country XO(String str) {
        List<Country> oxoX2 = me.zheteng.countrycodeselector.II0xO0.oIX0oI(getContext()).oxoX(this.f30996oI0IIXIo);
        if (oxoX2 == null) {
            return null;
        }
        ArrayList<Country> arrayList = new ArrayList();
        for (Country country : oxoX2) {
            if (country.oIX0oI().equals(str)) {
                arrayList.add(country);
            }
        }
        if (arrayList.size() == 1) {
            return (Country) arrayList.get(0);
        }
        if (arrayList.size() == 0) {
            return null;
        }
        for (Country country2 : arrayList) {
            if (country2.II0XooXoX() != null) {
                return country2;
            }
        }
        return (Country) arrayList.get(0);
    }

    public String getCountryCode() {
        return this.f30992Oxx0xo.getText().toString();
    }

    public int getCountrySelectorType() {
        return this.f30991Oo;
    }

    public String getPhoneNumber() {
        return this.f30990IXxxXO.getText().toString();
    }

    @ColorInt
    public int getThemeColor() {
        return this.f30994XO;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        IntentFilter intentFilter = new IntentFilter(f30984OxI);
        if (Build.VERSION.SDK_INT >= 34) {
            ContextCompat.registerReceiver(this.f30996oI0IIXIo, this.f30997xoXoI, intentFilter, 2);
        } else {
            this.f30996oI0IIXIo.registerReceiver(this.f30997xoXoI, intentFilter);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f30996oI0IIXIo.unregisterReceiver(this.f30997xoXoI);
    }

    public void setCountryCode(@IntRange(from = 1, to = 999) int i) {
        this.f30992Oxx0xo.setText("" + i);
    }

    public void setCountrySelectorType(@X0o0xo int i) {
        this.f30991Oo = i;
    }

    public void setThemeColor(@ColorInt int i) {
        this.f30994XO = i;
    }

    public PhoneInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhoneInputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f30989IIXOooo = new oIX0oI();
        this.f30997xoXoI = new II0xO0();
        this.f30995o00 = new I0Io();
        this.f30996oI0IIXIo = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ccs_PhoneInputView, i, 0);
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(obtainStyledAttributes.getResourceId(R.styleable.ccs_PhoneInputView_ccs_layout, R.layout.ccs_phone_input_view), (ViewGroup) this, true);
        this.f30993OxxIIOOXO = (TextView) findViewById(R.id.select_country);
        this.f30992Oxx0xo = (EditText) findViewById(R.id.edit_country_code);
        this.f30990IXxxXO = (EditText) findViewById(R.id.edit_phone_number);
        this.f30994XO = obtainStyledAttributes.getColor(R.styleable.ccs_PhoneInputView_ccs_theme_color, ContextCompat.getColor(context, R.color.ccs_default_color));
        this.f30993OxxIIOOXO.getBackground().setColorFilter(this.f30994XO, PorterDuff.Mode.SRC_ATOP);
        for (Drawable drawable : this.f30993OxxIIOOXO.getCompoundDrawables()) {
            if (drawable != null) {
                drawable.setColorFilter(this.f30994XO, PorterDuff.Mode.SRC_ATOP);
            }
        }
        Drawable background = this.f30990IXxxXO.getBackground();
        int i2 = this.f30994XO;
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_ATOP;
        background.setColorFilter(i2, mode);
        this.f30992Oxx0xo.getBackground().setColorFilter(this.f30994XO, mode);
        this.f30991Oo = obtainStyledAttributes.getInt(R.styleable.ccs_PhoneInputView_ccs_country_selector_type, 0);
        this.f30993OxxIIOOXO.setOnClickListener(this.f30989IIXOooo);
        this.f30992Oxx0xo.addTextChangedListener(this.f30995o00);
        this.f30992Oxx0xo.setText("1");
        obtainStyledAttributes.recycle();
    }
}
