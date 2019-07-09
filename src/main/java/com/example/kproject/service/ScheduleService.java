package com.example.kproject.service;

import com.example.kproject.model.Schedule;

import java.util.List;

public interface ScheduleService {

    List<Schedule> getAllById();

    void create(Schedule schedule);

    void update(Schedule schedule);

    void delete(Long id);

    Schedule getScheduleById(Long id);

    List<Schedule> getScheduleByGroup (Long id);

    List<Schedule> getScheduleByTime(String time);

    List<Schedule> getScheduleByTeacher(Long id);

    List<Schedule> getScheduleByLessonId(Long id);

}
