package com.hikago.services;

import com.googlecode.objectify.ObjectifyService;
import com.hikago.models.StudySet;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by tuannka on 10/5/15.
 */
@Service
public class StudySetService implements IStudySetService {

    private static Logger logger = Logger.getLogger(StudySetService.class);

    @Override
    public List<StudySet> listStudySetsByUser(String username) {
        logger.info("----- Run getStudySetsByUser -----");
        try {
            List<StudySet> studySetList = ObjectifyService.ofy().load().type(StudySet.class).list();
            return studySetList;
        } catch (Exception e) {
            logger.error("----- Error at getStudySetsByUser -----");
            logger.error(e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public Boolean addNewStudySet(String name, String username) {
        logger.info("----- Run addNewStudySet -----");
        try {
            StudySet studySet = new StudySet(name, username);
            ObjectifyService.ofy().save().entity(studySet).now();
            return true;
        } catch (Exception e) {
            logger.error("----- Error at addNewStudySet -----");
            logger.error(e.getMessage());
            return false;
        }
    }

    @Override
    public Boolean deleteStudySet(Long id) {
        logger.info("----- Run deleteStudySet -----");
        try {
            ObjectifyService.ofy().delete().type(StudySet.class).id(id).now();
            return true;
        } catch (Exception e) {
            logger.error("----- Error at deleteStudySet -----");
            logger.error(e.getMessage());
            return false;
        }
    }

    @Override
    public Boolean editStudySet(Long id, String name) {
        logger.info("----- Run editStudySet -----");
        try {
            StudySet studySet = ObjectifyService.ofy().load().type(StudySet.class).id(id).now();
            studySet.setName(name);
            studySet.setLastUpdate(new Date());
            ObjectifyService.ofy().save().entity(studySet).now();
            return true;
        } catch (Exception e) {
            logger.error("----- Error at editStudySet -----");
            logger.error(e.getMessage());
            return false;
        }
    }
}
