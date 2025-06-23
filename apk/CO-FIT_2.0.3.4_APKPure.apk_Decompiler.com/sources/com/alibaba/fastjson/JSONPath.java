package com.alibaba.fastjson;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexerBase;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.FieldSerializer;
import com.alibaba.fastjson.serializer.JavaBeanSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import com.baidu.platform.comapi.map.MapBundleKey;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Pattern;

public class JSONPath implements JSONAware {
    static final long LENGTH = -1580386065683472715L;
    static final long SIZE = 5614464919154503228L;
    private static ConcurrentMap<String, JSONPath> pathCache = new ConcurrentHashMap(128, 0.75f, 1);
    private boolean hasRefSegment;
    private boolean ignoreNullValue;
    private ParserConfig parserConfig;
    private final String path;
    private Segment[] segments;
    private SerializeConfig serializeConfig;

    /* renamed from: com.alibaba.fastjson.JSONPath$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$fastjson$JSONPath$Operator;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.alibaba.fastjson.JSONPath$Operator[] r0 = com.alibaba.fastjson.JSONPath.Operator.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$alibaba$fastjson$JSONPath$Operator = r0
                com.alibaba.fastjson.JSONPath$Operator r1 = com.alibaba.fastjson.JSONPath.Operator.EQ     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$alibaba$fastjson$JSONPath$Operator     // Catch:{ NoSuchFieldError -> 0x001d }
                com.alibaba.fastjson.JSONPath$Operator r1 = com.alibaba.fastjson.JSONPath.Operator.NE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$alibaba$fastjson$JSONPath$Operator     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.alibaba.fastjson.JSONPath$Operator r1 = com.alibaba.fastjson.JSONPath.Operator.GE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$alibaba$fastjson$JSONPath$Operator     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.alibaba.fastjson.JSONPath$Operator r1 = com.alibaba.fastjson.JSONPath.Operator.GT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$alibaba$fastjson$JSONPath$Operator     // Catch:{ NoSuchFieldError -> 0x003e }
                com.alibaba.fastjson.JSONPath$Operator r1 = com.alibaba.fastjson.JSONPath.Operator.LE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$alibaba$fastjson$JSONPath$Operator     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.alibaba.fastjson.JSONPath$Operator r1 = com.alibaba.fastjson.JSONPath.Operator.LT     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.JSONPath.AnonymousClass1.<clinit>():void");
        }
    }

    public static class ArrayAccessSegment implements Segment {
        /* access modifiers changed from: private */
        public final int index;

