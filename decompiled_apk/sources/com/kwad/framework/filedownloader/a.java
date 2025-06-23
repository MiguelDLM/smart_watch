package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.x;

/* loaded from: classes11.dex */
public interface a {

    /* renamed from: com.kwad.framework.filedownloader.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0823a {
        boolean aY(int i);

        void free();

        boolean isOver();

        a uH();

        x.a uI();

        int uJ();

        void uK();

        boolean uL();

        void uM();

        void uN();

        boolean uO();
    }

    /* loaded from: classes11.dex */
    public interface b {
        int uP();
    }

    /* loaded from: classes11.dex */
    public interface c {
        void onBegin();

        void uQ();
    }

    a a(i iVar);

    a aX(int i);

    a ba(boolean z);

    a bb(boolean z);

    a bc(String str);

    a bc(boolean z);

    a bd(String str);

    a c(String str, boolean z);

    boolean cancel();

    a e(Object obj);

    String getFilename();

    int getId();

    String getPath();

    int getSmallFileSoFarBytes();

    int getSmallFileTotalBytes();

    int getSpeed();

    long getStatusUpdateTime();

    Object getTag();

    String getTargetFilePath();

    String getUrl();

    boolean isRunning();

    boolean pause();

    int start();

    a t(String str, String str2);

    boolean uA();

    Throwable uB();

    int uC();

    int uD();

    boolean uE();

    boolean uF();

    boolean uG();

    b uq();

    boolean ur();

    boolean us();

    int ut();

    int uu();

    boolean uv();

    i uw();

    long ux();

    long uy();

    byte uz();
}
