package com.springcooler.sgma.choice.command.application.service;


import com.springcooler.sgma.choice.command.application.dto.ChoiceDTO;
import com.springcooler.sgma.choice.command.domain.aggregate.entity.Choice;
import com.springcooler.sgma.choice.command.domain.aggregate.vo.ProblemVO;

public interface AppChoiceService {
    Choice registChoice(ChoiceDTO newChoiceDTO);
    Choice modifyChoice(ChoiceDTO modifyChoiceDTO);
    int registChoices(ProblemVO problemVO);

}
