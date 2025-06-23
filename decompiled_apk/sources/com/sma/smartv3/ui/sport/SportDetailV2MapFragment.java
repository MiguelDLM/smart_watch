package com.sma.smartv3.ui.sport;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter;
import com.bestmafen.androidbase.adapter.recyclerview.base.ViewHolder;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.entity.Location;
import com.sma.smartv3.ui.me.WebViewActivity;
import com.sma.smartv3.ui.sport.SportDetailV2MapFragment;
import com.sma.smartv3.util.TextConvertKt;
import com.sma.smartv3.view.ImageViewRound;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@kotlin.jvm.internal.XX({"SMAP\nSportDetailV2MapFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SportDetailV2MapFragment.kt\ncom/sma/smartv3/ui/sport/SportDetailV2MapFragment\n+ 2 Activity.kt\ncom/bestmafen/androidbase/extension/ActivityKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,519:1\n185#2,7:520\n192#2,3:528\n154#2,7:531\n195#2:538\n99#2,7:539\n106#2,3:547\n79#2,7:550\n109#2:557\n99#2,7:559\n106#2,3:567\n79#2,7:570\n109#2:577\n99#2,7:578\n106#2,3:586\n79#2,7:589\n109#2:596\n1#3:527\n1#3:546\n1#3:558\n1#3:566\n1#3:585\n*S KotlinDebug\n*F\n+ 1 SportDetailV2MapFragment.kt\ncom/sma/smartv3/ui/sport/SportDetailV2MapFragment\n*L\n99#1:520,7\n99#1:528,3\n99#1:531,7\n99#1:538\n105#1:539,7\n105#1:547,3\n105#1:550,7\n105#1:557\n510#1:559,7\n510#1:567,3\n510#1:570,7\n510#1:577\n431#1:578,7\n431#1:586,3\n431#1:589,7\n431#1:596\n99#1:527\n105#1:546\n510#1:566\n431#1:585\n*E\n"})
/* loaded from: classes12.dex */
public final class SportDetailV2MapFragment extends SportDetailMapFragment {

    @OXOo.OOXIXo
    public static final oIX0oI Companion = new oIX0oI(null);

    @OXOo.OOXIXo
    public static final String TAG = "SportDetailV2MapFragment";

