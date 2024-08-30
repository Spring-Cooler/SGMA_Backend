package com.springcooler.sgma.studygroupcategory.command.domain.repository;

import com.springcooler.sgma.studygroupnotice.command.domain.aggregate.StudyGroupNotice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyGroupCategoryRepository extends JpaRepository<StudyGroupNotice, Long> {
}
