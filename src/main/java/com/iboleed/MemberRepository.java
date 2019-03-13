package com.iboleed;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public class MemberRepository extends CrudRepository<Member, Long> {
    List<Member> findByLastName(String lastName);
}
