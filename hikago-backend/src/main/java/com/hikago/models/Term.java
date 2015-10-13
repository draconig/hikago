package com.hikago.models;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Parent;

/**
 * Created by tuannka on 10/5/15.
 */
@Entity
public class Term {

    @Parent Key<StudySet> studySetKey;
    @Id @Index public Long id;
    public String word;
    public String definition;

    public Term(Key<StudySet> studySetKey, String word, String definition) {
        this.studySetKey = studySetKey;
        this.word = word;
        this.definition = definition;
    }

    public Term(Long studySetId, String word, String definition) {
        this.studySetKey = Key.create(StudySet.class, studySetId);
        this.word = word;
        this.definition = definition;
    }

    public Key<StudySet> getStudySetKey() {
        return studySetKey;
    }

    public void setStudySetKey(Key<StudySet> studySetKey) {
        this.studySetKey = studySetKey;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }
}
