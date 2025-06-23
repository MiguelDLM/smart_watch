package com.sma.smartv3.ui.sport;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import com.baidu.mapapi.map.BaiduMap;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.ThreadUtils;
import com.garmin.fit.X0xOO;
import com.google.android.gms.maps.GoogleMap;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.pop.xx0X0;
import com.sma.smartv3.util.permission.PermissionHelper;
import kotlin.oXIO0o0XI;

/* loaded from: classes12.dex */
public final class DetailRouteCardFragment extends BaseDetailCardFragment {
    private boolean isGetSnapShot;

    @OXOo.oOoXoXO
    private xx0X0 mSelectAvatarPopup;

    @OXOo.OOXIXo
    private final String TAG = "DetailRouteCardFragment";

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mCameraBtn$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.sport.DetailRouteCardFragment$mCameraBtn$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            View mView;
            mView = DetailRouteCardFragment.this.getMView();
            return (ImageView) mView.findViewById(R.id.share_card_map_camera);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mRouteImgBg$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.sport.DetailRouteCardFragment$mRouteImgBg$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            View mView;
            mView = DetailRouteCardFragment.this.getMView();
            return (ImageView) mView.findViewById(R.id.share_card_route_image);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mRouteImg$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.sport.DetailRouteCardFragment$mRouteImg$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            View mView;
            mView = DetailRouteCardFragment.this.getMView();
            return (ImageView) mView.findViewById(R.id.share_card_route_image_figure);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mRouteDistanceLayout$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.sport.DetailRouteCardFragment$mRouteDistanceLayout$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            View mView;
            mView = DetailRouteCardFragment.this.getMView();
            return mView.findViewById(R.id.route_distance_ll);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mRouteBtnLayout$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<View>() { // from class: com.sma.smartv3.ui.sport.DetailRouteCardFragment$mRouteBtnLayout$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final View invoke() {
            View mView;
            mView = DetailRouteCardFragment.this.getMView();
            return mView.findViewById(R.id.sport_detail_share_card_route_btn_layout);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mCrop$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Xx000oIo.oxoX>() { // from class: com.sma.smartv3.ui.sport.DetailRouteCardFragment$mCrop$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.oOoXoXO
        public final Xx000oIo.oxoX invoke() {
            xx0X0 xx0x0;
            Context context = DetailRouteCardFragment.this.getContext();
            if (context == null) {
                return null;
            }
            DetailRouteCardFragment detailRouteCardFragment = DetailRouteCardFragment.this;
            xx0x0 = detailRouteCardFragment.mSelectAvatarPopup;
            ImageView mRouteImgBg = detailRouteCardFragment.getMRouteImgBg();
            kotlin.jvm.internal.IIX0o.oO(mRouteImgBg, "<get-mRouteImgBg>(...)");
            return com.sma.smartv3.util.II0xO0.oIX0oI(context, xx0x0, mRouteImgBg);
        }
    });

    public DetailRouteCardFragment() {
        setShowLineMarker(false);
        setGradient(false);
        setMMapLineColor(R.color.black);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convertWhiteToTransparent$lambda$5(DetailRouteCardFragment this$0, Bitmap result) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.x0xO0oo(result, "$result");
        this$0.getMRouteImg().setImageBitmap(result);
        this$0.goneMap();
    }

