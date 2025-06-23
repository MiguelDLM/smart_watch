package org.eclipse.paho.android.service;

import OoOoXO0.Oxx0xo;
import java.util.Iterator;

/* loaded from: classes6.dex */
interface MessageStore {

    /* loaded from: classes6.dex */
    public interface StoredMessage {
        String getClientHandle();

        Oxx0xo getMessage();

        String getMessageId();

        String getTopic();
    }

    void clearArrivedMessages(String str);

    void close();

    boolean discardArrived(String str, String str2);

    Iterator<StoredMessage> getAllArrivedMessages(String str);

    String storeArrived(String str, String str2, Oxx0xo oxx0xo);
}
