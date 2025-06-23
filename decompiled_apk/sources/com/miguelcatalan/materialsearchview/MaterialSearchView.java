package com.miguelcatalan.materialsearchview;

import IxIX0I.oIX0oI;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.lang.reflect.Field;

/* loaded from: classes11.dex */
public class MaterialSearchView extends FrameLayout implements Filter.FilterListener {

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public static final int f18521Xx000oIo = 9999;

    /* renamed from: IIX0o, reason: collision with root package name */
    public SavedState f18522IIX0o;

    /* renamed from: IIXOooo, reason: collision with root package name */
    public ListView f18523IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public int f18524IXxxXO;

    /* renamed from: IoOoX, reason: collision with root package name */
    public Context f18525IoOoX;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public ImageButton f18526O0xOxO;

    /* renamed from: Oo, reason: collision with root package name */
    public boolean f18527Oo;

    /* renamed from: OxI, reason: collision with root package name */
    public ImageButton f18528OxI;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public boolean f18529Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public View f18530OxxIIOOXO;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public RelativeLayout f18531X0IIOO;

    /* renamed from: XI0IXoo, reason: collision with root package name */
    public CharSequence f18532XI0IXoo;

    /* renamed from: XIxXXX0x0, reason: collision with root package name */
    public CharSequence f18533XIxXXX0x0;

    /* renamed from: XO, reason: collision with root package name */
    public MenuItem f18534XO;

    /* renamed from: XxX0x0xxx, reason: collision with root package name */
    public xxIXOIIO f18535XxX0x0xxx;

    /* renamed from: o00, reason: collision with root package name */
    public ImageButton f18536o00;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public View f18537oI0IIXIo;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public final View.OnClickListener f18538oOXoIIIo;

    /* renamed from: oo, reason: collision with root package name */
    public Drawable f18539oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public boolean f18540oo0xXOI0I;

    /* renamed from: ooXIXxIX, reason: collision with root package name */
    public boolean f18541ooXIXxIX;

    /* renamed from: xI, reason: collision with root package name */
    public boolean f18542xI;

    /* renamed from: xXxxox0I, reason: collision with root package name */
    public ListAdapter f18543xXxxox0I;

    /* renamed from: xoXoI, reason: collision with root package name */
    public EditText f18544xoXoI;

    /* renamed from: xxX, reason: collision with root package name */
    public II0XooXoX f18545xxX;

