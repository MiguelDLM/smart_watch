package com.sma.smartv3.ui.sport;

import Xx000oIo.oxoX;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.garmin.fit.X0xOO;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.pop.IXO;
import com.sma.smartv3.pop.xx0X0;
import com.sma.smartv3.util.TextConvertKt;
import com.sma.smartv3.util.permission.PermissionHelper;
import java.util.Random;
import kotlin.oXIO0o0XI;

/* loaded from: classes12.dex */
public final class DetailDataCardFragment extends DetailCaloriesCardFragment {

    @OXOo.oOoXoXO
    private IXO mEditPop;

    @OXOo.oOoXoXO
    private xx0X0 mSelectAvatarPopup;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mEditBtn$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.sport.DetailDataCardFragment$mEditBtn$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            View mView;
            mView = DetailDataCardFragment.this.getMView();
            return (ImageView) mView.findViewById(R.id.share_card_map_edit);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mCustomize$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.DetailDataCardFragment$mCustomize$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = DetailDataCardFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.share_card_customize_tv);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mCameraBtn$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.sport.DetailDataCardFragment$mCameraBtn$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            View mView;
            mView = DetailDataCardFragment.this.getMView();
            return (ImageView) mView.findViewById(R.id.share_card_map_camera);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mRlShareCard$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.sport.DetailDataCardFragment$mRlShareCard$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            View mView;
            mView = DetailDataCardFragment.this.getMView();
            return mView.findViewById(R.id.share_card_rl);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mRouteImg$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.sport.DetailDataCardFragment$mRouteImg$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            View mView;
            mView = DetailDataCardFragment.this.getMView();
            return (ImageView) mView.findViewById(R.id.share_card_route_image);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mRouteImgFigure$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.sport.DetailDataCardFragment$mRouteImgFigure$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            View mView;
            mView = DetailDataCardFragment.this.getMView();
            return (ImageView) mView.findViewById(R.id.share_card_route_image_figure);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvDistanceValue$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.DetailDataCardFragment$tvDistanceValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = DetailDataCardFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.tv_distance_value);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvDistanceUnit$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.DetailDataCardFragment$tvDistanceUnit$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = DetailDataCardFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.tv_distance_unit);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvDuration$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.DetailDataCardFragment$tvDuration$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = DetailDataCardFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.tv_duration);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvAvgPaceValue$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.DetailDataCardFragment$tvAvgPaceValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = DetailDataCardFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.tv_pace_value);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvAvgPaceValueLayout$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.sport.DetailDataCardFragment$tvAvgPaceValueLayout$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            View mView;
            mView = DetailDataCardFragment.this.getMView();
            return mView.findViewById(R.id.ll_pace_value);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mCrop$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Xx000oIo.oxoX>() { // from class: com.sma.smartv3.ui.sport.DetailDataCardFragment$mCrop$2

        /* loaded from: classes12.dex */
        public static final class oIX0oI implements oxoX.II0xO0 {

            /* renamed from: I0Io, reason: collision with root package name */
            public final /* synthetic */ DetailDataCardFragment f23773I0Io;

            /* renamed from: II0xO0, reason: collision with root package name */
            @OXOo.OOXIXo
            public final Uri f23774II0xO0;

            /* renamed from: oIX0oI, reason: collision with root package name */
            @OXOo.OOXIXo
            public final Uri f23775oIX0oI;

            /* renamed from: oxoX, reason: collision with root package name */
            public final /* synthetic */ Context f23776oxoX;

            public oIX0oI(DetailDataCardFragment detailDataCardFragment, Context context) {
                this.f23773I0Io = detailDataCardFragment;
                this.f23776oxoX = context;
                X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
                this.f23775oIX0oI = oix0oi.oxoX(com.sma.smartv3.initializer.IXxxXO.XIxXXX0x0(oix0oi));
                Uri fromFile = Uri.fromFile(com.sma.smartv3.initializer.IXxxXO.IO(oix0oi));
                kotlin.jvm.internal.IIX0o.oO(fromFile, "fromFile(...)");
                this.f23774II0xO0 = fromFile;
            }

            @Override // Xx000oIo.oxoX.II0xO0
            public void II0xO0(@OXOo.OOXIXo Uri uri) {
                xx0X0 xx0x0;
                ImageView mRouteImg;
                View mRlShareCard;
                ImageView mRouteImgFigure;
                kotlin.jvm.internal.IIX0o.x0xO0oo(uri, "uri");
                xx0x0 = this.f23773I0Io.mSelectAvatarPopup;
                if (xx0x0 != null) {
                    xx0x0.dismiss();
                }
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.f23776oxoX.getContentResolver(), uri);
                    DetailDataCardFragment detailDataCardFragment = this.f23773I0Io;
                    mRouteImg = detailDataCardFragment.getMRouteImg();
                    mRouteImg.setImageBitmap(bitmap);
                    mRlShareCard = detailDataCardFragment.getMRlShareCard();
                    mRlShareCard.setBackground(null);
                    mRouteImgFigure = detailDataCardFragment.getMRouteImgFigure();
                    mRouteImgFigure.setVisibility(8);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override // Xx000oIo.oxoX.II0xO0
            @OXOo.OOXIXo
            public Uri getResult() {
                return this.f23774II0xO0;
            }

            @Override // Xx000oIo.oxoX.II0xO0
            @OXOo.OOXIXo
            public Uri oIX0oI() {
                return this.f23775oIX0oI;
            }
        }

        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.oOoXoXO
        public final Xx000oIo.oxoX invoke() {
            Context context = DetailDataCardFragment.this.getContext();
            if (context != null) {
                return new Xx000oIo.oxoX(context, new oIX0oI(DetailDataCardFragment.this, context));
            }
            return null;
        }
    });

    private final ImageView getMCameraBtn() {
        return (ImageView) this.mCameraBtn$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Xx000oIo.oxoX getMCrop() {
        return (Xx000oIo.oxoX) this.mCrop$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView getMCustomize() {
        return (TextView) this.mCustomize$delegate.getValue();
    }

    private final ImageView getMEditBtn() {
        return (ImageView) this.mEditBtn$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View getMRlShareCard() {
        return (View) this.mRlShareCard$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView getMRouteImg() {
        return (ImageView) this.mRouteImg$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView getMRouteImgFigure() {
        return (ImageView) this.mRouteImgFigure$delegate.getValue();
    }

    private final TextView getTvAvgPaceValue() {
        return (TextView) this.tvAvgPaceValue$delegate.getValue();
    }

    private final View getTvAvgPaceValueLayout() {
        return (View) this.tvAvgPaceValueLayout$delegate.getValue();
    }

    private final TextView getTvDistanceUnit() {
        return (TextView) this.tvDistanceUnit$delegate.getValue();
    }

    private final TextView getTvDistanceValue() {
        return (TextView) this.tvDistanceValue$delegate.getValue();
    }

    private final TextView getTvDuration() {
        return (TextView) this.tvDuration$delegate.getValue();
    }

    public static /* synthetic */ void initCustomizeText$default(DetailDataCardFragment detailDataCardFragment, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        detailDataCardFragment.initCustomizeText(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(DetailDataCardFragment this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.showEditPop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(DetailDataCardFragment this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.selectAvatar();
    }

    private final void showEditPop() {
        if (this.mEditPop == null) {
            IXO ixo = new IXO(getMActivity(), 0, 2, null);
            ixo.ooXIXxIX().addTextChangedListener(new com.sma.smartv3.util.XO(60));
            ixo.ooXIXxIX().setTextColor(oIxOXo.oxoX.I0Io(ixo.Oxx0IOOO(), R.color.text_color_light));
            ixo.xII(new Oox.x0xO0oo<String, Integer, Boolean>() { // from class: com.sma.smartv3.ui.sport.DetailDataCardFragment$showEditPop$1$1
                {
                    super(2);
                }

                @Override // Oox.x0xO0oo
                public /* bridge */ /* synthetic */ Boolean invoke(String str, Integer num) {
                    return invoke(str, num.intValue());
                }

                @OXOo.OOXIXo
                public final Boolean invoke(@OXOo.OOXIXo String text, int i) {
                    TextView mCustomize;
                    TextView mCustomize2;
                    kotlin.jvm.internal.IIX0o.x0xO0oo(text, "text");
                    if (!TextUtils.isEmpty(text)) {
                        mCustomize = DetailDataCardFragment.this.getMCustomize();
                        mCustomize.setText(text);
                        mCustomize2 = DetailDataCardFragment.this.getMCustomize();
                        mCustomize2.setTextColor(i);
                    }
                    return Boolean.TRUE;
                }
            });
            this.mEditPop = ixo;
        }
        IXO ixo2 = this.mEditPop;
        if (ixo2 != null) {
            ixo2.X00IoxXI(getMCustomize().getText().toString());
        }
        IXO ixo3 = this.mEditPop;
        if (ixo3 != null) {
            ixo3.IIXOooo();
        }
    }

    public final void initCustomizeText(int i) {
        String string;
        TextView mCustomize = getMCustomize();
        if (i != 0) {
            if (i != 1) {
                string = getString(R.string.customize_content3);
            } else {
                string = getString(R.string.customize_content2);
            }
        } else {
            string = getString(R.string.customize_content1);
        }
        mCustomize.setText(string);
    }

    @Override // com.sma.smartv3.ui.sport.DetailCaloriesCardFragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        Xx000oIo.oxoX mCrop = getMCrop();
        if (mCrop != null) {
            Xx000oIo.oxoX.x0XOIxOo(mCrop, this, null, 2, null);
        }
        getMEditBtn().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.Oxx0xo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DetailDataCardFragment.initView$lambda$0(DetailDataCardFragment.this, view);
            }
        });
        if (getUserProfile().getGender() == 0) {
            getMRlShareCard().setBackgroundColor(Color.parseColor("#AA87CE"));
            getMRouteImgFigure().setImageResource(R.drawable.share_card_customize_woman_bg);
        }
        getMCameraBtn().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.oI0IIXIo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DetailDataCardFragment.initView$lambda$1(DetailDataCardFragment.this, view);
            }
        });
        ProductManager productManager = ProductManager.f20544oIX0oI;
        if (ProductManager.IXX(productManager, getMWorkout().getMMode(), false, 2, null)) {
            getTvDistanceValue().setText(String.valueOf(TextConvertKt.ooOOo0oXI(getMWorkout().getMDistance(), getUserProfile().getUnit(), false, 4, null)));
            getTvDistanceUnit().setText(getString(TextConvertKt.oI0IIXIo(getUserProfile().getUnit())));
        } else {
            getTvDistanceValue().setVisibility(4);
            getTvDistanceUnit().setVisibility(4);
        }
        getTvDuration().setText(com.sma.smartv3.util.xoIox.IoOoX(getMWorkout().getMDuration() * 1000));
        if (ProductManager.IXX(productManager, getMWorkout().getMMode(), false, 2, null)) {
            getTvAvgPaceValueLayout().setVisibility(0);
            getTvAvgPaceValue().setText(TextConvertKt.OI0(getMWorkout().getMPace(), getUserProfile().getUnit()));
        } else {
            getTvAvgPaceValueLayout().setVisibility(8);
        }
        initCustomizeText(new Random().nextInt(3));
    }

    @Override // com.sma.smartv3.ui.sport.DetailCaloriesCardFragment, com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.fragment_sport_detail_share_card_data;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @OXOo.oOoXoXO Intent intent) {
        super.onActivityResult(i, i2, intent);
        Xx000oIo.oxoX mCrop = getMCrop();
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(mCrop);
        mCrop.Oxx0IOOO(i, i2, intent, 1.0d, 0.8d, 480, X0xOO.f13583O0o0);
    }

    public final void selectAvatar() {
        if (this.mSelectAvatarPopup == null) {
            final xx0X0 xx0x0 = new xx0X0(getMActivity());
            xx0x0.xI(new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.DetailDataCardFragment$selectAvatar$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // Oox.oIX0oI
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
                    invoke2();
                    return oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    PermissionHelper permissionHelper = PermissionHelper.f24522oIX0oI;
                    Activity Oxx0IOOO2 = xx0X0.this.Oxx0IOOO();
                    final DetailDataCardFragment detailDataCardFragment = this;
                    permissionHelper.X0o0xo(Oxx0IOOO2, new Oox.oOoXoXO<Boolean, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.DetailDataCardFragment$selectAvatar$1$1.1
                        {
                            super(1);
                        }

                        @Override // Oox.oOoXoXO
                        public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return oXIO0o0XI.f29392oIX0oI;
                        }

                        public final void invoke(boolean z) {
                            Xx000oIo.oxoX mCrop;
                            mCrop = DetailDataCardFragment.this.getMCrop();
                            if (mCrop != null) {
                                mCrop.I0Io();
                            }
                        }
                    });
                }
            });
            xx0x0.ooXIXxIX(new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.DetailDataCardFragment$selectAvatar$1$2
                {
                    super(0);
                }

                @Override // Oox.oIX0oI
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
                    invoke2();
                    return oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Xx000oIo.oxoX mCrop;
                    mCrop = DetailDataCardFragment.this.getMCrop();
                    if (mCrop != null) {
                        mCrop.OOXIXo();
                    }
                }
            });
            this.mSelectAvatarPopup = xx0x0;
        }
        xx0X0 xx0x02 = this.mSelectAvatarPopup;
        if (xx0x02 != null) {
            xx0x02.IIXOooo();
        }
    }
}
