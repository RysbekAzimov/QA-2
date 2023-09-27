package com.example.QA2.repository;

import com.example.QA2.entity.User;
import com.example.QA2.entity.UserQuestionnaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserQuestionnaireRepository extends JpaRepository<UserQuestionnaire, Long> {
    List<UserQuestionnaire> findByUser(User user);
}
