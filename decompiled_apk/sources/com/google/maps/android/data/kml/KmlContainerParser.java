package com.google.maps.android.data.kml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes10.dex */
class KmlContainerParser {
    private static final String CONTAINER_REGEX = "Folder|Document";
    private static final String EXTENDED_DATA = "ExtendedData";
    private static final String GROUND_OVERLAY = "GroundOverlay";
    private static final String PLACEMARK = "Placemark";
    private static final String PROPERTY_REGEX = "name|description|visibility|open|address|phoneNumber";
    private static final String STYLE = "Style";
    private static final String STYLE_MAP = "StyleMap";
    private static final String UNSUPPORTED_REGEX = "altitude|altitudeModeGroup|altitudeMode|begin|bottomFov|cookie|displayName|displayMode|end|expires|extrude|flyToView|gridOrigin|httpQuery|leftFov|linkDescription|linkName|linkSnippet|listItemType|maxSnippetLines|maxSessionLength|message|minAltitude|minFadeExtent|minLodPixels|minRefreshPeriod|maxAltitude|maxFadeExtent|maxLodPixels|maxHeight|maxWidth|near|overlayXY|range|refreshMode|refreshInterval|refreshVisibility|rightFov|roll|rotationXY|screenXY|shape|sourceHref|state|targetHref|tessellate|tileSize|topFov|viewBoundScale|viewFormat|viewRefreshMode|viewRefreshTime|when";

    private static KmlContainer assignPropertiesToContainer(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String str;
        String name = xmlPullParser.getName();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        ArrayList arrayList = new ArrayList();
        HashMap hashMap4 = new HashMap();
        HashMap hashMap5 = new HashMap();
        if (xmlPullParser.getAttributeValue(null, "id") != null) {
            str = xmlPullParser.getAttributeValue(null, "id");
        } else {
            str = null;
        }
        xmlPullParser.next();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 3 && xmlPullParser.getName().equals(name)) {
                return new KmlContainer(hashMap, hashMap2, hashMap3, hashMap4, arrayList, hashMap5, str);
            }
            if (eventType == 2) {
                if (xmlPullParser.getName().matches(UNSUPPORTED_REGEX)) {
                    KmlParser.skip(xmlPullParser);
                } else if (xmlPullParser.getName().matches(CONTAINER_REGEX)) {
                    arrayList.add(assignPropertiesToContainer(xmlPullParser));
                } else if (xmlPullParser.getName().matches(PROPERTY_REGEX)) {
                    hashMap.put(xmlPullParser.getName(), xmlPullParser.nextText());
                } else if (xmlPullParser.getName().equals(STYLE_MAP)) {
                    setContainerStyleMap(xmlPullParser, hashMap4);
                } else if (xmlPullParser.getName().equals(STYLE)) {
                    setContainerStyle(xmlPullParser, hashMap2);
                } else if (xmlPullParser.getName().equals(PLACEMARK)) {
                    setContainerPlacemark(xmlPullParser, hashMap3);
                } else if (xmlPullParser.getName().equals(EXTENDED_DATA)) {
                    setExtendedDataProperties(xmlPullParser, hashMap);
                } else if (xmlPullParser.getName().equals(GROUND_OVERLAY)) {
                    hashMap5.put(KmlFeatureParser.createGroundOverlay(xmlPullParser), null);
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    public static KmlContainer createContainer(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return assignPropertiesToContainer(xmlPullParser);
    }

    private static void setContainerPlacemark(XmlPullParser xmlPullParser, HashMap<KmlPlacemark, Object> hashMap) throws XmlPullParserException, IOException {
        hashMap.put(KmlFeatureParser.createPlacemark(xmlPullParser), null);
    }

    private static void setContainerStyle(XmlPullParser xmlPullParser, HashMap<String, KmlStyle> hashMap) throws XmlPullParserException, IOException {
        if (xmlPullParser.getAttributeValue(null, "id") != null) {
            KmlStyle createStyle = KmlStyleParser.createStyle(xmlPullParser);
            hashMap.put(createStyle.getStyleId(), createStyle);
        }
    }

    private static void setContainerStyleMap(XmlPullParser xmlPullParser, HashMap<String, String> hashMap) throws XmlPullParserException, IOException {
        hashMap.putAll(KmlStyleParser.createStyleMap(xmlPullParser));
    }

    private static void setExtendedDataProperties(XmlPullParser xmlPullParser, HashMap<String, String> hashMap) throws XmlPullParserException, IOException {
        int eventType = xmlPullParser.getEventType();
        String str = null;
        while (true) {
            if (eventType == 3 && xmlPullParser.getName().equals(EXTENDED_DATA)) {
                return;
            }
            if (eventType == 2) {
                if (xmlPullParser.getName().equals("Data")) {
                    str = xmlPullParser.getAttributeValue(null, "name");
                } else if (xmlPullParser.getName().equals("value") && str != null) {
                    hashMap.put(str, xmlPullParser.nextText());
                    str = null;
                }
            }
            eventType = xmlPullParser.next();
        }
    }
}
