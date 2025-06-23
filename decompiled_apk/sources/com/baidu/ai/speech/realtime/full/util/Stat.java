package com.baidu.ai.speech.realtime.full.util;

import android.text.TextUtils;
import com.baidu.ai.speech.realtime.Util;
import com.baidu.ai.speech.realtime.full.download.Result;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public class Stat {
    private volatile long afterFinishFrameTime;
    private volatile long afterStartFrameTime;
    private volatile long beforeConnectTime;
    private volatile long lastResultRecieveTime;
    private volatile long onOpenTime;
    private SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss.SSS");
    private List<Result> results = Collections.synchronizedList(new ArrayList());

    public static StringBuilder formatResult(Result result) {
        StringBuilder sb = new StringBuilder();
        if (result.getErrNo() == -3005) {
            sb.append("【噪音】");
        } else if (result.getErrNo() != 0) {
            sb.append("【出错】");
        } else if (result.getType().equals(Result.TYPE_FIN_TEXT)) {
            sb.append("【一句话最终结果】");
        } else if (result.getType().equals(Result.TYPE_MID_TEXT)) {
            sb.append("【一句话临时结果】");
        }
        if (result.getResult() != null) {
            sb.append(result.getResult());
        }
        if (result.getErrNo() != 0) {
            sb.append("[");
            sb.append(result.getErrNo());
            sb.append(" | ");
            sb.append(result.getErrMsg());
            sb.append("]");
        }
        if (result.getStartTime() >= 0) {
            long startTime = result.getStartTime();
            long endTime = result.getEndTime();
            sb.append("[时长： ");
            sb.append(result.getStartTime());
            sb.append("ms 至 ");
            sb.append(endTime);
            sb.append("ms]");
            sb.append("[字节： ");
            sb.append(Util.timeToBytes(startTime));
            sb.append(" 至 ");
            sb.append(Util.timeToBytes(endTime));
            sb.append("]");
        }
        return sb;
    }

    private StringBuilder formatTime(long timeStamp, String message) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(this.formatter.format(new Date(timeStamp)));
        sb.append("] ");
        sb.append(message);
        sb.append("\n");
        return sb;
    }

    public void addResult(Result result) {
        this.lastResultRecieveTime = System.currentTimeMillis();
        this.results.add(result);
    }

    public int getErrNo() {
        Iterator<Result> it = this.results.iterator();
        int i = 0;
        while (it.hasNext()) {
            i = it.next().getErrNo();
        }
        return i;
    }

    public String getResult() {
        Iterator<Result> it = this.results.iterator();
        String str = null;
        while (it.hasNext()) {
            str = it.next().getResult();
            if (!TextUtils.isEmpty(str)) {
                break;
            }
        }
        return str;
    }

    public String toReportString() {
        StringBuilder sb = new StringBuilder("\n");
        sb.append((CharSequence) formatTime(this.beforeConnectTime, "准备发起websocket连接"));
        sb.append((CharSequence) formatTime(this.onOpenTime, "websocket 连接建立"));
        sb.append((CharSequence) formatTime(this.afterStartFrameTime, "第一个FRAME开始START帧发送完成"));
        sb.append((CharSequence) formatTime(this.afterFinishFrameTime, "最后一个FRAME结束FINISH帧发送完成"));
        sb.append((CharSequence) formatTime(this.lastResultRecieveTime, "最后一个句子的识别结果收到"));
        sb.append("==============\n");
        for (Result result : this.results) {
            sb.append("result:");
            sb.append((CharSequence) formatTime(result.getReceiveTime(), formatResult(result).toString()));
        }
        return sb.toString();
    }

    public void updateAfterFinishFrameTime() {
        this.afterFinishFrameTime = System.currentTimeMillis();
    }

    public void updateAfterStartFrameTime() {
        this.afterStartFrameTime = System.currentTimeMillis();
    }

    public void updateBeforeConnectTime() {
        this.beforeConnectTime = System.currentTimeMillis();
    }

    public void updateOnOpenTime() {
        this.onOpenTime = System.currentTimeMillis();
    }
}
