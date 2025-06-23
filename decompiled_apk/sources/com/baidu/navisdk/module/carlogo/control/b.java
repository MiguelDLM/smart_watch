package com.baidu.navisdk.module.carlogo.control;

import com.baidu.ar.constants.HttpConstants;
import com.baidu.navisdk.j;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.a0;
import com.baidu.navisdk.util.common.v;
import com.baidu.navisdk.util.http.center.i;
import com.baidu.navisdk.util.http.center.l;
import com.baidu.navisdk.util.worker.e;
import com.baidu.navisdk.util.worker.f;
import com.baidu.navisdk.util.worker.g;
import com.baidu.navisdk.vi.VDeviceAPI;
import com.baidu.nplatform.comapi.MapItem;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import o0oIxXOx.oO;

/* loaded from: classes7.dex */
public class b implements com.baidu.navisdk.module.carlogo.interfaces.a {

    /* renamed from: a, reason: collision with root package name */
    private com.baidu.navisdk.util.http.custom.b f7063a;

    /* renamed from: com.baidu.navisdk.module.carlogo.control.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0233b extends f<String, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f7065a;
        final /* synthetic */ com.baidu.navisdk.module.carlogo.listeners.c b;
        final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0233b(String str, String str2, String str3, com.baidu.navisdk.module.carlogo.listeners.c cVar, String str4) {
            super(str, str2);
            this.f7065a = str3;
            this.b = cVar;
            this.c = str4;
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            if (b.this.f7063a == null) {
                return null;
            }
            b.this.f7063a.a(this.f7065a, new a(), new File(this.c));
            return null;
        }

        /* renamed from: com.baidu.navisdk.module.carlogo.control.b$b$a */
        /* loaded from: classes7.dex */
        public class a implements com.baidu.navisdk.util.http.custom.listeners.a {
            public a() {
            }

            @Override // com.baidu.navisdk.util.http.custom.listeners.a
            public void a(String str, File file, String str2) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e(g.TAG, "onDownloadFailed: " + str + ", error:" + str2);
                }
                if (file != null) {
                    try {
                        if (file.exists()) {
                            file.delete();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        LogUtil.printCallStack();
                    }
                }
                com.baidu.navisdk.module.carlogo.listeners.c cVar = C0233b.this.b;
                if (cVar != null) {
                    cVar.a(str);
                }
            }

