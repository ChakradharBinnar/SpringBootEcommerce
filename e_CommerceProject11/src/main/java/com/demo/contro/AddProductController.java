package com.demo.contro;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.demo.entity.ProductModel;
import com.demo.repo.ProductRepo;

@Controller
public class AddProductController {

	@Autowired
	private ProductRepo uploadRepo;

	@GetMapping("/")
	public String index(Model m) {
		
		List<ProductModel> list =uploadRepo.findAll();
		m.addAttribute("list", list);
		return "home";
	}
	
	@GetMapping("/addProduct")
	public String homePage() {
		return "addProductForm";
	}
	
	@GetMapping("/login")
	public String getLoginPage() {
		return "loginpage";
	}
	
	@GetMapping("/dlt/{id}")
	public String dltByid(@PathVariable int id) {
		uploadRepo.deleteById(id);
		return "redirect:/";
	}
	
	
	@GetMapping("/getByProIdM")
	public String getByProductIdM(Model m) {
		List<ProductModel> list1 = uploadRepo.getUserByIdM();
		m.addAttribute("list1", list1);
		return "mobile";
	}
	
	@GetMapping("/getByProIdG")
	public String getByProductIdG(Model m) {
		List<ProductModel> list2 = uploadRepo.getUserByIdG();
		m.addAttribute("list2", list2);
		return "grocery";
	}
	
	@GetMapping("/getByProIdK")
	public String getByProductIdK(Model m) {
		List<ProductModel> list3 = uploadRepo.getUserByIdK();
		m.addAttribute("list3", list3);
		return "kids";
	}
	
	@GetMapping("/getByProIdF")
	public String getByProductIdF(Model m) {
		List<ProductModel> list4 = uploadRepo.getUserByIdF();
		m.addAttribute("list4", list4);
		return "fashion";
	}
	
	@GetMapping("/getByProIdH")
	public String getByProductIdH(Model m) {
		List<ProductModel> list5 = uploadRepo.getUserByIdH();
		m.addAttribute("list5", list5);
		return "homefur";
	}
	
	
	

	@PostMapping("/imageUpload")
	public String imageUpload(@RequestParam MultipartFile img, ProductModel imgs) {

		
		imgs.setImageName(img.getOriginalFilename());
		ProductModel uploadImg = uploadRepo.save(imgs);

		if (uploadImg != null) {
			try {

				File saveFile = new ClassPathResource("static/img").getFile();

				Path path=Paths.get(saveFile.getAbsolutePath() + File.separator + img.getOriginalFilename());
				
				System.out.println(path);
				
				Files.copy(img.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
//		session.setAttribute("msg", "Your Image Upload Sucessfully");

		return "redirect:/";
	}
}
