package com.example.QA2.service.impl;
import com.example.QA2.entity.Question;
import com.example.QA2.repository.QuestionRepository;
import com.example.QA2.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    public QuestionRepository questionRepository;

    public QuestionRepository getQuestionRepository() {
        return questionRepository;
    }

    @Override
    public void createQuestion(String questionText) {
        Question question = new Question();
        question.setText(questionText);
        questionRepository.save(question);
    }

    @Override
    public Question readQuestion(Long id) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Вопросник с id " + id + " не найдено"));
        System.out.println(question.toString());
        return question;
    }

    @Override
    public List<Question> readAllQuestion() {
        List<Question> question = questionRepository.findAll();
        question.sort(Comparator.comparingLong(Question::getId));
        return question;
    }

    @Override
    public void updateQuestion(Long id, String questionText) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Вопросник с id " + id + " не найдено"));
        question.setText(questionText);
        questionRepository.save(question);
    }

    @Override
    public void deleteQuestion(Long id) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Вопросник с id " + id + " не найдено"));
        questionRepository.delete(question);
    }
}
