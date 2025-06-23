package com.sma.smartv3.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.LogUtils;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.ui.status.MainStatusFragment;
import com.sma.smartv3.util.Xo0;
import com.sma.smartv3.util.XoI0Ixx0;
import kotlin.jvm.internal.IIX0o;
import kotlin.oXIO0o0XI;

/* loaded from: classes12.dex */
public final class GuideView {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.oOoXoXO
    public static GuideRelativeLayout f25042I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static int f25043II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final GuideView f25044oIX0oI = new GuideView();

    public static final void II0XooXoX(AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, View view, View view2, View view3, View view4, ImageView imageView, ImageView imageView2, LinearLayoutCompat linearLayoutCompat, View view5, ImageView imageView3, int i, LinearLayoutCompat linearLayoutCompat2, LinearLayoutCompat linearLayoutCompat3, TextView textView5, View view6, View view7) {
        IIX0o.x0xO0oo(view6, "$view");
        int i2 = f25043II0xO0;
        if (i2 == 1) {
            f25043II0xO0 = 2;
            appCompatImageView.setVisibility(8);
            appCompatImageView2.setVisibility(8);
            textView.setVisibility(8);
            textView2.setVisibility(8);
            textView3.setVisibility(8);
            textView4.setVisibility(8);
            textView2.setVisibility(0);
            view.setBackgroundResource(R.drawable.bg_point_gray_shape);
            view2.setBackgroundResource(R.drawable.bg_point_yellow_shape);
            view3.setBackgroundResource(R.drawable.bg_point_gray_shape);
            view4.setBackgroundResource(R.drawable.bg_point_gray_shape);
            imageView.setVisibility(4);
            imageView2.setVisibility(0);
            return;
        }
        if (i2 == 2) {
            f25043II0xO0 = 3;
            appCompatImageView.setVisibility(8);
            appCompatImageView2.setVisibility(8);
            textView.setVisibility(8);
            textView2.setVisibility(8);
            linearLayoutCompat.setVisibility(8);
            textView4.setVisibility(8);
            textView2.setVisibility(8);
            textView3.setVisibility(0);
            imageView.setVisibility(4);
            imageView2.setVisibility(4);
            view.setBackgroundResource(R.drawable.bg_point_gray_shape);
            view2.setBackgroundResource(R.drawable.bg_point_gray_shape);
            view3.setBackgroundResource(R.drawable.bg_point_yellow_shape);
            view4.setBackgroundResource(R.drawable.bg_point_gray_shape);
            view5.setBackgroundResource(R.drawable.bg_comment_dialog_shape);
            imageView3.setBackgroundResource(R.drawable.ic_binding_complete);
            if (i == 3) {
                linearLayoutCompat2.setVisibility(8);
                linearLayoutCompat3.setVisibility(8);
                return;
            } else {
                if (i != 4) {
                    return;
                }
                linearLayoutCompat2.setVisibility(8);
                return;
            }
        }
        if (i2 != 3) {
            view6.setVisibility(8);
            GuideRelativeLayout guideRelativeLayout = f25042I0Io;
            if (guideRelativeLayout == null) {
                return;
            }
            guideRelativeLayout.setIntercept(false);
            return;
        }
        f25043II0xO0 = 4;
        appCompatImageView.setVisibility(8);
        appCompatImageView2.setVisibility(8);
        textView.setVisibility(8);
        textView2.setVisibility(8);
        textView3.setVisibility(8);
        textView4.setVisibility(8);
        linearLayoutCompat.setVisibility(0);
        appCompatImageView.setVisibility(0);
        appCompatImageView2.setVisibility(0);
        textView.setVisibility(0);
        view.setBackgroundResource(R.drawable.bg_point_gray_shape);
        view2.setBackgroundResource(R.drawable.bg_point_gray_shape);
        view3.setBackgroundResource(R.drawable.bg_point_gray_shape);
        view4.setBackgroundResource(R.drawable.bg_point_yellow_shape);
        imageView.setVisibility(4);
        imageView2.setVisibility(4);
        imageView3.setBackgroundResource(R.color.bg_colors_clarity_70);
        view5.setBackgroundResource(R.color.bg_colors_clarity_70);
        imageView3.setBackgroundResource(0);
        textView5.setText(R.string.got_it);
    }

