package com.sma.smartv3.ui.ai;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.SizeUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.AIFunction;
import com.sma.smartv3.model.AIFunctionType;
import com.sma.smartv3.view.AIGridSpacingItemDecoration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.oxxXoxO;

@XX({"SMAP\nAIAnswerActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AIAnswerActivity.kt\ncom/sma/smartv3/ui/ai/AIAnswerActivity\n+ 2 TextView.kt\nandroidx/core/widget/TextViewKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,227:1\n65#2,16:228\n93#2,3:244\n1#3:247\n1855#4,2:248\n*S KotlinDebug\n*F\n+ 1 AIAnswerActivity.kt\ncom/sma/smartv3/ui/ai/AIAnswerActivity\n*L\n129#1:228,16\n129#1:244,3\n210#1:248,2\n*E\n"})
/* loaded from: classes12.dex */
public final class AIAnswerActivity extends AIAnswerBaseActivity {
    public LayoutInflater mLayoutInflater;
    private final int mAdapterSpanCount = 3;

    @OXOo.OOXIXo
    private final List<oIX0oI> mTabList = new ArrayList();

    @XX({"SMAP\nTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1\n+ 2 AIAnswerActivity.kt\ncom/sma/smartv3/ui/ai/AIAnswerActivity\n+ 3 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$1\n+ 4 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$2\n*L\n1#1,97:1\n130#2,2:98\n71#3:100\n77#4:101\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class I0Io implements TextWatcher {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ oIX0oI f21614XO;

        public I0Io(oIX0oI oix0oi) {
            this.f21614XO = oix0oi;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@OXOo.oOoXoXO Editable editable) {
            this.f21614XO.Oxx0IOOO(String.valueOf(editable));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@OXOo.oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@OXOo.oOoXoXO CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* loaded from: classes12.dex */
    public /* synthetic */ class II0xO0 {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ int[] f21615oIX0oI;

        static {
            int[] iArr = new int[AIFunctionType.values().length];
            try {
                iArr[AIFunctionType.EAT_HEALTHY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AIFunctionType.SHORT_VIDEO_SCRIPTS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AIFunctionType.DAILY_WEEKLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AIFunctionType.TRAVEL_GUIDES.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AIFunctionType.MOMENTS_COPYWRITING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AIFunctionType.APOLOGIZE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[AIFunctionType.PSYCHOLOGICAL_COUNSELOR.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[AIFunctionType.DREAM_INTERPRETATION.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[AIFunctionType.EVENT_PLANNING.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[AIFunctionType.MARKET_ANALYSIS.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[AIFunctionType.COMPLIMENT_MASTERS.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            f21615oIX0oI = iArr;
        }
    }

    /* loaded from: classes12.dex */
    public static final class oIX0oI {

        /* renamed from: II0xO0, reason: collision with root package name */
        @OXOo.OOXIXo
        public String f21616II0xO0;

        /* renamed from: oIX0oI, reason: collision with root package name */
        @OXOo.OOXIXo
        public final String f21617oIX0oI;

        /* JADX WARN: Multi-variable type inference failed */
        public oIX0oI() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ oIX0oI oxoX(oIX0oI oix0oi, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = oix0oi.f21617oIX0oI;
            }
            if ((i & 2) != 0) {
                str2 = oix0oi.f21616II0xO0;
            }
            return oix0oi.I0Io(str, str2);
        }

        @OXOo.OOXIXo
        public final oIX0oI I0Io(@OXOo.OOXIXo String describe, @OXOo.OOXIXo String text) {
            IIX0o.x0xO0oo(describe, "describe");
            IIX0o.x0xO0oo(text, "text");
            return new oIX0oI(describe, text);
        }

        @OXOo.OOXIXo
        public final String II0xO0() {
            return this.f21616II0xO0;
        }

        public final void Oxx0IOOO(@OXOo.OOXIXo String str) {
            IIX0o.x0xO0oo(str, "<set-?>");
            this.f21616II0xO0 = str;
        }

        @OXOo.OOXIXo
        public final String X0o0xo() {
            return this.f21617oIX0oI;
        }

        @OXOo.OOXIXo
        public final String XO() {
            return this.f21616II0xO0;
        }

        public boolean equals(@OXOo.oOoXoXO Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof oIX0oI)) {
                return false;
            }
            oIX0oI oix0oi = (oIX0oI) obj;
            return IIX0o.Oxx0IOOO(this.f21617oIX0oI, oix0oi.f21617oIX0oI) && IIX0o.Oxx0IOOO(this.f21616II0xO0, oix0oi.f21616II0xO0);
        }

        public int hashCode() {
            return (this.f21617oIX0oI.hashCode() * 31) + this.f21616II0xO0.hashCode();
        }

        @OXOo.OOXIXo
        public final String oIX0oI() {
            return this.f21617oIX0oI;
        }

        @OXOo.OOXIXo
        public String toString() {
            return "TabData(describe=" + this.f21617oIX0oI + ", text=" + this.f21616II0xO0 + HexStringBuilder.COMMENT_END_CHAR;
        }

        public oIX0oI(@OXOo.OOXIXo String describe, @OXOo.OOXIXo String text) {
            IIX0o.x0xO0oo(describe, "describe");
            IIX0o.x0xO0oo(text, "text");
            this.f21617oIX0oI = describe;
            this.f21616II0xO0 = text;
        }

        public /* synthetic */ oIX0oI(String str, String str2, int i, IIXOooo iIXOooo) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addEditLayout$lambda$1(EditText editText, View view) {
        editText.getText().clear();
    }

    public static /* synthetic */ void addReyclerView$default(AIAnswerActivity aIAnswerActivity, List list, int i, String str, oIX0oI oix0oi, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = aIAnswerActivity.mAdapterSpanCount;
        }
        if ((i2 & 4) != 0) {
            str = "";
        }
        aIAnswerActivity.addReyclerView(list, i, str, oix0oi);
    }

    private final String stitchTabText(String str) {
        String XO2;
        if (this.mTabList.size() > 0) {
            for (oIX0oI oix0oi : this.mTabList) {
                if (oix0oi.XO().length() > 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    if (oix0oi.X0o0xo().length() > 0) {
                        XO2 = ',' + oix0oi.X0o0xo() + ':' + oix0oi.XO();
                    } else {
                        XO2 = oix0oi.XO();
                    }
                    sb.append(XO2);
                    str = sb.toString();
                }
            }
        }
        return str;
    }

    public final void addEditLayout(@OXOo.OOXIXo oIX0oI tabData) {
        IIX0o.x0xO0oo(tabData, "tabData");
        View inflate = getMLayoutInflater().inflate(R.layout.ai_answer_edit_layout, (ViewGroup) null);
        final EditText editText = (EditText) inflate.findViewById(R.id.item_edit);
        IIX0o.ooOOo0oXI(editText);
        editText.addTextChangedListener(new I0Io(tabData));
        inflate.findViewById(R.id.item_edit_clear).setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.ui.ai.oIX0oI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AIAnswerActivity.addEditLayout$lambda$1(editText, view);
            }
        });
        IIX0o.ooOOo0oXI(inflate);
        addView(inflate);
    }

    public final void addReyclerView(@OXOo.OOXIXo List<String> list, int i, @OXOo.OOXIXo String defaultText, @OXOo.OOXIXo oIX0oI tabData) {
        IIX0o.x0xO0oo(list, "list");
        IIX0o.x0xO0oo(defaultText, "defaultText");
        IIX0o.x0xO0oo(tabData, "tabData");
        tabData.Oxx0IOOO(defaultText);
        RecyclerView recyclerView = new RecyclerView(getMContext());
        recyclerView.setLayoutManager(new GridLayoutManager(getMContext(), i));
        recyclerView.setAdapter(new AIAnswerActivity$addReyclerView$mAdapter$1(list, tabData, getMContext()));
        recyclerView.addItemDecoration(new AIGridSpacingItemDecoration(i, SizeUtils.dp2px(15.0f)));
        addView(recyclerView);
    }

    public final void addTitleDescribe(@OXOo.OOXIXo String text) {
        IIX0o.x0xO0oo(text, "text");
        View inflate = getMLayoutInflater().inflate(R.layout.ai_answer_describe, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.ai_answer_et_describe)).setText(text);
        IIX0o.ooOOo0oXI(inflate);
        addView(inflate);
    }

    public final int getMAdapterSpanCount() {
        return this.mAdapterSpanCount;
    }

    @OXOo.OOXIXo
    public final LayoutInflater getMLayoutInflater() {
        LayoutInflater layoutInflater = this.mLayoutInflater;
        if (layoutInflater != null) {
            return layoutInflater;
        }
        IIX0o.XOxIOxOx("mLayoutInflater");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.sma.smartv3.ui.ai.AIAnswerBaseActivity, com.sma.smartv3.ui.ai.BaseAIActivity, com.bestmafen.androidbase.base.oIX0oI
    public void initView() {
        AIFunctionType aIFunctionType;
        int i;
        super.initView();
        LayoutInflater from = LayoutInflater.from(getMContext());
        IIX0o.oO(from, "from(...)");
        setMLayoutInflater(from);
        this.mTabList.clear();
        AIFunction mAIFunction = getMAIFunction();
        String str = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        Object[] objArr5 = 0;
        Object[] objArr6 = 0;
        Object[] objArr7 = 0;
        Object[] objArr8 = 0;
        Object[] objArr9 = 0;
        Object[] objArr10 = 0;
        Object[] objArr11 = 0;
        Object[] objArr12 = 0;
        Object[] objArr13 = 0;
        Object[] objArr14 = 0;
        Object[] objArr15 = 0;
        Object[] objArr16 = 0;
        Object[] objArr17 = 0;
        Object[] objArr18 = 0;
        Object[] objArr19 = 0;
        Object[] objArr20 = 0;
        Object[] objArr21 = 0;
        if (mAIFunction != null) {
            aIFunctionType = mAIFunction.getType();
        } else {
            aIFunctionType = null;
        }
        if (aIFunctionType == null) {
            i = -1;
        } else {
            i = II0xO0.f21615oIX0oI[aIFunctionType.ordinal()];
        }
        int i2 = 2;
        switch (i) {
            case 1:
                String string = getString(R.string.catering_type);
                IIX0o.oO(string, "getString(...)");
                oIX0oI oix0oi = new oIX0oI(string, objArr2 == true ? 1 : 0, i2, objArr == true ? 1 : 0);
                this.mTabList.add(oix0oi);
                addTitleDescribe(oix0oi.X0o0xo());
                String[] stringArray = getResources().getStringArray(R.array.eat_healthy_list);
                IIX0o.oO(stringArray, "getStringArray(...)");
                addReyclerView$default(this, ArraysKt___ArraysKt.IoXOX(stringArray), 0, null, oix0oi, 6, null);
                return;
            case 2:
                String string2 = getString(R.string.copywriting_style);
                IIX0o.oO(string2, "getString(...)");
                oIX0oI oix0oi2 = new oIX0oI(string2, objArr6 == true ? 1 : 0, i2, objArr5 == true ? 1 : 0);
                this.mTabList.add(oix0oi2);
                addTitleDescribe(oix0oi2.X0o0xo());
                String[] stringArray2 = getResources().getStringArray(R.array.short_video_scripts_list);
                IIX0o.oO(stringArray2, "getStringArray(...)");
                addReyclerView$default(this, ArraysKt___ArraysKt.IoXOX(stringArray2), 0, null, oix0oi2, 6, null);
                String string3 = getString(R.string.time);
                IIX0o.oO(string3, "getString(...)");
                oIX0oI oix0oi3 = new oIX0oI(string3, objArr4 == true ? 1 : 0, i2, objArr3 == true ? 1 : 0);
                this.mTabList.add(oix0oi3);
                addTitleDescribe(oix0oi3.X0o0xo());
                addReyclerView$default(this, CollectionsKt__CollectionsKt.XOxIOxOx("30s", "90s", "270s"), 0, null, oix0oi3, 6, null);
                return;
            case 3:
                String string4 = getString(R.string.number_of_words);
                IIX0o.oO(string4, "getString(...)");
                oIX0oI oix0oi4 = new oIX0oI(string4, objArr10 == true ? 1 : 0, i2, objArr9 == true ? 1 : 0);
                this.mTabList.add(oix0oi4);
                addTitleDescribe(oix0oi4.X0o0xo());
                addEditLayout(oix0oi4);
                String string5 = getString(R.string.type);
                IIX0o.oO(string5, "getString(...)");
                oIX0oI oix0oi5 = new oIX0oI(string5, objArr8 == true ? 1 : 0, i2, objArr7 == true ? 1 : 0);
                this.mTabList.add(oix0oi5);
                addTitleDescribe(oix0oi5.X0o0xo());
                String[] stringArray3 = getResources().getStringArray(R.array.daily_weekly_list);
                IIX0o.oO(stringArray3, "getStringArray(...)");
                addReyclerView$default(this, ArraysKt___ArraysKt.IoXOX(stringArray3), 0, null, oix0oi5, 6, null);
                return;
            case 4:
                String string6 = getString(R.string.travel_days);
                IIX0o.oO(string6, "getString(...)");
                oIX0oI oix0oi6 = new oIX0oI(string6, objArr16 == true ? 1 : 0, i2, objArr15 == true ? 1 : 0);
                this.mTabList.add(oix0oi6);
                addTitleDescribe(oix0oi6.X0o0xo());
                addEditLayout(oix0oi6);
                String string7 = getString(R.string.tourism_budget);
                IIX0o.oO(string7, "getString(...)");
                oIX0oI oix0oi7 = new oIX0oI(string7, objArr14 == true ? 1 : 0, i2, objArr13 == true ? 1 : 0);
                this.mTabList.add(oix0oi7);
                addTitleDescribe(oix0oi7.X0o0xo());
                addEditLayout(oix0oi7);
                oIX0oI oix0oi8 = new oIX0oI("", objArr12 == true ? 1 : 0, i2, objArr11 == true ? 1 : 0);
                this.mTabList.add(oix0oi8);
                String[] stringArray4 = getResources().getStringArray(R.array.travel_guides_list);
                IIX0o.oO(stringArray4, "getStringArray(...)");
                addReyclerView$default(this, ArraysKt___ArraysKt.IoXOX(stringArray4), 2, null, oix0oi8, 4, null);
                return;
            case 5:
                String string8 = getString(R.string.type);
                IIX0o.oO(string8, "getString(...)");
                oIX0oI oix0oi9 = new oIX0oI(string8, objArr18 == true ? 1 : 0, i2, objArr17 == true ? 1 : 0);
                this.mTabList.add(oix0oi9);
                addTitleDescribe(oix0oi9.X0o0xo());
                String[] stringArray5 = getResources().getStringArray(R.array.moments_copywriting_list);
                IIX0o.oO(stringArray5, "getStringArray(...)");
                addReyclerView$default(this, ArraysKt___ArraysKt.IoXOX(stringArray5), 0, null, oix0oi9, 6, null);
                return;
            case 6:
                String string9 = getString(R.string.number_of_words);
                IIX0o.oO(string9, "getString(...)");
                oIX0oI oix0oi10 = new oIX0oI(string9, str, i2, objArr21 == true ? 1 : 0);
                this.mTabList.add(oix0oi10);
                addTitleDescribe(oix0oi10.X0o0xo());
                addEditLayout(oix0oi10);
                String string10 = getString(R.string.type);
                IIX0o.oO(string10, "getString(...)");
                oIX0oI oix0oi11 = new oIX0oI(string10, objArr20 == true ? 1 : 0, i2, objArr19 == true ? 1 : 0);
                this.mTabList.add(oix0oi11);
                addTitleDescribe(oix0oi11.X0o0xo());
                String[] stringArray6 = getResources().getStringArray(R.array.apologize_list);
                IIX0o.oO(stringArray6, "getStringArray(...)");
                List IoXOX = ArraysKt___ArraysKt.IoXOX(stringArray6);
                String string11 = getString(R.string.daily_weekly_list_1);
                IIX0o.ooOOo0oXI(string11);
                addReyclerView$default(this, IoXOX, 0, string11, oix0oi11, 2, null);
                return;
            default:
                return;
        }
    }

    @Override // com.sma.smartv3.ui.ai.AIAnswerBaseActivity
    public void inputContent(@OXOo.OOXIXo String content) {
        AIFunctionType aIFunctionType;
        IIX0o.x0xO0oo(content, "content");
        AIFunctionType aIFunctionType2 = AIFunctionType.DAILY_WEEKLY;
        AIFunction mAIFunction = getMAIFunction();
        if (mAIFunction != null) {
            aIFunctionType = mAIFunction.getType();
        } else {
            aIFunctionType = null;
        }
        if (aIFunctionType2 == aIFunctionType && (this.mTabList.size() <= 0 || ((oIX0oI) CollectionsKt___CollectionsKt.O0O0Io00X(this.mTabList)).XO().length() <= 0)) {
            dismissLoading();
            ToastUtils.showLong(getString(R.string.daily_weekly_no_selete_tip), new Object[0]);
        } else {
            super.inputContent(content);
        }
    }

    @Override // com.sma.smartv3.ui.ai.AIAnswerBaseActivity, com.bestmafen.androidbase.base.oIX0oI
    public int layoutId() {
        return R.layout.activity_ai_answer;
    }

    @Override // com.sma.smartv3.ui.ai.AIAnswerBaseActivity
    public void sendAIQuestion(@OXOo.OOXIXo String content) {
        AIFunctionType aIFunctionType;
        int i;
        String format;
        IIX0o.x0xO0oo(content, "content");
        addSendRecord(content);
        AIFunction mAIFunction = getMAIFunction();
        String str = null;
        if (mAIFunction != null) {
            aIFunctionType = mAIFunction.getType();
        } else {
            aIFunctionType = null;
        }
        if (aIFunctionType == null) {
            i = -1;
        } else {
            i = II0xO0.f21615oIX0oI[aIFunctionType.ordinal()];
        }
        switch (i) {
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                String stitchTabText = stitchTabText(content);
                oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
                AIFunction mAIFunction2 = getMAIFunction();
                if (mAIFunction2 != null) {
                    str = mAIFunction2.getDetailsQuestion();
                }
                IIX0o.ooOOo0oXI(str);
                format = String.format(str, Arrays.copyOf(new Object[]{stitchTabText}, 1));
                IIX0o.oO(format, "format(...)");
                break;
            case 6:
            default:
                StringBuilder sb = new StringBuilder();
                sb.append(getString(R.string.ai_help_me_write));
                AIFunction mAIFunction3 = getMAIFunction();
                if (mAIFunction3 != null) {
                    str = mAIFunction3.getDetailsQuestion();
                }
                sb.append(str);
                sb.append(", ");
                sb.append(getString(R.string.ai_help_me_write_describe));
                sb.append(content);
                format = stitchTabText(sb.toString());
                break;
        }
        addReceivedRecord();
        super.sendAIQuestion(format);
    }

    public final void setMLayoutInflater(@OXOo.OOXIXo LayoutInflater layoutInflater) {
        IIX0o.x0xO0oo(layoutInflater, "<set-?>");
        this.mLayoutInflater = layoutInflater;
    }
}
