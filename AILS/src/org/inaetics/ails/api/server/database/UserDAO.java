package org.inaetics.ails.api.server.database;

import java.util.UUID;

import org.inaetics.ails.api.common.model.User;

/**
 * DAO for {@link User} objects.
 * 
 * @author L. Buit, N. Korthout, J. Naus
 * @version 0.1.0
 * @since 12-12-2015
 */
public interface UserDAO extends DAO<UUID, User> {

}
