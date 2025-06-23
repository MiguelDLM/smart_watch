package com.bestmafen.androidbase.base;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import oOXoIIIo.II0XooXoX;

/* loaded from: classes8.dex */
public abstract class BaseFragment extends Fragment implements com.bestmafen.androidbase.base.oIX0oI {

    @OOXIXo
    public static final oIX0oI Companion = new oIX0oI(null);
    protected Activity mActivity;

    @oOoXoXO
    private String mArg0;

    @oOoXoXO
    private Parcelable mArg2;

    @oOoXoXO
    private Serializable mArg3;
    protected View mView;
    private final int mTitleId = -1;
    private int mArg1 = -1;

    @XX({"SMAP\nBaseFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseFragment.kt\ncom/bestmafen/androidbase/base/BaseFragment$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,95:1\n75#1,3:97\n1#2:96\n*S KotlinDebug\n*F\n+ 1 BaseFragment.kt\ncom/bestmafen/androidbase/base/BaseFragment$Companion\n*L\n91#1:97,3\n*E\n"})
    /* loaded from: classes8.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(IIXOooo iIXOooo) {
            this();
        }

        public static /* synthetic */ BaseFragment I0Io(oIX0oI oix0oi, Bundle bundle, int i, Object obj) {
            if ((i & 1) != 0) {
                bundle = null;
            }
            IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
            BaseFragment baseFragment = (BaseFragment) BaseFragment.class.newInstance();
            baseFragment.setArguments(bundle);
            IIX0o.OxI(1, ExifInterface.GPS_DIRECTION_TRUE);
            return baseFragment;
        }

        public static /* synthetic */ BaseFragment oxoX(oIX0oI oix0oi, String str, Integer num, Parcelable parcelable, Serializable serializable, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                num = null;
            }
            if ((i & 4) != 0) {
                parcelable = null;
            }
            if ((i & 8) != 0) {
                serializable = null;
            }
            Bundle bundle = new Bundle();
            bundle.putString("mArg0", str);
            if (num != null) {
                bundle.putInt("mArg1", num.intValue());
            }
            bundle.putParcelable("mArg2", parcelable);
            bundle.putSerializable("mArg3", serializable);
            IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
            BaseFragment baseFragment = (BaseFragment) BaseFragment.class.newInstance();
            baseFragment.setArguments(bundle);
            IIX0o.OxI(1, ExifInterface.GPS_DIRECTION_TRUE);
            return baseFragment;
        }

        public final /* synthetic */ <T extends BaseFragment> T II0xO0(String str, Integer num, Parcelable parcelable, Serializable serializable) {
            Bundle bundle = new Bundle();
            bundle.putString("mArg0", str);
            if (num != null) {
                bundle.putInt("mArg1", num.intValue());
            }
            bundle.putParcelable("mArg2", parcelable);
            bundle.putSerializable("mArg3", serializable);
            IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
            T t = (T) BaseFragment.class.newInstance();
            t.setArguments(bundle);
            IIX0o.OxI(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t;
        }

        public final /* synthetic */ <T extends BaseFragment> T oIX0oI(Bundle bundle) {
            IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
            T t = (T) BaseFragment.class.newInstance();
            t.setArguments(bundle);
            IIX0o.OxI(1, ExifInterface.GPS_DIRECTION_TRUE);
            return t;
        }

        public oIX0oI() {
        }
    }

    @OOXIXo
    public final Activity getMActivity() {
        Activity activity = this.mActivity;
        if (activity != null) {
            return activity;
        }
        IIX0o.XOxIOxOx("mActivity");
        return null;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    @oOoXoXO
    public String getMArg0() {
        return this.mArg0;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int getMArg1() {
        return this.mArg1;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    @oOoXoXO
    public Parcelable getMArg2() {
        return this.mArg2;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    @oOoXoXO
    public Serializable getMArg3() {
        return this.mArg3;
    }

    public int getMTitleId() {
        return this.mTitleId;
    }

    @OOXIXo
    public final View getMView() {
        View view = this.mView;
        if (view != null) {
            return view;
        }
        IIX0o.XOxIOxOx("mView");
        return null;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public boolean initEvent() {
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        super.onAttach(context);
        FragmentActivity activity = getActivity();
        IIX0o.x0XOIxOo(activity, "null cannot be cast to non-null type android.app.Activity");
        setMActivity(activity);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@oOoXoXO Bundle bundle) {
        String str;
        Parcelable parcelable;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        Serializable serializable = null;
        if (arguments != null) {
            str = arguments.getString("mArg0");
        } else {
            str = null;
        }
        setMArg0(str);
        Bundle arguments2 = getArguments();
        int i = -1;
        if (arguments2 != null) {
            i = arguments2.getInt("mArg1", -1);
        }
        setMArg1(i);
        Bundle arguments3 = getArguments();
        if (arguments3 != null) {
            parcelable = arguments3.getParcelable("mArg2");
        } else {
            parcelable = null;
        }
        setMArg2(parcelable);
        Bundle arguments4 = getArguments();
        if (arguments4 != null) {
            serializable = arguments4.getSerializable("mArg3");
        }
        setMArg3(serializable);
        if (initEvent()) {
            XO0.II0xO0.oxoX().x0XOIxOo(this);
        }
        init(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    @oOoXoXO
    public View onCreateView(@OOXIXo LayoutInflater inflater, @oOoXoXO ViewGroup viewGroup, @oOoXoXO Bundle bundle) {
        View findViewById;
        IIX0o.x0xO0oo(inflater, "inflater");
        View inflate = inflater.inflate(layoutId(), viewGroup, false);
        IIX0o.oO(inflate, "inflate(...)");
        setMView(inflate);
        if (getMTitleId() != -1 && (findViewById = getMView().findViewById(getMTitleId())) != null) {
            II0XooXoX.oIX0oI(findViewById);
        }
        initView();
        return getMView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        if (initEvent()) {
            XO0.II0xO0.oxoX().IIXOooo(this);
        }
        super.onDestroy();
    }

    public final void setMActivity(@OOXIXo Activity activity) {
        IIX0o.x0xO0oo(activity, "<set-?>");
        this.mActivity = activity;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void setMArg0(@oOoXoXO String str) {
        this.mArg0 = str;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void setMArg1(int i) {
        this.mArg1 = i;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void setMArg2(@oOoXoXO Parcelable parcelable) {
        this.mArg2 = parcelable;
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void setMArg3(@oOoXoXO Serializable serializable) {
        this.mArg3 = serializable;
    }

    public final void setMView(@OOXIXo View view) {
        IIX0o.x0xO0oo(view, "<set-?>");
        this.mView = view;
    }
}
