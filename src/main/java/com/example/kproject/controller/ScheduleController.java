package com.example.kproject.controller;


import com.example.kproject.model.Schedule;
import com.example.kproject.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/schedule")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    // Get Whole Schedule
    @GetMapping
    public List<Schedule> getWholeSchedule() {
        return scheduleService.getAllById();
    }

    // Create New Schedule
    @PostMapping
    public void createSchedule(@Valid @RequestBody Schedule schedule) {
        scheduleService.create(schedule);
    }

    // Update An Existing Schedule
    @PutMapping
    public void updateSchedule(@Valid @RequestBody Schedule scheduleDetails) {
        scheduleService.update(scheduleDetails);
    }

    // Delete An Existing Schedule
    @DeleteMapping("/{id}")
    public ResponseEntity<Schedule> deleteSchedule(@PathVariable(value = "id") Long scheduleId) {
        scheduleService.delete(scheduleId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Get An Existing Schedule By Schedule Id (Id = Day)
    @GetMapping("/{id}")
    public ResponseEntity<Schedule> getScheduleById(@PathVariable(value = "id") Long scheduleId) {
        Schedule schedule = scheduleService.getScheduleById(scheduleId);
        return new ResponseEntity<>(schedule, HttpStatus.OK);
    }

    // Get An Existing Schedule By Group's Id
    @GetMapping("/search/gId")
    public List<Schedule> getScheduleByGroupId(@RequestParam(value = "id") Long groupId) {
        return scheduleService.getScheduleByGroup(groupId);
    }

    // Get An Existing Schedule By Schedule Time (Time Type - String)
    @GetMapping("/search/time")
    public List<Schedule> getScheduleByTime(@RequestParam(value = "time") String scheduleTime) {
        return scheduleService.getScheduleByTime(scheduleTime);
    }

    // Get An Existing Schedule By Teacher's Id
    @GetMapping("/search/tId")
    public List<Schedule> getScheduleByTeacherId(@RequestParam(value = "id") Long teacherId) {
        return scheduleService.getScheduleByTeacher(teacherId);
    }

    // Get An Existing Schedule By Lessons's Id
    @GetMapping("/search/lId")
    public List<Schedule> getScheduleByLessonId(@RequestParam(value = "id") Long lessonId) {
        return scheduleService.getScheduleByLessonId(lessonId);
    }
}
