package com.sma.smartv3.biz;

import android.app.Activity;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.blankj.utilcode.util.LogUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sma.androidnetworklib.method.HttpProgressCallback;
import com.sma.androidnetworklib.method.NetWork;
import com.sma.androidnetworklib.model.Response;
import com.sma.smartv3.initializer.IXxxXO;
import com.sma.smartv3.model.CourSelectByType;
import com.sma.smartv3.model.CourseDetails;
import com.sma.smartv3.model.CourseList;
import com.sma.smartv3.model.CourseType;
import com.sma.smartv3.model.RecommendSearch;
import com.sma.smartv3.network.Api;
import com.sma.smartv3.network.CourseCollect;
import com.sma.smartv3.network.GetChoicenessSearchList;
import com.sma.smartv3.network.GetCourSelectByType;
import com.sma.smartv3.network.GetCourseCollectList;
import com.sma.smartv3.network.GetCourseDetailsList;
import com.sma.smartv3.network.GetCourseList;
import com.sma.smartv3.network.GetRecommendSearchList;
import com.sma.smartv3.network.NetWorkUtils;
import com.sma.smartv3.network.RequestBodyKt;
import com.sma.smartv3.pop.I0X0x0oIo;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import java.util.HashMap;
import java.util.Map;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.o0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nCourseManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CourseManager.kt\ncom/sma/smartv3/biz/CourseManager\n+ 2 NetWorkUtils.kt\ncom/sma/smartv3/network/NetWorkUtils\n+ 3 NetWork.kt\ncom/sma/androidnetworklib/method/NetWork\n*L\n1#1,316:1\n173#2,12:317\n194#2:338\n173#2,12:339\n194#2:360\n173#2,12:361\n194#2:382\n173#2,12:383\n194#2:404\n128#2,12:405\n149#2:426\n128#2,12:427\n149#2:448\n173#2,12:449\n194#2:470\n173#2,12:471\n194#2:492\n234#3,8:329\n254#3:337\n234#3,8:351\n254#3:359\n234#3,8:373\n254#3:381\n234#3,8:395\n254#3:403\n182#3,8:417\n201#3:425\n182#3,8:439\n201#3:447\n234#3,8:461\n254#3:469\n234#3,8:483\n254#3:491\n*S KotlinDebug\n*F\n+ 1 CourseManager.kt\ncom/sma/smartv3/biz/CourseManager\n*L\n42#1:317,12\n42#1:338\n74#1:339,12\n74#1:360\n103#1:361,12\n103#1:382\n142#1:383,12\n142#1:404\n180#1:405,12\n180#1:426\n210#1:427,12\n210#1:448\n241#1:449,12\n241#1:470\n262#1:471,12\n262#1:492\n42#1:329,8\n42#1:337\n74#1:351,8\n74#1:359\n103#1:373,8\n103#1:381\n142#1:395,8\n142#1:403\n180#1:417,8\n180#1:425\n210#1:439,8\n210#1:447\n241#1:461,8\n241#1:469\n262#1:483,8\n262#1:491\n*E\n"})
/* loaded from: classes12.dex */
public final class CourseManager {

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final String f19939II0xO0 = "CourseManager";

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final CourseManager f19940oIX0oI = new CourseManager();

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void II0XooXoX(CourseManager courseManager, String str, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "INDEX";
        }
        if ((i & 2) != 0) {
            oooxoxo = null;
        }
        courseManager.Oxx0IOOO(str, oooxoxo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void II0xO0(CourseManager courseManager, String str, String str2, boolean z, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 8) != 0) {
            oooxoxo = null;
        }
        courseManager.oIX0oI(str, str2, z, oooxoxo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void IXxxXO(CourseManager courseManager, String str, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "INDEX";
        }
        if ((i & 2) != 0) {
            oooxoxo = null;
        }
        courseManager.Oo(str, oooxoxo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void XO(CourseManager courseManager, String str, String str2, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 4) != 0) {
            oooxoxo = null;
        }
        courseManager.X0o0xo(str, str2, oooxoxo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void oOoXoXO(CourseManager courseManager, String str, String str2, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 4) != 0) {
            oooxoxo = null;
        }
        courseManager.OOXIXo(str, str2, oooxoxo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void oxoX(CourseManager courseManager, String str, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 2) != 0) {
            oooxoxo = null;
        }
        courseManager.I0Io(str, oooxoxo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void x0XOIxOo(CourseManager courseManager, String str, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "course_type";
        }
        if ((i & 2) != 0) {
            oooxoxo = null;
        }
        courseManager.ooOOo0oXI(str, oooxoxo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void x0xO0oo(CourseManager courseManager, String str, String str2, String str3, String str4, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 8) != 0) {
            str4 = null;
        }
        if ((i & 16) != 0) {
            oooxoxo = null;
        }
        courseManager.oO(str, str2, str3, str4, oooxoxo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void xoIox(CourseManager courseManager, String str, Oox.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 1) != 0) {
            str = GetCourSelectByType.COURSE_DIFF;
        }
        if ((i & 2) != 0) {
            oooxoxo = null;
        }
        courseManager.xxIXOIIO(str, oooxoxo);
    }

    public final void I0Io(@OXOo.OOXIXo String uid, @OXOo.oOoXoXO final Oox.oOoXoXO<? super CourseList[], oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(uid, "uid");
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> courseCollectList = RequestBodyKt.getCourseCollectList(uid);
        final xxxI.II0xO0<CourseList[]> iI0xO0 = new xxxI.II0xO0<CourseList[]>() { // from class: com.sma.smartv3.biz.CourseManager$courseCollectList$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                LogUtils.d("courseCollect -> " + error);
                Oox.oOoXoXO<CourseList[], oXIO0o0XI> oooxoxo2 = oooxoxo;
                if (oooxoxo2 != null) {
                    oooxoxo2.invoke(null);
                }
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO CourseList[] courseListArr) {
                LogUtils.d("courseCollect ");
                try {
                    Oox.oOoXoXO<CourseList[], oXIO0o0XI> oooxoxo2 = oooxoxo;
                    if (oooxoxo2 != null) {
                        oooxoxo2.invoke(courseListArr);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Oox.oOoXoXO<CourseList[], oXIO0o0XI> oooxoxo3 = oooxoxo;
                    if (oooxoxo3 != null) {
                        oooxoxo3.invoke(null);
                    }
                }
            }
        };
        Map<String, String> headersMap = netWorkUtils.getHeadersMap();
        final Activity activity = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), GetCourseCollectList.URL);
        netWorkUtils.printParam(convertBaseUrl + GetCourseCollectList.URL, o0.xoIxX(courseCollectList, headersMap));
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + GetCourseCollectList.URL;
        final xxxI.II0xO0<Response<CourseList[]>> iI0xO02 = new xxxI.II0xO0<Response<CourseList[]>>() { // from class: com.sma.smartv3.biz.CourseManager$courseCollectList$$inlined$postV2$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<CourseList[]> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                Activity activity2 = activity;
                xxxI.II0xO0 iI0xO03 = iI0xO0;
                I0X0x0oIo i0X0x0oIo = loadPopup;
                LogUtils.d(x0xO.XO.f34062II0XooXoX + response);
                if (response == null) {
                    response = new Response<>();
                    response.setCode(-1000);
                }
                netWorkUtils2.responseWhenCheck(activity2, response, iI0xO03);
                if (i0X0x0oIo != null) {
                    i0X0x0oIo.dismiss();
                }
            }
        };
        AndroidNetworking.post(str).addHeaders(headersMap).addBodyParameter((Map<String, String>) courseCollectList).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, CourseList[].class), new ParsedRequestListener<Response<CourseList[]>>() { // from class: com.sma.smartv3.biz.CourseManager$courseCollectList$$inlined$postV2$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<CourseList[]> response) {
                IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                Integer num;
                String str2;
                String str3;
                String str4;
                Response response;
                if (aNError != null) {
                    aNError.printStackTrace();
                }
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
                    str2 = aNError.getErrorBody();
                } else {
                    str2 = null;
                }
                sb.append(str2);
                sb.append(", errorDetail:");
                if (aNError != null) {
                    str3 = aNError.getErrorDetail();
                } else {
                    str3 = null;
                }
                sb.append(str3);
                sb.append(", exception:");
                if (aNError != null) {
                    str4 = aNError.getLocalizedMessage();
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

    public final void OOXIXo(@OXOo.OOXIXo String id, @OXOo.OOXIXo String uid, @OXOo.oOoXoXO final Oox.oOoXoXO<? super CourseDetails, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(id, "id");
        IIX0o.x0xO0oo(uid, "uid");
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> courseDetailsBody = RequestBodyKt.getCourseDetailsBody(id, uid);
        final xxxI.II0xO0<CourseDetails> iI0xO0 = new xxxI.II0xO0<CourseDetails>() { // from class: com.sma.smartv3.biz.CourseManager$getCourseDetails$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                LogUtils.d("getCourseDetails -> " + error);
                Oox.oOoXoXO<CourseDetails, oXIO0o0XI> oooxoxo2 = oooxoxo;
                if (oooxoxo2 != null) {
                    oooxoxo2.invoke(null);
                }
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO CourseDetails courseDetails) {
                LogUtils.d("getCourseDetails -> " + courseDetails);
                try {
                    Oox.oOoXoXO<CourseDetails, oXIO0o0XI> oooxoxo2 = oooxoxo;
                    if (oooxoxo2 != null) {
                        oooxoxo2.invoke(courseDetails);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Oox.oOoXoXO<CourseDetails, oXIO0o0XI> oooxoxo3 = oooxoxo;
                    if (oooxoxo3 != null) {
                        oooxoxo3.invoke(null);
                    }
                }
            }
        };
        Map<String, String> headersMap = netWorkUtils.getHeadersMap();
        final Activity activity = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), GetCourseDetailsList.URL);
        netWorkUtils.printParam(convertBaseUrl + GetCourseDetailsList.URL, o0.xoIxX(courseDetailsBody, headersMap));
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + GetCourseDetailsList.URL;
        final xxxI.II0xO0<Response<CourseDetails>> iI0xO02 = new xxxI.II0xO0<Response<CourseDetails>>() { // from class: com.sma.smartv3.biz.CourseManager$getCourseDetails$$inlined$postV2$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<CourseDetails> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                Activity activity2 = activity;
                xxxI.II0xO0 iI0xO03 = iI0xO0;
                I0X0x0oIo i0X0x0oIo = loadPopup;
                LogUtils.d(x0xO.XO.f34062II0XooXoX + response);
                if (response == null) {
                    response = new Response<>();
                    response.setCode(-1000);
                }
                netWorkUtils2.responseWhenCheck(activity2, response, iI0xO03);
                if (i0X0x0oIo != null) {
                    i0X0x0oIo.dismiss();
                }
            }
        };
        AndroidNetworking.post(str).addHeaders(headersMap).addBodyParameter((Map<String, String>) courseDetailsBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, CourseDetails.class), new ParsedRequestListener<Response<CourseDetails>>() { // from class: com.sma.smartv3.biz.CourseManager$getCourseDetails$$inlined$postV2$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<CourseDetails> response) {
                IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                Integer num;
                String str2;
                String str3;
                String str4;
                Response response;
                if (aNError != null) {
                    aNError.printStackTrace();
                }
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
                    str2 = aNError.getErrorBody();
                } else {
                    str2 = null;
                }
                sb.append(str2);
                sb.append(", errorDetail:");
                if (aNError != null) {
                    str3 = aNError.getErrorDetail();
                } else {
                    str3 = null;
                }
                sb.append(str3);
                sb.append(", exception:");
                if (aNError != null) {
                    str4 = aNError.getLocalizedMessage();
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

    public final void Oo(@OXOo.OOXIXo String type, @OXOo.oOoXoXO final Oox.oOoXoXO<? super RecommendSearch[], oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(type, "type");
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> choicenessSearchListBody = RequestBodyKt.getChoicenessSearchListBody(type);
        final xxxI.II0xO0<RecommendSearch[]> iI0xO0 = new xxxI.II0xO0<RecommendSearch[]>() { // from class: com.sma.smartv3.biz.CourseManager$getRecommendSearchListList$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                LogUtils.d("getCourseDetails -> " + error);
                Oox.oOoXoXO<RecommendSearch[], oXIO0o0XI> oooxoxo2 = oooxoxo;
                if (oooxoxo2 != null) {
                    oooxoxo2.invoke(null);
                }
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO RecommendSearch[] recommendSearchArr) {
                boolean z = true;
                LogUtils.d("getCourseDetails -> " + recommendSearchArr);
                if (recommendSearchArr != null) {
                    try {
                        if (recommendSearchArr.length != 0) {
                            z = false;
                        }
                        if (!z) {
                            recommendSearchArr[0].setOnCreateTime(System.currentTimeMillis());
                        }
                        Xo0.f24349oIX0oI.X0o0xo().put(XoI0Ixx0.f24477xI0oxI00, new Gson().toJson(ArraysKt___ArraysKt.X0XOOO(recommendSearchArr)));
                    } catch (Exception e) {
                        e.printStackTrace();
                        Oox.oOoXoXO<RecommendSearch[], oXIO0o0XI> oooxoxo2 = oooxoxo;
                        if (oooxoxo2 != null) {
                            oooxoxo2.invoke(null);
                            return;
                        }
                        return;
                    }
                }
                Oox.oOoXoXO<RecommendSearch[], oXIO0o0XI> oooxoxo3 = oooxoxo;
                if (oooxoxo3 != null) {
                    oooxoxo3.invoke(recommendSearchArr);
                }
            }
        };
        Map<String, String> headersMap = netWorkUtils.getHeadersMap();
        final Activity activity = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), GetRecommendSearchList.URL);
        netWorkUtils.printParam(convertBaseUrl + GetRecommendSearchList.URL, o0.xoIxX(choicenessSearchListBody, headersMap));
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + GetRecommendSearchList.URL;
        final xxxI.II0xO0<Response<RecommendSearch[]>> iI0xO02 = new xxxI.II0xO0<Response<RecommendSearch[]>>() { // from class: com.sma.smartv3.biz.CourseManager$getRecommendSearchListList$$inlined$postV2$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<RecommendSearch[]> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                Activity activity2 = activity;
                xxxI.II0xO0 iI0xO03 = iI0xO0;
                I0X0x0oIo i0X0x0oIo = loadPopup;
                LogUtils.d(x0xO.XO.f34062II0XooXoX + response);
                if (response == null) {
                    response = new Response<>();
                    response.setCode(-1000);
                }
                netWorkUtils2.responseWhenCheck(activity2, response, iI0xO03);
                if (i0X0x0oIo != null) {
                    i0X0x0oIo.dismiss();
                }
            }
        };
        AndroidNetworking.post(str).addHeaders(headersMap).addBodyParameter((Map<String, String>) choicenessSearchListBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, RecommendSearch[].class), new ParsedRequestListener<Response<RecommendSearch[]>>() { // from class: com.sma.smartv3.biz.CourseManager$getRecommendSearchListList$$inlined$postV2$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<RecommendSearch[]> response) {
                IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                Integer num;
                String str2;
                String str3;
                String str4;
                Response response;
                if (aNError != null) {
                    aNError.printStackTrace();
                }
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
                    str2 = aNError.getErrorBody();
                } else {
                    str2 = null;
                }
                sb.append(str2);
                sb.append(", errorDetail:");
                if (aNError != null) {
                    str3 = aNError.getErrorDetail();
                } else {
                    str3 = null;
                }
                sb.append(str3);
                sb.append(", exception:");
                if (aNError != null) {
                    str4 = aNError.getLocalizedMessage();
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

    public final void Oxx0IOOO(@OXOo.OOXIXo String type, @OXOo.oOoXoXO final Oox.oOoXoXO<? super CourseList[], oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(type, "type");
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> choicenessSearchListBody = RequestBodyKt.getChoicenessSearchListBody(type);
        final xxxI.II0xO0<CourseList[]> iI0xO0 = new xxxI.II0xO0<CourseList[]>() { // from class: com.sma.smartv3.biz.CourseManager$getChoicenessSearchList$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                LogUtils.d("getCourseDetails -> " + error);
                Oox.oOoXoXO<CourseList[], oXIO0o0XI> oooxoxo2 = oooxoxo;
                if (oooxoxo2 != null) {
                    oooxoxo2.invoke(null);
                }
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO CourseList[] courseListArr) {
                boolean z = true;
                LogUtils.d("getCourseDetails -> " + courseListArr);
                if (courseListArr != null) {
                    try {
                        if (courseListArr.length != 0) {
                            z = false;
                        }
                        if (!z) {
                            courseListArr[0].setOnSaveTime(System.currentTimeMillis());
                        }
                        Xo0.f24349oIX0oI.X0o0xo().put(XoI0Ixx0.f24494xx0X0, new Gson().toJson(ArraysKt___ArraysKt.X0XOOO(courseListArr)));
                    } catch (Exception e) {
                        e.printStackTrace();
                        Oox.oOoXoXO<CourseList[], oXIO0o0XI> oooxoxo2 = oooxoxo;
                        if (oooxoxo2 != null) {
                            oooxoxo2.invoke(null);
                            return;
                        }
                        return;
                    }
                }
                Oox.oOoXoXO<CourseList[], oXIO0o0XI> oooxoxo3 = oooxoxo;
                if (oooxoxo3 != null) {
                    oooxoxo3.invoke(courseListArr);
                }
            }
        };
        Map<String, String> headersMap = netWorkUtils.getHeadersMap();
        final Activity activity = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), GetChoicenessSearchList.URL);
        netWorkUtils.printParam(convertBaseUrl + GetChoicenessSearchList.URL, o0.xoIxX(choicenessSearchListBody, headersMap));
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + GetChoicenessSearchList.URL;
        final xxxI.II0xO0<Response<CourseList[]>> iI0xO02 = new xxxI.II0xO0<Response<CourseList[]>>() { // from class: com.sma.smartv3.biz.CourseManager$getChoicenessSearchList$$inlined$postV2$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<CourseList[]> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                Activity activity2 = activity;
                xxxI.II0xO0 iI0xO03 = iI0xO0;
                I0X0x0oIo i0X0x0oIo = loadPopup;
                LogUtils.d(x0xO.XO.f34062II0XooXoX + response);
                if (response == null) {
                    response = new Response<>();
                    response.setCode(-1000);
                }
                netWorkUtils2.responseWhenCheck(activity2, response, iI0xO03);
                if (i0X0x0oIo != null) {
                    i0X0x0oIo.dismiss();
                }
            }
        };
        AndroidNetworking.post(str).addHeaders(headersMap).addBodyParameter((Map<String, String>) choicenessSearchListBody).setTag((Object) str).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, CourseList[].class), new ParsedRequestListener<Response<CourseList[]>>() { // from class: com.sma.smartv3.biz.CourseManager$getChoicenessSearchList$$inlined$postV2$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<CourseList[]> response) {
                IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                Integer num;
                String str2;
                String str3;
                String str4;
                Response response;
                if (aNError != null) {
                    aNError.printStackTrace();
                }
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
                    str2 = aNError.getErrorBody();
                } else {
                    str2 = null;
                }
                sb.append(str2);
                sb.append(", errorDetail:");
                if (aNError != null) {
                    str3 = aNError.getErrorDetail();
                } else {
                    str3 = null;
                }
                sb.append(str3);
                sb.append(", exception:");
                if (aNError != null) {
                    str4 = aNError.getLocalizedMessage();
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

    public final void X0o0xo(@OXOo.OOXIXo String fileUrl, @OXOo.OOXIXo String fileName, @OXOo.oOoXoXO final Oox.oOoXoXO<? super Integer, oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(fileUrl, "fileUrl");
        IIX0o.x0xO0oo(fileName, "fileName");
        if (fileUrl.length() == 0) {
            if (oooxoxo != null) {
                oooxoxo.invoke(-1);
            }
        } else {
            final Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = -1;
            NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
            String absolutePath = IXxxXO.XX0(X00IoxXI.oIX0oI.f3233oIX0oI).getAbsolutePath();
            IIX0o.oO(absolutePath, "getAbsolutePath(...)");
            netWorkUtils.download(fileUrl, absolutePath, fileName, new HttpProgressCallback<String>() { // from class: com.sma.smartv3.biz.CourseManager$downloadCourse$1
                @Override // xxxI.II0xO0
                public void handleError(@OXOo.OOXIXo String error) {
                    IIX0o.x0xO0oo(error, "error");
                    Oox.oOoXoXO<Integer, oXIO0o0XI> oooxoxo2 = oooxoxo;
                    if (oooxoxo2 != null) {
                        oooxoxo2.invoke(-1);
                    }
                }

                @Override // com.sma.androidnetworklib.method.HttpProgressCallback
                public void handleProgress(int i) {
                    Ref.IntRef intRef2 = Ref.IntRef.this;
                    if (intRef2.element != i) {
                        intRef2.element = i;
                        Oox.oOoXoXO<Integer, oXIO0o0XI> oooxoxo2 = oooxoxo;
                        if (oooxoxo2 != null) {
                            oooxoxo2.invoke(Integer.valueOf(i));
                        }
                    }
                }

                @Override // xxxI.II0xO0
                /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
                public void handleResponse(@OXOo.oOoXoXO String str) {
                    Oox.oOoXoXO<Integer, oXIO0o0XI> oooxoxo2 = oooxoxo;
                    if (oooxoxo2 != null) {
                        oooxoxo2.invoke(101);
                    }
                }
            });
        }
    }

    public final void oIX0oI(@OXOo.OOXIXo String cid, @OXOo.OOXIXo String uid, boolean z, @OXOo.oOoXoXO final Oox.oOoXoXO<? super String, oXIO0o0XI> oooxoxo) {
        String str;
        IIX0o.x0xO0oo(cid, "cid");
        IIX0o.x0xO0oo(uid, "uid");
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        if (z) {
            str = Api.Y;
        } else {
            str = "N";
        }
        HashMap<String, String> courseCollectBody = RequestBodyKt.getCourseCollectBody(cid, uid, str);
        final xxxI.II0xO0<CourseList> iI0xO0 = new xxxI.II0xO0<CourseList>() { // from class: com.sma.smartv3.biz.CourseManager$courseCollect$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                LogUtils.d("courseCollect -> " + error);
                Oox.oOoXoXO<String, oXIO0o0XI> oooxoxo2 = oooxoxo;
                if (oooxoxo2 != null) {
                    oooxoxo2.invoke(error);
                }
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO CourseList courseList) {
                LogUtils.d("courseCollect ");
                Oox.oOoXoXO<String, oXIO0o0XI> oooxoxo2 = oooxoxo;
                if (oooxoxo2 != null) {
                    oooxoxo2.invoke("");
                }
            }
        };
        Map<String, String> headersMap = netWorkUtils.getHeadersMap();
        final Activity activity = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), CourseCollect.URL);
        netWorkUtils.printParam(convertBaseUrl + CourseCollect.URL, o0.xoIxX(courseCollectBody, headersMap));
        NetWork netWork = NetWork.f19682oIX0oI;
        String str2 = convertBaseUrl + CourseCollect.URL;
        final xxxI.II0xO0<Response<CourseList>> iI0xO02 = new xxxI.II0xO0<Response<CourseList>>() { // from class: com.sma.smartv3.biz.CourseManager$courseCollect$$inlined$postV2$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<CourseList> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                Activity activity2 = activity;
                xxxI.II0xO0 iI0xO03 = iI0xO0;
                I0X0x0oIo i0X0x0oIo = loadPopup;
                LogUtils.d(x0xO.XO.f34062II0XooXoX + response);
                if (response == null) {
                    response = new Response<>();
                    response.setCode(-1000);
                }
                netWorkUtils2.responseWhenCheck(activity2, response, iI0xO03);
                if (i0X0x0oIo != null) {
                    i0X0x0oIo.dismiss();
                }
            }
        };
        AndroidNetworking.post(str2).addHeaders(headersMap).addBodyParameter((Map<String, String>) courseCollectBody).setTag((Object) str2).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, CourseList.class), new ParsedRequestListener<Response<CourseList>>() { // from class: com.sma.smartv3.biz.CourseManager$courseCollect$$inlined$postV2$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<CourseList> response) {
                IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                Integer num;
                String str3;
                String str4;
                String str5;
                Response response;
                if (aNError != null) {
                    aNError.printStackTrace();
                }
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
                sb.append(", errorDetail:");
                if (aNError != null) {
                    str4 = aNError.getErrorDetail();
                } else {
                    str4 = null;
                }
                sb.append(str4);
                sb.append(", exception:");
                if (aNError != null) {
                    str5 = aNError.getLocalizedMessage();
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

    public final void oO(@OXOo.oOoXoXO String str, @OXOo.oOoXoXO String str2, @OXOo.oOoXoXO String str3, @OXOo.oOoXoXO String str4, @OXOo.oOoXoXO final Oox.oOoXoXO<? super Boolean, oXIO0o0XI> oooxoxo) {
        LogUtils.i("getOnLineCourseList -> " + str + ", " + str2 + ", " + str3 + ", " + str4);
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> courseBody = RequestBodyKt.getCourseBody(str, str2, str3, str4);
        final xxxI.II0xO0<CourseList[]> iI0xO0 = new xxxI.II0xO0<CourseList[]>() { // from class: com.sma.smartv3.biz.CourseManager$getOnLineCourseList$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                LogUtils.d("getOnLinWatchFaceList -> " + error);
                Oox.oOoXoXO<Boolean, oXIO0o0XI> oooxoxo2 = oooxoxo;
                if (oooxoxo2 != null) {
                    oooxoxo2.invoke(Boolean.FALSE);
                }
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO CourseList[] courseListArr) {
                Integer num;
                StringBuilder sb = new StringBuilder();
                sb.append("getOnLineCourseList -> ");
                if (courseListArr != null) {
                    num = Integer.valueOf(courseListArr.length);
                } else {
                    num = null;
                }
                sb.append(num);
                LogUtils.d(sb.toString());
                if (courseListArr != null) {
                    try {
                        Xo0.f24349oIX0oI.X0o0xo().put(XoI0Ixx0.f24377O0, new Gson().toJson(ArraysKt___ArraysKt.X0XOOO(courseListArr)));
                    } catch (Exception e) {
                        e.printStackTrace();
                        Oox.oOoXoXO<Boolean, oXIO0o0XI> oooxoxo2 = oooxoxo;
                        if (oooxoxo2 != null) {
                            oooxoxo2.invoke(Boolean.FALSE);
                            return;
                        }
                        return;
                    }
                }
                Oox.oOoXoXO<Boolean, oXIO0o0XI> oooxoxo3 = oooxoxo;
                if (oooxoxo3 != null) {
                    oooxoxo3.invoke(Boolean.TRUE);
                }
            }
        };
        Map<String, String> headersMap = netWorkUtils.getHeadersMap();
        final Activity activity = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), GetCourseList.URL);
        netWorkUtils.printParam(convertBaseUrl + GetCourseList.URL, o0.xoIxX(courseBody, headersMap));
        NetWork netWork = NetWork.f19682oIX0oI;
        String str5 = convertBaseUrl + GetCourseList.URL;
        final xxxI.II0xO0<Response<CourseList[]>> iI0xO02 = new xxxI.II0xO0<Response<CourseList[]>>() { // from class: com.sma.smartv3.biz.CourseManager$getOnLineCourseList$$inlined$postV2$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<CourseList[]> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                Activity activity2 = activity;
                xxxI.II0xO0 iI0xO03 = iI0xO0;
                I0X0x0oIo i0X0x0oIo = loadPopup;
                LogUtils.d(x0xO.XO.f34062II0XooXoX + response);
                if (response == null) {
                    response = new Response<>();
                    response.setCode(-1000);
                }
                netWorkUtils2.responseWhenCheck(activity2, response, iI0xO03);
                if (i0X0x0oIo != null) {
                    i0X0x0oIo.dismiss();
                }
            }
        };
        AndroidNetworking.post(str5).addHeaders(headersMap).addBodyParameter((Map<String, String>) courseBody).setTag((Object) str5).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, CourseList[].class), new ParsedRequestListener<Response<CourseList[]>>() { // from class: com.sma.smartv3.biz.CourseManager$getOnLineCourseList$$inlined$postV2$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<CourseList[]> response) {
                IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                Integer num;
                String str6;
                String str7;
                String str8;
                Response response;
                if (aNError != null) {
                    aNError.printStackTrace();
                }
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
                    str6 = aNError.getErrorBody();
                } else {
                    str6 = null;
                }
                sb.append(str6);
                sb.append(", errorDetail:");
                if (aNError != null) {
                    str7 = aNError.getErrorDetail();
                } else {
                    str7 = null;
                }
                sb.append(str7);
                sb.append(", exception:");
                if (aNError != null) {
                    str8 = aNError.getLocalizedMessage();
                } else {
                    str8 = null;
                }
                sb.append(str8);
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

    public final void ooOOo0oXI(@OXOo.OOXIXo String type, @OXOo.oOoXoXO final Oox.oOoXoXO<? super CourseType[], oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(type, "type");
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        String str = "/system/dict/data/type/" + type;
        HashMap<String, String> courseTypeListBody = RequestBodyKt.getCourseTypeListBody(type);
        final xxxI.II0xO0<CourseType[]> iI0xO0 = new xxxI.II0xO0<CourseType[]>() { // from class: com.sma.smartv3.biz.CourseManager$getCourseType$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                LogUtils.d("getCourseType -> " + error);
                Oox.oOoXoXO<CourseType[], oXIO0o0XI> oooxoxo2 = oooxoxo;
                if (oooxoxo2 != null) {
                    oooxoxo2.invoke(null);
                }
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO CourseType[] courseTypeArr) {
                LogUtils.d("getCourseType -> " + courseTypeArr);
                try {
                    Oox.oOoXoXO<CourseType[], oXIO0o0XI> oooxoxo2 = oooxoxo;
                    if (oooxoxo2 != null) {
                        oooxoxo2.invoke(courseTypeArr);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Oox.oOoXoXO<CourseType[], oXIO0o0XI> oooxoxo3 = oooxoxo;
                    if (oooxoxo3 != null) {
                        oooxoxo3.invoke(null);
                    }
                }
            }
        };
        Map<String, String> headersMap = netWorkUtils.getHeadersMap();
        final Activity activity = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), str);
        netWorkUtils.printParam(convertBaseUrl + str, o0.xoIxX(courseTypeListBody, headersMap));
        NetWork netWork = NetWork.f19682oIX0oI;
        String str2 = convertBaseUrl + str;
        final xxxI.II0xO0<Response<CourseType[]>> iI0xO02 = new xxxI.II0xO0<Response<CourseType[]>>() { // from class: com.sma.smartv3.biz.CourseManager$getCourseType$$inlined$getV2$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<CourseType[]> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                Activity activity2 = activity;
                xxxI.II0xO0 iI0xO03 = iI0xO0;
                I0X0x0oIo i0X0x0oIo = loadPopup;
                LogUtils.d(x0xO.XO.f34062II0XooXoX + response);
                if (response == null) {
                    response = new Response<>();
                    response.setCode(-1000);
                }
                netWorkUtils2.responseWhenCheck(activity2, response, iI0xO03);
                if (i0X0x0oIo != null) {
                    i0X0x0oIo.dismiss();
                }
            }
        };
        AndroidNetworking.get(str2).addQueryParameter((Map<String, String>) courseTypeListBody).setTag((Object) str2).addHeaders(headersMap).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, CourseType[].class), new ParsedRequestListener<Response<CourseType[]>>() { // from class: com.sma.smartv3.biz.CourseManager$getCourseType$$inlined$getV2$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<CourseType[]> response) {
                IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                Integer num;
                String str3;
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

    public final void xxIXOIIO(@OXOo.OOXIXo String type, @OXOo.oOoXoXO final Oox.oOoXoXO<? super CourSelectByType[], oXIO0o0XI> oooxoxo) {
        IIX0o.x0xO0oo(type, "type");
        LogUtils.d("getCourSelectByType -> " + type);
        NetWorkUtils netWorkUtils = NetWorkUtils.INSTANCE;
        HashMap<String, String> courSelectByTypeBody = RequestBodyKt.getCourSelectByTypeBody(type);
        final xxxI.II0xO0<CourSelectByType[]> iI0xO0 = new xxxI.II0xO0<CourSelectByType[]>() { // from class: com.sma.smartv3.biz.CourseManager$getCourSelectByType$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                LogUtils.d("getCourSelectByType -> " + error);
                Oox.oOoXoXO<CourSelectByType[], oXIO0o0XI> oooxoxo2 = oooxoxo;
                if (oooxoxo2 != null) {
                    oooxoxo2.invoke(null);
                }
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO CourSelectByType[] courSelectByTypeArr) {
                LogUtils.d("getCourSelectByType -> " + courSelectByTypeArr);
                try {
                    Oox.oOoXoXO<CourSelectByType[], oXIO0o0XI> oooxoxo2 = oooxoxo;
                    if (oooxoxo2 != null) {
                        oooxoxo2.invoke(courSelectByTypeArr);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Oox.oOoXoXO<CourSelectByType[], oXIO0o0XI> oooxoxo3 = oooxoxo;
                    if (oooxoxo3 != null) {
                        oooxoxo3.invoke(null);
                    }
                }
            }
        };
        Map<String, String> headersMap = netWorkUtils.getHeadersMap();
        final Activity activity = null;
        final I0X0x0oIo loadPopup = netWorkUtils.loadPopup(null, null);
        String convertBaseUrl = netWorkUtils.convertBaseUrl(Api.INSTANCE.getBASE_URL(), GetCourSelectByType.URL);
        netWorkUtils.printParam(convertBaseUrl + GetCourSelectByType.URL, o0.xoIxX(courSelectByTypeBody, headersMap));
        NetWork netWork = NetWork.f19682oIX0oI;
        String str = convertBaseUrl + GetCourSelectByType.URL;
        final xxxI.II0xO0<Response<CourSelectByType[]>> iI0xO02 = new xxxI.II0xO0<Response<CourSelectByType[]>>() { // from class: com.sma.smartv3.biz.CourseManager$getCourSelectByType$$inlined$getV2$default$1
            @Override // xxxI.II0xO0
            public void handleError(@OXOo.OOXIXo String error) {
                IIX0o.x0xO0oo(error, "error");
                NetWorkUtils.INSTANCE.errorData(error, iI0xO0, loadPopup);
            }

            @Override // xxxI.II0xO0
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void handleResponse(@OXOo.oOoXoXO Response<CourSelectByType[]> response) {
                NetWorkUtils netWorkUtils2 = NetWorkUtils.INSTANCE;
                Activity activity2 = activity;
                xxxI.II0xO0 iI0xO03 = iI0xO0;
                I0X0x0oIo i0X0x0oIo = loadPopup;
                LogUtils.d(x0xO.XO.f34062II0XooXoX + response);
                if (response == null) {
                    response = new Response<>();
                    response.setCode(-1000);
                }
                netWorkUtils2.responseWhenCheck(activity2, response, iI0xO03);
                if (i0X0x0oIo != null) {
                    i0X0x0oIo.dismiss();
                }
            }
        };
        AndroidNetworking.get(str).addQueryParameter((Map<String, String>) courSelectByTypeBody).setTag((Object) str).addHeaders(headersMap).setPriority(Priority.HIGH).build().getAsParsed(TypeToken.getParameterized(Response.class, CourSelectByType[].class), new ParsedRequestListener<Response<CourSelectByType[]>>() { // from class: com.sma.smartv3.biz.CourseManager$getCourSelectByType$$inlined$getV2$default$2
            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public void onResponse(@OXOo.OOXIXo Response<CourSelectByType[]> response) {
                IIX0o.x0xO0oo(response, "response");
                xxxI.II0xO0.this.handleResponse(response);
            }

            @Override // com.androidnetworking.interfaces.ParsedRequestListener
            public void onError(@OXOo.oOoXoXO ANError aNError) {
                Integer num;
                String str2;
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
                    str2 = aNError.getErrorBody();
                } else {
                    str2 = null;
                }
                sb.append(str2);
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
