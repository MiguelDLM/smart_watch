package androidx.sqlite.db;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XO0OX.x0XOIxOo;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import java.util.regex.Pattern;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

@XX({"SMAP\nSupportSQLiteQueryBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SupportSQLiteQueryBuilder.kt\nandroidx/sqlite/db/SupportSQLiteQueryBuilder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,187:1\n1#2:188\n*E\n"})
/* loaded from: classes.dex */
public final class SupportSQLiteQueryBuilder {

    @OOXIXo
    public static final Companion Companion = new Companion(null);
    private static final Pattern limitPattern = Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");

    @oOoXoXO
    private Object[] bindArgs;

    @oOoXoXO
    private String[] columns;
    private boolean distinct;

    @oOoXoXO
    private String groupBy;

    @oOoXoXO
    private String having;

    @oOoXoXO
    private String limit;

    @oOoXoXO
    private String orderBy;

    @oOoXoXO
    private String selection;

    @OOXIXo
    private final String table;

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @x0XOIxOo
        @OOXIXo
        public final SupportSQLiteQueryBuilder builder(@OOXIXo String tableName) {
            IIX0o.x0xO0oo(tableName, "tableName");
            return new SupportSQLiteQueryBuilder(tableName, null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ SupportSQLiteQueryBuilder(String str, IIXOooo iIXOooo) {
        this(str);
    }

    private final void appendClause(StringBuilder sb, String str, String str2) {
        if (str2 != null && str2.length() != 0) {
            sb.append(str);
            sb.append(str2);
        }
    }

    private final void appendColumns(StringBuilder sb, String[] strArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            String str = strArr[i];
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(str);
        }
        sb.append(TokenParser.SP);
    }

    @x0XOIxOo
    @OOXIXo
    public static final SupportSQLiteQueryBuilder builder(@OOXIXo String str) {
        return Companion.builder(str);
    }

    @OOXIXo
    public final SupportSQLiteQueryBuilder columns(@oOoXoXO String[] strArr) {
        this.columns = strArr;
        return this;
    }

    @OOXIXo
    public final SupportSQLiteQuery create() {
        String str;
        String str2 = this.groupBy;
        if ((str2 == null || str2.length() == 0) && (str = this.having) != null && str.length() != 0) {
            throw new IllegalArgumentException("HAVING clauses are only permitted when using a groupBy clause");
        }
        StringBuilder sb = new StringBuilder(120);
        sb.append("SELECT ");
        if (this.distinct) {
            sb.append("DISTINCT ");
        }
        String[] strArr = this.columns;
        if (strArr != null && strArr.length != 0) {
            IIX0o.ooOOo0oXI(strArr);
            appendColumns(sb, strArr);
        } else {
            sb.append("* ");
        }
        sb.append("FROM ");
        sb.append(this.table);
        appendClause(sb, " WHERE ", this.selection);
        appendClause(sb, " GROUP BY ", this.groupBy);
        appendClause(sb, " HAVING ", this.having);
        appendClause(sb, " ORDER BY ", this.orderBy);
        appendClause(sb, " LIMIT ", this.limit);
        String sb2 = sb.toString();
        IIX0o.oO(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return new SimpleSQLiteQuery(sb2, this.bindArgs);
    }

    @OOXIXo
    public final SupportSQLiteQueryBuilder distinct() {
        this.distinct = true;
        return this;
    }

    @OOXIXo
    public final SupportSQLiteQueryBuilder groupBy(@oOoXoXO String str) {
        this.groupBy = str;
        return this;
    }

    @OOXIXo
    public final SupportSQLiteQueryBuilder having(@oOoXoXO String str) {
        this.having = str;
        return this;
    }

    @OOXIXo
    public final SupportSQLiteQueryBuilder limit(@OOXIXo String limit) {
        IIX0o.x0xO0oo(limit, "limit");
        boolean matches = limitPattern.matcher(limit).matches();
        if (limit.length() == 0 || matches) {
            this.limit = limit;
            return this;
        }
        throw new IllegalArgumentException(("invalid LIMIT clauses:" + limit).toString());
    }

    @OOXIXo
    public final SupportSQLiteQueryBuilder orderBy(@oOoXoXO String str) {
        this.orderBy = str;
        return this;
    }

    @OOXIXo
    public final SupportSQLiteQueryBuilder selection(@oOoXoXO String str, @oOoXoXO Object[] objArr) {
        this.selection = str;
        this.bindArgs = objArr;
        return this;
    }

    private SupportSQLiteQueryBuilder(String str) {
        this.table = str;
    }
}
