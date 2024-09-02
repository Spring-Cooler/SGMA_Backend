package com.springcooler.sgma.choice.query.service;

import com.springcooler.sgma.choice.query.dto.ChoiceDTO;

import java.util.List;

public interface ChoiceService {
    List<ChoiceDTO> findAllChoices();
}
