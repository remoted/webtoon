package com.webtoon.webtoonservice.service;

import com.webtoon.webtoonservice.model.User;
import com.webtoon.webtoonservice.repository.EvaluationRepository;
import com.webtoon.webtoonservice.repository.SearchHistoryRepository;
import com.webtoon.webtoonservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EvaluationRepository evaluationRepository;

    @Autowired
    private SearchHistoryRepository searchHistoryRepository;


    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public void deleteUserAndRelatedData(Long userId) {
        // Check if the user exists
        Optional<User> userOptional = userRepository.findById(userId);
        if (!userOptional.isPresent()) {
            throw new UserNotFoundException("User with ID " + userId + " not found");
        }

        // Delete evaluations and search history related to the user
        evaluationRepository.deleteByUserId(userId);
        searchHistoryRepository.deleteByUserId(userId);

        // Finally, delete the user
        userRepository.deleteById(userId);
    }

    // Define a UserNotFoundException
    public static class UserNotFoundException extends RuntimeException {
        public UserNotFoundException(String message) {
            super(message);
        }
    }
}
