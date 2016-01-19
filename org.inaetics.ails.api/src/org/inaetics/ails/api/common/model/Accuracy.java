package org.inaetics.ails.api.common.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Accuracy describes the accuracy with which a {@link User} can be located.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.2.0
 * @since 20-10-2015
 */
public enum Accuracy {
    AREA, BUILDING, SITE, ORGANIZATION, OFF;
    
    
    private static Map<String, Accuracy> namespace = new HashMap<>();
    
    static {
        namespace.put("area", AREA);
        namespace.put("building", BUILDING);
        namespace.put("site", SITE);
        namespace.put("organization", ORGANIZATION);
        namespace.put("off", OFF);
    }
    
    @JsonCreator
    public static Accuracy forValue(String value) {
        return namespace.get(value.toLowerCase());
    }

    @JsonValue
    public String toValue() {
        for (Map.Entry<String, Accuracy> entry : namespace.entrySet()) {
            if (entry.getValue() == this)
                return entry.getKey();
        }

        return null; // or fail
    }
}
