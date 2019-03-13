package com.iboleed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/iboleed")
public class IboleedApplication {

	public static void main(String[] args) {
		SpringApplication.run(IboleedApplication.class, args);
	}

	//Template
	private List<Member> memberListt = Arrays.asList(
			new Member(1L, "Member", "Tim Schimandle"),
			new Member(2L, "Member2", "Slavisa")
	);

	@GetMapping("")
	public List<Member> findAllMem() {
		return memberListt;
	}

	@GetMapping("/{memId}")
	public Member findMem(@PathVariable Long bookId) {
		return memberListt.stream().filter(b -> b.getId().equals(bookId)).findFirst().orElse(null);
	}


}

