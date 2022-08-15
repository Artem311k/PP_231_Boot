package ru.kuzmin.PP_231.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kuzmin.PP_231.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
