package com.work.services;

import com.work.config.DatabaseConnection;
import com.work.repository.interfaces.ManagerInterface;
import com.work.repository.repositories.ManagerRepository;

import java.sql.Connection;

public class ManagerService {
    private final Connection conn = DatabaseConnection.getConnection();
    private final ManagerInterface managerRepository = new ManagerRepository(conn);

    public boolean signUpManager(String username, String email, String password) {
        managerRepository.signUpManager(username, email, password);
        return true;
    }

}


