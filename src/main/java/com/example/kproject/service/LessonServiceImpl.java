package com.example.kproject.service;

import com.example.kproject.exception.NoRecordFoundException;
import com.example.kproject.exception.NoRecordFoundToDelete;
import com.example.kproject.exception.NoRecordFoundToUpdate;
import com.example.kproject.model.Lesson;
import com.example.kproject.repository.LessonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;

    public LessonServiceImpl(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }


    @Override
    public List<Lesson> getAllLessons() {
        List<Lesson> lessons = lessonRepository.findAll();
        if (lessons == null || lessons.isEmpty()) {
            throw new NoRecordFoundException("Lessons Have Not Been Created Yet");
        } else {
            return lessons;
        }
    }

    @Override
    public void create(Lesson lesson) {
        lessonRepository.save(lesson);
    }

    @Override
    public void update(Lesson lesson) {
        Optional<Lesson> founded = lessonRepository.findById(lesson.getId());
        if (founded.isPresent()) {
            lessonRepository.save(lesson);
        } else {
            throw new NoRecordFoundToUpdate("There Is No Group With iD = " + lesson.getId());
        }
    }

    @Override
    public void delete(Long lessonId) {
        Optional<Lesson> founded = lessonRepository.findById(lessonId);
        if (founded.isPresent()) {
            lessonRepository.deleteById(lessonId);
        } else {
            throw new NoRecordFoundToDelete("There Is No Lesson With Id = " + lessonId);
        }
    }

    @Override
    public Lesson getById(Long id) {
        Optional optional = lessonRepository.findById(id);
        if (optional.isPresent()) {
            return (Lesson) optional.get();
        } else {
            throw new NoRecordFoundException("Lesson Not Found With Id = " + id);
        }
    }

    @Override
    public List<Lesson> getAllLessonsByName(String name) {
        List<Lesson> lessons = lessonRepository.getAllLessonsByName(name);
        if (lessons == null || lessons.isEmpty()) {
            throw new NoRecordFoundException("Not Found Lesson With Name = " + name);
        } else {
            return lessons;
        }
    }
}
