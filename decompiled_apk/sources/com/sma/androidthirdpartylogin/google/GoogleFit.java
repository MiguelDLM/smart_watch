package com.sma.androidthirdpartylogin.google;

import android.app.Activity;
import android.content.Context;
import com.blankj.utilcode.util.LogUtils;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.fitness.Fitness;
import com.google.android.gms.fitness.FitnessOptions;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

/* loaded from: classes11.dex */
public final class GoogleFit {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final GoogleFit f19698oIX0oI = new GoogleFit();

    /* loaded from: classes11.dex */
    public static final class oIX0oI {

        /* renamed from: I0Io, reason: collision with root package name */
        @OXOo.OOXIXo
        public String f19699I0Io;

        /* renamed from: II0xO0, reason: collision with root package name */
        public int f19700II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        public int f19701oIX0oI;

        public oIX0oI(int i, int i2, @OXOo.OOXIXo String sleepType) {
            IIX0o.x0xO0oo(sleepType, "sleepType");
            this.f19701oIX0oI = i;
            this.f19700II0xO0 = i2;
            this.f19699I0Io = sleepType;
        }

        public static /* synthetic */ oIX0oI X0o0xo(oIX0oI oix0oi, int i, int i2, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = oix0oi.f19701oIX0oI;
            }
            if ((i3 & 2) != 0) {
                i2 = oix0oi.f19700II0xO0;
            }
            if ((i3 & 4) != 0) {
                str = oix0oi.f19699I0Io;
            }
            return oix0oi.oxoX(i, i2, str);
        }

        @OXOo.OOXIXo
        public final String I0Io() {
            return this.f19699I0Io;
        }

        public final int II0XooXoX() {
            return this.f19701oIX0oI;
        }

        public final int II0xO0() {
            return this.f19700II0xO0;
        }

        public final void OOXIXo(int i) {
            this.f19701oIX0oI = i;
        }

        @OXOo.OOXIXo
        public final String Oxx0IOOO() {
            return this.f19699I0Io;
        }

        public final int XO() {
            return this.f19700II0xO0;
        }

