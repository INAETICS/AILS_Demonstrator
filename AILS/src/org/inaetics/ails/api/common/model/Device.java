package org.inaetics.ails.api.common.model;

import java.util.UUID;

/**
 * Representation of a Device.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 22-10-2015
 */
public class Device {

    private final String name;
    private final byte[] mac;
    private final Accuracy accuracy;
    private final UUID uuid;

    public Device(String name, byte[] mac, Accuracy accuracy, UUID uuid) {
        super();
        this.name = name;
        this.mac = mac;
        this.accuracy = accuracy;
        this.uuid = uuid;
    }

    /**
     * Retrieve the UUID of this Device.
     * 
     * @return This User's UUID.
     */
    public UUID getUuid() {
        return uuid;
    }

    /**
     * Retrieve the name of this Device.
     * 
     * @return The User's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieve the MAC-address of this Device.
     * 
     * @return A byte[] representation of the MAC-address of this Device.
     */
    public byte[] getMac() {
        return mac;
    }

    /**
     * Retrieve the MAC-address of this Device.
     * 
     * @return The accuracy of this Device.
     */
    public Accuracy getAccuracy() {
        return accuracy;
    }
}
