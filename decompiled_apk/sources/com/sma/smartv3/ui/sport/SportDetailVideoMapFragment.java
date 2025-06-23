package com.sma.smartv3.ui.sport;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.blankj.utilcode.util.Utils;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.sma.smartv3.ble.ProductManager;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.db.MyDb;
import com.sma.smartv3.db.dao.HeartRateDao;
import com.sma.smartv3.db.entity.HeartRate;
import com.sma.smartv3.ui.sport.SportDetailVideoMapFragment;
import com.sma.smartv3.ui.sport.TrackPlay;
import com.sma.smartv3.util.video.VideoEncoder;
import com.sma.smartv3.view.ImageViewRound;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.oXIO0o0XI;

@kotlin.jvm.internal.XX({"SMAP\nSportDetailVideoMapFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SportDetailVideoMapFragment.kt\ncom/sma/smartv3/ui/sport/SportDetailVideoMapFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,613:1\n1864#2,3:614\n*S KotlinDebug\n*F\n+ 1 SportDetailVideoMapFragment.kt\ncom/sma/smartv3/ui/sport/SportDetailVideoMapFragment\n*L\n479#1:614,3\n*E\n"})
/* loaded from: classes12.dex */
public final class SportDetailVideoMapFragment extends SportDetailMapFragment implements com.sma.smartv3.util.video.oIX0oI<Bitmap> {
    private long mEndTime;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.I0X0x0oIo mLoadingPopup;
    private int mMaxSize;
    private long mStartTime;
    private int nextIndex;
    private boolean playEndJump;

    @OXOo.oOoXoXO
    private Bitmap rootBitmap;
    private float trackPlayProcess;
    private float videoProcess;
    private boolean videoStart;

    @OXOo.OOXIXo
    private final String TAG = "SportDetailVideoMapFragment";

