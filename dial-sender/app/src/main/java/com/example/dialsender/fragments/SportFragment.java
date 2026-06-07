package com.example.dialsender.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.dialsender.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Deporte tab — a functional phone-side workout tracker (stopwatch). Pick an
 * activity, start/pause/stop; sessions are timed, calories are estimated and
 * the history is persisted locally.
 */
public class SportFragment extends Fragment {

    private static final String PREF = "dial_sender_prefs";
    private static final String KEY_SESSIONS = "sport_sessions"; // "start|type|durSec|kcal,..."

    // sport key names used to look up R.string.sport_* at runtime
    private static final int[] SPORT_RES = {
            R.string.sport_walk, R.string.sport_run, R.string.sport_cycling,
            R.string.sport_hike, R.string.sport_treadmill, R.string.sport_yoga,
            R.string.sport_jump_rope, R.string.sport_basketball, R.string.sport_football,
            R.string.sport_swim, R.string.sport_row, R.string.sport_climb
    };
    private static final double[] KCAL_MIN = {
            4, 11, 8, 6, 9, 3, 12, 8, 9, 9, 7, 8
    };

    private SharedPreferences prefs;
    private final Handler handler = new Handler(Looper.getMainLooper());

    private int selectedSport = 1; // Correr
    private boolean running = false;
    private long accumulatedMs = 0;
    private long startedAt = 0;

    private TextView timerText, kcalText, btnStart;
    private LinearLayout historyContainer, chipsRow;
    private final Runnable tick = new Runnable() {
        @Override
        public void run() {
            updateTimer();
            if (running)
                handler.postDelayed(this, 250);
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        prefs = requireContext().getSharedPreferences(PREF, Context.MODE_PRIVATE);

        ScrollView scroll = new ScrollView(requireContext());
        scroll.setBackgroundColor(0xFF0E1116);
        scroll.setFillViewport(true);
        LinearLayout root = new LinearLayout(requireContext());
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(dp(20), dp(20), dp(20), dp(20));

        TextView title = new TextView(requireContext());
        title.setText(getString(R.string.nav_deporte));
        title.setTextColor(Color.WHITE);
        title.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24);
        title.setTypeface(null, Typeface.BOLD);
        title.setPadding(0, 0, 0, dp(14));
        root.addView(title);

        // Activity chips
        HorizontalScrollView hsv = new HorizontalScrollView(requireContext());
        hsv.setHorizontalScrollBarEnabled(false);
        chipsRow = new LinearLayout(requireContext());
        chipsRow.setOrientation(LinearLayout.HORIZONTAL);
        hsv.addView(chipsRow);
        root.addView(hsv);
        rebuildChips();

        // Timer card
        LinearLayout card = card();
        card.setGravity(Gravity.CENTER);
        card.setPadding(dp(20), dp(28), dp(20), dp(24));

        timerText = new TextView(requireContext());
        timerText.setText("00:00");
        timerText.setTextColor(Color.WHITE);
        timerText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 54);
        timerText.setTypeface(android.graphics.Typeface.MONOSPACE, Typeface.BOLD);
        card.addView(timerText);

        kcalText = new TextView(requireContext());
        kcalText.setText("0 kcal");
        kcalText.setTextColor(0xFFE5552E);
        kcalText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
        kcalText.setPadding(0, dp(4), 0, dp(20));
        card.addView(kcalText);

        LinearLayout btnRow = new LinearLayout(requireContext());
        btnRow.setOrientation(LinearLayout.HORIZONTAL);
        btnRow.setGravity(Gravity.CENTER);

        btnStart = pill(getString(R.string.sport_start), 0xFF22D3EE, 0xFF06121A);
        btnStart.setOnClickListener(v -> toggleStart());
        btnRow.addView(btnStart);

