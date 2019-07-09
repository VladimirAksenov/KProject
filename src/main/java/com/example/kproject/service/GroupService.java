package com.example.kproject.service;

import com.example.kproject.model.Group;

import java.util.List;

public interface GroupService {

    List<Group> getAllGroup();

    void create(Group group);

    void update(Group group);

    void delete(Long groupId);

    Group getById(Long id);

    List<Group> getByAmount(Long maxAmountCount);
}
