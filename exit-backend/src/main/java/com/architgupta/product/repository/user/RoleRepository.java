/**
 * 
 */
package com.architgupta.product.repository.user;

import com.architgupta.product.model.user.Role;
import com.architgupta.product.model.user.RoleName;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author architgupta
 *
 */

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
	Optional<Role> findByRoleName(RoleName roleName);
}