    private final ImageView getMCameraBtn() {
        return (ImageView) this.mCameraBtn$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Xx000oIo.oxoX getMCrop() {
        return (Xx000oIo.oxoX) this.mCrop$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSnapShot$lambda$1(final DetailRouteCardFragment this$0, final Bitmap bitmap) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.isGetSnapShot = true;
        xoIXOxX.II0xO0.I0Io(true, false, null, null, 0, new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.DetailRouteCardFragment$getSnapShot$1$1
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
                DetailRouteCardFragment detailRouteCardFragment = DetailRouteCardFragment.this;
                Bitmap it = bitmap;
                kotlin.jvm.internal.IIX0o.oO(it, "$it");
                detailRouteCardFragment.convertWhiteToTransparent(it);
            }
        }, 30, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSnapShot$lambda$3(final DetailRouteCardFragment this$0, final Bitmap bitmap) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        if (bitmap != null) {
            this$0.isGetSnapShot = true;
            xoIXOxX.II0xO0.I0Io(true, false, null, null, 0, new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.DetailRouteCardFragment$getSnapShot$2$1$1
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
                    DetailRouteCardFragment detailRouteCardFragment = DetailRouteCardFragment.this;
                    Bitmap it = bitmap;
                    kotlin.jvm.internal.IIX0o.oO(it, "$it");
                    detailRouteCardFragment.convertWhiteToTransparent(it);
                }
            }, 30, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(DetailRouteCardFragment this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.selectAvatar();
    }

    @OXOo.OOXIXo
    public final Bitmap convertWhiteToTransparent(@OXOo.OOXIXo Bitmap img) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(img, "img");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " convertWhiteToTransparent");
        int width = img.getWidth();
        int height = img.getHeight();
        final Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        kotlin.jvm.internal.IIX0o.oO(createBitmap, "createBitmap(...)");
        int i = width * height;
        int[] iArr = new int[i];
        img.getPixels(iArr, 0, width, 0, 0, width, height);
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = iArr[i2];
            int red = Color.red(i3);
            int green = Color.green(i3);
            int blue = Color.blue(i3);
            if (red > 235 && green > 235 && blue > 220) {
                iArr[i2] = 0;
            } else if (red < 50 && green < 235 && blue < 150) {
                iArr[i2] = -1;
            } else {
                iArr[i2] = 0;
            }
        }
        createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(this.TAG + " convertWhiteToTransparent OK");
        ThreadUtils.runOnUiThread(new Runnable() { // from class: com.sma.smartv3.ui.sport.OxI
            @Override // java.lang.Runnable
            public final void run() {
                DetailRouteCardFragment.convertWhiteToTransparent$lambda$5(DetailRouteCardFragment.this, createBitmap);
            }
        });
        return createBitmap;
    }

    public final View getMRouteBtnLayout() {
        return (View) this.mRouteBtnLayout$delegate.getValue();
    }

    public final View getMRouteDistanceLayout() {
        return (View) this.mRouteDistanceLayout$delegate.getValue();
    }

    public final ImageView getMRouteImg() {
        return (ImageView) this.mRouteImg$delegate.getValue();
    }

    public final ImageView getMRouteImgBg() {
        return (ImageView) this.mRouteImgBg$delegate.getValue();
    }

    public final void getSnapShot() {
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        oix0oi.oIX0oI(this.TAG + " getSnapShot");
        if (this.isGetSnapShot && !isLocationEmpty()) {
            return;
        }
        if (isInChinaMainland()) {
            getMBaiDuMap().snapshot(new BaiduMap.SnapshotReadyCallback() { // from class: com.sma.smartv3.ui.sport.O0xOxO
                @Override // com.baidu.mapapi.map.BaiduMap.SnapshotReadyCallback
                public final void onSnapshotReady(Bitmap bitmap) {
                    DetailRouteCardFragment.getSnapShot$lambda$1(DetailRouteCardFragment.this, bitmap);
                }
            });
            return;
        }
        oix0oi.oIX0oI(this.TAG + " mGoogleMap.snapshot");
        getMGoogleMap().snapshot(new GoogleMap.SnapshotReadyCallback() { // from class: com.sma.smartv3.ui.sport.X0IIOO
            @Override // com.google.android.gms.maps.GoogleMap.SnapshotReadyCallback
            public final void onSnapshotReady(Bitmap bitmap) {
                DetailRouteCardFragment.getSnapShot$lambda$3(DetailRouteCardFragment.this, bitmap);
            }
        });
    }

    @OXOo.OOXIXo
    public final String getTAG() {
        return this.TAG;
    }

    public final void goneMap() {
        if (isInChinaMainland()) {
            if (isLocationEmpty() && getMBMapView() != null) {
                getMBMapView().setVisibility(4);
                return;
            }
            return;
        }
        if (isLocationEmpty() && getMGMapView() != null) {
            getMGMapView().setVisibility(4);
        }
    }

    @Override // com.sma.smartv3.ui.sport.BaseDetailCardFragment, com.sma.smartv3.ui.sport.SportDetailMapFragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        getMRouteBtnLayout().setVisibility(8);
        getMCameraBtn().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.o00
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DetailRouteCardFragment.initView$lambda$0(DetailRouteCardFragment.this, view);
            }
        });
        if (ProductManager.IXX(ProductManager.f20544oIX0oI, getMWorkout().getMMode(), false, 2, null)) {
            getMRouteDistanceLayout().setVisibility(0);
        } else {
            getMRouteDistanceLayout().setVisibility(4);
        }
        Xx000oIo.oxoX mCrop = getMCrop();
        if (mCrop != null) {
            mCrop.oOoXoXO(this, new Oox.oOoXoXO<Uri, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.DetailRouteCardFragment$initView$2
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Uri uri) {
                    invoke2(uri);
                    return oXIO0o0XI.f29392oIX0oI;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@OXOo.OOXIXo Uri it) {
                    Xx000oIo.oxoX mCrop2;
                    kotlin.jvm.internal.IIX0o.x0xO0oo(it, "it");
                    mCrop2 = DetailRouteCardFragment.this.getMCrop();
                    if (mCrop2 != null) {
                        mCrop2.X0o0xo(it, 1.0d, 0.8d, 480, X0xOO.f13583O0o0);
                    }
                }
            });
        }
    }

    @Override // com.sma.smartv3.ui.sport.BaseDetailCardFragment, com.sma.smartv3.ui.sport.SportDetailMapFragment
    public void initializedMapFinish() {
        super.initializedMapFinish();
        if (isInChinaMainland()) {
            getMBaiDuMap().setMapType(3);
        } else {
            getMGoogleMap().setMapType(0);
        }
    }

    public final boolean isGetSnapShot() {
        return this.isGetSnapShot;
    }

    @Override // com.sma.smartv3.ui.sport.SportDetailMapFragment, com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.fragment_sport_detail_share_card_route;
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
            xx0x0.xI(new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.DetailRouteCardFragment$selectAvatar$1$1
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
                    final DetailRouteCardFragment detailRouteCardFragment = this;
                    permissionHelper.X0o0xo(Oxx0IOOO2, new Oox.oOoXoXO<Boolean, oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.DetailRouteCardFragment$selectAvatar$1$1.1
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
                            if (z) {
                                mCrop = DetailRouteCardFragment.this.getMCrop();
                                kotlin.jvm.internal.IIX0o.ooOOo0oXI(mCrop);
                                mCrop.I0Io();
                            }
                        }
                    });
                }
            });
            xx0x0.ooXIXxIX(new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.sma.smartv3.ui.sport.DetailRouteCardFragment$selectAvatar$1$2
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
                    mCrop = DetailRouteCardFragment.this.getMCrop();
                    kotlin.jvm.internal.IIX0o.ooOOo0oXI(mCrop);
                    mCrop.OOXIXo();
                }
            });
            this.mSelectAvatarPopup = xx0x0;
        }
        xx0X0 xx0x02 = this.mSelectAvatarPopup;
        if (xx0x02 != null) {
            xx0x02.IIXOooo();
        }
    }

    public final void setGetSnapShot(boolean z) {
        this.isGetSnapShot = z;
    }

    @Override // com.sma.smartv3.ui.sport.BaseDetailCardFragment
    public void shareImage() {
        Bitmap createBitmap = Bitmap.createBitmap(getShareCardView().getWidth(), getShareCardView().getHeight(), Bitmap.Config.ARGB_8888);
        kotlin.jvm.internal.IIX0o.oO(createBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(createBitmap);
        com.sma.smartv3.util.Oxx0IOOO oxx0IOOO = com.sma.smartv3.util.Oxx0IOOO.f24316oIX0oI;
        CardView shareCardView = getShareCardView();
        kotlin.jvm.internal.IIX0o.oO(shareCardView, "<get-shareCardView>(...)");
        canvas.drawBitmap(oxx0IOOO.II0xO0(shareCardView), 0.0f, 0.0f, (Paint) null);
        Bitmap roundCorner = ImageUtils.toRoundCorner(createBitmap, getMBitmapRadius());
        kotlin.jvm.internal.IIX0o.oO(roundCorner, "toRoundCorner(...)");
        ImageUtils.save(roundCorner, com.sma.smartv3.initializer.IXxxXO.xo0x(X00IoxXI.oIX0oI.f3233oIX0oI), Bitmap.CompressFormat.PNG);
        requireActivity().setResult(-1);
        requireActivity().finish();
    }
}
