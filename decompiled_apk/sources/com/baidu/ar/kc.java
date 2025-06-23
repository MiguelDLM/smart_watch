package com.baidu.ar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import com.baidu.R;
import com.baidu.ar.bean.NavigationNpc;
import com.baidu.ar.marker.model.TranslationPrior;
import com.baidu.ar.util.UiThreadUtil;
import com.facebook.login.widget.ToolTipPopup;
import com.sma.smartv3.util.xoIox;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes7.dex */
public class kc implements SensorEventListener, kb {
    private static kc BC;
    private ViewGroup BD;
    private boolean BE;
    private Handler BF;
    private View.OnClickListener BJ;
    private View.OnClickListener BK;
    private ka BL;
    private RelativeLayout BN;
    private RelativeLayout BO;
    private RelativeLayout BP;
    private RelativeLayout BQ;
    private RelativeLayout BR;
    private boolean BS;
    private int BV;
    private boolean BW;
    private boolean BX;
    private boolean BY;
    private TextView Ca;
    private ScrollView Cb;
    private int Cd;
    private Button Ce;
    private Button Cf;
    private Button Cg;
    private Button Ch;
    private Button Ci;
    private TextView Cl;
    private boolean Cm;
    private boolean Co;
    private boolean Cp;
    private Handler Cr;
    private String Cs;
    private boolean Ct;
    private ImageView Cu;
    private ImageView Cv;
    private Context mContext;
    private float sY;
    private SensorManager sv;
    private RelativeLayout BG = null;
    private RelativeLayout BH = null;
    private RelativeLayout BI = null;
    private long BM = 0;
    private long BT = System.currentTimeMillis();
    private float BU = 50.0f;
    private TextView BZ = null;
    private StringBuffer Cc = new StringBuffer();
    private long dK = System.currentTimeMillis();
    private ValueAnimator Cj = null;
    private ValueAnimator Ck = null;
    private boolean Cn = true;
    private int Cq = -1;
    private String[] Cw = {" . ", " . . ", " . . ."};
    private boolean Cx = false;
    private int Cy = -86;

