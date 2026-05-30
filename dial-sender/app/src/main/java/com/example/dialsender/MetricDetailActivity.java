package com.example.dialsender;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dialsender.ble.BleManager;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Full-screen detail for a single health metric, styled after Co-Fit:
 * Día/Semana/Mes tabs, a big current value with icon, a line/bar chart and a
 * máx/media/mín summary, plus share.
 */
public class MetricDetailActivity extends AppCompatActivity {

    public static final String EXTRA_METRIC = "metric";

    private static final String PREF = "dial_sender_prefs";
    private static final String P = "health_";
    private static final int DAY = 0, WEEK = 1, MONTH = 2;

    private String metric;
    private int range = DAY;
    private long selDayStart; // start-of-day for the day currently shown
    private SharedPreferences prefs;

    private LinearLayout content;   // value header + chart + stats container
    private TextView[] tabs = new TextView[3];

    // --- metric metadata ---
    private String title, unit, desc;
    private int color, iconRes;
    private boolean cumulative; // steps/calories/distance accumulate during the day
    private boolean isBp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefs = getSharedPreferences(PREF, Context.MODE_PRIVATE);
        metric = getIntent().getStringExtra(EXTRA_METRIC);
        if (metric == null)
            metric = "heart_rate";
        selDayStart = todayStart();
        configMeta();

