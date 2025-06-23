package com.sma.smartv3.ui.sport;

import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.CustomLatLng;
import java.util.ArrayList;

/* loaded from: classes12.dex */
public final class DetailMapCardFragment extends BaseDetailCardFragment {

    @OXOo.OOXIXo
    private final kotlin.X0IIOO showMapPoi$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageView>() { // from class: com.sma.smartv3.ui.sport.DetailMapCardFragment$showMapPoi$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageView invoke() {
            View mView;
            mView = DetailMapCardFragment.this.getMView();
            return (ImageView) mView.findViewById(R.id.share_card_map_showMapPoi);
        }
    });
    private boolean isShowMapPoi = true;

    public DetailMapCardFragment() {
        setMStartIcon(R.drawable.icon_sport_map_start_v2);
        setMCurrentIcon(R.drawable.icon_sport_map_end_v2);
        setEndMarkerAnchorCenter(false);
        setShowLineMarker(true);
        setMBaiduLineStart(null);
        setMBaiduLineEnd(null);
    }

    private final ImageView getShowMapPoi() {
        return (ImageView) this.showMapPoi$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(DetailMapCardFragment this$0, View view) {
        int i;
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        int i2 = 1;
        this$0.isShowMapPoi = !this$0.isShowMapPoi;
        if (this$0.isInChinaMainland()) {
            this$0.getMBaiDuMap().showMapPoi(this$0.isShowMapPoi);
        } else {
            GoogleMap mGoogleMap = this$0.getMGoogleMap();
            if (!this$0.isShowMapPoi) {
                i2 = 2;
            }
            mGoogleMap.setMapType(i2);
        }
        ImageView showMapPoi = this$0.getShowMapPoi();
        if (this$0.isShowMapPoi) {
            i = R.drawable.share_map_card_showpoi;
        } else {
            i = R.drawable.share_map_card_noshowpoi;
        }
        showMapPoi.setImageResource(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(DetailMapCardFragment this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(DetailMapCardFragment this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.onResume();
    }

    @Override // com.sma.smartv3.ui.sport.BaseDetailCardFragment, com.sma.smartv3.ui.sport.SportDetailMapFragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        getShowMapPoi().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.OxxIIOOXO
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DetailMapCardFragment.initView$lambda$0(DetailMapCardFragment.this, view);
            }
        });
        new Handler().postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.sport.IIXOooo
            @Override // java.lang.Runnable
            public final void run() {
                DetailMapCardFragment.initView$lambda$1(DetailMapCardFragment.this);
            }
        }, 250L);
        new Handler().postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.sport.xoXoI
            @Override // java.lang.Runnable
            public final void run() {
                DetailMapCardFragment.initView$lambda$2(DetailMapCardFragment.this);
            }
        }, 300L);
    }

    @Override // com.sma.smartv3.ui.sport.BaseDetailCardFragment, com.sma.smartv3.ui.sport.SportDetailMapFragment
    public void initializedMapFinish() {
        super.initializedMapFinish();
        if (!isInChinaMainland()) {
            getMGoogleMap().moveCamera(CameraUpdateFactory.zoomOut());
        }
    }

    public final boolean isShowMapPoi() {
        return this.isShowMapPoi;
    }

    @Override // com.sma.smartv3.ui.sport.SportDetailMapFragment, com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.fragment_sport_detail_share_card_map;
    }

    @Override // com.sma.smartv3.ui.sport.SportDetailMapFragment
    public void mapStatusBaiDuCenterPoint(@OXOo.OOXIXo ArrayList<CustomLatLng> locationList) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(locationList, "locationList");
        getMBaiDuMap().setMapStatus(com.sma.smartv3.util.I0Io.X0o0xo(locationList));
    }

    public final void setShowMapPoi(boolean z) {
        this.isShowMapPoi = z;
    }
}
