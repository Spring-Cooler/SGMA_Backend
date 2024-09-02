package com.springcooler.sgma.choice.command.domain.repository;

import com.springcooler.sgma.choice.command.domain.aggregate.Choice;
import com.springcooler.sgma.choice.command.domain.aggregate.ChoicePK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChoiceRepository extends JpaRepository<Choice, ChoicePK> {
}
