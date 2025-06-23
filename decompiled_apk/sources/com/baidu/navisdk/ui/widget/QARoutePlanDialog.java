package com.baidu.navisdk.ui.widget;

import android.app.Activity;
import android.app.Dialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.routeplan.v2.a;
import com.baidu.navisdk.comapi.routeplan.v2.b;
import com.baidu.navisdk.comapi.routeplan.v2.d;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comjni.tools.JNITools;
import com.huawei.openalliance.ad.constant.x;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/* loaded from: classes8.dex */
public class QARoutePlanDialog extends Dialog {
    private static final String TAG = "QACruiser";
    private BufferedReader br;
    private int cancelCount;
    private int engineFailCount;
    private Activity mActivity;
    private ViewGroup mRootView;
    private a mSingleRPListenerV2;
    private MyTask mTask;
    private ArrayList<RoutePlanNode> nodeList;
    private int normalFailCount;
    private int poiListCount;
    private File resultFile;
    private SimpleDateFormat sDF;
    private int successCount;

    /* loaded from: classes8.dex */
    public class MyTask extends AsyncTask<String, Integer, String> {
        private MyTask() {
        }

        @Override // android.os.AsyncTask
        public void onCancelled() {
            ((Button) QARoutePlanDialog.this.mRootView.findViewById(R.id.calc_button)).setText("已取消");
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            ((Button) QARoutePlanDialog.this.mRootView.findViewById(R.id.calc_button)).setText("算路中");
        }

        @Override // android.os.AsyncTask
        public String doInBackground(String... strArr) {
            LogUtil.e(QARoutePlanDialog.TAG, "开始执行任务");
            QARoutePlanDialog.this.successCount = 0;
            QARoutePlanDialog.this.engineFailCount = 0;
            QARoutePlanDialog.this.normalFailCount = 0;
            QARoutePlanDialog.this.cancelCount = 0;
            QARoutePlanDialog.this.poiListCount = 0;
            File file = new File(Environment.getExternalStorageDirectory().toString() + "/Android/data/com.baidu.BaiduMap/BaiduMap/bnav/QARouteplanTestFile.txt");
            QARoutePlanDialog.this.resultFile = new File(Environment.getExternalStorageDirectory().toString() + "/Android/data/com.baidu.BaiduMap/BaiduMap/bnav/QARouteplanResultFile.txt");
            try {
                QARoutePlanDialog.this.br = new BufferedReader(new FileReader(file));
                if (QARoutePlanDialog.this.resultFile.exists()) {
                    QARoutePlanDialog.this.resultFile.delete();
                    LogUtil.e(QARoutePlanDialog.TAG, "删除文件");
                }
                QARoutePlanDialog.this.resultFile.createNewFile();
                LogUtil.e(QARoutePlanDialog.TAG, "创建文件");
            } catch (Exception e) {
                LogUtil.e(QARoutePlanDialog.TAG, "读文件或创建文件出现异常");
                e.printStackTrace();
            }
            QARoutePlanDialog.this.calRoute();
            return null;
        }
    }

