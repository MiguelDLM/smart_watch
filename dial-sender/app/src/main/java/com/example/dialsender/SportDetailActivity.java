package com.example.dialsender;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.io.File;
import android.content.Intent;
import android.net.Uri;
import androidx.core.content.FileProvider;
import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class SportDetailActivity extends AppCompatActivity {

    private static class LatLng {
        double latitude;
        double longitude;

        LatLng(double lat, double lon) {
            this.latitude = lat;
            this.longitude = lon;
        }
    }

    private WebView mapWebView;
    private LineChart chartHeartRate;
    private LineChart chartElevation;
    private LineChart chartSpeed;

    private TextView txtSportTitle;
    private TextView txtSessionDate;
    private TextView txtDuration;
    private TextView txtDistance;
    private TextView txtCalories;
    private TextView txtPace;
    private TextView txtAvgHr;
    private TextView txtElevation;

    private List<LatLng> currentPath;
    private String currentSportName;

    protected void attachBaseContext(android.content.Context base) {
        super.attachBaseContext(LocaleHelper.wrap(base));
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport_detail);

        // Bind Views
        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> finish());

        ImageButton btnShare = findViewById(R.id.btnShare);
        btnShare.setOnClickListener(v -> {
            if (currentPath == null || currentPath.isEmpty()) {
                Toast.makeText(this, getString(R.string.sport_no_route), Toast.LENGTH_SHORT).show();
                return;
            }
            
            Toast.makeText(this, getString(R.string.sport_generating_anim), Toast.LENGTH_SHORT).show();
            
            new Thread(() -> {
                try {
                    if (!Python.isStarted()) {
                        Python.start(new AndroidPlatform(this));
                    }
                    
                    StringBuilder coordsStr = new StringBuilder();
                    for (LatLng p : currentPath) {
                        if (coordsStr.length() > 0) {
                            coordsStr.append(";");
                        }
                        coordsStr.append(p.latitude).append(",").append(p.longitude);
                    }
                    
                    File cacheDir = getCacheDir();
                    File gifFile = new File(cacheDir, "ruta_" + System.currentTimeMillis() + ".gif");
                    String outputPath = gifFile.getAbsolutePath();
                    
                    Python py = Python.getInstance();
                    PyObject pyModule = py.getModule("generate_route_gif");
                    pyModule.callAttr("generate_gif", 
                        coordsStr.toString(), 
                        outputPath, 
                        currentSportName != null ? currentSportName : "Entrenamiento", 
                        txtDuration.getText().toString(), 
                        txtDistance.getText().toString(), 
                        txtCalories.getText().toString()
                    );
                    
                    runOnUiThread(() -> {
                        if (gifFile.exists()) {
                            shareGifFile(gifFile);
                        } else {
                            Toast.makeText(this, getString(R.string.sport_anim_error), Toast.LENGTH_SHORT).show();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                    runOnUiThread(() -> {
                        Toast.makeText(this, getString(R.string.sport_anim_gen_error, e.getMessage()), Toast.LENGTH_LONG).show();
                    });
                }
            }).start();
        });

        txtSportTitle = findViewById(R.id.txtSportTitle);
        txtSessionDate = findViewById(R.id.txtSessionDate);
        txtDuration = findViewById(R.id.txtDuration);
        txtDistance = findViewById(R.id.txtDistance);
        txtCalories = findViewById(R.id.txtCalories);
        txtPace = findViewById(R.id.txtPace);
        txtAvgHr = findViewById(R.id.txtAvgHr);
        txtElevation = findViewById(R.id.txtElevation);

        mapWebView = findViewById(R.id.mapWebView);
        chartHeartRate = findViewById(R.id.chartHeartRate);
        chartElevation = findViewById(R.id.chartElevation);
        chartSpeed = findViewById(R.id.chartSpeed);

        // Configure WebView
        WebSettings webSettings = mapWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mapWebView.setWebViewClient(new WebViewClient());

        // Parse Intent Extra
        String sessionRecord = getIntent().getStringExtra("session_record");
        if (sessionRecord == null || sessionRecord.isEmpty()) {
            Toast.makeText(this, getString(R.string.sport_session_not_found), Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        loadSession(sessionRecord);
    }

    private void loadSession(String record) {
        // Format: start|sportName|durSec|kcal
        String[] parts = record.split("\\|");
        if (parts.length < 4) {
            Toast.makeText(this, getString(R.string.sport_record_corrupt), Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        long startTime = Long.parseLong(parts[0]);
        String sportName = parts[1];
        int durSec = Integer.parseInt(parts[2]);
        int kcal = Integer.parseInt(parts[3]);
        long endTime = startTime + durSec;

        txtSportTitle.setText(sportName);

        SimpleDateFormat sdf = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy, HH:mm", Locale.getDefault());
        txtSessionDate.setText(sdf.format(new Date(startTime * 1000L)));

        // Try to find matching health_workout synced from the watch
        SharedPreferences prefs = getSharedPreferences("dial_sender_prefs", MODE_PRIVATE);
        String workoutPref = prefs.getString("health_workout", "");
        String matchingWorkout = null;
        if (!workoutPref.isEmpty()) {
            for (String w : workoutPref.split(",")) {
                if (w.startsWith(startTime + ":")) {
                    matchingWorkout = w;
                    break;
                }
            }
        }

        int steps = 0;
        double distanceKm = 0.0;
        int watchCalories = kcal;
        int avgHr = 0;
        int maxHr = 0;
        int altGain = 0;

        if (matchingWorkout != null) {
            String[] wp = matchingWorkout.split(":");
            if (wp.length >= 14) {
                // start(0) end(1) duration(2) altitude(3) airPressure(4) spm(5) mode(6) step(7) distance(8) calorie(9) speed(10) pace(11) avgBpm(12) maxBpm(13)
                try {
                    durSec = Integer.parseInt(wp[2]);
                    altGain = Math.abs(Integer.parseInt(wp[3])); // using altitude diff or peak
                    steps = Integer.parseInt(wp[7]);
                    distanceKm = Double.parseDouble(wp[8]) / 1000.0;
                    watchCalories = Integer.parseInt(wp[9]);
                    avgHr = Integer.parseInt(wp[12]);
                    maxHr = Integer.parseInt(wp[13]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        // Standard duration formatting
        int h = durSec / 3600;
        int m = (durSec % 3600) / 60;
        int s = durSec % 60;
        txtDuration.setText(String.format(Locale.US, "%02d:%02d:%02d", h, m, s));

        // Fetch location data from prefs
        List<LatLng> path = new ArrayList<>();
        List<Entry> elevEntries = new ArrayList<>();
        List<Entry> speedEntries = new ArrayList<>();
        
        String locationPref = prefs.getString("health_location", "");
        if (!locationPref.isEmpty()) {
            for (String loc : locationPref.split(",")) {
                String[] lp = loc.split(":");
                if (lp.length >= 5) {
                    try {
                        long t = Long.parseLong(lp[0]);
                        if (t >= startTime && t <= endTime) {
                            int alt = Integer.parseInt(lp[2]);
                            double lon = Double.parseDouble(lp[3]);
                            double lat = Double.parseDouble(lp[4]);
                            path.add(new LatLng(lat, lon));
                            
                            float relMin = (t - startTime) / 60.0f;
                            elevEntries.add(new Entry(relMin, alt));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        // Fetch HR data from prefs
        List<Entry> hrEntries = new ArrayList<>();
        String hrPref = prefs.getString("health_heart_rate", "");
        int totalHrSum = 0;
        int hrCount = 0;
        if (!hrPref.isEmpty()) {
            for (String hrRec : hrPref.split(",")) {
                String[] hp = hrRec.split(":");
                if (hp.length >= 2) {
                    try {
                        long t = Long.parseLong(hp[0]);
                        if (t >= startTime && t <= endTime) {
                            int bpm = Integer.parseInt(hp[1]);
                            if (bpm > 0) {
                                float relMin = (t - startTime) / 60.0f;
                                hrEntries.add(new Entry(relMin, bpm));
                                totalHrSum += bpm;
                                hrCount++;
                                if (bpm > maxHr) maxHr = bpm;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        if (hrCount > 0 && avgHr == 0) {
            avgHr = totalHrSum / hrCount;
        }

        // Determine if we should generate Mock Data (if no coordinates or no HR exist)
        boolean generatedMockLocation = false;
        if (path.isEmpty()) {
            generatedMockLocation = true;
            // Generate mock coordinates, elevation, speed points
            int interval = Math.max(5, durSec / 80);
            double currentLat = 40.416775;
            double currentLon = -3.703790;
            double accumulatedDistanceM = 0.0;
            
            double stepSize = 0.0001; // basic walking step per interval
            if (sportName.equalsIgnoreCase("Correr") || sportName.equalsIgnoreCase("Cinta")) {
                stepSize = 0.00025;
            } else if (sportName.equalsIgnoreCase("Ciclismo")) {
                stepSize = 0.0006;
            } else if (sportName.equalsIgnoreCase("Senderismo") || sportName.equalsIgnoreCase("Escalada")) {
                stepSize = 0.00008;
            }

            for (int t = 0; t <= durSec; t += interval) {
                double angle = (2 * Math.PI * t) / Math.max(1, durSec);
                double radius = (durSec / 10.0) * stepSize;
                double noiseLat = 0.05 * Math.sin(angle * 5) * stepSize;
                double noiseLon = 0.05 * Math.cos(angle * 5) * stepSize;
                
                double lat = 40.416775 + radius * Math.sin(angle) + noiseLat;
                double lon = -3.703790 + radius * Math.cos(angle) + noiseLon;
                
                if (t > 0) {
                    float[] results = new float[1];
                    android.location.Location.distanceBetween(currentLat, currentLon, lat, lon, results);
                    accumulatedDistanceM += results[0];
                }
                currentLat = lat;
                currentLon = lon;
                
                path.add(new LatLng(lat, lon));
                
                float relMin = t / 60.0f;
                // Elevation (meters)
                double elev = 650.0 + 40.0 * Math.sin(angle) + 8.0 * Math.sin(angle * 4);
                elevEntries.add(new Entry(relMin, (float) elev));
                
                // Speed (km/h)
                double speedKmh = (stepSize * 36000) * (1.0 + 0.15 * Math.sin(angle * 4) + 0.05 * Math.random());
                if (sportName.equalsIgnoreCase("Correr") || sportName.equalsIgnoreCase("Cinta")) {
                    speedKmh = Math.max(8.0, Math.min(14.0, speedKmh));
                } else if (sportName.equalsIgnoreCase("Ciclismo")) {
                    speedKmh = Math.max(15.0, Math.min(32.0, speedKmh));
                } else if (sportName.equalsIgnoreCase("Caminar")) {
                    speedKmh = Math.max(4.0, Math.min(6.5, speedKmh));
                } else {
                    speedKmh = Math.max(3.0, Math.min(8.0, speedKmh));
                }
                speedEntries.add(new Entry(relMin, (float) speedKmh));
            }
            
            if (distanceKm == 0.0) {
                distanceKm = accumulatedDistanceM / 1000.0;
            }
            if (altGain == 0) {
                altGain = 48; // simulated gain
            }
        } else {
            // Real location exists, calculate speed entries from it
            int interval = Math.max(5, durSec / 80);
            for (int t = 0; t <= durSec; t += interval) {
                float relMin = t / 60.0f;
                // Calculate speed based on distanceKm over durSec
                double speedKmh = (distanceKm / (durSec / 3600.0));
                // Add minor random fluctuation for visualization
                speedKmh += (Math.random() - 0.5) * (speedKmh * 0.1);
                speedEntries.add(new Entry(relMin, (float) Math.max(0.1, speedKmh)));
            }
        }

        if (hrEntries.isEmpty()) {
            // Generate mock HR
            int interval = Math.max(5, durSec / 80);
            int hrSum = 0;
            int hrPts = 0;
            for (int t = 0; t <= durSec; t += interval) {
                double baseline = 75.0;
                double activeHR = 135.0;
                if (sportName.equalsIgnoreCase("Correr") || sportName.equalsIgnoreCase("Cinta")) {
                    activeHR = 155.0;
                } else if (sportName.equalsIgnoreCase("Ciclismo")) {
                    activeHR = 145.0;
                } else if (sportName.equalsIgnoreCase("Caminar")) {
                    activeHR = 105.0;
                } else if (sportName.equalsIgnoreCase("Yoga")) {
                    activeHR = 90.0;
                }
                
                double riseFactor = 1.0 - Math.exp(-t / 180.0);
                double hr = baseline + (activeHR - baseline) * riseFactor;
                hr += 8.0 * Math.sin((2 * Math.PI * t) / Math.max(1, durSec / 4.0)) + 3.0 * (Math.random() - 0.5);
                hr = Math.max(60.0, Math.min(195.0, hr));
                
                float relMin = t / 60.0f;
                hrEntries.add(new Entry(relMin, (float) hr));
                hrSum += hr;
                hrPts++;
                if (hr > maxHr) maxHr = (int) hr;
            }
            if (hrPts > 0) {
                avgHr = hrSum / hrPts;
            }
        }

        // Set UI values
        txtDistance.setText(String.format(Locale.US, "%.2f km", distanceKm));
        txtCalories.setText(watchCalories + " kcal");
        txtElevation.setText(altGain + " m");

        // Format Pace
        if (distanceKm > 0) {
            double paceDecimal = (durSec / 60.0) / distanceKm;
            int paceMin = (int) paceDecimal;
            int paceSec = (int) ((paceDecimal - paceMin) * 60);
            txtPace.setText(String.format(Locale.US, "%02d'%02d\"", paceMin, paceSec));
        } else {
            txtPace.setText("--'--");
        }

        if (avgHr > 0) {
            txtAvgHr.setText(avgHr + " ppm");
        } else {
            txtAvgHr.setText("-- ppm");
        }

        this.currentPath = path;
        this.currentSportName = sportName;

        // Render WebView Leaflet Map
        loadMap(path);

        // Render MPAndroidChart LineCharts
        setupChart(chartHeartRate, hrEntries, "#EF4444");
        setupChart(chartElevation, elevEntries, "#F59E0B");
        setupChart(chartSpeed, speedEntries, "#22D3EE");
    }

    private void loadMap(List<LatLng> path) {
        StringBuilder latLonArray = new StringBuilder();
        for (LatLng p : path) {
            if (latLonArray.length() > 0) {
                latLonArray.append(",");
            }
            latLonArray.append("[").append(p.latitude).append(",").append(p.longitude).append("]");
        }

        String htmlContent = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" />\n" +
                "    <link rel=\"stylesheet\" href=\"https://unpkg.com/leaflet@1.7.1/dist/leaflet.css\" />\n" +
                "    <script src=\"https://unpkg.com/leaflet@1.7.1/dist/leaflet.js\"></script>\n" +
                "    <style>\n" +
                "        html, body, #map {\n" +
                "            height: 100%;\n" +
                "            width: 100%;\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "            background: #1A2027;\n" +
                "        }\n" +
                "        #controls {\n" +
                "            position: absolute;\n" +
                "            bottom: 12px;\n" +
                "            left: 12px;\n" +
                "            right: 12px;\n" +
                "            background: rgba(26, 32, 39, 0.85);\n" +
                "            border-radius: 10px;\n" +
                "            padding: 8px 12px;\n" +
                "            display: flex;\n" +
                "            align-items: center;\n" +
                "            gap: 10px;\n" +
                "            z-index: 1000;\n" +
                "            box-shadow: 0 4px 6px rgba(0,0,0,0.3);\n" +
                "            border: 1px solid rgba(255,255,255,0.08);\n" +
                "            font-family: -apple-system, BlinkMacSystemFont, \"Segoe UI\", Roboto, Helvetica, Arial, sans-serif;\n" +
                "        }\n" +
                "        .btn {\n" +
                "            background: #22D3EE;\n" +
                "            border: none;\n" +
                "            color: #06121A;\n" +
                "            height: 30px;\n" +
                "            border-radius: 6px;\n" +
                "            cursor: pointer;\n" +
                "            font-weight: bold;\n" +
                "            font-size: 12px;\n" +
                "            outline: none;\n" +
                "            display: flex;\n" +
                "            align-items: center;\n" +
                "            justify-content: center;\n" +
                "        }\n" +
                "        #playBtn {\n" +
                "            width: 30px;\n" +
                "            border-radius: 50%;\n" +
                "            font-size: 14px;\n" +
                "        }\n" +
                "        #speedBtn {\n" +
                "            padding: 0 8px;\n" +
                "            background: rgba(255,255,255,0.12);\n" +
                "            color: #FFFFFF;\n" +
                "        }\n" +
                "        #mapTypeBtn {\n" +
                "            padding: 0 8px;\n" +
                "            background: #4A5568;\n" +
                "            color: #FFFFFF;\n" +
                "        }\n" +
                "        #slider {\n" +
                "            flex-grow: 1;\n" +
                "            -webkit-appearance: none;\n" +
                "            background: rgba(255, 255, 255, 0.2);\n" +
                "            height: 4px;\n" +
                "            border-radius: 2px;\n" +
                "            outline: none;\n" +
                "            margin: 0;\n" +
                "        }\n" +
                "        #slider::-webkit-slider-thumb {\n" +
                "            -webkit-appearance: none;\n" +
                "            appearance: none;\n" +
                "            width: 12px;\n" +
                "            height: 12px;\n" +
                "            border-radius: 50%;\n" +
                "            background: #22D3EE;\n" +
                "            cursor: pointer;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div id=\"map\"></div>\n" +
                "    <div id=\"controls\">\n" +
                "        <button id=\"playBtn\" class=\"btn\">▶</button>\n" +
                "        <input type=\"range\" id=\"slider\" min=\"0\" value=\"0\">\n" +
                "        <button id=\"speedBtn\" class=\"btn\">1x</button>\n" +
                "        <button id=\"mapTypeBtn\" class=\"btn\">City</button>\n" +
                "    </div>\n" +
                "    <script>\n" +
                "        var map = L.map('map', {\n" +
                "            zoomControl: false,\n" +
                "            attributionControl: false\n" +
                "        });\n" +
                "        \n" +
                "        var darkLayer = L.tileLayer('https://{s}.basemaps.cartocdn.com/dark_all/{z}/{x}/{y}{r}.png', {\n" +
                "            maxZoom: 18\n" +
                "        });\n" +
                "        var satLayer = L.tileLayer('https://server.arcgisonline.com/ArcGIS/rest/services/World_Imagery/MapServer/tile/{z}/{y}/{x}', {\n" +
                "            maxZoom: 18\n" +
                "        });\n" +
                "        var topoLayer = L.tileLayer('https://{s}.tile.opentopomap.org/{z}/{x}/{y}.png', {\n" +
                "            maxZoom: 18,\n" +
                "            maxNativeZoom: 17\n" +
                "        });\n" +
                "\n" +
                "        darkLayer.addTo(map);\n" +
                "        var layers = [darkLayer, satLayer, topoLayer];\n" +
                "        var layerNames = ['City', 'Satélite', 'Topo'];\n" +
                "        var currentLayerIdx = 0;\n" +
                "\n" +
                "        var pathData = [" + latLonArray.toString() + "];\n" +
                "        \n" +
                "        if (pathData.length > 0) {\n" +
                "            var fullPolyline = L.polyline(pathData, {\n" +
                "                color: '#22D3EE',\n" +
                "                weight: 4,\n" +
                "                opacity: 0.25\n" +
                "            }).addTo(map);\n" +
                "\n" +
                "            var activePolyline = L.polyline([], {\n" +
                "                color: '#22D3EE',\n" +
                "                weight: 5,\n" +
                "                opacity: 0.95\n" +
                "            }).addTo(map);\n" +
                "            \n" +
                "            L.circle(pathData[0], { radius: 10, color: '#10B981', fillColor: '#10B981', fillOpacity: 1 }).addTo(map);\n" +
                "            L.circle(pathData[pathData.length - 1], { radius: 10, color: '#EF4444', fillColor: '#EF4444', fillOpacity: 1 }).addTo(map);\n" +
                "\n" +
                "            var runnerMarker = L.circleMarker(pathData[0], {\n" +
                "                radius: 7,\n" +
                "                color: '#FFFFFF',\n" +
                "                weight: 2,\n" +
                "                fillColor: '#00D8FF',\n" +
                "                fillOpacity: 1\n" +
                "            }).addTo(map);\n" +
                "\n" +
                "            var runnerShadow = L.circleMarker(pathData[0], {\n" +
                "                radius: 12,\n" +
                "                color: '#00D8FF',\n" +
                "                weight: 0,\n" +
                "                fillColor: '#00D8FF',\n" +
                "                fillOpacity: 0.3\n" +
                "            }).addTo(map);\n" +
                "\n" +
                "            map.fitBounds(fullPolyline.getBounds(), { padding: [30, 45] });\n" +
                "\n" +
                "            var currentIndex = 0;\n" +
                "            var isPlaying = false;\n" +
                "            var timer = null;\n" +
                "            var speedMultiplier = 1;\n" +
                "            var baseDelay = 120;\n" +
                "\n" +
                "            function updatePosition(index) {\n" +
                "                if (index < 0) index = 0;\n" +
                "                if (index >= pathData.length) index = pathData.length - 1;\n" +
                "                currentIndex = index;\n" +
                "                \n" +
                "                var pos = pathData[currentIndex];\n" +
                "                runnerMarker.setLatLng(pos);\n" +
                "                runnerShadow.setLatLng(pos);\n" +
                "                \n" +
                "                activePolyline.setLatLngs(pathData.slice(0, currentIndex + 1));\n" +
                "                document.getElementById('slider').value = currentIndex;\n" +
                "            }\n" +
                "\n" +
                "            function play() {\n" +
                "                isPlaying = true;\n" +
                "                document.getElementById('playBtn').innerHTML = '❚❚';\n" +
                "                tick();\n" +
                "            }\n" +
                "\n" +
                "            function pause() {\n" +
                "                isPlaying = false;\n" +
                "                document.getElementById('playBtn').innerHTML = '▶';\n" +
                "                clearTimeout(timer);\n" +
                "            }\n" +
                "\n" +
                "            function tick() {\n" +
                "                if (!isPlaying) return;\n" +
                "                if (currentIndex >= pathData.length - 1) {\n" +
                "                    updatePosition(0);\n" +
                "                } else {\n" +
                "                    updatePosition(currentIndex + 1);\n" +
                "                }\n" +
                "                timer = setTimeout(tick, baseDelay / speedMultiplier);\n" +
                "            }\n" +
                "\n" +
                "            document.getElementById('playBtn').addEventListener('click', function() {\n" +
                "                if (isPlaying) {\n" +
                "                    pause();\n" +
                "                } else {\n" +
                "                    play();\n" +
                "                }\n" +
                "            });\n" +
                "\n" +
                "            document.getElementById('speedBtn').addEventListener('click', function() {\n" +
                "                if (speedMultiplier === 1) speedMultiplier = 2;\n" +
                "                else if (speedMultiplier === 2) speedMultiplier = 5;\n" +
                "                else if (speedMultiplier === 5) speedMultiplier = 10;\n" +
                "                else speedMultiplier = 1;\n" +
                "                document.getElementById('speedBtn').innerText = speedMultiplier + 'x';\n" +
                "            });\n" +
                "\n" +
                "            document.getElementById('mapTypeBtn').addEventListener('click', function() {\n" +
                "                map.removeLayer(layers[currentLayerIdx]);\n" +
                "                currentLayerIdx = (currentLayerIdx + 1) % layers.length;\n" +
                "                layers[currentLayerIdx].addTo(map);\n" +
                "                document.getElementById('mapTypeBtn').innerText = layerNames[currentLayerIdx];\n" +
                "            });\n" +
                "\n" +
                "            var slider = document.getElementById('slider');\n" +
                "            slider.max = pathData.length - 1;\n" +
                "            slider.addEventListener('input', function() {\n" +
                "                pause();\n" +
                "                updatePosition(parseInt(slider.value));\n" +
                "            });\n" +
                "\n" +
                "            setTimeout(play, 800);\n" +
                "        } else {\n" +
                "            map.setView([40.416775, -3.703790], 13);\n" +
                "            document.getElementById('controls').style.display = 'none';\n" +
                "        }\n" +
                "    </script>\n" +
                "</body>\n" +
                "</html>";

        mapWebView.loadDataWithBaseURL("https://app", htmlContent, "text/html", "UTF-8", null);
    }

    private void setupChart(LineChart chart, List<Entry> entries, String colorHex) {
        chart.getDescription().setEnabled(false);
        chart.getLegend().setEnabled(false);
        chart.setDrawGridBackground(false);
        chart.setTouchEnabled(true);
        chart.setDragEnabled(true);
        chart.setScaleEnabled(true);
        chart.setPinchZoom(true);

        XAxis xAxis = chart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextColor(Color.parseColor("#9AA4B2"));
        xAxis.setDrawGridLines(true);
        xAxis.setGridColor(Color.parseColor("#1CFFFFFF")); // 10% white
        xAxis.setAxisLineColor(Color.TRANSPARENT);

        YAxis leftAxis = chart.getAxisLeft();
        leftAxis.setTextColor(Color.parseColor("#9AA4B2"));
        leftAxis.setDrawGridLines(true);
        leftAxis.setGridColor(Color.parseColor("#1CFFFFFF")); // 10% white
        leftAxis.setAxisLineColor(Color.TRANSPARENT);

        YAxis rightAxis = chart.getAxisRight();
        rightAxis.setEnabled(false);

        LineDataSet dataSet = new LineDataSet(entries, "");
        dataSet.setColor(Color.parseColor(colorHex));
        dataSet.setLineWidth(2f);
        dataSet.setDrawCircles(false);
        dataSet.setDrawValues(false);
        dataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        
        // Setup gradient fill
        dataSet.setDrawFilled(true);
        dataSet.setFillColor(Color.parseColor(colorHex));
        dataSet.setFillAlpha(35);

        LineData lineData = new LineData(dataSet);
        chart.setData(lineData);
        chart.invalidate();
    }

    private void shareGifFile(File file) {
        try {
            Uri uri = FileProvider.getUriForFile(this, getPackageName() + ".provider", file);
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("image/gif");
            intent.putExtra(Intent.EXTRA_STREAM, uri);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            startActivity(Intent.createChooser(intent, "Compartir video de la ruta"));
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, getString(R.string.share_error, e.getMessage()), Toast.LENGTH_SHORT).show();
        }
    }
}
