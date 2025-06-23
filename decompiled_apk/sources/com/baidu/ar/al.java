package com.baidu.ar;

import com.baidu.ar.arplay.core.message.ARPMessage;
import java.util.HashMap;

/* loaded from: classes7.dex */
public class al {
    private ARPMessage.MessageHandler hJ;
    private boolean hK = false;
    private boolean hL = false;
    private boolean hM = false;
    private boolean hN = false;
    private boolean hO = false;
    private boolean hP = false;
    private boolean hQ = false;
    private boolean hR = false;
    private boolean hS = false;

    public al() {
        aU();
    }

    private void aU() {
        this.hJ = new ARPMessage.MessageHandler() { // from class: com.baidu.ar.al.1
            @Override // com.baidu.ar.arplay.core.message.ARPMessage.MessageHandler
            public void handleMessage(int i, int i2, HashMap<String, Object> hashMap) {
                if (hashMap != null) {
                    if (hashMap.get("disable_all") != null) {
                        if (1 == ((Integer) hashMap.get("disable_all")).intValue()) {
                            al.this.hK = true;
                        } else {
                            al.this.hK = false;
                        }
                    }
                    if (hashMap.get("disable_click") != null) {
                        if (1 == ((Integer) hashMap.get("disable_click")).intValue()) {
                            al.this.hL = true;
                        } else {
                            al.this.hL = false;
                        }
                    }
                    if (hashMap.get("disable_double_click") != null) {
                        if (1 == ((Integer) hashMap.get("disable_double_click")).intValue()) {
                            al.this.hM = true;
                        } else {
                            al.this.hM = false;
                        }
                    }
                    if (hashMap.get("disable_long_press") != null) {
                        if (1 == ((Integer) hashMap.get("disable_long_press")).intValue()) {
                            al.this.hN = true;
                        } else {
                            al.this.hN = false;
                        }
                    }
                    if (hashMap.get("disable_swipe") != null) {
                        if (1 == ((Integer) hashMap.get("disable_swipe")).intValue()) {
                            al.this.hO = true;
                        } else {
                            al.this.hO = false;
                        }
                    }
                    if (hashMap.get("disable_scroll") != null) {
                        if (1 == ((Integer) hashMap.get("disable_scroll")).intValue()) {
                            al.this.hP = true;
                        } else {
                            al.this.hP = false;
                        }
                    }
                    if (hashMap.get("disable_two_finger_scroll") != null) {
                        if (1 == ((Integer) hashMap.get("disable_two_finger_scroll")).intValue()) {
                            al.this.hQ = true;
                        } else {
                            al.this.hQ = false;
                        }
                    }
                    if (hashMap.get("disable_pinch") != null) {
                        if (1 == ((Integer) hashMap.get("disable_pinch")).intValue()) {
                            al.this.hR = true;
                        } else {
                            al.this.hR = false;
                        }
                    }
                    if (hashMap.get("disable_two_finger_rotate") != null) {
                        if (1 == ((Integer) hashMap.get("disable_two_finger_rotate")).intValue()) {
                            al.this.hS = true;
                        } else {
                            al.this.hS = false;
                        }
                    }
                }
            }
        };
    }

    public boolean aV() {
        return (this.hK || this.hL) ? false : true;
    }

    public boolean aW() {
        return (this.hK || this.hM) ? false : true;
    }

    public boolean aX() {
        return (this.hK || this.hN) ? false : true;
    }

    public boolean aY() {
        return (this.hK || this.hP) ? false : true;
    }

    public boolean aZ() {
        return (this.hK || this.hQ) ? false : true;
    }

    public boolean ba() {
        return (this.hK || this.hO) ? false : true;
    }

    public boolean bb() {
        return (this.hK || this.hR) ? false : true;
    }

    public boolean bc() {
        return (this.hK || this.hS) ? false : true;
    }

    public void onPause() {
        ARPMessage.getInstance().removeMessageHandeler(this.hJ);
    }

    public void onResume() {
        ARPMessage.getInstance().registerMessageHandler(11, this.hJ);
    }

    public void release() {
        this.hJ = null;
    }
}
