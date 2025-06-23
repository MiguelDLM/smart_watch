package com.baidu.ar.arplay.core.message;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ar.arplay.core.engine.ARPEngine;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes7.dex */
public class ARPMessage {
    private static final int INVALID_MESSAGE_ID = -1;
    private static final int MSG_MESSAGE_FROM_ENGINE = 1;
    private static ARPMessage mARPMessage;
    private Handler mHandler;
    private boolean mIsInitNative = false;
    private List<ArCallback> mMsgHandlers;
    private HandlerThread mThread;

    /* loaded from: classes7.dex */
    public static class ArCallback {
        public MessageHandler mHandler;
        public int mMessageId;
        public int mMessageType;

        public ArCallback(int i, int i2, MessageHandler messageHandler) {
            this.mMessageType = i;
            this.mMessageId = i2;
            this.mHandler = messageHandler;
        }
    }

    /* loaded from: classes7.dex */
    public static class ArMessage {
        public HashMap<String, Object> mData;
        public int mMessageID;
        public int mMessageType;
        public int mResMessageID;

        public ArMessage(int i, int i2, HashMap<String, Object> hashMap, int i3) {
            this.mMessageType = i;
            this.mMessageID = i2;
            this.mData = hashMap;
            this.mResMessageID = i3;
        }
    }

    /* loaded from: classes7.dex */
    public interface MessageHandler {
        void handleMessage(int i, int i2, HashMap<String, Object> hashMap);
    }

    public ARPMessage() {
        HandlerThread handlerThread = new HandlerThread("msg_callback_thread");
        this.mThread = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.mThread.getLooper(), new Handler.Callback() { // from class: com.baidu.ar.arplay.core.message.ARPMessage.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.what != 1) {
                    return false;
                }
                ARPMessage.this.processIncomingMessage((ArMessage) message.obj);
                return false;
            }
        });
        this.mMsgHandlers = new LinkedList();
    }

    public static ARPMessage getInstance() {
        ARPMessage aRPMessage;
        ARPMessage aRPMessage2 = mARPMessage;
        if (aRPMessage2 != null) {
            return aRPMessage2;
        }
        synchronized (ARPMessage.class) {
            try {
                if (mARPMessage == null) {
                    mARPMessage = new ARPMessage();
                }
                aRPMessage = mARPMessage;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aRPMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processIncomingMessage(ArMessage arMessage) {
        for (ArCallback arCallback : this.mMsgHandlers) {
            int i = arCallback.mMessageType;
            if (i == 0 || arMessage.mMessageType == i) {
                int i2 = arCallback.mMessageId;
                if (-1 == i2 || arMessage.mResMessageID == i2) {
                    arCallback.mHandler.handleMessage(arMessage.mMessageType, arMessage.mMessageID, arMessage.mData);
                }
            }
        }
    }

    private void sendMessageImpl(int i, boolean z, HashMap<String, Object> hashMap, int i2) {
        if (ARPEngine.getInstance().isEngineCanAccess()) {
            sendMessageToEngine(i, getMessageID(), z, hashMap, i2);
        }
    }

    public native int getMessageID();

    public native void nativeFinalize();

    public native void nativeSetup(Object obj);

    public void receiveMsgFromEngine(int i, int i2, HashMap<String, Object> hashMap, int i3) {
        Log.d("ARPMessage", "receiveMsgFromEngine :" + i);
        this.mHandler.obtainMessage(1, new ArMessage(i, i2, hashMap, i3)).sendToTarget();
    }

    public synchronized void registerMessageHandler(final int i, final MessageHandler messageHandler) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.ar.arplay.core.message.ARPMessage.2
            @Override // java.lang.Runnable
            public void run() {
                ARPMessage.this.mMsgHandlers.add(new ArCallback(i, -1, messageHandler));
            }
        });
    }

    public void release() {
        this.mHandler.removeCallbacks(null);
        this.mHandler.post(new Runnable() { // from class: com.baidu.ar.arplay.core.message.ARPMessage.4
            @Override // java.lang.Runnable
            public void run() {
                if (ARPMessage.this.mMsgHandlers != null) {
                    ARPMessage.this.mMsgHandlers.clear();
                }
            }
        });
        nativeFinalize();
        this.mIsInitNative = false;
    }

    public synchronized void removeMessageHandeler(final MessageHandler messageHandler) {
        this.mHandler.post(new Runnable() { // from class: com.baidu.ar.arplay.core.message.ARPMessage.3
            @Override // java.lang.Runnable
            public void run() {
                if (ARPMessage.this.mMsgHandlers == null) {
                    return;
                }
                Iterator it = ARPMessage.this.mMsgHandlers.iterator();
                while (it.hasNext()) {
                    if (((ArCallback) it.next()).mHandler == messageHandler) {
                        it.remove();
                    }
                }
            }
        });
    }

    public void sendLuaScriptToEngine(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("script", str);
        sendMessage(2001, hashMap);
    }

    public void sendMessage(int i, HashMap<String, Object> hashMap) {
        sendMessageImpl(i, true, hashMap, -1);
    }

    public native void sendMessageToEngine(int i, int i2, boolean z, HashMap<String, Object> hashMap, int i3);

    public void sendResponseMessage(int i, HashMap<String, Object> hashMap, int i2) {
        sendMessageImpl(i, true, hashMap, i2);
    }

    public void setModelVirtualColor(int i, boolean z) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("model_color", Integer.valueOf(i));
        if (!z) {
            hashMap.put("model_type", 1);
        }
        sendMessage(2002, hashMap);
    }

    public void setUp() {
        if (this.mIsInitNative) {
            return;
        }
        nativeSetup(new WeakReference(this));
        this.mIsInitNative = true;
    }

    private static void receiveMsgFromEngine(Object obj, int i, int i2, HashMap<String, Object> hashMap, int i3) {
        ARPMessage aRPMessage;
        if (obj == null || (aRPMessage = (ARPMessage) ((WeakReference) obj).get()) == null) {
            return;
        }
        aRPMessage.receiveMsgFromEngine(i, i2, hashMap, i3);
    }

    public void sendMessage(int i, boolean z, HashMap<String, Object> hashMap) {
        sendMessageImpl(i, z, hashMap, -1);
    }
}