        TextView btnStop = pill(getString(R.string.sport_stop), 0x33FFFFFF, Color.WHITE);
        btnStop.setOnClickListener(v -> stopAndSave());
        ((LinearLayout.LayoutParams) btnStop.getLayoutParams()).setMargins(dp(12), 0, 0, 0);
        btnRow.addView(btnStop);
        card.addView(btnRow);
        root.addView(card);

        TextView histTitle = new TextView(requireContext());
        histTitle.setText(getString(R.string.sport_history));
        histTitle.setTextColor(0xFF9AA4B2);
        histTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 13);
        histTitle.setPadding(dp(4), dp(18), 0, dp(8));
        root.addView(histTitle);

        historyContainer = new LinearLayout(requireContext());
        historyContainer.setOrientation(LinearLayout.VERTICAL);
        root.addView(historyContainer);
        renderHistory();

        scroll.addView(root);
        return scroll;
    }

    private void rebuildChips() {
        chipsRow.removeAllViews();
        for (int i = 0; i < SPORT_RES.length; i++) {
            final int idx = i;
            TextView chip = new TextView(requireContext());
            chip.setText(getString(SPORT_RES[i]));
            boolean sel = i == selectedSport;
            chip.setTextColor(sel ? 0xFF06121A : 0xFFC9D1D9);
            chip.setTextSize(TypedValue.COMPLEX_UNIT_SP, 13);
            GradientDrawable bg = new GradientDrawable();
            bg.setColor(sel ? 0xFF22D3EE : 0xFF1A2027);
            bg.setCornerRadius(dp(18));
            chip.setBackground(bg);
            chip.setPadding(dp(16), dp(9), dp(16), dp(9));
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            lp.setMargins(0, 0, dp(8), 0);
            chip.setLayoutParams(lp);
            chip.setOnClickListener(v -> {
                if (running)
                    return; // don't change activity mid-session
                selectedSport = idx;
                rebuildChips();
            });
            chipsRow.addView(chip);
        }
    }

    private void toggleStart() {
        if (running) {
            // pause
            accumulatedMs += System.currentTimeMillis() - startedAt;
            running = false;
            btnStart.setText(getString(R.string.sport_resume));
            handler.removeCallbacks(tick);
        } else {
            startedAt = System.currentTimeMillis();
            running = true;
            btnStart.setText(getString(R.string.sport_pause));
            handler.post(tick);
        }
    }

    private void stopAndSave() {
        long durMs = accumulatedMs + (running ? System.currentTimeMillis() - startedAt : 0);
        running = false;
        handler.removeCallbacks(tick);
        int durSec = (int) (durMs / 1000);
        if (durSec >= 5) {
            int kcal = (int) Math.round(KCAL_MIN[selectedSport] * durSec / 60.0);
            String rec = (System.currentTimeMillis() / 1000) + "|" + getString(SPORT_RES[selectedSport]) + "|" + durSec + "|" + kcal;
            String all = prefs.getString(KEY_SESSIONS, "");
            prefs.edit().putString(KEY_SESSIONS, all.isEmpty() ? rec : rec + "," + all).apply();
            android.widget.Toast.makeText(requireContext(), getString(R.string.sport_session_saved), android.widget.Toast.LENGTH_SHORT).show();
        }
        accumulatedMs = 0;
        startedAt = 0;
        btnStart.setText(getString(R.string.sport_start));
        updateTimer();
        renderHistory();
    }

    private void updateTimer() {
        long ms = accumulatedMs + (running ? System.currentTimeMillis() - startedAt : 0);
        int s = (int) (ms / 1000);
        timerText.setText(String.format(Locale.US, "%02d:%02d", s / 60, s % 60));
        int kcal = (int) Math.round(KCAL_MIN[selectedSport] * s / 60.0);
        kcalText.setText(kcal + " kcal");
    }

    private void renderHistory() {
        historyContainer.removeAllViews();
        String all = prefs.getString(KEY_SESSIONS, "");
        if (all.isEmpty()) {
            TextView empty = new TextView(requireContext());
            empty.setText(getString(R.string.sport_no_sessions));
            empty.setTextColor(0xFF6B7280);
            empty.setTextSize(TypedValue.COMPLEX_UNIT_SP, 13);
            empty.setPadding(dp(4), dp(8), dp(4), dp(8));
            historyContainer.addView(empty);
            return;
        }
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM HH:mm", Locale.getDefault());
        for (String rec : all.split(",")) {
            String[] p = rec.split("\\|");
            if (p.length < 4)
                continue;
            android.widget.FrameLayout frameLayout = new android.widget.FrameLayout(requireContext());
            
            // 1. Delete background button
            LinearLayout deleteBg = new LinearLayout(requireContext());
            deleteBg.setOrientation(LinearLayout.HORIZONTAL);
            deleteBg.setGravity(Gravity.START | Gravity.CENTER_VERTICAL);
            GradientDrawable deleteBgDraw = new GradientDrawable();
            deleteBgDraw.setColor(0xFFEF4444); // Red
            deleteBgDraw.setCornerRadius(dp(14));
            deleteBg.setBackground(deleteBgDraw);
            deleteBg.setPadding(dp(20), 0, 0, 0);
            
            android.widget.FrameLayout.LayoutParams deleteLp = new android.widget.FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            deleteBg.setLayoutParams(deleteLp);
            
            TextView deleteText = new TextView(requireContext());
            deleteText.setText(getString(R.string.sport_delete_btn));
            deleteText.setTextColor(Color.WHITE);
            deleteText.setTypeface(null, Typeface.BOLD);
            deleteText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
            deleteBg.addView(deleteText);
            
            frameLayout.addView(deleteBg);

            // 2. Foreground content card
            LinearLayout row = card();
            row.setOrientation(LinearLayout.HORIZONTAL);
            row.setGravity(Gravity.CENTER_VERTICAL);
            row.setPadding(dp(16), dp(14), dp(16), dp(14));
            final String finalRec = rec;
            
            LinearLayout.LayoutParams rowLp = (LinearLayout.LayoutParams) row.getLayoutParams();
            if (rowLp != null) {
                rowLp.setMargins(0, 0, 0, 0); // frameLayout handles margins
            }
            
            LinearLayout.LayoutParams frameLp = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            frameLp.setMargins(0, 0, 0, dp(12));
            frameLayout.setLayoutParams(frameLp);

            final float[] downX = {0};
            final boolean[] swipedOpen = {false};
            final int swipeThreshold = dp(80);
            
            row.setOnTouchListener(new View.OnTouchListener() {
                private boolean isMoving = false;
                
                @Override
                public boolean onTouch(View v, android.view.MotionEvent event) {
                    switch (event.getAction()) {
                        case android.view.MotionEvent.ACTION_DOWN:
                            downX[0] = event.getX();
                            isMoving = false;
                            return true;
                        case android.view.MotionEvent.ACTION_MOVE:
                            float diff = event.getX() - downX[0];
                            float newX = swipedOpen[0] ? swipeThreshold + diff : diff;
                            if (newX < 0) newX = 0;
                            if (newX > swipeThreshold * 1.5f) newX = swipeThreshold * 1.5f;
                            v.setTranslationX(newX);
                            if (Math.abs(diff) > 10) {
                                isMoving = true;
                            }
                            return true;
                        case android.view.MotionEvent.ACTION_UP:
                        case android.view.MotionEvent.ACTION_CANCEL:
                            float currentX = v.getTranslationX();
                            if (currentX > swipeThreshold / 2f) {
                                v.animate().translationX(swipeThreshold).setDuration(150).start();
                                swipedOpen[0] = true;
                            } else {
                                v.animate().translationX(0).setDuration(150).start();
                                swipedOpen[0] = false;
                            }
                            
                            if (!isMoving && Math.abs(currentX - (swipedOpen[0] ? swipeThreshold : 0)) < 15) {
                                if (swipedOpen[0]) {
                                    v.animate().translationX(0).setDuration(150).start();
                                    swipedOpen[0] = false;
                                } else {
                                    android.content.Intent intent = new android.content.Intent(requireContext(), com.example.dialsender.SportDetailActivity.class);
                                    intent.putExtra("session_record", finalRec);
                                    startActivity(intent);
                                }
                            }
                            return true;
                    }
                    return false;
                }
            });

            deleteBg.setOnClickListener(v -> {
                new androidx.appcompat.app.AlertDialog.Builder(requireContext())
                    .setTitle(getString(R.string.sport_delete_title))
                    .setMessage(getString(R.string.sport_delete_msg))
                    .setPositiveButton(getString(R.string.delete), (dialog, which) -> {
                        deleteSession(finalRec);
                    })
                    .setNegativeButton(getString(R.string.cancel), (dialog, which) -> {
                        row.animate().translationX(0).setDuration(150).start();
                        swipedOpen[0] = false;
                    })
                    .show();
            });

            LinearLayout col = new LinearLayout(requireContext());
            col.setOrientation(LinearLayout.VERTICAL);
            col.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f));
            TextView name = new TextView(requireContext());
            name.setText(p[1]);
            name.setTextColor(Color.WHITE);
            name.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
            col.addView(name);
            TextView when = new TextView(requireContext());
            try {
                when.setText(fmt.format(new Date(Long.parseLong(p[0]) * 1000L)));
            } catch (Exception e) {
                when.setText("");
            }
            when.setTextColor(0xFF6B7280);
            when.setTextSize(TypedValue.COMPLEX_UNIT_SP, 11);
            col.addView(when);
            row.addView(col);
            int durSec = parseInt(p[2]);
            TextView stat = new TextView(requireContext());
            stat.setText(String.format(Locale.US, "%02d:%02d · %s kcal", durSec / 60, durSec % 60, p[3]));
            stat.setTextColor(0xFF22D3EE);
            stat.setTextSize(TypedValue.COMPLEX_UNIT_SP, 13);
            row.addView(stat);
            frameLayout.addView(row);
            historyContainer.addView(frameLayout);
        }
    }

    private int parseInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            return 0;
        }
    }

    private TextView pill(String text, int bgColor, int textColor) {
        TextView b = new TextView(requireContext());
        b.setText(text);
        b.setTextColor(textColor);
        b.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        b.setTypeface(null, Typeface.BOLD);
        b.setGravity(Gravity.CENTER);
        GradientDrawable bg = new GradientDrawable();
        bg.setColor(bgColor);
        bg.setCornerRadius(dp(26));
        b.setBackground(bg);
        b.setPadding(dp(28), dp(14), dp(28), dp(14));
        b.setClickable(true);
        b.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return b;
    }

    private LinearLayout card() {
        LinearLayout ll = new LinearLayout(requireContext());
        ll.setOrientation(LinearLayout.VERTICAL);
        GradientDrawable bg = new GradientDrawable();
        bg.setColor(0xFF1A2027);
        bg.setCornerRadius(dp(14));
        ll.setBackground(bg);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.setMargins(0, dp(12), 0, 0);
        ll.setLayoutParams(lp);
        return ll;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        handler.removeCallbacks(tick);
    }

    private void deleteSession(String record) {
        String all = prefs.getString(KEY_SESSIONS, "");
        if (!all.isEmpty()) {
            String[] sessions = all.split(",");
            StringBuilder sb = new StringBuilder();
            for (String s : sessions) {
                if (!s.equals(record)) {
                    if (sb.length() > 0)
                        sb.append(",");
                    sb.append(s);
                }
            }
            prefs.edit().putString(KEY_SESSIONS, sb.toString()).apply();
            renderHistory();
            android.widget.Toast.makeText(requireContext(), getString(R.string.sport_workout_deleted), android.widget.Toast.LENGTH_SHORT).show();
        }
    }

    private int dp(int v) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, v,
                getResources().getDisplayMetrics());
    }
}
