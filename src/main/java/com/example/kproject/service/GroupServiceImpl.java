package com.example.kproject.service;

import com.example.kproject.exception.NoRecordFoundException;
import com.example.kproject.exception.NoRecordFoundToDelete;
import com.example.kproject.exception.NoRecordFoundToUpdate;
import com.example.kproject.model.Group;
import com.example.kproject.repository.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService {

    //private static final Logger logger = LoggerFactory.getLogger(GroupServiceImpl.class);

    private final GroupRepository groupRepository;

    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public List<Group> getAllGroup() {
        List<Group> groups = groupRepository.findAll();
        if (groups == null || groups.isEmpty()) {
            throw new NoRecordFoundException("Groups Have Not Been Created Yet");
        } else {
            return groups;
        }
    }

    @Override
    public void create(Group group) {
        groupRepository.save(group);
    }

    @Override
    public void update(Group group) {
        Optional<Group> founded = groupRepository.findById(group.getId());
        if (founded.isPresent()) {
            groupRepository.save(group);
        } else {
            throw new NoRecordFoundToUpdate("There Is No Group With Id = " + group.getId());
        }
    }

    @Override
    public void delete(Long groupId) {
        Optional founded = groupRepository.findById(groupId);
        if (founded.isPresent()) {
            groupRepository.deleteById(groupId);
        } else {
            throw new NoRecordFoundToDelete("There Is No Group With Id = " + groupId);
        }
    }

    @Override
    public Group getById(Long id) {
        //logger.debug("Trying to find group by id = {}", id);
        Optional optional = groupRepository.findById(id);
        if (optional.isPresent()) {
            return (Group) optional.get();
        } else {
            throw new NoRecordFoundException("Group Not Found With Id = " + id);
        }
    }

    @Override
    public List<Group> getByAmount(Long maxAmountCount) {
        List<Group> groups = groupRepository.findAllByMaxAmount(maxAmountCount);
        if (groups == null || groups.isEmpty()) {
            throw new NoRecordFoundException("Group Not Found With Max Amount = " + maxAmountCount);
        } else {
            return groups;
        }
    }
}
