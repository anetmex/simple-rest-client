package com.simple.restclient.repository;

import com.simple.restclient.domain.User;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class UserRepository {

    private final Map<Integer, User> users = new HashMap<>();

    public UserRepository() {
        users.put(1, new User(1, "Nikolas"));
    }

    public List<User> selectAll() {
        return users.values().stream()
                .sorted(Comparator.comparingInt(User::getId))
                .collect(toList());
    }

    public User select(Integer id) {
        return users.get(id);
    }

    public User create(User user) {
        return users.put(user.getId(), user);
    }

    public User update(User user) {
        return users.compute(user.getId(), (id, oldUser) -> new User(id, user.getName()));
    }

    /**
     * Return TRUE if a user has been deleted
     */
    public boolean delete(Integer id) {
        return users.remove(id) != null;
    }
}
