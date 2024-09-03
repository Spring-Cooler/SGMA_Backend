package com.springcooler.sgma.choice.command.application.service;

import com.springcooler.sgma.choice.command.application.dto.ChoiceDTO;
import com.springcooler.sgma.choice.command.domain.aggregate.entity.Choice;
import com.springcooler.sgma.choice.command.domain.aggregate.entity.ChoicePK;
import com.springcooler.sgma.choice.command.domain.aggregate.vo.ProblemVO;
import com.springcooler.sgma.choice.command.domain.repository.ChoiceRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
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

    @Transactional
    @Override
    public Choice registChoice(ChoiceDTO newChoiceDTO) {

        ChoicePK choicePK = new ChoicePK(newChoiceDTO.getProblemId(), newChoiceDTO.getChoiceNum());
        Choice choice = new Choice(choicePK, newChoiceDTO.getContent());
        return choiceRepository.save(choice);

    }


    @Transactional
    @Override
    public Choice modifyChoice(ChoiceDTO modifyChoiceDTO) {
        ChoicePK choicePK = new ChoicePK(modifyChoiceDTO.getProblemId(), modifyChoiceDTO.getChoiceNum());
        Choice existingChoice = choiceRepository.findById(choicePK).orElseThrow(EntityNotFoundException::new);
        existingChoice.setContent(modifyChoiceDTO.getContent());
        return choiceRepository.save(existingChoice);
    }


    @Override
    public int registChoices(ProblemVO problemVO) {
        long problemID = problemVO.getProblemId();
        int count = 0;
        for (int i = 0; i < problemVO.getChoices().length; i++) {
            ChoiceDTO choice = new ChoiceDTO(problemID, i+1, problemVO.getChoices()[i]);
            this.registChoice(choice);
            count+=1;
        }
        return count;
    }
}

