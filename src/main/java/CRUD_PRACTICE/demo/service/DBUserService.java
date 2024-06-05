package CRUD_PRACTICE.demo.service;

import CRUD_PRACTICE.demo.repository.DBUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DBUserService {
    private final DBUserRepository DBuserRepository;

    
}
