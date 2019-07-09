package com.example.kproject.controller;


import com.example.kproject.model.Lesson;
import com.example.kproject.service.LessonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/lessons")
public class LessonsController {

    private final LessonService lessonService;

    public LessonsController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    //Get All Lessons
    @GetMapping
    public List<Lesson> getAllLessons() {
        return lessonService.getAllLessons();
    }

    // Create New Lesson
    @PostMapping
    public void createLesson(@Valid @RequestBody Lesson lesson) {
        lessonService.create(lesson);
    }

    // Update An Existing Lesson
    @PutMapping
    public void updateLesson(@Valid @RequestBody Lesson lessonDetails) {
        lessonService.update(lessonDetails);
    }

    // Delete An Existing Lesson
    @DeleteMapping("/{id}")
    public ResponseEntity<Lesson> deleteLesson(@PathVariable(value = "id") Long lessonId) {
        lessonService.delete(lessonId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Search Lesson By Id
    @GetMapping("/search/id")
    public ResponseEntity<Lesson> getLessonById(@RequestParam(value = "id") Long lessonId) {
        Lesson lesson = lessonService.getById(lessonId);
        return new ResponseEntity<>(lesson, HttpStatus.OK);
    }

    // Search Lesson By Name
    @GetMapping("/search/name")
    public List<Lesson> getLessonByName(@RequestParam(value = "name") String lessonName) {
        return lessonService.getAllLessonsByName(lessonName);
    }
}
