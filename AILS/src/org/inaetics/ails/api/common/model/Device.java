package org.inaetics.ails.api.common.model;

import com.google.common.base.Preconditions;

/**
 * Representation of a Device.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.2.0
 * @since 22-10-2015
 */
public class Device {

    private static final Accuracy DEFAULT_ACCURACY = Accuracy.AREA;

    private final User user;
    private final Accuracy accuracy;

    /**
     * Constructor for Device.
     * 
     * @param user @NotNull The user's information.
     * @param accuracy The accuracy with which this device is allowed to be located. Will use a
     *        default of Device.DEFAULT_ACCURACY if null is provided.
     */
    public Device(User user, Accuracy accuracy) {
        super();
        this.user = Preconditions.checkNotNull(user, "name is not set");
        this.accuracy = accuracy != null ? accuracy : DEFAULT_ACCURACY;
    }

    /**
     * Retrieve the user of this Device.
     * 
     * @return The {@link User Uses}'s information.
     */
    public User getUser() {
        return user;
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
