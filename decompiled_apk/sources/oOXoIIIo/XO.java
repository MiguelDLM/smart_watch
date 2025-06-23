package oOXoIIIo;

import OXOo.OOXIXo;
import Oox.oOoXoXO;
import androidx.exifinterface.media.ExifInterface;
import com.blankj.utilcode.util.EncodeUtils;
import com.blankj.utilcode.util.SPUtils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.OxxIIOOXO;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;

@XX({"SMAP\nSPUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,100:1\n15#1:101\n18#1,2:102\n15#1:104\n11#1,2:106\n90#1:128\n1#2:105\n1549#3:108\n1620#3,3:109\n1549#3:112\n1620#3,3:113\n1549#3:116\n1620#3,3:117\n1549#3:120\n1620#3,3:121\n1549#3:124\n1620#3,3:125\n*S KotlinDebug\n*F\n+ 1 SPUtils.kt\ncom/bestmafen/androidbase/extension/SPUtilsKt\n*L\n19#1:101\n23#1:102,2\n23#1:104\n23#1:106,2\n94#1:128\n41#1:108\n41#1:109,3\n52#1:112\n52#1:113,3\n52#1:116\n52#1:117,3\n77#1:120\n77#1:121,3\n77#1:124\n77#1:125,3\n*E\n"})
/* loaded from: classes8.dex */
public final class XO {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public static final String f32008oIX0oI = "_list";

