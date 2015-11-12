package org.inaetics.ails.api.common.model;

import java.util.UUID;

public class User extends AnonUser {
    private final byte[] mac;

    public User(UUID uuid, String name, byte[] mac) {
        super(uuid, name);        
        this.mac = mac;
    }
    
    
    
    /**
     * Retrieve the MAC-address of this User.
     * 
     * @return A byte[] representation of the MAC-address of this User's device.
     * @since 0.1.0
     */
    public byte[] getMac() {
        return mac;
    }
    
    /**
     * Anonymizes this object to not have a Mac
     */
    public AnonUser asAnonUser() {
        return new AnonUser(this.getUuid(), this.getName());
    }

}
