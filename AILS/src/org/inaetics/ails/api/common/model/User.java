package org.inaetics.ails.api.common.model;

import java.util.UUID;

import com.google.common.base.Preconditions;

/**
 * Representation of a User.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.3
 * @since 20-10-2015
 */
public class User {

    private final UUID uuid;
    private final String name;
    private final byte[] mac;

    /**
     * Constructor for User.
     * 
     * @param uuid @NotNull Universally unique identifier identifying this User.
     * @param name The name of this User.
     * @param mac A byte[] representation of the MAC-address of this User's device.
     */
    public User(UUID uuid, String name, byte[] mac) {
        super();
        this.uuid = Preconditions.checkNotNull(uuid, "uuid is not set");
        this.name = name;
        this.mac = mac;
    }

    /**
     * Retrieve the UUID of this User.
     * 
     * @return This User's UUID.
     */
    public UUID getUuid() {
        return uuid;
    }

    /**
     * Retrieve the Name of this User.
     * 
     * @return This User's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieve the MAC-address of this User.
     * 
     * @return A byte[] representation of the MAC-address of this User's device.
     */
    public byte[] getMac() {
        return mac;
    }

    /**
     * Returns a hash code value for the object, based on its uuid.
     * 
     * @return a hash code value for this object.
     * @see Object#hashCode()
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
