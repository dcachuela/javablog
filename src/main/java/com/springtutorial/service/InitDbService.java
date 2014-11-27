package com.springtutorial.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springtutorial.entity.Blog;
import com.springtutorial.entity.Item;
import com.springtutorial.entity.Role;
import com.springtutorial.entity.User;
import com.springtutorial.repository.BlogRepository;
import com.springtutorial.repository.ItemRepository;
import com.springtutorial.repository.RoleRepository;
import com.springtutorial.repository.UserRepository;

@Transactional
@Service
public class InitDbService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	//means this method will be called after the spring context creation which is created during start up
	//all the methods under this will be called
	@PostConstruct
	public void init() {
		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);
		
		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);
		
		User userAdmin = new User();
		userAdmin.setName("admin");
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleAdmin);
		roles.add(roleUser);
		userAdmin.setRoles(roles);
		userRepository.save(userAdmin);
		
		Blog blogJavaVids = new Blog();
		blogJavaVids.setName("Jav Vids");
		blogJavaVids.setUrl("https://feeds.feedburner.com/javavids?format=xml");
		blogJavaVids.setUser(userAdmin);
		blogRepository.save(blogJavaVids);
		
		Item item1 = new Item();
		item1.setBlog(blogJavaVids);
		item1.setTitle("first");
		item1.setLink("http//www.javavids.com");
		item1.setPublishedDate(new Date());
		itemRepository.save(item1);
	
		Item item2 = new Item();
		item2.setBlog(blogJavaVids);
		item2.setTitle("second");
		item2.setLink("http//www.javavids.com");
		item2.setPublishedDate(new Date());
		itemRepository.save(item2);
	
		
	}
}