        public ArrayAccessSegment(int i) {
            this.index = i;
        }

        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            return jSONPath.getArrayItem(obj2, this.index);
        }

        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            if (((JSONLexerBase) defaultJSONParser.lexer).seekArrayToItem(this.index) && context.eval) {
                context.object = defaultJSONParser.parse();
            }
        }

        public boolean remove(JSONPath jSONPath, Object obj) {
            return jSONPath.removeArrayItem(jSONPath, obj, this.index);
        }

        public boolean setValue(JSONPath jSONPath, Object obj, Object obj2) {
            return jSONPath.setArrayItem(jSONPath, obj, this.index, obj2);
        }
    }

    public static class Context {
        final boolean eval;
        Object object;
        final Context parent;

        public Context(Context context, boolean z) {
            this.parent = context;
            this.eval = z;
        }
    }

    public static class DoubleOpSegement extends PropertyFilter {
        private final Operator op;
        private final double value;

        public DoubleOpSegement(String str, boolean z, double d, Operator operator) {
            super(str, z);
            this.value = d;
            this.op = operator;
        }

        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object obj4 = get(jSONPath, obj, obj3);
            if (obj4 == null || !(obj4 instanceof Number)) {
                return false;
            }
            double doubleValue = ((Number) obj4).doubleValue();
            switch (AnonymousClass1.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.op.ordinal()]) {
                case 1:
                    if (doubleValue == this.value) {
                        return true;
                    }
                    return false;
                case 2:
                    if (doubleValue != this.value) {
                        return true;
                    }
                    return false;
                case 3:
                    if (doubleValue >= this.value) {
                        return true;
                    }
                    return false;
                case 4:
                    if (doubleValue > this.value) {
                        return true;
                    }
                    return false;
                case 5:
                    if (doubleValue <= this.value) {
                        return true;
                    }
                    return false;
                case 6:
                    if (doubleValue < this.value) {
                        return true;
                    }
                    return false;
                default:
                    return false;
            }
        }
    }

    public interface Filter {
        boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3);
    }

    public static class FilterGroup implements Filter {
        private boolean and;
        private List<Filter> fitlers;

        public FilterGroup(Filter filter, Filter filter2, boolean z) {
            ArrayList arrayList = new ArrayList(2);
            this.fitlers = arrayList;
            arrayList.add(filter);
            this.fitlers.add(filter2);
            this.and = z;
        }

        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            if (this.and) {
                for (Filter apply : this.fitlers) {
                    if (!apply.apply(jSONPath, obj, obj2, obj3)) {
                        return false;
                    }
                }
                return true;
            }
            for (Filter apply2 : this.fitlers) {
                if (apply2.apply(jSONPath, obj, obj2, obj3)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static class FilterSegment implements Segment {
        /* access modifiers changed from: private */
        public final Filter filter;

        public FilterSegment(Filter filter2) {
            this.filter = filter2;
        }

        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            if (obj2 == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            if (obj2 instanceof Iterable) {
                for (Object next : (Iterable) obj2) {
                    if (this.filter.apply(jSONPath, obj, obj2, next)) {
                        jSONArray.add(next);
                    }
                }
                return jSONArray;
            } else if (this.filter.apply(jSONPath, obj, obj2, obj2)) {
                return obj2;
            } else {
                return null;
            }
        }

        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            Object parse = defaultJSONParser.parse();
            context.object = eval(jSONPath, parse, parse);
        }

        public boolean remove(JSONPath jSONPath, Object obj, Object obj2) {
            if (obj2 == null || !(obj2 instanceof Iterable)) {
                return false;
            }
            Iterator it = ((Iterable) obj2).iterator();
            while (it.hasNext()) {
                if (this.filter.apply(jSONPath, obj, obj2, it.next())) {
                    it.remove();
                }
            }
            return true;
        }
    }

    public static class FloorSegment implements Segment {
        public static final FloorSegment instance = new FloorSegment();

        private static Object floor(Object obj) {
            if (obj == null) {
                return null;
            }
            if (obj instanceof Float) {
                return Double.valueOf(Math.floor((double) ((Float) obj).floatValue()));
            }
            if (obj instanceof Double) {
                return Double.valueOf(Math.floor(((Double) obj).doubleValue()));
            }
            if (obj instanceof BigDecimal) {
                return ((BigDecimal) obj).setScale(0, RoundingMode.FLOOR);
            }
            if ((obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof BigInteger)) {
                return obj;
            }
            throw new UnsupportedOperationException();
        }

        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            if (!(obj2 instanceof JSONArray)) {
                return floor(obj2);
            }
            JSONArray jSONArray = (JSONArray) ((JSONArray) obj2).clone();
            for (int i = 0; i < jSONArray.size(); i++) {
                Object obj3 = jSONArray.get(i);
                Object floor = floor(obj3);
                if (floor != obj3) {
                    jSONArray.set(i, floor);
                }
            }
            return jSONArray;
        }

        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            throw new UnsupportedOperationException();
        }
    }

    public static class IntBetweenSegement extends PropertyFilter {
        private final long endValue;
        private final boolean not;
        private final long startValue;

        public IntBetweenSegement(String str, boolean z, long j, long j2, boolean z2) {
            super(str, z);
            this.startValue = j;
            this.endValue = j2;
            this.not = z2;
        }

        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object obj4 = get(jSONPath, obj, obj3);
            if (obj4 == null) {
                return false;
            }
            if (obj4 instanceof Number) {
                long longExtractValue = TypeUtils.longExtractValue((Number) obj4);
                if (longExtractValue >= this.startValue && longExtractValue <= this.endValue) {
                    return !this.not;
                }
            }
            return this.not;
        }
    }

    public static class IntInSegement extends PropertyFilter {
        private final boolean not;
        private final long[] values;

        public IntInSegement(String str, boolean z, long[] jArr, boolean z2) {
            super(str, z);
            this.values = jArr;
            this.not = z2;
        }

        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object obj4 = get(jSONPath, obj, obj3);
            if (obj4 == null) {
                return false;
            }
            if (obj4 instanceof Number) {
                long longExtractValue = TypeUtils.longExtractValue((Number) obj4);
                for (long j : this.values) {
                    if (j == longExtractValue) {
                        return !this.not;
                    }
                }
            }
            return this.not;
        }
    }

    public static class IntObjInSegement extends PropertyFilter {
        private final boolean not;
        private final Long[] values;

        public IntObjInSegement(String str, boolean z, Long[] lArr, boolean z2) {
            super(str, z);
            this.values = lArr;
            this.not = z2;
        }

        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object obj4 = get(jSONPath, obj, obj3);
            int i = 0;
            if (obj4 == null) {
                Long[] lArr = this.values;
                int length = lArr.length;
                while (i < length) {
                    if (lArr[i] == null) {
                        return !this.not;
                    }
                    i++;
                }
                return this.not;
            }
            if (obj4 instanceof Number) {
                long longExtractValue = TypeUtils.longExtractValue((Number) obj4);
                Long[] lArr2 = this.values;
                int length2 = lArr2.length;
                while (i < length2) {
                    Long l = lArr2[i];
                    if (l != null && l.longValue() == longExtractValue) {
                        return !this.not;
                    }
                    i++;
                }
            }
            return this.not;
        }
    }

    public static class IntOpSegement extends PropertyFilter {
        private final Operator op;
        private final long value;
        private BigDecimal valueDecimal;
        private Double valueDouble;
        private Float valueFloat;

        public IntOpSegement(String str, boolean z, long j, Operator operator) {
            super(str, z);
            this.value = j;
            this.op = operator;
        }

        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object obj4 = get(jSONPath, obj, obj3);
            if (obj4 == null || !(obj4 instanceof Number)) {
                return false;
            }
            if (obj4 instanceof BigDecimal) {
                if (this.valueDecimal == null) {
                    this.valueDecimal = BigDecimal.valueOf(this.value);
                }
                int compareTo = this.valueDecimal.compareTo((BigDecimal) obj4);
                switch (AnonymousClass1.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.op.ordinal()]) {
                    case 1:
                        if (compareTo == 0) {
                            return true;
                        }
                        return false;
                    case 2:
                        if (compareTo != 0) {
                            return true;
                        }
                        return false;
                    case 3:
                        if (compareTo <= 0) {
                            return true;
                        }
                        return false;
                    case 4:
                        if (compareTo < 0) {
                            return true;
                        }
                        return false;
                    case 5:
                        if (compareTo >= 0) {
                            return true;
                        }
                        return false;
                    case 6:
                        if (compareTo > 0) {
                            return true;
                        }
                        return false;
                    default:
                        return false;
                }
            } else if (obj4 instanceof Float) {
                if (this.valueFloat == null) {
                    this.valueFloat = Float.valueOf((float) this.value);
                }
                int compareTo2 = this.valueFloat.compareTo((Float) obj4);
                switch (AnonymousClass1.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.op.ordinal()]) {
                    case 1:
                        if (compareTo2 == 0) {
                            return true;
                        }
                        return false;
                    case 2:
                        if (compareTo2 != 0) {
                            return true;
                        }
                        return false;
                    case 3:
                        if (compareTo2 <= 0) {
                            return true;
                        }
                        return false;
                    case 4:
                        if (compareTo2 < 0) {
                            return true;
                        }
                        return false;
                    case 5:
                        if (compareTo2 >= 0) {
                            return true;
                        }
                        return false;
                    case 6:
                        if (compareTo2 > 0) {
                            return true;
                        }
                        return false;
                    default:
                        return false;
                }
            } else if (obj4 instanceof Double) {
                if (this.valueDouble == null) {
                    this.valueDouble = Double.valueOf((double) this.value);
                }
                int compareTo3 = this.valueDouble.compareTo((Double) obj4);
                switch (AnonymousClass1.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.op.ordinal()]) {
                    case 1:
                        if (compareTo3 == 0) {
                            return true;
                        }
                        return false;
                    case 2:
                        if (compareTo3 != 0) {
                            return true;
                        }
                        return false;
                    case 3:
                        if (compareTo3 <= 0) {
                            return true;
                        }
                        return false;
                    case 4:
                        if (compareTo3 < 0) {
                            return true;
                        }
                        return false;
                    case 5:
                        if (compareTo3 >= 0) {
                            return true;
                        }
                        return false;
                    case 6:
                        if (compareTo3 > 0) {
                            return true;
                        }
                        return false;
                    default:
                        return false;
                }
            } else {
                long longExtractValue = TypeUtils.longExtractValue((Number) obj4);
                switch (AnonymousClass1.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.op.ordinal()]) {
                    case 1:
                        if (longExtractValue == this.value) {
                            return true;
                        }
                        return false;
                    case 2:
                        if (longExtractValue != this.value) {
                            return true;
                        }
                        return false;
                    case 3:
                        if (longExtractValue >= this.value) {
                            return true;
                        }
                        return false;
                    case 4:
                        if (longExtractValue > this.value) {
                            return true;
                        }
                        return false;
                    case 5:
                        if (longExtractValue <= this.value) {
                            return true;
                        }
                        return false;
                    case 6:
                        if (longExtractValue < this.value) {
                            return true;
                        }
                        return false;
                    default:
                        return false;
                }
            }
        }
    }

    public static class JSONPathParser {
        private static final Pattern strArrayPatternx = Pattern.compile(strArrayRegex);
        private static final String strArrayRegex = "'\\s*,\\s*'";
        private char ch;
        /* access modifiers changed from: private */
        public boolean hasRefSegment;
        private int level;
        private final String path;
        private int pos;

        public JSONPathParser(String str) {
            this.path = str;
            next();
        }

        public static boolean isDigitFirst(char c) {
            return c == '-' || c == '+' || (c >= '0' && c <= '9');
        }

        public void accept(char c) {
            if (this.ch == ' ') {
                next();
            }
            if (this.ch != c) {
                throw new JSONPathException("expect '" + c + ", but '" + this.ch + "'");
            } else if (!isEOF()) {
                next();
            }
        }

        public Segment buildArraySegement(String str) {
            int length = str.length();
            char charAt = str.charAt(0);
            int i = 1;
            int i2 = length - 1;
            char charAt2 = str.charAt(i2);
            int indexOf = str.indexOf(44);
            int i3 = -1;
            if (str.length() > 2 && charAt == '\'' && charAt2 == '\'') {
                String substring = str.substring(1, i2);
                if (indexOf == -1 || !strArrayPatternx.matcher(str).find()) {
                    return new PropertySegment(substring, false);
                }
                return new MultiPropertySegment(substring.split(strArrayRegex));
            }
            int indexOf2 = str.indexOf(58);
            if (indexOf == -1 && indexOf2 == -1) {
                if (TypeUtils.isNumber(str)) {
                    try {
                        return new ArrayAccessSegment(Integer.parseInt(str));
                    } catch (NumberFormatException unused) {
                        return new PropertySegment(str, false);
                    }
                } else {
                    if (str.charAt(0) == '\"' && str.charAt(str.length() - 1) == '\"') {
                        str = str.substring(1, str.length() - 1);
                    }
                    return new PropertySegment(str, false);
                }
            } else if (indexOf != -1) {
                String[] split = str.split(",");
                int[] iArr = new int[split.length];
                for (int i4 = 0; i4 < split.length; i4++) {
                    iArr[i4] = Integer.parseInt(split[i4]);
                }
                return new MultiIndexSegment(iArr);
            } else if (indexOf2 != -1) {
                String[] split2 = str.split(":");
                int length2 = split2.length;
                int[] iArr2 = new int[length2];
                for (int i5 = 0; i5 < split2.length; i5++) {
                    String str2 = split2[i5];
                    if (str2.length() != 0) {
                        iArr2[i5] = Integer.parseInt(str2);
                    } else if (i5 == 0) {
                        iArr2[i5] = 0;
                    } else {
                        throw new UnsupportedOperationException();
                    }
                }
                int i6 = iArr2[0];
                if (length2 > 1) {
                    i3 = iArr2[1];
                }
                if (length2 == 3) {
                    i = iArr2[2];
                }
                if (i3 >= 0 && i3 < i6) {
                    throw new UnsupportedOperationException("end must greater than or equals start. start " + i6 + ",  end " + i3);
                } else if (i > 0) {
                    return new RangeSegment(i6, i3, i);
                } else {
                    throw new UnsupportedOperationException("step must greater than zero : " + i);
                }
            } else {
                throw new UnsupportedOperationException();
            }
        }

        public Segment[] explain() {
            String str = this.path;
            if (str == null || str.length() == 0) {
                throw new IllegalArgumentException();
            }
            Segment[] segmentArr = new Segment[8];
            while (true) {
                Segment readSegement = readSegement();
                if (readSegement == null) {
                    break;
                }
                if (readSegement instanceof PropertySegment) {
                    PropertySegment propertySegment = (PropertySegment) readSegement;
                    if (!propertySegment.deep && propertySegment.propertyName.equals("*")) {
                    }
                }
                int i = this.level;
                if (i == segmentArr.length) {
                    Segment[] segmentArr2 = new Segment[((i * 3) / 2)];
                    System.arraycopy(segmentArr, 0, segmentArr2, 0, i);
                    segmentArr = segmentArr2;
                }
                int i2 = this.level;
                this.level = i2 + 1;
                segmentArr[i2] = readSegement;
            }
            int i3 = this.level;
            if (i3 == segmentArr.length) {
                return segmentArr;
            }
            Segment[] segmentArr3 = new Segment[i3];
            System.arraycopy(segmentArr, 0, segmentArr3, 0, i3);
            return segmentArr3;
        }

        public Filter filterRest(Filter filter) {
            boolean z;
            char c = this.ch;
            boolean z2 = true;
            if (c == '&') {
                z = true;
            } else {
                z = false;
            }
            if ((c != '&' || getNextChar() != '&') && (this.ch != '|' || getNextChar() != '|')) {
                return filter;
            }
            next();
            next();
            if (this.ch == '(') {
                next();
            } else {
                z2 = false;
            }
            while (this.ch == ' ') {
                next();
            }
            FilterGroup filterGroup = new FilterGroup(filter, (Filter) parseArrayAccessFilter(false), z);
            if (z2 && this.ch == ')') {
                next();
            }
            return filterGroup;
        }

        public char getNextChar() {
            return this.path.charAt(this.pos);
        }

        public boolean isEOF() {
            if (this.pos >= this.path.length()) {
                return true;
            }
            return false;
        }

        public void next() {
            String str = this.path;
            int i = this.pos;
            this.pos = i + 1;
            this.ch = str.charAt(i);
        }

        public Segment parseArrayAccess(boolean z) {
            Object parseArrayAccessFilter = parseArrayAccessFilter(z);
            if (parseArrayAccessFilter instanceof Segment) {
                return (Segment) parseArrayAccessFilter;
            }
            return new FilterSegment((Filter) parseArrayAccessFilter);
        }

        /* JADX WARNING: type inference failed for: r1v28, types: [com.alibaba.fastjson.JSONPath$Filter] */
        /* JADX WARNING: type inference failed for: r9v17, types: [com.alibaba.fastjson.JSONPath$Filter] */
        /* JADX WARNING: type inference failed for: r18v6, types: [com.alibaba.fastjson.JSONPath$DoubleOpSegement] */
        /* JADX WARNING: type inference failed for: r18v7, types: [com.alibaba.fastjson.JSONPath$IntOpSegement] */
        /* JADX WARNING: Code restructure failed: missing block: B:156:0x0245, code lost:
            if (r1 == '|') goto L_0x0247;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:157:0x0247, code lost:
            r9 = filterRest(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:158:0x024b, code lost:
            if (r2 == false) goto L_0x0252;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:159:0x024d, code lost:
            accept(com.goodix.ble.libcomx.util.HexStringBuilder.COMMENT_END_CHAR);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:160:0x0252, code lost:
            if (r27 == false) goto L_0x0259;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:161:0x0254, code lost:
            accept(']');
         */
        /* JADX WARNING: Code restructure failed: missing block: B:162:0x0259, code lost:
            return r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:393:0x0594, code lost:
            if (r3 == '|') goto L_0x059a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:395:0x059a, code lost:
            r1 = filterRest(r18);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:396:0x059f, code lost:
            accept(com.goodix.ble.libcomx.util.HexStringBuilder.COMMENT_END_CHAR);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:397:0x05a2, code lost:
            if (r2 == false) goto L_0x05a7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:398:0x05a4, code lost:
            accept(com.goodix.ble.libcomx.util.HexStringBuilder.COMMENT_END_CHAR);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:399:0x05a7, code lost:
            if (r27 == false) goto L_0x05ae;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:400:0x05a9, code lost:
            accept(']');
         */
        /* JADX WARNING: Code restructure failed: missing block: B:401:0x05ae, code lost:
            return r1;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x0079  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x007d  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x0096  */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x00d8  */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x0119  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object parseArrayAccessFilter(boolean r27) {
            /*
                r26 = this;
                r0 = r26
                if (r27 == 0) goto L_0x0009
                r1 = 91
                r0.accept(r1)
            L_0x0009:
                char r1 = r0.ch
                r2 = 63
                r3 = 40
                r5 = 1
                if (r1 != r2) goto L_0x0025
                r26.next()
                r0.accept(r3)
                r1 = 1
            L_0x0019:
                char r2 = r0.ch
                if (r2 != r3) goto L_0x0023
                r26.next()
                int r1 = r1 + 1
                goto L_0x0019
            L_0x0023:
                r2 = 1
                goto L_0x0027
            L_0x0025:
                r1 = 0
                r2 = 0
            L_0x0027:
                r26.skipWhitespace()
                r6 = 34
                r7 = 39
                r8 = 64
                r9 = 46
                r10 = 47
                r11 = -1
                r12 = 2
                r13 = 92
                r14 = 93
                if (r2 != 0) goto L_0x012b
                char r3 = r0.ch
                boolean r3 = com.alibaba.fastjson.util.IOUtils.firstIdentifier(r3)
                if (r3 != 0) goto L_0x012b
                char r3 = r0.ch
                boolean r3 = java.lang.Character.isJavaIdentifierStart(r3)
                if (r3 != 0) goto L_0x012b
                char r3 = r0.ch
                if (r3 == r13) goto L_0x012b
                if (r3 != r8) goto L_0x0054
                goto L_0x012b
            L_0x0054:
                int r1 = r0.pos
                int r1 = r1 - r5
            L_0x0057:
                char r4 = r0.ch
                if (r4 == r14) goto L_0x0077
                if (r4 == r10) goto L_0x0077
                boolean r4 = r26.isEOF()
                if (r4 != 0) goto L_0x0077
                char r4 = r0.ch
                if (r4 != r9) goto L_0x006e
                if (r2 != 0) goto L_0x006e
                if (r2 != 0) goto L_0x006e
                if (r3 == r7) goto L_0x006e
                goto L_0x0077
            L_0x006e:
                if (r4 != r13) goto L_0x0073
                r26.next()
            L_0x0073:
                r26.next()
                goto L_0x0057
            L_0x0077:
                if (r27 == 0) goto L_0x007d
                int r4 = r0.pos
            L_0x007b:
                int r4 = r4 - r5
                goto L_0x008a
            L_0x007d:
                char r4 = r0.ch
                if (r4 == r10) goto L_0x0087
                if (r4 != r9) goto L_0x0084
                goto L_0x0087
            L_0x0084:
                int r4 = r0.pos
                goto L_0x008a
            L_0x0087:
                int r4 = r0.pos
                goto L_0x007b
            L_0x008a:
                java.lang.String r9 = r0.path
                java.lang.String r1 = r9.substring(r1, r4)
                int r4 = r1.indexOf(r13)
                if (r4 == 0) goto L_0x00d0
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                int r9 = r1.length()
                r4.<init>(r9)
                r9 = 0
            L_0x00a0:
                int r10 = r1.length()
                if (r9 >= r10) goto L_0x00cc
                char r10 = r1.charAt(r9)
                if (r10 != r13) goto L_0x00c5
                int r16 = r1.length()
                int r14 = r16 + -1
                if (r9 >= r14) goto L_0x00c5
                int r14 = r9 + 1
                char r15 = r1.charAt(r14)
                if (r15 == r8) goto L_0x00c0
                if (r10 == r13) goto L_0x00c0
                if (r10 != r6) goto L_0x00c5
            L_0x00c0:
                r4.append(r15)
                r9 = r14
                goto L_0x00c8
            L_0x00c5:
                r4.append(r10)
            L_0x00c8:
                int r9 = r9 + r5
                r14 = 93
                goto L_0x00a0
            L_0x00cc:
                java.lang.String r1 = r4.toString()
            L_0x00d0:
                java.lang.String r4 = "\\."
                int r6 = r1.indexOf(r4)
                if (r6 == r11) goto L_0x0119
                if (r3 != r7) goto L_0x00f5
                int r6 = r1.length()
                if (r6 <= r12) goto L_0x00f5
                int r6 = r1.length()
                int r6 = r6 - r5
                char r6 = r1.charAt(r6)
                if (r6 != r3) goto L_0x00f5
                int r3 = r1.length()
                int r3 = r3 - r5
                java.lang.String r1 = r1.substring(r5, r3)
                goto L_0x010b
            L_0x00f5:
                java.lang.String r3 = "\\\\\\."
                java.lang.String r1 = r1.replaceAll(r3, r4)
                java.lang.String r3 = "\\-"
                int r3 = r1.indexOf(r3)
                if (r3 == r11) goto L_0x010b
                java.lang.String r3 = "\\\\-"
                java.lang.String r4 = "-"
                java.lang.String r1 = r1.replaceAll(r3, r4)
            L_0x010b:
                if (r2 == 0) goto L_0x0112
                r2 = 41
                r0.accept(r2)
            L_0x0112:
                com.alibaba.fastjson.JSONPath$PropertySegment r2 = new com.alibaba.fastjson.JSONPath$PropertySegment
                r3 = 0
                r2.<init>(r1, r3)
                return r2
            L_0x0119:
                com.alibaba.fastjson.JSONPath$Segment r1 = r0.buildArraySegement(r1)
                if (r27 == 0) goto L_0x012a
                boolean r2 = r26.isEOF()
                if (r2 != 0) goto L_0x012a
                r2 = 93
                r0.accept(r2)
            L_0x012a:
                return r1
            L_0x012b:
                char r3 = r0.ch
                if (r3 != r8) goto L_0x0135
                r26.next()
                r0.accept(r9)
            L_0x0135:
                java.lang.String r3 = r26.readName()
                r26.skipWhitespace()
                r4 = 124(0x7c, float:1.74E-43)
                r8 = 38
                r14 = 32
                if (r2 == 0) goto L_0x016b
                char r15 = r0.ch
                r12 = 41
                if (r15 != r12) goto L_0x016b
                r26.next()
                com.alibaba.fastjson.JSONPath$NotNullSegement r1 = new com.alibaba.fastjson.JSONPath$NotNullSegement
                r2 = 0
                r1.<init>(r3, r2)
            L_0x0153:
                char r2 = r0.ch
                if (r2 != r14) goto L_0x015b
                r26.next()
                goto L_0x0153
            L_0x015b:
                if (r2 == r8) goto L_0x015f
                if (r2 != r4) goto L_0x0163
            L_0x015f:
                com.alibaba.fastjson.JSONPath$Filter r1 = r0.filterRest(r1)
            L_0x0163:
                if (r27 == 0) goto L_0x016a
                r12 = 93
                r0.accept(r12)
            L_0x016a:
                return r1
            L_0x016b:
                r12 = 93
                if (r27 == 0) goto L_0x01b9
                char r15 = r0.ch
                if (r15 != r12) goto L_0x01b9
                boolean r1 = r26.isEOF()
                if (r1 == 0) goto L_0x018b
                java.lang.String r1 = "last"
                boolean r1 = r3.equals(r1)
                if (r1 == 0) goto L_0x018b
                com.alibaba.fastjson.JSONPath$MultiIndexSegment r1 = new com.alibaba.fastjson.JSONPath$MultiIndexSegment
                int[] r2 = new int[]{r11}
                r1.<init>(r2)
                return r1
            L_0x018b:
                r26.next()
                com.alibaba.fastjson.JSONPath$NotNullSegement r1 = new com.alibaba.fastjson.JSONPath$NotNullSegement
                r5 = 0
                r1.<init>(r3, r5)
            L_0x0194:
                char r3 = r0.ch
                if (r3 != r14) goto L_0x019c
                r26.next()
                goto L_0x0194
            L_0x019c:
                if (r3 == r8) goto L_0x01a4
                if (r3 != r4) goto L_0x01a1
                goto L_0x01a4
            L_0x01a1:
                r3 = 41
                goto L_0x01a9
            L_0x01a4:
                com.alibaba.fastjson.JSONPath$Filter r1 = r0.filterRest(r1)
                goto L_0x01a1
            L_0x01a9:
                r0.accept(r3)
                if (r2 == 0) goto L_0x01b1
                r0.accept(r3)
            L_0x01b1:
                if (r27 == 0) goto L_0x01b8
                r2 = 93
                r0.accept(r2)
            L_0x01b8:
                return r1
            L_0x01b9:
                r26.skipWhitespace()
                char r12 = r0.ch
                r15 = 40
                if (r12 != r15) goto L_0x01cf
                r26.next()
                r12 = 41
                r0.accept(r12)
                r26.skipWhitespace()
                r12 = 1
                goto L_0x01d0
            L_0x01cf:
                r12 = 0
            L_0x01d0:
                com.alibaba.fastjson.JSONPath$Operator r15 = r26.readOp()
                r26.skipWhitespace()
                com.alibaba.fastjson.JSONPath$Operator r11 = com.alibaba.fastjson.JSONPath.Operator.BETWEEN
                if (r15 == r11) goto L_0x01df
                com.alibaba.fastjson.JSONPath$Operator r11 = com.alibaba.fastjson.JSONPath.Operator.NOT_BETWEEN
                if (r15 != r11) goto L_0x01e2
            L_0x01df:
                r7 = 0
                goto L_0x06c5
            L_0x01e2:
                com.alibaba.fastjson.JSONPath$Operator r11 = com.alibaba.fastjson.JSONPath.Operator.IN
                if (r15 == r11) goto L_0x04ca
                com.alibaba.fastjson.JSONPath$Operator r11 = com.alibaba.fastjson.JSONPath.Operator.NOT_IN
                if (r15 != r11) goto L_0x01ec
                goto L_0x04ca
            L_0x01ec:
                char r11 = r0.ch
                r16 = 0
                if (r11 == r7) goto L_0x03c1
                if (r11 != r6) goto L_0x01f6
                goto L_0x03c1
            L_0x01f6:
                boolean r6 = isDigitFirst(r11)
                if (r6 == 0) goto L_0x025a
                long r6 = r26.readLongValue()
                char r10 = r0.ch
                r16 = 0
                if (r10 != r9) goto L_0x020d
                double r9 = r0.readDoubleValue(r6)
                r21 = r9
                goto L_0x020f
            L_0x020d:
                r21 = r16
            L_0x020f:
                int r9 = (r21 > r16 ? 1 : (r21 == r16 ? 0 : -1))
                if (r9 != 0) goto L_0x0223
                com.alibaba.fastjson.JSONPath$IntOpSegement r9 = new com.alibaba.fastjson.JSONPath$IntOpSegement
                r18 = r9
                r19 = r3
                r20 = r12
                r21 = r6
                r23 = r15
                r18.<init>(r19, r20, r21, r23)
                goto L_0x0230
            L_0x0223:
                com.alibaba.fastjson.JSONPath$DoubleOpSegement r9 = new com.alibaba.fastjson.JSONPath$DoubleOpSegement
                r18 = r9
                r19 = r3
                r20 = r12
                r23 = r15
                r18.<init>(r19, r20, r21, r23)
            L_0x0230:
                char r3 = r0.ch
                if (r3 != r14) goto L_0x0238
                r26.next()
                goto L_0x0230
            L_0x0238:
                if (r1 <= r5) goto L_0x0241
                r1 = 41
                if (r3 != r1) goto L_0x0241
                r26.next()
            L_0x0241:
                char r1 = r0.ch
                if (r1 == r8) goto L_0x0247
                if (r1 != r4) goto L_0x024b
            L_0x0247:
                com.alibaba.fastjson.JSONPath$Filter r9 = r0.filterRest(r9)
            L_0x024b:
                if (r2 == 0) goto L_0x0252
                r1 = 41
                r0.accept(r1)
            L_0x0252:
                if (r27 == 0) goto L_0x0259
                r1 = 93
                r0.accept(r1)
            L_0x0259:
                return r9
            L_0x025a:
                char r1 = r0.ch
                r6 = 36
                if (r1 != r6) goto L_0x0282
                com.alibaba.fastjson.JSONPath$Segment r1 = r26.readSegement()
                com.alibaba.fastjson.JSONPath$RefOpSegement r4 = new com.alibaba.fastjson.JSONPath$RefOpSegement
                r4.<init>(r3, r12, r1, r15)
                r0.hasRefSegment = r5
            L_0x026b:
                char r1 = r0.ch
                if (r1 != r14) goto L_0x0273
                r26.next()
                goto L_0x026b
            L_0x0273:
                if (r2 == 0) goto L_0x027a
                r1 = 41
                r0.accept(r1)
            L_0x027a:
                if (r27 == 0) goto L_0x0281
                r1 = 93
                r0.accept(r1)
            L_0x0281:
                return r4
            L_0x0282:
                if (r1 != r10) goto L_0x02ca
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
            L_0x0289:
                r26.next()
                char r1 = r0.ch
                if (r1 != r10) goto L_0x02bb
                r26.next()
                char r1 = r0.ch
                r4 = 105(0x69, float:1.47E-43)
                if (r1 != r4) goto L_0x029e
                r26.next()
                r4 = 2
                goto L_0x029f
            L_0x029e:
                r4 = 0
            L_0x029f:
                java.lang.String r1 = r6.toString()
                java.util.regex.Pattern r1 = java.util.regex.Pattern.compile(r1, r4)
                com.alibaba.fastjson.JSONPath$RegMatchSegement r4 = new com.alibaba.fastjson.JSONPath$RegMatchSegement
                r4.<init>(r3, r12, r1, r15)
                if (r2 == 0) goto L_0x02b3
                r1 = 41
                r0.accept(r1)
            L_0x02b3:
                if (r27 == 0) goto L_0x02ba
                r1 = 93
                r0.accept(r1)
            L_0x02ba:
                return r4
            L_0x02bb:
                if (r1 != r13) goto L_0x02c6
                r26.next()
                char r1 = r0.ch
                r6.append(r1)
                goto L_0x0289
            L_0x02c6:
                r6.append(r1)
                goto L_0x0289
            L_0x02ca:
                r6 = 110(0x6e, float:1.54E-43)
                if (r1 != r6) goto L_0x0317
                java.lang.String r1 = r26.readName()
                java.lang.String r5 = "null"
                boolean r1 = r5.equals(r1)
                if (r1 == 0) goto L_0x03bb
                com.alibaba.fastjson.JSONPath$Operator r1 = com.alibaba.fastjson.JSONPath.Operator.EQ
                if (r15 != r1) goto L_0x02e4
                com.alibaba.fastjson.JSONPath$NullSegement r1 = new com.alibaba.fastjson.JSONPath$NullSegement
                r1.<init>(r3, r12)
                goto L_0x02f0
            L_0x02e4:
                com.alibaba.fastjson.JSONPath$Operator r1 = com.alibaba.fastjson.JSONPath.Operator.NE
                if (r15 != r1) goto L_0x02ee
                com.alibaba.fastjson.JSONPath$NotNullSegement r1 = new com.alibaba.fastjson.JSONPath$NotNullSegement
                r1.<init>(r3, r12)
                goto L_0x02f0
            L_0x02ee:
                r1 = r16
            L_0x02f0:
                if (r1 == 0) goto L_0x0302
            L_0x02f2:
                char r3 = r0.ch
                if (r3 != r14) goto L_0x02fa
                r26.next()
                goto L_0x02f2
            L_0x02fa:
                if (r3 == r8) goto L_0x02fe
                if (r3 != r4) goto L_0x0302
            L_0x02fe:
                com.alibaba.fastjson.JSONPath$Filter r1 = r0.filterRest(r1)
            L_0x0302:
                if (r2 == 0) goto L_0x0309
                r2 = 41
                r0.accept(r2)
            L_0x0309:
                r2 = 93
                r0.accept(r2)
                if (r1 == 0) goto L_0x0311
                return r1
            L_0x0311:
                java.lang.UnsupportedOperationException r1 = new java.lang.UnsupportedOperationException
                r1.<init>()
                throw r1
            L_0x0317:
                r6 = 116(0x74, float:1.63E-43)
                if (r1 != r6) goto L_0x0369
                java.lang.String r1 = r26.readName()
                java.lang.String r6 = "true"
                boolean r1 = r6.equals(r1)
                if (r1 == 0) goto L_0x03bb
                com.alibaba.fastjson.JSONPath$Operator r1 = com.alibaba.fastjson.JSONPath.Operator.EQ
                if (r15 != r1) goto L_0x0333
                com.alibaba.fastjson.JSONPath$ValueSegment r1 = new com.alibaba.fastjson.JSONPath$ValueSegment
                java.lang.Boolean r6 = java.lang.Boolean.TRUE
                r1.<init>(r3, r12, r6, r5)
                goto L_0x0342
            L_0x0333:
                com.alibaba.fastjson.JSONPath$Operator r1 = com.alibaba.fastjson.JSONPath.Operator.NE
                if (r15 != r1) goto L_0x0340
                com.alibaba.fastjson.JSONPath$ValueSegment r1 = new com.alibaba.fastjson.JSONPath$ValueSegment
                java.lang.Boolean r5 = java.lang.Boolean.TRUE
                r6 = 0
                r1.<init>(r3, r12, r5, r6)
                goto L_0x0342
            L_0x0340:
                r1 = r16
            L_0x0342:
                if (r1 == 0) goto L_0x0354
            L_0x0344:
                char r3 = r0.ch
                if (r3 != r14) goto L_0x034c
                r26.next()
                goto L_0x0344
            L_0x034c:
                if (r3 == r8) goto L_0x0350
                if (r3 != r4) goto L_0x0354
            L_0x0350:
                com.alibaba.fastjson.JSONPath$Filter r1 = r0.filterRest(r1)
            L_0x0354:
                if (r2 == 0) goto L_0x035b
                r2 = 41
                r0.accept(r2)
            L_0x035b:
                r2 = 93
                r0.accept(r2)
                if (r1 == 0) goto L_0x0363
                return r1
            L_0x0363:
                java.lang.UnsupportedOperationException r1 = new java.lang.UnsupportedOperationException
                r1.<init>()
                throw r1
            L_0x0369:
                r6 = 102(0x66, float:1.43E-43)
                if (r1 != r6) goto L_0x03bb
                java.lang.String r1 = r26.readName()
                java.lang.String r6 = "false"
                boolean r1 = r6.equals(r1)
                if (r1 == 0) goto L_0x03bb
                com.alibaba.fastjson.JSONPath$Operator r1 = com.alibaba.fastjson.JSONPath.Operator.EQ
                if (r15 != r1) goto L_0x0385
                com.alibaba.fastjson.JSONPath$ValueSegment r1 = new com.alibaba.fastjson.JSONPath$ValueSegment
                java.lang.Boolean r6 = java.lang.Boolean.FALSE
                r1.<init>(r3, r12, r6, r5)
                goto L_0x0394
            L_0x0385:
                com.alibaba.fastjson.JSONPath$Operator r1 = com.alibaba.fastjson.JSONPath.Operator.NE
                if (r15 != r1) goto L_0x0392
                com.alibaba.fastjson.JSONPath$ValueSegment r1 = new com.alibaba.fastjson.JSONPath$ValueSegment
                java.lang.Boolean r5 = java.lang.Boolean.FALSE
                r6 = 0
                r1.<init>(r3, r12, r5, r6)
                goto L_0x0394
            L_0x0392:
                r1 = r16
            L_0x0394:
                if (r1 == 0) goto L_0x03a6
            L_0x0396:
                char r3 = r0.ch
                if (r3 != r14) goto L_0x039e
                r26.next()
                goto L_0x0396
            L_0x039e:
                if (r3 == r8) goto L_0x03a2
                if (r3 != r4) goto L_0x03a6
            L_0x03a2:
                com.alibaba.fastjson.JSONPath$Filter r1 = r0.filterRest(r1)
            L_0x03a6:
                if (r2 == 0) goto L_0x03ad
                r2 = 41
                r0.accept(r2)
            L_0x03ad:
                r2 = 93
                r0.accept(r2)
                if (r1 == 0) goto L_0x03b5
                return r1
            L_0x03b5:
                java.lang.UnsupportedOperationException r1 = new java.lang.UnsupportedOperationException
                r1.<init>()
                throw r1
            L_0x03bb:
                java.lang.UnsupportedOperationException r1 = new java.lang.UnsupportedOperationException
                r1.<init>()
                throw r1
            L_0x03c1:
                java.lang.String r1 = r26.readString()
                com.alibaba.fastjson.JSONPath$Operator r6 = com.alibaba.fastjson.JSONPath.Operator.RLIKE
                if (r15 != r6) goto L_0x03d1
                com.alibaba.fastjson.JSONPath$RlikeSegement r5 = new com.alibaba.fastjson.JSONPath$RlikeSegement
                r6 = 0
                r5.<init>(r3, r12, r1, r6)
                goto L_0x04ab
            L_0x03d1:
                com.alibaba.fastjson.JSONPath$Operator r6 = com.alibaba.fastjson.JSONPath.Operator.NOT_RLIKE
                if (r15 != r6) goto L_0x03dd
                com.alibaba.fastjson.JSONPath$RlikeSegement r6 = new com.alibaba.fastjson.JSONPath$RlikeSegement
                r6.<init>(r3, r12, r1, r5)
            L_0x03da:
                r5 = r6
                goto L_0x04ab
            L_0x03dd:
                com.alibaba.fastjson.JSONPath$Operator r6 = com.alibaba.fastjson.JSONPath.Operator.LIKE
                if (r15 == r6) goto L_0x03ed
                com.alibaba.fastjson.JSONPath$Operator r6 = com.alibaba.fastjson.JSONPath.Operator.NOT_LIKE
                if (r15 != r6) goto L_0x03e6
                goto L_0x03ed
            L_0x03e6:
                com.alibaba.fastjson.JSONPath$StringOpSegement r5 = new com.alibaba.fastjson.JSONPath$StringOpSegement
                r5.<init>(r3, r12, r1, r15)
                goto L_0x04ab
            L_0x03ed:
                java.lang.String r6 = "%%"
                int r7 = r1.indexOf(r6)
                java.lang.String r9 = "%"
                r10 = -1
                if (r7 == r10) goto L_0x03fd
                java.lang.String r1 = r1.replaceAll(r6, r9)
                goto L_0x03ed
            L_0x03fd:
                com.alibaba.fastjson.JSONPath$Operator r6 = com.alibaba.fastjson.JSONPath.Operator.NOT_LIKE
                if (r15 != r6) goto L_0x0404
                r24 = 1
                goto L_0x0406
            L_0x0404:
                r24 = 0
            L_0x0406:
                r6 = 37
                int r7 = r1.indexOf(r6)
                if (r7 != r10) goto L_0x041d
                com.alibaba.fastjson.JSONPath$Operator r5 = com.alibaba.fastjson.JSONPath.Operator.LIKE
                if (r15 != r5) goto L_0x0415
                com.alibaba.fastjson.JSONPath$Operator r5 = com.alibaba.fastjson.JSONPath.Operator.EQ
                goto L_0x0417
            L_0x0415:
                com.alibaba.fastjson.JSONPath$Operator r5 = com.alibaba.fastjson.JSONPath.Operator.NE
            L_0x0417:
                com.alibaba.fastjson.JSONPath$StringOpSegement r6 = new com.alibaba.fastjson.JSONPath$StringOpSegement
                r6.<init>(r3, r12, r1, r5)
                goto L_0x03da
            L_0x041d:
                java.lang.String[] r9 = r1.split(r9)
                if (r7 != 0) goto L_0x045c
                int r7 = r1.length()
                int r7 = r7 - r5
                char r1 = r1.charAt(r7)
                if (r1 != r6) goto L_0x043e
                int r1 = r9.length
                int r1 = r1 - r5
                java.lang.String[] r6 = new java.lang.String[r1]
                r7 = 0
                java.lang.System.arraycopy(r9, r5, r6, r7, r1)
                r23 = r6
            L_0x0438:
                r21 = r16
                r22 = r21
                goto L_0x049f
            L_0x043e:
                r7 = 0
                int r1 = r9.length
                int r1 = r1 - r5
                r1 = r9[r1]
                int r6 = r9.length
                r10 = 2
                if (r6 <= r10) goto L_0x0455
                int r6 = r9.length
                int r6 = r6 - r10
                java.lang.String[] r10 = new java.lang.String[r6]
                java.lang.System.arraycopy(r9, r5, r10, r7, r6)
                r22 = r1
                r23 = r10
                r21 = r16
                goto L_0x049f
            L_0x0455:
                r22 = r1
                r21 = r16
                r23 = r21
                goto L_0x049f
            L_0x045c:
                r7 = 0
                int r10 = r1.length()
                int r10 = r10 - r5
                char r1 = r1.charAt(r10)
                if (r1 != r6) goto L_0x0477
                int r1 = r9.length
                if (r1 != r5) goto L_0x0474
                r1 = r9[r7]
            L_0x046d:
                r21 = r1
                r22 = r16
                r23 = r22
                goto L_0x049f
            L_0x0474:
                r23 = r9
                goto L_0x0438
            L_0x0477:
                int r1 = r9.length
                if (r1 != r5) goto L_0x047d
                r1 = r9[r7]
                goto L_0x046d
            L_0x047d:
                int r1 = r9.length
                r6 = 2
                if (r1 != r6) goto L_0x048c
                r1 = r9[r7]
                r5 = r9[r5]
                r21 = r1
                r22 = r5
                r23 = r16
                goto L_0x049f
            L_0x048c:
                r1 = r9[r7]
                int r10 = r9.length
                int r10 = r10 - r5
                r10 = r9[r10]
                int r11 = r9.length
                int r11 = r11 - r6
                java.lang.String[] r6 = new java.lang.String[r11]
                java.lang.System.arraycopy(r9, r5, r6, r7, r11)
                r21 = r1
                r23 = r6
                r22 = r10
            L_0x049f:
                com.alibaba.fastjson.JSONPath$MatchSegement r1 = new com.alibaba.fastjson.JSONPath$MatchSegement
                r18 = r1
                r19 = r3
                r20 = r12
                r18.<init>(r19, r20, r21, r22, r23, r24)
                r5 = r1
            L_0x04ab:
                char r1 = r0.ch
                if (r1 != r14) goto L_0x04b3
                r26.next()
                goto L_0x04ab
            L_0x04b3:
                if (r1 == r8) goto L_0x04b7
                if (r1 != r4) goto L_0x04bb
            L_0x04b7:
                com.alibaba.fastjson.JSONPath$Filter r5 = r0.filterRest(r5)
            L_0x04bb:
                if (r2 == 0) goto L_0x04c2
                r1 = 41
                r0.accept(r1)
            L_0x04c2:
                if (r27 == 0) goto L_0x04c9
                r1 = 93
                r0.accept(r1)
            L_0x04c9:
                return r5
            L_0x04ca:
                com.alibaba.fastjson.JSONPath$Operator r1 = com.alibaba.fastjson.JSONPath.Operator.NOT_IN
                if (r15 != r1) goto L_0x04d2
                r1 = 1
            L_0x04cf:
                r6 = 40
                goto L_0x04d4
            L_0x04d2:
                r1 = 0
                goto L_0x04cf
            L_0x04d4:
                r0.accept(r6)
                com.alibaba.fastjson.JSONArray r6 = new com.alibaba.fastjson.JSONArray
                r6.<init>()
                java.lang.Object r7 = r26.readValue()
                r6.add(r7)
            L_0x04e3:
                r26.skipWhitespace()
                char r7 = r0.ch
                r9 = 44
                if (r7 == r9) goto L_0x06b4
                java.util.Iterator r7 = r6.iterator()
                r9 = 1
                r10 = 1
                r11 = 1
            L_0x04f3:
                boolean r13 = r7.hasNext()
                if (r13 == 0) goto L_0x0523
                java.lang.Object r13 = r7.next()
                if (r13 != 0) goto L_0x0503
                if (r9 == 0) goto L_0x04f3
                r9 = 0
                goto L_0x04f3
            L_0x0503:
                java.lang.Class r13 = r13.getClass()
                if (r9 == 0) goto L_0x051b
                java.lang.Class<java.lang.Byte> r15 = java.lang.Byte.class
                if (r13 == r15) goto L_0x051b
                java.lang.Class<java.lang.Short> r15 = java.lang.Short.class
                if (r13 == r15) goto L_0x051b
                java.lang.Class<java.lang.Integer> r15 = java.lang.Integer.class
                if (r13 == r15) goto L_0x051b
                java.lang.Class<java.lang.Long> r15 = java.lang.Long.class
                if (r13 == r15) goto L_0x051b
                r9 = 0
                r11 = 0
            L_0x051b:
                if (r10 == 0) goto L_0x04f3
                java.lang.Class<java.lang.String> r15 = java.lang.String.class
                if (r13 == r15) goto L_0x04f3
                r10 = 0
                goto L_0x04f3
            L_0x0523:
                int r7 = r6.size()
                if (r7 != r5) goto L_0x0562
                r7 = 0
                java.lang.Object r13 = r6.get(r7)
                if (r13 != 0) goto L_0x0562
                if (r1 == 0) goto L_0x0538
                com.alibaba.fastjson.JSONPath$NotNullSegement r1 = new com.alibaba.fastjson.JSONPath$NotNullSegement
                r1.<init>(r3, r12)
                goto L_0x053d
            L_0x0538:
                com.alibaba.fastjson.JSONPath$NullSegement r1 = new com.alibaba.fastjson.JSONPath$NullSegement
                r1.<init>(r3, r12)
            L_0x053d:
                char r3 = r0.ch
                if (r3 != r14) goto L_0x0545
                r26.next()
                goto L_0x053d
            L_0x0545:
                if (r3 == r8) goto L_0x054d
                if (r3 != r4) goto L_0x054a
                goto L_0x054d
            L_0x054a:
                r3 = 41
                goto L_0x0552
            L_0x054d:
                com.alibaba.fastjson.JSONPath$Filter r1 = r0.filterRest(r1)
                goto L_0x054a
            L_0x0552:
                r0.accept(r3)
                if (r2 == 0) goto L_0x055a
                r0.accept(r3)
            L_0x055a:
                if (r27 == 0) goto L_0x0561
                r2 = 93
                r0.accept(r2)
            L_0x0561:
                return r1
            L_0x0562:
                if (r9 == 0) goto L_0x05f1
                int r7 = r6.size()
                if (r7 != r5) goto L_0x05af
                r5 = 0
                java.lang.Object r5 = r6.get(r5)
                java.lang.Number r5 = (java.lang.Number) r5
                long r21 = com.alibaba.fastjson.util.TypeUtils.longExtractValue(r5)
                if (r1 == 0) goto L_0x057c
                com.alibaba.fastjson.JSONPath$Operator r1 = com.alibaba.fastjson.JSONPath.Operator.NE
            L_0x0579:
                r23 = r1
                goto L_0x057f
            L_0x057c:
                com.alibaba.fastjson.JSONPath$Operator r1 = com.alibaba.fastjson.JSONPath.Operator.EQ
                goto L_0x0579
            L_0x057f:
                com.alibaba.fastjson.JSONPath$IntOpSegement r1 = new com.alibaba.fastjson.JSONPath$IntOpSegement
                r18 = r1
                r19 = r3
                r20 = r12
                r18.<init>(r19, r20, r21, r23)
            L_0x058a:
                char r3 = r0.ch
                if (r3 != r14) goto L_0x0592
                r26.next()
                goto L_0x058a
            L_0x0592:
                if (r3 == r8) goto L_0x059a
                if (r3 != r4) goto L_0x0597
                goto L_0x059a
            L_0x0597:
                r3 = 41
                goto L_0x059f
            L_0x059a:
                com.alibaba.fastjson.JSONPath$Filter r1 = r0.filterRest(r1)
                goto L_0x0597
            L_0x059f:
                r0.accept(r3)
                if (r2 == 0) goto L_0x05a7
                r0.accept(r3)
            L_0x05a7:
                if (r27 == 0) goto L_0x05ae
                r2 = 93
                r0.accept(r2)
            L_0x05ae:
                return r1
            L_0x05af:
                int r5 = r6.size()
                long[] r7 = new long[r5]
                r9 = 0
            L_0x05b6:
                if (r9 >= r5) goto L_0x05c7
                java.lang.Object r10 = r6.get(r9)
                java.lang.Number r10 = (java.lang.Number) r10
                long r10 = com.alibaba.fastjson.util.TypeUtils.longExtractValue(r10)
                r7[r9] = r10
                int r9 = r9 + 1
                goto L_0x05b6
            L_0x05c7:
                com.alibaba.fastjson.JSONPath$IntInSegement r5 = new com.alibaba.fastjson.JSONPath$IntInSegement
                r5.<init>(r3, r12, r7, r1)
            L_0x05cc:
                char r1 = r0.ch
                if (r1 != r14) goto L_0x05d4
                r26.next()
                goto L_0x05cc
            L_0x05d4:
                if (r1 == r8) goto L_0x05dc
                if (r1 != r4) goto L_0x05d9
                goto L_0x05dc
            L_0x05d9:
                r1 = 41
                goto L_0x05e1
            L_0x05dc:
                com.alibaba.fastjson.JSONPath$Filter r5 = r0.filterRest(r5)
                goto L_0x05d9
            L_0x05e1:
                r0.accept(r1)
                if (r2 == 0) goto L_0x05e9
                r0.accept(r1)
            L_0x05e9:
                if (r27 == 0) goto L_0x05f0
                r1 = 93
                r0.accept(r1)
            L_0x05f0:
                return r5
            L_0x05f1:
                if (r10 == 0) goto L_0x0664
                int r7 = r6.size()
                if (r7 != r5) goto L_0x0631
                r7 = 0
                java.lang.Object r5 = r6.get(r7)
                java.lang.String r5 = (java.lang.String) r5
                if (r1 == 0) goto L_0x0605
                com.alibaba.fastjson.JSONPath$Operator r1 = com.alibaba.fastjson.JSONPath.Operator.NE
                goto L_0x0607
            L_0x0605:
                com.alibaba.fastjson.JSONPath$Operator r1 = com.alibaba.fastjson.JSONPath.Operator.EQ
            L_0x0607:
                com.alibaba.fastjson.JSONPath$StringOpSegement r6 = new com.alibaba.fastjson.JSONPath$StringOpSegement
                r6.<init>(r3, r12, r5, r1)
            L_0x060c:
                char r1 = r0.ch
                if (r1 != r14) goto L_0x0614
                r26.next()
                goto L_0x060c
            L_0x0614:
                if (r1 == r8) goto L_0x061c
                if (r1 != r4) goto L_0x0619
                goto L_0x061c
            L_0x0619:
                r1 = 41
                goto L_0x0621
            L_0x061c:
                com.alibaba.fastjson.JSONPath$Filter r6 = r0.filterRest(r6)
                goto L_0x0619
            L_0x0621:
                r0.accept(r1)
                if (r2 == 0) goto L_0x0629
                r0.accept(r1)
            L_0x0629:
                if (r27 == 0) goto L_0x0630
                r1 = 93
                r0.accept(r1)
            L_0x0630:
                return r6
            L_0x0631:
                int r5 = r6.size()
                java.lang.String[] r5 = new java.lang.String[r5]
                r6.toArray(r5)
                com.alibaba.fastjson.JSONPath$StringInSegement r6 = new com.alibaba.fastjson.JSONPath$StringInSegement
                r6.<init>(r3, r12, r5, r1)
            L_0x063f:
                char r1 = r0.ch
                if (r1 != r14) goto L_0x0647
                r26.next()
                goto L_0x063f
            L_0x0647:
                if (r1 == r8) goto L_0x064f
                if (r1 != r4) goto L_0x064c
                goto L_0x064f
            L_0x064c:
                r1 = 41
                goto L_0x0654
            L_0x064f:
                com.alibaba.fastjson.JSONPath$Filter r6 = r0.filterRest(r6)
                goto L_0x064c
            L_0x0654:
                r0.accept(r1)
                if (r2 == 0) goto L_0x065c
                r0.accept(r1)
            L_0x065c:
                if (r27 == 0) goto L_0x0663
                r1 = 93
                r0.accept(r1)
            L_0x0663:
                return r6
            L_0x0664:
                r7 = 0
                if (r11 == 0) goto L_0x06ae
                int r5 = r6.size()
                java.lang.Long[] r9 = new java.lang.Long[r5]
            L_0x066d:
                if (r7 >= r5) goto L_0x0684
                java.lang.Object r10 = r6.get(r7)
                java.lang.Number r10 = (java.lang.Number) r10
                if (r10 == 0) goto L_0x0681
                long r10 = com.alibaba.fastjson.util.TypeUtils.longExtractValue(r10)
                java.lang.Long r10 = java.lang.Long.valueOf(r10)
                r9[r7] = r10
            L_0x0681:
                int r7 = r7 + 1
                goto L_0x066d
            L_0x0684:
                com.alibaba.fastjson.JSONPath$IntObjInSegement r5 = new com.alibaba.fastjson.JSONPath$IntObjInSegement
                r5.<init>(r3, r12, r9, r1)
            L_0x0689:
                char r1 = r0.ch
                if (r1 != r14) goto L_0x0691
                r26.next()
                goto L_0x0689
            L_0x0691:
                if (r1 == r8) goto L_0x0699
                if (r1 != r4) goto L_0x0696
                goto L_0x0699
            L_0x0696:
                r9 = 41
                goto L_0x069e
            L_0x0699:
                com.alibaba.fastjson.JSONPath$Filter r5 = r0.filterRest(r5)
                goto L_0x0696
            L_0x069e:
                r0.accept(r9)
                if (r2 == 0) goto L_0x06a6
                r0.accept(r9)
            L_0x06a6:
                if (r27 == 0) goto L_0x06ad
                r10 = 93
                r0.accept(r10)
            L_0x06ad:
                return r5
            L_0x06ae:
                java.lang.UnsupportedOperationException r1 = new java.lang.UnsupportedOperationException
                r1.<init>()
                throw r1
            L_0x06b4:
                r7 = 0
                r9 = 41
                r10 = 93
                r26.next()
                java.lang.Object r11 = r26.readValue()
                r6.add(r11)
                goto L_0x04e3
            L_0x06c5:
                com.alibaba.fastjson.JSONPath$Operator r1 = com.alibaba.fastjson.JSONPath.Operator.NOT_BETWEEN
                if (r15 != r1) goto L_0x06cc
                r25 = 1
                goto L_0x06ce
            L_0x06cc:
                r25 = 0
            L_0x06ce:
                java.lang.Object r1 = r26.readValue()
                java.lang.String r2 = r26.readName()
                java.lang.String r4 = "and"
                boolean r2 = r4.equalsIgnoreCase(r2)
                if (r2 == 0) goto L_0x0722
                java.lang.Object r2 = r26.readValue()
                if (r1 == 0) goto L_0x071a
                if (r2 == 0) goto L_0x071a
                java.lang.Class r4 = r1.getClass()
                boolean r4 = com.alibaba.fastjson.JSONPath.isInt(r4)
                if (r4 == 0) goto L_0x0712
                java.lang.Class r4 = r2.getClass()
                boolean r4 = com.alibaba.fastjson.JSONPath.isInt(r4)
                if (r4 == 0) goto L_0x0712
                com.alibaba.fastjson.JSONPath$IntBetweenSegement r4 = new com.alibaba.fastjson.JSONPath$IntBetweenSegement
                java.lang.Number r1 = (java.lang.Number) r1
                long r21 = com.alibaba.fastjson.util.TypeUtils.longExtractValue(r1)
                java.lang.Number r2 = (java.lang.Number) r2
                long r23 = com.alibaba.fastjson.util.TypeUtils.longExtractValue(r2)
                r18 = r4
                r19 = r3
                r20 = r12
                r18.<init>(r19, r20, r21, r23, r25)
                return r4
            L_0x0712:
                com.alibaba.fastjson.JSONPathException r1 = new com.alibaba.fastjson.JSONPathException
                java.lang.String r2 = r0.path
                r1.<init>(r2)
                throw r1
            L_0x071a:
                com.alibaba.fastjson.JSONPathException r1 = new com.alibaba.fastjson.JSONPathException
                java.lang.String r2 = r0.path
                r1.<init>(r2)
                throw r1
            L_0x0722:
                com.alibaba.fastjson.JSONPathException r1 = new com.alibaba.fastjson.JSONPathException
                java.lang.String r2 = r0.path
                r1.<init>(r2)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.JSONPath.JSONPathParser.parseArrayAccessFilter(boolean):java.lang.Object");
        }

        public double readDoubleValue(long j) {
            int i = this.pos - 1;
            next();
            while (true) {
                char c = this.ch;
                if (c < '0' || c > '9') {
                } else {
                    next();
                }
            }
            return Double.parseDouble(this.path.substring(i, this.pos - 1)) + ((double) j);
        }

        public long readLongValue() {
            int i = this.pos - 1;
            char c = this.ch;
            if (c == '+' || c == '-') {
                next();
            }
            while (true) {
                char c2 = this.ch;
                if (c2 < '0' || c2 > '9') {
                } else {
                    next();
                }
            }
            return Long.parseLong(this.path.substring(i, this.pos - 1));
        }

        public String readName() {
            skipWhitespace();
            char c = this.ch;
            if (c == '\\' || Character.isJavaIdentifierStart(c)) {
                StringBuilder sb = new StringBuilder();
                while (!isEOF()) {
                    char c2 = this.ch;
                    if (c2 == '\\') {
                        next();
                        sb.append(this.ch);
                        if (isEOF()) {
                            return sb.toString();
                        }
                        next();
                    } else if (!Character.isJavaIdentifierPart(c2)) {
                        break;
                    } else {
                        sb.append(this.ch);
                        next();
                    }
                }
                if (isEOF() && Character.isJavaIdentifierPart(this.ch)) {
                    sb.append(this.ch);
                }
                return sb.toString();
            }
            throw new JSONPathException("illeal jsonpath syntax. " + this.path);
        }

        public Operator readOp() {
            Operator operator;
            char c = this.ch;
            if (c == '=') {
                next();
                char c2 = this.ch;
                if (c2 == '~') {
                    next();
                    operator = Operator.REG_MATCH;
                } else if (c2 == '=') {
                    next();
                    operator = Operator.EQ;
                } else {
                    operator = Operator.EQ;
                }
            } else if (c == '!') {
                next();
                accept('=');
                operator = Operator.NE;
            } else if (c == '<') {
                next();
                if (this.ch == '=') {
                    next();
                    operator = Operator.LE;
                } else {
                    operator = Operator.LT;
                }
            } else if (c == '>') {
                next();
                if (this.ch == '=') {
                    next();
                    operator = Operator.GE;
                } else {
                    operator = Operator.GT;
                }
            } else {
                operator = null;
            }
            if (operator != null) {
                return operator;
            }
            String readName = readName();
            if ("not".equalsIgnoreCase(readName)) {
                skipWhitespace();
                String readName2 = readName();
                if ("like".equalsIgnoreCase(readName2)) {
                    return Operator.NOT_LIKE;
                }
                if ("rlike".equalsIgnoreCase(readName2)) {
                    return Operator.NOT_RLIKE;
                }
                if ("in".equalsIgnoreCase(readName2)) {
                    return Operator.NOT_IN;
                }
                if ("between".equalsIgnoreCase(readName2)) {
                    return Operator.NOT_BETWEEN;
                }
                throw new UnsupportedOperationException();
            } else if ("nin".equalsIgnoreCase(readName)) {
                return Operator.NOT_IN;
            } else {
                if ("like".equalsIgnoreCase(readName)) {
                    return Operator.LIKE;
                }
                if ("rlike".equalsIgnoreCase(readName)) {
                    return Operator.RLIKE;
                }
                if ("in".equalsIgnoreCase(readName)) {
                    return Operator.IN;
                }
                if ("between".equalsIgnoreCase(readName)) {
                    return Operator.BETWEEN;
                }
                throw new UnsupportedOperationException();
            }
        }

        public Segment readSegement() {
            boolean z;
            boolean z2 = true;
            if (this.level == 0 && this.path.length() == 1) {
                if (isDigitFirst(this.ch)) {
                    return new ArrayAccessSegment(this.ch - '0');
                }
                char c = this.ch;
                if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                    return new PropertySegment(Character.toString(c), false);
                }
            }
            while (!isEOF()) {
                skipWhitespace();
                char c2 = this.ch;
                if (c2 == '$') {
                    next();
                    skipWhitespace();
                    if (this.ch == '?') {
                        return new FilterSegment((Filter) parseArrayAccessFilter(false));
                    }
                } else if (c2 == '.' || c2 == '/') {
                    next();
                    if (c2 == '.' && this.ch == '.') {
                        next();
                        int length = this.path.length();
                        int i = this.pos;
                        if (length > i + 3 && this.ch == '[' && this.path.charAt(i) == '*' && this.path.charAt(this.pos + 1) == ']' && this.path.charAt(this.pos + 2) == '.') {
                            next();
                            next();
                            next();
                            next();
                        }
                        z = true;
                    } else {
                        z = false;
                    }
                    char c3 = this.ch;
                    if (c3 == '*' || (z && c3 == '[')) {
                        if (c3 != '[') {
                            z2 = false;
                        }
                        if (!isEOF()) {
                            next();
                        }
                        if (!z) {
                            return WildCardSegment.instance;
                        }
                        if (z2) {
                            return WildCardSegment.instance_deep_objectOnly;
                        }
                        return WildCardSegment.instance_deep;
                    } else if (isDigitFirst(c3)) {
                        return parseArrayAccess(false);
                    } else {
                        String readName = readName();
                        if (this.ch != '(') {
                            return new PropertySegment(readName, z);
                        }
                        next();
                        if (this.ch == ')') {
                            if (!isEOF()) {
                                next();
                            }
                            if (MapBundleKey.OfflineMapKey.OFFLINE_TOTAL_SIZE.equals(readName) || "length".equals(readName)) {
                                return SizeSegment.instance;
                            }
                            if ("max".equals(readName)) {
                                return MaxSegment.instance;
                            }
                            if ("min".equals(readName)) {
                                return MinSegment.instance;
                            }
                            if ("keySet".equals(readName)) {
                                return KeySetSegment.instance;
                            }
                            if ("type".equals(readName)) {
                                return TypeSegment.instance;
                            }
                            if ("floor".equals(readName)) {
                                return FloorSegment.instance;
                            }
                            throw new JSONPathException("not support jsonpath : " + this.path);
                        }
                        throw new JSONPathException("not support jsonpath : " + this.path);
                    }
                } else if (c2 == '[') {
                    return parseArrayAccess(true);
                } else {
                    if (this.level == 0) {
                        return new PropertySegment(readName(), false);
                    }
                    if (c2 == '?') {
                        return new FilterSegment((Filter) parseArrayAccessFilter(false));
                    }
                    throw new JSONPathException("not support jsonpath : " + this.path);
                }
            }
            return null;
        }

        public String readString() {
            int i;
            char c = this.ch;
            next();
            int i2 = this.pos - 1;
            while (this.ch != c && !isEOF()) {
                next();
            }
            String str = this.path;
            if (isEOF()) {
                i = this.pos;
            } else {
                i = this.pos - 1;
            }
            String substring = str.substring(i2, i);
            accept(c);
            return substring;
        }

        public Object readValue() {
            skipWhitespace();
            if (isDigitFirst(this.ch)) {
                return Long.valueOf(readLongValue());
            }
            char c = this.ch;
            if (c == '\"' || c == '\'') {
                return readString();
            }
            if (c != 'n') {
                throw new UnsupportedOperationException();
            } else if ("null".equals(readName())) {
                return null;
            } else {
                throw new JSONPathException(this.path);
            }
        }

        public final void skipWhitespace() {
            while (true) {
                char c = this.ch;
                if (c > ' ') {
                    return;
                }
                if (c == ' ' || c == 13 || c == 10 || c == 9 || c == 12 || c == 8) {
                    next();
                } else {
                    return;
                }
            }
        }
    }

    public static class KeySetSegment implements Segment {
        public static final KeySetSegment instance = new KeySetSegment();

        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            return jSONPath.evalKeySet(obj2);
        }

        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            throw new UnsupportedOperationException();
        }
    }

    public static class MatchSegement extends PropertyFilter {
        private final String[] containsValues;
        private final String endsWithValue;
        private final int minLength;
        private final boolean not;
        private final String startsWithValue;

        public MatchSegement(String str, boolean z, String str2, String str3, String[] strArr, boolean z2) {
            super(str, z);
            int i;
            this.startsWithValue = str2;
            this.endsWithValue = str3;
            this.containsValues = strArr;
            this.not = z2;
            if (str2 != null) {
                i = str2.length();
            } else {
                i = 0;
            }
            i = str3 != null ? i + str3.length() : i;
            if (strArr != null) {
                for (String length : strArr) {
                    i += length.length();
                }
            }
            this.minLength = i;
        }

        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            int i;
            Object obj4 = get(jSONPath, obj, obj3);
            if (obj4 == null) {
                return false;
            }
            String obj5 = obj4.toString();
            if (obj5.length() < this.minLength) {
                return this.not;
            }
            String str = this.startsWithValue;
            if (str == null) {
                i = 0;
            } else if (!obj5.startsWith(str)) {
                return this.not;
            } else {
                i = this.startsWithValue.length();
            }
            String[] strArr = this.containsValues;
            if (strArr != null) {
                for (String str2 : strArr) {
                    int indexOf = obj5.indexOf(str2, i);
                    if (indexOf == -1) {
                        return this.not;
                    }
                    i = indexOf + str2.length();
                }
            }
            String str3 = this.endsWithValue;
            if (str3 == null || obj5.endsWith(str3)) {
                return !this.not;
            }
            return this.not;
        }
    }

    public static class MaxSegment implements Segment {
        public static final MaxSegment instance = new MaxSegment();

        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            if (obj2 instanceof Collection) {
                Object obj3 = null;
                for (Object next : (Collection) obj2) {
                    if (next != null && (obj3 == null || JSONPath.compare(obj3, next) < 0)) {
                        obj3 = next;
                    }
                }
                return obj3;
            }
            throw new UnsupportedOperationException();
        }

        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            throw new UnsupportedOperationException();
        }
    }

    public static class MinSegment implements Segment {
        public static final MinSegment instance = new MinSegment();

        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            if (obj2 instanceof Collection) {
                Object obj3 = null;
                for (Object next : (Collection) obj2) {
                    if (next != null && (obj3 == null || JSONPath.compare(obj3, next) > 0)) {
                        obj3 = next;
                    }
                }
                return obj3;
            }
            throw new UnsupportedOperationException();
        }

        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            throw new UnsupportedOperationException();
        }
    }

    public static class MultiIndexSegment implements Segment {
        private final int[] indexes;

        public MultiIndexSegment(int[] iArr) {
            this.indexes = iArr;
        }

        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            JSONArray jSONArray = new JSONArray(this.indexes.length);
            int i = 0;
            while (true) {
                int[] iArr = this.indexes;
                if (i >= iArr.length) {
                    return jSONArray;
                }
                jSONArray.add(jSONPath.getArrayItem(obj2, iArr[i]));
                i++;
            }
        }

        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            if (context.eval) {
                Object parse = defaultJSONParser.parse();
                if (parse instanceof List) {
                    int[] iArr = this.indexes;
                    int length = iArr.length;
                    int[] iArr2 = new int[length];
                    boolean z = false;
                    System.arraycopy(iArr, 0, iArr2, 0, length);
                    if (iArr2[0] >= 0) {
                        z = true;
                    }
                    List list = (List) parse;
                    if (z) {
                        for (int size = list.size() - 1; size >= 0; size--) {
                            if (Arrays.binarySearch(iArr2, size) < 0) {
                                list.remove(size);
                            }
                        }
                        context.object = list;
                        return;
                    }
                }
            }
            throw new UnsupportedOperationException();
        }
    }

    public static class MultiPropertySegment implements Segment {
        private final String[] propertyNames;
        private final long[] propertyNamesHash;

        public MultiPropertySegment(String[] strArr) {
            this.propertyNames = strArr;
            this.propertyNamesHash = new long[strArr.length];
            int i = 0;
            while (true) {
                long[] jArr = this.propertyNamesHash;
                if (i < jArr.length) {
                    jArr[i] = TypeUtils.fnv1a_64(strArr[i]);
                    i++;
                } else {
                    return;
                }
            }
        }

        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            ArrayList arrayList = new ArrayList(this.propertyNames.length);
            int i = 0;
            while (true) {
                String[] strArr = this.propertyNames;
                if (i >= strArr.length) {
                    return arrayList;
                }
                arrayList.add(jSONPath.getPropertyValue(obj2, strArr[i], this.propertyNamesHash[i]));
                i++;
            }
        }

        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            JSONArray jSONArray;
            Object obj;
            JSONLexerBase jSONLexerBase = (JSONLexerBase) defaultJSONParser.lexer;
            Object obj2 = context.object;
            if (obj2 == null) {
                jSONArray = new JSONArray();
                context.object = jSONArray;
            } else {
                jSONArray = (JSONArray) obj2;
            }
            for (int size = jSONArray.size(); size < this.propertyNamesHash.length; size++) {
                jSONArray.add((Object) null);
            }
            do {
                int seekObjectToField = jSONLexerBase.seekObjectToField(this.propertyNamesHash);
                if (jSONLexerBase.matchStat == 3) {
                    int i = jSONLexerBase.token();
                    if (i == 2) {
                        obj = jSONLexerBase.integerValue();
                        jSONLexerBase.nextToken(16);
                    } else if (i == 3) {
                        obj = jSONLexerBase.decimalValue();
                        jSONLexerBase.nextToken(16);
                    } else if (i != 4) {
                        obj = defaultJSONParser.parse();
                    } else {
                        obj = jSONLexerBase.stringVal();
                        jSONLexerBase.nextToken(16);
                    }
                    jSONArray.set(seekObjectToField, obj);
                } else {
                    return;
                }
            } while (jSONLexerBase.token() == 16);
        }
    }

    public static class NotNullSegement extends PropertyFilter {
        public NotNullSegement(String str, boolean z) {
            super(str, z);
        }

        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            if (jSONPath.getPropertyValue(obj3, this.propertyName, this.propertyNameHash) != null) {
                return true;
            }
            return false;
        }
    }

    public static class NullSegement extends PropertyFilter {
        public NullSegement(String str, boolean z) {
            super(str, z);
        }

        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            if (get(jSONPath, obj, obj3) == null) {
                return true;
            }
            return false;
        }
    }

    public enum Operator {
        EQ,
        NE,
        GT,
        GE,
        LT,
        LE,
        LIKE,
        NOT_LIKE,
        RLIKE,
        NOT_RLIKE,
        IN,
        NOT_IN,
        BETWEEN,
        NOT_BETWEEN,
        And,
        Or,
        REG_MATCH
    }

    public static abstract class PropertyFilter implements Filter {
        static long TYPE = TypeUtils.fnv1a_64("type");
        protected final boolean function;
        protected Segment functionExpr;
        protected final String propertyName;
        protected final long propertyNameHash;

        public PropertyFilter(String str, boolean z) {
            this.propertyName = str;
            long fnv1a_64 = TypeUtils.fnv1a_64(str);
            this.propertyNameHash = fnv1a_64;
            this.function = z;
            if (!z) {
                return;
            }
            if (fnv1a_64 == TYPE) {
                this.functionExpr = TypeSegment.instance;
            } else if (fnv1a_64 == JSONPath.SIZE) {
                this.functionExpr = SizeSegment.instance;
            } else {
                throw new JSONPathException("unsupported funciton : " + str);
            }
        }

        public Object get(JSONPath jSONPath, Object obj, Object obj2) {
            Segment segment = this.functionExpr;
            if (segment != null) {
                return segment.eval(jSONPath, obj, obj2);
            }
            return jSONPath.getPropertyValue(obj2, this.propertyName, this.propertyNameHash);
        }
    }

    public static class PropertySegment implements Segment {
        /* access modifiers changed from: private */
        public final boolean deep;
        /* access modifiers changed from: private */
        public final String propertyName;
        private final long propertyNameHash;

        public PropertySegment(String str, boolean z) {
            this.propertyName = str;
            this.propertyNameHash = TypeUtils.fnv1a_64(str);
            this.deep = z;
        }

        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            if (!this.deep) {
                return jSONPath.getPropertyValue(obj2, this.propertyName, this.propertyNameHash);
            }
            ArrayList arrayList = new ArrayList();
            jSONPath.deepScan(obj2, this.propertyName, arrayList);
            return arrayList;
        }

        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            Object obj;
            Object obj2;
            JSONArray jSONArray;
            Object obj3;
            Context context2 = context;
            JSONLexerBase jSONLexerBase = (JSONLexerBase) defaultJSONParser.lexer;
            if (this.deep && context2.object == null) {
                context2.object = new JSONArray();
            }
            if (jSONLexerBase.token() != 14) {
                boolean z = this.deep;
                if (z) {
                    while (true) {
                        int seekObjectToField = jSONLexerBase.seekObjectToField(this.propertyNameHash, this.deep);
                        if (seekObjectToField != -1) {
                            if (seekObjectToField == 3) {
                                if (context2.eval) {
                                    int i = jSONLexerBase.token();
                                    if (i == 2) {
                                        obj = jSONLexerBase.integerValue();
                                        jSONLexerBase.nextToken(16);
                                    } else if (i == 3) {
                                        obj = jSONLexerBase.decimalValue();
                                        jSONLexerBase.nextToken(16);
                                    } else if (i != 4) {
                                        obj = defaultJSONParser.parse();
                                    } else {
                                        obj = jSONLexerBase.stringVal();
                                        jSONLexerBase.nextToken(16);
                                    }
                                    if (context2.eval) {
                                        Object obj4 = context2.object;
                                        if (obj4 instanceof List) {
                                            List list = (List) obj4;
                                            if (list.size() != 0 || !(obj instanceof List)) {
                                                list.add(obj);
                                            } else {
                                                context2.object = obj;
                                            }
                                        } else {
                                            context2.object = obj;
                                        }
                                    }
                                }
                            } else if (seekObjectToField == 1 || seekObjectToField == 2) {
                                extract(jSONPath, defaultJSONParser, context);
                            }
                        } else {
                            return;
                        }
                    }
                } else if (jSONLexerBase.seekObjectToField(this.propertyNameHash, z) == 3 && context2.eval) {
                    int i2 = jSONLexerBase.token();
                    if (i2 == 2) {
                        obj2 = jSONLexerBase.integerValue();
                        jSONLexerBase.nextToken(16);
                    } else if (i2 == 3) {
                        obj2 = jSONLexerBase.decimalValue();
                        jSONLexerBase.nextToken(16);
                    } else if (i2 != 4) {
                        obj2 = defaultJSONParser.parse();
                    } else {
                        obj2 = jSONLexerBase.stringVal();
                        jSONLexerBase.nextToken(16);
                    }
                    if (context2.eval) {
                        context2.object = obj2;
                    }
                }
            } else if (!"*".equals(this.propertyName)) {
                jSONLexerBase.nextToken();
                if (this.deep) {
                    jSONArray = (JSONArray) context2.object;
                } else {
                    jSONArray = new JSONArray();
                }
                while (true) {
                    int i3 = jSONLexerBase.token();
                    if (i3 == 12) {
                        boolean z2 = this.deep;
                        if (z2) {
                            extract(jSONPath, defaultJSONParser, context);
                        } else {
                            int seekObjectToField2 = jSONLexerBase.seekObjectToField(this.propertyNameHash, z2);
                            if (seekObjectToField2 == 3) {
                                int i4 = jSONLexerBase.token();
                                if (i4 == 2) {
                                    obj3 = jSONLexerBase.integerValue();
                                    jSONLexerBase.nextToken();
                                } else if (i4 != 4) {
                                    obj3 = defaultJSONParser.parse();
                                } else {
                                    obj3 = jSONLexerBase.stringVal();
                                    jSONLexerBase.nextToken();
                                }
                                jSONArray.add(obj3);
                                if (jSONLexerBase.token() == 13) {
                                    jSONLexerBase.nextToken();
                                } else {
                                    jSONLexerBase.skipObject(false);
                                }
                            } else if (seekObjectToField2 == -1) {
                                continue;
                            } else if (!this.deep) {
                                jSONLexerBase.skipObject(false);
                            } else {
                                throw new UnsupportedOperationException(jSONLexerBase.info());
                            }
                        }
                    } else if (i3 != 14) {
                        switch (i3) {
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                                jSONLexerBase.nextToken();
                                break;
                        }
                    } else if (this.deep) {
                        extract(jSONPath, defaultJSONParser, context);
                    } else {
                        jSONLexerBase.skipObject(false);
                    }
                    if (jSONLexerBase.token() == 15) {
                        jSONLexerBase.nextToken();
                        if (!this.deep && jSONArray.size() > 0) {
                            context2.object = jSONArray;
                            return;
                        }
                        return;
                    } else if (jSONLexerBase.token() == 16) {
                        jSONLexerBase.nextToken();
                    } else {
                        throw new JSONException("illegal json : " + jSONLexerBase.info());
                    }
                }
            }
        }

        public boolean remove(JSONPath jSONPath, Object obj) {
            return jSONPath.removePropertyValue(obj, this.propertyName, this.deep);
        }

        public void setValue(JSONPath jSONPath, Object obj, Object obj2) {
            if (this.deep) {
                jSONPath.deepSet(obj, this.propertyName, this.propertyNameHash, obj2);
                return;
            }
            jSONPath.setPropertyValue(obj, this.propertyName, this.propertyNameHash, obj2);
        }
    }

    public static class RangeSegment implements Segment {
        private final int end;
        private final int start;
        private final int step;

        public RangeSegment(int i, int i2, int i3) {
            this.start = i;
            this.end = i2;
            this.step = i3;
        }

        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            int intValue = SizeSegment.instance.eval(jSONPath, obj, obj2).intValue();
            int i = this.start;
            if (i < 0) {
                i += intValue;
            }
            int i2 = this.end;
            if (i2 < 0) {
                i2 += intValue;
            }
            int i3 = ((i2 - i) / this.step) + 1;
            if (i3 == -1) {
                return null;
            }
            ArrayList arrayList = new ArrayList(i3);
            while (i <= i2 && i < intValue) {
                arrayList.add(jSONPath.getArrayItem(obj2, i));
                i += this.step;
            }
            return arrayList;
        }

        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            throw new UnsupportedOperationException();
        }
    }

    public static class RefOpSegement extends PropertyFilter {
        private final Operator op;
        private final Segment refSgement;

        public RefOpSegement(String str, boolean z, Segment segment, Operator operator) {
            super(str, z);
            this.refSgement = segment;
            this.op = operator;
        }

        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object obj4 = get(jSONPath, obj, obj3);
            if (obj4 == null || !(obj4 instanceof Number)) {
                return false;
            }
            Object eval = this.refSgement.eval(jSONPath, obj, obj);
            if ((eval instanceof Integer) || (eval instanceof Long) || (eval instanceof Short) || (eval instanceof Byte)) {
                long longExtractValue = TypeUtils.longExtractValue((Number) eval);
                if ((obj4 instanceof Integer) || (obj4 instanceof Long) || (obj4 instanceof Short) || (obj4 instanceof Byte)) {
                    long longExtractValue2 = TypeUtils.longExtractValue((Number) obj4);
                    switch (AnonymousClass1.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.op.ordinal()]) {
                        case 1:
                            if (longExtractValue2 == longExtractValue) {
                                return true;
                            }
                            return false;
                        case 2:
                            if (longExtractValue2 != longExtractValue) {
                                return true;
                            }
                            return false;
                        case 3:
                            if (longExtractValue2 >= longExtractValue) {
                                return true;
                            }
                            return false;
                        case 4:
                            if (longExtractValue2 > longExtractValue) {
                                return true;
                            }
                            return false;
                        case 5:
                            if (longExtractValue2 <= longExtractValue) {
                                return true;
                            }
                            return false;
                        case 6:
                            if (longExtractValue2 < longExtractValue) {
                                return true;
                            }
                            return false;
                    }
                } else if (obj4 instanceof BigDecimal) {
                    int compareTo = BigDecimal.valueOf(longExtractValue).compareTo((BigDecimal) obj4);
                    switch (AnonymousClass1.$SwitchMap$com$alibaba$fastjson$JSONPath$Operator[this.op.ordinal()]) {
                        case 1:
                            if (compareTo == 0) {
                                return true;
                            }
                            return false;
                        case 2:
                            if (compareTo != 0) {
                                return true;
                            }
                            return false;
                        case 3:
                            if (compareTo <= 0) {
                                return true;
                            }
                            return false;
                        case 4:
                            if (compareTo < 0) {
                                return true;
                            }
                            return false;
                        case 5:
                            if (compareTo >= 0) {
                                return true;
                            }
                            return false;
                        case 6:
                            if (compareTo > 0) {
                                return true;
                            }
                            return false;
                        default:
                            return false;
                    }
                }
            }
            throw new UnsupportedOperationException();
        }
    }

    public static class RegMatchSegement extends PropertyFilter {
        private final Operator op;
        private final Pattern pattern;

        public RegMatchSegement(String str, boolean z, Pattern pattern2, Operator operator) {
            super(str, z);
            this.pattern = pattern2;
            this.op = operator;
        }

        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object obj4 = get(jSONPath, obj, obj3);
            if (obj4 == null) {
                return false;
            }
            return this.pattern.matcher(obj4.toString()).matches();
        }
    }

    public static class RlikeSegement extends PropertyFilter {
        private final boolean not;
        private final Pattern pattern;

        public RlikeSegement(String str, boolean z, String str2, boolean z2) {
            super(str, z);
            this.pattern = Pattern.compile(str2);
            this.not = z2;
        }

        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object obj4 = get(jSONPath, obj, obj3);
            if (obj4 == null) {
                return false;
            }
            boolean matches = this.pattern.matcher(obj4.toString()).matches();
            if (this.not) {
                return !matches;
            }
            return matches;
        }
    }

    public interface Segment {
        Object eval(JSONPath jSONPath, Object obj, Object obj2);

        void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context);
    }

    public static class SizeSegment implements Segment {
        public static final SizeSegment instance = new SizeSegment();

        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            context.object = Integer.valueOf(jSONPath.evalSize(defaultJSONParser.parse()));
        }

        public Integer eval(JSONPath jSONPath, Object obj, Object obj2) {
            return Integer.valueOf(jSONPath.evalSize(obj2));
        }
    }

    public static class StringInSegement extends PropertyFilter {
        private final boolean not;
        private final String[] values;

        public StringInSegement(String str, boolean z, String[] strArr, boolean z2) {
            super(str, z);
            this.values = strArr;
            this.not = z2;
        }

        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object obj4 = get(jSONPath, obj, obj3);
            for (String str : this.values) {
                if (str == obj4) {
                    return !this.not;
                }
                if (str != null && str.equals(obj4)) {
                    return !this.not;
                }
            }
            return this.not;
        }
    }

    public static class StringOpSegement extends PropertyFilter {
        private final Operator op;
        private final String value;

        public StringOpSegement(String str, boolean z, String str2, Operator operator) {
            super(str, z);
            this.value = str2;
            this.op = operator;
        }

        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            Object obj4 = get(jSONPath, obj, obj3);
            Operator operator = this.op;
            if (operator == Operator.EQ) {
                return this.value.equals(obj4);
            }
            if (operator == Operator.NE) {
                return !this.value.equals(obj4);
            }
            if (obj4 == null) {
                return false;
            }
            int compareTo = this.value.compareTo(obj4.toString());
            Operator operator2 = this.op;
            if (operator2 == Operator.GE) {
                if (compareTo <= 0) {
                    return true;
                }
                return false;
            } else if (operator2 == Operator.GT) {
                if (compareTo < 0) {
                    return true;
                }
                return false;
            } else if (operator2 == Operator.LE) {
                if (compareTo >= 0) {
                    return true;
                }
                return false;
            } else if (operator2 != Operator.LT || compareTo <= 0) {
                return false;
            } else {
                return true;
            }
        }
    }

    public static class TypeSegment implements Segment {
        public static final TypeSegment instance = new TypeSegment();

        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            throw new UnsupportedOperationException();
        }

        public String eval(JSONPath jSONPath, Object obj, Object obj2) {
            if (obj2 == null) {
                return "null";
            }
            if (obj2 instanceof Collection) {
                return "array";
            }
            if (obj2 instanceof Number) {
                return "number";
            }
            if (obj2 instanceof Boolean) {
                return TypedValues.Custom.S_BOOLEAN;
            }
            if ((obj2 instanceof String) || (obj2 instanceof UUID) || (obj2 instanceof Enum)) {
                return TypedValues.Custom.S_STRING;
            }
            return "object";
        }
    }

    public static class ValueSegment extends PropertyFilter {
        private boolean eq = true;
        private final Object value;

        public ValueSegment(String str, boolean z, Object obj, boolean z2) {
            super(str, z);
            if (obj != null) {
                this.value = obj;
                this.eq = z2;
                return;
            }
            throw new IllegalArgumentException("value is null");
        }

        public boolean apply(JSONPath jSONPath, Object obj, Object obj2, Object obj3) {
            boolean equals = this.value.equals(get(jSONPath, obj, obj3));
            if (!this.eq) {
                return !equals;
            }
            return equals;
        }
    }

    public static class WildCardSegment implements Segment {
        public static final WildCardSegment instance = new WildCardSegment(false, false);
        public static final WildCardSegment instance_deep = new WildCardSegment(true, false);
        public static final WildCardSegment instance_deep_objectOnly = new WildCardSegment(true, true);
        private boolean deep;
        private boolean objectOnly;

        private WildCardSegment(boolean z, boolean z2) {
            this.deep = z;
            this.objectOnly = z2;
        }

        public Object eval(JSONPath jSONPath, Object obj, Object obj2) {
            if (!this.deep) {
                return jSONPath.getPropertyValues(obj2);
            }
            ArrayList arrayList = new ArrayList();
            jSONPath.deepGetPropertyValues(obj2, arrayList);
            return arrayList;
        }

        public void extract(JSONPath jSONPath, DefaultJSONParser defaultJSONParser, Context context) {
            if (context.eval) {
                Object parse = defaultJSONParser.parse();
                if (this.deep) {
                    ArrayList arrayList = new ArrayList();
                    if (this.objectOnly) {
                        jSONPath.deepGetObjects(parse, arrayList);
                    } else {
                        jSONPath.deepGetPropertyValues(parse, arrayList);
                    }
                    context.object = arrayList;
                    return;
                } else if (parse instanceof JSONObject) {
                    Collection<Object> values = ((JSONObject) parse).values();
                    JSONArray jSONArray = new JSONArray(values.size());
                    jSONArray.addAll(values);
                    context.object = jSONArray;
                    return;
                } else if (parse instanceof JSONArray) {
                    context.object = parse;
                    return;
                }
            }
            throw new JSONException("TODO");
        }
    }

    public JSONPath(String str) {
        this(str, SerializeConfig.getGlobalInstance(), ParserConfig.getGlobalInstance(), true);
    }

    public static int compare(Object obj, Object obj2) {
        Object d;
        Object f;
        if (obj.getClass() == obj2.getClass()) {
            return ((Comparable) obj).compareTo(obj2);
        }
        Class<?> cls = obj.getClass();
        Class<?> cls2 = obj2.getClass();
        Class<BigDecimal> cls3 = BigDecimal.class;
        Class<Double> cls4 = Double.class;
        Class<Float> cls5 = Float.class;
        Class<Long> cls6 = Long.class;
        Class<Integer> cls7 = Integer.class;
        if (cls != cls3) {
            if (cls == cls6) {
                if (cls2 == cls7) {
                    f = new Long((long) ((Integer) obj2).intValue());
                } else if (cls2 == cls3) {
                    d = new BigDecimal(((Long) obj).longValue());
                } else if (cls2 == cls5) {
                    d = new Float((float) ((Long) obj).longValue());
                } else {
                    if (cls2 == cls4) {
                        d = new Double((double) ((Long) obj).longValue());
                    }
                    return ((Comparable) obj).compareTo(obj2);
                }
            } else if (cls == cls7) {
                if (cls2 == cls6) {
                    d = new Long((long) ((Integer) obj).intValue());
                } else if (cls2 == cls3) {
                    d = new BigDecimal(((Integer) obj).intValue());
                } else if (cls2 == cls5) {
                    d = new Float((float) ((Integer) obj).intValue());
                } else {
                    if (cls2 == cls4) {
                        d = new Double((double) ((Integer) obj).intValue());
                    }
                    return ((Comparable) obj).compareTo(obj2);
                }
            } else if (cls != cls4) {
                if (cls == cls5) {
                    if (cls2 == cls7) {
                        f = new Float((float) ((Integer) obj2).intValue());
                    } else if (cls2 == cls6) {
                        f = new Float((float) ((Long) obj2).longValue());
                    } else if (cls2 == cls4) {
                        d = new Double((double) ((Float) obj).floatValue());
                    }
                }
                return ((Comparable) obj).compareTo(obj2);
            } else if (cls2 == cls7) {
                f = new Double((double) ((Integer) obj2).intValue());
            } else if (cls2 == cls6) {
                f = new Double((double) ((Long) obj2).longValue());
            } else {
                if (cls2 == cls5) {
                    f = new Double((double) ((Float) obj2).floatValue());
                }
                return ((Comparable) obj).compareTo(obj2);
            }
            obj = d;
            return ((Comparable) obj).compareTo(obj2);
        } else if (cls2 == cls7) {
            f = new BigDecimal(((Integer) obj2).intValue());
        } else if (cls2 == cls6) {
            f = new BigDecimal(((Long) obj2).longValue());
        } else if (cls2 == cls5) {
            f = new BigDecimal((double) ((Float) obj2).floatValue());
        } else {
            if (cls2 == cls4) {
                f = new BigDecimal(((Double) obj2).doubleValue());
            }
            return ((Comparable) obj).compareTo(obj2);
        }
        obj2 = f;
        return ((Comparable) obj).compareTo(obj2);
    }

    public static JSONPath compile(String str) {
        if (str != null) {
            JSONPath jSONPath = pathCache.get(str);
            if (jSONPath != null) {
                return jSONPath;
            }
            JSONPath jSONPath2 = new JSONPath(str);
            if (pathCache.size() >= 1024) {
                return jSONPath2;
            }
            pathCache.putIfAbsent(str, jSONPath2);
            return pathCache.get(str);
        }
        throw new JSONPathException("jsonpath can not be null");
    }

    public static boolean eq(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        if (obj.getClass() == obj2.getClass()) {
            return obj.equals(obj2);
        }
        if (!(obj instanceof Number)) {
            return obj.equals(obj2);
        }
        if (obj2 instanceof Number) {
            return eqNotNull((Number) obj, (Number) obj2);
        }
        return false;
    }

    public static boolean eqNotNull(Number number, Number number2) {
        Class<?> cls = number.getClass();
        boolean isInt = isInt(cls);
        Class<?> cls2 = number2.getClass();
        boolean isInt2 = isInt(cls2);
        if (number instanceof BigDecimal) {
            BigDecimal bigDecimal = (BigDecimal) number;
            if (isInt2) {
                return bigDecimal.equals(BigDecimal.valueOf(TypeUtils.longExtractValue(number2)));
            }
        }
        if (isInt) {
            if (isInt2) {
                if (number.longValue() == number2.longValue()) {
                    return true;
                }
                return false;
            } else if (number2 instanceof BigInteger) {
                return BigInteger.valueOf(number.longValue()).equals((BigInteger) number);
            }
        }
        if (isInt2 && (number instanceof BigInteger)) {
            return ((BigInteger) number).equals(BigInteger.valueOf(TypeUtils.longExtractValue(number2)));
        }
        boolean isDouble = isDouble(cls);
        boolean isDouble2 = isDouble(cls2);
        if (((!isDouble || !isDouble2) && ((!isDouble || !isInt2) && (!isDouble2 || !isInt))) || number.doubleValue() != number2.doubleValue()) {
            return false;
        }
        return true;
    }

    public static boolean isDouble(Class<?> cls) {
        if (cls == Float.class || cls == Double.class) {
            return true;
        }
        return false;
    }

    public static boolean isInt(Class<?> cls) {
        if (cls == Byte.class || cls == Short.class || cls == Integer.class || cls == Long.class) {
            return true;
        }
        return false;
    }

    public static Map<String, Object> paths(Object obj) {
        return paths(obj, SerializeConfig.globalInstance);
    }

    public static Object read(String str, String str2) {
        return compile(str2).eval(JSON.parse(str));
    }

    public static Object reserveToArray(Object obj, String... strArr) {
        JSONArray jSONArray = new JSONArray();
        if (!(strArr == null || strArr.length == 0)) {
            for (String compile : strArr) {
                JSONPath compile2 = compile(compile);
                compile2.init();
                jSONArray.add(compile2.eval(obj));
            }
        }
        return jSONArray;
    }

    public static Object reserveToObject(Object obj, String... strArr) {
        Object eval;
        if (strArr == null || strArr.length == 0) {
            return obj;
        }
        JSONObject jSONObject = new JSONObject(true);
        for (String compile : strArr) {
            JSONPath compile2 = compile(compile);
            compile2.init();
            Segment[] segmentArr = compile2.segments;
            if ((segmentArr[segmentArr.length - 1] instanceof PropertySegment) && (eval = compile2.eval(obj)) != null) {
                compile2.set(jSONObject, eval);
            }
        }
        return jSONObject;
    }

    public void arrayAdd(Object obj, Object... objArr) {
        if (objArr != null && objArr.length != 0 && obj != null) {
            init();
            int i = 0;
            Object obj2 = null;
            Object obj3 = obj;
            int i2 = 0;
            while (true) {
                Segment[] segmentArr = this.segments;
                if (i2 >= segmentArr.length) {
                    break;
                }
                if (i2 == segmentArr.length - 1) {
                    obj2 = obj3;
                }
                obj3 = segmentArr[i2].eval(this, obj, obj3);
                i2++;
            }
            if (obj3 == null) {
                throw new JSONPathException("value not found in path " + this.path);
            } else if (obj3 instanceof Collection) {
                Collection collection = (Collection) obj3;
                int length = objArr.length;
                while (i < length) {
                    collection.add(objArr[i]);
                    i++;
                }
            } else {
                Class<?> cls = obj3.getClass();
                if (cls.isArray()) {
                    int length2 = Array.getLength(obj3);
                    Object newInstance = Array.newInstance(cls.getComponentType(), objArr.length + length2);
                    System.arraycopy(obj3, 0, newInstance, 0, length2);
                    while (i < objArr.length) {
                        Array.set(newInstance, length2 + i, objArr[i]);
                        i++;
                    }
                    Segment[] segmentArr2 = this.segments;
                    Segment segment = segmentArr2[segmentArr2.length - 1];
                    if (segment instanceof PropertySegment) {
                        ((PropertySegment) segment).setValue(this, obj2, newInstance);
                    } else if (segment instanceof ArrayAccessSegment) {
                        ((ArrayAccessSegment) segment).setValue(this, obj2, newInstance);
                    } else {
                        throw new UnsupportedOperationException();
                    }
                } else {
                    throw new JSONException("unsupported array put operation. " + cls);
                }
            }
        }
    }

    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        init();
        Object obj2 = obj;
        int i = 0;
        while (true) {
            Segment[] segmentArr = this.segments;
            if (i >= segmentArr.length) {
                return true;
            }
            Object eval = segmentArr[i].eval(this, obj, obj2);
            if (eval == null) {
                return false;
            }
            if (eval == Collections.EMPTY_LIST && (obj2 instanceof List)) {
                return ((List) obj2).contains(eval);
            }
            i++;
            obj2 = eval;
        }
    }

    public boolean containsValue(Object obj, Object obj2) {
        Object eval = eval(obj);
        if (eval == obj2) {
            return true;
        }
        if (eval == null) {
            return false;
        }
        if (!(eval instanceof Iterable)) {
            return eq(eval, obj2);
        }
        for (Object eq : (Iterable) eval) {
            if (eq(eq, obj2)) {
                return true;
            }
        }
        return false;
    }

    public void deepGetObjects(Object obj, List<Object> list) {
        Collection collection;
        Class<?> cls = obj.getClass();
        JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(cls);
        if (javaBeanSerializer != null) {
            try {
                collection = javaBeanSerializer.getFieldValues(obj);
                list.add(obj);
            } catch (Exception e) {
                throw new JSONPathException("jsonpath error, path " + this.path, e);
            }
        } else if (obj instanceof Map) {
            list.add(obj);
            collection = ((Map) obj).values();
        } else if (obj instanceof Collection) {
            collection = (Collection) obj;
        } else {
            collection = null;
        }
        if (collection != null) {
            for (Object next : collection) {
                if (next != null && !ParserConfig.isPrimitive2(next.getClass())) {
                    deepGetObjects(next, list);
                }
            }
            return;
        }
        throw new UnsupportedOperationException(cls.getName());
    }

    public void deepGetPropertyValues(Object obj, List<Object> list) {
        Collection collection;
        Class<?> cls = obj.getClass();
        JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(cls);
        if (javaBeanSerializer != null) {
            try {
                collection = javaBeanSerializer.getFieldValues(obj);
            } catch (Exception e) {
                throw new JSONPathException("jsonpath error, path " + this.path, e);
            }
        } else if (obj instanceof Map) {
            collection = ((Map) obj).values();
        } else if (obj instanceof Collection) {
            collection = (Collection) obj;
        } else {
            collection = null;
        }
        if (collection != null) {
            for (Object next : collection) {
                if (next == null || ParserConfig.isPrimitive2(next.getClass())) {
                    list.add(next);
                } else {
                    deepGetPropertyValues(next, list);
                }
            }
            return;
        }
        throw new UnsupportedOperationException(cls.getName());
    }

    public void deepScan(Object obj, String str, List<Object> list) {
        if (obj != null) {
            if (obj instanceof Map) {
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    Object value = entry.getValue();
                    if (str.equals(entry.getKey())) {
                        if (value instanceof Collection) {
                            list.addAll((Collection) value);
                        } else {
                            list.add(value);
                        }
                    } else if (value != null && !ParserConfig.isPrimitive2(value.getClass())) {
                        deepScan(value, str, list);
                    }
                }
            } else if (obj instanceof Collection) {
                for (Object next : (Collection) obj) {
                    if (!ParserConfig.isPrimitive2(next.getClass())) {
                        deepScan(next, str, list);
                    }
                }
            } else {
                JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(obj.getClass());
                if (javaBeanSerializer != null) {
                    try {
                        FieldSerializer fieldSerializer = javaBeanSerializer.getFieldSerializer(str);
                        if (fieldSerializer != null) {
                            list.add(fieldSerializer.getPropertyValueDirect(obj));
                            return;
                        }
                        for (Object deepScan : javaBeanSerializer.getFieldValues(obj)) {
                            deepScan(deepScan, str, list);
                        }
                    } catch (InvocationTargetException e) {
                        throw new JSONException("getFieldValue error." + str, e);
                    } catch (IllegalAccessException e2) {
                        throw new JSONException("getFieldValue error." + str, e2);
                    } catch (Exception e3) {
                        throw new JSONPathException("jsonpath error, path " + this.path + ", segement " + str, e3);
                    }
                } else if (obj instanceof List) {
                    List list2 = (List) obj;
                    for (int i = 0; i < list2.size(); i++) {
                        deepScan(list2.get(i), str, list);
                    }
                }
            }
        }
    }

    public void deepSet(Object obj, String str, long j, Object obj2) {
        if (obj != null) {
            if (obj instanceof Map) {
                Map map = (Map) obj;
                if (map.containsKey(str)) {
                    map.get(str);
                    map.put(str, obj2);
                    return;
                }
                for (Object deepSet : map.values()) {
                    deepSet(deepSet, str, j, obj2);
                }
                return;
            }
            Class<?> cls = obj.getClass();
            JavaBeanDeserializer javaBeanDeserializer = getJavaBeanDeserializer(cls);
            if (javaBeanDeserializer != null) {
                try {
                    FieldDeserializer fieldDeserializer = javaBeanDeserializer.getFieldDeserializer(str);
                    if (fieldDeserializer != null) {
                        fieldDeserializer.setValue(obj, obj2);
                        return;
                    }
                    for (Object deepSet2 : getJavaBeanSerializer(cls).getObjectFieldValues(obj)) {
                        deepSet(deepSet2, str, j, obj2);
                    }
                } catch (Exception e) {
                    throw new JSONPathException("jsonpath error, path " + this.path + ", segement " + str, e);
                }
            } else if (obj instanceof List) {
                List list = (List) obj;
                for (int i = 0; i < list.size(); i++) {
                    deepSet(list.get(i), str, j, obj2);
                }
            }
        }
    }

    public Object eval(Object obj) {
        if (obj == null) {
            return null;
        }
        init();
        int i = 0;
        Object obj2 = obj;
        while (true) {
            Segment[] segmentArr = this.segments;
            if (i >= segmentArr.length) {
                return obj2;
            }
            obj2 = segmentArr[i].eval(this, obj, obj2);
            i++;
        }
    }

    public Set<?> evalKeySet(Object obj) {
        JavaBeanSerializer javaBeanSerializer;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Map) {
            return ((Map) obj).keySet();
        }
        if ((obj instanceof Collection) || (obj instanceof Object[]) || obj.getClass().isArray() || (javaBeanSerializer = getJavaBeanSerializer(obj.getClass())) == null) {
            return null;
        }
        try {
            return javaBeanSerializer.getFieldNames(obj);
        } catch (Exception e) {
            throw new JSONPathException("evalKeySet error : " + this.path, e);
        }
    }

    public int evalSize(Object obj) {
        if (obj == null) {
            return -1;
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).size();
        }
        if (obj instanceof Object[]) {
            return ((Object[]) obj).length;
        }
        if (obj.getClass().isArray()) {
            return Array.getLength(obj);
        }
        if (obj instanceof Map) {
            int i = 0;
            for (Object obj2 : ((Map) obj).values()) {
                if (obj2 != null) {
                    i++;
                }
            }
            return i;
        }
        JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(obj.getClass());
        if (javaBeanSerializer == null) {
            return -1;
        }
        try {
            return javaBeanSerializer.getSize(obj);
        } catch (Exception e) {
            throw new JSONPathException("evalSize error : " + this.path, e);
        }
    }

    public Object extract(DefaultJSONParser defaultJSONParser) {
        boolean z;
        Object obj;
        if (defaultJSONParser == null) {
            return null;
        }
        init();
        if (this.hasRefSegment) {
            return eval(defaultJSONParser.parse());
        }
        Segment[] segmentArr = this.segments;
        if (segmentArr.length == 0) {
            return defaultJSONParser.parse();
        }
        Segment segment = segmentArr[segmentArr.length - 1];
        if ((segment instanceof TypeSegment) || (segment instanceof FloorSegment) || (segment instanceof MultiIndexSegment)) {
            return eval(defaultJSONParser.parse());
        }
        Context context = null;
        int i = 0;
        while (true) {
            Segment[] segmentArr2 = this.segments;
            if (i >= segmentArr2.length) {
                return context.object;
            }
            Segment segment2 = segmentArr2[i];
            boolean z2 = i == segmentArr2.length - 1;
            if (context == null || (obj = context.object) == null) {
                if (!z2) {
                    Segment segment3 = segmentArr2[i + 1];
                    if ((!(segment2 instanceof PropertySegment) || !((PropertySegment) segment2).deep || (!(segment3 instanceof ArrayAccessSegment) && !(segment3 instanceof MultiIndexSegment) && !(segment3 instanceof MultiPropertySegment) && !(segment3 instanceof SizeSegment) && !(segment3 instanceof PropertySegment) && !(segment3 instanceof FilterSegment))) && ((!(segment3 instanceof ArrayAccessSegment) || ((ArrayAccessSegment) segment3).index >= 0) && !(segment3 instanceof FilterSegment) && !(segment2 instanceof WildCardSegment) && !(segment2 instanceof MultiIndexSegment))) {
                        z = false;
                        Context context2 = new Context(context, z);
                        segment2.extract(this, defaultJSONParser, context2);
                        context = context2;
                    }
                }
                z = true;
                Context context22 = new Context(context, z);
                segment2.extract(this, defaultJSONParser, context22);
                context = context22;
            } else {
                context.object = segment2.eval(this, (Object) null, obj);
            }
            i++;
        }
    }

    public Object getArrayItem(Object obj, int i) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            if (i >= 0) {
                if (i < list.size()) {
                    return list.get(i);
                }
                return null;
            } else if (Math.abs(i) <= list.size()) {
                return list.get(list.size() + i);
            } else {
                return null;
            }
        } else if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            if (i >= 0) {
                if (i < length) {
                    return Array.get(obj, i);
                }
                return null;
            } else if (Math.abs(i) <= length) {
                return Array.get(obj, length + i);
            } else {
                return null;
            }
        } else if (obj instanceof Map) {
            Map map = (Map) obj;
            Object obj2 = map.get(Integer.valueOf(i));
            if (obj2 == null) {
                return map.get(Integer.toString(i));
            }
            return obj2;
        } else if (obj instanceof Collection) {
            int i2 = 0;
            for (Object next : (Collection) obj) {
                if (i2 == i) {
                    return next;
                }
                i2++;
            }
            return null;
        } else if (i == 0) {
            return obj;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public JavaBeanDeserializer getJavaBeanDeserializer(Class<?> cls) {
        ObjectDeserializer deserializer = this.parserConfig.getDeserializer((Type) cls);
        if (deserializer instanceof JavaBeanDeserializer) {
            return (JavaBeanDeserializer) deserializer;
        }
        return null;
    }

    public JavaBeanSerializer getJavaBeanSerializer(Class<?> cls) {
        ObjectSerializer objectWriter = this.serializeConfig.getObjectWriter(cls);
        if (objectWriter instanceof JavaBeanSerializer) {
            return (JavaBeanSerializer) objectWriter;
        }
        return null;
    }

    public String getPath() {
        return this.path;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getPropertyValue(java.lang.Object r9, java.lang.String r10, long r11) {
        /*
            r8 = this;
            r0 = 0
            if (r9 != 0) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r9 instanceof java.lang.String
            if (r1 == 0) goto L_0x0016
            r1 = r9
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0015 }
            com.alibaba.fastjson.parser.ParserConfig r2 = r8.parserConfig     // Catch:{ Exception -> 0x0015 }
            java.lang.Object r1 = com.alibaba.fastjson.JSON.parse((java.lang.String) r1, (com.alibaba.fastjson.parser.ParserConfig) r2)     // Catch:{ Exception -> 0x0015 }
            com.alibaba.fastjson.JSONObject r1 = (com.alibaba.fastjson.JSONObject) r1     // Catch:{ Exception -> 0x0015 }
            r3 = r1
            goto L_0x0017
        L_0x0015:
        L_0x0016:
            r3 = r9
        L_0x0017:
            boolean r9 = r3 instanceof java.util.Map
            r1 = -1580386065683472715(0xea11573f1af59eb5, double:-8.49505883430448E202)
            r4 = 5614464919154503228(0x4dea9618e618ae3c, double:2.239892812106928E67)
            if (r9 == 0) goto L_0x003f
            java.util.Map r3 = (java.util.Map) r3
            java.lang.Object r9 = r3.get(r10)
            if (r9 != 0) goto L_0x003e
            int r10 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r10 == 0) goto L_0x0036
            int r10 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r10 != 0) goto L_0x003e
        L_0x0036:
            int r9 = r3.size()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
        L_0x003e:
            return r9
        L_0x003f:
            java.lang.Class r9 = r3.getClass()
            com.alibaba.fastjson.serializer.JavaBeanSerializer r9 = r8.getJavaBeanSerializer(r9)
            if (r9 == 0) goto L_0x0074
            r7 = 0
            r2 = r9
            r4 = r10
            r5 = r11
            java.lang.Object r9 = r2.getFieldValue(r3, r4, r5, r7)     // Catch:{ Exception -> 0x0052 }
            return r9
        L_0x0052:
            r9 = move-exception
            com.alibaba.fastjson.JSONPathException r11 = new com.alibaba.fastjson.JSONPathException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r0 = "jsonpath error, path "
            r12.append(r0)
            java.lang.String r0 = r8.path
            r12.append(r0)
            java.lang.String r0 = ", segement "
            r12.append(r0)
            r12.append(r10)
            java.lang.String r10 = r12.toString()
            r11.<init>(r10, r9)
            throw r11
        L_0x0074:
            boolean r9 = r3 instanceof java.util.List
            r6 = 0
            if (r9 == 0) goto L_0x00df
            java.util.List r3 = (java.util.List) r3
            int r9 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r9 == 0) goto L_0x00d6
            int r9 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r9 != 0) goto L_0x0084
            goto L_0x00d6
        L_0x0084:
            int r9 = r3.size()
            if (r6 >= r9) goto L_0x00cf
            java.lang.Object r9 = r3.get(r6)
            if (r9 != r3) goto L_0x009f
            if (r0 != 0) goto L_0x009b
            com.alibaba.fastjson.JSONArray r0 = new com.alibaba.fastjson.JSONArray
            int r1 = r3.size()
            r0.<init>((int) r1)
        L_0x009b:
            r0.add(r9)
            goto L_0x00cc
        L_0x009f:
            java.lang.Object r9 = r8.getPropertyValue(r9, r10, r11)
            boolean r1 = r9 instanceof java.util.Collection
            if (r1 == 0) goto L_0x00b8
            java.util.Collection r9 = (java.util.Collection) r9
            if (r0 != 0) goto L_0x00b4
            com.alibaba.fastjson.JSONArray r0 = new com.alibaba.fastjson.JSONArray
            int r1 = r3.size()
            r0.<init>((int) r1)
        L_0x00b4:
            r0.addAll(r9)
            goto L_0x00cc
        L_0x00b8:
            if (r9 != 0) goto L_0x00be
            boolean r1 = r8.ignoreNullValue
            if (r1 != 0) goto L_0x00cc
        L_0x00be:
            if (r0 != 0) goto L_0x00c9
            com.alibaba.fastjson.JSONArray r0 = new com.alibaba.fastjson.JSONArray
            int r1 = r3.size()
            r0.<init>((int) r1)
        L_0x00c9:
            r0.add(r9)
        L_0x00cc:
            int r6 = r6 + 1
            goto L_0x0084
        L_0x00cf:
            if (r0 != 0) goto L_0x00d5
            java.util.List r0 = java.util.Collections.emptyList()
        L_0x00d5:
            return r0
        L_0x00d6:
            int r9 = r3.size()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            return r9
        L_0x00df:
            boolean r9 = r3 instanceof java.lang.Object[]
            if (r9 == 0) goto L_0x0120
            java.lang.Object[] r3 = (java.lang.Object[]) r3
            int r9 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r9 == 0) goto L_0x011a
            int r9 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r9 != 0) goto L_0x00ee
            goto L_0x011a
        L_0x00ee:
            com.alibaba.fastjson.JSONArray r9 = new com.alibaba.fastjson.JSONArray
            int r0 = r3.length
            r9.<init>((int) r0)
        L_0x00f4:
            int r0 = r3.length
            if (r6 >= r0) goto L_0x0119
            r0 = r3[r6]
            if (r0 != r3) goto L_0x00ff
            r9.add(r0)
            goto L_0x0116
        L_0x00ff:
            java.lang.Object r0 = r8.getPropertyValue(r0, r10, r11)
            boolean r1 = r0 instanceof java.util.Collection
            if (r1 == 0) goto L_0x010d
            java.util.Collection r0 = (java.util.Collection) r0
            r9.addAll(r0)
            goto L_0x0116
        L_0x010d:
            if (r0 != 0) goto L_0x0113
            boolean r1 = r8.ignoreNullValue
            if (r1 != 0) goto L_0x0116
        L_0x0113:
            r9.add(r0)
        L_0x0116:
            int r6 = r6 + 1
            goto L_0x00f4
        L_0x0119:
            return r9
        L_0x011a:
            int r9 = r3.length
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            return r9
        L_0x0120:
            boolean r9 = r3 instanceof java.lang.Enum
            if (r9 == 0) goto L_0x0147
            r9 = r3
            java.lang.Enum r9 = (java.lang.Enum) r9
            r1 = -4270347329889690746(0xc4bcadba8e631b86, double:-1.3543099103600943E23)
            int r10 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r10 != 0) goto L_0x0135
            java.lang.String r9 = r9.name()
            return r9
        L_0x0135:
            r1 = -1014497654951707614(0xf1ebc7c20322fc22, double:-5.788733405278088E240)
            int r10 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r10 != 0) goto L_0x0147
            int r9 = r9.ordinal()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            return r9
        L_0x0147:
            boolean r9 = r3 instanceof java.util.Calendar
            if (r9 == 0) goto L_0x01c2
            java.util.Calendar r3 = (java.util.Calendar) r3
            r9 = 8963398325558730460(0x7c64634977425edc, double:1.5894872030233988E291)
            int r1 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r1 != 0) goto L_0x0160
            r9 = 1
            int r9 = r3.get(r9)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            return r9
        L_0x0160:
            r9 = -811277319855450459(0xf4bdc3936faf56a5, double:-2.1821630275621928E254)
            int r1 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r1 != 0) goto L_0x0173
            r9 = 2
            int r9 = r3.get(r9)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            return r9
        L_0x0173:
            r9 = -3851359326990528739(0xca8d3918f4578f1d, double:-1.3667045267075351E51)
            int r1 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r1 != 0) goto L_0x0186
            r9 = 5
            int r9 = r3.get(r9)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            return r9
        L_0x0186:
            r9 = 4647432019745535567(0x407efecc7eb5764f, double:495.924925526463)
            int r1 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r1 != 0) goto L_0x019a
            r9 = 11
            int r9 = r3.get(r9)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            return r9
        L_0x019a:
            r9 = 6607618197526598121(0x5bb2f9bdf2fad1e9, double:5.387565597711505E133)
            int r1 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r1 != 0) goto L_0x01ae
            r9 = 12
            int r9 = r3.get(r9)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            return r9
        L_0x01ae:
            r9 = -6586085717218287427(0xa49985ef4cee20bd, double:-2.2473812103034466E-132)
            int r1 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r1 != 0) goto L_0x01c2
            r9 = 13
            int r9 = r3.get(r9)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            return r9
        L_0x01c2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.JSONPath.getPropertyValue(java.lang.Object, java.lang.String, long):java.lang.Object");
    }

    public Collection<Object> getPropertyValues(Object obj) {
        if (obj == null) {
            return null;
        }
        JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(obj.getClass());
        if (javaBeanSerializer != null) {
            try {
                return javaBeanSerializer.getFieldValues(obj);
            } catch (Exception e) {
                throw new JSONPathException("jsonpath error, path " + this.path, e);
            }
        } else if (obj instanceof Map) {
            return ((Map) obj).values();
        } else {
            if (obj instanceof Collection) {
                return (Collection) obj;
            }
            throw new UnsupportedOperationException();
        }
    }

    public void init() {
        if (this.segments == null) {
            if ("*".equals(this.path)) {
                this.segments = new Segment[]{WildCardSegment.instance};
                return;
            }
            JSONPathParser jSONPathParser = new JSONPathParser(this.path);
            this.segments = jSONPathParser.explain();
            this.hasRefSegment = jSONPathParser.hasRefSegment;
        }
    }

    public boolean isRef() {
        try {
            init();
            int i = 0;
            while (true) {
                Segment[] segmentArr = this.segments;
                if (i >= segmentArr.length) {
                    return true;
                }
                Class<?> cls = segmentArr[i].getClass();
                if (cls != ArrayAccessSegment.class && cls != PropertySegment.class) {
                    return false;
                }
                i++;
            }
        } catch (JSONPathException unused) {
            return false;
        }
    }

    public Set<?> keySet(Object obj) {
        if (obj == null) {
            return null;
        }
        init();
        int i = 0;
        Object obj2 = obj;
        while (true) {
            Segment[] segmentArr = this.segments;
            if (i >= segmentArr.length) {
                return evalKeySet(obj2);
            }
            obj2 = segmentArr[i].eval(this, obj, obj2);
            i++;
        }
    }

    public void patchAdd(Object obj, Object obj2, boolean z) {
        if (obj != null) {
            init();
            Object obj3 = null;
            int i = 0;
            Object obj4 = obj;
            while (true) {
                Segment[] segmentArr = this.segments;
                if (i >= segmentArr.length) {
                    break;
                }
                Segment segment = segmentArr[i];
                Object eval = segment.eval(this, obj, obj4);
                if (eval == null && i != this.segments.length - 1 && (segment instanceof PropertySegment)) {
                    eval = new JSONObject();
                    ((PropertySegment) segment).setValue(this, obj4, eval);
                }
                i++;
                obj3 = obj4;
                obj4 = eval;
            }
            if (z || !(obj4 instanceof Collection)) {
                if (obj4 != null && !z) {
                    Class<?> cls = obj4.getClass();
                    if (cls.isArray()) {
                        int length = Array.getLength(obj4);
                        Object newInstance = Array.newInstance(cls.getComponentType(), length + 1);
                        System.arraycopy(obj4, 0, newInstance, 0, length);
                        Array.set(newInstance, length, obj2);
                        obj2 = newInstance;
                    } else if (!Map.class.isAssignableFrom(cls)) {
                        throw new JSONException("unsupported array put operation. " + cls);
                    }
                }
                Segment[] segmentArr2 = this.segments;
                Segment segment2 = segmentArr2[segmentArr2.length - 1];
                if (segment2 instanceof PropertySegment) {
                    ((PropertySegment) segment2).setValue(this, obj3, obj2);
                } else if (segment2 instanceof ArrayAccessSegment) {
                    ((ArrayAccessSegment) segment2).setValue(this, obj3, obj2);
                } else {
                    throw new UnsupportedOperationException();
                }
            } else {
                ((Collection) obj4).add(obj2);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x008d, code lost:
        r4 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean remove(java.lang.Object r11) {
        /*
            r10 = this;
            r0 = 0
            if (r11 != 0) goto L_0x0004
            return r0
        L_0x0004:
            r10.init()
            com.alibaba.fastjson.JSONPath$Segment[] r1 = r10.segments
            int r2 = r1.length
            r3 = 1
            int r2 = r2 - r3
            r1 = r1[r2]
            r4 = r11
            r2 = 0
        L_0x0010:
            com.alibaba.fastjson.JSONPath$Segment[] r5 = r10.segments
            int r6 = r5.length
            if (r2 >= r6) goto L_0x008d
            int r6 = r5.length
            int r6 = r6 - r3
            if (r2 != r6) goto L_0x001b
            goto L_0x008e
        L_0x001b:
            r6 = r5[r2]
            int r5 = r5.length
            int r5 = r5 + -2
            if (r2 != r5) goto L_0x0083
            boolean r5 = r1 instanceof com.alibaba.fastjson.JSONPath.FilterSegment
            if (r5 == 0) goto L_0x0083
            boolean r5 = r6 instanceof com.alibaba.fastjson.JSONPath.PropertySegment
            if (r5 == 0) goto L_0x0083
            r5 = r1
            com.alibaba.fastjson.JSONPath$FilterSegment r5 = (com.alibaba.fastjson.JSONPath.FilterSegment) r5
            boolean r7 = r4 instanceof java.util.List
            if (r7 == 0) goto L_0x0063
            com.alibaba.fastjson.JSONPath$PropertySegment r6 = (com.alibaba.fastjson.JSONPath.PropertySegment) r6
            r0 = r4
            java.util.List r0 = (java.util.List) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x003a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0062
            java.lang.Object r1 = r0.next()
            java.lang.Object r1 = r6.eval(r10, r11, r1)
            boolean r2 = r1 instanceof java.lang.Iterable
            if (r2 == 0) goto L_0x0050
            r5.remove(r10, r11, r1)
            goto L_0x003a
        L_0x0050:
            boolean r2 = r1 instanceof java.util.Map
            if (r2 == 0) goto L_0x003a
            com.alibaba.fastjson.JSONPath$Filter r2 = r5.filter
            boolean r1 = r2.apply(r10, r11, r4, r1)
            if (r1 == 0) goto L_0x003a
            r0.remove()
            goto L_0x003a
        L_0x0062:
            return r3
        L_0x0063:
            boolean r7 = r4 instanceof java.util.Map
            if (r7 == 0) goto L_0x0083
            r7 = r6
            com.alibaba.fastjson.JSONPath$PropertySegment r7 = (com.alibaba.fastjson.JSONPath.PropertySegment) r7
            java.lang.Object r8 = r7.eval(r10, r11, r4)
            if (r8 != 0) goto L_0x0071
            return r0
        L_0x0071:
            boolean r9 = r8 instanceof java.util.Map
            if (r9 == 0) goto L_0x0083
            com.alibaba.fastjson.JSONPath$Filter r5 = r5.filter
            boolean r5 = r5.apply(r10, r11, r4, r8)
            if (r5 == 0) goto L_0x0083
            r7.remove(r10, r4)
            return r3
        L_0x0083:
            java.lang.Object r4 = r6.eval(r10, r11, r4)
            if (r4 != 0) goto L_0x008a
            goto L_0x008d
        L_0x008a:
            int r2 = r2 + 1
            goto L_0x0010
        L_0x008d:
            r4 = 0
        L_0x008e:
            if (r4 != 0) goto L_0x0091
            return r0
        L_0x0091:
            boolean r2 = r1 instanceof com.alibaba.fastjson.JSONPath.PropertySegment
            if (r2 == 0) goto L_0x00cb
            com.alibaba.fastjson.JSONPath$PropertySegment r1 = (com.alibaba.fastjson.JSONPath.PropertySegment) r1
            boolean r11 = r4 instanceof java.util.Collection
            if (r11 == 0) goto L_0x00c6
            com.alibaba.fastjson.JSONPath$Segment[] r11 = r10.segments
            int r2 = r11.length
            if (r2 <= r3) goto L_0x00c6
            int r2 = r11.length
            int r2 = r2 + -2
            r11 = r11[r2]
            boolean r2 = r11 instanceof com.alibaba.fastjson.JSONPath.RangeSegment
            if (r2 != 0) goto L_0x00ad
            boolean r11 = r11 instanceof com.alibaba.fastjson.JSONPath.MultiIndexSegment
            if (r11 == 0) goto L_0x00c6
        L_0x00ad:
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.Iterator r11 = r4.iterator()
        L_0x00b3:
            boolean r2 = r11.hasNext()
            if (r2 == 0) goto L_0x00c5
            java.lang.Object r2 = r11.next()
            boolean r2 = r1.remove(r10, r2)
            if (r2 == 0) goto L_0x00b3
            r0 = 1
            goto L_0x00b3
        L_0x00c5:
            return r0
        L_0x00c6:
            boolean r11 = r1.remove(r10, r4)
            return r11
        L_0x00cb:
            boolean r0 = r1 instanceof com.alibaba.fastjson.JSONPath.ArrayAccessSegment
            if (r0 == 0) goto L_0x00d6
            com.alibaba.fastjson.JSONPath$ArrayAccessSegment r1 = (com.alibaba.fastjson.JSONPath.ArrayAccessSegment) r1
            boolean r11 = r1.remove(r10, r4)
            return r11
        L_0x00d6:
            boolean r0 = r1 instanceof com.alibaba.fastjson.JSONPath.FilterSegment
            if (r0 == 0) goto L_0x00e1
            com.alibaba.fastjson.JSONPath$FilterSegment r1 = (com.alibaba.fastjson.JSONPath.FilterSegment) r1
            boolean r11 = r1.remove(r10, r11, r4)
            return r11
        L_0x00e1:
            java.lang.UnsupportedOperationException r11 = new java.lang.UnsupportedOperationException
            r11.<init>()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.JSONPath.remove(java.lang.Object):boolean");
    }

    public boolean removeArrayItem(JSONPath jSONPath, Object obj, int i) {
        if (obj instanceof List) {
            List list = (List) obj;
            if (i < 0) {
                int size = list.size() + i;
                if (size < 0) {
                    return false;
                }
                list.remove(size);
                return true;
            } else if (i >= list.size()) {
                return false;
            } else {
                list.remove(i);
                return true;
            }
        } else {
            Class<?> cls = obj.getClass();
            throw new JSONPathException("unsupported set operation." + cls);
        }
    }

    public boolean removePropertyValue(Object obj, String str, boolean z) {
        JavaBeanDeserializer javaBeanDeserializer;
        boolean z2 = true;
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (map.remove(str) == null) {
                z2 = false;
            }
            if (z) {
                for (Object removePropertyValue : map.values()) {
                    removePropertyValue(removePropertyValue, str, z);
                }
            }
            return z2;
        }
        ObjectDeserializer deserializer = this.parserConfig.getDeserializer((Type) obj.getClass());
        if (deserializer instanceof JavaBeanDeserializer) {
            javaBeanDeserializer = (JavaBeanDeserializer) deserializer;
        } else {
            javaBeanDeserializer = null;
        }
        if (javaBeanDeserializer != null) {
            FieldDeserializer fieldDeserializer = javaBeanDeserializer.getFieldDeserializer(str);
            if (fieldDeserializer != null) {
                fieldDeserializer.setValue(obj, (String) null);
            } else {
                z2 = false;
            }
            if (z) {
                for (Object next : getPropertyValues(obj)) {
                    if (next != null) {
                        removePropertyValue(next, str, z);
                    }
                }
            }
            return z2;
        } else if (z) {
            return false;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public boolean set(Object obj, Object obj2) {
        return set(obj, obj2, true);
    }

    public boolean setArrayItem(JSONPath jSONPath, Object obj, int i, Object obj2) {
        if (obj instanceof List) {
            List list = (List) obj;
            if (i >= 0) {
                list.set(i, obj2);
            } else {
                list.set(list.size() + i, obj2);
            }
            return true;
        }
        Class<?> cls = obj.getClass();
        if (cls.isArray()) {
            int length = Array.getLength(obj);
            if (i >= 0) {
                if (i < length) {
                    Array.set(obj, i, obj2);
                }
            } else if (Math.abs(i) <= length) {
                Array.set(obj, length + i, obj2);
            }
            return true;
        }
        throw new JSONPathException("unsupported set operation." + cls);
    }

    public boolean setPropertyValue(Object obj, String str, long j, Object obj2) {
        JavaBeanDeserializer javaBeanDeserializer;
        if (obj instanceof Map) {
            ((Map) obj).put(str, obj2);
            return true;
        } else if (obj instanceof List) {
            for (Object next : (List) obj) {
                if (next != null) {
                    setPropertyValue(next, str, j, obj2);
                }
            }
            return true;
        } else {
            ObjectDeserializer deserializer = this.parserConfig.getDeserializer((Type) obj.getClass());
            if (deserializer instanceof JavaBeanDeserializer) {
                javaBeanDeserializer = (JavaBeanDeserializer) deserializer;
            } else {
                javaBeanDeserializer = null;
            }
            if (javaBeanDeserializer != null) {
                FieldDeserializer fieldDeserializer = javaBeanDeserializer.getFieldDeserializer(j);
                if (fieldDeserializer == null) {
                    return false;
                }
                if (obj2 != null) {
                    Class<?> cls = obj2.getClass();
                    FieldInfo fieldInfo = fieldDeserializer.fieldInfo;
                    if (cls != fieldInfo.fieldClass) {
                        obj2 = TypeUtils.cast(obj2, fieldInfo.fieldType, this.parserConfig);
                    }
                }
                fieldDeserializer.setValue(obj, obj2);
                return true;
            }
            throw new UnsupportedOperationException();
        }
    }

    public int size(Object obj) {
        if (obj == null) {
            return -1;
        }
        init();
        int i = 0;
        Object obj2 = obj;
        while (true) {
            Segment[] segmentArr = this.segments;
            if (i >= segmentArr.length) {
                return evalSize(obj2);
            }
            obj2 = segmentArr[i].eval(this, obj, obj2);
            i++;
        }
    }

    public String toJSONString() {
        return JSON.toJSONString(this.path);
    }

    public JSONPath(String str, boolean z) {
        this(str, SerializeConfig.getGlobalInstance(), ParserConfig.getGlobalInstance(), z);
    }

    public static Map<String, Object> paths(Object obj, SerializeConfig serializeConfig2) {
        IdentityHashMap identityHashMap = new IdentityHashMap();
        HashMap hashMap = new HashMap();
        paths(identityHashMap, hashMap, "/", obj, serializeConfig2);
        return hashMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean set(java.lang.Object r9, java.lang.Object r10, boolean r11) {
        /*
            r8 = this;
            r11 = 0
            if (r9 != 0) goto L_0x0004
            return r11
        L_0x0004:
            r8.init()
            r0 = 0
            r2 = r9
            r3 = r0
            r1 = 0
        L_0x000b:
            com.alibaba.fastjson.JSONPath$Segment[] r4 = r8.segments
            int r5 = r4.length
            r6 = 1
            if (r1 >= r5) goto L_0x0086
            r3 = r4[r1]
            java.lang.Object r4 = r3.eval(r8, r9, r2)
            if (r4 != 0) goto L_0x0081
            com.alibaba.fastjson.JSONPath$Segment[] r4 = r8.segments
            int r5 = r4.length
            int r5 = r5 - r6
            if (r1 >= r5) goto L_0x0024
            int r5 = r1 + 1
            r4 = r4[r5]
            goto L_0x0025
        L_0x0024:
            r4 = r0
        L_0x0025:
            boolean r5 = r4 instanceof com.alibaba.fastjson.JSONPath.PropertySegment
            if (r5 == 0) goto L_0x0061
            boolean r4 = r3 instanceof com.alibaba.fastjson.JSONPath.PropertySegment
            if (r4 == 0) goto L_0x004b
            r4 = r3
            com.alibaba.fastjson.JSONPath$PropertySegment r4 = (com.alibaba.fastjson.JSONPath.PropertySegment) r4
            java.lang.String r4 = r4.propertyName
            java.lang.Class r5 = r2.getClass()
            com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer r5 = r8.getJavaBeanDeserializer(r5)
            if (r5 == 0) goto L_0x004b
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer r4 = r5.getFieldDeserializer((java.lang.String) r4)
            com.alibaba.fastjson.util.FieldInfo r4 = r4.fieldInfo
            java.lang.Class<?> r4 = r4.fieldClass
            com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer r5 = r8.getJavaBeanDeserializer(r4)
            goto L_0x004d
        L_0x004b:
            r4 = r0
            r5 = r4
        L_0x004d:
            if (r5 == 0) goto L_0x005b
            com.alibaba.fastjson.util.JavaBeanInfo r7 = r5.beanInfo
            java.lang.reflect.Constructor<?> r7 = r7.defaultConstructor
            if (r7 == 0) goto L_0x005a
            java.lang.Object r4 = r5.createInstance((com.alibaba.fastjson.parser.DefaultJSONParser) r0, (java.lang.reflect.Type) r4)
            goto L_0x006c
        L_0x005a:
            return r11
        L_0x005b:
            com.alibaba.fastjson.JSONObject r4 = new com.alibaba.fastjson.JSONObject
            r4.<init>()
            goto L_0x006c
        L_0x0061:
            boolean r4 = r4 instanceof com.alibaba.fastjson.JSONPath.ArrayAccessSegment
            if (r4 == 0) goto L_0x006b
            com.alibaba.fastjson.JSONArray r4 = new com.alibaba.fastjson.JSONArray
            r4.<init>()
            goto L_0x006c
        L_0x006b:
            r4 = r0
        L_0x006c:
            if (r4 == 0) goto L_0x0087
            boolean r5 = r3 instanceof com.alibaba.fastjson.JSONPath.PropertySegment
            if (r5 == 0) goto L_0x0078
            com.alibaba.fastjson.JSONPath$PropertySegment r3 = (com.alibaba.fastjson.JSONPath.PropertySegment) r3
            r3.setValue(r8, r2, r4)
            goto L_0x0081
        L_0x0078:
            boolean r5 = r3 instanceof com.alibaba.fastjson.JSONPath.ArrayAccessSegment
            if (r5 == 0) goto L_0x0087
            com.alibaba.fastjson.JSONPath$ArrayAccessSegment r3 = (com.alibaba.fastjson.JSONPath.ArrayAccessSegment) r3
            r3.setValue(r8, r2, r4)
        L_0x0081:
            int r1 = r1 + 1
            r3 = r2
            r2 = r4
            goto L_0x000b
        L_0x0086:
            r2 = r3
        L_0x0087:
            if (r2 != 0) goto L_0x008a
            return r11
        L_0x008a:
            com.alibaba.fastjson.JSONPath$Segment[] r9 = r8.segments
            int r11 = r9.length
            int r11 = r11 - r6
            r9 = r9[r11]
            boolean r11 = r9 instanceof com.alibaba.fastjson.JSONPath.PropertySegment
            if (r11 == 0) goto L_0x009a
            com.alibaba.fastjson.JSONPath$PropertySegment r9 = (com.alibaba.fastjson.JSONPath.PropertySegment) r9
            r9.setValue(r8, r2, r10)
            return r6
        L_0x009a:
            boolean r11 = r9 instanceof com.alibaba.fastjson.JSONPath.ArrayAccessSegment
            if (r11 == 0) goto L_0x00a5
            com.alibaba.fastjson.JSONPath$ArrayAccessSegment r9 = (com.alibaba.fastjson.JSONPath.ArrayAccessSegment) r9
            boolean r9 = r9.setValue(r8, r2, r10)
            return r9
        L_0x00a5:
            java.lang.UnsupportedOperationException r9 = new java.lang.UnsupportedOperationException
            r9.<init>()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.JSONPath.set(java.lang.Object, java.lang.Object, boolean):boolean");
    }

    public JSONPath(String str, SerializeConfig serializeConfig2, ParserConfig parserConfig2, boolean z) {
        if (str == null || str.length() == 0) {
            throw new JSONPathException("json-path can not be null or empty");
        }
        this.path = str;
        this.serializeConfig = serializeConfig2;
        this.parserConfig = parserConfig2;
        this.ignoreNullValue = z;
    }

    public static <T> T read(String str, String str2, Type type, ParserConfig parserConfig2) {
        return compile(str2).eval(JSON.parse(str), type, parserConfig2);
    }

    public static Set<?> keySet(Object obj, String str) {
        JSONPath compile = compile(str);
        return compile.evalKeySet(compile.eval(obj));
    }

    private static void paths(Map<Object, String> map, Map<String, Object> map2, String str, Object obj, SerializeConfig serializeConfig2) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        Class<?> cls;
        if (obj != null) {
            if (map.put(obj, str) == null || (cls = obj.getClass()) == String.class || cls == Boolean.class || cls == Character.class || cls == UUID.class || cls.isEnum() || (obj instanceof Number) || (obj instanceof Date)) {
                map2.put(str, obj);
                if (obj instanceof Map) {
                    for (Map.Entry entry : ((Map) obj).entrySet()) {
                        Object key = entry.getKey();
                        if (key instanceof String) {
                            if (str.equals("/")) {
                                sb4 = new StringBuilder();
                            } else {
                                sb4 = new StringBuilder();
                                sb4.append(str);
                            }
                            sb4.append("/");
                            sb4.append(key);
                            paths(map, map2, sb4.toString(), entry.getValue(), serializeConfig2);
                        }
                    }
                    return;
                }
                int i = 0;
                if (obj instanceof Collection) {
                    for (Object next : (Collection) obj) {
                        if (str.equals("/")) {
                            sb3 = new StringBuilder();
                        } else {
                            sb3 = new StringBuilder();
                            sb3.append(str);
                        }
                        sb3.append("/");
                        sb3.append(i);
                        paths(map, map2, sb3.toString(), next, serializeConfig2);
                        i++;
                    }
                    return;
                }
                Class<?> cls2 = obj.getClass();
                if (cls2.isArray()) {
                    int length = Array.getLength(obj);
                    while (i < length) {
                        Object obj2 = Array.get(obj, i);
                        if (str.equals("/")) {
                            sb2 = new StringBuilder();
                        } else {
                            sb2 = new StringBuilder();
                            sb2.append(str);
                        }
                        sb2.append("/");
                        sb2.append(i);
                        paths(map, map2, sb2.toString(), obj2, serializeConfig2);
                        i++;
                    }
                } else if (!ParserConfig.isPrimitive2(cls2) && !cls2.isEnum()) {
                    ObjectSerializer objectWriter = serializeConfig2.getObjectWriter(cls2);
                    if (objectWriter instanceof JavaBeanSerializer) {
                        try {
                            for (Map.Entry next2 : ((JavaBeanSerializer) objectWriter).getFieldValuesMap(obj).entrySet()) {
                                String str2 = (String) next2.getKey();
                                if (str2 instanceof String) {
                                    if (str.equals("/")) {
                                        sb = new StringBuilder();
                                        sb.append("/");
                                        sb.append(str2);
                                    } else {
                                        sb = new StringBuilder();
                                        sb.append(str);
                                        sb.append("/");
                                        sb.append(str2);
                                    }
                                    paths(map, map2, sb.toString(), next2.getValue(), serializeConfig2);
                                }
                            }
                        } catch (Exception e) {
                            throw new JSONException("toJSON error", e);
                        }
                    }
                }
            }
        }
    }

    public static <T> T read(String str, String str2, Type type) {
        return read(str, str2, type, (ParserConfig) null);
    }

    public static int size(Object obj, String str) {
        JSONPath compile = compile(str);
        return compile.evalSize(compile.eval(obj));
    }

    public <T> T eval(Object obj, Type type, ParserConfig parserConfig2) {
        return TypeUtils.cast(eval(obj), type, parserConfig2);
    }

    public static boolean contains(Object obj, String str) {
        if (obj == null) {
            return false;
        }
        return compile(str).contains(obj);
    }

    public static JSONPath compile(String str, boolean z) {
        if (str != null) {
            JSONPath jSONPath = pathCache.get(str);
            if (jSONPath != null) {
                return jSONPath;
            }
            JSONPath jSONPath2 = new JSONPath(str, z);
            if (pathCache.size() >= 1024) {
                return jSONPath2;
            }
            pathCache.putIfAbsent(str, jSONPath2);
            return pathCache.get(str);
        }
        throw new JSONPathException("jsonpath can not be null");
    }

    public <T> T eval(Object obj, Type type) {
        return eval(obj, type, ParserConfig.getGlobalInstance());
    }

    public static boolean containsValue(Object obj, String str, Object obj2) {
        return compile(str).containsValue(obj, obj2);
    }

    public static Object eval(Object obj, String str) {
        return compile(str).eval(obj);
    }

    public static Object eval(Object obj, String str, boolean z) {
        return compile(str, z).eval(obj);
    }

    public static void arrayAdd(Object obj, String str, Object... objArr) {
        compile(str).arrayAdd(obj, objArr);
    }

    public static Object extract(String str, String str2, ParserConfig parserConfig2, int i, Feature... featureArr) {
        DefaultJSONParser defaultJSONParser = new DefaultJSONParser(str, parserConfig2, i | Feature.OrderedField.mask);
        Object extract = compile(str2).extract(defaultJSONParser);
        defaultJSONParser.lexer.close();
        return extract;
    }

    public static Object extract(String str, String str2) {
        return extract(str, str2, ParserConfig.global, JSON.DEFAULT_PARSER_FEATURE, new Feature[0]);
    }

    public static boolean set(Object obj, String str, Object obj2) {
        return compile(str).set(obj, obj2);
    }

    public static boolean remove(Object obj, String str) {
        return compile(str).remove(obj);
    }
}
