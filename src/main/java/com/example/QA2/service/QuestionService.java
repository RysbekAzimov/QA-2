package com.example.QA2.service;


import com.example.QA2.entity.Question;

import java.util.List;

public interface QuestionService {
    void createQuestion(String questionText);

    Question readQuestion(Long id);

    List<Question> readAllQuestion();

    void updateQuestion(Long id, String questionText);

    void deleteQuestion(Long id);
}
