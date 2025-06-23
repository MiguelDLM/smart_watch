package androidx.room.util;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.XO;
import XO0OX.x0XOIxOo;
import android.database.Cursor;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Closeable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.Xo0;
import kotlin.collections.oX;
import kotlin.io.II0xO0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.oXIO0o0XI;
import kotlin.text.OxI;
import kotlin.text.StringsKt__StringsKt;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class FtsTableInfo {
    @OOXIXo
    public static final Companion Companion = new Companion((IIXOooo) null);
    /* access modifiers changed from: private */
    @OOXIXo
    public static final String[] FTS_OPTIONS = {"tokenize=", "compress=", "content=", "languageid=", "matchinfo=", "notindexed=", "order=", "prefix=", "uncompress="};
    @XO
    @OOXIXo
    public final Set<String> columns;
    @XO
    @OOXIXo
    public final String name;
    @XO
    @OOXIXo
    public final Set<String> options;

    @XX({"SMAP\nFtsTableInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FtsTableInfo.kt\nandroidx/room/util/FtsTableInfo$Companion\n+ 2 CursorUtil.kt\nandroidx/room/util/CursorUtil\n+ 3 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 4 Strings.kt\nkotlin/text/StringsKt__StringsKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 6 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,182:1\n145#2,7:183\n145#2,7:190\n1183#3,2:197\n1185#3:222\n107#4:199\n79#4,22:200\n766#5:223\n857#5:224\n858#5:227\n12744#6,2:225\n*S KotlinDebug\n*F\n+ 1 FtsTableInfo.kt\nandroidx/room/util/FtsTableInfo$Companion\n*L\n94#1:183,7\n108#1:190,7\n148#1:197,2\n148#1:222\n163#1:199\n163#1:200,22\n173#1:223\n173#1:224\n173#1:227\n174#1:225,2\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        private final Set<String> readColumns(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
            Set oxoX2 = oX.oxoX();
            Closeable query = supportSQLiteDatabase.query("PRAGMA table_info(`" + str + "`)");
            try {
                Cursor cursor = (Cursor) query;
                if (cursor.getColumnCount() > 0) {
                    int columnIndex = cursor.getColumnIndex("name");
                    while (cursor.moveToNext()) {
                        String string = cursor.getString(columnIndex);
                        IIX0o.oO(string, "cursor.getString(nameIndex)");
                        oxoX2.add(string);
                    }
                }
                oXIO0o0XI oxio0o0xi = oXIO0o0XI.f19155oIX0oI;
                II0xO0.oIX0oI(query, (Throwable) null);
                return oX.oIX0oI(oxoX2);
            } catch (Throwable th) {
                II0xO0.oIX0oI(query, th);
                throw th;
            }
        }

        private final Set<String> readOptions(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
            String str2;
            Closeable query = supportSQLiteDatabase.query("SELECT * FROM sqlite_master WHERE `name` = '" + str + '\'');
            try {
                Cursor cursor = (Cursor) query;
                if (cursor.moveToFirst()) {
                    str2 = cursor.getString(cursor.getColumnIndexOrThrow("sql"));
                } else {
                    str2 = "";
                }
                II0xO0.oIX0oI(query, (Throwable) null);
                IIX0o.oO(str2, "sql");
                return parseOptions(str2);
            } catch (Throwable th) {
                II0xO0.oIX0oI(query, th);
                throw th;
            }
        }

        @x0XOIxOo
        @VisibleForTesting
        @OOXIXo
        public final Set<String> parseOptions(@OOXIXo String str) {
            int i;
            boolean z;
            Character ch;
            IIX0o.x0xO0oo(str, "createStatement");
            if (str.length() == 0) {
                return Xo0.OOXIXo();
            }
            String substring = str.substring(StringsKt__StringsKt.XxIIOXIXx(str, HexStringBuilder.COMMENT_BEGIN_CHAR, 0, false, 6, (Object) null) + 1, StringsKt__StringsKt.XIxO(str, HexStringBuilder.COMMENT_END_CHAR, 0, false, 6, (Object) null));
            IIX0o.oO(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            ArrayList arrayList = new ArrayList();
            ArrayDeque arrayDeque = new ArrayDeque();
            int i2 = -1;
            int i3 = 0;
            int i4 = 0;
            while (i3 < substring.length()) {
                char charAt = substring.charAt(i3);
                int i5 = i4 + 1;
                if (charAt == '\'' || charAt == '\"' || charAt == '`') {
                    if (arrayDeque.isEmpty()) {
                        arrayDeque.push(Character.valueOf(charAt));
                    } else {
                        Character ch2 = (Character) arrayDeque.peek();
                        if (ch2 != null && ch2.charValue() == charAt) {
                            arrayDeque.pop();
                        }
                    }
                } else if (charAt == '[') {
                    if (arrayDeque.isEmpty()) {
                        arrayDeque.push(Character.valueOf(charAt));
                    }
                } else if (charAt == ']') {
                    if (!arrayDeque.isEmpty() && (ch = (Character) arrayDeque.peek()) != null && ch.charValue() == '[') {
                        arrayDeque.pop();
                    }
                } else if (charAt == ',' && arrayDeque.isEmpty()) {
                    String substring2 = substring.substring(i2 + 1, i4);
                    IIX0o.oO(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                    int length = substring2.length() - 1;
                    int i6 = 0;
                    boolean z2 = false;
                    while (i6 <= length) {
                        if (!z2) {
                            i = i6;
                        } else {
                            i = length;
                        }
                        if (IIX0o.oI0IIXIo(substring2.charAt(i), 32) <= 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z2) {
                            if (!z) {
                                z2 = true;
                            } else {
                                i6++;
                            }
                        } else if (!z) {
                            break;
                        } else {
                            length--;
                        }
                    }
                    arrayList.add(substring2.subSequence(i6, length + 1).toString());
                    i2 = i4;
                }
                i3++;
                i4 = i5;
            }
            String substring3 = substring.substring(i2 + 1);
            IIX0o.oO(substring3, "this as java.lang.String).substring(startIndex)");
            arrayList.add(StringsKt__StringsKt.oIoIXxIO(substring3).toString());
            ArrayList arrayList2 = new ArrayList();
            for (Object next : arrayList) {
                String str2 = (String) next;
                String[] access$getFTS_OPTIONS$cp = FtsTableInfo.FTS_OPTIONS;
                int length2 = access$getFTS_OPTIONS$cp.length;
                int i7 = 0;
                while (true) {
                    if (i7 >= length2) {
                        break;
                    } else if (OxI.IOOoXo0Ix(str2, access$getFTS_OPTIONS$cp[i7], false, 2, (Object) null)) {
                        arrayList2.add(next);
                        break;
                    } else {
                        i7++;
                    }
                }
            }
            return CollectionsKt___CollectionsKt.XxI0(arrayList2);
        }

        @x0XOIxOo
        @OOXIXo
        public final FtsTableInfo read(@OOXIXo SupportSQLiteDatabase supportSQLiteDatabase, @OOXIXo String str) {
            IIX0o.x0xO0oo(supportSQLiteDatabase, "database");
            IIX0o.x0xO0oo(str, "tableName");
            return new FtsTableInfo(str, readColumns(supportSQLiteDatabase, str), readOptions(supportSQLiteDatabase, str));
        }

        private Companion() {
        }
    }

    public FtsTableInfo(@OOXIXo String str, @OOXIXo Set<String> set, @OOXIXo Set<String> set2) {
        IIX0o.x0xO0oo(str, "name");
        IIX0o.x0xO0oo(set, "columns");
        IIX0o.x0xO0oo(set2, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        this.name = str;
        this.columns = set;
        this.options = set2;
    }

    @x0XOIxOo
    @VisibleForTesting
    @OOXIXo
    public static final Set<String> parseOptions(@OOXIXo String str) {
        return Companion.parseOptions(str);
    }

    @x0XOIxOo
    @OOXIXo
    public static final FtsTableInfo read(@OOXIXo SupportSQLiteDatabase supportSQLiteDatabase, @OOXIXo String str) {
        return Companion.read(supportSQLiteDatabase, str);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FtsTableInfo)) {
            return false;
        }
        FtsTableInfo ftsTableInfo = (FtsTableInfo) obj;
        if (IIX0o.Oxx0IOOO(this.name, ftsTableInfo.name) && IIX0o.Oxx0IOOO(this.columns, ftsTableInfo.columns)) {
            return IIX0o.Oxx0IOOO(this.options, ftsTableInfo.options);
        }
        return false;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.columns.hashCode()) * 31) + this.options.hashCode();
    }

    @OOXIXo
    public String toString() {
        return "FtsTableInfo{name='" + this.name + "', columns=" + this.columns + ", options=" + this.options + "'}";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FtsTableInfo(@OOXIXo String str, @OOXIXo Set<String> set, @OOXIXo String str2) {
        this(str, set, Companion.parseOptions(str2));
        IIX0o.x0xO0oo(str, "name");
        IIX0o.x0xO0oo(set, "columns");
        IIX0o.x0xO0oo(str2, "createSql");
    }
}
