package com.example.QA2.service.impl;

import com.example.QA2.entity.Answer;
import com.example.QA2.repository.AnswerRepository;
import com.example.QA2.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {
    private AnswerRepository answerRepository;

    @Autowired
    public AnswerServiceImpl(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public void createAnswer(String answerText) {
        Answer answer = new Answer();
        answer.setText(answerText);
        answerRepository.save(answer);
    }

    public  List<Answer> readAllAnswer() {
        List<Answer> answers = answerRepository.findAll();
        answers.sort(Comparator.comparingLong(Answer::getId));
        for (Answer answer : answers) {
            String result = answer.getId() + ", Результат: " + answer.getText();
            System.out.println(result);
        }
        return answers;
    }

    public void updateAnswer(Long Id, String answerText) {
        Answer answer = answerRepository.findById(Id)
                .orElseThrow(()->new RuntimeException("Результат с ID " + Id + " Не найдено."));
        answer.setText(answerText);
        answerRepository.save(answer);
    }
    public void deleteAnswer(Long Id) {
        Answer answer = answerRepository.findById(Id)
                .orElseThrow(()-> new RuntimeException("Результат с ID " + Id + " Не найдено."));
        answerRepository.delete(answer);
    }
}