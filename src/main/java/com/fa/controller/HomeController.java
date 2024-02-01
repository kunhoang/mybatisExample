package com.fa.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fa.dto.CustomerDTO;
import com.fa.entity.Customer;
import com.fa.entity.TinhThanh;
import com.fa.service.CustomerService;
import com.fa.service.TinhThanhService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class HomeController {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	TinhThanhService tinhThanhService;
	
	@GetMapping("/home")
	public String home(Model model, @RequestParam(name = "page", defaultValue = "1") int page) {
		PageHelper.startPage(page, 3);
		List<Customer> list = customerService.getAll();
//		List<CustomerDTO> listDTO = customerService.listAll();
		List<TinhThanh> listTT = tinhThanhService.getAll();
		PageInfo<List<Customer>> pageInfo = new PageInfo(list);
		model.addAttribute("list",list);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("listTT",listTT);
		return "Example";
	}
	
	@GetMapping("/save")
	public String formAdd(Model model) {
		List<TinhThanh> tt = tinhThanhService.getAll();
		model.addAttribute("tt",tt);
		model.addAttribute("customer",new Customer());
		model.addAttribute("action","insert");
		return "Form";
	}
	
	@PostMapping("/save")
	public String addCustomer(Model model,@Valid Customer customer, BindingResult rs) {
		if(rs.hasErrors()) {
			List<TinhThanh> tt = tinhThanhService.getAll();
			model.addAttribute("tt",tt);
			model.addAttribute("action","insert");
			return "Form";
		}
		customerService.insert(customer);
		return "redirect:/home";
	}
	
	@GetMapping("/delete")
	public String delete(Model model,String id) {
		customerService.deleteById(Integer.parseInt(id));
		return "redirect:/home";
	}
	
	@GetMapping("/update/{id}")
	public String formUpdate(Model model,@PathVariable(name = "id",required = false)String id) {
		Customer cus = customerService.findById(Integer.parseInt(id));
		model.addAttribute("action","update");
		model.addAttribute("customer",cus);
		List<TinhThanh> tt = tinhThanhService.getAll();
		model.addAttribute("tt",tt);
		return "Form";
	}
	
	@PostMapping("update")
	public String update(Model model,@Valid Customer customer, BindingResult rs) {
		if(rs.hasErrors()) {
			model.addAttribute("action","update");
			List<TinhThanh> tt = tinhThanhService.getAll();
			model.addAttribute("tt",tt);
			return "Form";
		}
		customerService.update(customer);
		return "redirect:/home";
	}
	
	@GetMapping("/login")
	public String loginForm(Model model,TinhThanh tinhThanh) {
		model.addAttribute("tinhthanh",new TinhThanh());
		return "Login";
	}
	
	@PostMapping("/login")
	public String login(Model model,String tenTT, String password,HttpSession session) {
		TinhThanh tt = tinhThanhService.search(tenTT, password);
		if(tt == null) {
			model.addAttribute("msg","Vui long dang nhap lai");
			model.addAttribute("tinhthanh",new TinhThanh());
			return "Login";
		}
		session.setAttribute("acc",tt.getTenTT());
		return "redirect:/home";
	}
	
	@GetMapping("/logout")
	public String logout (Model model,TinhThanh tinhThanh,HttpSession session) {
		model.addAttribute("tinhthanh",new TinhThanh());
		session.removeAttribute("acc");
		return "Login";
	}
	
	@GetMapping("/search")
	public String search(Model model, @RequestParam String search) {
		List<Customer> rs = customerService.search(search);
		model.addAttribute("list",rs);
		return "Example";
	}
}
