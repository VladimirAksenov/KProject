package com.example.kproject.controller;

import com.example.kproject.model.Group;
import com.example.kproject.service.GroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/groups")
public class GroupsController {

    //private static final Logger logger = LoggerFactory.getLogger(GroupsController.class);

    private final GroupService groupService;

    public GroupsController(GroupService groupService) {
        this.groupService = groupService;
    }

    // Get All Group
    @GetMapping
    public List<Group> getAllGroups() {
        return groupService.getAllGroup();
    }

    // Create New Group
    @PostMapping
    public void createGroup(@Valid @RequestBody Group group) {
        groupService.create(group);
    }

    // Search Group By Id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Group> getGroupById(@PathVariable(value = "id") Long groupId) {
        Group group = groupService.getById(groupId);
        return new ResponseEntity<>(group, HttpStatus.OK);
    }

    // Update An Existing Group
    @PutMapping
    public void updateGroup(@Valid @RequestBody Group groupDetails) {
        groupService.update(groupDetails);
    }

    // Delete An Existing Group
    @DeleteMapping("/{id}")
    public ResponseEntity<Group> deleteGroup(@PathVariable(value = "id") Long groupId) {
        groupService.delete(groupId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Search An Existing Group by Amount
    @GetMapping("/search")
    public List<Group> getGroupByAmount(@RequestParam(value = "maxAmount") Long maxAmount) {
        return groupService.getByAmount(maxAmount);
    }

}

