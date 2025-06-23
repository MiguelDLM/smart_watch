package androidx.work.impl;

import O0IoXXOx.XO;
import OXOo.OOXIXo;
import XO0OX.x0XOIxOo;
import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.room.AutoMigration;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import androidx.work.Clock;
import androidx.work.Data;
import androidx.work.impl.model.Dependency;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.Preference;
import androidx.work.impl.model.PreferenceDao;
import androidx.work.impl.model.RawWorkInfoDao;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.WorkName;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkProgress;
import androidx.work.impl.model.WorkProgressDao;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTag;
import androidx.work.impl.model.WorkTagDao;
import androidx.work.impl.model.WorkTypeConverters;
import com.huawei.openalliance.ad.constant.bn;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@Database(autoMigrations = {@AutoMigration(from = 13, to = 14), @AutoMigration(from = 14, spec = AutoMigration_14_15.class, to = 15), @AutoMigration(from = 16, to = 17), @AutoMigration(from = 17, to = 18), @AutoMigration(from = 18, to = 19), @AutoMigration(from = 19, spec = AutoMigration_19_20.class, to = 20), @AutoMigration(from = 20, to = 21), @AutoMigration(from = 22, to = 23)}, entities = {Dependency.class, WorkSpec.class, WorkTag.class, SystemIdInfo.class, WorkName.class, WorkProgress.class, Preference.class}, version = 23)
@TypeConverters({Data.class, WorkTypeConverters.class})
public abstract class WorkDatabase extends RoomDatabase {
    @OOXIXo
    public static final Companion Companion = new Companion((IIXOooo) null);

    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        /* access modifiers changed from: private */
        public static final SupportSQLiteOpenHelper create$lambda$0(Context context, SupportSQLiteOpenHelper.Configuration configuration) {
            IIX0o.x0xO0oo(configuration, XO.f15419Oxx0IOOO);
            SupportSQLiteOpenHelper.Configuration.Builder builder = SupportSQLiteOpenHelper.Configuration.Companion.builder(context);
            builder.name(configuration.name).callback(configuration.callback).noBackupDirectory(true).allowDataLossOnRecovery(true);
            return new FrameworkSQLiteOpenHelperFactory().create(builder.build());
        }

        @x0XOIxOo
        @OOXIXo
        public final WorkDatabase create(@OOXIXo Context context, @OOXIXo Executor executor, @OOXIXo Clock clock, boolean z) {
            RoomDatabase.Builder<WorkDatabase> builder;
            IIX0o.x0xO0oo(context, bn.f.o);
            IIX0o.x0xO0oo(executor, "queryExecutor");
            IIX0o.x0xO0oo(clock, "clock");
            Class<WorkDatabase> cls = WorkDatabase.class;
            if (z) {
                builder = Room.inMemoryDatabaseBuilder(context, cls).allowMainThreadQueries();
            } else {
                builder = Room.databaseBuilder(context, cls, WorkDatabasePathHelperKt.WORK_DATABASE_NAME).openHelperFactory(new II0XooXoX(context));
            }
            return builder.setQueryExecutor(executor).addCallback(new CleanupCallback(clock)).addMigrations(Migration_1_2.INSTANCE).addMigrations(new RescheduleMigration(context, 2, 3)).addMigrations(Migration_3_4.INSTANCE).addMigrations(Migration_4_5.INSTANCE).addMigrations(new RescheduleMigration(context, 5, 6)).addMigrations(Migration_6_7.INSTANCE).addMigrations(Migration_7_8.INSTANCE).addMigrations(Migration_8_9.INSTANCE).addMigrations(new WorkMigration9To10(context)).addMigrations(new RescheduleMigration(context, 10, 11)).addMigrations(Migration_11_12.INSTANCE).addMigrations(Migration_12_13.INSTANCE).addMigrations(Migration_15_16.INSTANCE).addMigrations(Migration_16_17.INSTANCE).addMigrations(new RescheduleMigration(context, 21, 22)).fallbackToDestructiveMigration().build();
        }

        private Companion() {
        }
    }

    @x0XOIxOo
    @OOXIXo
    public static final WorkDatabase create(@OOXIXo Context context, @OOXIXo Executor executor, @OOXIXo Clock clock, boolean z) {
        return Companion.create(context, executor, clock, z);
    }

    @OOXIXo
    public abstract DependencyDao dependencyDao();

    @OOXIXo
    public abstract PreferenceDao preferenceDao();

    @OOXIXo
    public abstract RawWorkInfoDao rawWorkInfoDao();

    @OOXIXo
    public abstract SystemIdInfoDao systemIdInfoDao();

    @OOXIXo
    public abstract WorkNameDao workNameDao();

    @OOXIXo
    public abstract WorkProgressDao workProgressDao();

    @OOXIXo
    public abstract WorkSpecDao workSpecDao();

    @OOXIXo
    public abstract WorkTagDao workTagDao();
}
