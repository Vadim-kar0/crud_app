package ru.geekbrains.crud_app.repository;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "sql")
@Value
public class UserRepositoryConfiguration {
    String sqlFindAll;
    String sqlSave;
    String sqlDeleteById;
    String sqlUpdateUser;
    String sqlGetUser;
}