    /* loaded from: classes11.dex */
    public class I0Io implements View.OnFocusChangeListener {
        public I0Io() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (z) {
                MaterialSearchView materialSearchView = MaterialSearchView.this;
                materialSearchView.O0xOxO(materialSearchView.f18544xoXoI);
                MaterialSearchView.this.XIxXXX0x0();
            }
        }
    }

    /* loaded from: classes11.dex */
    public interface II0XooXoX {
        boolean onQueryTextChange(String str);

        boolean onQueryTextSubmit(String str);
    }

    /* loaded from: classes11.dex */
    public class II0xO0 implements TextWatcher {
        public II0xO0() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            MaterialSearchView.this.f18533XIxXXX0x0 = charSequence;
            MaterialSearchView.this.XxX0x0xxx(charSequence);
            MaterialSearchView.this.IIXOooo(charSequence);
        }
    }

    /* loaded from: classes11.dex */
    public class Oxx0IOOO implements oIX0oI.oxoX {
        public Oxx0IOOO() {
        }

        @Override // IxIX0I.oIX0oI.oxoX
        public boolean onAnimationCancel(View view) {
            return false;
        }

        @Override // IxIX0I.oIX0oI.oxoX
        public boolean onAnimationEnd(View view) {
            if (MaterialSearchView.this.f18535XxX0x0xxx != null) {
                MaterialSearchView.this.f18535XxX0x0xxx.II0xO0();
                return false;
            }
            return false;
        }

        @Override // IxIX0I.oIX0oI.oxoX
        public boolean onAnimationStart(View view) {
            return false;
        }
    }

    /* loaded from: classes11.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new oIX0oI();

        /* renamed from: Oo, reason: collision with root package name */
        public boolean f18549Oo;

        /* renamed from: XO, reason: collision with root package name */
        public String f18550XO;

        /* loaded from: classes11.dex */
        public static class oIX0oI implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: II0xO0, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        public /* synthetic */ SavedState(Parcel parcel, oIX0oI oix0oi) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f18550XO);
            parcel.writeInt(this.f18549Oo ? 1 : 0);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f18550XO = parcel.readString();
            this.f18549Oo = parcel.readInt() == 1;
        }
    }

    /* loaded from: classes11.dex */
    public class X0o0xo implements AdapterView.OnItemClickListener {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ com.miguelcatalan.materialsearchview.II0xO0 f18552XO;

        public X0o0xo(com.miguelcatalan.materialsearchview.II0xO0 iI0xO0) {
            this.f18552XO = iI0xO0;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            MaterialSearchView.this.o00((String) this.f18552XO.getItem(i), MaterialSearchView.this.f18541ooXIXxIX);
        }
    }

    /* loaded from: classes11.dex */
    public class XO implements MenuItem.OnMenuItemClickListener {
        public XO() {
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            MaterialSearchView.this.X0IIOO();
            return true;
        }
    }

    /* loaded from: classes11.dex */
    public class oIX0oI implements TextView.OnEditorActionListener {
        public oIX0oI() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            MaterialSearchView.this.OxxIIOOXO();
            return true;
        }
    }

    /* loaded from: classes11.dex */
    public class oxoX implements View.OnClickListener {
        public oxoX() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == MaterialSearchView.this.f18536o00) {
                MaterialSearchView.this.ooOOo0oXI();
                return;
            }
            if (view == MaterialSearchView.this.f18528OxI) {
                MaterialSearchView.this.xoXoI();
                return;
            }
            if (view == MaterialSearchView.this.f18526O0xOxO) {
                MaterialSearchView.this.f18544xoXoI.setText((CharSequence) null);
            } else if (view == MaterialSearchView.this.f18544xoXoI) {
                MaterialSearchView.this.XIxXXX0x0();
            } else if (view == MaterialSearchView.this.f18530OxxIIOOXO) {
                MaterialSearchView.this.ooOOo0oXI();
            }
        }
    }

    /* loaded from: classes11.dex */
    public interface xxIXOIIO {
        void II0xO0();

        void oIX0oI();
    }

    public MaterialSearchView(Context context) {
        this(context, null);
    }

    public final void IIXOooo(CharSequence charSequence) {
        Editable text = this.f18544xoXoI.getText();
        this.f18533XIxXXX0x0 = text;
        if (!TextUtils.isEmpty(text)) {
            this.f18526O0xOxO.setVisibility(0);
            xxX(false);
        } else {
            this.f18526O0xOxO.setVisibility(8);
            xxX(true);
        }
        if (this.f18545xxX != null && !TextUtils.equals(charSequence, this.f18532XI0IXoo)) {
            this.f18545xxX.onQueryTextChange(charSequence.toString());
        }
        this.f18532XI0IXoo = charSequence.toString();
    }

    public final void IXxxXO() {
        LayoutInflater.from(this.f18525IoOoX).inflate(R.layout.search_view, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.search_layout);
        this.f18537oI0IIXIo = findViewById;
        this.f18531X0IIOO = (RelativeLayout) findViewById.findViewById(R.id.search_top_bar);
        this.f18523IIXOooo = (ListView) this.f18537oI0IIXIo.findViewById(R.id.suggestion_list);
        this.f18544xoXoI = (EditText) this.f18537oI0IIXIo.findViewById(R.id.searchTextView);
        this.f18536o00 = (ImageButton) this.f18537oI0IIXIo.findViewById(R.id.action_up_btn);
        this.f18528OxI = (ImageButton) this.f18537oI0IIXIo.findViewById(R.id.action_voice_btn);
        this.f18526O0xOxO = (ImageButton) this.f18537oI0IIXIo.findViewById(R.id.action_empty_btn);
        this.f18530OxxIIOOXO = this.f18537oI0IIXIo.findViewById(R.id.transparent_view);
        this.f18544xoXoI.setOnClickListener(this.f18538oOXoIIIo);
        this.f18536o00.setOnClickListener(this.f18538oOXoIIIo);
        this.f18528OxI.setOnClickListener(this.f18538oOXoIIIo);
        this.f18526O0xOxO.setOnClickListener(this.f18538oOXoIIIo);
        this.f18530OxxIIOOXO.setOnClickListener(this.f18538oOXoIIIo);
        this.f18540oo0xXOI0I = false;
        xxX(true);
        x0xO0oo();
        this.f18523IIXOooo.setVisibility(8);
        setAnimationDuration(IxIX0I.oIX0oI.f1090II0xO0);
    }

    public void O0xOxO(View view) {
        view.requestFocus();
        ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
    }

    public final void Oo(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.f18525IoOoX.obtainStyledAttributes(attributeSet, R.styleable.MaterialSearchView, i, 0);
        if (obtainStyledAttributes != null) {
            int i2 = R.styleable.MaterialSearchView_searchBackground;
            if (obtainStyledAttributes.hasValue(i2)) {
                setBackground(obtainStyledAttributes.getDrawable(i2));
            }
            int i3 = R.styleable.MaterialSearchView_android_textColor;
            if (obtainStyledAttributes.hasValue(i3)) {
                setTextColor(obtainStyledAttributes.getColor(i3, 0));
            }
            int i4 = R.styleable.MaterialSearchView_android_textColorHint;
            if (obtainStyledAttributes.hasValue(i4)) {
                setHintTextColor(obtainStyledAttributes.getColor(i4, 0));
            }
            int i5 = R.styleable.MaterialSearchView_android_hint;
            if (obtainStyledAttributes.hasValue(i5)) {
                setHint(obtainStyledAttributes.getString(i5));
            }
            int i6 = R.styleable.MaterialSearchView_searchVoiceIcon;
            if (obtainStyledAttributes.hasValue(i6)) {
                setVoiceIcon(obtainStyledAttributes.getDrawable(i6));
            }
            int i7 = R.styleable.MaterialSearchView_searchCloseIcon;
            if (obtainStyledAttributes.hasValue(i7)) {
                setCloseIcon(obtainStyledAttributes.getDrawable(i7));
            }
            int i8 = R.styleable.MaterialSearchView_searchBackIcon;
            if (obtainStyledAttributes.hasValue(i8)) {
                setBackIcon(obtainStyledAttributes.getDrawable(i8));
            }
            int i9 = R.styleable.MaterialSearchView_searchSuggestionBackground;
            if (obtainStyledAttributes.hasValue(i9)) {
                setSuggestionBackground(obtainStyledAttributes.getDrawable(i9));
            }
            int i10 = R.styleable.MaterialSearchView_searchSuggestionIcon;
            if (obtainStyledAttributes.hasValue(i10)) {
                setSuggestionIcon(obtainStyledAttributes.getDrawable(i10));
            }
            obtainStyledAttributes.recycle();
        }
    }

    public final void OxI() {
        Oxx0IOOO oxx0IOOO = new Oxx0IOOO();
        this.f18537oI0IIXIo.setVisibility(0);
        IxIX0I.oIX0oI.xxIXOIIO(this.f18531X0IIOO, oxx0IOOO);
    }

    public boolean Oxx0xo() {
        return this.f18527Oo;
    }

    public final void OxxIIOOXO() {
        Editable text = this.f18544xoXoI.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            II0XooXoX iI0XooXoX = this.f18545xxX;
            if (iI0XooXoX == null || !iI0XooXoX.onQueryTextSubmit(text.toString())) {
                ooOOo0oXI();
                this.f18544xoXoI.setText((CharSequence) null);
            }
        }
    }

    public void X0IIOO() {
        XI0IXoo(true);
    }

    public void XI0IXoo(boolean z) {
        if (Oxx0xo()) {
            return;
        }
        this.f18544xoXoI.setText((CharSequence) null);
        this.f18544xoXoI.requestFocus();
        if (z) {
            OxI();
        } else {
            this.f18537oI0IIXIo.setVisibility(0);
            xxIXOIIO xxixoiio = this.f18535XxX0x0xxx;
            if (xxixoiio != null) {
                xxixoiio.II0xO0();
            }
        }
        this.f18527Oo = true;
    }

    public void XIxXXX0x0() {
        ListAdapter listAdapter = this.f18543xXxxox0I;
        if (listAdapter != null && listAdapter.getCount() > 0 && this.f18523IIXOooo.getVisibility() == 8) {
            this.f18523IIXOooo.setVisibility(0);
        }
    }

    public final void XxX0x0xxx(CharSequence charSequence) {
        ListAdapter listAdapter = this.f18543xXxxox0I;
        if (listAdapter != null && (listAdapter instanceof Filterable)) {
            ((Filterable) listAdapter).getFilter().filter(charSequence, this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.f18529Oxx0xo = true;
        oO(this);
        super.clearFocus();
        this.f18544xoXoI.clearFocus();
        this.f18529Oxx0xo = false;
    }

    public void o00(CharSequence charSequence, boolean z) {
        this.f18544xoXoI.setText(charSequence);
        if (charSequence != null) {
            EditText editText = this.f18544xoXoI;
            editText.setSelection(editText.length());
            this.f18533XIxXXX0x0 = charSequence;
        }
        if (z && !TextUtils.isEmpty(charSequence)) {
            OxxIIOOXO();
        }
    }

    public final boolean oI0IIXIo() {
        if (isInEditMode() || getContext().getPackageManager().queryIntentActivities(new Intent("android.speech.action.RECOGNIZE_SPEECH"), 0).size() == 0) {
            return true;
        }
        return false;
    }

    public void oO(View view) {
        ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    @Override // android.widget.Filter.FilterListener
    public void onFilterComplete(int i) {
        if (i > 0) {
            XIxXXX0x0();
        } else {
            x0XOIxOo();
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.f18522IIX0o = savedState;
        if (savedState.f18549Oo) {
            XI0IXoo(false);
            o00(this.f18522IIX0o.f18550XO, false);
        }
        super.onRestoreInstanceState(this.f18522IIX0o.getSuperState());
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        String str;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        this.f18522IIX0o = savedState;
        CharSequence charSequence = this.f18533XIxXXX0x0;
        if (charSequence != null) {
            str = charSequence.toString();
        } else {
            str = null;
        }
        savedState.f18550XO = str;
        SavedState savedState2 = this.f18522IIX0o;
        savedState2.f18549Oo = this.f18527Oo;
        return savedState2;
    }

    public void ooOOo0oXI() {
        if (!Oxx0xo()) {
            return;
        }
        this.f18544xoXoI.setText((CharSequence) null);
        x0XOIxOo();
        clearFocus();
        this.f18537oI0IIXIo.setVisibility(8);
        xxIXOIIO xxixoiio = this.f18535XxX0x0xxx;
        if (xxixoiio != null) {
            xxixoiio.oIX0oI();
        }
        this.f18527Oo = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i, Rect rect) {
        if (this.f18529Oxx0xo || !isFocusable()) {
            return false;
        }
        return this.f18544xoXoI.requestFocus(i, rect);
    }

    public void setAdapter(ListAdapter listAdapter) {
        this.f18543xXxxox0I = listAdapter;
        this.f18523IIXOooo.setAdapter(listAdapter);
        XxX0x0xxx(this.f18544xoXoI.getText());
    }

    public void setAnimationDuration(int i) {
        this.f18524IXxxXO = i;
    }

    public void setBackIcon(Drawable drawable) {
        this.f18536o00.setImageDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        this.f18531X0IIOO.setBackground(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.f18531X0IIOO.setBackgroundColor(i);
    }

    public void setCloseIcon(Drawable drawable) {
        this.f18526O0xOxO.setImageDrawable(drawable);
    }

    public void setCursorDrawable(int i) {
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(this.f18544xoXoI, Integer.valueOf(i));
        } catch (Exception e) {
            Log.e("MaterialSearchView", e.toString());
        }
    }

    public void setEllipsize(boolean z) {
        this.f18542xI = z;
    }

    public void setHint(CharSequence charSequence) {
        this.f18544xoXoI.setHint(charSequence);
    }

    public void setHintTextColor(int i) {
        this.f18544xoXoI.setHintTextColor(i);
    }

    public void setMenuItem(MenuItem menuItem) {
        this.f18534XO = menuItem;
        menuItem.setOnMenuItemClickListener(new XO());
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.f18523IIXOooo.setOnItemClickListener(onItemClickListener);
    }

    public void setOnQueryTextListener(II0XooXoX iI0XooXoX) {
        this.f18545xxX = iI0XooXoX;
    }

    public void setOnSearchViewListener(xxIXOIIO xxixoiio) {
        this.f18535XxX0x0xxx = xxixoiio;
    }

    public void setSubmitOnClick(boolean z) {
        this.f18541ooXIXxIX = z;
    }

    public void setSuggestionBackground(Drawable drawable) {
        this.f18523IIXOooo.setBackground(drawable);
    }

    public void setSuggestionIcon(Drawable drawable) {
        this.f18539oo = drawable;
    }

    public void setSuggestions(String[] strArr) {
        if (strArr != null && strArr.length > 0) {
            this.f18530OxxIIOOXO.setVisibility(0);
            com.miguelcatalan.materialsearchview.II0xO0 iI0xO0 = new com.miguelcatalan.materialsearchview.II0xO0(this.f18525IoOoX, strArr, this.f18539oo, this.f18542xI);
            setAdapter(iI0xO0);
            setOnItemClickListener(new X0o0xo(iI0xO0));
            return;
        }
        this.f18530OxxIIOOXO.setVisibility(8);
    }

    public void setTextColor(int i) {
        this.f18544xoXoI.setTextColor(i);
    }

    public void setVoiceIcon(Drawable drawable) {
        this.f18528OxI.setImageDrawable(drawable);
    }

    public void setVoiceSearch(boolean z) {
        this.f18540oo0xXOI0I = z;
    }

    public void x0XOIxOo() {
        if (this.f18523IIXOooo.getVisibility() == 0) {
            this.f18523IIXOooo.setVisibility(8);
        }
    }

    public final void x0xO0oo() {
        this.f18544xoXoI.setOnEditorActionListener(new oIX0oI());
        this.f18544xoXoI.addTextChangedListener(new II0xO0());
        this.f18544xoXoI.setOnFocusChangeListener(new I0Io());
    }

    public final void xoXoI() {
        Intent intent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        intent.putExtra("android.speech.extra.MAX_RESULTS", 1);
        Context context = this.f18525IoOoX;
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, f18521Xx000oIo);
        }
    }

    public void xxX(boolean z) {
        if (z && oI0IIXIo() && this.f18540oo0xXOI0I) {
            this.f18528OxI.setVisibility(0);
        } else {
            this.f18528OxI.setVisibility(8);
        }
    }

    public MaterialSearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaterialSearchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f18527Oo = false;
        this.f18541ooXIXxIX = false;
        this.f18542xI = false;
        this.f18538oOXoIIIo = new oxoX();
        this.f18525IoOoX = context;
        IXxxXO();
        Oo(attributeSet, i);
    }
}