    /* loaded from: classes7.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        private View CN;

        public a(View view) {
            this.CN = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(final ValueAnimator valueAnimator) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.kc.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.CN != null) {
                        a.this.CN.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                }
            });
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends Handler {
        private kb CQ;

        public b(Looper looper, kb kbVar) {
            super(looper);
            this.CQ = kbVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.CQ.g(message);
        }
    }

    private kc(Context context, ViewGroup viewGroup, boolean z) {
        this.mContext = context;
        this.BD = viewGroup;
        if (z) {
            return;
        }
        this.BF = new b(context.getMainLooper(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(boolean z) {
        if (this.sY >= this.BU || this.BE) {
            RelativeLayout relativeLayout = this.BG;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            RelativeLayout relativeLayout2 = this.BO;
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(8);
            }
            RelativeLayout relativeLayout3 = this.BQ;
            if (relativeLayout3 != null) {
                relativeLayout3.setVisibility(8);
            }
            RelativeLayout relativeLayout4 = this.BR;
            if (relativeLayout4 != null) {
                relativeLayout4.setVisibility(8);
            }
            if (this.BN == null) {
                this.BN = (RelativeLayout) this.BD.findViewById(R.id.bdar_scanaroud_group);
            }
            this.BN.setVisibility(0);
            if (this.BI == null) {
                this.BI = (RelativeLayout) this.BD.findViewById(R.id.bdar_top_bar);
            }
            this.BI.setVisibility(0);
            ImageView imageView = (ImageView) this.BD.findViewById(R.id.bdar_image_scanaroud);
            ((TextView) this.BD.findViewById(R.id.bdar_text_scanroud)).setText(z ? R.string.bdar_hint_vpas_reset : R.string.bdar_hint_scan);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, R.anim.bdar_wsdk_scan_round_anim_set);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.ar.kc.5
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (kc.this.BN == null || kc.this.BF == null) {
                        return;
                    }
                    Message message = new Message();
                    message.what = 1002;
                    message.obj = kc.this.BN;
                    kc.this.BF.sendMessageDelayed(message, 1000L);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            });
            imageView.setAnimation(loadAnimation);
            imageView.startAnimation(loadAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cg(final String str) {
        Handler handler = this.BF;
        if (handler == null || this.BZ == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.baidu.ar.kc.4
            @Override // java.lang.Runnable
            public void run() {
                kc.this.BZ.setText(str);
                kc.this.Cb.fullScroll(130);
            }
        });
    }

    private void gF() {
        if (this.Cr == null) {
            this.Cr = new Handler() { // from class: com.baidu.ar.kc.1
                @Override // android.os.Handler
                public void handleMessage(final Message message) {
                    UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.kc.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            kc kcVar;
                            boolean z;
                            Message message2 = message;
                            if (message2 == null || message2.what != 1001 || kc.this.Cu == null) {
                                return;
                            }
                            kc.this.gH();
                            if (kc.this.Ct) {
                                ValueAnimator valueAnimator = kc.this.Cj;
                                kc kcVar2 = kc.this;
                                valueAnimator.addUpdateListener(new a(kcVar2.Cv));
                                kc.this.Cj.start();
                                ValueAnimator valueAnimator2 = kc.this.Ck;
                                kc kcVar3 = kc.this;
                                valueAnimator2.addUpdateListener(new a(kcVar3.Cu));
                                kc.this.Ck.start();
                                kcVar = kc.this;
                                z = false;
                            } else {
                                ValueAnimator valueAnimator3 = kc.this.Cj;
                                kc kcVar4 = kc.this;
                                valueAnimator3.addUpdateListener(new a(kcVar4.Cu));
                                kc.this.Cj.start();
                                ValueAnimator valueAnimator4 = kc.this.Ck;
                                kc kcVar5 = kc.this;
                                valueAnimator4.addUpdateListener(new a(kcVar5.Cv));
                                kc.this.Ck.start();
                                kcVar = kc.this;
                                z = true;
                            }
                            kcVar.Ct = z;
                        }
                    });
                    super.handleMessage(message);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gG() {
        ViewGroup viewGroup = this.BD;
        if (viewGroup == null || this.Cr == null) {
            return;
        }
        viewGroup.findViewById(R.id.bdar_npc_view_group).setVisibility(8);
        this.Cr.removeMessages(1001);
        this.Cr.removeCallbacksAndMessages(null);
        this.Cs = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gH() {
        ValueAnimator valueAnimator = this.Cj;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.Ck.removeAllUpdateListeners();
            this.Cj = null;
        }
        if (this.Cr != null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.Cj = ofFloat;
            ofFloat.setDuration(1000L);
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.Ck = ofFloat2;
            ofFloat2.setDuration(1000L);
            this.Ck.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.ar.kc.21
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    Message message = new Message();
                    message.what = 1001;
                    kc.this.Cr.sendMessageDelayed(message, 4000L);
                }
            });
        }
    }

    private void gJ() {
        if (this.sv == null) {
            this.sv = (SensorManager) this.mContext.getSystemService("sensor");
        }
        SensorManager sensorManager = this.sv;
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(3), 0);
    }

    private void gK() {
        SensorManager sensorManager = this.sv;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
            this.sv = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gM() {
        Handler handler = this.BF;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.baidu.ar.kc.24
                @Override // java.lang.Runnable
                public void run() {
                    kc.this.BF.removeMessages(1002);
                    kc.this.BX = false;
                    kc kcVar = kc.this;
                    kcVar.a(kcVar.BY, true);
                    kc.this.BY = false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gN() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gO() {
        if (this.BG == null) {
            RelativeLayout relativeLayout = (RelativeLayout) this.BD.findViewById(R.id.bdar_lift_up_group);
            this.BG = relativeLayout;
            relativeLayout.setBackgroundColor(Color.parseColor("#B2000000"));
        }
        if (this.BI == null) {
            this.BI = (RelativeLayout) this.BD.findViewById(R.id.bdar_top_bar);
        }
        this.BI.setVisibility(0);
        this.BG.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gP() {
        this.Cc.append("算法库加载失败 \n");
        cg(this.Cc.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gQ() {
        this.Cc.append("session 创建失败\n");
        cg(this.Cc.toString());
        RelativeLayout relativeLayout = this.BO;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        RelativeLayout relativeLayout2 = this.BG;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(8);
        }
        RelativeLayout relativeLayout3 = this.BR;
        if (relativeLayout3 != null) {
            relativeLayout3.setVisibility(8);
        }
        RelativeLayout relativeLayout4 = this.BQ;
        if (relativeLayout4 != null) {
            relativeLayout4.setVisibility(8);
        }
        RelativeLayout relativeLayout5 = this.BN;
        if (relativeLayout5 != null) {
            relativeLayout5.setVisibility(8);
        }
        if (this.BP == null) {
            this.BP = (RelativeLayout) this.BD.findViewById(R.id.bdar_net_fail_group);
        }
        gK();
        this.BF.removeCallbacksAndMessages(null);
        this.BP.findViewById(R.id.bdar_button_netfail_reset).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.ar.kc.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (kc.this.BK != null) {
                    kc.this.BK.onClick(view);
                }
                kc.this.BX = false;
                if (kc.this.BG != null) {
                    kc.this.BG.setVisibility(8);
                }
                if (kc.this.BN != null) {
                    kc.this.BN.setVisibility(8);
                }
                if (kc.this.BQ != null) {
                    kc.this.BQ.setVisibility(8);
                }
                if (kc.this.BO != null) {
                    kc.this.BO.setVisibility(8);
                }
                if (kc.this.BR != null) {
                    kc.this.BR.setVisibility(8);
                }
                if (kc.this.BP != null) {
                    kc.this.BP.setVisibility(8);
                }
                kc.this.BS = false;
                kc.this.BM = 0L;
                kc.this.gZ();
                kc.this.Cc.append("点击网络异常的重试\n");
                kc kcVar = kc.this;
                kcVar.cg(kcVar.Cc.toString());
            }
        });
        this.BP.setBackgroundColor(Color.parseColor("#B2000000"));
        this.BP.setVisibility(0);
    }

    private void gR() {
        this.Cc.append("创建定位中UI \n");
        cg(this.Cc.toString());
        RelativeLayout relativeLayout = this.BO;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        RelativeLayout relativeLayout2 = this.BG;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(8);
        }
        RelativeLayout relativeLayout3 = this.BR;
        if (relativeLayout3 != null) {
            relativeLayout3.setVisibility(8);
        }
        RelativeLayout relativeLayout4 = this.BP;
        if (relativeLayout4 != null) {
            relativeLayout4.setVisibility(8);
        }
        if (this.BQ == null) {
            this.BQ = (RelativeLayout) this.BD.findViewById(R.id.bdar_locgoing_group);
        }
        this.BQ.setVisibility(0);
        ImageView imageView = (ImageView) this.BD.findViewById(R.id.bdar_image_scan);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) kt.a(this.mContext, 340.0f), -1);
        layoutParams.setMargins(-((int) kt.a(this.mContext, 340.0f)), 0, 0, 0);
        imageView.setLayoutParams(layoutParams);
        imageView.startAnimation(AnimationUtils.loadAnimation(this.mContext, R.anim.bdar_wsdk_anim_rg_scan));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gS() {
        this.Cc.append("创建定位成功UI \n");
        cg(this.Cc.toString());
        RelativeLayout relativeLayout = this.BO;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        RelativeLayout relativeLayout2 = this.BG;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(8);
        }
        RelativeLayout relativeLayout3 = this.BN;
        if (relativeLayout3 != null) {
            relativeLayout3.setVisibility(8);
        }
        RelativeLayout relativeLayout4 = this.BQ;
        if (relativeLayout4 != null) {
            relativeLayout4.setVisibility(8);
        }
        RelativeLayout relativeLayout5 = this.BP;
        if (relativeLayout5 != null) {
            relativeLayout5.setVisibility(8);
        }
        RelativeLayout relativeLayout6 = this.BI;
        if (relativeLayout6 != null) {
            relativeLayout6.setVisibility(8);
        }
        if (this.BR == null) {
            this.BR = (RelativeLayout) this.BD.findViewById(R.id.bdar_locfinish_group);
        }
        this.BR.setVisibility(0);
        final TextView textView = (TextView) this.BD.findViewById(R.id.bdar_text_loc_finish);
        final String string = this.mContext.getResources().getString(R.string.bdar_hint_Loc_finish);
        ValueAnimator duration = ValueAnimator.ofInt(0, 3).setDuration(1000L);
        duration.setRepeatCount(-1);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.ar.kc.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                textView.setText(string + kc.this.Cw[intValue % kc.this.Cw.length]);
            }
        });
        duration.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gT() {
        RelativeLayout relativeLayout = this.BG;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        RelativeLayout relativeLayout2 = this.BN;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(8);
        }
        RelativeLayout relativeLayout3 = this.BQ;
        if (relativeLayout3 != null) {
            relativeLayout3.setVisibility(8);
        }
        RelativeLayout relativeLayout4 = this.BO;
        if (relativeLayout4 != null) {
            relativeLayout4.setVisibility(8);
        }
        RelativeLayout relativeLayout5 = this.BP;
        if (relativeLayout5 != null) {
            relativeLayout5.setVisibility(8);
        }
        RelativeLayout relativeLayout6 = this.BR;
        if (relativeLayout6 != null) {
            relativeLayout6.setVisibility(8);
        }
    }

    private void gU() {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.kc.9
            @Override // java.lang.Runnable
            public void run() {
                if (kc.this.Cf != null) {
                    kc.this.Cf.setBackground(kc.this.Cf.getContext().getDrawable(R.drawable.bdar_round_button_red));
                }
                if (kc.this.Cg != null) {
                    kc.this.Cg.setBackground(kc.this.Cg.getContext().getDrawable(R.drawable.bdar_round_button_red));
                }
                if (kc.this.Ch != null) {
                    kc.this.Ch.setBackground(kc.this.Ch.getContext().getDrawable(R.drawable.bdar_round_button_red));
                }
                if (kc.this.Ci != null) {
                    kc.this.Ci.setBackground(kc.this.Ci.getContext().getDrawable(R.drawable.bdar_round_button_red));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gZ() {
        gJ();
    }

    private String getDateToString(long j) {
        return new SimpleDateFormat(xoIox.f24709oo0xXOI0I).format(new Date(j));
    }

    private void ha() {
        RelativeLayout relativeLayout;
        if (this.BD == null || (relativeLayout = this.BQ) == null) {
            return;
        }
        relativeLayout.setVisibility(8);
    }

    private void hb() {
        Handler handler = this.BF;
        if (handler != null) {
            handler.removeMessages(1001);
            this.BF.removeMessages(1002);
            this.BF.removeMessages(1003);
        }
    }

    public void V(final int i) {
        Handler handler;
        if (this.BD == null || (handler = this.BF) == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.baidu.ar.kc.3
            @Override // java.lang.Runnable
            public void run() {
                int i2 = i;
                if (i2 == 0) {
                    kc.this.gO();
                } else if (i2 == 1) {
                    kc.this.ab(false);
                } else {
                    if (i2 != 9) {
                        return;
                    }
                    kc.this.gN();
                }
            }
        });
    }

    public void W(int i) {
        if (i > 1) {
            this.Cp = true;
        }
        this.Cc.append("********定位成功 定位结果：" + i + "个 \n");
        cg(this.Cc.toString());
        gK();
        if (this.BF != null) {
            hb();
            this.BF.post(new Runnable() { // from class: com.baidu.ar.kc.10
                @Override // java.lang.Runnable
                public void run() {
                    kc.this.BX = true;
                    kc.this.gS();
                }
            });
        }
    }

    public void Y(boolean z) {
        this.Cn = z;
    }

    public void Z(boolean z) {
        if (z) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.kc.22
                @Override // java.lang.Runnable
                public void run() {
                    if (kc.this.Cg != null) {
                        kc.this.Cg.setBackground(kc.this.Cg.getResources().getDrawable(R.drawable.bdar_round_button_greed));
                        kc.this.Cg.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                        kc.this.Cg.setText("R");
                    }
                }
            });
            Handler handler = this.BF;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.baidu.ar.kc.23
                    @Override // java.lang.Runnable
                    public void run() {
                        if (kc.this.BG != null) {
                            kc.this.BG.setVisibility(8);
                        }
                        if (kc.this.BN != null) {
                            kc.this.BN.setVisibility(8);
                        }
                        if (kc.this.BQ != null) {
                            kc.this.BQ.setVisibility(8);
                        }
                        if (kc.this.BO != null) {
                            kc.this.BO.setVisibility(8);
                        }
                        if (kc.this.BR != null) {
                            kc.this.BR.setVisibility(8);
                        }
                        kc.this.BF.removeCallbacksAndMessages(null);
                        kc.this.Cc.append("渲染路线 \n");
                        kc kcVar = kc.this;
                        kcVar.cg(kcVar.Cc.toString());
                        if (kc.this.Cg != null) {
                            kc.this.Cg.setBackground(kc.this.Cg.getResources().getDrawable(R.drawable.bdar_round_button_greed));
                            kc.this.Cg.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                            kc.this.Cg.setText("R");
                        }
                    }
                });
            }
        }
    }

    public void aa(boolean z) {
        Handler handler;
        Runnable runnable;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.dK > 100) {
            this.dK = currentTimeMillis;
            if (z) {
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.kc.25
                    @Override // java.lang.Runnable
                    public void run() {
                        if (kc.this.Ch != null) {
                            kc.this.Ch.setBackground(kc.this.Ch.getResources().getDrawable(R.drawable.bdar_round_button_greed));
                            kc.this.Ch.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                            kc.this.Ch.setText("A");
                        }
                    }
                });
                handler = this.BF;
                if (handler != null) {
                    runnable = new Runnable() { // from class: com.baidu.ar.kc.26
                        @Override // java.lang.Runnable
                        public void run() {
                            if (kc.this.Ca != null) {
                                kc.this.Ca.setText("AREngine Tracking");
                                kc.this.Ca.setTextColor(-16711936);
                            }
                        }
                    };
                    handler.post(runnable);
                }
            } else {
                gU();
                handler = this.BF;
                if (handler != null) {
                    runnable = new Runnable() { // from class: com.baidu.ar.kc.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (kc.this.Ca != null) {
                                kc.this.Ca.setText("AREngine Pause");
                                kc.this.Ca.setTextColor(SupportMenu.CATEGORY_MASK);
                            }
                        }
                    };
                    handler.post(runnable);
                }
            }
        }
        this.BW = z;
    }

    public void ac(final boolean z) {
        this.Cc.append("hideARUI \n");
        cg(this.Cc.toString());
        Handler handler = this.BF;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.baidu.ar.kc.13
                @Override // java.lang.Runnable
                public void run() {
                    kc.this.gT();
                    if (z) {
                        kc.this.Cq = 0;
                    }
                    kc.this.BX = false;
                    kc.this.BM = 0L;
                }
            });
        }
    }

    public void ad(final boolean z) {
        this.Cc.append(z ? "runAbilityResult success \n" : "runAbilityResult fail \n");
        cg(this.Cc.toString());
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.kc.18
            @Override // java.lang.Runnable
            public void run() {
                Button button;
                Resources resources;
                int i;
                if (kc.this.Ci != null) {
                    if (z) {
                        button = kc.this.Ci;
                        resources = kc.this.Ci.getResources();
                        i = R.drawable.bdar_round_button_greed;
                    } else {
                        button = kc.this.Ci;
                        resources = kc.this.Ci.getResources();
                        i = R.drawable.bdar_round_button_red;
                    }
                    button.setBackground(resources.getDrawable(i));
                }
            }
        });
    }

    public void cf(String str) {
        this.Cc.append(str + "\n");
        cg(this.Cc.toString());
    }

    public void choseFloor() {
        this.Cp = false;
    }

    public void clearRoute() {
        this.Cc.append("清除路线 \n");
        cg(this.Cc.toString());
    }

    public void gE() {
        Handler handler = this.BF;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.BF = null;
        }
        if (this.BD != null) {
            this.BD = null;
        }
        BC = null;
    }

    public void gI() {
        this.Cc.append("发帧啦~~~~~~~~\n");
        cg(this.Cc.toString());
    }

    public boolean gL() {
        return this.Co;
    }

    public void gV() {
        this.BW = true;
        this.Cm = true;
    }

    public void gW() {
        this.Cc.append("showARUI\n");
        cg(this.Cc.toString());
        Handler handler = this.BF;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.baidu.ar.kc.12
                @Override // java.lang.Runnable
                public void run() {
                    if (kc.this.BG != null) {
                        kc.this.BG.setVisibility(8);
                    }
                    if (kc.this.BN != null) {
                        kc.this.BN.setVisibility(8);
                    }
                    if (kc.this.BQ != null) {
                        kc.this.BQ.setVisibility(8);
                    }
                    if (kc.this.BO != null) {
                        kc.this.BO.setVisibility(8);
                    }
                    if (kc.this.BP != null) {
                        kc.this.BP.setVisibility(8);
                    }
                    if (kc.this.BR != null) {
                        kc.this.BR.setVisibility(8);
                    }
                    kc.this.BS = false;
                    kc.this.BM = 0L;
                    kc.this.gZ();
                    kc.this.Cq = 1;
                }
            });
        }
    }

    public boolean gX() {
        return this.Cq == 0;
    }

    public void gY() {
        this.Cp = false;
        this.Cc.append("resetUI \n");
        cg(this.Cc.toString());
        Handler handler = this.BF;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.baidu.ar.kc.14
                @Override // java.lang.Runnable
                public void run() {
                    kc.this.BX = false;
                    kc.this.gT();
                    kc.this.BS = false;
                    kc.this.BM = 0L;
                    if (kc.this.Cq == 0) {
                        return;
                    }
                    kc.this.Cc.append("resetUI:resetUIControllerState \n");
                    kc kcVar = kc.this;
                    kcVar.cg(kcVar.Cc.toString());
                    kc.this.gZ();
                }
            });
        }
    }

    public void hc() {
        this.Cd++;
        this.Cc.append("********定位成功 第：" + this.Cd + "次定位成功 \n");
        cg(this.Cc.toString());
    }

    public void hd() {
        Button button = this.Cf;
        if (button != null) {
            button.setBackground(button.getResources().getDrawable(R.drawable.bdar_round_button_greed));
            this.Cf.setText("L");
            this.Cf.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onCaseDestroy() {
        this.Cc.append("case 销毁完成 \n");
        cg(this.Cc.toString());
    }

    public void onCreateSessionFail() {
        Handler handler = this.BF;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.baidu.ar.kc.15
                @Override // java.lang.Runnable
                public void run() {
                    kc.this.gQ();
                }
            });
        }
    }

    public void onCreateVpasAlgoFail() {
        Handler handler = this.BF;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.baidu.ar.kc.16
                @Override // java.lang.Runnable
                public void run() {
                    kc.this.gP();
                }
            });
        }
    }

    public void onPause() {
        this.BY = true;
        this.BX = false;
        this.Cc.append("onPause\n");
        cg(this.Cc.toString());
        Handler handler = this.BF;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        gT();
        if (!this.Cm) {
            this.BW = false;
        }
        Handler handler2 = this.Cr;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
            this.Cr = null;
            a(false, (NavigationNpc) null);
        }
        gU();
    }

    public void onResume() {
        if (this.Cq == 0) {
            this.Cc.append("resume 拦截~~~~ \n");
            cg(this.Cc.toString());
            return;
        }
        this.Cc.append("onResume \n");
        cg(this.Cc.toString());
        gT();
        this.BS = false;
        this.BM = 0L;
        gZ();
    }

    public void onResuourceCreated() {
        this.Cc.append("case 加载完成 \n");
        cg(this.Cc.toString());
        Button button = this.Ce;
        if (button != null) {
            button.setBackground(button.getResources().getDrawable(R.drawable.bdar_round_button_greed));
            this.Ce.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            this.Ce.setText("C");
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        float f = sensorEvent.values[1];
        this.sY = Math.abs(f);
        long abs = Math.abs(this.BT - System.currentTimeMillis()) / 1000;
        if (this.BS || abs < 1) {
            return;
        }
        this.BT = System.currentTimeMillis();
        if (Math.abs(f) < this.BU) {
            this.BV = 1;
            V(0);
            return;
        }
        this.BE = true;
        this.BS = true;
        if (this.BF != null) {
            if (this.BV != 1) {
                Message message = new Message();
                message.what = 1001;
                this.BF.sendMessage(message);
            } else {
                Message message2 = new Message();
                message2.what = 1001;
                message2.obj = this.BG;
                this.BF.sendMessageDelayed(message2, 1000L);
            }
        }
    }

    public void onVpasAlgoStatePrint(int i, final int i2, final float f) {
        Handler handler;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.dK <= 100 || (handler = this.BF) == null) {
            return;
        }
        this.dK = currentTimeMillis;
        handler.post(new Runnable() { // from class: com.baidu.ar.kc.19
            @Override // java.lang.Runnable
            public void run() {
                if (kc.this.Cl != null) {
                    kc.this.Cl.setVisibility(0);
                    kc.this.Cl.setText("stepCount:" + i2 + "\r\n stepLength:" + f + "\r\n VpasLocCount:" + kc.this.Cd);
                    kc.this.Cl.setTextColor(-16711936);
                }
            }
        });
    }

    public void onVpasTrackingState(final int i) {
        Handler handler = this.BF;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.baidu.ar.kc.17
                @Override // java.lang.Runnable
                public void run() {
                    int i2;
                    if (kc.this.Cx && ((i2 = i) == -86 || i2 == -1)) {
                        kc.this.Cx = false;
                        kc.this.gM();
                    }
                    if (i == 0) {
                        kc.this.Cx = true;
                    }
                }
            });
        }
    }

    public void updateAuxiliaryLPositions(TranslationPrior translationPrior) {
        b(translationPrior);
    }

    public void b(View.OnClickListener onClickListener) {
        this.BK = onClickListener;
    }

    public void d(int i, int i2, int i3, int i4) {
        ViewGroup viewGroup = this.BD;
        if (viewGroup != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ((RelativeLayout) viewGroup.findViewById(R.id.bdar_npc_view_group)).getLayoutParams();
            layoutParams.rightMargin = i - i3;
            layoutParams.topMargin = i4;
            int i5 = (int) ((i3 - 13) * 0.17699115f);
            layoutParams.height = i5;
            layoutParams.width = i3;
            ImageView imageView = this.Cv;
            if (imageView == null || this.Cu == null) {
                return;
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams2.height = i5;
            layoutParams2.width = i5;
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.Cu.getLayoutParams();
            layoutParams3.height = i5;
            layoutParams3.width = i5;
        }
    }

    public void e(final float f) {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.kc.20
            @Override // java.lang.Runnable
            public void run() {
                if (kc.this.Cl != null) {
                    kc.this.Cl.setVisibility(0);
                    kc.this.Cl.setText(String.valueOf(f));
                }
            }
        });
    }

    @Override // com.baidu.ar.kb
    public void g(Message message) {
        if (this.BF == null || this.BX) {
            return;
        }
        switch (message.what) {
            case 1001:
                Object obj = message.obj;
                if (obj != null) {
                    ((View) obj).setVisibility(8);
                }
                gK();
                V(1);
                return;
            case 1002:
                Object obj2 = message.obj;
                if (obj2 != null) {
                    ((View) obj2).setVisibility(8);
                }
                gR();
                Message message2 = new Message();
                message2.what = 1003;
                this.BF.sendMessageDelayed(message2, ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME);
                return;
            case 1003:
                ha();
                if (!this.BW) {
                    a(false, true);
                    return;
                }
                long j = this.BM + 1;
                this.BM = j;
                if (j >= 3) {
                    a(false, false);
                    return;
                } else {
                    ab(true);
                    return;
                }
            default:
                return;
        }
    }

    public static kc a(Context context, ViewGroup viewGroup, boolean z) {
        if (BC == null) {
            BC = new kc(context, viewGroup, z);
        }
        return BC;
    }

    private void b(TranslationPrior translationPrior) {
        if (translationPrior != null) {
            this.Cc.append("lng:" + translationPrior.getCoordinate()[0] + "\n lat:" + translationPrior.getCoordinate()[1] + "\ntime:" + getDateToString(System.currentTimeMillis()) + "\n floorID:" + translationPrior.getFloorID() + "\n");
        }
        cg(this.Cc.toString());
    }

    public void a(View.OnClickListener onClickListener) {
        this.BJ = onClickListener;
    }

    public void a(ka kaVar) {
        this.BL = kaVar;
    }

    public void a(final boolean z, final NavigationNpc navigationNpc) {
        gF();
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.baidu.ar.kc.11
            @Override // java.lang.Runnable
            public void run() {
                if (kc.this.BD != null) {
                    if (!z || navigationNpc == null) {
                        kc.this.gG();
                        return;
                    }
                    kc.this.BD.findViewById(R.id.bdar_npc_view_group).setVisibility(0);
                    if (navigationNpc != null) {
                        kc kcVar = kc.this;
                        kcVar.Cu = (ImageView) kcVar.BD.findViewById(R.id.bdar_iv_npc_icon);
                        kc kcVar2 = kc.this;
                        kcVar2.Cv = (ImageView) kcVar2.BD.findViewById(R.id.bdar_iv_npc_dir);
                        TextView textView = (TextView) kc.this.BD.findViewById(R.id.bdar_npc_content);
                        ((RelativeLayout) kc.this.BD.findViewById(R.id.bdar_npc_bg)).setBackground(new BitmapDrawable(BitmapFactory.decodeFile(navigationNpc.getBGPath())));
                        kc.this.Cv.setImageBitmap(BitmapFactory.decodeFile(navigationNpc.getDirPath()));
                        kc.this.Cu.setImageBitmap(BitmapFactory.decodeFile(navigationNpc.getIconPath()));
                        if (TextUtils.isEmpty(kc.this.Cs) || (!kc.this.Cs.equals(navigationNpc.getDirPath()) && kc.this.Cr != null)) {
                            kc.this.Cs = navigationNpc.getDirPath();
                            kc.this.Cr.removeMessages(1001);
                            kc.this.Cr.removeCallbacksAndMessages(null);
                            Message message = new Message();
                            message.what = 1001;
                            kc.this.Cr.sendMessageDelayed(message, 4000L);
                        }
                        String titleTxt = navigationNpc.getTitleTxt();
                        int indexOf = titleTxt.indexOf("[");
                        int indexOf2 = titleTxt.indexOf("]") - 1;
                        if (indexOf < 0 || indexOf2 < 0) {
                            textView.setText(titleTxt);
                            return;
                        }
                        SpannableString spannableString = new SpannableString(titleTxt.replace("[", "").replace("]", ""));
                        spannableString.setSpan(new AbsoluteSizeSpan(55), indexOf, indexOf2, 33);
                        spannableString.setSpan(new kd(55), indexOf, indexOf2, 33);
                        spannableString.setSpan(new StyleSpan(0), indexOf, indexOf2, 33);
                        textView.setText(spannableString);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, boolean z2) {
        if (z || this.Cp || this.Cq == 0) {
            return;
        }
        this.Cc.append("创建定位错误弹窗 \n");
        cg(this.Cc.toString());
        Handler handler = this.BF;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        RelativeLayout relativeLayout = this.BG;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        RelativeLayout relativeLayout2 = this.BN;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(8);
        }
        RelativeLayout relativeLayout3 = this.BQ;
        if (relativeLayout3 != null) {
            relativeLayout3.setVisibility(8);
        }
        RelativeLayout relativeLayout4 = this.BR;
        if (relativeLayout4 != null) {
            relativeLayout4.setVisibility(8);
        }
        RelativeLayout relativeLayout5 = this.BP;
        if (relativeLayout5 != null) {
            relativeLayout5.setVisibility(8);
        }
        if (this.BO == null) {
            this.BO = (RelativeLayout) this.BD.findViewById(R.id.bdar_fail_group);
        }
        ((TextView) this.BD.findViewById(R.id.bdar_text_fail)).setText(z2 ? R.string.bdar_tracking_fail : R.string.bdar_location_fail);
        this.BO.setVisibility(0);
        this.BO.setBackgroundColor(Color.parseColor("#B2000000"));
        ((Button) this.BD.findViewById(R.id.bdar_button_reset)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.ar.kc.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (kc.this.BJ != null) {
                    kc.this.BJ.onClick(view);
                }
                kc.this.BX = false;
                if (kc.this.BG != null) {
                    kc.this.BG.setVisibility(8);
                }
                if (kc.this.BN != null) {
                    kc.this.BN.setVisibility(8);
                }
                if (kc.this.BQ != null) {
                    kc.this.BQ.setVisibility(8);
                }
                if (kc.this.BO != null) {
                    kc.this.BO.setVisibility(8);
                }
                if (kc.this.BR != null) {
                    kc.this.BR.setVisibility(8);
                }
                kc.this.BS = false;
                kc.this.BM = 0L;
                kc.this.gZ();
                kc.this.Cc.append("点击了重试\n");
                kc kcVar = kc.this;
                kcVar.cg(kcVar.Cc.toString());
            }
        });
    }
}
