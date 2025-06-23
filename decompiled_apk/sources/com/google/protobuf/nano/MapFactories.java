package com.google.protobuf.nano;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes10.dex */
public final class MapFactories {
    private static volatile MapFactory mapFactory = new DefaultMapFactory();

    /* loaded from: classes10.dex */
    public static class DefaultMapFactory implements MapFactory {
        private DefaultMapFactory() {
        }

        @Override // com.google.protobuf.nano.MapFactories.MapFactory
        public <K, V> Map<K, V> forMap(Map<K, V> map) {
            if (map == null) {
                return new HashMap();
            }
            return map;
        }
    }

    /* loaded from: classes10.dex */
    public interface MapFactory {
        <K, V> Map<K, V> forMap(Map<K, V> map);
    }

    private MapFactories() {
    }

    public static MapFactory getMapFactory() {
        return mapFactory;
    }

    public static void setMapFactory(MapFactory mapFactory2) {
        mapFactory = mapFactory2;
    }
}