    public QARoutePlanDialog(Activity activity) {
        super(activity);
        this.nodeList = new ArrayList<>();
        this.successCount = 0;
        this.engineFailCount = 0;
        this.normalFailCount = 0;
        this.cancelCount = 0;
        this.poiListCount = 0;
        this.sDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        this.mSingleRPListenerV2 = new a() { // from class: com.baidu.navisdk.ui.widget.QARoutePlanDialog.2
            @Override // com.baidu.navisdk.comapi.routeplan.v2.a
            public String getName() {
                return null;
            }

            @Override // com.baidu.navisdk.comapi.routeplan.v2.a
            public void onRoutePlan(int i, int i2, d dVar, Bundle bundle) {
                LogUtil.e(QARoutePlanDialog.TAG, "返回算路结果类型" + i);
                LogUtil.e(QARoutePlanDialog.TAG, "返回算路结果子类型" + i2);
                if (i != 49) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                if (i != 5) {
                                    LogUtil.e(QARoutePlanDialog.TAG, "未知结果");
                                } else {
                                    LogUtil.e(QARoutePlanDialog.TAG, "算路取消一次");
                                    QARoutePlanDialog.this.mActivity.runOnUiThread(new Runnable() { // from class: com.baidu.navisdk.ui.widget.QARoutePlanDialog.2.4
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            TextView textView = (TextView) QARoutePlanDialog.this.mRootView.findViewById(R.id.calc_cancle);
                                            QARoutePlanDialog.access$608(QARoutePlanDialog.this);
                                            textView.setText("算路取消" + QARoutePlanDialog.this.cancelCount + "次");
                                            QARoutePlanDialog.this.writeRoutePlanResult(QARoutePlanDialog.this.sDF.format(new Date()) + " 算路取消次数：" + QARoutePlanDialog.this.cancelCount);
                                        }
                                    });
                                    QARoutePlanDialog.this.calRoute();
                                }
                            } else {
                                LogUtil.e(QARoutePlanDialog.TAG, "算路引擎失败一次");
                                QARoutePlanDialog.this.mActivity.runOnUiThread(new Runnable() { // from class: com.baidu.navisdk.ui.widget.QARoutePlanDialog.2.3
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        TextView textView = (TextView) QARoutePlanDialog.this.mRootView.findViewById(R.id.calc_engine_fail);
                                        QARoutePlanDialog.access$408(QARoutePlanDialog.this);
                                        textView.setText("算路引擎失败" + QARoutePlanDialog.this.engineFailCount + "次");
                                        QARoutePlanDialog.this.writeRoutePlanResult(QARoutePlanDialog.this.sDF.format(new Date()) + " 算路引擎失败次数：" + QARoutePlanDialog.this.engineFailCount);
                                    }
                                });
                                QARoutePlanDialog.this.calRoute();
                            }
                        } else {
                            LogUtil.e(QARoutePlanDialog.TAG, "算路通用失败一次");
                            QARoutePlanDialog.this.mActivity.runOnUiThread(new Runnable() { // from class: com.baidu.navisdk.ui.widget.QARoutePlanDialog.2.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    TextView textView = (TextView) QARoutePlanDialog.this.mRootView.findViewById(R.id.calc_normal_fail);
                                    QARoutePlanDialog.access$508(QARoutePlanDialog.this);
                                    textView.setText("算路通用失败" + QARoutePlanDialog.this.normalFailCount + "次");
                                    QARoutePlanDialog.this.writeRoutePlanResult(QARoutePlanDialog.this.sDF.format(new Date()) + " 算路通用失败次数：" + QARoutePlanDialog.this.normalFailCount);
                                }
                            });
                            QARoutePlanDialog.this.calRoute();
                        }
                    } else {
                        LogUtil.e(QARoutePlanDialog.TAG, "算路成功一次");
                        QARoutePlanDialog.this.mActivity.runOnUiThread(new Runnable() { // from class: com.baidu.navisdk.ui.widget.QARoutePlanDialog.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                TextView textView = (TextView) QARoutePlanDialog.this.mRootView.findViewById(R.id.calc_success);
                                QARoutePlanDialog.access$308(QARoutePlanDialog.this);
                                LogUtil.e(QARoutePlanDialog.TAG, "成功次数" + QARoutePlanDialog.this.successCount);
                                textView.setText("算路成功" + QARoutePlanDialog.this.successCount + "次");
                                QARoutePlanDialog.this.writeRoutePlanResult(QARoutePlanDialog.this.sDF.format(new Date()) + " 算路成功次数：" + QARoutePlanDialog.this.successCount);
                            }
                        });
                        QARoutePlanDialog.this.calRoute();
                    }
                } else {
                    LogUtil.e(QARoutePlanDialog.TAG, "算路多结果一次");
                    QARoutePlanDialog.this.mActivity.runOnUiThread(new Runnable() { // from class: com.baidu.navisdk.ui.widget.QARoutePlanDialog.2.5
                        @Override // java.lang.Runnable
                        public void run() {
                            TextView textView = (TextView) QARoutePlanDialog.this.mRootView.findViewById(R.id.calc_POIlist);
                            QARoutePlanDialog.access$708(QARoutePlanDialog.this);
                            textView.setText("算路多结果" + QARoutePlanDialog.this.poiListCount + "次");
                            QARoutePlanDialog.this.writeRoutePlanResult(QARoutePlanDialog.this.sDF.format(new Date()) + " 算路多结果次数：" + QARoutePlanDialog.this.poiListCount);
                        }
                    });
                    QARoutePlanDialog.this.calRoute();
                }
                LogUtil.e(QARoutePlanDialog.TAG, "switch结束");
            }
        };
        this.mActivity = activity;
        Window window = getWindow();
        requestWindowFeature(1);
        window.setBackgroundDrawableResource(android.R.color.transparent);
        window.getAttributes().gravity = 17;
        View view = null;
        try {
            view = JarUtils.oldInflate(activity, R.layout.nsdk_layout_qa_routeplan_tool, null);
        } catch (Exception unused) {
        }
        if (view == null) {
            return;
        }
        setContentView(view);
        this.mRootView = (ViewGroup) view;
        setCanceledOnTouchOutside(false);
        setCancelable(true);
        getWindow().getAttributes().gravity = 17;
    }

    public static /* synthetic */ int access$308(QARoutePlanDialog qARoutePlanDialog) {
        int i = qARoutePlanDialog.successCount;
        qARoutePlanDialog.successCount = i + 1;
        return i;
    }

    public static /* synthetic */ int access$408(QARoutePlanDialog qARoutePlanDialog) {
        int i = qARoutePlanDialog.engineFailCount;
        qARoutePlanDialog.engineFailCount = i + 1;
        return i;
    }

    public static /* synthetic */ int access$508(QARoutePlanDialog qARoutePlanDialog) {
        int i = qARoutePlanDialog.normalFailCount;
        qARoutePlanDialog.normalFailCount = i + 1;
        return i;
    }

    public static /* synthetic */ int access$608(QARoutePlanDialog qARoutePlanDialog) {
        int i = qARoutePlanDialog.cancelCount;
        qARoutePlanDialog.cancelCount = i + 1;
        return i;
    }

    public static /* synthetic */ int access$708(QARoutePlanDialog qARoutePlanDialog) {
        int i = qARoutePlanDialog.poiListCount;
        qARoutePlanDialog.poiListCount = i + 1;
        return i;
    }

    public static RoutePlanNode getNode(String[] strArr) {
        if ("Point".equals(strArr[0])) {
            RoutePlanNode routePlanNode = new RoutePlanNode();
            routePlanNode.setNodeType(1);
            routePlanNode.setFrom(1);
            Bundle Bd09mcToGcj02 = JNITools.Bd09mcToGcj02((int) Double.parseDouble(strArr[1]), (int) Double.parseDouble(strArr[2]));
            routePlanNode.setGeoPoint(new GeoPoint((int) (Bd09mcToGcj02.getDouble("LLx") * 100000.0d), (int) (Bd09mcToGcj02.getDouble("LLy") * 100000.0d)));
            if (!"".equals(strArr[3])) {
                routePlanNode.setUID(strArr[3]);
            }
            routePlanNode.setDistrictID(Integer.parseInt(strArr[4]));
            if (!"".equals(strArr[6])) {
                routePlanNode.setDescription(strArr[6]);
                return routePlanNode;
            }
            return routePlanNode;
        }
        if ("Keyword".equals(strArr[0])) {
            RoutePlanNode routePlanNode2 = new RoutePlanNode();
            routePlanNode2.setNodeType(2);
            routePlanNode2.setFrom(2);
            if (!"".equals(strArr[2])) {
                routePlanNode2.setUID(strArr[2]);
            }
            routePlanNode2.setDistrictID(Integer.parseInt(strArr[4]));
            routePlanNode2.setName(strArr[5]);
            if (!"".equals(strArr[6])) {
                routePlanNode2.setDescription(strArr[6]);
                return routePlanNode2;
            }
            return routePlanNode2;
        }
        return null;
    }

    public void calRoute() {
        if (getNodeInfo()) {
            routeplan(this.nodeList);
        } else {
            this.mActivity.runOnUiThread(new Runnable() { // from class: com.baidu.navisdk.ui.widget.QARoutePlanDialog.3
                @Override // java.lang.Runnable
                public void run() {
                    ((Button) QARoutePlanDialog.this.mRootView.findViewById(R.id.calc_button)).setText("算路完成");
                }
            });
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        super.cancel();
        MyTask myTask = this.mTask;
        if (myTask != null && myTask.getStatus() == AsyncTask.Status.RUNNING) {
            this.mTask.cancel(true);
            this.mTask = null;
        }
    }

    public Activity getActivity() {
        return this.mActivity;
    }

    public boolean getNodeInfo() {
        try {
            String readLine = this.br.readLine();
            if (readLine == null) {
                return false;
            }
            LogUtil.e(TAG, "整行信息" + readLine);
            writeRoutePlanResult(this.sDF.format(new Date()) + readLine);
            String[] split = readLine.split(x.aL);
            String[] split2 = split[0].split(",", -1);
            String[] split3 = split[1].split(",", -1);
            split[2].split(",");
            RoutePlanNode node = getNode(split2);
            RoutePlanNode node2 = getNode(split3);
            LogUtil.e(TAG, node.toString());
            LogUtil.e(TAG, node2.toString());
            if (!this.nodeList.isEmpty()) {
                this.nodeList.remove(0);
                this.nodeList.remove(0);
            }
            this.nodeList.add(node);
            this.nodeList.add(node2);
            return true;
        } catch (Exception e) {
            LogUtil.e(TAG, "读文件并解析出现异常");
            e.printStackTrace();
            return false;
        }
    }

    public boolean isRouteCruiseBegin() {
        return true;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, Activity activity) {
        this.mActivity = activity;
        LogUtil.e(TAG, "进入onCreateView()");
        ViewGroup viewGroup2 = (ViewGroup) JarUtils.inflate(activity, R.layout.nsdk_layout_qa_routeplan_tool, null);
        this.mRootView = viewGroup2;
        return viewGroup2;
    }

    @Override // android.app.Dialog
    public void onStart() {
        LogUtil.e(TAG, "进入onStart()");
        Button button = (Button) this.mRootView.findViewById(R.id.calc_button);
        LogUtil.e(TAG, "算路button");
        LogUtil.e(TAG, button.toString());
        button.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.navisdk.ui.widget.QARoutePlanDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LogUtil.e(QARoutePlanDialog.TAG, "点击开始算路");
                if (QARoutePlanDialog.this.mTask != null && QARoutePlanDialog.this.mTask.getStatus() == AsyncTask.Status.RUNNING) {
                    QARoutePlanDialog.this.mTask.cancel(true);
                    QARoutePlanDialog.this.mTask = null;
                } else {
                    QARoutePlanDialog.this.mTask = new MyTask();
                    QARoutePlanDialog.this.mTask.execute(new String[0]);
                }
            }
        });
    }

    public boolean routeplan(ArrayList<RoutePlanNode> arrayList) {
        if (arrayList == null) {
            LogUtil.out(TAG, "routeplan() return for the origin nodes is null.");
            return false;
        }
        b bVar = new b();
        bVar.f6726a = arrayList.get(0);
        bVar.b = arrayList.get(1);
        bVar.d = 1;
        bVar.f = 4;
        bVar.g = 0;
        bVar.h = 0;
        bVar.p = this.mSingleRPListenerV2;
        if (bVar.r == null) {
            bVar.r = new Bundle();
        }
        bVar.r.putBoolean("extra_key_enter_routeguide", false);
        LogUtil.e(TAG, "calcRouteForPBDataV2() start to calcRouteV2.");
        BNRoutePlaner.getInstance().a(bVar);
        return true;
    }

    public void writeRoutePlanResult(String str) {
        try {
            FileWriter fileWriter = new FileWriter(this.resultFile, true);
            fileWriter.write(str);
            fileWriter.append((CharSequence) " \r\n");
            fileWriter.flush();
            fileWriter.close();
        } catch (Exception e) {
            LogUtil.e(TAG, e.toString());
        }
    }
}
