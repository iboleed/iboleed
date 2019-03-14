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

	@Autowired
	private final MemberRepository repository = new MemberRepository() {
		@Override
		public List<Member> findByLastName(String lastName) {
			return null;
		}

		@Override
		public Member findByName(String name) {
			return null;
		}

		@Override
		public <S extends Member> S save(S entity) {
			return null;
		}

		@Override
		public <S extends Member> Iterable<S> saveAll(Iterable<S> entities) {
			return null;
		}

		@Override
		public Optional<Member> findById(Long aLong) {
			return Optional.empty();
		}

		@Override
		public boolean existsById(Long aLong) {
			return false;
		}

		@Override
		public Iterable<Member> findAll() {
			return null;
		}

		@Override
		public Iterable<Member> findAllById(Iterable<Long> longs) {
			return null;
		}

		@Override
		public long count() {
			return 0;
		}

		@Override
		public void deleteById(Long aLong) {

		}

		@Override
		public void delete(Member entity) {

		}

		@Override
		public void deleteAll(Iterable<? extends Member> entities) {

		}

		@Override
		public void deleteAll() {

		}
	};

	//Template
	private List<Member> memberListt = Arrays.asList(
			new Member("123", "Member", "Tim Schimandle", "qwerty"),
			new Member("456", "Member2", "Slavisa", "asdf")
	);

	//Template
	private List<FitnessData> fitnessData = Arrays.asList(
			new FitnessData(999L, "123", Instant.now(), 123),
			new FitnessData(888L, "456", Instant.now(), 34)
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

