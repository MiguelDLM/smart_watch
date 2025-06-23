package com.sma.smartv3.ui.me;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.bestmafen.androidbase.base.BaseActivity;
import com.bestmafen.androidbase.io.Location;
import com.blankj.utilcode.util.FileIOUtils;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.reflect.TypeToken;
import com.sma.androidnetworklib.method.NetWork;
import com.sma.androidnetworklib.model.Response;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.network.Api;
import com.sma.smartv3.network.NetWorkUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.text.StringsKt__StringsKt;

@kotlin.jvm.internal.XX({"SMAP\nDeveloperTuyaQueryActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeveloperTuyaQueryActivity.kt\ncom/sma/smartv3/ui/me/DeveloperTuyaQueryActivity\n+ 2 NetWorkUtils.kt\ncom/sma/smartv3/network/NetWorkUtils\n+ 3 NetWork.kt\ncom/sma/androidnetworklib/method/NetWork\n*L\n1#1,268:1\n151#2,11:269\n171#2:288\n151#2,11:289\n171#2:308\n151#2,11:309\n171#2:328\n208#3,7:280\n226#3:287\n208#3,7:300\n226#3:307\n208#3,7:320\n226#3:327\n*S KotlinDebug\n*F\n+ 1 DeveloperTuyaQueryActivity.kt\ncom/sma/smartv3/ui/me/DeveloperTuyaQueryActivity\n*L\n143#1:269,11\n143#1:288\n178#1:289,11\n178#1:308\n222#1:309,11\n222#1:328\n143#1:280,7\n143#1:287\n178#1:300,7\n178#1:307\n222#1:320,7\n222#1:327\n*E\n"})
/* loaded from: classes11.dex */
public final class DeveloperTuyaQueryActivity extends BaseActivity {

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.I0X0x0oIo mLoadingPopup;
    private String mMac;
    private String mName;

