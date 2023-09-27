package com.example.QA2.service;

import com.example.QA2.entity.User;
import com.example.QA2.entity.UserQuestionnaire;

import java.util.List;

public interface UserQuestionnaireService {
    List<UserQuestionnaire> getUserQuestionnairesByUser(User user);

    UserQuestionnaire getUserQuestionnaireById(Long id);
}
