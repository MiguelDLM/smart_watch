package com.github.doyaaaaaken.kotlincsv.client;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import Oox.x0xO0oo;
import com.github.doyaaaaaken.kotlincsv.dsl.context.CsvReaderContext;
import com.github.doyaaaaaken.kotlincsv.dsl.context.ExcessFieldsRowBehaviour;
import com.github.doyaaaaaken.kotlincsv.dsl.context.InsufficientFieldsRowBehaviour;
import com.github.doyaaaaaken.kotlincsv.util.CSVAutoRenameFailedException;
import com.github.doyaaaaaken.kotlincsv.util.CSVFieldNumDifferentException;
import com.github.doyaaaaaken.kotlincsv.util.MalformedCSVException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.OxxIIOOXO;
import kotlin.collections.o0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.sequences.ooOOo0oXI;
import kotlin.text.OxI;

/* loaded from: classes9.dex */
public final class CsvFileReader {

    /* renamed from: I0Io, reason: collision with root package name */
    @OOXIXo
    public final oIX0oI f15750I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OOXIXo
    public final xoIxX.oIX0oI f15751II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    @OOXIXo
    public final com.github.doyaaaaaken.kotlincsv.parser.oIX0oI f15752X0o0xo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public final CsvReaderContext f15753oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public long f15754oxoX;

    public CsvFileReader(@OOXIXo CsvReaderContext ctx, @OOXIXo X0o0xo reader, @OOXIXo xoIxX.oIX0oI logger) {
        IIX0o.x0xO0oo(ctx, "ctx");
        IIX0o.x0xO0oo(reader, "reader");
        IIX0o.x0xO0oo(logger, "logger");
        this.f15753oIX0oI = ctx;
        this.f15751II0xO0 = logger;
        this.f15750I0Io = new oIX0oI(reader);
        this.f15752X0o0xo = new com.github.doyaaaaaken.kotlincsv.parser.oIX0oI(ctx.xxIXOIIO(), ctx.oIX0oI(), ctx.Oxx0IOOO());
    }

    public static /* synthetic */ ooOOo0oXI II0XooXoX(CsvFileReader csvFileReader, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        return csvFileReader.Oxx0IOOO(num);
    }

    public static /* synthetic */ List oOoXoXO(CsvFileReader csvFileReader, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        return csvFileReader.OOXIXo(str);
    }

