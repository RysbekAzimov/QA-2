package com.example.QA2.service.impl;

import com.example.QA2.entity.Questionnaire;
import com.example.QA2.entity.User;
import com.example.QA2.entity.UserQuestionnaire;
import com.example.QA2.repository.UserQuestionnaireRepository;
import com.example.QA2.service.UserQuestionnaireService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserQuestionnaireServiceImpl implements UserQuestionnaireService {
    @Autowired
    public  UserQuestionnaireRepository userQuestionnaireRepository;

    public void createUserQuestionnaire (Questionnaire questionnaire, User user){
        UserQuestionnaire userQuestionnaire = new UserQuestionnaire();
        userQuestionnaire.setUser(user);
        userQuestionnaire.setQuestionnaire(questionnaire);
        userQuestionnaireRepository.save(userQuestionnaire);
    }
    @Override
    public List<UserQuestionnaire> getUserQuestionnairesByUser(User user) {
        return userQuestionnaireRepository.findByUser(user);
    }
    @Override
    public UserQuestionnaire getUserQuestionnaireById(Long id) {
        return userQuestionnaireRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Пользовательский вопросник не найден по id: " + id));
    }
}
