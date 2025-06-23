package androidx.navigation.serialization;

import OXOo.OOXIXo;
import androidx.navigation.CollectionNavType;
import androidx.navigation.NavType;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlinx.serialization.Oxx0IOOO;
import org.apache.log4j.spi.LocationInfo;

@XX({"SMAP\nRouteBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RouteBuilder.kt\nandroidx/navigation/serialization/RouteBuilder\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,111:1\n1855#2,2:112\n*S KotlinDebug\n*F\n+ 1 RouteBuilder.kt\nandroidx/navigation/serialization/RouteBuilder\n*L\n88#1:112,2\n*E\n"})
public final class RouteBuilder<T> {
    @OOXIXo
    private final String path;
    @OOXIXo
    private String pathArgs = "";
    @OOXIXo
    private String queryArgs = "";
    @OOXIXo
    private final Oxx0IOOO<T> serializer;

    public enum ParamType {
        PATH,
        QUERY
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                androidx.navigation.serialization.RouteBuilder$ParamType[] r0 = androidx.navigation.serialization.RouteBuilder.ParamType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.navigation.serialization.RouteBuilder$ParamType r1 = androidx.navigation.serialization.RouteBuilder.ParamType.PATH     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.navigation.serialization.RouteBuilder$ParamType r1 = androidx.navigation.serialization.RouteBuilder.ParamType.QUERY     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.serialization.RouteBuilder.WhenMappings.<clinit>():void");
        }
    }

    public RouteBuilder(@OOXIXo Oxx0IOOO<T> oxx0IOOO) {
        IIX0o.x0xO0oo(oxx0IOOO, "serializer");
        this.serializer = oxx0IOOO;
        this.path = oxx0IOOO.oIX0oI().xxIXOIIO();
    }

    private final void addPath(String str) {
        this.pathArgs += IOUtils.DIR_SEPARATOR_UNIX + str;
    }

    private final void addQuery(String str, String str2) {
        String str3;
        if (this.queryArgs.length() == 0) {
            str3 = LocationInfo.NA;
        } else {
            str3 = "&";
        }
        this.queryArgs += str3 + str + '=' + str2;
    }

    private final ParamType computeParamType(int i, NavType<Object> navType) {
        if ((navType instanceof CollectionNavType) || this.serializer.oIX0oI().xoIox(i)) {
            return ParamType.QUERY;
        }
        return ParamType.PATH;
    }

    public final void appendArg(int i, @OOXIXo String str, @OOXIXo NavType<Object> navType, @OOXIXo List<String> list) {
        IIX0o.x0xO0oo(str, "name");
        IIX0o.x0xO0oo(navType, "type");
        IIX0o.x0xO0oo(list, "value");
        int i2 = WhenMappings.$EnumSwitchMapping$0[computeParamType(i, navType).ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                for (String addQuery : list) {
                    addQuery(str, addQuery);
                }
            }
        } else if (list.size() == 1) {
            addPath((String) CollectionsKt___CollectionsKt.O0OOX0IIx(list));
        } else {
            throw new IllegalArgumentException(("Expected one value for argument " + str + ", found " + list.size() + "values instead.").toString());
        }
    }

    public final void appendPattern(int i, @OOXIXo String str, @OOXIXo NavType<Object> navType) {
        IIX0o.x0xO0oo(str, "name");
        IIX0o.x0xO0oo(navType, "type");
        int i2 = WhenMappings.$EnumSwitchMapping$0[computeParamType(i, navType).ordinal()];
        if (i2 == 1) {
            addPath('{' + str + '}');
        } else if (i2 == 2) {
            addQuery(str, '{' + str + '}');
        }
    }

    @OOXIXo
    public final String build() {
        return this.path + this.pathArgs + this.queryArgs;
    }

    public RouteBuilder(@OOXIXo String str, @OOXIXo Oxx0IOOO<T> oxx0IOOO) {
        IIX0o.x0xO0oo(str, "path");
        IIX0o.x0xO0oo(oxx0IOOO, "serializer");
        this.serializer = oxx0IOOO;
        this.path = str;
    }
}