    public final List<String> OOXIXo(String str) {
        String str2;
        while (true) {
            String I0Io2 = this.f15750I0Io.I0Io();
            this.f15754oxoX++;
            if (I0Io2 == null) {
                if (str.length() <= 0) {
                    return null;
                }
                throw new MalformedCSVException('\"' + str + "\" on the tail of file is left on the way of parsing row");
            }
            if (!this.f15753oIX0oI.I0Io() || !OxI.X0O0I0(I0Io2) || !OxI.X0O0I0(str)) {
                if (str.length() == 0) {
                    str2 = I0Io2;
                } else {
                    str2 = str + I0Io2;
                }
                List<String> oIX0oI2 = this.f15752X0o0xo.oIX0oI(str2, this.f15754oxoX);
                if (oIX0oI2 == null) {
                    str = str + I0Io2;
                } else {
                    return oIX0oI2;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OOXIXo
    public final ooOOo0oXI<List<String>> Oxx0IOOO(@oOoXoXO Integer num) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = num;
        return SequencesKt___SequencesKt.oXxOI0oIx(SequencesKt__SequencesKt.oOoXoXO(new Oox.oIX0oI<List<? extends String>>() { // from class: com.github.doyaaaaaken.kotlincsv.client.CsvFileReader$readAllAsSequence$1
            {
                super(0);
            }

            @Override // Oox.oIX0oI
            @oOoXoXO
            public final List<? extends String> invoke() {
                return CsvFileReader.this.xoIox();
            }
        }), new x0xO0oo<Integer, List<? extends String>, List<? extends String>>() { // from class: com.github.doyaaaaaken.kotlincsv.client.CsvFileReader$readAllAsSequence$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // Oox.x0xO0oo
            public /* bridge */ /* synthetic */ List<? extends String> invoke(Integer num2, List<? extends String> list) {
                return invoke(num2.intValue(), (List<String>) list);
            }

            /* JADX WARN: Type inference failed for: r1v29, types: [T, java.lang.Integer] */
            @oOoXoXO
            public final List<String> invoke(int i, @OOXIXo List<String> row) {
                CsvReaderContext csvReaderContext;
                Object ooOOo0oXI2;
                CsvReaderContext csvReaderContext2;
                CsvReaderContext csvReaderContext3;
                CsvReaderContext csvReaderContext4;
                CsvReaderContext csvReaderContext5;
                Object ooOOo0oXI3;
                CsvReaderContext csvReaderContext6;
                xoIxX.oIX0oI oix0oi;
                IIX0o.x0xO0oo(row, "row");
                Ref.ObjectRef<Integer> objectRef2 = objectRef;
                if (objectRef2.element == null) {
                    objectRef2.element = Integer.valueOf(row.size());
                }
                Integer num2 = objectRef.element;
                int intValue = num2 != null ? num2.intValue() : row.size();
                if (row.size() > intValue) {
                    csvReaderContext4 = this.f15753oIX0oI;
                    if (csvReaderContext4.X0o0xo() == ExcessFieldsRowBehaviour.TRIM) {
                        oix0oi = this.f15751II0xO0;
                        oix0oi.oIX0oI("trimming excess rows. [csv row num = " + (i + 1) + ", fields num = " + row.size() + ", fields num of row = " + intValue + ']');
                        return row.subList(0, intValue);
                    }
                    csvReaderContext5 = this.f15753oIX0oI;
                    if (!csvReaderContext5.oxoX()) {
                        csvReaderContext6 = this.f15753oIX0oI;
                        if (csvReaderContext6.X0o0xo() != ExcessFieldsRowBehaviour.IGNORE) {
                            throw new CSVFieldNumDifferentException(intValue, row.size(), i + 1);
                        }
                    }
                    ooOOo0oXI3 = this.ooOOo0oXI(i, row, intValue);
                    return (List) ooOOo0oXI3;
                }
                if (intValue == row.size()) {
                    return row;
                }
                csvReaderContext = this.f15753oIX0oI;
                if (!csvReaderContext.oxoX()) {
                    csvReaderContext2 = this.f15753oIX0oI;
                    if (csvReaderContext2.II0XooXoX() != InsufficientFieldsRowBehaviour.IGNORE) {
                        csvReaderContext3 = this.f15753oIX0oI;
                        if (csvReaderContext3.II0XooXoX() == InsufficientFieldsRowBehaviour.EMPTY_STRING) {
                            int size = intValue - row.size();
                            List<String> list = row;
                            ArrayList arrayList = new ArrayList(size);
                            for (int i2 = 0; i2 < size; i2++) {
                                arrayList.add("");
                            }
                            return CollectionsKt___CollectionsKt.o0xIIX0(list, arrayList);
                        }
                        throw new CSVFieldNumDifferentException(intValue, row.size(), i + 1);
                    }
                }
                ooOOo0oXI2 = this.ooOOo0oXI(i, row, intValue);
                return (List) ooOOo0oXI2;
            }
        });
    }

    public final List<String> X0o0xo(List<String> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List<String> list2 = list;
        ArrayList arrayList = new ArrayList(OxxIIOOXO.xo0x(list2, 10));
        for (String str : list2) {
            Object obj = linkedHashMap.get(str);
            if (obj == null) {
                obj = 0;
                linkedHashMap.put(str, obj);
            }
            int intValue = ((Number) obj).intValue() + 1;
            linkedHashMap.put(str, Integer.valueOf(intValue));
            if (intValue > 1) {
                str = str + '_' + intValue;
            }
            arrayList.add(str);
        }
        if (arrayList.size() == CollectionsKt___CollectionsKt.XooIO0oo0(arrayList).size()) {
            return arrayList;
        }
        throw new CSVAutoRenameFailedException();
    }

    public final String XO(List<String> list) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String str : list) {
            if (linkedHashSet.contains(str)) {
                return str;
            }
            linkedHashSet.add(str);
        }
        return null;
    }

    public final Void ooOOo0oXI(int i, List<String> list, int i2) {
        this.f15751II0xO0.oIX0oI("skip miss matched row. [csv row num = " + (i + 1) + ", fields num = " + list.size() + ", fields num of first row = " + i2 + ']');
        return null;
    }

    public final void oxoX() {
        this.f15750I0Io.oIX0oI();
    }

    @kotlin.OOXIXo(message = "We are considering making it a private method. If you have feedback, please comment on Issue #100.")
    @oOoXoXO
    public final List<String> xoIox() {
        return OOXIXo("");
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r1v15, types: [java.util.List, T] */
    @OOXIXo
    public final ooOOo0oXI<Map<String, String>> xxIXOIIO() {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? xoIox2 = xoIox();
        if (xoIox2 == 0) {
            return SequencesKt__SequencesKt.Oxx0IOOO();
        }
        objectRef.element = xoIox2;
        if (this.f15753oIX0oI.XO()) {
            objectRef.element = X0o0xo((List) objectRef.element);
        } else {
            String XO2 = XO((List) objectRef.element);
            if (XO2 != null) {
                throw new MalformedCSVException("header '" + XO2 + "' is duplicated. please consider to use 'autoRenameDuplicateHeaders' option.");
            }
        }
        return SequencesKt___SequencesKt.X0xxXX0(Oxx0IOOO(Integer.valueOf(((List) objectRef.element).size())), new Oox.oOoXoXO<List<? extends String>, Map<String, ? extends String>>() { // from class: com.github.doyaaaaaken.kotlincsv.client.CsvFileReader$readAllWithHeaderAsSequence$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // Oox.oOoXoXO
            public /* bridge */ /* synthetic */ Map<String, ? extends String> invoke(List<? extends String> list) {
                return invoke2((List<String>) list);
            }

            @OOXIXo
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Map<String, String> invoke2(@OOXIXo List<String> fields) {
                IIX0o.x0xO0oo(fields, "fields");
                return o0.ooOx(CollectionsKt___CollectionsKt.XOx0xX(objectRef.element, fields));
            }
        });
    }
}
