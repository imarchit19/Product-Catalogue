/**
 * 
 */
package com.architgupta.product.dbseeder;

import com.architgupta.product.model.item.Item;
import com.architgupta.product.model.item.ItemCategory;
import com.architgupta.product.model.user.Role;
import com.architgupta.product.model.user.RoleName;
import com.architgupta.product.model.user.User;
import com.architgupta.product.repository.item.ItemRepository;
import com.architgupta.product.repository.user.RoleRepository;
import com.architgupta.product.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author architgupta
 *
 */
@Component
public class DatabaseSeeder implements CommandLineRunner {

	private String[] itemNames = { 
			"Apple MacBook Air", 
			"Apple MacBook Pro", 
			"Apple iPhone 13", 
			"Apple iPhone 13 Pro", 
			"Apple iPhone 13 Pro Max", 
			"Pixel 6",
			"Pixel 6 Pro", 
			"Google Chromebook", 
			"Samsung Galaxy S21", 
			"Samsung Galaxy S21 Ultra", 
			"Samsung Galaxy S20", 
			"Samsung Galaxy S20 Ultra", 
			"Samsung Galaxy S7", 
			"Samsung Galaxy S7 FE",
			"Apple iPad 13", 
			"Apple iPad 13 Pro", 
			"Pixel 6 Fold", 
			"HP Ultrabook 13", 
			"HP Chromebook 12", 
			"HP Ultrabook 13 Pro" 
	};

	private String[] itemImages = { 
			"https://picsum.photos/id/1/200/300", 
			"https://picsum.photos/id/2/200/300",
			"https://picsum.photos/id/3/200/300", 
			"https://picsum.photos/id/4/200/300",
			"https://picsum.photos/id/5/200/300", 
			"https://picsum.photos/id/6/200/300",
			"https://picsum.photos/id/7/200/300", 
			"https://picsum.photos/id/8/200/300",
			"https://picsum.photos/id/9/200/300", 
			"https://picsum.photos/id/10/200/300",
			"https://picsum.photos/id/11/200/300", 
			"https://picsum.photos/id/12/200/300",
			"https://picsum.photos/id/13/200/300", 
			"https://picsum.photos/id/14/200/300",
			"https://picsum.photos/id/15/200/300", 
			"https://picsum.photos/id/16/200/300",
			"https://picsum.photos/id/17/200/300", 
			"https://picsum.photos/id/18/200/300",
			"https://picsum.photos/id/19/200/300", 
			"https://picsum.photos/id/20/200/300" 
	};

	private ItemCategory[] itemCategories = { 
			ItemCategory.LAPTOPS, 
			ItemCategory.LAPTOPS,
			ItemCategory.MOBILES, 
			ItemCategory.MOBILES, 
			ItemCategory.MOBILES, 
			ItemCategory.MOBILES,
			ItemCategory.MOBILES, 
			ItemCategory.LAPTOPS, 
			ItemCategory.MOBILES, 
			ItemCategory.MOBILES,
			ItemCategory.MOBILES, 
			ItemCategory.MOBILES, 
			ItemCategory.TABLETS, 
			ItemCategory.TABLETS,
			ItemCategory.TABLETS, 
			ItemCategory.TABLETS, 
			ItemCategory.MOBILES, 
			ItemCategory.LAPTOPS,
			ItemCategory.LAPTOPS, 
			ItemCategory.LAPTOPS 
	};

	private String[] descriptions = {
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
					
	};

	private String[] brand = {
			"Apple",
			"Apple",
			"Apple",
			"Apple",
			"Apple",
			"Google",
			"Google",
			"Google",
			"Samsung",
			"Samsung",
			"Samsung",
			"Samsung",
			"Samsung",
			"Samsung",
			"Apple",
			"Apple",
			"Google",
			"HP",
			"HP",
			"HP"
	};
	
	private Integer[] price = {
			125000,
			221000,
			112150,
			221240,
			322220,
			411150,
			502220,
			103331,
			23113,
			43222,
			13323,
			24422,
			41132,
			52267,
			78449,
			12111,
			23224,
			323331,
			10410,
			20111
	};
	
	private Integer[][] itemPincodes = {
			{110034, 110075, 110088},
			{110023, 110099, 110025},
			{110034, 110075, 110011},
			{110023, 110099, 110000},
			{110034, 110075, 110000},
			{110023, 110099, 110000},
			{110034, 110075, 110000},
			{110023, 110099, 110000},
			{110034, 110075, 110000},
			{110023, 110099, 110000},
			{110034, 110075, 110000},
			{110023, 110099, 110000},
			{110034, 110075, 110000},
			{110023, 110099, 110000},
			{110034, 110075, 110000},
			{110023, 110099, 110000},
			{110034, 110075, 110000},
			{110023, 110099, 110000},
			{110034, 110075, 110000},
			{110023, 110099, 110000}
	};

	private ItemRepository itemRepository;

	private RoleRepository roleRepository;

	private UserRepository userRepository;

	private PasswordEncoder encoder;

	@Autowired
	public DatabaseSeeder(ItemRepository itemRepository, RoleRepository roleRepository,
			UserRepository userRepository, PasswordEncoder encoder) {
		this.itemRepository = itemRepository;
		this.roleRepository = roleRepository;
		this.userRepository = userRepository;
		this.encoder = encoder;
	}

	@Override
	public void run(String... args) throws Exception {

		Iterable<Item> items = itemRepository.findAll();

		if (items.spliterator().getExactSizeIfKnown() == 0) {
			roleRepository.save(new Role(RoleName.USER));
			roleRepository.save(new Role(RoleName.ADMIN));
			User user = new User("test", "username", "test1@test.test", encoder.encode("password"));
			Set<Role> roles = new HashSet<>();
			Role userRole = roleRepository.findByRoleName(RoleName.USER)
					.orElseThrow(() -> new RuntimeException("Failed: User role not found!"));
			roles.add(userRole);
			user.setRoles(roles);
			userRepository.save(user);

			for (int i = 0; i < itemNames.length; i++) {

				Item item = new Item(itemNames[i], itemCategories[i], descriptions[i], brand[i],
						itemImages[i], price[i], itemPincodes[i]);

				item.setLastAccessed(new Date());
				itemRepository.save(item);
			}
		}
	}
}


