package com.springcooler.sgma.choice.command.application.service;

import com.springcooler.sgma.choice.command.application.dto.ChoiceDTO;
import com.springcooler.sgma.choice.command.domain.aggregate.Choice;
import com.springcooler.sgma.choice.command.domain.aggregate.ChoicePK;
import com.springcooler.sgma.choice.command.domain.repository.ChoiceRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AppChoiceServiceImpl implements AppChoiceService {

    private final ChoiceRepository choiceRepository;

    @Autowired
    public AppChoiceServiceImpl(ChoiceRepository choiceRepository) {
        this.choiceRepository = choiceRepository;
    }

    @Override
    public Choice registChoice(ChoiceDTO newChoiceDTO) {

        ChoicePK choicePK = new ChoicePK(newChoiceDTO.getProblemId(), newChoiceDTO.getChoiceNum());
        Choice choice = new Choice(choicePK, newChoiceDTO.getContent());
        return choiceRepository.save(choice);

    }



    @Override
    public Choice modifyChoice(ChoiceDTO modifyChoiceDTO) {
        ChoicePK choicePK = new ChoicePK(modifyChoiceDTO.getProblemId(), modifyChoiceDTO.getChoiceNum());
        Choice existingChoice = choiceRepository.findById(choicePK).orElseThrow(EntityNotFoundException::new);
        existingChoice.setContent(modifyChoiceDTO.getContent());
        return choiceRepository.save(existingChoice);
    }
}
