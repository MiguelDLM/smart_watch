package androidx.room.util;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.XO;
import XO0OX.x0XOIxOo;
import XxI.I0Io;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.room.ColumnInfo;
import androidx.room.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.Xo0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.text.OxI;
import kotlin.text.StringsKt__StringsKt;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class TableInfo {
    public static final int CREATED_FROM_DATABASE = 2;
    public static final int CREATED_FROM_ENTITY = 1;
    public static final int CREATED_FROM_UNKNOWN = 0;
    @OOXIXo
    public static final Companion Companion = new Companion((IIXOooo) null);
    @XO
    @OOXIXo
    public final Map<String, Column> columns;
    @XO
    @OOXIXo
    public final Set<ForeignKey> foreignKeys;
    @XO
    @oOoXoXO
    public final Set<Index> indices;
    @XO
    @OOXIXo
    public final String name;

    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @x0XOIxOo
        @OOXIXo
        public final TableInfo read(@OOXIXo SupportSQLiteDatabase supportSQLiteDatabase, @OOXIXo String str) {
            IIX0o.x0xO0oo(supportSQLiteDatabase, "database");
            IIX0o.x0xO0oo(str, "tableName");
            return TableInfoKt.readTableInfo(supportSQLiteDatabase, str);
        }

        private Companion() {
        }
    }

    @I0Io(AnnotationRetention.SOURCE)
    @Retention(RetentionPolicy.SOURCE)
    public @interface CreatedFrom {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final class ForeignKey {
        @XO
        @OOXIXo
        public final List<String> columnNames;
        @XO
        @OOXIXo
        public final String onDelete;
        @XO
        @OOXIXo
        public final String onUpdate;
        @XO
        @OOXIXo
        public final List<String> referenceColumnNames;
        @XO
        @OOXIXo
        public final String referenceTable;

        public ForeignKey(@OOXIXo String str, @OOXIXo String str2, @OOXIXo String str3, @OOXIXo List<String> list, @OOXIXo List<String> list2) {
            IIX0o.x0xO0oo(str, "referenceTable");
            IIX0o.x0xO0oo(str2, "onDelete");
            IIX0o.x0xO0oo(str3, "onUpdate");
            IIX0o.x0xO0oo(list, "columnNames");
            IIX0o.x0xO0oo(list2, "referenceColumnNames");
            this.referenceTable = str;
            this.onDelete = str2;
            this.onUpdate = str3;
            this.columnNames = list;
            this.referenceColumnNames = list2;
        }

        public boolean equals(@oOoXoXO Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ForeignKey)) {
                return false;
            }
            ForeignKey foreignKey = (ForeignKey) obj;
            if (IIX0o.Oxx0IOOO(this.referenceTable, foreignKey.referenceTable) && IIX0o.Oxx0IOOO(this.onDelete, foreignKey.onDelete) && IIX0o.Oxx0IOOO(this.onUpdate, foreignKey.onUpdate) && IIX0o.Oxx0IOOO(this.columnNames, foreignKey.columnNames)) {
                return IIX0o.Oxx0IOOO(this.referenceColumnNames, foreignKey.referenceColumnNames);
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.referenceTable.hashCode() * 31) + this.onDelete.hashCode()) * 31) + this.onUpdate.hashCode()) * 31) + this.columnNames.hashCode()) * 31) + this.referenceColumnNames.hashCode();
        }

        @OOXIXo
        public String toString() {
            return "ForeignKey{referenceTable='" + this.referenceTable + "', onDelete='" + this.onDelete + " +', onUpdate='" + this.onUpdate + "', columnNames=" + this.columnNames + ", referenceColumnNames=" + this.referenceColumnNames + '}';
        }
    }

    public static final class ForeignKeyWithSequence implements Comparable<ForeignKeyWithSequence> {
        @OOXIXo
        private final String from;
        private final int id;
        private final int sequence;
        @OOXIXo
        private final String to;

        public ForeignKeyWithSequence(int i, int i2, @OOXIXo String str, @OOXIXo String str2) {
            IIX0o.x0xO0oo(str, TypedValues.TransitionType.S_FROM);
            IIX0o.x0xO0oo(str2, "to");
            this.id = i;
            this.sequence = i2;
            this.from = str;
            this.to = str2;
        }

        @OOXIXo
        public final String getFrom() {
            return this.from;
        }

        public final int getId() {
            return this.id;
        }

        public final int getSequence() {
            return this.sequence;
        }

        @OOXIXo
        public final String getTo() {
            return this.to;
        }

        public int compareTo(@OOXIXo ForeignKeyWithSequence foreignKeyWithSequence) {
            IIX0o.x0xO0oo(foreignKeyWithSequence, "other");
            int i = this.id - foreignKeyWithSequence.id;
            return i == 0 ? this.sequence - foreignKeyWithSequence.sequence : i;
        }
    }

    public TableInfo(@OOXIXo String str, @OOXIXo Map<String, Column> map, @OOXIXo Set<ForeignKey> set, @oOoXoXO Set<Index> set2) {
        IIX0o.x0xO0oo(str, "name");
        IIX0o.x0xO0oo(map, "columns");
        IIX0o.x0xO0oo(set, "foreignKeys");
        this.name = str;
        this.columns = map;
        this.foreignKeys = set;
        this.indices = set2;
    }

    @x0XOIxOo
    @OOXIXo
    public static final TableInfo read(@OOXIXo SupportSQLiteDatabase supportSQLiteDatabase, @OOXIXo String str) {
        return Companion.read(supportSQLiteDatabase, str);
    }

    public boolean equals(@oOoXoXO Object obj) {
        Set<Index> set;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TableInfo)) {
            return false;
        }
        TableInfo tableInfo = (TableInfo) obj;
        if (!IIX0o.Oxx0IOOO(this.name, tableInfo.name) || !IIX0o.Oxx0IOOO(this.columns, tableInfo.columns) || !IIX0o.Oxx0IOOO(this.foreignKeys, tableInfo.foreignKeys)) {
            return false;
        }
        Set<Index> set2 = this.indices;
        if (set2 == null || (set = tableInfo.indices) == null) {
            return true;
        }
        return IIX0o.Oxx0IOOO(set2, set);
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.columns.hashCode()) * 31) + this.foreignKeys.hashCode();
    }

    @OOXIXo
    public String toString() {
        return "TableInfo{name='" + this.name + "', columns=" + this.columns + ", foreignKeys=" + this.foreignKeys + ", indices=" + this.indices + '}';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TableInfo(String str, Map map, Set set, Set set2, int i, IIXOooo iIXOooo) {
        this(str, map, set, (i & 8) != 0 ? null : set2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TableInfo(@OOXIXo String str, @OOXIXo Map<String, Column> map, @OOXIXo Set<ForeignKey> set) {
        this(str, map, set, Xo0.OOXIXo());
        IIX0o.x0xO0oo(str, "name");
        IIX0o.x0xO0oo(map, "columns");
        IIX0o.x0xO0oo(set, "foreignKeys");
    }

    public static final class Column {
        @OOXIXo
        public static final Companion Companion = new Companion((IIXOooo) null);
        @XO
        public final int affinity;
        @XO
        public final int createdFrom;
        @XO
        @oOoXoXO
        public final String defaultValue;
        @XO
        @OOXIXo
        public final String name;
        @XO
        public final boolean notNull;
        @XO
        public final int primaryKeyPosition;
        @XO
        @OOXIXo
        public final String type;

        @XX({"SMAP\nTableInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TableInfo.kt\nandroidx/room/util/TableInfo$Column$Companion\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,646:1\n1183#2,3:647\n*S KotlinDebug\n*F\n+ 1 TableInfo.kt\nandroidx/room/util/TableInfo$Column$Companion\n*L\n249#1:647,3\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(IIXOooo iIXOooo) {
                this();
            }

            private final boolean containsSurroundingParenthesis(String str) {
                if (str.length() == 0) {
                    return false;
                }
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                while (i < str.length()) {
                    char charAt = str.charAt(i);
                    int i4 = i3 + 1;
                    if (i3 == 0 && charAt != '(') {
                        return false;
                    }
                    if (charAt == '(') {
                        i2++;
                    } else if (charAt == ')' && i2 - 1 == 0 && i3 != str.length() - 1) {
                        return false;
                    }
                    i++;
                    i3 = i4;
                }
                if (i2 == 0) {
                    return true;
                }
                return false;
            }

            @VisibleForTesting
            @x0XOIxOo
            public final boolean defaultValueEquals(@OOXIXo String str, @oOoXoXO String str2) {
                IIX0o.x0xO0oo(str, "current");
                if (IIX0o.Oxx0IOOO(str, str2)) {
                    return true;
                }
                if (!containsSurroundingParenthesis(str)) {
                    return false;
                }
                String substring = str.substring(1, str.length() - 1);
                IIX0o.oO(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                return IIX0o.Oxx0IOOO(StringsKt__StringsKt.oIoIXxIO(substring).toString(), str2);
            }

            private Companion() {
            }
        }

        public Column(@OOXIXo String str, @OOXIXo String str2, boolean z, int i, @oOoXoXO String str3, int i2) {
            IIX0o.x0xO0oo(str, "name");
            IIX0o.x0xO0oo(str2, "type");
            this.name = str;
            this.type = str2;
            this.notNull = z;
            this.primaryKeyPosition = i;
            this.defaultValue = str3;
            this.createdFrom = i2;
            this.affinity = findAffinity(str2);
        }

        @VisibleForTesting
        @x0XOIxOo
        public static final boolean defaultValueEquals(@OOXIXo String str, @oOoXoXO String str2) {
            return Companion.defaultValueEquals(str, str2);
        }

        @ColumnInfo.SQLiteTypeAffinity
        private final int findAffinity(String str) {
            if (str == null) {
                return 5;
            }
            Locale locale = Locale.US;
            IIX0o.oO(locale, "US");
            String upperCase = str.toUpperCase(locale);
            IIX0o.oO(upperCase, "this as java.lang.String).toUpperCase(locale)");
            if (StringsKt__StringsKt.o00xOoIO(upperCase, "INT", false, 2, (Object) null)) {
                return 3;
            }
            if (StringsKt__StringsKt.o00xOoIO(upperCase, "CHAR", false, 2, (Object) null) || StringsKt__StringsKt.o00xOoIO(upperCase, "CLOB", false, 2, (Object) null) || StringsKt__StringsKt.o00xOoIO(upperCase, "TEXT", false, 2, (Object) null)) {
                return 2;
            }
            if (StringsKt__StringsKt.o00xOoIO(upperCase, "BLOB", false, 2, (Object) null)) {
                return 5;
            }
            if (StringsKt__StringsKt.o00xOoIO(upperCase, "REAL", false, 2, (Object) null) || StringsKt__StringsKt.o00xOoIO(upperCase, "FLOA", false, 2, (Object) null) || StringsKt__StringsKt.o00xOoIO(upperCase, "DOUB", false, 2, (Object) null)) {
                return 4;
            }
            return 1;
        }

        @ColumnInfo.SQLiteTypeAffinity
        public static /* synthetic */ void getAffinity$annotations() {
        }

        public boolean equals(@oOoXoXO Object obj) {
            String str;
            String str2;
            String str3;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Column) || this.primaryKeyPosition != ((Column) obj).primaryKeyPosition) {
                return false;
            }
            Column column = (Column) obj;
            if (!IIX0o.Oxx0IOOO(this.name, column.name) || this.notNull != column.notNull) {
                return false;
            }
            if (this.createdFrom == 1 && column.createdFrom == 2 && (str3 = this.defaultValue) != null && !Companion.defaultValueEquals(str3, column.defaultValue)) {
                return false;
            }
            if (this.createdFrom == 2 && column.createdFrom == 1 && (str2 = column.defaultValue) != null && !Companion.defaultValueEquals(str2, this.defaultValue)) {
                return false;
            }
            int i = this.createdFrom;
            if ((i == 0 || i != column.createdFrom || ((str = this.defaultValue) == null ? column.defaultValue == null : Companion.defaultValueEquals(str, column.defaultValue))) && this.affinity == column.affinity) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i;
            int hashCode = ((this.name.hashCode() * 31) + this.affinity) * 31;
            if (this.notNull) {
                i = 1231;
            } else {
                i = 1237;
            }
            return ((hashCode + i) * 31) + this.primaryKeyPosition;
        }

        public final boolean isPrimaryKey() {
            if (this.primaryKeyPosition > 0) {
                return true;
            }
            return false;
        }

        @OOXIXo
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Column{name='");
            sb.append(this.name);
            sb.append("', type='");
            sb.append(this.type);
            sb.append("', affinity='");
            sb.append(this.affinity);
            sb.append("', notNull=");
            sb.append(this.notNull);
            sb.append(", primaryKeyPosition=");
            sb.append(this.primaryKeyPosition);
            sb.append(", defaultValue='");
            String str = this.defaultValue;
            if (str == null) {
                str = "undefined";
            }
            sb.append(str);
            sb.append("'}");
            return sb.toString();
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        @kotlin.OOXIXo(message = "Use {@link Column#Column(String, String, boolean, int, String, int)} instead.")
        public Column(@OOXIXo String str, @OOXIXo String str2, boolean z, int i) {
            this(str, str2, z, i, (String) null, 0);
            IIX0o.x0xO0oo(str, "name");
            IIX0o.x0xO0oo(str2, "type");
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @XX({"SMAP\nTableInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TableInfo.kt\nandroidx/room/util/TableInfo$Index\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,646:1\n1#2:647\n*E\n"})
    public static final class Index {
        @OOXIXo
        public static final Companion Companion = new Companion((IIXOooo) null);
        @OOXIXo
        public static final String DEFAULT_PREFIX = "index_";
        @XO
        @OOXIXo
        public final List<String> columns;
        @XO
        @OOXIXo
        public final String name;
        @XO
        @OOXIXo
        public List<String> orders;
        @XO
        public final boolean unique;

        public static final class Companion {
            public /* synthetic */ Companion(IIXOooo iIXOooo) {
                this();
            }

            private Companion() {
            }
        }

        public Index(@OOXIXo String str, boolean z, @OOXIXo List<String> list, @OOXIXo List<String> list2) {
            IIX0o.x0xO0oo(str, "name");
            IIX0o.x0xO0oo(list, "columns");
            IIX0o.x0xO0oo(list2, "orders");
            this.name = str;
            this.unique = z;
            this.columns = list;
            this.orders = list2;
            Collection collection = list2;
            boolean isEmpty = collection.isEmpty();
            ArrayList arrayList = collection;
            if (isEmpty) {
                int size = list.size();
                ArrayList arrayList2 = new ArrayList(size);
                for (int i = 0; i < size; i++) {
                    arrayList2.add(Index.Order.ASC.name());
                }
                arrayList = arrayList2;
            }
            this.orders = (List) arrayList;
        }

        public boolean equals(@oOoXoXO Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Index)) {
                return false;
            }
            Index index = (Index) obj;
            if (this.unique != index.unique || !IIX0o.Oxx0IOOO(this.columns, index.columns) || !IIX0o.Oxx0IOOO(this.orders, index.orders)) {
                return false;
            }
            if (OxI.IOOoXo0Ix(this.name, DEFAULT_PREFIX, false, 2, (Object) null)) {
                return OxI.IOOoXo0Ix(index.name, DEFAULT_PREFIX, false, 2, (Object) null);
            }
            return IIX0o.Oxx0IOOO(this.name, index.name);
        }

        public int hashCode() {
            int i;
            if (OxI.IOOoXo0Ix(this.name, DEFAULT_PREFIX, false, 2, (Object) null)) {
                i = -1184239155;
            } else {
                i = this.name.hashCode();
            }
            return (((((i * 31) + (this.unique ? 1 : 0)) * 31) + this.columns.hashCode()) * 31) + this.orders.hashCode();
        }

        @OOXIXo
        public String toString() {
            return "Index{name='" + this.name + "', unique=" + this.unique + ", columns=" + this.columns + ", orders=" + this.orders + "'}";
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        @kotlin.OOXIXo(message = "Use {@link #Index(String, boolean, List, List)}")
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Index(@OXOo.OOXIXo java.lang.String r5, boolean r6, @OXOo.OOXIXo java.util.List<java.lang.String> r7) {
            /*
                r4 = this;
                java.lang.String r0 = "name"
                kotlin.jvm.internal.IIX0o.x0xO0oo(r5, r0)
                java.lang.String r0 = "columns"
                kotlin.jvm.internal.IIX0o.x0xO0oo(r7, r0)
                int r0 = r7.size()
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>(r0)
                r2 = 0
            L_0x0014:
                if (r2 >= r0) goto L_0x0022
                androidx.room.Index$Order r3 = androidx.room.Index.Order.ASC
                java.lang.String r3 = r3.name()
                r1.add(r3)
                int r2 = r2 + 1
                goto L_0x0014
            L_0x0022:
                r4.<init>(r5, r6, r7, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.util.TableInfo.Index.<init>(java.lang.String, boolean, java.util.List):void");
        }
    }
}
