package com.example.QA2.service;


import com.example.QA2.entity.Questionnaire;

import java.lang.reflect.Type;
import java.util.List;

public interface QuestionnaireService {

    void createQuestionnaire(String name, Type type);

    Questionnaire readQuestionnaire(Long id);

    List<Questionnaire> readAllQuestionnaire();

    void updateQuestionnaire(Long id, String name);

    void deleteQuestionnaire(Long id);
}
