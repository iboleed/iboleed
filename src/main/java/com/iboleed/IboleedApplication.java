package com.iboleed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/iboleed")
public class IboleedApplication {

	public static void main(String[] args) { SpringApplication.run(IboleedApplication.class, args); }

	//Template
	private List<Member> memberListt = Arrays.asList(
			new Member( "Member", "Tim Schimandle", "qwerty",""),
			new Member( "Member2", "Slavisa", "asdf","")
	);

	//Template
	private List<FitnessData> fitnessData = Arrays.asList(
			new FitnessData.FitnessDataBuilder()
					.memberId("22")
					.date(Instant.now())
					.steps(123)
					.build(),
			new FitnessData.FitnessDataBuilder()
					.memberId("46")
					.date(Instant.now())
					.steps(34)
					.build()

	);

	@GetMapping("")
	public List<Member> findAllMem() {
		return memberListt;
	}

	@GetMapping("/{memId}")
	public Member findMem(@PathVariable Long bookId) {
		return memberListt.stream().filter(b -> b.getFirstName().equals(bookId)).findFirst().orElse(null);
	}

}