    @OXOo.oOoXoXO
    private com.sma.smartv3.pop.xxOXOOoIX mPopup;

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvInfo$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.me.DeveloperTuyaQueryActivity$tvInfo$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) DeveloperTuyaQueryActivity.this.findViewById(R.id.tvInfo);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvState$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.me.DeveloperTuyaQueryActivity$tvState$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) DeveloperTuyaQueryActivity.this.findViewById(R.id.tvState);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO btnOperate$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<Button>() { // from class: com.sma.smartv3.ui.me.DeveloperTuyaQueryActivity$btnOperate$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final Button invoke() {
            return (Button) DeveloperTuyaQueryActivity.this.findViewById(R.id.btn_operate);
        }
    });

    @OXOo.OOXIXo
    private final kotlin.X0IIOO tvCount$delegate = kotlin.XIxXXX0x0.oIX0oI(new Oox.oIX0oI<TextView>() { // from class: com.sma.smartv3.ui.me.DeveloperTuyaQueryActivity$tvCount$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // Oox.oIX0oI
        public final TextView invoke() {
            return (TextView) DeveloperTuyaQueryActivity.this.findViewById(R.id.tvCount);
        }
    });

    @OXOo.OOXIXo
    private final List<String> list = CollectionsKt__CollectionsKt.XOxIOxOx("0-主板烧录", "1-产线一检", "2-产线二检", "3-包装", "99-恢复默认状态（全部状态置为0）");

    /* JADX INFO: Access modifiers changed from: private */
    public final Button getBtnOperate() {
        return (Button) this.btnOperate$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getMNow() {
        return new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.getDefault()).format(new Date());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File getShareFile(String str) {
        return X00IoxXI.oIX0oI.f3233oIX0oI.oIX0oI(Location.EXTERNAL, X00IoxXI.II0xO0.f3231II0xO0.X0o0xo().II0xO0("share"), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView getTvCount() {
        return (TextView) this.tvCount$delegate.getValue();
    }

    private final TextView getTvInfo() {
        return (TextView) this.tvInfo$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView getTvState() {
        return (TextView) this.tvState$delegate.getValue();
    }

    public final void export() {
        if (this.mLoadingPopup == null) {
            com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo = new com.sma.smartv3.pop.I0X0x0oIo(getMContext());
            i0X0x0oIo.x0xO0oo(false);
            this.mLoadingPopup = i0X0x0oIo;
        }
        com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo2 = this.mLoadingPopup;
        if (i0X0x0oIo2 != null) {
            i0X0x0oIo2.IIXOooo();
        }
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap hashMap = new HashMap();
        String str = this.mName;
        final Activity activity = null;
        if (str == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mName");
            str = null;
        }
        hashMap.put("bleName", str);
        final xxxI.II0xO0<IxI[]> iI0xO0 = new xxxI.II0xO0<IxI[]>() { // from class: com.sma.smartv3.ui.me.DeveloperTuyaQueryActivity$export$3
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo3;
                kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                ToastUtils.showLong(error, new Object[0]);
                i0X0x0oIo3 = DeveloperTuyaQueryActivity.this.mLoadingPopup;
                if (i0X0x0oIo3 != null) {
                    i0X0x0oIo3.dismiss();
                }
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO IxI[] ixIArr) {
                com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo3;
                String mNow;
                File shareFile;
                com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo4;
                if (ixIArr == null || ixIArr.length == 0) {
                    i0X0x0oIo3 = DeveloperTuyaQueryActivity.this.mLoadingPopup;
                    if (i0X0x0oIo3 != null) {
                        i0X0x0oIo3.dismiss();
                    }
                    ToastUtils.showLong("没有数据", new Object[0]);
                    return;
                }
                DeveloperTuyaQueryActivity developerTuyaQueryActivity = DeveloperTuyaQueryActivity.this;
                StringBuilder sb = new StringBuilder();
                mNow = DeveloperTuyaQueryActivity.this.getMNow();
                sb.append(mNow);
                sb.append(".csv");
                shareFile = developerTuyaQueryActivity.getShareFile(sb.toString());
                FileUtils.createOrExistsFile(shareFile);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("id,bleName,mac,uuid,tuYaKey,info\n");
                for (IxI ixI : ixIArr) {
                    sb2.append(ixI.getId() + ',' + ixI.getBleName() + ',' + ixI.getMac() + ',' + ixI.oxoX() + ',' + ixI.I0Io() + ',' + kotlin.text.OxI.IIOIX(ixI.getInfo(), ",", " ", false, 4, null) + '\n');
                }
                FileIOUtils.writeFileFromString(shareFile, sb2.toString());
                i0X0x0oIo4 = DeveloperTuyaQueryActivity.this.mLoadingPopup;
                if (i0X0x0oIo4 != null) {
                    i0X0x0oIo4.dismiss();
                }
                Intent intent = new Intent("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.TEXT", "Share Csv");
                intent.putExtra("android.intent.extra.STREAM", X00IoxXI.oIX0oI.f3233oIX0oI.oxoX(shareFile));
                intent.setType("*/*");
                DeveloperTuyaQueryActivity.this.startActivity(Intent.createChooser(intent, "Share Csv"));
            }
        };
        final com.sma.smartv3.pop.I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), x0xO0oo.f23617II0xO0);
        netWorkUtils.printParam(convertBaseUrl + x0xO0oo.f23617II0xO0, hashMap);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str2 = convertBaseUrl + x0xO0oo.f23617II0xO0;
        final xxxI.II0xO0<Response<IxI[]>> iI0xO02 = new xxxI.II0xO0<Response<IxI[]>>() { // from class: com.sma.smartv3.ui.me.DeveloperTuyaQueryActivity$export$$inlined$post$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<IxI[]> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                Activity activity2 = activity;
                xxxI.II0xO0 iI0xO03 = iI0xO0;
                com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo3 = loadPopup;
                LogUtils.d(x0xO.XO.f34062II0XooXoX + response);
                if (response == null) {
                    response = new Response<>();
                    response.setCode(-1000);
                }
                netWorkUtils2.responseWhenCheck(activity2, response, iI0xO03);
                if (i0X0x0oIo3 != null) {
                    i0X0x0oIo3.dismiss();
                }
            }
        };
        AndroidNetworking.post(str2).addBodyParameter((Map<String, String>) hashMap).setTag((Object) str2).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, IxI[].class), new ParsedRequestListener<Response<IxI[]>>() { // from class: com.sma.smartv3.ui.me.DeveloperTuyaQueryActivity$export$$inlined$post$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<IxI[]> response) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                Integer num;
                String str3;
                String str4;
                Response response;
                StringBuilder sb = new StringBuilder();
                sb.append("errorCode:");
                Integer num2 = null;
                if (aNError != null) {
                    num = Integer.valueOf(aNError.getErrorCode());
                } else {
                    num = null;
                }
                sb.append(num);
                sb.append(", errorBody:");
                if (aNError != null) {
                    str3 = aNError.getErrorBody();
                } else {
                    str3 = null;
                }
                sb.append(str3);
                sb.append(", ");
                if (aNError != null) {
                    str4 = aNError.getErrorDetail();
                } else {
                    str4 = null;
                }
                sb.append(str4);
                LogUtils.d(sb.toString());
                if (aNError != null && (response = (Response) aNError.getErrorAsObject(Response.class)) != null) {
                    num2 = Integer.valueOf(response.getCode());
                } else if (aNError != null) {
                    num2 = Integer.valueOf(aNError.getErrorCode());
                }
                xxxI.II0xO0.this.handleError(String.valueOf(num2));
            }
        });
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void init(@OXOo.oOoXoXO Bundle bundle) {
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        this.mName = String.valueOf(getIntent().getStringExtra("name"));
        this.mMac = String.valueOf(getIntent().getStringExtra("mac"));
        TextView tvInfo = getTvInfo();
        StringBuilder sb = new StringBuilder();
        sb.append("蓝牙名\n");
        String str = this.mName;
        String str2 = null;
        if (str == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mName");
            str = null;
        }
        sb.append(str);
        sb.append("\n\n\n地址\n");
        String str3 = this.mMac;
        if (str3 == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mMac");
        } else {
            str2 = str3;
        }
        sb.append(str2);
        tvInfo.setText(sb.toString());
        Button btnOperate = getBtnOperate();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("当前：\n");
        List<String> list = this.list;
        com.sma.smartv3.util.Xo0 xo0 = com.sma.smartv3.util.Xo0.f24349oIX0oI;
        sb2.append(list.get(xo0.II0xO0().getInt(xXoOI00O.f23639oIX0oI, 0)));
        btnOperate.setText(sb2.toString());
        queryCount(xo0.II0xO0().getInt(xXoOI00O.f23639oIX0oI, 0));
    }

    @Override // com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_developer_test_tuya_query;
    }

    public final void onExportCsv(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(this, 0, 2, null);
        xoI0Ixx0.Xx000oIo("是否导出数据？");
        com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx0, Integer.valueOf(R.string.cancel), null, 2, null);
        xoI0Ixx0.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.me.DeveloperTuyaQueryActivity$onExportCsv$1$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final Boolean invoke() {
                DeveloperTuyaQueryActivity.this.export();
                return Boolean.TRUE;
            }
        });
        xoI0Ixx0.oI0IIXIo(R.id.root_view);
    }

    public final void onOperate(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        if (this.mPopup == null) {
            com.sma.smartv3.pop.xxOXOOoIX xxoxoooix = new com.sma.smartv3.pop.xxOXOOoIX(this, this.list, 0, 4, (kotlin.jvm.internal.IIXOooo) null);
            xxoxoooix.ooXIXxIX(new Oox.oOoXoXO<Integer, Boolean>() { // from class: com.sma.smartv3.ui.me.DeveloperTuyaQueryActivity$onOperate$1$1
                {
                    super(1);
                }

                @Override // Oox.oOoXoXO
                public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                    return invoke(num.intValue());
                }

                @OXOo.OOXIXo
                public final Boolean invoke(int i) {
                    Button btnOperate;
                    List list;
                    btnOperate = DeveloperTuyaQueryActivity.this.getBtnOperate();
                    StringBuilder sb = new StringBuilder();
                    sb.append("当前：\n");
                    list = DeveloperTuyaQueryActivity.this.list;
                    sb.append((String) list.get(i));
                    btnOperate.setText(sb.toString());
                    com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0().put(xXoOI00O.f23639oIX0oI, i);
                    DeveloperTuyaQueryActivity.this.queryCount(i);
                    return Boolean.TRUE;
                }
            });
            this.mPopup = xxoxoooix;
        }
        com.sma.smartv3.pop.xxOXOOoIX xxoxoooix2 = this.mPopup;
        if (xxoxoooix2 != null) {
            xxoxoooix2.IIX0o(com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0().getInt(xXoOI00O.f23639oIX0oI, 0));
            xxoxoooix2.oI0IIXIo(R.id.root_view);
        }
    }

    public final void onQuery(@OXOo.OOXIXo View view) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(view, "view");
        com.sma.smartv3.pop.XoI0Ixx0 xoI0Ixx0 = new com.sma.smartv3.pop.XoI0Ixx0(this, 0, 2, null);
        xoI0Ixx0.Xx000oIo("当前：\n" + this.list.get(com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0().getInt(xXoOI00O.f23639oIX0oI, 0)));
        com.sma.smartv3.pop.XoI0Ixx0.IO(xoI0Ixx0, Integer.valueOf(R.string.cancel), null, 2, null);
        xoI0Ixx0.x0o(R.string.confirm, new Oox.oIX0oI<Boolean>() { // from class: com.sma.smartv3.ui.me.DeveloperTuyaQueryActivity$onQuery$1$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // Oox.oIX0oI
            @OXOo.OOXIXo
            public final Boolean invoke() {
                int i = com.sma.smartv3.util.Xo0.f24349oIX0oI.II0xO0().getInt(xXoOI00O.f23639oIX0oI, 0);
                if (i == 4) {
                    DeveloperTuyaQueryActivity.this.query(99);
                } else {
                    DeveloperTuyaQueryActivity.this.query(i);
                }
                return Boolean.TRUE;
            }
        });
        xoI0Ixx0.oI0IIXIo(R.id.root_view);
    }

    public final void query(int i) {
        if (this.mLoadingPopup == null) {
            com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo = new com.sma.smartv3.pop.I0X0x0oIo(getMContext());
            i0X0x0oIo.x0xO0oo(false);
            this.mLoadingPopup = i0X0x0oIo;
        }
        com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo2 = this.mLoadingPopup;
        if (i0X0x0oIo2 != null) {
            i0X0x0oIo2.IIXOooo();
        }
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap hashMap = new HashMap();
        String str = this.mName;
        final Activity activity = null;
        if (str == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mName");
            str = null;
        }
        hashMap.put("bleName", str);
        String str2 = this.mMac;
        if (str2 == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mMac");
            str2 = null;
        }
        hashMap.put("mac", str2);
        hashMap.put("queryStep", String.valueOf(i));
        final xxxI.II0xO0<String> iI0xO0 = new xxxI.II0xO0<String>() { // from class: com.sma.smartv3.ui.me.DeveloperTuyaQueryActivity$query$3
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo3;
                kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                ToastUtils.showLong(error, new Object[0]);
                i0X0x0oIo3 = DeveloperTuyaQueryActivity.this.mLoadingPopup;
                if (i0X0x0oIo3 != null) {
                    i0X0x0oIo3.dismiss();
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x007e  */
            /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void handleResponse(@OXOo.oOoXoXO java.lang.String r5) {
                /*
                    r4 = this;
                    com.sma.smartv3.ui.me.DeveloperTuyaQueryActivity r0 = com.sma.smartv3.ui.me.DeveloperTuyaQueryActivity.this
                    android.widget.TextView r0 = com.sma.smartv3.ui.me.DeveloperTuyaQueryActivity.access$getTvState(r0)
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    r1.append(r5)
                    r2 = 58
                    r1.append(r2)
                    if (r5 == 0) goto L6a
                    int r2 = r5.hashCode()
                    r3 = 48
                    if (r2 == r3) goto L5e
                    r3 = 49
                    if (r2 == r3) goto L52
                    r3 = 1444(0x5a4, float:2.023E-42)
                    if (r2 == r3) goto L46
                    r3 = 1445(0x5a5, float:2.025E-42)
                    if (r2 == r3) goto L3a
                    r3 = 1824(0x720, float:2.556E-42)
                    if (r2 == r3) goto L2e
                    goto L6a
                L2e:
                    java.lang.String r2 = "99"
                    boolean r5 = r5.equals(r2)
                    if (r5 != 0) goto L37
                    goto L6a
                L37:
                    java.lang.String r5 = "恢复了默认状态"
                    goto L6c
                L3a:
                    java.lang.String r2 = "-2"
                    boolean r5 = r5.equals(r2)
                    if (r5 != 0) goto L43
                    goto L6a
                L43:
                    java.lang.String r5 = "不支持"
                    goto L6c
                L46:
                    java.lang.String r2 = "-1"
                    boolean r5 = r5.equals(r2)
                    if (r5 != 0) goto L4f
                    goto L6a
                L4f:
                    java.lang.String r5 = "不存在授权码"
                    goto L6c
                L52:
                    java.lang.String r2 = "1"
                    boolean r5 = r5.equals(r2)
                    if (r5 != 0) goto L5b
                    goto L6a
                L5b:
                    java.lang.String r5 = "标记成功"
                    goto L6c
                L5e:
                    java.lang.String r2 = "0"
                    boolean r5 = r5.equals(r2)
                    if (r5 != 0) goto L67
                    goto L6a
                L67:
                    java.lang.String r5 = "已被标记"
                    goto L6c
                L6a:
                    java.lang.String r5 = "未知"
                L6c:
                    r1.append(r5)
                    java.lang.String r5 = r1.toString()
                    r0.setText(r5)
                    com.sma.smartv3.ui.me.DeveloperTuyaQueryActivity r5 = com.sma.smartv3.ui.me.DeveloperTuyaQueryActivity.this
                    com.sma.smartv3.pop.I0X0x0oIo r5 = com.sma.smartv3.ui.me.DeveloperTuyaQueryActivity.access$getMLoadingPopup$p(r5)
                    if (r5 == 0) goto L81
                    r5.dismiss()
                L81:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sma.smartv3.ui.me.DeveloperTuyaQueryActivity$query$3.handleResponse(java.lang.String):void");
            }
        };
        final com.sma.smartv3.pop.I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), oO.f23564II0xO0);
        netWorkUtils.printParam(convertBaseUrl + oO.f23564II0xO0, hashMap);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str3 = convertBaseUrl + oO.f23564II0xO0;
        final xxxI.II0xO0<Response<String>> iI0xO02 = new xxxI.II0xO0<Response<String>>() { // from class: com.sma.smartv3.ui.me.DeveloperTuyaQueryActivity$query$$inlined$post$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<String> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                Activity activity2 = activity;
                xxxI.II0xO0 iI0xO03 = iI0xO0;
                com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo3 = loadPopup;
                LogUtils.d(x0xO.XO.f34062II0XooXoX + response);
                if (response == null) {
                    response = new Response<>();
                    response.setCode(-1000);
                }
                netWorkUtils2.responseWhenCheck(activity2, response, iI0xO03);
                if (i0X0x0oIo3 != null) {
                    i0X0x0oIo3.dismiss();
                }
            }
        };
        AndroidNetworking.post(str3).addBodyParameter((Map<String, String>) hashMap).setTag((Object) str3).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, String.class), new ParsedRequestListener<Response<String>>() { // from class: com.sma.smartv3.ui.me.DeveloperTuyaQueryActivity$query$$inlined$post$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<String> response) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                Integer num;
                String str4;
                String str5;
                Response response;
                StringBuilder sb = new StringBuilder();
                sb.append("errorCode:");
                Integer num2 = null;
                if (aNError != null) {
                    num = Integer.valueOf(aNError.getErrorCode());
                } else {
                    num = null;
                }
                sb.append(num);
                sb.append(", errorBody:");
                if (aNError != null) {
                    str4 = aNError.getErrorBody();
                } else {
                    str4 = null;
                }
                sb.append(str4);
                sb.append(", ");
                if (aNError != null) {
                    str5 = aNError.getErrorDetail();
                } else {
                    str5 = null;
                }
                sb.append(str5);
                LogUtils.d(sb.toString());
                if (aNError != null && (response = (Response) aNError.getErrorAsObject(Response.class)) != null) {
                    num2 = Integer.valueOf(response.getCode());
                } else if (aNError != null) {
                    num2 = Integer.valueOf(aNError.getErrorCode());
                }
                xxxI.II0xO0.this.handleError(String.valueOf(num2));
            }
        });
    }

    public final void queryCount(int i) {
        String valueOf;
        if (this.mLoadingPopup == null) {
            com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo = new com.sma.smartv3.pop.I0X0x0oIo(getMContext());
            i0X0x0oIo.x0xO0oo(false);
            this.mLoadingPopup = i0X0x0oIo;
        }
        com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo2 = this.mLoadingPopup;
        if (i0X0x0oIo2 != null) {
            i0X0x0oIo2.IIXOooo();
        }
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap hashMap = new HashMap();
        String str = this.mName;
        final Activity activity = null;
        if (str == null) {
            kotlin.jvm.internal.IIX0o.XOxIOxOx("mName");
            str = null;
        }
        hashMap.put("bleName", str);
        if (i == 4) {
            valueOf = "99";
        } else {
            valueOf = String.valueOf(i);
        }
        hashMap.put("queryStep", valueOf);
        final xxxI.II0xO0<String> iI0xO0 = new xxxI.II0xO0<String>() { // from class: com.sma.smartv3.ui.me.DeveloperTuyaQueryActivity$queryCount$3
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo3;
                kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                ToastUtils.showLong(error, new Object[0]);
                i0X0x0oIo3 = DeveloperTuyaQueryActivity.this.mLoadingPopup;
                if (i0X0x0oIo3 != null) {
                    i0X0x0oIo3.dismiss();
                }
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO String str2) {
                com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo3;
                TextView tvCount;
                if (str2 != null) {
                    int parseInt = Integer.parseInt((String) StringsKt__StringsKt.XXoO0oX(str2, new String[]{","}, false, 0, 6, null).get(0));
                    int parseInt2 = Integer.parseInt((String) StringsKt__StringsKt.XXoO0oX(str2, new String[]{","}, false, 0, 6, null).get(1));
                    tvCount = DeveloperTuyaQueryActivity.this.getTvCount();
                    tvCount.setText("已使用：" + parseInt + "，未使用：" + (parseInt2 - parseInt) + "，总数：" + parseInt2);
                }
                i0X0x0oIo3 = DeveloperTuyaQueryActivity.this.mLoadingPopup;
                if (i0X0x0oIo3 != null) {
                    i0X0x0oIo3.dismiss();
                }
            }
        };
        final com.sma.smartv3.pop.I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), x0XOIxOo.f23608II0xO0);
        netWorkUtils.printParam(convertBaseUrl + x0XOIxOo.f23608II0xO0, hashMap);
        NetWork netWork = NetWork.f19682oIX0oI;
        String str2 = convertBaseUrl + x0XOIxOo.f23608II0xO0;
        final xxxI.II0xO0<Response<String>> iI0xO02 = new xxxI.II0xO0<Response<String>>() { // from class: com.sma.smartv3.ui.me.DeveloperTuyaQueryActivity$queryCount$$inlined$post$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<String> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                Activity activity2 = activity;
                xxxI.II0xO0 iI0xO03 = iI0xO0;
                com.sma.smartv3.pop.I0X0x0oIo i0X0x0oIo3 = loadPopup;
                LogUtils.d(x0xO.XO.f34062II0XooXoX + response);
                if (response == null) {
                    response = new Response<>();
                    response.setCode(-1000);
                }
                netWorkUtils2.responseWhenCheck(activity2, response, iI0xO03);
                if (i0X0x0oIo3 != null) {
                    i0X0x0oIo3.dismiss();
                }
            }
        };
        AndroidNetworking.post(str2).addBodyParameter((Map<String, String>) hashMap).setTag((Object) str2).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, String.class), new ParsedRequestListener<Response<String>>() { // from class: com.sma.smartv3.ui.me.DeveloperTuyaQueryActivity$queryCount$$inlined$post$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<String> response) {
                kotlin.jvm.internal.IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                Integer num;
                String str3;
                String str4;
                Response response;
                StringBuilder sb = new StringBuilder();
                sb.append("errorCode:");
                Integer num2 = null;
                if (aNError != null) {
                    num = Integer.valueOf(aNError.getErrorCode());
                } else {
                    num = null;
                }
                sb.append(num);
                sb.append(", errorBody:");
                if (aNError != null) {
                    str3 = aNError.getErrorBody();
                } else {
                    str3 = null;
                }
                sb.append(str3);
                sb.append(", ");
                if (aNError != null) {
                    str4 = aNError.getErrorDetail();
                } else {
                    str4 = null;
                }
                sb.append(str4);
                LogUtils.d(sb.toString());
                if (aNError != null && (response = (Response) aNError.getErrorAsObject(Response.class)) != null) {
                    num2 = Integer.valueOf(response.getCode());
                } else if (aNError != null) {
                    num2 = Integer.valueOf(aNError.getErrorCode());
                }
                xxxI.II0xO0.this.handleError(String.valueOf(num2));
            }
        });
    }
}