        ScrollView scroll = new ScrollView(this);
        scroll.setBackgroundColor(0xFF0E1116);
        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);

        root.addView(buildHeader());
        root.addView(buildTabs());
        content = new LinearLayout(this);
        content.setOrientation(LinearLayout.VERTICAL);
        content.setPadding(dp(16), dp(8), dp(16), dp(24));
        root.addView(content);

        scroll.addView(root);
        setContentView(scroll);
        render();
    }

    private void configMeta() {
        switch (metric) {
            case "steps":
                title = "Pasos"; unit = ""; color = 0xFFFF9800; iconRes = R.drawable.ic_metric_steps;
                cumulative = true;
                desc = "Los pasos cuentan el movimiento detectado por el acelerómetro del reloj a lo largo "
                        + "del día. Caminar al menos 8.000–10.000 pasos diarios ayuda a mantener un corazón "
                        + "sano y a controlar el peso.";
                break;
            case "calories":
                title = "Calorías"; unit = "Kcal"; color = 0xFFE5552E; iconRes = R.drawable.ic_metric_calories;
                cumulative = true;
                desc = "Estimación de la energía gastada (calorías activas) calculada a partir de tus pasos, "
                        + "frecuencia cardíaca y datos de perfil. Es una aproximación, útil para comparar tu "
                        + "actividad día a día.";
                break;
            case "distance":
                title = "Distancia"; unit = "Km"; color = 0xFF34C759; iconRes = R.drawable.ic_metric_distance;
                cumulative = true;
                desc = "Distancia recorrida estimada a partir del número de pasos y la longitud media de tu "
                        + "zancada. Camina o corre con el reloj puesto para acumular distancia.";
                break;
            case "blood_oxygen":
                title = "Oxígeno en sangre"; unit = "%"; color = 0xFF42A5F5; iconRes = R.drawable.ic_metric_spo2;
                desc = "La saturación de oxígeno (SpO₂) indica el porcentaje de oxígeno que transportan tus "
                        + "glóbulos rojos. Un valor normal en reposo se sitúa entre 95% y 100%. Valores bajos "
                        + "de forma sostenida conviene consultarlos con un profesional.";
                break;
            case "stress":
                title = "Estrés"; unit = ""; color = 0xFF34C759; iconRes = R.drawable.ic_metric_pulse;
                desc = "El nivel de estrés se estima a partir de la variabilidad de tu frecuencia cardíaca "
                        + "(HRV). Valores altos sugieren tensión; respirar profundamente y descansar suele "
                        + "ayudar a reducirlo.";
                break;
            case "blood_pressure":
                title = "Presión arterial"; unit = "mmHg"; color = 0xFFEF5350; iconRes = R.drawable.ic_metric_pulse;
                isBp = true;
                desc = "La presión arterial se muestra como sistólica/diastólica (mmHg). Un valor de referencia "
                        + "es alrededor de 120/80. La medición del reloj es orientativa y no sustituye a un "
                        + "tensiómetro clínico.";
                break;
            default:
                title = "Frecuencia cardíaca"; unit = "Lpm"; color = 0xFFE5552E;
                iconRes = R.drawable.ic_metric_heart;
                desc = "La frecuencia cardíaca son los latidos por minuto (Lpm). En reposo, un adulto suele "
                        + "estar entre 60 y 100 Lpm. Sube con el ejercicio y baja al descansar; observar su "
                        + "tendencia ayuda a conocer tu estado físico.";
                break;
        }
    }

    // ============ Header / tabs ============

    private View buildHeader() {
        LinearLayout h = new LinearLayout(this);
        h.setOrientation(LinearLayout.HORIZONTAL);
        h.setGravity(Gravity.CENTER_VERTICAL);
        h.setPadding(dp(8), dp(14), dp(12), dp(8));

        ImageView back = new ImageView(this);
        back.setImageResource(R.drawable.ic_back);
        back.setColorFilter(Color.WHITE);
        back.setPadding(dp(12), dp(12), dp(12), dp(12));
        back.setOnClickListener(v -> finish());
        h.addView(back, new LinearLayout.LayoutParams(dp(48), dp(48)));

        TextView t = new TextView(this);
        t.setText(title);
        t.setTextColor(Color.WHITE);
        t.setTextSize(TypedValue.COMPLEX_UNIT_SP, 19);
        t.setTypeface(null, Typeface.BOLD);
        t.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f));
        h.addView(t);

        ImageView cal = new ImageView(this);
        cal.setImageResource(R.drawable.ic_calendar);
        cal.setColorFilter(Color.WHITE);
        cal.setPadding(dp(12), dp(12), dp(12), dp(12));
        cal.setOnClickListener(v -> pickDate());
        h.addView(cal, new LinearLayout.LayoutParams(dp(48), dp(48)));

        ImageView share = new ImageView(this);
        share.setImageResource(R.drawable.ic_share);
        share.setColorFilter(Color.WHITE);
        share.setPadding(dp(12), dp(12), dp(12), dp(12));
        share.setOnClickListener(v -> share());
        h.addView(share, new LinearLayout.LayoutParams(dp(48), dp(48)));
        return h;
    }

    private View buildTabs() {
        LinearLayout row = new LinearLayout(this);
        row.setOrientation(LinearLayout.HORIZONTAL);
        row.setPadding(dp(8), dp(4), dp(8), dp(4));
        String[] names = { "Día", "Semana", "Mes" };
        for (int i = 0; i < 3; i++) {
            final int idx = i;
            TextView tab = new TextView(this);
            tab.setText(names[i]);
            tab.setGravity(Gravity.CENTER);
            tab.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
            tab.setPadding(0, dp(12), 0, dp(12));
            tab.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f));
            tab.setOnClickListener(v -> {
                range = idx;
                updateTabs();
                render();
            });
            tabs[i] = tab;
            row.addView(tab);
        }
        updateTabs();
        return row;
    }

    private void updateTabs() {
        for (int i = 0; i < 3; i++) {
            boolean sel = i == range;
            tabs[i].setTextColor(sel ? 0xFF22D3EE : 0xFF8B949E);
            tabs[i].setTypeface(null, sel ? Typeface.BOLD : Typeface.NORMAL);
        }
    }

    // ============ Render ============

    private void render() {
        content.removeAllViews();

        if (range == DAY)
            content.addView(buildDayNav());

        if (isBp) {
            renderBp(selDayStart);
            content.addView(descriptionCard());
            return;
        }

        if (range == DAY) {
            List<float[]> s = seriesRange(metric, selDayStart, selDayStart + 86400);
            float latest = s.isEmpty() ? 0 : s.get(s.size() - 1)[1];
            float disp = "distance".equals(metric) ? latest / 1000f : latest;
            String when = s.isEmpty() ? "Sin datos" : new SimpleDateFormat("HH:mm", Locale.US)
                    .format(new Date((long) s.get(s.size() - 1)[0] * 1000L));
            content.addView(valueHeader(fmt(disp), when));
            if (cumulative) {
                content.addView(hourlyBarChart(s, selDayStart));
            } else {
                content.addView(lineChartDay(s, selDayStart));
                content.addView(statsRow(s));
            }
        } else {
            long todayStart = todayStart();
            int days = range == WEEK ? 7 : 30;
            long start = todayStart - (days - 1) * 86400L;
            float[][] agg = aggregateByDay(metric, start, days); // [sum/last, avg, count]
            float shown = cumulative ? agg[0][days - 1] : lastNonZeroAvg(agg, days);
            float disp = "distance".equals(metric) ? shown / 1000f : shown;
            content.addView(valueHeader(fmt(disp), range == WEEK ? "Últimos 7 días" : "Últimos 30 días"));
            content.addView(dailyBarChart(agg, days, start));
            if (!cumulative)
                content.addView(statsRowDaily(agg, days));
        }

        content.addView(descriptionCard());
    }

    /** Informational card explaining what the metric is (like Co-Fit). */
    private View descriptionCard() {
        if (desc == null || desc.isEmpty())
            return new View(this);
        LinearLayout card = new LinearLayout(this);
        card.setOrientation(LinearLayout.VERTICAL);
        GradientDrawable bg = new GradientDrawable();
        bg.setColor(0xFF1A2027);
        bg.setCornerRadius(dp(14));
        card.setBackground(bg);
        card.setPadding(dp(16), dp(16), dp(16), dp(16));
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.setMargins(0, dp(24), 0, 0);
        card.setLayoutParams(lp);

        TextView head = new TextView(this);
        head.setText("Acerca de " + title.toLowerCase(Locale.getDefault()));
        head.setTextColor(0xFF22D3EE);
        head.setTextSize(TypedValue.COMPLEX_UNIT_SP, 13);
        head.setTypeface(null, Typeface.BOLD);
        head.setPadding(0, 0, 0, dp(8));
        card.addView(head);

        TextView body = new TextView(this);
        body.setText(desc);
        body.setTextColor(0xFF9AA4B2);
        body.setTextSize(TypedValue.COMPLEX_UNIT_SP, 13);
        body.setLineSpacing(dp(3), 1f);
        card.addView(body);
        return card;
    }

    private View buildDayNav() {
        LinearLayout row = new LinearLayout(this);
        row.setOrientation(LinearLayout.HORIZONTAL);
        row.setGravity(Gravity.CENTER_VERTICAL);
        row.setPadding(dp(4), dp(8), dp(4), dp(4));

        TextView prev = navArrow("‹");
        prev.setOnClickListener(v -> {
            selDayStart -= 86400L;
            render();
        });
        row.addView(prev);

        TextView label = new TextView(this);
        boolean isToday = selDayStart == todayStart();
        label.setText(isToday ? "Hoy"
                : new SimpleDateFormat("EEE d MMM", Locale.getDefault())
                        .format(new Date(selDayStart * 1000L)));
        label.setTextColor(0xFFC9D1D9);
        label.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        label.setGravity(Gravity.CENTER);
        GradientDrawable lb = new GradientDrawable();
        lb.setColor(0xFF1A2027);
        lb.setCornerRadius(dp(20));
        label.setBackground(lb);
        label.setPadding(dp(28), dp(8), dp(28), dp(8));
        LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(0,
                ViewGroup.LayoutParams.WRAP_CONTENT, 1f);
        label.setLayoutParams(llp);
        label.setOnClickListener(v -> pickDate());
        row.addView(label);

        TextView next = navArrow("›");
        next.setEnabled(!isToday);
        next.setAlpha(isToday ? 0.3f : 1f);
        next.setOnClickListener(v -> {
            if (selDayStart < todayStart()) {
                selDayStart += 86400L;
                render();
            }
        });
        row.addView(next);
        return row;
    }

    private TextView navArrow(String s) {
        TextView t = new TextView(this);
        t.setText(s);
        t.setTextColor(0xFFC9D1D9);
        t.setTextSize(TypedValue.COMPLEX_UNIT_SP, 26);
        t.setGravity(Gravity.CENTER);
        t.setPadding(dp(16), dp(4), dp(16), dp(4));
        return t;
    }

    private void pickDate() {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(selDayStart * 1000L);
        android.app.DatePickerDialog d = new android.app.DatePickerDialog(this,
                (view, y, m, day) -> {
                    Calendar sel = Calendar.getInstance();
                    sel.set(y, m, day, 0, 0, 0);
                    sel.set(Calendar.MILLISECOND, 0);
                    selDayStart = sel.getTimeInMillis() / 1000;
                    range = DAY;
                    updateTabs();
                    render();
                }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
        d.getDatePicker().setMaxDate(System.currentTimeMillis());
        d.show();
    }

    private View valueHeader(String value, String sub) {
        LinearLayout h = new LinearLayout(this);
        h.setOrientation(LinearLayout.HORIZONTAL);
        h.setGravity(Gravity.CENTER_VERTICAL);
        h.setPadding(dp(4), dp(16), dp(4), dp(16));

        ImageView icon = new ImageView(this);
        GradientDrawable bg = new GradientDrawable();
        bg.setShape(GradientDrawable.OVAL);
        bg.setColor(color);
        icon.setBackground(bg);
        icon.setPadding(dp(9), dp(9), dp(9), dp(9));
        icon.setImageResource(iconRes);
        icon.setColorFilter(Color.WHITE);
        LinearLayout.LayoutParams il = new LinearLayout.LayoutParams(dp(44), dp(44));
        il.setMargins(0, 0, dp(16), 0);
        h.addView(icon, il);

        LinearLayout col = new LinearLayout(this);
        col.setOrientation(LinearLayout.VERTICAL);
        col.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f));
        LinearLayout vr = new LinearLayout(this);
        vr.setOrientation(LinearLayout.HORIZONTAL);
        vr.setGravity(Gravity.BOTTOM);
        TextView v = new TextView(this);
        v.setText(value);
        v.setTextColor(Color.WHITE);
        v.setTextSize(TypedValue.COMPLEX_UNIT_SP, 40);
        v.setTypeface(null, Typeface.BOLD);
        vr.addView(v);
        if (!unit.isEmpty()) {
            TextView u = new TextView(this);
            u.setText(" " + unit);
            u.setTextColor(0xFF8B949E);
            u.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
            u.setPadding(0, 0, 0, dp(8));
            vr.addView(u);
        }
        col.addView(vr);
        if (sub != null && !sub.isEmpty()) {
            TextView st = new TextView(this);
            st.setText(sub);
            st.setTextColor(0xFF6B7280);
            st.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
            col.addView(st);
        }
        h.addView(col);
        return h;
    }

    private View statsRow(List<float[]> s) {
        float max = 0, min = Float.MAX_VALUE, sum = 0;
        int n = 0;
        for (float[] e : s) {
            if (e[1] <= 0) continue;
            max = Math.max(max, e[1]);
            min = Math.min(min, e[1]);
            sum += e[1]; n++;
        }
        if (n == 0) { min = 0; }
        return threeStats((int) max, n > 0 ? (int) (sum / n) : 0, n > 0 ? (int) min : 0);
    }

    private View statsRowDaily(float[][] agg, int days) {
        float max = 0, min = Float.MAX_VALUE, sum = 0;
        int n = 0;
        for (int i = 0; i < days; i++) {
            if (agg[2][i] <= 0) continue;
            float avg = agg[1][i];
            max = Math.max(max, avg);
            min = Math.min(min, avg);
            sum += avg; n++;
        }
        if (n == 0) min = 0;
        return threeStats((int) max, n > 0 ? (int) (sum / n) : 0, n > 0 ? (int) min : 0);
    }

    private View threeStats(int max, int avg, int min) {
        LinearLayout row = new LinearLayout(this);
        row.setOrientation(LinearLayout.HORIZONTAL);
        row.setPadding(0, dp(20), 0, 0);
        row.addView(stat(title + "\nmáx.", max));
        row.addView(stat(title + "\nmedia", avg));
        row.addView(stat(title + "\nmín.", min));
        return row;
    }

    private View stat(String label, int value) {
        LinearLayout c = new LinearLayout(this);
        c.setOrientation(LinearLayout.VERTICAL);
        c.setGravity(Gravity.CENTER_HORIZONTAL);
        c.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f));
        TextView l = new TextView(this);
        l.setText(label);
        l.setTextColor(0xFF8B949E);
        l.setTextSize(TypedValue.COMPLEX_UNIT_SP, 11);
        l.setGravity(Gravity.CENTER);
        c.addView(l);
        TextView v = new TextView(this);
        v.setText(String.valueOf(value));
        v.setTextColor(Color.WHITE);
        v.setTextSize(TypedValue.COMPLEX_UNIT_SP, 28);
        v.setTypeface(null, Typeface.BOLD);
        v.setGravity(Gravity.CENTER);
        v.setPadding(0, dp(6), 0, 0);
        c.addView(v);
        if (!unit.isEmpty()) {
            TextView u = new TextView(this);
            u.setText(unit);
            u.setTextColor(0xFF6B7280);
            u.setTextSize(TypedValue.COMPLEX_UNIT_SP, 11);
            u.setGravity(Gravity.CENTER);
            c.addView(u);
        }
        return c;
    }

    // ============ Charts ============

    private LineChart lineChartDay(List<float[]> s, long dayStart) {
        LineChart chart = new LineChart(this);
        List<Entry> entries = new ArrayList<>();
        for (float[] e : s)
            entries.add(new Entry((e[0] - dayStart) / 3600f, e[1]));
        // sort by X so the line is drawn left-to-right (avoids back-connections)
        java.util.Collections.sort(entries, (a, b) -> Float.compare(a.getX(), b.getX()));
        if (entries.size() < 2 && !entries.isEmpty())
            entries.add(new Entry(entries.get(0).getX() + 0.01f, entries.get(0).getY()));
        LineDataSet ds = new LineDataSet(entries, "");
        ds.setColor(color);
        ds.setLineWidth(2f);
        ds.setDrawCircles(false);
        ds.setDrawValues(false);
        ds.setMode(LineDataSet.Mode.LINEAR);
        ds.setDrawFilled(true);
        ds.setFillColor(color);
        ds.setFillAlpha(70);
        chart.setData(new LineData(ds));
        style(chart);
        chart.getXAxis().setAxisMinimum(0f);
        chart.getXAxis().setAxisMaximum(24f);
        chart.getXAxis().setLabelCount(7, true);
        setHeight(chart, 260);
        return chart;
    }

    private BarChart hourlyBarChart(List<float[]> s, long dayStart) {
        float[] buckets = new float[24];
        for (float[] e : s) {
            int hr = (int) ((e[0] - dayStart) / 3600L);
            if (hr >= 0 && hr < 24)
                buckets[hr] = Math.max(buckets[hr], e[1]);
        }
        // cumulative metrics -> show per-hour increment
        if (cumulative) {
            float prev = 0;
            for (int i = 0; i < 24; i++) {
                float cur = buckets[i] > 0 ? buckets[i] : prev;
                float inc = Math.max(0, cur - prev);
                if (buckets[i] > 0) prev = buckets[i];
                buckets[i] = inc;
            }
        }
        List<BarEntry> entries = new ArrayList<>();
        for (int i = 0; i < 24; i++)
            entries.add(new BarEntry(i, buckets[i]));
        BarChart chart = new BarChart(this);
        BarDataSet ds = new BarDataSet(entries, "");
        ds.setColor(color);
        ds.setDrawValues(false);
        BarData bd = new BarData(ds);
        bd.setBarWidth(0.5f);
        chart.setData(bd);
        style(chart);
        chart.getXAxis().setAxisMinimum(-0.5f);
        chart.getXAxis().setAxisMaximum(23.5f);
        chart.getXAxis().setLabelCount(7, true);
        setHeight(chart, 260);
        return chart;
    }

    private BarChart dailyBarChart(float[][] agg, int days, long start) {
        List<BarEntry> entries = new ArrayList<>();
        for (int i = 0; i < days; i++)
            entries.add(new BarEntry(i, cumulative ? agg[0][i] : agg[1][i]));
        BarChart chart = new BarChart(this);
        BarDataSet ds = new BarDataSet(entries, "");
        ds.setColor(color);
        ds.setDrawValues(false);
        BarData bd = new BarData(ds);
        bd.setBarWidth(0.6f);
        chart.setData(bd);
        style(chart);
        chart.getXAxis().setAxisMinimum(-0.5f);
        chart.getXAxis().setAxisMaximum(days - 0.5f);
        // label a few days
        String[] labels = new String[days];
        SimpleDateFormat f = new SimpleDateFormat("dd/MM", Locale.getDefault());
        for (int i = 0; i < days; i++)
            labels[i] = f.format(new Date((start + i * 86400L) * 1000L));
        chart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(labels));
        chart.getXAxis().setLabelCount(Math.min(days, 6), false);
        setHeight(chart, 260);
        return chart;
    }

    private void renderBp(long todayStart) {
        // Blood pressure: show latest sys/dia + a simple list
        String h = prefs.getString(P + "blood_pressure", "");
        String latest = "—";
        String when = "";
        if (!h.isEmpty()) {
            String[] arr = h.split(",");
            for (int i = arr.length - 1; i >= 0; i--) {
                String[] p = arr[i].split(":");
                if (p.length >= 2 && p[1].contains("/")) {
                    latest = p[1];
                    try {
                        when = new SimpleDateFormat("HH:mm", Locale.US)
                                .format(new Date(Long.parseLong(p[0]) * 1000L));
                    } catch (Exception ignored) {
                    }
                    break;
                }
            }
        }
        content.addView(valueHeader(latest, when));
    }

    private void style(BarLineChartBase<?> chart) {
        chart.getDescription().setEnabled(false);
        chart.getLegend().setEnabled(false);
        chart.setTouchEnabled(false);
        XAxis x = chart.getXAxis();
        x.setPosition(XAxis.XAxisPosition.BOTTOM);
        x.setDrawGridLines(false);
        x.setTextColor(0xFF6B7280);
        x.setTextSize(9f);
        chart.getAxisLeft().setTextColor(0xFF6B7280);
        chart.getAxisLeft().setTextSize(9f);
        chart.getAxisLeft().setAxisMinimum(0f);
        chart.getAxisLeft().setGridColor(0x22FFFFFF);
        chart.getAxisRight().setEnabled(false);
        chart.animateY(500);
    }

    private void setHeight(View v, int dp) {
        v.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp(dp)));
    }

    // ============ Data ============

    private List<float[]> series(String key, long start) {
        return seriesRange(key, start, System.currentTimeMillis() / 1000 + 86400);
    }

    private List<float[]> seriesRange(String key, long start, long end) {
        List<float[]> out = new ArrayList<>();
        String h = prefs.getString(P + key, "");
        if (h.isEmpty())
            return out;
        for (String e : h.split(",")) {
            String[] p = e.split(":");
            if (p.length < 2 || p[1].contains("/"))
                continue;
            try {
                long ts = Long.parseLong(p[0]);
                float val = Float.parseFloat(p[1]);
                if (ts >= start && ts < end)
                    out.add(new float[] { ts, val });
            } catch (Exception ignored) {
            }
        }
        return out;
    }

    /** Returns [0]=max/last per day, [1]=avg per day, [2]=count per day. */
    private float[][] aggregateByDay(String key, long start, int days) {
        float[][] agg = new float[3][days];
        for (float[] e : series(key, start)) {
            int idx = (int) ((e[0] - start) / 86400L);
            if (idx < 0 || idx >= days)
                continue;
            agg[0][idx] = cumulative ? Math.max(agg[0][idx], e[1]) : agg[0][idx] + e[1];
            agg[2][idx] += 1;
        }
        for (int i = 0; i < days; i++)
            agg[1][i] = agg[2][i] > 0 ? (cumulative ? agg[0][i] : agg[0][i] / agg[2][i]) : 0;
        return agg;
    }

    private float lastNonZeroAvg(float[][] agg, int days) {
        for (int i = days - 1; i >= 0; i--)
            if (agg[2][i] > 0)
                return agg[1][i];
        return 0;
    }

    private String fmt(float v) {
        if ("distance".equals(metric))
            return String.format(Locale.US, "%.2f", v);
        return v <= 0 ? "—" : String.valueOf((int) v);
    }

    private void share() {
        String rangeName = range == DAY ? "hoy" : range == WEEK ? "esta semana" : "este mes";
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_TEXT, "Mi " + title + " (" + rangeName + ") — Dial Studio");
        startActivity(Intent.createChooser(i, "Compartir"));
    }

    private long todayStart() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTimeInMillis() / 1000;
    }

    private int dp(int v) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, v, getResources().getDisplayMetrics());
    }
}
