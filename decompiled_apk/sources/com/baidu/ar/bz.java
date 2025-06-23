package com.baidu.ar;

import android.content.Context;
import com.baidu.ar.baidumap.MapDuMixParams;
import com.baidu.ar.baidumap.bean.CommandDate;
import com.baidu.ar.baidumap.bean.CommandType;
import com.baidu.ar.baidumap.bean.NavigationRes;
import com.baidu.ar.baidumap.bean.VpasArrow;
import com.baidu.ar.baidumap.bean.VpasDestination;
import com.baidu.ar.baidumap.bean.VpasResource;
import com.baidu.ar.content.ContentCloud;
import com.baidu.ar.content.IARCaseInfo;
import com.baidu.ar.content.IRequestCallback;
import com.baidu.ar.ihttp.HttpException;
import com.baidu.ar.ihttp.HttpFactory;
import com.baidu.ar.ihttp.IHttpRequest;
import com.baidu.ar.ihttp.IHttpResponse;
import com.baidu.ar.ihttp.IProgressCallback;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class bz {
    private DuMixController lF;
    private MapDuMixParams p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.ar.bz$5, reason: invalid class name */
    /* loaded from: classes7.dex */
    public /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] lI;

        static {
            int[] iArr = new int[CommandType.values().length];
            lI = iArr;
            try {
                iArr[CommandType.VPAS_DRAW_ARROW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                lI[CommandType.VPAS_REMOVE_ARROW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                lI[CommandType.VPAS_DESTINATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public bz(DuMixController duMixController, MapDuMixParams mapDuMixParams) {
        this.lF = duMixController;
        this.p = mapDuMixParams;
    }

    public void a(final Context context, String str, ca caVar) {
        IHttpRequest newRequest = HttpFactory.newRequest();
        if (newRequest == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("building_id", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        newRequest.setMethod("POST").setUrl(kw.hz()).setBody(jSONObject);
        newRequest.enqueue(new fa() { // from class: com.baidu.ar.bz.1
            @Override // com.baidu.ar.fa
            public void a(HttpException httpException) {
                kf.b("MapBusiness", "getNavigationRes request() fail!!!");
            }

            @Override // com.baidu.ar.fa
            public void a(IHttpResponse iHttpResponse) {
                List<NavigationRes> list;
                if (!iHttpResponse.isSuccess()) {
                    kf.b("MapBusiness", "getNavigationRes onResponse() fail!!!");
                    return;
                }
                try {
                    list = cc.P(iHttpResponse.getContent());
                } catch (Exception unused) {
                    kf.b("MapBusiness", "getNavigationRes onResponse() parse() error!!!");
                    list = null;
                }
                bz.this.a(list, context);
            }
        });
    }

    public void b(VpasArrow vpasArrow) {
    }

    public void doCommand(CommandType commandType, CommandDate commandDate) {
        int i = AnonymousClass5.lI[commandType.ordinal()];
        if (i == 1) {
            a((VpasArrow) commandDate);
        } else if (i == 2) {
            b((VpasArrow) commandDate);
        } else {
            if (i != 3) {
                return;
            }
            a((VpasDestination) commandDate);
        }
    }

    public void release() {
        this.lF = null;
    }

    public void a(VpasArrow vpasArrow) {
    }

    public void a(VpasDestination vpasDestination) {
    }

    public void a(String str, final ca caVar) {
        if (HttpFactory.newRequest() != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("session_id", str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            ni.a(kw.hA(), jSONObject, new fa() { // from class: com.baidu.ar.bz.4
                @Override // com.baidu.ar.fa
                public void a(HttpException httpException) {
                    httpException.printStackTrace();
                    kf.b("MapBusiness", "getVpasRes request() fail!!!");
                    ca caVar2 = caVar;
                    if (caVar2 != null) {
                        caVar2.a(false, httpException.getMessage(), null);
                    }
                }

                @Override // com.baidu.ar.fa
                public void a(IHttpResponse iHttpResponse) {
                    VpasResource vpasResource;
                    ca caVar2;
                    try {
                        try {
                            vpasResource = cc.R(iHttpResponse.getContent());
                        } catch (Exception unused) {
                            kf.b("MapBusiness", "getVpasRes onResponse() parse() error!!!");
                            vpasResource = null;
                        }
                        if (vpasResource == null || (caVar2 = caVar) == null) {
                            return;
                        }
                        caVar2.a(true, "success", vpasResource);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        kf.b("MapBusiness", "getVpasRes request() fail!!!");
                        ca caVar3 = caVar;
                        if (caVar3 != null) {
                            caVar3.a(false, e2.getMessage(), null);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<NavigationRes> list, Context context) {
        if (list == null || list.size() <= 0) {
            return;
        }
        ContentCloud contentCloud = new ContentCloud(context);
        Iterator<NavigationRes> it = list.iterator();
        while (it.hasNext()) {
            contentCloud.downloadCase(it.next().getArkey(), new IRequestCallback<IARCaseInfo>() { // from class: com.baidu.ar.bz.2
                @Override // com.baidu.ar.content.IRequestCallback
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onResponse(IARCaseInfo iARCaseInfo) {
                }

                @Override // com.baidu.ar.content.IRequestCallback
                public void onFail(int i, String str) {
                }
            }, new IProgressCallback() { // from class: com.baidu.ar.bz.3
                @Override // com.baidu.ar.ihttp.IProgressCallback
                public void onProgress(int i, int i2) {
                }
            });
        }
    }
}