    @OXOo.OOXIXo
    private final kotlin.X0IIOO ivAvatar$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<ImageViewRound>() { // from class: com.sma.smartv3.ui.sport.SportDetailVideoMapFragment$ivAvatar$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final ImageViewRound invoke() {
            View mView;
            mView = SportDetailVideoMapFragment.this.getMView();
            return (ImageViewRound) mView.findViewById(R.id.iv_avatar);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvNickname$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.SportDetailVideoMapFragment$tvNickname$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = SportDetailVideoMapFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.edt_nickname);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvDetailname$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.SportDetailVideoMapFragment$tvDetailname$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = SportDetailVideoMapFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.tv_detail_name);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO hrLineChart$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<LineChart>() { // from class: com.sma.smartv3.ui.sport.SportDetailVideoMapFragment$hrLineChart$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final LineChart invoke() {
            View mView;
            mView = SportDetailVideoMapFragment.this.getMView();
            return (LineChart) mView.findViewById(R.id.hrLineChart);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO mHeartRateDao$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<HeartRateDao>() { // from class: com.sma.smartv3.ui.sport.SportDetailVideoMapFragment$mHeartRateDao$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        @OXOo.OOXIXo
        public final HeartRateDao invoke() {
            return MyDb.INSTANCE.getMDatabase().heartRateDao();
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvAvgHrValue$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.sport.SportDetailVideoMapFragment$tvAvgHrValue$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            View mView;
            mView = SportDetailVideoMapFragment.this.getMView();
            return (TextView) mView.findViewById(R.id.tv_hr_value);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO btnSaveVideo$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Button>() { // from class: com.sma.smartv3.ui.sport.SportDetailVideoMapFragment$btnSaveVideo$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final Button invoke() {
            View mView;
            mView = SportDetailVideoMapFragment.this.getMView();
            return (Button) mView.findViewById(R.id.share_video_save_btn);
        }
    });

    @OXOo.OOXIXo
    private final List<Bitmap> mList = new ArrayList();

    @OXOo.OOXIXo
    private File mFile = new File(com.sma.smartv3.initializer.IXxxXO.XoX(X00IoxXI.oIX0oI.f3233oIX0oI), "mapVideo" + getMArg1() + '_' + Utils.getApp().getResources().getConfiguration().locale.getLanguage() + ".mp4");
    private int mFrameRate = 40;

    @OXOo.OOXIXo
    private TrackPlay mTrackPlay = new TrackPlay(new oIX0oI());

    /* loaded from: classes12.dex */
    public static final class oIX0oI implements TrackPlay.oIX0oI {
        public oIX0oI() {
        }

        public static final void II0XooXoX(SportDetailVideoMapFragment this$0) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            this$0.generateVideo(1.0f);
            this$0.setLoadingProcess();
        }

        public static final void Oxx0IOOO(SportDetailVideoMapFragment this$0) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
            this$0.generateVideo(1.0f);
            this$0.setLoadingProcess();
        }

        @Override // com.sma.smartv3.ui.sport.TrackPlay.oIX0oI
        public void I0Io(float f) {
        }

        @Override // com.sma.smartv3.ui.sport.TrackPlay.oIX0oI
        public void II0xO0() {
            SportDetailVideoMapFragment.this.getMColorList().clear();
            SportDetailVideoMapFragment.this.getMColorList().addAll(SportDetailVideoMapFragment.this.getMLineColors());
            SportDetailVideoMapFragment.this.addLine();
        }

        @Override // com.sma.smartv3.ui.sport.TrackPlay.oIX0oI
        public void oIX0oI(@OXOo.OOXIXo ArrayList<LatLng> points, float f) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(points, "points");
            if (points.size() > 1) {
                SportDetailVideoMapFragment.this.addGoogleLine(points);
            }
            if (f == 1.0f) {
                SportDetailVideoMapFragment.this.generateVideo(0.99f);
                SportDetailVideoMapFragment.this.getMGoogleMap().moveCamera(CameraUpdateFactory.zoomIn());
                SportDetailVideoMapFragment.this.getMGoogleMap().moveCamera(CameraUpdateFactory.zoomIn());
                Handler handler = new Handler(Looper.getMainLooper());
                final SportDetailVideoMapFragment sportDetailVideoMapFragment = SportDetailVideoMapFragment.this;
                handler.postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.sport.O0Xx
                    @Override // java.lang.Runnable
                    public final void run() {
                        SportDetailVideoMapFragment.oIX0oI.II0XooXoX(SportDetailVideoMapFragment.this);
                    }
                }, 200L);
            } else {
                SportDetailVideoMapFragment.this.generateVideo(f);
            }
            SportDetailVideoMapFragment.this.setLoadingProcess();
        }

        @Override // com.sma.smartv3.ui.sport.TrackPlay.oIX0oI
        public void onStart() {
            SportDetailVideoMapFragment.this.getMColorList().clear();
        }

        @Override // com.sma.smartv3.ui.sport.TrackPlay.oIX0oI
        public void oxoX(@OXOo.OOXIXo ArrayList<com.baidu.mapapi.model.LatLng> points, float f, int i) {
            kotlin.jvm.internal.IIX0o.x0xO0oo(points, "points");
            SportDetailVideoMapFragment.this.getMColorList().add(Integer.valueOf(i));
            if (points.size() > 1) {
                SportDetailVideoMapFragment.this.addBaiduLine(points);
            }
            if (f == 1.0f) {
                SportDetailVideoMapFragment.this.generateVideo(0.99f);
                SportDetailVideoMapFragment.this.getMBaiDuMap().animateMapStatus(MapStatusUpdateFactory.zoomIn(), 1000);
                Handler handler = new Handler(Looper.getMainLooper());
                final SportDetailVideoMapFragment sportDetailVideoMapFragment = SportDetailVideoMapFragment.this;
                handler.postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.sport.XoI0Ixx0
                    @Override // java.lang.Runnable
                    public final void run() {
                        SportDetailVideoMapFragment.oIX0oI.Oxx0IOOO(SportDetailVideoMapFragment.this);
                    }
                }, 200L);
            } else {
                SportDetailVideoMapFragment.this.generateVideo(f);
            }
            SportDetailVideoMapFragment.this.setLoadingProcess();
        }
    }

    public SportDetailVideoMapFragment() {
        setMStartIcon(R.drawable.icon_sport_map_start_v2);
        setMCurrentIcon(R.drawable.icon_sport_map_end_v2);
        setEndMarkerAnchorCenter(false);
        setGradient(isInChinaMainland());
        setMMapLineColor(R.color.sport_detail_bg_startColor);
    }

    private final void avatarShow() {
        getIvAvatar().setImageDrawable(oIxOXo.oxoX.Oxx0IOOO(getIvAvatar().getContext(), R.drawable.pic_avatar_default));
        X00IoxXI.oIX0oI oix0oi = X00IoxXI.oIX0oI.f3233oIX0oI;
        if (com.sma.smartv3.initializer.IXxxXO.xxIXOIIO(oix0oi).exists()) {
            getIvAvatar().setImageURI(Uri.fromFile(com.sma.smartv3.initializer.IXxxXO.xxIXOIIO(oix0oi)));
        }
    }

    private final void configChart(LineChart lineChart, int i, int i2) {
        long j = 1000;
        long j2 = 60;
        long j3 = ((this.mEndTime - this.mStartTime) / j) / j2;
        xxx00.oIX0oI oix0oi = xxx00.oIX0oI.f35574oIX0oI;
        oix0oi.II0xO0(lineChart);
        lineChart.setTouchEnabled(false);
        lineChart.getDescription().Oxx0IOOO(false);
        lineChart.getLegend().Oxx0IOOO(false);
        lineChart.getAxisLeft().I0oOIX(false);
        lineChart.getAxisLeft().Xo0(false);
        lineChart.getAxisLeft().XoI0Ixx0(false);
        lineChart.getAxisLeft().xXOx(i2);
        lineChart.getAxisLeft().I0X0x0oIo(i);
        lineChart.getAxisLeft().oxxXoxO(oIxOXo.oxoX.I0Io(getMActivity(), R.color.line_color));
        lineChart.getAxisLeft().II0XooXoX(oIxOXo.oxoX.I0Io(getMActivity(), R.color.line_color));
        lineChart.getAxisLeft().Ox0O(true);
        lineChart.getAxisRight().I0oOIX(false);
        lineChart.getAxisRight().Xo0(false);
        lineChart.getAxisRight().XoI0Ixx0(false);
        XAxis xAxis = lineChart.getXAxis();
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(xAxis);
        Context context = lineChart.getContext();
        kotlin.jvm.internal.IIX0o.oO(context, "getContext(...)");
        oix0oi.X0o0xo(xAxis, false, context);
        xAxis.I0X0x0oIo(0.0f);
        xAxis.OO(1.0f);
        xAxis.I0oOIX(false);
        xAxis.Xo0(false);
        xAxis.XoI0Ixx0(false);
        xAxis.xXOx((float) j3);
        SimpleDateFormat O0Xx2 = com.sma.smartv3.util.xoIox.O0Xx(false, 1, null);
        ArrayList arrayList = new ArrayList();
        long j4 = 0;
        if (0 <= j3) {
            while (true) {
                String millis2String = TimeUtils.millis2String(this.mStartTime + (j4 * j2 * j), O0Xx2);
                kotlin.jvm.internal.IIX0o.oO(millis2String, "millis2String(...)");
                arrayList.add(millis2String);
                if (j4 == j3) {
                    break;
                } else {
                    j4++;
                }
            }
        }
        xAxis.o0xxxXXxX(new ox.oOoXoXO(arrayList));
    }

    private final void dismissLoadPopup() {
        com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo = this.mLoadingPopup;
        if (i0X0x0oIo != null) {
            i0X0x0oIo.dismiss();
        }
        this.mLoadingPopup = null;
    }

    public static /* synthetic */ void generateVideo$default(SportDetailVideoMapFragment sportDetailVideoMapFragment, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        sportDetailVideoMapFragment.generateVideo(f);
    }

    private final Button getBtnSaveVideo() {
        return (Button) this.btnSaveVideo$delegate.getValue();
    }

    private final LineChart getHrLineChart() {
        return (LineChart) this.hrLineChart$delegate.getValue();
    }

    private final ImageViewRound getIvAvatar() {
        return (ImageViewRound) this.ivAvatar$delegate.getValue();
    }

    private final HeartRateDao getMHeartRateDao() {
        return (HeartRateDao) this.mHeartRateDao$delegate.getValue();
    }

    private final TextView getTvAvgHrValue() {
        return (TextView) this.tvAvgHrValue$delegate.getValue();
    }

    private final TextView getTvDetailname() {
        return (TextView) this.tvDetailname$delegate.getValue();
    }

    private final TextView getTvNickname() {
        return (TextView) this.tvNickname$delegate.getValue();
    }

    private final void initCanvasImage(Bitmap bitmap, float f) {
        Bitmap createBitmap = Bitmap.createBitmap(getRootView().getWidth(), getRootView().getHeight(), Bitmap.Config.ARGB_8888);
        kotlin.jvm.internal.IIX0o.oO(createBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        if (this.rootBitmap == null) {
            com.sma.smartv3.util.Oxx0IOOO oxx0IOOO = com.sma.smartv3.util.Oxx0IOOO.f24316oIX0oI;
            RelativeLayout rootView = getRootView();
            kotlin.jvm.internal.IIX0o.oO(rootView, "<get-rootView>(...)");
            this.rootBitmap = oxx0IOOO.II0xO0(rootView);
        }
        Bitmap bitmap2 = this.rootBitmap;
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(bitmap2);
        canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
        this.mMaxSize++;
        this.mList.add(createBitmap);
        if (f == 1.0f) {
            ImageUtils.save(createBitmap, com.sma.smartv3.initializer.IXxxXO.oxXx0IX(X00IoxXI.oIX0oI.f3233oIX0oI), Bitmap.CompressFormat.JPEG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(final SportDetailVideoMapFragment this$0, View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        if (!this$0.mFile.exists()) {
            this$0.getBtnTrackPlay().setVisibility(8);
            this$0.playEndJump = true;
            this$0.playTrack();
        } else {
            this$0.getBtnSaveVideo().setVisibility(8);
            this$0.getBtnTrackPlay().setVisibility(8);
            this$0.getBtnTrackPlay().post(new Runnable() { // from class: com.sma.smartv3.ui.sport.Xo0
                @Override // java.lang.Runnable
                public final void run() {
                    SportDetailVideoMapFragment.initView$lambda$3$lambda$2(SportDetailVideoMapFragment.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3$lambda$2(SportDetailVideoMapFragment this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.mapSnapShot(1.0f);
        oXIO0o0XI oxio0o0xi = oXIO0o0XI.f29392oIX0oI;
        this$0.requireActivity().setResult(-1);
        this$0.requireActivity().finish();
    }

    private final void mapSnapShot(final float f) {
        try {
            if (isInChinaMainland()) {
                getMBaiDuMap().snapshot(new BaiduMap.SnapshotReadyCallback() { // from class: com.sma.smartv3.ui.sport.oxXx0IX
                    @Override // com.baidu.mapapi.map.BaiduMap.SnapshotReadyCallback
                    public final void onSnapshotReady(Bitmap bitmap) {
                        SportDetailVideoMapFragment.mapSnapShot$lambda$5(SportDetailVideoMapFragment.this, f, bitmap);
                    }
                });
            } else {
                getMGoogleMap().snapshot(new GoogleMap.SnapshotReadyCallback() { // from class: com.sma.smartv3.ui.sport.xo0x
                    @Override // com.google.android.gms.maps.GoogleMap.SnapshotReadyCallback
                    public final void onSnapshotReady(Bitmap bitmap) {
                        SportDetailVideoMapFragment.mapSnapShot$lambda$7(SportDetailVideoMapFragment.this, f, bitmap);
                    }
                });
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mapSnapShot$lambda$5(SportDetailVideoMapFragment this$0, float f, Bitmap bitmap) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        kotlin.jvm.internal.IIX0o.ooOOo0oXI(bitmap);
        this$0.initCanvasImage(bitmap, f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mapSnapShot$lambda$7(SportDetailVideoMapFragment this$0, float f, Bitmap bitmap) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        if (bitmap != null) {
            this$0.initCanvasImage(bitmap, f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void playTrack$lambda$0(SportDetailVideoMapFragment this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        if (this$0.isInChinaMainland()) {
            generateVideo$default(this$0, 0.0f, 1, null);
            this$0.getMBaiDuMap().animateMapStatus(MapStatusUpdateFactory.zoomOut(), 1000);
        } else {
            this$0.getMGoogleMap().animateCamera(CameraUpdateFactory.zoomOut(), 500, null);
        }
        super.playTrack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setLoadingProcess$lambda$10(SportDetailVideoMapFragment this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        float f = (this$0.trackPlayProcess + this$0.videoProcess) / 2;
        com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo = this$0.mLoadingPopup;
        if (i0X0x0oIo != null) {
            if (f >= 1.0f) {
                this$0.dismissLoadPopup();
                if (this$0.playEndJump) {
                    this$0.playEndJump = false;
                    this$0.requireActivity().setResult(-1);
                    this$0.requireActivity().finish();
                }
            }
            if (this$0.isAdded()) {
                i0X0x0oIo.XxX0x0xxx(this$0.getString(R.string.generating) + ((int) (f * 100)) + org.apache.log4j.helpers.x0XOIxOo.f33309xxIXOIIO);
            }
        }
    }

    private final void showHr(List<HeartRate> list) {
        XIo0oOXIx xIo0oOXIx = XIo0oOXIx.f23889oIX0oI;
        this.mStartTime = xIo0oOXIx.xxIXOIIO(getMWorkout().getMStart());
        this.mEndTime = xIo0oOXIx.xxIXOIIO(getMWorkout().getMEnd()) + 60000;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        long j = this.mStartTime;
        long oxoX2 = xx0o0O.x0XOIxOo.oxoX(j, this.mEndTime, 60000L);
        int i = 0;
        if (j <= oxoX2) {
            while (true) {
                linkedHashMap.put(Long.valueOf(j), new XI0IXoo(0, 0));
                if (j == oxoX2) {
                    break;
                } else {
                    j += 60000;
                }
            }
        }
        int i2 = 0;
        for (Object obj : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.XoX();
            }
            HeartRate heartRate = (HeartRate) obj;
            Iterator it = linkedHashMap.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    long longValue = ((Number) entry.getKey()).longValue();
                    XI0IXoo xI0IXoo = (XI0IXoo) entry.getValue();
                    if (XIo0oOXIx.f23889oIX0oI.xxIXOIIO(heartRate.getMTime()) <= longValue) {
                        xI0IXoo.II0XooXoX(xI0IXoo.XO() + heartRate.getMBpm());
                        xI0IXoo.Oxx0IOOO(xI0IXoo.X0o0xo() + 1);
                        break;
                    }
                }
            }
            i2 = i3;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it2 = linkedHashMap.entrySet().iterator();
        float f = 0.0f;
        int i4 = 0;
        float f2 = -1.0f;
        while (it2.hasNext()) {
            XI0IXoo xI0IXoo2 = (XI0IXoo) ((Map.Entry) it2.next()).getValue();
            if (xI0IXoo2.X0o0xo() != 0 && xI0IXoo2.XO() != 0) {
                int XO2 = xI0IXoo2.XO() / xI0IXoo2.X0o0xo();
                arrayList.add(new Entry(f, XO2));
                if (i4 < XO2) {
                    f2 += 1.0f;
                    i4 = XO2;
                }
                i += XO2;
            }
            f += 1.0f;
        }
        if (arrayList.size() != 0) {
            int size = i / arrayList.size();
        }
        if (getMWorkout().getMMaxBpm() > 0 && getMWorkout().getMMaxBpm() > i4 && f2 > -1.0f) {
            arrayList.get((int) f2).XO(getMWorkout().getMMaxBpm());
        }
        LineChart hrLineChart = getHrLineChart();
        kotlin.jvm.internal.IIX0o.oO(hrLineChart, "<get-hrLineChart>(...)");
        configChart(hrLineChart, 40, Math.max(i4, getMWorkout().getMMaxBpm()) + 10);
        LineChart hrLineChart2 = getHrLineChart();
        kotlin.jvm.internal.IIX0o.oO(hrLineChart2, "<get-hrLineChart>(...)");
        updateChartData(hrLineChart2, arrayList, R.color.hr_color, R.drawable.shape_hr);
    }

    private final void showLoadPopup() {
        com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo;
        if (this.mLoadingPopup == null) {
            this.mLoadingPopup = new com.sma.smartv3.pop.I0X0x0oIo(getMActivity());
        }
        if (!isInChinaMainland()) {
            return;
        }
        com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo2 = this.mLoadingPopup;
        if (i0X0x0oIo2 != null) {
            i0X0x0oIo2.XxX0x0xxx(getString(R.string.generating) + "0%");
        }
        if (isAdded() && (i0X0x0oIo = this.mLoadingPopup) != null) {
            i0X0x0oIo.IIXOooo();
        }
    }

    private final void updateChartData(LineChart lineChart, List<Entry> list, int i, int i2) {
        LineDataSet lineDataSet = new LineDataSet(list, "");
        lineDataSet.OX(ContextCompat.getColor(getMActivity(), i));
        lineDataSet.X0ooXIooI(ContextCompat.getColor(getMActivity(), i));
        lineDataSet.oXxx000(2.0f);
        lineDataSet.xIXIOX(1.0f);
        lineDataSet.X0IOOI(false);
        lineDataSet.ooOOo0oXI(false);
        lineDataSet.oI(true);
        lineDataSet.xox(LineDataSet.Mode.CUBIC_BEZIER);
        Drawable drawable = ContextCompat.getDrawable(getMActivity(), i2);
        kotlin.jvm.internal.IIX0o.x0XOIxOo(drawable, "null cannot be cast to non-null type android.graphics.drawable.Drawable");
        lineDataSet.xIx0XO(drawable);
        o0xxxXXxX.ooOOo0oXI ooooo0oxi = new o0xxxXXxX.ooOOo0oXI(lineDataSet);
        ooooo0oxi.oo0xXOI0I(false);
        lineChart.setData(ooooo0oxi);
        lineChart.II0XooXoX(1000);
        lineChart.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void videoFinish$lambda$8(SportDetailVideoMapFragment this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.getBtnTrackPlay().setVisibility(0);
        if (this$0.isInChinaMainland()) {
            this$0.getBtnSaveVideo().setVisibility(0);
        }
    }

    public final void generateVideo(float f) {
        this.trackPlayProcess = f;
        if (f == 1.0f && this.mFile.exists() && !this.videoStart) {
            videoFinish();
        }
        if (isInChinaMainland()) {
            if (!this.mFile.exists()) {
                mapSnapShot(f);
            }
            if (f == 1.0f && !this.videoStart && !this.mFile.exists() && isAdded()) {
                this.videoStart = !this.videoStart;
                this.nextIndex = 0;
                new VideoEncoder(this, this.mFile, this.mFrameRate).oOoXoXO();
                return;
            }
            return;
        }
        if (f == 1.0f) {
            videoFinish();
        }
    }

    @OXOo.OOXIXo
    public final File getMFile() {
        return this.mFile;
    }

    @OXOo.OOXIXo
    public final List<Bitmap> getMList() {
        return this.mList;
    }

    public final int getMMaxSize() {
        return this.mMaxSize;
    }

    @Override // com.sma.smartv3.ui.sport.SportDetailMapFragment
    @OXOo.OOXIXo
    public TrackPlay getMTrackPlay() {
        return this.mTrackPlay;
    }

    public final int getNextIndex() {
        return this.nextIndex;
    }

    public final boolean getPlayEndJump() {
        return this.playEndJump;
    }

    @OXOo.oOoXoXO
    public final Bitmap getRootBitmap() {
        return this.rootBitmap;
    }

    @OXOo.OOXIXo
    public final String getTitle() {
        return ProductManager.f20544oIX0oI.xIXX(getMWorkout().getMMode());
    }

    public final float getTrackPlayProcess() {
        return this.trackPlayProcess;
    }

    public final float getVideoProcess() {
        return this.videoProcess;
    }

    public final boolean getVideoStart() {
        return this.videoStart;
    }

    @Override // com.sma.smartv3.ui.sport.SportDetailMapFragment, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        super.initView();
        this.mFile = new File(com.sma.smartv3.initializer.IXxxXO.XoX(X00IoxXI.oIX0oI.f3233oIX0oI), "mapVideo" + getMArg1() + '_' + Utils.getApp().getResources().getConfiguration().locale.getLanguage() + ".mp4");
        getBtnSaveVideo().setVisibility(8);
        getBtnTrackPlay().setVisibility(0);
        getTvDetailname().setText(getTitle());
        getTvNickname().setText(getUserProfile().getNickname());
        avatarShow();
        getTvAvgHrValue().setText(String.valueOf(getMWorkout().getMAvgBpm()));
        getBtnSaveVideo().setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.sport.XX0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SportDetailVideoMapFragment.initView$lambda$3(SportDetailVideoMapFragment.this, view);
            }
        });
        List<HeartRate> heartRates = getMHeartRateDao().getHeartRates(getMWorkout().getMStart(), getMWorkout().getMEnd());
        if (getMWorkout().getMSource() == 1 && getMWorkout().getMAvgBpm() == 0) {
            showHr(new ArrayList());
        } else {
            showHr(heartRates);
        }
    }

    @Override // com.sma.smartv3.ui.sport.SportDetailMapFragment
    public void initializedMapFinish() {
        if (isInChinaMainland()) {
            getMBaiDuMap().setMapType(2);
            getMBaiDuMap().getUiSettings().setAllGesturesEnabled(false);
        } else {
            getMGoogleMap().setMapType(2);
            getMGoogleMap().getUiSettings().setAllGesturesEnabled(false);
            getMGoogleMap().moveCamera(CameraUpdateFactory.zoomOut());
        }
    }

    @Override // com.sma.smartv3.ui.sport.SportDetailMapFragment, com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.fragment_sport_detail_map_v3;
    }

    @Override // com.sma.smartv3.ui.sport.SportDetailMapFragment, com.bestmafen.androidbase.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Bitmap bitmap = this.rootBitmap;
        if (bitmap != null) {
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(bitmap);
            bitmap.recycle();
            this.rootBitmap = null;
        }
    }

    @Override // com.sma.smartv3.ui.sport.SportDetailMapFragment
    public void playTrack() {
        int OOXIXo2 = getMTrackPlay().OOXIXo();
        if (OOXIXo2 >= 0 && OOXIXo2 < 21) {
            this.mFrameRate = OOXIXo2 / 3;
            getMTrackPlay().xoXoI(3000 / OOXIXo2);
        } else if (21 <= OOXIXo2 && OOXIXo2 < 101) {
            this.mFrameRate = OOXIXo2 / 5;
            getMTrackPlay().xoXoI(5000 / OOXIXo2);
        } else {
            this.mFrameRate = OOXIXo2 / 10;
            getMTrackPlay().xoXoI(10000 / OOXIXo2);
        }
        LogUtils.d(this.TAG + "  playTrack size = " + OOXIXo2 + "  mFrameRate = " + this.mFrameRate);
        getBtnTrackPlay().setVisibility(8);
        getBtnSaveVideo().setVisibility(8);
        this.videoStart = false;
        this.trackPlayProcess = 0.0f;
        this.videoProcess = 0.0f;
        this.mMaxSize = 0;
        this.mList.clear();
        if (!this.mFile.exists()) {
            showLoadPopup();
        }
        generateVideo$default(this, 0.0f, 1, null);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.sport.I0X0x0oIo
            @Override // java.lang.Runnable
            public final void run() {
                SportDetailVideoMapFragment.playTrack$lambda$0(SportDetailVideoMapFragment.this);
            }
        }, 150L);
    }

    @Override // com.sma.smartv3.util.video.oIX0oI
    public void progress(float f) {
        this.videoProcess = f;
        setLoadingProcess();
        if (f >= 1.0f) {
            videoFinish();
        }
    }

    public final void setLoadingProcess() {
        if (!isInChinaMainland()) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.sma.smartv3.ui.sport.xXOx
            @Override // java.lang.Runnable
            public final void run() {
                SportDetailVideoMapFragment.setLoadingProcess$lambda$10(SportDetailVideoMapFragment.this);
            }
        });
    }

    public final void setMFile(@OXOo.OOXIXo File file) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(file, "<set-?>");
        this.mFile = file;
    }

    public final void setMMaxSize(int i) {
        this.mMaxSize = i;
    }

    @Override // com.sma.smartv3.ui.sport.SportDetailMapFragment
    public void setMTrackPlay(@OXOo.OOXIXo TrackPlay trackPlay) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(trackPlay, "<set-?>");
        this.mTrackPlay = trackPlay;
    }

    public final void setNextIndex(int i) {
        this.nextIndex = i;
    }

    public final void setPlayEndJump(boolean z) {
        this.playEndJump = z;
    }

    public final void setRootBitmap(@OXOo.oOoXoXO Bitmap bitmap) {
        this.rootBitmap = bitmap;
    }

    public final void setTrackPlayProcess(float f) {
        this.trackPlayProcess = f;
    }

    public final void setVideoProcess(float f) {
        this.videoProcess = f;
    }

    public final void setVideoStart(boolean z) {
        this.videoStart = z;
    }

    @Override // com.sma.smartv3.util.video.oIX0oI
    public int size() {
        return this.mMaxSize + 5;
    }

    public final void videoFinish() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.sma.smartv3.ui.sport.oX
            @Override // java.lang.Runnable
            public final void run() {
                SportDetailVideoMapFragment.videoFinish$lambda$8(SportDetailVideoMapFragment.this);
            }
        });
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sma.smartv3.util.video.oIX0oI
    @OXOo.OOXIXo
    public Bitmap next() {
        if (this.nextIndex > 10) {
            int size = this.mList.size();
            int i = this.nextIndex;
            if (size > i + 10) {
                this.mList.get(i - 10).recycle();
            }
        }
        int i2 = this.nextIndex + 1;
        this.nextIndex = i2;
        if (i2 >= this.mList.size() - 1) {
            return this.mList.get(r0.size() - 1);
        }
        return this.mList.get(this.nextIndex);
    }
}