    public static final void xoIox(Oox.oIX0oI function, View view) {
        IIX0o.x0xO0oo(function, "$function");
        function.invoke();
    }

    public final int OOXIXo(float f, @OXOo.OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        int i = (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
        LogUtils.i("pxToDp==pxValue:" + f + ",dpValue:" + i);
        return i;
    }

    public final View Oxx0IOOO(Context context, MainStatusFragment mainStatusFragment, final int i) {
        View view;
        ImageView imageView;
        TextView textView;
        View view2;
        View view3;
        LinearLayoutCompat linearLayoutCompat;
        RecyclerView recyclerView;
        RecyclerView.LayoutManager layoutManager;
        int i2;
        LogUtils.i("GuideView==size:" + i);
        View XO2 = XO(context);
        final ImageView imageView2 = (ImageView) XO2.findViewById(R.id.guide_middle_view);
        final ImageView imageView3 = (ImageView) XO2.findViewById(R.id.guide_bottom_view);
        final AppCompatImageView appCompatImageView = (AppCompatImageView) XO2.findViewById(R.id.iv_binding_complete);
        final AppCompatImageView appCompatImageView2 = (AppCompatImageView) XO2.findViewById(R.id.iv_binding_complete_bottom);
        final TextView textView2 = (TextView) XO2.findViewById(R.id.tv_binding_complete_title);
        final TextView textView3 = (TextView) XO2.findViewById(R.id.tv_top_middle_title);
        final TextView textView4 = (TextView) XO2.findViewById(R.id.tv_top_hint_title);
        final TextView textView5 = (TextView) XO2.findViewById(R.id.tv_bundle_device_title);
        LinearLayoutCompat linearLayoutCompat2 = (LinearLayoutCompat) XO2.findViewById(R.id.ll_point_layout);
        final LinearLayoutCompat linearLayoutCompat3 = (LinearLayoutCompat) XO2.findViewById(R.id.ll_bottom_view_2);
        final LinearLayoutCompat linearLayoutCompat4 = (LinearLayoutCompat) XO2.findViewById(R.id.ll_bottom_view_3);
        final View findViewById = XO2.findViewById(R.id.iv_ll_bottom_view_4);
        final View findViewById2 = XO2.findViewById(R.id.point_view_1);
        View findViewById3 = XO2.findViewById(R.id.point_view_2);
        View findViewById4 = XO2.findViewById(R.id.point_view_3);
        final View findViewById5 = XO2.findViewById(R.id.point_view_4);
        ImageView imageView4 = (ImageView) XO2.findViewById(R.id.iv_close);
        final ImageView imageView5 = (ImageView) XO2.findViewById(R.id.iv_ll_bottom_4);
        TextView textView6 = (TextView) XO2.findViewById(R.id.tv_next);
        if (mainStatusFragment != null && (recyclerView = mainStatusFragment.getRecyclerView()) != null && (layoutManager = recyclerView.getLayoutManager()) != null) {
            imageView = imageView4;
            textView = textView6;
            View findViewByPosition = layoutManager.findViewByPosition(0);
            if (findViewByPosition != null) {
                int height = findViewByPosition.getHeight();
                view = XO2;
                int width = findViewByPosition.getWidth();
                linearLayoutCompat = linearLayoutCompat2;
                StringBuilder sb = new StringBuilder();
                view3 = findViewById4;
                sb.append("GuideView==height:");
                sb.append(height);
                String sb2 = sb.toString();
                view2 = findViewById3;
                i2 = 1;
                LogUtils.i(sb2);
                imageView2.getLayoutParams().height = height;
                imageView2.setImageBitmap(OxxIIOOXO.oIX0oI(findViewByPosition, width, height));
            } else {
                view = XO2;
                view2 = findViewById3;
                view3 = findViewById4;
                linearLayoutCompat = linearLayoutCompat2;
                i2 = 1;
            }
            View findViewByPosition2 = layoutManager.findViewByPosition(i2);
            if (findViewByPosition2 != null) {
                int height2 = findViewByPosition2.getHeight();
                int width2 = findViewByPosition2.getWidth();
                Object[] objArr = new Object[i2];
                objArr[0] = "GuideView==height2:" + height2;
                LogUtils.i(objArr);
                imageView3.getLayoutParams().height = height2;
                imageView3.setImageBitmap(OxxIIOOXO.oIX0oI(findViewByPosition2, width2, height2));
            }
        } else {
            view = XO2;
            imageView = imageView4;
            textView = textView6;
            view2 = findViewById3;
            view3 = findViewById4;
            linearLayoutCompat = linearLayoutCompat2;
        }
        if (f25043II0xO0 == 0) {
            f25043II0xO0 = 1;
            appCompatImageView.setVisibility(8);
            appCompatImageView2.setVisibility(8);
            textView2.setVisibility(8);
            textView3.setVisibility(8);
            textView5.setVisibility(8);
            textView4.setVisibility(0);
            imageView2.setVisibility(0);
            imageView3.setVisibility(4);
        }
        final View view4 = view2;
        final View view5 = view3;
        final LinearLayoutCompat linearLayoutCompat5 = linearLayoutCompat;
        final TextView textView7 = textView;
        final View view6 = view;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.view.OOXIXo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view7) {
                GuideView.II0XooXoX(AppCompatImageView.this, appCompatImageView2, textView2, textView3, textView5, textView4, findViewById2, view4, view5, findViewById5, imageView2, imageView3, linearLayoutCompat5, findViewById, imageView5, i, linearLayoutCompat3, linearLayoutCompat4, textView7, view6, view7);
            }
        });
        final View view7 = view;
        xxIXOIIO(imageView, new Oox.oIX0oI<oXIO0o0XI>() { // from class: com.sma.smartv3.view.GuideView$intiView$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // Oox.oIX0oI
            public /* bridge */ /* synthetic */ oXIO0o0XI invoke() {
                invoke2();
                return oXIO0o0XI.f29392oIX0oI;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                GuideRelativeLayout guideRelativeLayout;
                view7.setVisibility(8);
                guideRelativeLayout = GuideView.f25042I0Io;
                if (guideRelativeLayout == null) {
                    return;
                }
                guideRelativeLayout.setIntercept(false);
            }
        });
        return view7;
    }

    public final int X0o0xo(int i, @OXOo.OOXIXo Context context) {
        IIX0o.x0xO0oo(context, "context");
        int i2 = (int) ((i * context.getResources().getDisplayMetrics().density) + 0.5f);
        LogUtils.i("pxToDp==pxValue:" + i2 + ",dpValue:" + i);
        return i2;
    }

    public final View XO(Context context) {
        View inflate = View.inflate(context, R.layout.activity_main_guide_layout, null);
        IIX0o.ooOOo0oXI(inflate);
        return inflate;
    }

    public final void oxoX(@OXOo.OOXIXo Context context, @OXOo.oOoXoXO MainStatusFragment mainStatusFragment, int i, @OXOo.OOXIXo ViewGroup rootView, @OXOo.OOXIXo GuideRelativeLayout guideLayout) {
        IIX0o.x0xO0oo(context, "context");
        IIX0o.x0xO0oo(rootView, "rootView");
        IIX0o.x0xO0oo(guideLayout, "guideLayout");
        f25042I0Io = guideLayout;
        Xo0 xo0 = Xo0.f24349oIX0oI;
        if (xo0.oIX0oI().getBoolean(XoI0Ixx0.f24402Oxx, true)) {
            guideLayout.setIntercept(true);
            xo0.oIX0oI().put(XoI0Ixx0.f24402Oxx, false);
            rootView.addView(Oxx0IOOO(context, mainStatusFragment, i), new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public final void xxIXOIIO(ImageView imageView, final Oox.oIX0oI<oXIO0o0XI> oix0oi) {
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.sma.smartv3.view.oOoXoXO
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuideView.xoIox(Oox.oIX0oI.this, view);
                }
            });
        }
    }
}
