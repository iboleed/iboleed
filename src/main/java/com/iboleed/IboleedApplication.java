package com.iboleed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("/iboleed")
public class IboleedApplication {

	public static void main(String[] args) { SpringApplication.run(IboleedApplication.class, args); }

//	//Template
//	private List<Member> memberListt = Arrays.asList(
//			new Member( "Member", "Tim Schimandle", "qwerty",""),
//			new Member( "Member2", "Slavisa", "asdf","")
//	);

	//Template
	private List<FitnessData> fitnessData = Arrays.asList(
			new FitnessData(999L, "123", Instant.now(), 123),
			new FitnessData(888L, "456", Instant.now(), 34)
	);

//	@GetMapping("")
//	public List<Member> findAllMem() {
//		return memberListt;
//	}
//
//	@GetMapping("/{memId}")
//	public Member findMem(@PathVariable Long bookId) {
//		return memberListt.stream().filter(b -> b.getFirstName().equals(bookId)).findFirst().orElse(null);
//	}

}

