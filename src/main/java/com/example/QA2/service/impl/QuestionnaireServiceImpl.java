package com.example.QA2.service.impl;

import com.example.QA2.entity.Questionnaire;
import com.example.QA2.repository.QuestionnaireRepository;
import com.example.QA2.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.Comparator;
import java.util.List;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {
    @Autowired
    private QuestionnaireRepository questionnaireRepository;

    public QuestionnaireRepository getQuestionnaireRepository() {
        return questionnaireRepository;
    }

    @Override
    public void createQuestionnaire(String name, Type type) {
        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setName(name);
        questionnaire.setType(type);
        questionnaireRepository.save(questionnaire);
    }

    @Override
    public Questionnaire readQuestionnaire(Long id) {
        Questionnaire questionnaire = questionnaireRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Вопросник с id " + id + " не найден"));
        System.out.println(questionnaire.toString());
        return questionnaire;
    }

    @Override
    public List<Questionnaire> readAllQuestionnaire() {
        List<Questionnaire> questionnaires = questionnaireRepository.findAll();
        questionnaires.sort(Comparator.comparingLong(Questionnaire::getId));
        for (Questionnaire questionnaire : questionnaires) {
            String result = questionnaire.getId() + ", Название вопросника: " + questionnaire.getName() + "\n";
            System.out.println(result);
        }
        return questionnaires;
    }

    @Override
    public void updateQuestionnaire(Long id, String name) {
        Questionnaire questionnaire = questionnaireRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Вопросник с id " + id + " не найден"));
        questionnaire.setName(name);
        questionnaireRepository.save(questionnaire);
    }

    @Override
    public void deleteQuestionnaire(Long id) {
        Questionnaire questionnaire = questionnaireRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Вопросник с id " + id + " не найден"));
        questionnaireRepository.delete(questionnaire);
    }
}
