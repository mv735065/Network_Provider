package com.example.Network.Repository;

import com.example.Network.Entities.User;
import com.example.Network.RequestDtos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private BCryptPasswordEncoder encoder;

    // Insert a new user into the database
    public int saveUser(UserDto userDto) {
        if (!isUsersTablePresent()) {
            String createTableSql = "CREATE TABLE IF NOT EXISTS users (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "username VARCHAR(50) UNIQUE NOT NULL, " +
                    "password VARCHAR(255) NOT NULL, " +
                    "email VARCHAR(255) NOT NULL, " +
                    "role VARCHAR(50) NOT NULL" +
                    ")";

            jdbcTemplate.execute(createTableSql);
        }

        String encodedPassword = encoder.encode(userDto.getPassword());

        String sql = "INSERT INTO users (username, password,email,role) VALUES (?, ? ,? , ?)";
        return jdbcTemplate.update(sql, userDto.getUsername(), encodedPassword,userDto.getEmail(),userDto.getRole());
    }

    public boolean isUsersTablePresent() {
        // Query to check if the 'users' table exists in the current database
        String checkTableSql = "SELECT COUNT(*) FROM information_schema.tables WHERE table_schema = ? AND table_name = 'users'";

        // Replace 'yourDatabaseName' with the name of your actual database
        int count = jdbcTemplate.queryForObject(checkTableSql, Integer.class, "network_provider_db");

        return count > 0; // Return true if the table exists, false otherwise
    }

}
