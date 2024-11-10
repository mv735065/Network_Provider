package com.example.Network.Repository;


import com.example.Network.RequestDtos.AdminDto;
import com.example.Network.RequestDtos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

@Lazy
@Repository
public class AdminRepository {
    private final JdbcTemplate jdbcTemplate;
    private final BCryptPasswordEncoder encoder;

    @Autowired
    public AdminRepository(JdbcTemplate jdbcTemplate, BCryptPasswordEncoder encoder) {
        this.jdbcTemplate = jdbcTemplate;
        this.encoder = encoder;
    }

    // Insert a new user into the database
    public int saveAdmin(AdminDto adminDto)  {
//        if (!isUsersTablePresent()) {
//            String createTableSql = "CREATE TABLE IF NOT EXISTS users (" +
//                    "id INT PRIMARY KEY AUTO_INCREMENT, " +
//                    "username VARCHAR(50) UNIQUE NOT NULL, " +
//                    "password VARCHAR(255) NOT NULL, " +
//                    "email VARCHAR(255) NOT NULL, " +
//                    "role VARCHAR(50) NOT NULL" +
//                    ")";
//
//            jdbcTemplate.execute(createTableSql);
//        }

        String encodedPassword = encoder.encode(adminDto.getPassword());

        String sql = "INSERT INTO admin (username, password,email,role) VALUES (?, ? ,? , ?)";
        return jdbcTemplate.update(sql, adminDto.getUsername(), encodedPassword,adminDto.getEmail(),adminDto.getRole());
    }



//    public boolean isUsersTablePresent() {
//        // Query to check if the 'users' table exists in the current database
//        String checkTableSql = "SELECT COUNT(*) FROM information_schema.tables WHERE table_schema = ? AND table_name = 'users'";
//
//        // Replace 'yourDatabaseName' with the name of your actual database
//        int count = jdbcTemplate.queryForObject(checkTableSql, Integer.class, "network_provider_db");
//
//        return count > 0; // Return true if the table exists, false otherwise
//    }


}
