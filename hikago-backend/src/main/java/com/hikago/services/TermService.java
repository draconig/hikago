package com.hikago.services;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;
import com.hikago.models.StudySet;
import com.hikago.models.Term;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by tuannka on 10/6/15.
 */
@Service
public class TermService implements ITermService {

    private static Logger logger = Logger.getLogger(StudySetService.class);

    @Override
    public List<Term> listTermsByUser(String username) {
        logger.info("----- Run listTermsByUser -----");
        try {
            List<StudySet> studySetList = ObjectifyService.ofy().load().type(StudySet.class).filter("username", username).list();

            List<Term> termList = new ArrayList<>();
            for(StudySet studySet : studySetList) {
                Key<StudySet> setKey = Key.create(StudySet.class, studySet.getId());
                termList.addAll(ObjectifyService.ofy().load().type(Term.class).ancestor(setKey).list());
            }

            return termList;
        } catch (Exception e) {
            logger.error("----- Error at listTermsByUser -----");
            logger.error(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Term> listTermsByStudySet(Long studySetId) {
        logger.info("----- Run listTermsByUser -----");
        try {
            Key<StudySet> setKey = Key.create(StudySet.class, studySetId);
            return ObjectifyService.ofy().load().type(Term.class).ancestor(setKey).list();
        } catch (Exception e) {
            logger.error("----- Error at listTermsByUser -----");
            logger.error(e.getMessage());
            return null;
        }
    }
}
