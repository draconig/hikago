package com.hikago.services;

import com.hikago.models.Term;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tuannka on 10/6/15.
 */
@Service
public interface ITermService {
    List<Term> listTermsByUser(String username);
    List<Term> listTermsByStudySet(Long studySetId);
}
