/**
 * 
 */
package com.architgupta.product.controller.user;

import com.architgupta.product.request.LoginForm;
import com.architgupta.product.request.SignUpForm;
import com.architgupta.product.response.JWTResponse;
import com.architgupta.product.response.ResponseMessage;
import com.architgupta.product.model.user.Role;
import com.architgupta.product.model.user.RoleName;
import com.architgupta.product.model.user.User;
import com.architgupta.product.repository.user.RoleRepository;
import com.architgupta.product.repository.user.UserRepository;
import com.architgupta.product.security.jwt.JWTProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

/**
 * @author architgupta
 *
 */


@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {
	private AuthenticationManager authenticationManager;

	private UserRepository userRepository;

	private RoleRepository roleRepository;

	private PasswordEncoder encoder;

	private JWTProvider jwtProvider;

	@Autowired
	public UserController(AuthenticationManager authenticationManager, 
			UserRepository userRepository, 
			RoleRepository roleRepository, 
			PasswordEncoder encoder, 
			JWTProvider jwtProvider){
		this.authenticationManager = authenticationManager;
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.encoder = encoder;
		this.jwtProvider = jwtProvider;
	}

	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginForm) {
		try {
			Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					loginForm.getUsername(), loginForm.getPassword()
					));

			SecurityContextHolder.getContext().setAuthentication(authentication);

			String jwt = jwtProvider.generateJwtToken(authentication);
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();

			return ResponseEntity.ok(new JWTResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
		} catch (BadCredentialsException e) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpForm signUpForm) {

		if(userRepository.existsByUsername(signUpForm.getUsername())){
			return new ResponseEntity<>(new ResponseMessage("Username is already taken!"), HttpStatus.BAD_REQUEST);
		}

		if(userRepository.existsByEmail(signUpForm.getEmail())){
			return new ResponseEntity<>(new ResponseMessage("Email is already in use!"), HttpStatus.BAD_REQUEST);
		}

		User user = new User(signUpForm.getName(), signUpForm.getUsername(), signUpForm.getEmail(), encoder.encode(signUpForm.getPassword()));

		Set<String> strRoles = signUpForm.getRole();
		Set<Role> roles = new HashSet<>();

		strRoles.forEach(role -> {
			if (role.equals("admin")) {
				Role adminRole = roleRepository.findByRoleName(RoleName.ADMIN)
						.orElseThrow(() -> new RuntimeException("Failed: User Role not found."));
				roles.add(adminRole);
			} else {
				Role userRole = roleRepository.findByRoleName(RoleName.USER)
						.orElseThrow(() -> new RuntimeException("Failed: User Role not found."));
				roles.add(userRole);
			}
		});

		user.setRoles(roles);
		userRepository.save(user);

		return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);
	}
}
