package org.eclipse.paho.android.service;

import OoOoXO0.Oxx0xo;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Iterator;
import java.util.UUID;
import org.apache.commons.text.ooOOo0oXI;
import org.eclipse.paho.android.service.MessageStore;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class DatabaseMessageStore implements MessageStore {
    private static final String ARRIVED_MESSAGE_TABLE_NAME = "MqttArrivedMessageTable";
    private static final String MTIMESTAMP = "mtimestamp";
    private static final String TAG = "DatabaseMessageStore";
    private SQLiteDatabase db = null;
    private MQTTDatabaseHelper mqttDb;
    private MqttTraceHandler traceHandler;

    /* loaded from: classes6.dex */
    public class DbStoredData implements MessageStore.StoredMessage {
        private String clientHandle;
        private Oxx0xo message;
        private String messageId;
        private String topic;

        public DbStoredData(String str, String str2, String str3, Oxx0xo oxx0xo) {
            this.messageId = str;
            this.topic = str3;
            this.message = oxx0xo;
        }

        @Override // org.eclipse.paho.android.service.MessageStore.StoredMessage
        public String getClientHandle() {
            return this.clientHandle;
        }

        @Override // org.eclipse.paho.android.service.MessageStore.StoredMessage
        public Oxx0xo getMessage() {
            return this.message;
        }

        @Override // org.eclipse.paho.android.service.MessageStore.StoredMessage
        public String getMessageId() {
            return this.messageId;
        }

        @Override // org.eclipse.paho.android.service.MessageStore.StoredMessage
        public String getTopic() {
            return this.topic;
        }
    }

    /* loaded from: classes6.dex */
    public static class MQTTDatabaseHelper extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "mqttAndroidService.db";
        private static final int DATABASE_VERSION = 1;
        private static final String TAG = "MQTTDatabaseHelper";
        private MqttTraceHandler traceHandler;

        public MQTTDatabaseHelper(MqttTraceHandler mqttTraceHandler, Context context) {
            super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 1);
            this.traceHandler = mqttTraceHandler;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            this.traceHandler.traceDebug(TAG, "onCreate {CREATE TABLE MqttArrivedMessageTable(messageId TEXT PRIMARY KEY, clientHandle TEXT, destinationName TEXT, payload BLOB, qos INTEGER, retained TEXT, duplicate TEXT, mtimestamp INTEGER);" + ooOOo0oXI.f33074oOoXoXO);
            try {
                sQLiteDatabase.execSQL("CREATE TABLE MqttArrivedMessageTable(messageId TEXT PRIMARY KEY, clientHandle TEXT, destinationName TEXT, payload BLOB, qos INTEGER, retained TEXT, duplicate TEXT, mtimestamp INTEGER);");
                this.traceHandler.traceDebug(TAG, "created the table");
            } catch (SQLException e) {
                this.traceHandler.traceException(TAG, "onCreate", e);
                throw e;
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.traceHandler.traceDebug(TAG, "onUpgrade");
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS MqttArrivedMessageTable");
                onCreate(sQLiteDatabase);
                this.traceHandler.traceDebug(TAG, "onUpgrade complete");
            } catch (SQLException e) {
                this.traceHandler.traceException(TAG, "onUpgrade", e);
                throw e;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class MqttMessageHack extends Oxx0xo {
        public MqttMessageHack(byte[] bArr) {
            super(bArr);
        }

        @Override // OoOoXO0.Oxx0xo
        public void setDuplicate(boolean z) {
            super.setDuplicate(z);
        }
    }

    public DatabaseMessageStore(MqttService mqttService, Context context) {
        this.mqttDb = null;
        this.traceHandler = mqttService;
        this.mqttDb = new MQTTDatabaseHelper(this.traceHandler, context);
        this.traceHandler.traceDebug(TAG, "DatabaseMessageStore<init> complete");
    }

    private int getArrivedRowCount(String str) {
        Cursor query = this.db.query(ARRIVED_MESSAGE_TABLE_NAME, new String[]{MqttServiceConstants.MESSAGE_ID}, "clientHandle=?", new String[]{str}, null, null, null);
        int i = query.moveToFirst() ? query.getInt(0) : 0;
        query.close();
        return i;
    }

    @Override // org.eclipse.paho.android.service.MessageStore
    public void clearArrivedMessages(String str) {
        int delete;
        this.db = this.mqttDb.getWritableDatabase();
        String[] strArr = {str};
        if (str == null) {
            this.traceHandler.traceDebug(TAG, "clearArrivedMessages: clearing the table");
            delete = this.db.delete(ARRIVED_MESSAGE_TABLE_NAME, null, null);
        } else {
            this.traceHandler.traceDebug(TAG, "clearArrivedMessages: clearing the table of " + str + " messages");
            delete = this.db.delete(ARRIVED_MESSAGE_TABLE_NAME, "clientHandle=?", strArr);
        }
        this.traceHandler.traceDebug(TAG, "clearArrivedMessages: rows affected = " + delete);
    }

    @Override // org.eclipse.paho.android.service.MessageStore
    public void close() {
        SQLiteDatabase sQLiteDatabase = this.db;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.close();
        }
    }

    @Override // org.eclipse.paho.android.service.MessageStore
    public boolean discardArrived(String str, String str2) {
        this.db = this.mqttDb.getWritableDatabase();
        this.traceHandler.traceDebug(TAG, "discardArrived{" + str + "}, {" + str2 + ooOOo0oXI.f33074oOoXoXO);
        try {
            int delete = this.db.delete(ARRIVED_MESSAGE_TABLE_NAME, "messageId=? AND clientHandle=?", new String[]{str2, str});
            if (delete == 1) {
                int arrivedRowCount = getArrivedRowCount(str);
                this.traceHandler.traceDebug(TAG, "discardArrived - Message deleted successfully. - messages in db for this clientHandle " + arrivedRowCount);
                return true;
            }
            this.traceHandler.traceError(TAG, "discardArrived - Error deleting message {" + str2 + "} from database: Rows affected = " + delete);
            return false;
        } catch (SQLException e) {
            this.traceHandler.traceException(TAG, "discardArrived", e);
            throw e;
        }
    }

    @Override // org.eclipse.paho.android.service.MessageStore
    public Iterator<MessageStore.StoredMessage> getAllArrivedMessages(String str) {
        return new Iterator<MessageStore.StoredMessage>(str) { // from class: org.eclipse.paho.android.service.DatabaseMessageStore.1
            private Cursor c;
            private boolean hasNext;
            private final String[] selectionArgs;
            public final /* synthetic */ String val$clientHandle;

            {
                this.val$clientHandle = str;
                String[] strArr = {str};
                this.selectionArgs = strArr;
                DatabaseMessageStore.this.db = DatabaseMessageStore.this.mqttDb.getWritableDatabase();
                this.c = str == null ? DatabaseMessageStore.this.db.query(DatabaseMessageStore.ARRIVED_MESSAGE_TABLE_NAME, null, null, null, null, null, "mtimestamp ASC") : DatabaseMessageStore.this.db.query(DatabaseMessageStore.ARRIVED_MESSAGE_TABLE_NAME, null, "clientHandle=?", strArr, null, null, "mtimestamp ASC");
                this.hasNext = this.c.moveToFirst();
            }

            public void finalize() {
                this.c.close();
                super.finalize();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (!this.hasNext) {
                    this.c.close();
                }
                return this.hasNext;
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.Iterator
            public MessageStore.StoredMessage next() {
                Cursor cursor = this.c;
                String string = cursor.getString(cursor.getColumnIndex(MqttServiceConstants.MESSAGE_ID));
                Cursor cursor2 = this.c;
                String string2 = cursor2.getString(cursor2.getColumnIndex(MqttServiceConstants.CLIENT_HANDLE));
                Cursor cursor3 = this.c;
                String string3 = cursor3.getString(cursor3.getColumnIndex(MqttServiceConstants.DESTINATION_NAME));
                Cursor cursor4 = this.c;
                byte[] blob = cursor4.getBlob(cursor4.getColumnIndex("payload"));
                Cursor cursor5 = this.c;
                int i = cursor5.getInt(cursor5.getColumnIndex(MqttServiceConstants.QOS));
                Cursor cursor6 = this.c;
                boolean parseBoolean = Boolean.parseBoolean(cursor6.getString(cursor6.getColumnIndex(MqttServiceConstants.RETAINED)));
                Cursor cursor7 = this.c;
                boolean parseBoolean2 = Boolean.parseBoolean(cursor7.getString(cursor7.getColumnIndex(MqttServiceConstants.DUPLICATE)));
                MqttMessageHack mqttMessageHack = new MqttMessageHack(blob);
                mqttMessageHack.setQos(i);
                mqttMessageHack.setRetained(parseBoolean);
                mqttMessageHack.setDuplicate(parseBoolean2);
                this.hasNext = this.c.moveToNext();
                return new DbStoredData(string, string2, string3, mqttMessageHack);
            }
        };
    }

    @Override // org.eclipse.paho.android.service.MessageStore
    public String storeArrived(String str, String str2, Oxx0xo oxx0xo) {
        this.db = this.mqttDb.getWritableDatabase();
        this.traceHandler.traceDebug(TAG, "storeArrived{" + str + "}, {" + oxx0xo.toString() + ooOOo0oXI.f33074oOoXoXO);
        byte[] payload = oxx0xo.getPayload();
        int qos = oxx0xo.getQos();
        boolean isRetained = oxx0xo.isRetained();
        boolean isDuplicate = oxx0xo.isDuplicate();
        ContentValues contentValues = new ContentValues();
        String uuid = UUID.randomUUID().toString();
        contentValues.put(MqttServiceConstants.MESSAGE_ID, uuid);
        contentValues.put(MqttServiceConstants.CLIENT_HANDLE, str);
        contentValues.put(MqttServiceConstants.DESTINATION_NAME, str2);
        contentValues.put("payload", payload);
        contentValues.put(MqttServiceConstants.QOS, Integer.valueOf(qos));
        contentValues.put(MqttServiceConstants.RETAINED, Boolean.valueOf(isRetained));
        contentValues.put(MqttServiceConstants.DUPLICATE, Boolean.valueOf(isDuplicate));
        contentValues.put(MTIMESTAMP, Long.valueOf(System.currentTimeMillis()));
        try {
            this.db.insertOrThrow(ARRIVED_MESSAGE_TABLE_NAME, null, contentValues);
            int arrivedRowCount = getArrivedRowCount(str);
            this.traceHandler.traceDebug(TAG, "storeArrived: inserted message with id of {" + uuid + "} - Number of messages in database for this clientHandle = " + arrivedRowCount);
            return uuid;
        } catch (SQLException e) {
            this.traceHandler.traceException(TAG, "onUpgrade", e);
            throw e;
        }
    }
}