    @OXOo.oOoXoXO
    private Bitmap mChartBitmap;
    private long mEndTime;
    private long mStartTime;
    private int mWorkoutId;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO ivAvatar$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageViewRound>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2MapFragment$ivAvatar$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageViewRound invoke() {
            View mView;
            mView = SportDetailV2MapFragment.this.getMView();
            return (ImageViewRound) mView.findViewById(R.id.iv_avatar);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvNickname$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2MapFragment$tvNickname$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = SportDetailV2MapFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.edt_nickname);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvDetailname$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2MapFragment$tvDetailname$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = SportDetailV2MapFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.tv_detail_name);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvNoMapDetailname$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2MapFragment$tvNoMapDetailname$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = SportDetailV2MapFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.tv_detail_name_noMap);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvNoMapTime$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2MapFragment$tvNoMapTime$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = SportDetailV2MapFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.tv_dateTime_noMap);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvFieldExplanation$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2MapFragment$tvFieldExplanation$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = SportDetailV2MapFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.tv_view_field_explanation);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mapViewLayout$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<FrameLayout>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2MapFragment$mapViewLayout$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final FrameLayout invoke() {
            View mView;
            mView = SportDetailV2MapFragment.this.getMView();
            return (FrameLayout) mView.findViewById(R.id.mapView_layout);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO sportDetailProgressbarLayout$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2MapFragment$sportDetailProgressbarLayout$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            View mView;
            mView = SportDetailV2MapFragment.this.getMView();
            return mView.findViewById(R.id.sport_detail_progressbar_layout);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvAvatarV2Layout$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2MapFragment$tvAvatarV2Layout$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            View mView;
            mView = SportDetailV2MapFragment.this.getMView();
            return mView.findViewById(R.id.iv_avatar2_layout);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO ivAvatarV2$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageViewRound>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2MapFragment$ivAvatarV2$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageViewRound invoke() {
            View mView;
            mView = SportDetailV2MapFragment.this.getMView();
            return (ImageViewRound) mView.findViewById(R.id.iv_avatar2);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvNickNameV2$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2MapFragment$tvNickNameV2$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = SportDetailV2MapFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.edt_nickname2);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvAvatarV1Layout$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2MapFragment$tvAvatarV1Layout$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            View mView;
            mView = SportDetailV2MapFragment.this.getMView();
            return mView.findViewById(R.id.iv_avatar1_layout);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mRecyclerView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<RecyclerView>() { // from class: com.sma.smartv3.ui.sport.SportDetailV2MapFragment$mRecyclerView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final RecyclerView invoke() {
            View mView;
            mView = SportDetailV2MapFragment.this.getMView();
            return (RecyclerView) mView.findViewById(R.id.sport_detail_map_v2_recycler);
        }
    });
    private boolean mHaveMapBitmap = true;

    /* loaded from: classes12.dex */
    public static final class II0xO0 {

        /* renamed from: I0Io, reason: collision with root package name */
        @OXOo.OOXIXo
        public String f23817I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        @OXOo.OOXIXo
        public String f23818II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        @OXOo.OOXIXo
        public String f23819oIX0oI;

        public II0xO0() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ II0xO0 X0o0xo(II0xO0 iI0xO0, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = iI0xO0.f23819oIX0oI;
            }
            if ((i & 2) != 0) {
                str2 = iI0xO0.f23818II0xO0;
            }
            if ((i & 4) != 0) {
                str3 = iI0xO0.f23817I0Io;
            }
            return iI0xO0.oxoX(str, str2, str3);
        }

        @OXOo.OOXIXo
        public final String I0Io() {
            return this.f23817I0Io;
        }

        @OXOo.OOXIXo
        public final String II0XooXoX() {
            return this.f23817I0Io;
        }

        @OXOo.OOXIXo
        public final String II0xO0() {
            return this.f23818II0xO0;
        }

        public final void OOXIXo(@OXOo.OOXIXo String str) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
            this.f23817I0Io = str;
        }

        @OXOo.OOXIXo
        public final String Oxx0IOOO() {
            return this.f23819oIX0oI;
        }

        @OXOo.OOXIXo
        public final String XO() {
            return this.f23818II0xO0;
        }

        public boolean equals(@OXOo.oOoXoXO Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof II0xO0)) {
                return false;
            }
            II0xO0 iI0xO0 = (II0xO0) obj;
            return kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f23819oIX0oI, iI0xO0.f23819oIX0oI) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f23818II0xO0, iI0xO0.f23818II0xO0) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f23817I0Io, iI0xO0.f23817I0Io);
        }

        public int hashCode() {
            return (((this.f23819oIX0oI.hashCode() * 31) + this.f23818II0xO0.hashCode()) * 31) + this.f23817I0Io.hashCode();
        }

        @OXOo.OOXIXo
        public final String oIX0oI() {
            return this.f23819oIX0oI;
        }

        @OXOo.OOXIXo
        public final II0xO0 oxoX(@OXOo.OOXIXo String mState, @OXOo.OOXIXo String mContent, @OXOo.OOXIXo String mUnit) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(mState, "mState");
            kotlin.jvm.internal.IIX0o.x0xO0oo(mContent, "mContent");
            kotlin.jvm.internal.IIX0o.x0xO0oo(mUnit, "mUnit");
            return new II0xO0(mState, mContent, mUnit);
        }

        @OXOo.OOXIXo
        public String toString() {
            return "Item(mState=" + this.f23819oIX0oI + ", mContent=" + this.f23818II0xO0 + ", mUnit=" + this.f23817I0Io + HexStringBuilder.COMMENT_END_CHAR;
        }

        public final void xoIox(@OXOo.OOXIXo String str) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
            this.f23819oIX0oI = str;
        }

        public final void xxIXOIIO(@OXOo.OOXIXo String str) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
            this.f23818II0xO0 = str;
        }

        public II0xO0(@OXOo.OOXIXo String mState, @OXOo.OOXIXo String mContent, @OXOo.OOXIXo String mUnit) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(mState, "mState");
            kotlin.jvm.internal.IIX0o.x0xO0oo(mContent, "mContent");
            kotlin.jvm.internal.IIX0o.x0xO0oo(mUnit, "mUnit");
            this.f23819oIX0oI = mState;
            this.f23818II0xO0 = mContent;
            this.f23817I0Io = mUnit;
        }

        public /* synthetic */ II0xO0(String str, String str2, String str3, int i, kotlin.jvm.internal.IIXOooo iIXOooo) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
        }
    }

    /* loaded from: classes12.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        public oIX0oI() {
        }
    }

    public SportDetailV2MapFragment() {
        setMStartIcon(R.drawable.icon_sport_map_start_v2);
        setMCurrentIcon(R.drawable.icon_sport_map_end_v2);
        setEndMarkerAnchorCenter(false);
        setGradient(true);
        setMMapLineColor(R.color.sport_detail_bg_startColor);
    }

    private final void avatarShow() {
        getIvAvatar().setImageDrawable(oIxOXo.oxoX.Oxx0IOOO(getIvAvatar().getContext(), R.drawable.pic_avatar_default));
        getIvAvatarV2().setImageDrawable(oIxOXo.oxoX.Oxx0IOOO(getIvAvatar().getContext(), R.drawable.pic_avatar_default));
        X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
        if (com.sma.smartv3.initializer.IXxxXO.xxIXOIIO(oix0oi).exists()) {
            getIvAvatar().setImageURI(Uri.fromFile(com.sma.smartv3.initializer.IXxxXO.xxIXOIIO(oix0oi)));
            getIvAvatarV2().setImageURI(Uri.fromFile(com.sma.smartv3.initializer.IXxxXO.xxIXOIIO(oix0oi)));
        }
    }

    private final ImageViewRound getIvAvatar() {
        return (ImageViewRound) this.ivAvatar$delegate.getValue();
    }

    private final ImageViewRound getIvAvatarV2() {
        return (ImageViewRound) this.ivAvatarV2$delegate.getValue();
    }

    private final RecyclerView getMRecyclerView() {
        return (RecyclerView) this.mRecyclerView$delegate.getValue();
    }

    private final View getSportDetailProgressbarLayout() {
        return (View) this.sportDetailProgressbarLayout$delegate.getValue();
    }

    private final View getTvAvatarV1Layout() {
        return (View) this.tvAvatarV1Layout$delegate.getValue();
    }

    private final View getTvAvatarV2Layout() {
        return (View) this.tvAvatarV2Layout$delegate.getValue();
    }

    private final TextView getTvDetailname() {
        return (TextView) this.tvDetailname$delegate.getValue();
    }

    private final TextView getTvFieldExplanation() {
        return (TextView) this.tvFieldExplanation$delegate.getValue();
    }

    private final TextView getTvNickNameV2() {
        return (TextView) this.tvNickNameV2$delegate.getValue();
    }

    private final TextView getTvNickname() {
        return (TextView) this.tvNickname$delegate.getValue();
    }

    private final TextView getTvNoMapDetailname() {
        return (TextView) this.tvNoMapDetailname$delegate.getValue();
    }

    private final TextView getTvNoMapTime() {
        return (TextView) this.tvNoMapTime$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initList$lambda$1(SportDetailV2MapFragment this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", "https://api.iot-solution.net/web/help/gomer_help.html?type=3");
        bundle.putInt("mArg1", 2);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", null);
        Intent intent = new Intent(this$0.getActivity(), (Class<?>) WebViewActivity.class);
        intent.putExtras(bundle);
        this$0.startActivity(intent);
    }

    @OXOo.oOoXoXO
    public final Bitmap getMChartBitmap() {
        return this.mChartBitmap;
    }

    public final boolean getMHaveMapBitmap() {
        return this.mHaveMapBitmap;
    }

    public final int getMWorkoutId() {
        return this.mWorkoutId;
    }

    public final FrameLayout getMapViewLayout() {
        return (FrameLayout) this.mapViewLayout$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final String getTitle() {
        return ProductManager.f20544oIX0oI.xIXX(getMWorkout().getMMode());
    }

    @Override // com.sma.smartv3.ui.sport.SportDetailMapFragment, com.bestmafen.androidbase.base.BaseFragment, com.bestmafen.androidbase.base.oIX0oI
    public boolean initEvent() {
        return true;
    }

    @OXOo.OOXIXo
    public final List<II0xO0> initList() {
        String string;
        boolean z;
        boolean IOooo0o2;
        boolean OooO0XOx2;
        int i;
        int i2;
        int Xx000oIo2;
        int i3;
        String valueOf;
        int i4;
        String OI02;
        int i5;
        ArrayList arrayList = new ArrayList();
        if (getMWorkout().getMMode() == 116) {
            string = getString(R.string.game_time);
        } else {
            string = getString(R.string.exercise_time);
        }
        String str = string;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(str);
        arrayList.add(new II0xO0(str, com.sma.smartv3.util.xoIox.IoOoX(getMWorkout().getMDuration() * 1000), null, 4, null));
        if (getMWorkout().getMRestDuration() > 0 && getMWorkout().getMRestDuration() < getMWorkout().getMDuration()) {
            String string2 = getString(R.string.sport_detail_rest_time);
            kotlin.jvm.internal.IIX0o.oO(string2, "getString(...)");
            arrayList.add(new II0xO0(string2, com.sma.smartv3.util.xoIox.IoOoX(getMWorkout().getMRestDuration() * 1000), null, 4, null));
        }
        String string3 = getString(R.string.quantity_of_heat);
        kotlin.jvm.internal.IIX0o.oO(string3, "getString(...)");
        String valueOf2 = String.valueOf(getMWorkout().getMCalorie() / 1000);
        String string4 = getString(R.string.kcal);
        kotlin.jvm.internal.IIX0o.oO(string4, "getString(...)");
        arrayList.add(new II0xO0(string3, valueOf2, string4));
        com.sma.smartv3.util.XX0xXo xX0xXo = com.sma.smartv3.util.XX0xXo.f24343oIX0oI;
        if (xX0xXo.Oxx0xo(getMWorkout().getMPlatform())) {
            z = xX0xXo.oIX0oI(getMWorkout().getMMode());
        } else if (getMWorkout().getMType() == 1) {
            z = xX0xXo.oIX0oI(getMWorkout().getMMode());
        } else {
            ProductManager productManager = ProductManager.f20544oIX0oI;
            if (ProductManager.IXX(productManager, getMWorkout().getMMode(), false, 2, null) && !productManager.X00xOoXI(getMWorkout().getMMode())) {
                z = true;
            } else {
                z = false;
            }
        }
        String str2 = "-'--''";
        if (z) {
            if (getMWorkout().getMPace() == 0) {
                OI02 = "-'--''";
            } else {
                OI02 = TextConvertKt.OI0(getMWorkout().getMPace(), getUserProfile().getUnit());
            }
            String string5 = getString(R.string.avg_pace);
            kotlin.jvm.internal.IIX0o.oO(string5, "getString(...)");
            if (getUserProfile().getUnit() == 0) {
                i5 = R.string.pace_km;
            } else {
                i5 = R.string.pace_mi;
            }
            String string6 = getString(i5);
            kotlin.jvm.internal.IIX0o.oO(string6, "getString(...)");
            arrayList.add(new II0xO0(string5, OI02, string6));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("SportDetailV2MapFragment mType");
        sb.append(getMWorkout().getMType());
        sb.append(" mPlatform=");
        sb.append(getMWorkout().getMPlatform());
        sb.append("mMode=");
        sb.append(getMWorkout().getMMode());
        sb.append(TokenParser.SP);
        ProductManager productManager2 = ProductManager.f20544oIX0oI;
        sb.append(productManager2.xxx00());
        LogUtils.i(sb.toString());
        boolean oxoX2 = xX0xXo.oxoX(getMWorkout().getMMode(), getMWorkout().getMPlatform());
        String str3 = HelpFormatter.DEFAULT_LONG_OPT_PREFIX;
        if (oxoX2) {
            if (getMWorkout().getMSpeed() == 0) {
                valueOf = HelpFormatter.DEFAULT_LONG_OPT_PREFIX;
            } else {
                valueOf = String.valueOf(TextConvertKt.xo0x(getMWorkout().getMSpeed() / 1000.0d, getUserProfile().getUnit()));
            }
            LogUtils.i("SportDetailV2MapFragment speedToFloat" + valueOf + " unit=" + getUserProfile().getUnit());
            String string7 = getString(R.string.avg_speed);
            kotlin.jvm.internal.IIX0o.oO(string7, "getString(...)");
            if (getUserProfile().getUnit() == 0) {
                i4 = R.string.pace_km;
            } else {
                i4 = R.string.pace_mi;
            }
            String string8 = getString(i4);
            kotlin.jvm.internal.IIX0o.oO(string8, "getString(...)");
            arrayList.add(new II0xO0(string7, valueOf, string8));
        }
        String string9 = getString(R.string.ave_hr);
        kotlin.jvm.internal.IIX0o.oO(string9, "getString(...)");
        String valueOf3 = String.valueOf(getMWorkout().getMAvgBpm());
        String string10 = getString(R.string.ave_hr_unit);
        kotlin.jvm.internal.IIX0o.oO(string10, "getString(...)");
        arrayList.add(new II0xO0(string9, valueOf3, string10));
        if (xX0xXo.Oxx0xo(getMWorkout().getMPlatform())) {
            IOooo0o2 = xX0xXo.X0o0xo(getMWorkout().getMMode());
        } else if (getMWorkout().getMType() == 1) {
            IOooo0o2 = xX0xXo.x0xO0oo(getMWorkout().getMMode());
        } else {
            IOooo0o2 = productManager2.IOooo0o(getMWorkout().getMMode());
        }
        if (IOooo0o2) {
            String string11 = getString(R.string.stepnum);
            kotlin.jvm.internal.IIX0o.oO(string11, "getString(...)");
            String valueOf4 = String.valueOf(getMWorkout().getMStep());
            String string12 = getString(R.string.steps);
            kotlin.jvm.internal.IIX0o.oO(string12, "getString(...)");
            arrayList.add(new II0xO0(string11, valueOf4, string12));
        }
        if (getMWorkout().getMAirPressure() != 0) {
            String string13 = getString(R.string.air_pressure);
            kotlin.jvm.internal.IIX0o.oO(string13, "getString(...)");
            if (getUserProfile().getUnit() == 0) {
                Xx000oIo2 = getMWorkout().getMAirPressure();
            } else {
                Xx000oIo2 = (int) TextConvertKt.Xx000oIo(getMWorkout().getMAirPressure());
            }
            String valueOf5 = String.valueOf(Xx000oIo2);
            if (getUserProfile().getUnit() == 0) {
                i3 = R.string.kpa;
            } else {
                i3 = R.string.psi;
            }
            String string14 = getString(i3);
            kotlin.jvm.internal.IIX0o.oO(string14, "getString(...)");
            arrayList.add(new II0xO0(string13, valueOf5, string14));
        }
        if (xX0xXo.Oxx0xo(getMWorkout().getMPlatform())) {
            OooO0XOx2 = productManager2.X0O0I0(getMWorkout().getMMode());
        } else if (getMWorkout().getMType() == 1) {
            OooO0XOx2 = xX0xXo.oOoXoXO(getMWorkout().getMMode());
        } else {
            OooO0XOx2 = productManager2.OooO0XOx(getMWorkout().getMMode(), !isLocationEmpty());
        }
        if (OooO0XOx2) {
            String string15 = getString(R.string.avg_altitude);
            kotlin.jvm.internal.IIX0o.oO(string15, "getString(...)");
            String X00IoxXI2 = TextConvertKt.X00IoxXI(getMWorkout().getMAltitude(), getUserProfile().getUnit());
            if (getUserProfile().getUnit() == 0) {
                i2 = R.string.m;
            } else {
                i2 = R.string.yd;
            }
            String string16 = getString(i2);
            kotlin.jvm.internal.IIX0o.oO(string16, "getString(...)");
            arrayList.add(new II0xO0(string15, X00IoxXI2, string16));
        }
        if (getMWorkout().getMType() == 1) {
            if (xX0xXo.OOXIXo(getMWorkout().getMMode())) {
                String string17 = getString(R.string.lactic_acid_wide_value_heart_rate);
                kotlin.jvm.internal.IIX0o.oO(string17, "getString(...)");
                if (getMWorkout().getMLactateThresholdHr() != 0) {
                    str3 = String.valueOf(getMWorkout().getMLactateThresholdHr());
                }
                String string18 = getString(R.string.ave_hr_unit);
                kotlin.jvm.internal.IIX0o.oO(string18, "getString(...)");
                arrayList.add(new II0xO0(string17, str3, string18));
                if (getMWorkout().getMLactateThresholdPace() != 0) {
                    str2 = TextConvertKt.OI0(getMWorkout().getMPace(), getUserProfile().getUnit());
                }
                String string19 = getString(R.string.lavaic_acid_lapsee_packet);
                kotlin.jvm.internal.IIX0o.oO(string19, "getString(...)");
                if (getUserProfile().getUnit() == 0) {
                    i = R.string.pace_km;
                } else {
                    i = R.string.pace_mi;
                }
                String string20 = getString(i);
                kotlin.jvm.internal.IIX0o.oO(string20, "getString(...)");
                arrayList.add(new II0xO0(string19, str2, string20));
            }
            int mMode = getMWorkout().getMMode();
            if (mMode != 25) {
                if (mMode != 52) {
                    if (mMode == 55) {
                        String string21 = getString(R.string.total_dumbbell_reps);
                        kotlin.jvm.internal.IIX0o.oO(string21, "getString(...)");
                        String valueOf6 = String.valueOf(getMWorkout().getMCnt());
                        String string22 = getString(R.string.times_key);
                        kotlin.jvm.internal.IIX0o.oO(string22, "getString(...)");
                        arrayList.add(new II0xO0(string21, valueOf6, string22));
                    }
                } else {
                    String string23 = getString(R.string.total_strokes);
                    kotlin.jvm.internal.IIX0o.oO(string23, "getString(...)");
                    String valueOf7 = String.valueOf(getMWorkout().getMCnt());
                    String string24 = getString(R.string.times_key);
                    kotlin.jvm.internal.IIX0o.oO(string24, "getString(...)");
                    arrayList.add(new II0xO0(string23, valueOf7, string24));
                }
            } else {
                String string25 = getString(R.string.total_boxing_reps);
                kotlin.jvm.internal.IIX0o.oO(string25, "getString(...)");
                String valueOf8 = String.valueOf(getMWorkout().getMCnt());
                String string26 = getString(R.string.times_key);
                kotlin.jvm.internal.IIX0o.oO(string26, "getString(...)");
                arrayList.add(new II0xO0(string25, valueOf8, string26));
            }
            if (getMWorkout().getMMode() == 52) {
                String string27 = getString(R.string.avg_stroke_rate);
                kotlin.jvm.internal.IIX0o.oO(string27, "getString(...)");
                String valueOf9 = String.valueOf(getMWorkout().getMCadence());
                String string28 = getString(R.string.times_key);
                kotlin.jvm.internal.IIX0o.oO(string28, "getString(...)");
                arrayList.add(new II0xO0(string27, valueOf9, string28));
            } else if (xX0xXo.xoIox(getMWorkout().getMMode())) {
                String string29 = getString(R.string.avg_spm);
                kotlin.jvm.internal.IIX0o.oO(string29, "getString(...)");
                String valueOf10 = String.valueOf(getMWorkout().getMSpm());
                String string30 = getString(R.string.steps);
                kotlin.jvm.internal.IIX0o.oO(string30, "getString(...)");
                arrayList.add(new II0xO0(string29, valueOf10, string30));
            }
            String string31 = getString(R.string.metabolic_volume);
            kotlin.jvm.internal.IIX0o.oO(string31, "getString(...)");
            arrayList.add(new II0xO0(string31, String.valueOf(getMWorkout().getMMetTotal()), "METs"));
            getTvFieldExplanation().setVisibility(0);
            getTvFieldExplanation().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.XoX
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SportDetailV2MapFragment.initList$lambda$1(SportDetailV2MapFragment.this, view);
                }
            });
        }
        return arrayList;
    }

    @Override // com.sma.smartv3.ui.sport.SportDetailMapFragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        boolean IXX2;
        super.initView();
        LogUtils.i("SportDetailV2MapFragment initView}");
        getTvDateTime().setText(com.sma.smartv3.util.xoIox.oxxXoxO(false, false, 3, null).format(new Date(getMWorkout().getMStart())));
        XIo0oOXIx xIo0oOXIx = XIo0oOXIx.f23889oIX0oI;
        this.mStartTime = xIo0oOXIx.xxIXOIIO(getMWorkout().getMStart());
        this.mEndTime = xIo0oOXIx.xxIXOIIO(getMWorkout().getMEnd()) + 60000;
        getTvDetailname().setText(getTitle());
        getTvNickname().setText(getUserProfile().getNickname());
        getTvNickNameV2().setText(getUserProfile().getNickname());
        avatarShow();
        com.sma.smartv3.util.XX0xXo xX0xXo = com.sma.smartv3.util.XX0xXo.f24343oIX0oI;
        if (xX0xXo.Oxx0xo(getMWorkout().getMPlatform())) {
            IXX2 = ProductManager.f20544oIX0oI.o0oxo0oI(getMWorkout().getMMode());
        } else if (getMWorkout().getMType() == 1) {
            IXX2 = xX0xXo.ooOOo0oXI(getMWorkout().getMMode());
        } else {
            IXX2 = ProductManager.IXX(ProductManager.f20544oIX0oI, getMWorkout().getMMode(), false, 2, null);
        }
        if (IXX2) {
            getTvAvatarV1Layout().setVisibility(0);
            getTvAvatarV2Layout().setVisibility(8);
        } else {
            getTvAvatarV1Layout().setVisibility(8);
            getTvAvatarV2Layout().setVisibility(0);
        }
        getMRecyclerView().setLayoutManager(new GridLayoutManager(getActivity(), 2));
        final Context context = getContext();
        final List<II0xO0> initList = initList();
        getMRecyclerView().setAdapter(new CommonAdapter<II0xO0>(context, initList) { // from class: com.sma.smartv3.ui.sport.SportDetailV2MapFragment$initView$mRecyclerAdapter$1
            @Override // com.bestmafen.androidbase.adapter.recyclerview.CommonAdapter
            public void convert(@OXOo.OOXIXo ViewHolder viewHolder, @OXOo.OOXIXo SportDetailV2MapFragment.II0xO0 item, int i) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(viewHolder, "viewHolder");
                kotlin.jvm.internal.IIX0o.x0xO0oo(item, "item");
                viewHolder.setText(R.id.item_sport_detail_title, item.Oxx0IOOO());
                viewHolder.setText(R.id.item_sport_detail_content, item.XO());
                viewHolder.setText(R.id.item_sport_detail_unit, item.II0XooXoX());
            }
        });
    }

    @Override // com.sma.smartv3.ui.sport.SportDetailMapFragment
    public void initializedMapFinish() {
        if (!isInChinaMainland()) {
            getMGoogleMap().moveCamera(CameraUpdateFactory.zoomOut());
        }
    }

    @Override // com.sma.smartv3.ui.sport.SportDetailMapFragment, com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.fragment_sport_detail_map_v2;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @OXOo.oOoXoXO Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 3) {
            int mArg1 = getMArg1();
            Bundle bundle = new Bundle();
            bundle.putString("mArg0", "3");
            bundle.putInt("mArg1", mArg1);
            bundle.putParcelable("mArg2", null);
            bundle.putSerializable("mArg3", null);
            Intent intent2 = new Intent(getActivity(), (Class<?>) MapShareActivity.class);
            intent2.putExtras(bundle);
            startActivity(intent2);
        }
    }

    @Override // com.sma.smartv3.ui.sport.SportDetailMapFragment
    public void playTrack() {
        int mArg1 = getMArg1();
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", null);
        bundle.putInt("mArg1", mArg1);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", null);
        FragmentActivity activity = getActivity();
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(activity);
        Intent intent = new Intent(activity, (Class<?>) ShareVideoActivity.class);
        intent.putExtras(bundle);
        startActivityForResult(intent, 3);
    }

    public final void setChartFragmentBitmap(@OXOo.OOXIXo Bitmap chartBitmap, int i) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(chartBitmap, "chartBitmap");
        this.mChartBitmap = chartBitmap;
        this.mWorkoutId = i;
    }

    public final void setMChartBitmap(@OXOo.oOoXoXO Bitmap bitmap) {
        this.mChartBitmap = bitmap;
    }

    public final void setMHaveMapBitmap(boolean z) {
        this.mHaveMapBitmap = z;
    }

    public final void setMWorkoutId(int i) {
        this.mWorkoutId = i;
    }

    @Override // com.sma.smartv3.ui.sport.SportDetailMapFragment
    public void share(@OXOo.OOXIXo Bitmap topBitmap) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(topBitmap, "topBitmap");
        if (this.mHaveMapBitmap) {
            super.share(topBitmap);
        } else {
            shareMapBitmap(topBitmap, topBitmap);
        }
    }

    @Override // com.sma.smartv3.ui.sport.SportDetailMapFragment
    public void shareMapBitmap(@OXOo.OOXIXo Bitmap topBitmap, @OXOo.OOXIXo Bitmap mapBitmap) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(topBitmap, "topBitmap");
        kotlin.jvm.internal.IIX0o.x0xO0oo(mapBitmap, "mapBitmap");
        if (this.mChartBitmap == null) {
            super.shareMapBitmap(topBitmap, mapBitmap);
            return;
        }
        int width = getRootView().getWidth();
        int height = getRootView().getHeight();
        Bitmap bitmap = this.mChartBitmap;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(bitmap);
        Bitmap createBitmap = Bitmap.createBitmap(width, height + bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        kotlin.jvm.internal.IIX0o.oO(createBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(createBitmap);
        if (this.mHaveMapBitmap) {
            getMView().findViewById(R.id.check_layout).setVisibility(8);
            canvas.drawBitmap(mapBitmap, 0.0f, 0.0f, (Paint) null);
        }
        com.sma.smartv3.util.Oxx0IOOO oxx0IOOO = com.sma.smartv3.util.Oxx0IOOO.f24316oIX0oI;
        RelativeLayout rootView = getRootView();
        kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
        canvas.drawBitmap(oxx0IOOO.II0xO0(rootView), 0.0f, 0.0f, (Paint) null);
        Bitmap bitmap2 = this.mChartBitmap;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(bitmap2);
        canvas.drawBitmap(bitmap2, 0.0f, r8.getHeight(), (Paint) null);
        ImageUtils.save(createBitmap, com.sma.smartv3.initializer.IXxxXO.oxXx0IX(X00IoxXI.oIX0oI.f3233oIX0oI), Bitmap.CompressFormat.JPEG);
        String valueOf = String.valueOf(oOXoIIIo.I0Io.I0Io(isLocationEmpty()));
        int i = this.mWorkoutId;
        Bundle bundle = new Bundle();
        bundle.putString("mArg0", valueOf);
        bundle.putInt("mArg1", i);
        bundle.putParcelable("mArg2", null);
        bundle.putSerializable("mArg3", null);
        Intent intent = new Intent(getActivity(), (Class<?>) MapShareActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
        if (this.mHaveMapBitmap) {
            getMView().findViewById(R.id.check_layout).setVisibility(0);
        }
    }

    @Override // com.sma.smartv3.ui.sport.SportDetailMapFragment
    public void showMapLocation(@OXOo.OOXIXo List<Location> locationList) {
        int dp2px;
        int dp2px2;
        kotlin.jvm.internal.IIX0o.x0xO0oo(locationList, "locationList");
        ViewGroup.LayoutParams layoutParams = getRootView().getLayoutParams();
        LogUtils.d(TAG, "showMapLocation: " + locationList.size());
        if (!locationList.isEmpty() && locationList.size() >= 2) {
            super.showMapLocation(locationList);
            this.mHaveMapBitmap = true;
            if (getMWorkout().getMType() == 1) {
                dp2px2 = SizeUtils.dp2px(970.0f);
            } else {
                dp2px2 = SizeUtils.dp2px(870.0f);
            }
            layoutParams.height = dp2px2;
            getSportDetailProgressbarLayout().setVisibility(0);
        } else {
            getMapViewLayout().setBackgroundResource(R.drawable.sport_detail_map_v2_tap_bg);
            getMView().findViewById(R.id.check_layout).setVisibility(8);
            getBtnTrackPlay().setVisibility(4);
            this.mHaveMapBitmap = false;
            if (getMWorkout().getMType() == 1) {
                dp2px = SizeUtils.dp2px(700.0f);
            } else {
                dp2px = SizeUtils.dp2px(600.0f);
            }
            layoutParams.height = dp2px;
            getTvNoMapDetailname().setVisibility(0);
            getTvDetailname().setVisibility(8);
            getTvNoMapDetailname().setText(getTitle());
            getTvNoMapTime().setVisibility(0);
            getTvDateTime().setVisibility(8);
            getTvNoMapTime().setText(getTvDateTime().getText());
            getSportDetailProgressbarLayout().setVisibility(8);
        }
        getRootView().setLayoutParams(layoutParams);
    }
}
