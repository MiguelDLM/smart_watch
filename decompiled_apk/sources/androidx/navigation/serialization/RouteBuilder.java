package androidx.navigation.serialization;

import OXOo.OOXIXo;
import androidx.navigation.CollectionNavType;
import androidx.navigation.NavType;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlinx.serialization.Oxx0IOOO;
import org.apache.log4j.spi.LocationInfo;

@XX({"SMAP\nRouteBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RouteBuilder.kt\nandroidx/navigation/serialization/RouteBuilder\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,111:1\n1855#2,2:112\n*S KotlinDebug\n*F\n+ 1 RouteBuilder.kt\nandroidx/navigation/serialization/RouteBuilder\n*L\n88#1:112,2\n*E\n"})
/* loaded from: classes.dex */
public final class RouteBuilder<T> {

    @OOXIXo
    private final String path;

    @OOXIXo
    private String pathArgs;

    @OOXIXo
    private String queryArgs;

    @OOXIXo
    private final Oxx0IOOO<T> serializer;

    /* loaded from: classes.dex */
    public enum ParamType {
        PATH,
        QUERY
    }

    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ParamType.values().length];
            try {
                iArr[ParamType.PATH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ParamType.QUERY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public RouteBuilder(@OOXIXo Oxx0IOOO<T> serializer) {
        IIX0o.x0xO0oo(serializer, "serializer");
        this.pathArgs = "";
        this.queryArgs = "";
        this.serializer = serializer;
        this.path = serializer.oIX0oI().xxIXOIIO();
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
        if (!(navType instanceof CollectionNavType) && !this.serializer.oIX0oI().xoIox(i)) {
            return ParamType.PATH;
        }
        return ParamType.QUERY;
    }

    public final void appendArg(int i, @OOXIXo String name, @OOXIXo NavType<Object> type, @OOXIXo List<String> value) {
        IIX0o.x0xO0oo(name, "name");
        IIX0o.x0xO0oo(type, "type");
        IIX0o.x0xO0oo(value, "value");
        int i2 = WhenMappings.$EnumSwitchMapping$0[computeParamType(i, type).ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                Iterator<T> it = value.iterator();
                while (it.hasNext()) {
                    addQuery(name, (String) it.next());
                }
                return;
            }
            return;
        }
        if (value.size() == 1) {
            addPath((String) CollectionsKt___CollectionsKt.O0OOX0IIx(value));
            return;
        }
        throw new IllegalArgumentException(("Expected one value for argument " + name + ", found " + value.size() + "values instead.").toString());
    }

    public final void appendPattern(int i, @OOXIXo String name, @OOXIXo NavType<Object> type) {
        IIX0o.x0xO0oo(name, "name");
        IIX0o.x0xO0oo(type, "type");
        int i2 = WhenMappings.$EnumSwitchMapping$0[computeParamType(i, type).ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                addQuery(name, '{' + name + '}');
                return;
            }
            return;
        }
        addPath('{' + name + '}');
    }

    @OOXIXo
    public final String build() {
        return this.path + this.pathArgs + this.queryArgs;
    }

    public RouteBuilder(@OOXIXo String path, @OOXIXo Oxx0IOOO<T> serializer) {
        IIX0o.x0xO0oo(path, "path");
        IIX0o.x0xO0oo(serializer, "serializer");
        this.pathArgs = "";
        this.queryArgs = "";
        this.serializer = serializer;
        this.path = path;
    }
}
