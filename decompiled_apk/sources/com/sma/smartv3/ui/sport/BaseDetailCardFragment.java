package com.sma.smartv3.ui.sport;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.blankj.utilcode.util.ImageUtils;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.util.TextConvertKt;
import com.sma.smartv3.view.ImageViewRound;

/* loaded from: classes12.dex */
public class BaseDetailCardFragment extends SportDetailMapFragment {

    @OXOo.OOXIXo
    private final kotlin.X0IIOO ivAvatar$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageViewRound>() { // from class: com.sma.smartv3.ui.sport.BaseDetailCardFragment$ivAvatar$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageViewRound invoke() {
            View mView;
            mView = BaseDetailCardFragment.this.getMView();
            return (ImageViewRound) mView.findViewById(R.id.iv_avatar);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvNickname$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.BaseDetailCardFragment$tvNickname$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = BaseDetailCardFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.edt_nickname);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvDetailname$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.BaseDetailCardFragment$tvDetailname$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = BaseDetailCardFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.tv_detail_name);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO paceValueLayout$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.sport.BaseDetailCardFragment$paceValueLayout$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            View mView;
            mView = BaseDetailCardFragment.this.getMView();
            return mView.findViewById(R.id.ll_pace_value);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvAvgPaceValue$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.BaseDetailCardFragment$tvAvgPaceValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = BaseDetailCardFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.tv_pace_value);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO btnShare$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Button>() { // from class: com.sma.smartv3.ui.sport.BaseDetailCardFragment$btnShare$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final Button invoke() {
            View mView;
            mView = BaseDetailCardFragment.this.getMView();
            return (Button) mView.findViewById(R.id.btn_share);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO shareCardView$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<CardView>() { // from class: com.sma.smartv3.ui.sport.BaseDetailCardFragment$shareCardView$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final CardView invoke() {
            View mView;
            mView = BaseDetailCardFragment.this.getMView();
            return (CardView) mView.findViewById(R.id.base_share_cardView);
        }
    });
    private final float mBitmapRadius = 30.0f;

    private final void avatarShow() {
        getIvAvatar().setImageDrawable(oIxOXo.oxoX.Oxx0IOOO(getIvAvatar().getContext(), R.drawable.pic_avatar_default));
        X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
        if (com.sma.smartv3.initializer.IXxxXO.xxIXOIIO(oix0oi).exists()) {
            getIvAvatar().setImageURI(Uri.fromFile(com.sma.smartv3.initializer.IXxxXO.xxIXOIIO(oix0oi)));
        }
    }

    private final ImageViewRound getIvAvatar() {
        return (ImageViewRound) this.ivAvatar$delegate.getValue();
    }

    private final View getPaceValueLayout() {
        return (View) this.paceValueLayout$delegate.getValue();
    }

    private final TextView getTvAvgPaceValue() {
        return (TextView) this.tvAvgPaceValue$delegate.getValue();
    }

    private final TextView getTvDetailname() {
        return (TextView) this.tvDetailname$delegate.getValue();
    }

    private final TextView getTvNickname() {
        return (TextView) this.tvNickname$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(BaseDetailCardFragment this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.shareImage();
    }

    private final void saveBitmap(Bitmap bitmap) {
        Bitmap createBitmap = Bitmap.createBitmap(getShareCardView().getWidth(), getShareCardView().getHeight(), Bitmap.Config.ARGB_8888);
        kotlin.jvm.internal.IIX0o.oO(createBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        com.sma.smartv3.util.Oxx0IOOO oxx0IOOO = com.sma.smartv3.util.Oxx0IOOO.f24316oIX0oI;
        CardView shareCardView = getShareCardView();
        kotlin.jvm.internal.IIX0o.oO(shareCardView, "<get-shareCardView>(...)");
        canvas.drawBitmap(oxx0IOOO.II0xO0(shareCardView), 0.0f, 0.0f, (Paint) null);
        Bitmap roundCorner = ImageUtils.toRoundCorner(createBitmap, this.mBitmapRadius);
        kotlin.jvm.internal.IIX0o.oO(roundCorner, "toRoundCorner(...)");
        ImageUtils.save(roundCorner, com.sma.smartv3.initializer.IXxxXO.xo0x(X00IoxXI.oIX0oI.f3233oIX0oI), Bitmap.CompressFormat.PNG);
        requireActivity().setResult(-1);
        requireActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void shareImage$lambda$3(BaseDetailCardFragment this$0, Bitmap bitmap) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(bitmap);
        this$0.saveBitmap(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void shareImage$lambda$4(BaseDetailCardFragment this$0, Bitmap bitmap) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(bitmap);
        this$0.saveBitmap(bitmap);
    }

    public final Button getBtnShare() {
        return (Button) this.btnShare$delegate.getValue();
    }

    public final float getMBitmapRadius() {
        return this.mBitmapRadius;
    }

    public final CardView getShareCardView() {
        return (CardView) this.shareCardView$delegate.getValue();
    }

    @OXOo.OOXIXo
    public final String getTitle() {
        return ProductManager.f20544oIX0oI.xIXX(getMWorkout().getMMode());
    }

    @Override // com.sma.smartv3.ui.sport.SportDetailMapFragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        getTvDetailname().setText(getTitle());
        getTvNickname().setText(getUserProfile().getNickname());
        avatarShow();
        if (ProductManager.IXX(ProductManager.f20544oIX0oI, getMWorkout().getMMode(), false, 2, null)) {
            getPaceValueLayout().setVisibility(0);
            getTvAvgPaceValue().setText(TextConvertKt.OI0(getMWorkout().getMPace(), getUserProfile().getUnit()));
        } else {
            getPaceValueLayout().setVisibility(4);
        }
        getBtnShare().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.I0Io
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseDetailCardFragment.initView$lambda$0(BaseDetailCardFragment.this, view);
            }
        });
    }

    @Override // com.sma.smartv3.ui.sport.SportDetailMapFragment
    public void initializedMapFinish() {
        if (isInChinaMainland()) {
            getMBaiDuMap().setMapStatus(MapStatusUpdateFactory.zoomOut());
            getMBaiDuMap().getUiSettings().setAllGesturesEnabled(false);
        } else {
            getMGoogleMap().moveCamera(CameraUpdateFactory.zoomOut());
            getMGoogleMap().getUiSettings().setAllGesturesEnabled(false);
        }
    }

    public void shareImage() {
        if (isInChinaMainland()) {
            getMBaiDuMap().snapshot(new BaiduMap.SnapshotReadyCallback() { // from class: com.sma.smartv3.ui.sport.oIX0oI
                @Override // com.baidu.mapapi.map.BaiduMap.SnapshotReadyCallback
                public final void onSnapshotReady(Bitmap bitmap) {
                    BaseDetailCardFragment.shareImage$lambda$3(BaseDetailCardFragment.this, bitmap);
                }
            });
        } else {
            getMGoogleMap().snapshot(new GoogleMap.SnapshotReadyCallback() { // from class: com.sma.smartv3.ui.sport.II0xO0
                @Override // com.google.android.gms.maps.GoogleMap.SnapshotReadyCallback
                public final void onSnapshotReady(Bitmap bitmap) {
                    BaseDetailCardFragment.shareImage$lambda$4(BaseDetailCardFragment.this, bitmap);
                }
            });
        }
    }
}
