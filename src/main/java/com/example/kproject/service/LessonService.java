package com.example.kproject.service;

import com.example.kproject.model.Lesson;

import java.util.List;

public interface LessonService {

    List<Lesson> getAllLessons();

    void create(Lesson lesson);

    void update(Lesson lesson);

    void delete(Long lessonId);

    Lesson getById(Long id);

    List<Lesson> getAllLessonsByName(String name);

}
