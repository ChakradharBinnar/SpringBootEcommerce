package com.demo.contro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.entity.ContactUsModel;
import com.demo.repo.ContactUsRepo;


@Controller
public class ContactUsController {

	@Autowired
	private ContactUsRepo repo;
	
	@GetMapping("/contactus")
	public String getContactUsPage() {
		return "contactus";
	}

	@PostMapping("/saveContactUs")
	public String saveContactUs(ContactUsModel ConUs) {
		repo.save(ConUs);
		return "contactus";
	}
	
}
