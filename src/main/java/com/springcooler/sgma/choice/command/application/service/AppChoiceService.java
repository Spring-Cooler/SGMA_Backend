package com.springcooler.sgma.choice.command.application.service;


import com.springcooler.sgma.choice.command.application.dto.ChoiceDTO;
import com.springcooler.sgma.choice.command.domain.aggregate.Choice;

public interface AppChoiceService {
    Choice registChoice(ChoiceDTO newChoiceDTO);
    Choice modifyChoice(ChoiceDTO modifyChoiceDTO);


}
