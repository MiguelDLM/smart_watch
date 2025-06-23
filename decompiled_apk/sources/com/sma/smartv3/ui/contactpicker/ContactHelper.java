package com.sma.smartv3.ui.contactpicker;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.util.LongSparseArray;
import androidx.annotation.NonNull;
import com.blankj.utilcode.util.LogUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes12.dex */
public class ContactHelper {
    public static final int CONTACT_PICKER_REQUEST = 991;
    private boolean cancelLoad = false;
    private Context mContext;
    private ContentResolver mResolver;
    private Cursor phoneCursor;
    private static final String DISPLAY_NAME = "display_name";
    private static final Uri PHONE_CONTENT_URI = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
    private static final Uri EMAIL_CONTENT_URI = ContactsContract.CommonDataKinds.Email.CONTENT_URI;
    private static final String[] PROJECTION = {"_id", "in_visible_group", "display_name", "starred", "photo_uri", "photo_thumb_uri", "has_phone_number"};
    private static final String[] EMAIL_PROJECTION = {"contact_id", "data1"};
    private static final String[] NUMBER_PROJECTION = {"contact_id", "data1", "data2", "data3"};

    /* renamed from: com.sma.smartv3.ui.contactpicker.ContactHelper$1, reason: invalid class name */
    /* loaded from: classes12.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$sma$smartv3$ui$contactpicker$LimitColumn;

        static {
            int[] iArr = new int[LimitColumn.values().length];
            $SwitchMap$com$sma$smartv3$ui$contactpicker$LimitColumn = iArr;
            try {
                iArr[LimitColumn.EMAIL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$sma$smartv3$ui$contactpicker$LimitColumn[LimitColumn.PHONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$sma$smartv3$ui$contactpicker$LimitColumn[LimitColumn.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public ContactHelper(@NonNull Context context) {
        this.mContext = context;
        this.mResolver = context.getContentResolver();
    }

    private Cursor createCursor(String filter) {
        return this.mResolver.query(ContactsContract.Contacts.CONTENT_URI, PROJECTION, filter, null, DISPLAY_NAME);
    }

    private HashMap<Long, List<PhoneNumber>> getAllPhoneNumber() {
        HashMap<Long, List<PhoneNumber>> hashMap = new HashMap<>();
        if (this.phoneCursor == null) {
            this.phoneCursor = this.mResolver.query(PHONE_CONTENT_URI, NUMBER_PROJECTION, null, null, null);
            while (this.phoneCursor.moveToNext()) {
                Cursor cursor = this.phoneCursor;
                Long valueOf = Long.valueOf(cursor.getLong(cursor.getColumnIndex("contact_id")));
                Cursor cursor2 = this.phoneCursor;
                String string = cursor2.getString(cursor2.getColumnIndex("data1"));
                Cursor cursor3 = this.phoneCursor;
                int i = cursor3.getInt(cursor3.getColumnIndex("data2"));
                Cursor cursor4 = this.phoneCursor;
                String str = (String) ContactsContract.CommonDataKinds.Phone.getTypeLabel(this.mContext.getResources(), i, cursor4.getString(cursor4.getColumnIndex("data3")));
                List<PhoneNumber> list = hashMap.get(valueOf);
                if (list == null) {
                    list = new ArrayList<>();
                    hashMap.put(valueOf, list);
                }
                if (string != null && !string.isEmpty()) {
                    list.add(new PhoneNumber(str, string.replaceAll("\\s+", "").trim()));
                }
            }
        }
        LogUtils.d("phoneNumbers size = " + hashMap.size());
        return hashMap;
    }

    private void getEmail(long id, Contact contact) {
        Cursor query = this.mResolver.query(EMAIL_CONTENT_URI, EMAIL_PROJECTION, "contact_id = ?", new String[]{String.valueOf(id)}, null);
        if (query != null) {
            int columnIndex = query.getColumnIndex("data1");
            if (query.moveToFirst()) {
                ColumnMapper.mapEmail(query, contact, columnIndex);
            }
            query.close();
        }
    }

    private String getFilter(LimitColumn limitColumn) {
        if (AnonymousClass1.$SwitchMap$com$sma$smartv3$ui$contactpicker$LimitColumn[limitColumn.ordinal()] != 2) {
            return null;
        }
        return "has_phone_number > 0";
    }

    private void getPhoneNumber(long id, Cursor cursor, Contact contact, int hasPhoneNumberColumnIndex, HashMap<Long, List<PhoneNumber>> phoneNumbers) {
        List<PhoneNumber> list;
        if (Integer.parseInt(cursor.getString(hasPhoneNumberColumnIndex)) <= 0 || (list = phoneNumbers.get(Long.valueOf(id))) == null || list.size() <= 0) {
            return;
        }
        contact.getPhoneNumbers().clear();
        contact.getPhoneNumbers().addAll(list);
    }

    public void load(LimitColumn columnLimitChoice, LoadCallBack callBack) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        long currentTimeMillis = System.currentTimeMillis();
        HashMap<Long, List<PhoneNumber>> allPhoneNumber = getAllPhoneNumber();
        LongSparseArray longSparseArray = new LongSparseArray();
        Cursor createCursor = createCursor(getFilter(columnLimitChoice));
        createCursor.moveToFirst();
        int columnIndex = createCursor.getColumnIndex("_id");
        int columnIndex2 = createCursor.getColumnIndex("in_visible_group");
        int columnIndex3 = createCursor.getColumnIndex(DISPLAY_NAME);
        int columnIndex4 = createCursor.getColumnIndex("starred");
        int columnIndex5 = createCursor.getColumnIndex("photo_uri");
        int columnIndex6 = createCursor.getColumnIndex("photo_thumb_uri");
        int columnIndex7 = createCursor.getColumnIndex("has_phone_number");
        while (!createCursor.isAfterLast() && !this.cancelLoad) {
            long j = currentTimeMillis;
            long j2 = createCursor.getLong(columnIndex);
            Contact contact = (Contact) longSparseArray.get(j2, null);
            if (contact == null) {
                contact = new Contact(j2);
            }
            Contact contact2 = contact;
            ColumnMapper.mapInVisibleGroup(createCursor, contact2, columnIndex2);
            ColumnMapper.mapDisplayName(createCursor, contact2, columnIndex3);
            ColumnMapper.mapStarred(createCursor, contact2, columnIndex4);
            ColumnMapper.mapPhoto(createCursor, contact2, columnIndex5);
            ColumnMapper.mapThumbnail(createCursor, contact2, columnIndex6);
            int i6 = AnonymousClass1.$SwitchMap$com$sma$smartv3$ui$contactpicker$LimitColumn[columnLimitChoice.ordinal()];
            if (i6 != 1) {
                if (i6 != 2) {
                    if (i6 != 3) {
                        i = columnIndex6;
                        i2 = columnIndex5;
                        i3 = columnIndex4;
                        i4 = columnIndex3;
                    } else {
                        getEmail(j2, contact2);
                        i = columnIndex6;
                        i2 = columnIndex5;
                        i3 = columnIndex4;
                        i4 = columnIndex3;
                        getPhoneNumber(j2, createCursor, contact2, columnIndex7);
                    }
                    i5 = columnIndex2;
                } else {
                    i = columnIndex6;
                    i2 = columnIndex5;
                    i3 = columnIndex4;
                    i4 = columnIndex3;
                    i5 = columnIndex2;
                    getPhoneNumber(j2, createCursor, contact2, columnIndex7, allPhoneNumber);
                }
            } else {
                i = columnIndex6;
                i2 = columnIndex5;
                i3 = columnIndex4;
                i4 = columnIndex3;
                i5 = columnIndex2;
                getEmail(j2, contact2);
            }
            if (columnLimitChoice == LimitColumn.EMAIL) {
                if (contact2.getEmails().size() > 0) {
                    longSparseArray.put(j2, contact2);
                    callBack.onNext(contact2);
                }
            } else {
                longSparseArray.put(j2, contact2);
                callBack.onNext(contact2);
            }
            createCursor.moveToNext();
            currentTimeMillis = j;
            columnIndex6 = i;
            columnIndex5 = i2;
            columnIndex4 = i3;
            columnIndex3 = i4;
            columnIndex2 = i5;
        }
        long j3 = currentTimeMillis;
        createCursor.close();
        Cursor cursor = this.phoneCursor;
        if (cursor != null) {
            cursor.close();
            this.phoneCursor = null;
        }
        LogUtils.d("加载完成，耗时：" + (System.currentTimeMillis() - j3) + "ms");
    }

    public void setCancelLoad(boolean cancel) {
        this.cancelLoad = cancel;
    }

    @Deprecated
    private void getPhoneNumber(long id, Cursor cursor, Contact contact, int hasPhoneNumberColumnIndex) {
        Cursor query;
        if (Integer.parseInt(cursor.getString(hasPhoneNumberColumnIndex)) <= 0 || (query = this.mResolver.query(PHONE_CONTENT_URI, NUMBER_PROJECTION, "contact_id = ?", new String[]{String.valueOf(id)}, null)) == null) {
            return;
        }
        query.moveToFirst();
        int columnIndex = query.getColumnIndex("data1");
        int columnIndex2 = query.getColumnIndex("data2");
        int columnIndex3 = query.getColumnIndex("data3");
        while (!query.isAfterLast()) {
            ColumnMapper.mapPhoneNumber(this.mContext, query, contact, columnIndex, columnIndex2, columnIndex3);
            query.moveToNext();
        }
        query.close();
    }
}
