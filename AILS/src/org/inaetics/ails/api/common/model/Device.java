package org.inaetics.ails.api.common.model;

import java.util.UUID;

import com.google.common.base.Preconditions;

/**
 * Representation of a Device.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.1
 * @since 22-10-2015
 */
public class Device {

    private static final Accuracy DEFAULT_ACCURACY = Accuracy.AREA;

    private final String name;
    private final byte[] mac;
    private final UUID uuid;
    private final Accuracy accuracy;

    /**
     * Constructor for Device.
     * 
     * @param name @NotNull The device's name.
     * @param mac @NotNull The device's uniquely identifying MAC-address.
     * @param uuid @NotNull Universally unique identifier identifying the {@link User} of this
     *        device.
     * @param accuracy The accuracy with which this device is allowed to be located. Will use a
     *        default of Device.DEFAULT_ACCURACY if null is provided.
     */
    public Device(String name, byte[] mac, UUID uuid, Accuracy accuracy) {
        super();
        this.name = Preconditions.checkNotNull(name, "name is not set");
        this.mac = Preconditions.checkNotNull(mac, "mac is not set");
        this.uuid = Preconditions.checkNotNull(uuid);
        this.accuracy = accuracy != null ? accuracy : DEFAULT_ACCURACY;
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
     * Retrieve the UUID of this Device.
     * 
     * @return This User's UUID.
     */
    public UUID getUuid() {
        return uuid;
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
