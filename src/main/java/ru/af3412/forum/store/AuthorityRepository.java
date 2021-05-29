package ru.af3412.forum.store;

import org.springframework.data.repository.CrudRepository;
import ru.af3412.forum.model.Authority;

public interface AuthorityRepository extends CrudRepository<Authority, Integer> {

    Authority findByAuthority(String authority);
}
