package com.sma.smartv3.ui.contactpicker;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;

/* loaded from: classes12.dex */
class ColumnMapper {
    private ColumnMapper() {
    }

    public static void mapDisplayName(Cursor cursor, Contact contact, int columnIndex) {
        String string = cursor.getString(columnIndex);
        if (string != null && !string.isEmpty()) {
            contact.setDisplayName(string);
        }
    }

    public static void mapEmail(Cursor cursor, Contact contact, int columnIndex) {
        String string = cursor.getString(columnIndex);
        if (string != null && !string.trim().isEmpty()) {
            contact.getEmails().add(string);
        }
    }

    public static void mapInVisibleGroup(Cursor cursor, Contact contact, int columnIndex) {
        contact.setInVisibleGroup(cursor.getInt(columnIndex));
    }

    public static void mapPhoneNumber(Context con, Cursor cursor, Contact contact, int noColumnIndex, int typeColIndex, int labelColIndex) {
        String string = cursor.getString(noColumnIndex);
        String str = (String) ContactsContract.CommonDataKinds.Phone.getTypeLabel(con.getResources(), cursor.getInt(typeColIndex), cursor.getString(labelColIndex));
        if (string != null && !string.isEmpty()) {
            contact.getPhoneNumbers().add(new PhoneNumber(str, string.replaceAll("\\s+", "").trim()));
        }
    }

    public static void mapPhoto(Cursor cursor, Contact contact, int columnIndex) {
        String string = cursor.getString(columnIndex);
        if (string != null && !string.isEmpty()) {
            contact.setPhoto(Uri.parse(string));
        }
    }

    public static void mapStarred(Cursor cursor, Contact contact, int columnIndex) {
        boolean z;
        if (cursor.getInt(columnIndex) != 0) {
            z = true;
        } else {
            z = false;
        }
        contact.setStarred(z);
    }

    public static void mapThumbnail(Cursor cursor, Contact contact, int columnIndex) {
        String string = cursor.getString(columnIndex);
        if (string != null && !string.isEmpty()) {
            contact.setThumbnail(Uri.parse(string));
        }
    }
}
