package Xxx0oXX;

import org.apache.log4j.x0XOIxOo;

/* loaded from: classes6.dex */
public class oxoX implements II0xO0 {
    @Override // Xxx0oXX.II0xO0
    public String oIX0oI(Object obj) {
        if (obj instanceof ThreadGroup) {
            StringBuffer stringBuffer = new StringBuffer();
            ThreadGroup threadGroup = (ThreadGroup) obj;
            stringBuffer.append("java.lang.ThreadGroup[name=");
            stringBuffer.append(threadGroup.getName());
            stringBuffer.append(", maxpri=");
            stringBuffer.append(threadGroup.getMaxPriority());
            stringBuffer.append("]");
            int activeCount = threadGroup.activeCount();
            Thread[] threadArr = new Thread[activeCount];
            threadGroup.enumerate(threadArr);
            for (int i = 0; i < activeCount; i++) {
                stringBuffer.append(x0XOIxOo.f33503oIX0oI);
                stringBuffer.append("   Thread=[");
                stringBuffer.append(threadArr[i].getName());
                stringBuffer.append(",");
                stringBuffer.append(threadArr[i].getPriority());
                stringBuffer.append(",");
                stringBuffer.append(threadArr[i].isDaemon());
                stringBuffer.append("]");
            }
            return stringBuffer.toString();
        }
        return obj.toString();
    }
}
