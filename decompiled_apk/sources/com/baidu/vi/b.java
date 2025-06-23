package com.baidu.vi;

/* loaded from: classes8.dex */
class b extends Thread {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AudioRecorder f10217a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(AudioRecorder audioRecorder, String str) {
        super(str);
        this.f10217a = audioRecorder;
    }

    /* JADX WARN: Incorrect condition in loop: B:3:0x0016 */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void run() {
        /*
            r4 = this;
            r0 = -19
            android.os.Process.setThreadPriority(r0)
            com.baidu.vi.AudioRecorder r0 = r4.f10217a
            android.media.AudioRecord r0 = com.baidu.vi.AudioRecorder.b(r0)
            r0.startRecording()
            r0 = 0
            r1 = 0
        L10:
            com.baidu.vi.AudioRecorder r2 = r4.f10217a
            boolean r2 = com.baidu.vi.AudioRecorder.a(r2)
            if (r2 == 0) goto L50
            com.baidu.vi.AudioRecorder r2 = r4.f10217a
            int r2 = com.baidu.vi.AudioRecorder.c(r2)
            byte[] r2 = new byte[r2]
            com.baidu.vi.AudioRecorder r3 = r4.f10217a
            android.media.AudioRecord r3 = com.baidu.vi.AudioRecorder.b(r3)
            if (r3 == 0) goto L38
            com.baidu.vi.AudioRecorder r1 = r4.f10217a
            android.media.AudioRecord r1 = com.baidu.vi.AudioRecorder.b(r1)
            com.baidu.vi.AudioRecorder r3 = r4.f10217a
            int r3 = com.baidu.vi.AudioRecorder.c(r3)
            int r1 = r1.read(r2, r0, r3)
        L38:
            r3 = -3
            if (r1 == r3) goto L4a
            r3 = -2
            if (r1 == r3) goto L4a
            r3 = -1
            if (r1 == r3) goto L4a
            if (r1 != 0) goto L44
            goto L4a
        L44:
            com.baidu.vi.AudioRecorder r3 = r4.f10217a
            com.baidu.vi.AudioRecorder.a(r3, r2, r1)
            goto L10
        L4a:
            com.baidu.vi.AudioRecorder r2 = r4.f10217a
            com.baidu.vi.AudioRecorder.d(r2)
            goto L10
        L50:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.vi.b.run():void");
    }
}
