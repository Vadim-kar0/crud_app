package ru.geekbrains.crud_app.repository;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.geekbrains.crud_app.model.User;


import java.util.List;

@Repository
@AllArgsConstructor
public class UserRepository {

    JdbcTemplate jdbc;
    UserRepositoryConfiguration urc;

    public List<User> findAll() {
        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };

        return jdbc.query(urc.getSqlFindAll(), userRowMapper);
    }

    public User getUser(int id){
        String sql = urc.getSqlGetUser() + id;
        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };
        List<User> users = jdbc.query(sql,userRowMapper);
        return users.isEmpty() ? null : users.get(0);
    }

    public User save(User user) {
        jdbc.update(urc.getSqlSave(), user.getFirstName(), user.getLastName());
        return  user;
    }

    public void deleteById(int id){
        jdbc.update(urc.getSqlDeleteById(),id);
    }

    public void update(User user){
        jdbc.update(urc.getSqlUpdateUser(),user.getFirstName(),user.getLastName(),user.getId());
    }
}
