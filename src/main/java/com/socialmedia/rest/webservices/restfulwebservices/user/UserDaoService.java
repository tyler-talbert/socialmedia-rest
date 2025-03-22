package com.socialmedia.rest.webservices.restfulwebservices.user;

import java.util.function.Predicate;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<User>();

    private static Integer usersCount = 0;

    static {
        users.add(new User(++usersCount, "Adam", LocalDate.of(1999, 12, 14)));
        users.add(new User(++usersCount, "Eve", LocalDate.of(1996, 11, 26)));
        users.add(new User(++usersCount, "Jack", LocalDate.now().minusYears(22)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(int id) {
        return users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }

    public User save(User user) {
        user.setId(++usersCount);
        users.add(user);
        return user;
    }


}
