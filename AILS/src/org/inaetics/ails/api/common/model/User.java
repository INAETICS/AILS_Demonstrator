package org.inaetics.ails.api.common.model;

import java.util.UUID;

import com.google.common.base.Preconditions;

/**
 * Representation of everything a client should know about users.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 1.0.0
 * @since 24-11-2015
 */
public class User implements Key<UUID> {

    private static final Accuracy ACCURACY_DEFAULT = Accuracy.AREA;
    
    private final UUID uuid;
    private final String name;
    private final Accuracy accuracy;

    /**
     * Constructor for User.
     * 
     * @param uuid @NotNull Universally unique identifier identifying this User.
     * @param name The name of this User.
     * @param accuracy The {@link Accuracy} of this User.
     */
    public User(UUID uuid, String name, Accuracy accuracy) {
        this.uuid = Preconditions.checkNotNull(uuid, "uuid is not set");
        this.name = name;
        this.accuracy = accuracy;
    }

    /**
     * Constructor for User with a default value of Area for the accuracy.
     * 
     * @param uuid @NotNull Universally unique identifier identifying this User.
     * @param name The name of this User.
     */
    public User(UUID uuid, String name) {
        this(uuid, name, ACCURACY_DEFAULT);
    }
    
    /**
     * Retrieve the UUID of this User.
     * 
     * @return This User's UUID.
     * @since 0.1.0
     */
    public UUID getUuid() {
        return uuid;
    }

    /**
     * Retrieve the Name of this User.
     * 
     * @return This User's name.
     * @since 0.1.0
     */
    public String getName() {
        return name;
    }
    
    /**
     * Retrieve the {@link Accuracy} of this User.
     * 
     * @return This User's accuracy.
     * @since 1.0.0
     */
    public Accuracy getAccuracy() {
        return accuracy;
    }

    /**
     * @since 0.1.0
     */
    @Override
    public UUID getKey() {
        return uuid;
    }

    /**
     * Returns a hash code value for the object, based on its uuid.
     * 
     * @return a hash code value for this object.
     * @see Object#hashCode()
     * @since 0.1.0
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
        return result;
    }

    /**
     * Indicates whether some other object is "equal to" this one, based on their uuid's.
     * 
     * @param obj the reference object with which to compare.
     * @return true if this object is the same as the obj argument; false otherwise.
     * @see java.lang.Object#equals(java.lang.Object)
     * @since 0.1.0
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        User other = (User) obj;
        if (uuid == null) {
            if (other.uuid != null) {
                return false;
            }
        } else if (!uuid.equals(other.uuid)) {
            return false;
        }
        return true;
    }

}
