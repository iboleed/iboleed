package com.iboleed;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long> {

    List<Member> findByLastName(String lastName);

    Member findByName(String name);
}