    public static /* synthetic */ List I0Io(SPUtils sPUtils, String key, int i, Object obj) {
        if ((i & 1) != 0) {
            StringBuilder sb = new StringBuilder();
            IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
            sb.append(Object.class.getName());
            sb.append(f32008oIX0oI);
            key = sb.toString();
        }
        IIX0o.x0xO0oo(sPUtils, "<this>");
        IIX0o.x0xO0oo(key, "key");
        try {
            JsonArray asJsonArray = JsonParser.parseString(sPUtils.getString(key)).getAsJsonArray();
            IIX0o.ooOOo0oXI(asJsonArray);
            ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(asJsonArray, 10));
            for (JsonElement jsonElement : asJsonArray) {
                Gson gson = new Gson();
                IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
                arrayList.add(gson.fromJson(jsonElement, Object.class));
            }
            return arrayList;
        } catch (Exception unused) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
    }

    public static final /* synthetic */ <T> T II0XooXoX(SPUtils sPUtils, T t) {
        IIX0o.x0xO0oo(sPUtils, "<this>");
        Gson gson = new Gson();
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        String string = sPUtils.getString(Object.class.getName());
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        T t2 = (T) gson.fromJson(string, (Class) Object.class);
        if (t2 == null) {
            if (t == null) {
                IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
                return (T) Object.class.newInstance();
            }
            return t;
        }
        return t2;
    }

    public static final /* synthetic */ <T> List<T> II0xO0(SPUtils sPUtils, String key) {
        IIX0o.x0xO0oo(sPUtils, "<this>");
        IIX0o.x0xO0oo(key, "key");
        try {
            JsonArray asJsonArray = JsonParser.parseString(sPUtils.getString(key)).getAsJsonArray();
            IIX0o.ooOOo0oXI(asJsonArray);
            ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(asJsonArray, 10));
            for (JsonElement jsonElement : asJsonArray) {
                Gson gson = new Gson();
                IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
                arrayList.add(gson.fromJson(jsonElement, (Class) Object.class));
            }
            return arrayList;
        } catch (Exception unused) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
    }

    public static final /* synthetic */ <T> void IXxxXO(SPUtils sPUtils, String key, T t) {
        IIX0o.x0xO0oo(sPUtils, "<this>");
        IIX0o.x0xO0oo(key, "key");
        StringBuilder sb = new StringBuilder();
        sb.append(key);
        sb.append('_');
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        sb.append(Object.class.getName());
        sPUtils.put(sb.toString(), new Gson().toJson(t));
    }

    public static /* synthetic */ Object OOXIXo(SPUtils sPUtils, String key, Object obj, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        IIX0o.x0xO0oo(sPUtils, "<this>");
        IIX0o.x0xO0oo(key, "key");
        Gson gson = new Gson();
        StringBuilder sb = new StringBuilder();
        sb.append(key);
        sb.append('_');
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        sb.append(Object.class.getName());
        String string = sPUtils.getString(sb.toString());
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        Object fromJson = gson.fromJson(string, (Class<Object>) Object.class);
        if (fromJson == null) {
            if (obj == null) {
                IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
                return Object.class.newInstance();
            }
            return obj;
        }
        return fromJson;
    }

    public static final /* synthetic */ <T> void Oo(SPUtils sPUtils, T t) {
        IIX0o.x0xO0oo(sPUtils, "<this>");
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        sPUtils.put(Object.class.getName(), new Gson().toJson(t));
    }

    public static final /* synthetic */ <T> T Oxx0IOOO(SPUtils sPUtils, String key) {
        IIX0o.x0xO0oo(sPUtils, "<this>");
        IIX0o.x0xO0oo(key, "key");
        Gson gson = new Gson();
        StringBuilder sb = new StringBuilder();
        sb.append(key);
        sb.append('_');
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        sb.append(Object.class.getName());
        String string = sPUtils.getString(sb.toString());
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) gson.fromJson(string, (Class) Object.class);
    }

    public static final /* synthetic */ <T> void Oxx0xo(SPUtils sPUtils) {
        IIX0o.x0xO0oo(sPUtils, "<this>");
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        sPUtils.remove(Object.class.getName());
    }

    public static final /* synthetic */ <T> void OxxIIOOXO(SPUtils sPUtils, oOoXoXO<? super T, oXIO0o0XI> update) {
        IIX0o.x0xO0oo(sPUtils, "<this>");
        IIX0o.x0xO0oo(update, "update");
        Gson gson = new Gson();
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        String string = sPUtils.getString(Object.class.getName());
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        Object fromJson = gson.fromJson(string, (Class<Object>) Object.class);
        if (fromJson == null) {
            IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
            fromJson = Object.class.newInstance();
        }
        update.invoke(fromJson);
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        sPUtils.put(Object.class.getName(), new Gson().toJson(fromJson));
    }

    public static /* synthetic */ List X0o0xo(SPUtils sPUtils, String key, int i, Object obj) {
        if ((i & 1) != 0) {
            StringBuilder sb = new StringBuilder();
            IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
            sb.append(Object.class.getName());
            sb.append(f32008oIX0oI);
            key = sb.toString();
        }
        IIX0o.x0xO0oo(sPUtils, "<this>");
        IIX0o.x0xO0oo(key, "key");
        try {
            byte[] base64Decode = EncodeUtils.base64Decode(sPUtils.getString(key));
            IIX0o.oO(base64Decode, "base64Decode(...)");
            JsonArray asJsonArray = JsonParser.parseString(new String(base64Decode, kotlin.text.oxoX.f29581II0xO0)).getAsJsonArray();
            IIX0o.ooOOo0oXI(asJsonArray);
            ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(asJsonArray, 10));
            for (JsonElement jsonElement : asJsonArray) {
                Gson gson = new Gson();
                IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
                arrayList.add(gson.fromJson(jsonElement, Object.class));
            }
            return arrayList;
        } catch (Exception unused) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
    }

    public static final /* synthetic */ <T> T XO(SPUtils sPUtils) {
        IIX0o.x0xO0oo(sPUtils, "<this>");
        Gson gson = new Gson();
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        String string = sPUtils.getString(Object.class.getName());
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) gson.fromJson(string, (Class) Object.class);
    }

    public static final /* synthetic */ <T> void oI0IIXIo(SPUtils sPUtils, String key) {
        IIX0o.x0xO0oo(sPUtils, "<this>");
        IIX0o.x0xO0oo(key, "key");
        StringBuilder sb = new StringBuilder();
        sb.append(key);
        sb.append('_');
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        sb.append(Object.class.getName());
        sPUtils.remove(sb.toString());
    }

    public static final /* synthetic */ <T> List<T> oIX0oI(SPUtils sPUtils) {
        IIX0o.x0xO0oo(sPUtils, "<this>");
        try {
            StringBuilder sb = new StringBuilder();
            IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
            sb.append(Object.class.getName());
            sb.append(f32008oIX0oI);
            JsonArray asJsonArray = JsonParser.parseString(sPUtils.getString(sb.toString())).getAsJsonArray();
            IIX0o.ooOOo0oXI(asJsonArray);
            ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(asJsonArray, 10));
            for (JsonElement jsonElement : asJsonArray) {
                Gson gson = new Gson();
                IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
                arrayList.add(gson.fromJson(jsonElement, (Class) Object.class));
            }
            return arrayList;
        } catch (Exception unused) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
    }

    public static final /* synthetic */ <T> void oO(SPUtils sPUtils, List<? extends T> list, String key) {
        IIX0o.x0xO0oo(sPUtils, "<this>");
        IIX0o.x0xO0oo(list, "list");
        IIX0o.x0xO0oo(key, "key");
        String json = new Gson().toJson(list);
        IIX0o.oO(json, "toJson(...)");
        byte[] bytes = json.getBytes(kotlin.text.oxoX.f29581II0xO0);
        IIX0o.oO(bytes, "getBytes(...)");
        sPUtils.put(key, EncodeUtils.base64Encode2String(bytes));
    }

    public static final /* synthetic */ <T> void oOoXoXO(SPUtils sPUtils, List<? extends T> list) {
        IIX0o.x0xO0oo(sPUtils, "<this>");
        IIX0o.x0xO0oo(list, "list");
        StringBuilder sb = new StringBuilder();
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        sb.append(Object.class.getName());
        sb.append(f32008oIX0oI);
        sPUtils.put(sb.toString(), new Gson().toJson(list));
    }

    public static final /* synthetic */ <T> void ooOOo0oXI(SPUtils sPUtils, List<? extends T> list, String key) {
        IIX0o.x0xO0oo(sPUtils, "<this>");
        IIX0o.x0xO0oo(list, "list");
        IIX0o.x0xO0oo(key, "key");
        sPUtils.put(key, new Gson().toJson(list));
    }

    public static final /* synthetic */ <T> List<T> oxoX(SPUtils sPUtils, String key) {
        IIX0o.x0xO0oo(sPUtils, "<this>");
        IIX0o.x0xO0oo(key, "key");
        try {
            byte[] base64Decode = EncodeUtils.base64Decode(sPUtils.getString(key));
            IIX0o.oO(base64Decode, "base64Decode(...)");
            JsonArray asJsonArray = JsonParser.parseString(new String(base64Decode, kotlin.text.oxoX.f29581II0xO0)).getAsJsonArray();
            IIX0o.ooOOo0oXI(asJsonArray);
            ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(asJsonArray, 10));
            for (JsonElement jsonElement : asJsonArray) {
                Gson gson = new Gson();
                IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
                arrayList.add(gson.fromJson(jsonElement, (Class) Object.class));
            }
            return arrayList;
        } catch (Exception unused) {
            return CollectionsKt__CollectionsKt.ooXIXxIX();
        }
    }

    public static /* synthetic */ void x0XOIxOo(SPUtils sPUtils, List list, String key, int i, Object obj) {
        if ((i & 2) != 0) {
            StringBuilder sb = new StringBuilder();
            IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
            sb.append(Object.class.getName());
            sb.append(f32008oIX0oI);
            key = sb.toString();
        }
        IIX0o.x0xO0oo(sPUtils, "<this>");
        IIX0o.x0xO0oo(list, "list");
        IIX0o.x0xO0oo(key, "key");
        sPUtils.put(key, new Gson().toJson(list));
    }

    public static /* synthetic */ void x0xO0oo(SPUtils sPUtils, List list, String key, int i, Object obj) {
        if ((i & 2) != 0) {
            StringBuilder sb = new StringBuilder();
            IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
            sb.append(Object.class.getName());
            sb.append(f32008oIX0oI);
            key = sb.toString();
        }
        IIX0o.x0xO0oo(sPUtils, "<this>");
        IIX0o.x0xO0oo(list, "list");
        IIX0o.x0xO0oo(key, "key");
        String json = new Gson().toJson(list);
        IIX0o.oO(json, "toJson(...)");
        byte[] bytes = json.getBytes(kotlin.text.oxoX.f29581II0xO0);
        IIX0o.oO(bytes, "getBytes(...)");
        sPUtils.put(key, EncodeUtils.base64Encode2String(bytes));
    }

    public static /* synthetic */ Object xoIox(SPUtils sPUtils, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        IIX0o.x0xO0oo(sPUtils, "<this>");
        Gson gson = new Gson();
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        String string = sPUtils.getString(Object.class.getName());
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        Object fromJson = gson.fromJson(string, (Class<Object>) Object.class);
        if (fromJson == null) {
            if (obj == null) {
                IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
                return Object.class.newInstance();
            }
            return obj;
        }
        return fromJson;
    }

    public static final /* synthetic */ <T> T xxIXOIIO(SPUtils sPUtils, String key, T t) {
        IIX0o.x0xO0oo(sPUtils, "<this>");
        IIX0o.x0xO0oo(key, "key");
        Gson gson = new Gson();
        StringBuilder sb = new StringBuilder();
        sb.append(key);
        sb.append('_');
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        sb.append(Object.class.getName());
        String string = sPUtils.getString(sb.toString());
        IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
        T t2 = (T) gson.fromJson(string, (Class) Object.class);
        if (t2 == null) {
            if (t == null) {
                IIX0o.OxI(4, ExifInterface.GPS_DIRECTION_TRUE);
                return (T) Object.class.newInstance();
            }
            return t;
        }
        return t2;
    }
}
