package org.inaetics.ails.api.common.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.Preconditions;

/**
 * Representation of everything a client should know about users.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 2.0.0
 * @since 24-11-2015
 */
public class User implements Key<UUID> {

    private UUID uuid;
    private String name;
    private Accuracy accuracy;
    
    public User () {
        // Empty constructor for Jackson
    }

    /**
     * Constructor for User.
     * 
     * @param uuid @NotNull Universally unique identifier identifying this User.
     * @param name @NotNull The name of this User.
     * @param accuracy The {@link Accuracy} of this User.
     * @since 2.0.0
     */
    public User(UUID uuid, String name, Accuracy accuracy) {
        this.uuid = Preconditions.checkNotNull(uuid, "uuid is not set");
        this.name = Preconditions.checkNotNull(name, "name is not set");
        this.accuracy = accuracy;
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
     * Retrieve the {@link Accuracy} of this User.
     * 
     * @return This User's accuracy.
     */
    public Accuracy getAccuracy() {
        return accuracy;
    }

    @Override
    public UUID retrieveKey() {
        return uuid;
    }
    
    // Below setters only exist for Jackson

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccuracy(Accuracy accuracy) {
        this.accuracy = accuracy;
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
