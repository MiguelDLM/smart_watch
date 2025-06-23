package com.google.maps.android.data.kml;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import androidx.annotation.RawRes;
import com.google.android.gms.maps.GoogleMap;
import com.google.maps.android.collections.GroundOverlayManager;
import com.google.maps.android.collections.MarkerManager;
import com.google.maps.android.collections.PolygonManager;
import com.google.maps.android.collections.PolylineManager;
import com.google.maps.android.data.Layer;
import com.google.maps.android.data.Renderer;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes10.dex */
public class KmlLayer extends Layer {
    public KmlLayer(GoogleMap googleMap, int i, Context context) throws XmlPullParserException, IOException {
        this(googleMap, context.getResources().openRawResource(i), context, new MarkerManager(googleMap), new PolygonManager(googleMap), new PolylineManager(googleMap), new GroundOverlayManager(googleMap), (Renderer.ImagesCache) null);
    }

    private static XmlPullParser createXmlParser(InputStream inputStream) throws XmlPullParserException {
        XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
        newInstance.setNamespaceAware(true);
        XmlPullParser newPullParser = newInstance.newPullParser();
        newPullParser.setInput(inputStream, null);
        return newPullParser;
    }

    private static KmlParser parseKml(InputStream inputStream) throws XmlPullParserException, IOException {
        KmlParser kmlParser = new KmlParser(createXmlParser(inputStream));
        kmlParser.parseKml();
        return kmlParser;
    }

    @Override // com.google.maps.android.data.Layer
    public void addLayerToMap() {
        super.addKMLToMap();
    }

    @Override // com.google.maps.android.data.Layer
    public Iterable<KmlContainer> getContainers() {
        return super.getContainers();
    }

    @Override // com.google.maps.android.data.Layer
    public Iterable<KmlGroundOverlay> getGroundOverlays() {
        return super.getGroundOverlays();
    }

    public Iterable<KmlPlacemark> getPlacemarks() {
        return getFeatures();
    }

    @Override // com.google.maps.android.data.Layer
    public boolean hasContainers() {
        return super.hasContainers();
    }

    public boolean hasPlacemarks() {
        return hasFeatures();
    }

    public KmlLayer(GoogleMap googleMap, InputStream inputStream, Context context) throws XmlPullParserException, IOException {
        this(googleMap, inputStream, context, new MarkerManager(googleMap), new PolygonManager(googleMap), new PolylineManager(googleMap), new GroundOverlayManager(googleMap), (Renderer.ImagesCache) null);
    }

    public KmlLayer(GoogleMap googleMap, @RawRes int i, Context context, MarkerManager markerManager, PolygonManager polygonManager, PolylineManager polylineManager, GroundOverlayManager groundOverlayManager, Renderer.ImagesCache imagesCache) throws XmlPullParserException, IOException {
        this(googleMap, context.getResources().openRawResource(i), context, markerManager, polygonManager, polylineManager, groundOverlayManager, imagesCache);
    }

    public KmlLayer(GoogleMap googleMap, InputStream inputStream, Context context, MarkerManager markerManager, PolygonManager polygonManager, PolylineManager polylineManager, GroundOverlayManager groundOverlayManager, Renderer.ImagesCache imagesCache) throws XmlPullParserException, IOException {
        if (inputStream != null) {
            KmlRenderer kmlRenderer = new KmlRenderer(googleMap, context, markerManager, polygonManager, polylineManager, groundOverlayManager, imagesCache);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedInputStream.mark(1024);
            ZipInputStream zipInputStream = new ZipInputStream(bufferedInputStream);
            try {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry != null) {
                    HashMap<String, Bitmap> hashMap = new HashMap<>();
                    KmlParser kmlParser = null;
                    while (nextEntry != null) {
                        if (kmlParser == null && nextEntry.getName().toLowerCase().endsWith(".kml")) {
                            kmlParser = parseKml(zipInputStream);
                        } else {
                            Bitmap decodeStream = BitmapFactory.decodeStream(zipInputStream);
                            if (decodeStream != null) {
                                hashMap.put(nextEntry.getName(), decodeStream);
                            } else {
                                Log.w("KmlLayer", "Unsupported KMZ contents file type: " + nextEntry.getName());
                            }
                        }
                        nextEntry = zipInputStream.getNextEntry();
                    }
                    if (kmlParser != null) {
                        kmlRenderer.storeKmzData(kmlParser.getStyles(), kmlParser.getStyleMaps(), kmlParser.getPlacemarks(), kmlParser.getContainers(), kmlParser.getGroundOverlays(), hashMap);
                    } else {
                        throw new IllegalArgumentException("KML not found in InputStream");
                    }
                } else {
                    bufferedInputStream.reset();
                    KmlParser parseKml = parseKml(bufferedInputStream);
                    kmlRenderer.storeKmlData(parseKml.getStyles(), parseKml.getStyleMaps(), parseKml.getPlacemarks(), parseKml.getContainers(), parseKml.getGroundOverlays());
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                storeRenderer(kmlRenderer);
                inputStream.close();
                bufferedInputStream.close();
                zipInputStream.close();
                return;
            } catch (Throwable th2) {
                th = th2;
                inputStream.close();
                bufferedInputStream.close();
                zipInputStream.close();
                throw th;
            }
        }
        throw new IllegalArgumentException("KML InputStream cannot be null");
    }
}
