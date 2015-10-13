package com.hikago.services;

import com.hikago.models.StudySet;
import org.springframework.stereotype.Service;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Parent;

import java.util.List;

/**
 * Created by tuannka on 10/5/15.
 */
@Service
public interface IStudySetService {
    List<StudySet> listStudySetsByUser(String username);
    Boolean addNewStudySet(String name, String username);
    Boolean deleteStudySet(Long id);
    Boolean editStudySet(Long id, String name);
}