            @Override // com.baidu.navisdk.util.http.custom.listeners.a
            public void a(String str, File file) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e(g.TAG, "onDownloadSuccess: " + str);
                }
                com.baidu.navisdk.module.carlogo.listeners.c cVar = C0233b.this.b;
                if (cVar != null) {
                    cVar.a(str, file.getPath());
                }
            }

            @Override // com.baidu.navisdk.util.http.custom.listeners.a
            public void a(String str, long j, long j2) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.e(g.TAG, "onDownloadProgress: " + j + "/" + j2);
                }
                com.baidu.navisdk.module.carlogo.listeners.c cVar = C0233b.this.b;
                if (cVar != null) {
                    cVar.a(j2 <= 0 ? 0 : (int) (((((float) j) * 1.0f) / ((float) j2)) * 100.0f), str);
                }
            }
        }
    }

    private void b(List<l> list, StringBuilder sb) {
        list.add(new i(HttpConstants.SIGN, v.b("mop" + com.baidu.navisdk.module.cloudconfig.d.a(list) + "6456bc093ca827bf3db43fb106fb2624").toLowerCase()));
    }

    /* loaded from: classes7.dex */
    public class c extends com.baidu.navisdk.util.http.center.f {
        public c(b bVar) {
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, String str, Throwable th) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BN3DDataHttpImplV2", "set3DCarLogo.onFail statusCode: " + i + ", responseString:" + str);
            }
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, String str) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BN3DDataHttpImplV2", "set3DCarLogo.onSuccess statusCode: " + i + ", responseString:" + str);
            }
        }
    }

    @Override // com.baidu.navisdk.module.carlogo.interfaces.a
    public void a(String str, com.baidu.navisdk.module.carlogo.listeners.d dVar, int i) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BN3DDataHttpImplV2", "request3DListData(), url = " + str + ", vehicle:" + i);
        }
        if (dVar != null) {
            dVar.onStart();
        }
        com.baidu.navisdk.util.http.center.b.a().a(str, a(i + ""), new a(this, dVar), null);
    }

    /* loaded from: classes7.dex */
    public class a extends com.baidu.navisdk.util.http.center.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.baidu.navisdk.module.carlogo.listeners.d f7064a;

        public a(b bVar, com.baidu.navisdk.module.carlogo.listeners.d dVar) {
            this.f7064a = dVar;
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, String str, Throwable th) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BN3DDataHttpImplV2", "request3DList.onFailure, statusCode = " + i + " responseString = " + str);
            }
            com.baidu.navisdk.module.carlogo.listeners.d dVar = this.f7064a;
            if (dVar != null) {
                dVar.onFailed();
            }
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, String str) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BN3DDataHttpImplV2", "request3DList.onSuccess, statusCode = " + i + " responseString = " + str);
            }
            com.baidu.navisdk.module.carlogo.listeners.d dVar = this.f7064a;
            if (dVar != null) {
                dVar.a(str);
            }
        }
    }

    @Override // com.baidu.navisdk.module.carlogo.interfaces.a
    public void a(String str, com.baidu.navisdk.module.carlogo.listeners.c cVar, String str2) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BN3DDataHttpImplV2", "asyncDownload3DZipFile(), url = " + str + " targetFilePath = " + str2);
        }
        a();
        com.baidu.navisdk.util.worker.c.a().c(new C0233b("asyncDownload3DZipFile", null, str, cVar, str2), new e(99, 0));
    }

    @Override // com.baidu.navisdk.module.carlogo.interfaces.a
    public void a(String str, int i, String str2) {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BN3DDataHttpImplV2", "set3DCarLogo: carId:" + i + ", color:" + str2 + ", url:" + str);
        }
        com.baidu.navisdk.util.http.center.b.a().b(str, a(i, str2), new c(this), null);
    }

    @Override // com.baidu.navisdk.module.carlogo.interfaces.a
    public boolean a(String str, com.baidu.navisdk.module.carlogo.listeners.b bVar) {
        com.baidu.navisdk.util.http.custom.b bVar2 = this.f7063a;
        if (bVar2 != null) {
            return bVar2.a(str);
        }
        return false;
    }

    private void a() {
        if (this.f7063a == null) {
            synchronized (this) {
                try {
                    if (this.f7063a == null) {
                        this.f7063a = new com.baidu.navisdk.util.http.custom.a();
                    }
                } finally {
                }
            }
        }
    }

    private HashMap<String, String> a(int i, String str) {
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        try {
            a(arrayList, sb);
            arrayList.add(new i("car_id", i + ""));
            sb.append("&car_id=");
            sb.append(URLEncoder.encode(i + "", "utf-8"));
            arrayList.add(new i("used_color_id", str));
            sb.append("&used_color_id=");
            sb.append(URLEncoder.encode(str, "utf-8"));
        } catch (Exception e) {
            LogUtil.printCallStack();
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BN3DDataHttpImplV2", "getSetCarLogoParams: " + e.getMessage());
            }
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BN3DDataHttpImplV2", "getSetCarLogoParams: " + sb.toString());
        }
        b(arrayList, sb);
        return com.baidu.navisdk.util.http.center.c.a(arrayList);
    }

    private HashMap<String, String> a(String str) {
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        try {
            a(arrayList, sb);
            arrayList.add(new i("only3d", "1"));
            sb.append("&only3d=");
            sb.append(URLEncoder.encode("1", "utf-8"));
            arrayList.add(new i("vehicle", str));
            sb.append("&vehicle=");
            sb.append(URLEncoder.encode(str, "utf-8"));
        } catch (Exception e) {
            LogUtil.printCallStack();
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BN3DDataHttpImplV2", "getRequestListParams: " + e.getMessage());
            }
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BN3DDataHttpImplV2", "getRequestListParams: " + sb.toString());
        }
        b(arrayList, sb);
        return com.baidu.navisdk.util.http.center.c.a(arrayList);
    }

    private void a(List<l> list, StringBuilder sb) throws UnsupportedEncodingException {
        int i = com.baidu.navisdk.model.a.g().d() != null ? com.baidu.navisdk.model.a.g().d().b : 0;
        list.add(new i("cityCode", "" + i));
        sb.append("&cityCode=");
        sb.append(URLEncoder.encode("" + i, "utf-8"));
        list.add(new i("cuid", a0.e()));
        sb.append("&cuid=");
        sb.append(URLEncoder.encode(a0.e(), "utf-8"));
        list.add(new i("mb", VDeviceAPI.getPhoneType()));
        sb.append("&mb=");
        sb.append(URLEncoder.encode(VDeviceAPI.getPhoneType(), "utf-8"));
        list.add(new i(oO.f31192XO, "android"));
        sb.append("&os=");
        sb.append(URLEncoder.encode("android", "utf-8"));
        list.add(new i("osv", VDeviceAPI.getOsVersion()));
        sb.append("&osv=");
        sb.append(URLEncoder.encode(VDeviceAPI.getOsVersion(), "utf-8"));
        list.add(new i(MapItem.KEY_ITEM_SID, j.d() ? "1" : "2"));
        sb.append("&sid=");
        sb.append(URLEncoder.encode(j.d() ? "1" : "2", "utf-8"));
        list.add(new i("sv", a0.k()));
        sb.append("&sv=");
        sb.append(URLEncoder.encode(a0.k(), "utf-8"));
        com.baidu.navisdk.util.http.a.a(list);
    }
}