        public boolean equals(@OXOo.oOoXoXO Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof oIX0oI)) {
                return false;
            }
            oIX0oI oix0oi = (oIX0oI) obj;
            return this.f19701oIX0oI == oix0oi.f19701oIX0oI && this.f19700II0xO0 == oix0oi.f19700II0xO0 && IIX0o.Oxx0IOOO(this.f19699I0Io, oix0oi.f19699I0Io);
        }

        public int hashCode() {
            return (((this.f19701oIX0oI * 31) + this.f19700II0xO0) * 31) + this.f19699I0Io.hashCode();
        }

        public final int oIX0oI() {
            return this.f19701oIX0oI;
        }

        @OXOo.OOXIXo
        public final oIX0oI oxoX(int i, int i2, @OXOo.OOXIXo String sleepType) {
            IIX0o.x0xO0oo(sleepType, "sleepType");
            return new oIX0oI(i, i2, sleepType);
        }

        @OXOo.OOXIXo
        public String toString() {
            return "SleepDataPoint(startTime=" + this.f19701oIX0oI + ", endTime=" + this.f19700II0xO0 + ", sleepType=" + this.f19699I0Io + HexStringBuilder.COMMENT_END_CHAR;
        }

        public final void xoIox(@OXOo.OOXIXo String str) {
            IIX0o.x0xO0oo(str, "<set-?>");
            this.f19699I0Io = str;
        }

        public final void xxIXOIIO(int i) {
            this.f19700II0xO0 = i;
        }
    }

    public static final void IIXOooo(String stream, Exception e) {
        IIX0o.x0xO0oo(stream, "$stream");
        IIX0o.x0xO0oo(e, "e");
        LogUtils.i(stream + " -> There was a problem inserting the session: " + e.getLocalizedMessage());
    }

    public static final void IXxxXO(DataType dataType, Exception it) {
        IIX0o.x0xO0oo(dataType, "$dataType");
        IIX0o.x0xO0oo(it, "it");
        LogUtils.i(dataType.getName() + " Failed to unsubscribe for data type.");
    }

    public static final void Oo(Oox.oOoXoXO tmp0, Object obj) {
        IIX0o.x0xO0oo(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void OxI(Exception e) {
        IIX0o.x0xO0oo(e, "e");
        LogUtils.i("There was a problem inserting the session: " + e.getLocalizedMessage());
    }

    public static final void OxxIIOOXO(Oox.oOoXoXO tmp0, Object obj) {
        IIX0o.x0xO0oo(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void o00(Oox.oOoXoXO tmp0, Object obj) {
        IIX0o.x0xO0oo(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void ooOOo0oXI(Oox.oOoXoXO tmp0, Object obj) {
        IIX0o.x0xO0oo(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void x0XOIxOo(DataType dataType, Exception it) {
        IIX0o.x0xO0oo(dataType, "$dataType");
        IIX0o.x0xO0oo(it, "it");
        LogUtils.i(dataType.getName() + " There was a problem subscribing.");
    }

    public final boolean OOXIXo(@OXOo.OOXIXo Activity app, int i, int i2) {
        IIX0o.x0xO0oo(app, "app");
        if (xoIox(app) == null || i != 1 || i2 != -1) {
            return false;
        }
        oO(app);
        return true;
    }

    public final void Oxx0xo(@OXOo.OOXIXo Activity app) {
        IIX0o.x0xO0oo(app, "app");
        LogUtils.d("unSubscribeDataToGoogleFit");
        DataType TYPE_STEP_COUNT_DELTA = DataType.TYPE_STEP_COUNT_DELTA;
        IIX0o.oO(TYPE_STEP_COUNT_DELTA, "TYPE_STEP_COUNT_DELTA");
        x0xO0oo(app, TYPE_STEP_COUNT_DELTA);
        DataType TYPE_CALORIES_EXPENDED = DataType.TYPE_CALORIES_EXPENDED;
        IIX0o.oO(TYPE_CALORIES_EXPENDED, "TYPE_CALORIES_EXPENDED");
        x0xO0oo(app, TYPE_CALORIES_EXPENDED);
        DataType TYPE_DISTANCE_DELTA = DataType.TYPE_DISTANCE_DELTA;
        IIX0o.oO(TYPE_DISTANCE_DELTA, "TYPE_DISTANCE_DELTA");
        x0xO0oo(app, TYPE_DISTANCE_DELTA);
        DataType TYPE_HEART_RATE_BPM = DataType.TYPE_HEART_RATE_BPM;
        IIX0o.oO(TYPE_HEART_RATE_BPM, "TYPE_HEART_RATE_BPM");
        x0xO0oo(app, TYPE_HEART_RATE_BPM);
        DataType TYPE_WEIGHT = DataType.TYPE_WEIGHT;
        IIX0o.oO(TYPE_WEIGHT, "TYPE_WEIGHT");
        x0xO0oo(app, TYPE_WEIGHT);
        DataType TYPE_SLEEP_SEGMENT = DataType.TYPE_SLEEP_SEGMENT;
        IIX0o.oO(TYPE_SLEEP_SEGMENT, "TYPE_SLEEP_SEGMENT");
        x0xO0oo(app, TYPE_SLEEP_SEGMENT);
    }

    public final void oI0IIXIo(@OXOo.OOXIXo Context context, @OXOo.OOXIXo String appPackageName, @OXOo.OOXIXo DataType dataType, @OXOo.OOXIXo final String stream, @OXOo.OOXIXo Field field, float f, long j, long j2) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(appPackageName, "appPackageName");
        IIX0o.x0xO0oo(dataType, "dataType");
        IIX0o.x0xO0oo(stream, "stream");
        IIX0o.x0xO0oo(field, "field");
        GoogleSignInAccount xoIox2 = xoIox(context);
        if (xoIox2 == null) {
            return;
        }
        DataSource build = new DataSource.Builder().setAppPackageName(appPackageName).setDataType(dataType).setStreamName(stream).setType(0).build();
        IIX0o.oO(build, "build(...)");
        DataSet.Builder builder = DataSet.builder(build);
        IIX0o.oO(builder, "builder(...)");
        DataPoint.Builder timeInterval = DataPoint.builder(build).setTimeInterval(j, j2, TimeUnit.MILLISECONDS);
        IIX0o.oO(timeInterval, "setTimeInterval(...)");
        LogUtils.d(stream + org.apache.commons.text.oIX0oI.f33048oxoX + f);
        if (IIX0o.Oxx0IOOO(dataType, DataType.TYPE_STEP_COUNT_DELTA)) {
            timeInterval.setField(field, (int) f);
        } else {
            timeInterval.setField(field, f);
        }
        builder.add(timeInterval.build());
        Task<Void> insertData = Fitness.getHistoryClient(context, xoIox2).insertData(builder.build());
        final Oox.oOoXoXO<Void, oXIO0o0XI> oooxoxo = new Oox.oOoXoXO<Void, oXIO0o0XI>() { // from class: com.sma.androidthirdpartylogin.google.GoogleFit$uploadDataToGoogleFit$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Void r1) {
                invoke2(r1);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r3) {
                LogUtils.i(stream + " -> Session insert was successful!");
            }
        };
        insertData.addOnSuccessListener(new OnSuccessListener() { // from class: com.sma.androidthirdpartylogin.google.II0XooXoX
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                GoogleFit.OxxIIOOXO(Oox.oOoXoXO.this, obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.sma.androidthirdpartylogin.google.xxIXOIIO
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                GoogleFit.IIXOooo(stream, exc);
            }
        });
    }

    public final void oO(Activity activity) {
        LogUtils.d("subscribeDataToGoogleFit");
        DataType TYPE_STEP_COUNT_DELTA = DataType.TYPE_STEP_COUNT_DELTA;
        IIX0o.oO(TYPE_STEP_COUNT_DELTA, "TYPE_STEP_COUNT_DELTA");
        oOoXoXO(activity, TYPE_STEP_COUNT_DELTA);
        DataType TYPE_CALORIES_EXPENDED = DataType.TYPE_CALORIES_EXPENDED;
        IIX0o.oO(TYPE_CALORIES_EXPENDED, "TYPE_CALORIES_EXPENDED");
        oOoXoXO(activity, TYPE_CALORIES_EXPENDED);
        DataType TYPE_DISTANCE_DELTA = DataType.TYPE_DISTANCE_DELTA;
        IIX0o.oO(TYPE_DISTANCE_DELTA, "TYPE_DISTANCE_DELTA");
        oOoXoXO(activity, TYPE_DISTANCE_DELTA);
        DataType TYPE_HEART_RATE_BPM = DataType.TYPE_HEART_RATE_BPM;
        IIX0o.oO(TYPE_HEART_RATE_BPM, "TYPE_HEART_RATE_BPM");
        oOoXoXO(activity, TYPE_HEART_RATE_BPM);
        DataType TYPE_WEIGHT = DataType.TYPE_WEIGHT;
        IIX0o.oO(TYPE_WEIGHT, "TYPE_WEIGHT");
        oOoXoXO(activity, TYPE_WEIGHT);
        DataType TYPE_SLEEP_SEGMENT = DataType.TYPE_SLEEP_SEGMENT;
        IIX0o.oO(TYPE_SLEEP_SEGMENT, "TYPE_SLEEP_SEGMENT");
        oOoXoXO(activity, TYPE_SLEEP_SEGMENT);
    }

    public final void oOoXoXO(Activity activity, final DataType dataType) {
        if (xoIox(activity) == null) {
            return;
        }
        GoogleSignInAccount lastSignedInAccount = GoogleSignIn.getLastSignedInAccount(activity);
        IIX0o.ooOOo0oXI(lastSignedInAccount);
        Task<Void> subscribe = Fitness.getRecordingClient(activity, lastSignedInAccount).subscribe(dataType);
        final Oox.oOoXoXO<Void, oXIO0o0XI> oooxoxo = new Oox.oOoXoXO<Void, oXIO0o0XI>() { // from class: com.sma.androidthirdpartylogin.google.GoogleFit$subscribeData$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Void r1) {
                invoke2(r1);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r3) {
                LogUtils.i(DataType.this.getName() + " Successfully subscribed!");
            }
        };
        subscribe.addOnSuccessListener(new OnSuccessListener() { // from class: com.sma.androidthirdpartylogin.google.oxoX
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                GoogleFit.ooOOo0oXI(Oox.oOoXoXO.this, obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.sma.androidthirdpartylogin.google.X0o0xo
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                GoogleFit.x0XOIxOo(DataType.this, exc);
            }
        });
    }

    public final void x0xO0oo(Activity activity, final DataType dataType) {
        if (xoIox(activity) == null) {
            return;
        }
        GoogleSignInAccount lastSignedInAccount = GoogleSignIn.getLastSignedInAccount(activity);
        IIX0o.ooOOo0oXI(lastSignedInAccount);
        Task<Void> unsubscribe = Fitness.getRecordingClient(activity, lastSignedInAccount).unsubscribe(dataType);
        final Oox.oOoXoXO<Void, oXIO0o0XI> oooxoxo = new Oox.oOoXoXO<Void, oXIO0o0XI>() { // from class: com.sma.androidthirdpartylogin.google.GoogleFit$unSubscribeData$1
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Void r1) {
                invoke2(r1);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r3) {
                LogUtils.i(DataType.this.getName() + " Successfully unsubscribed!");
            }
        };
        unsubscribe.addOnSuccessListener(new OnSuccessListener() { // from class: com.sma.androidthirdpartylogin.google.xoIox
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                GoogleFit.Oo(Oox.oOoXoXO.this, obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.sma.androidthirdpartylogin.google.OOXIXo
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                GoogleFit.IXxxXO(DataType.this, exc);
            }
        });
    }

    public final GoogleSignInAccount xoIox(Context context) {
        boolean z;
        StringBuilder sb = new StringBuilder();
        sb.append("isSignedInAccount ");
        if (GoogleSignIn.getLastSignedInAccount(context) != null) {
            z = true;
        } else {
            z = false;
        }
        sb.append(z);
        LogUtils.d(sb.toString());
        return GoogleSignIn.getLastSignedInAccount(context);
    }

    public final void xoXoI(@OXOo.OOXIXo Context context, @OXOo.OOXIXo String appPackageName, @OXOo.OOXIXo String stream, @OXOo.OOXIXo String sessionName, @OXOo.OOXIXo String description, @OXOo.OOXIXo ArrayList<oIX0oI> sleepData) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(appPackageName, "appPackageName");
        IIX0o.x0xO0oo(stream, "stream");
        IIX0o.x0xO0oo(sessionName, "sessionName");
        IIX0o.x0xO0oo(description, "description");
        IIX0o.x0xO0oo(sleepData, "sleepData");
        GoogleSignInAccount xoIox2 = xoIox(context);
        if (xoIox2 == null) {
            return;
        }
        DataSource build = new DataSource.Builder().setAppPackageName(appPackageName).setDataType(DataType.TYPE_SLEEP_SEGMENT).setStreamName(stream).setType(0).build();
        IIX0o.oO(build, "build(...)");
        DataSet.Builder builder = DataSet.builder(build);
        IIX0o.oO(builder, "builder(...)");
        Iterator<oIX0oI> it = sleepData.iterator();
        while (it.hasNext()) {
            builder.add(DataPoint.builder(build).setTimeInterval(r10.II0XooXoX() * 1000, r10.XO() * 1000, TimeUnit.MILLISECONDS).setActivityField(Field.FIELD_SLEEP_SEGMENT_TYPE, it.next().Oxx0IOOO()).build());
            build = build;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("sleep insert ");
        sb.append(((oIX0oI) CollectionsKt___CollectionsKt.O0OOX0IIx(sleepData)).II0XooXoX());
        sb.append("  ");
        sb.append(((oIX0oI) CollectionsKt___CollectionsKt.O0O0Io00X(sleepData)).XO());
        LogUtils.d(sb.toString());
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        Session build2 = new Session.Builder().setName(sessionName).setDescription(description).setStartTime(((oIX0oI) CollectionsKt___CollectionsKt.O0OOX0IIx(sleepData)).II0XooXoX() * 1000, timeUnit).setEndTime(((oIX0oI) CollectionsKt___CollectionsKt.O0O0Io00X(sleepData)).XO() * 1000, timeUnit).setActivity("sleep").build();
        IIX0o.oO(build2, "build(...)");
        SessionInsertRequest build3 = new SessionInsertRequest.Builder().setSession(build2).addDataSet(builder.build()).build();
        IIX0o.oO(build3, "build(...)");
        Task<Void> insertSession = Fitness.getSessionsClient(context, xoIox2).insertSession(build3);
        final GoogleFit$uploadSleepDataToGoogleFit$1 googleFit$uploadSleepDataToGoogleFit$1 = new Oox.oOoXoXO<Void, oXIO0o0XI>() { // from class: com.sma.androidthirdpartylogin.google.GoogleFit$uploadSleepDataToGoogleFit$1
            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke(Void r1) {
                invoke2(r1);
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r3) {
                LogUtils.i("Session insert was successful!");
            }
        };
        insertSession.addOnSuccessListener(new OnSuccessListener() { // from class: com.sma.androidthirdpartylogin.google.XO
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                GoogleFit.o00(Oox.oOoXoXO.this, obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.sma.androidthirdpartylogin.google.Oxx0IOOO
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                GoogleFit.OxI(exc);
            }
        });
    }

    public final void xxIXOIIO(@OXOo.OOXIXo Activity app) {
        IIX0o.x0xO0oo(app, "app");
        FitnessOptions build = FitnessOptions.builder().addDataType(DataType.TYPE_STEP_COUNT_DELTA, 1).addDataType(DataType.TYPE_CALORIES_EXPENDED, 1).addDataType(DataType.TYPE_DISTANCE_DELTA, 1).addDataType(DataType.TYPE_HEART_RATE_BPM, 1).addDataType(DataType.TYPE_WEIGHT, 1).addDataType(DataType.TYPE_SLEEP_SEGMENT, 1).build();
        IIX0o.oO(build, "build(...)");
        GoogleSignInAccount accountForExtension = GoogleSignIn.getAccountForExtension(app, build);
        IIX0o.oO(accountForExtension, "getAccountForExtension(...)");
        LogUtils.d("init");
        if (!GoogleSignIn.hasPermissions(accountForExtension, build)) {
            GoogleSignIn.requestPermissions(app, 1, accountForExtension, build);
        } else {
            oO(app);
        }
    }
}
