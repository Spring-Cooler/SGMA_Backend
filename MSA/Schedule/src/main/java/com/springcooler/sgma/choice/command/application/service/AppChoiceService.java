package com.springcooler.sgma.choice.command.application.service;


import com.springcooler.sgma.choice.command.application.dto.ChoiceDTO;
import com.springcooler.sgma.choice.command.domain.aggregate.vo.ProblemVO;

public interface AppChoiceService {
    ProblemVO registChoices(ProblemVO problemVO);

}
