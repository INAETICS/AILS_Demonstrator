package org.inaetics.ails.impl.client.factory.profile;

import java.util.Optional;

import org.inaetics.ails.api.client.factory.ProfileFactory;
import org.inaetics.ails.api.common.model.WiFiProfile;

/**
 * The ProfileFactoryImpl class provides an implementation of the {@link ProfileFactory
 * ProfileFactory}
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 05-11-2015
 */
public class ProfileFactoryImpl implements ProfileFactory {

    @Override
    public Optional<WiFiProfile> getProfile() {
        throw new UnsupportedOperationException(
                "ProfileFactoryImpl.getProfile() not yet implemented.");
    }

}
