package com.springcooler.sgma.choice.query.service;

import com.springcooler.sgma.choice.query.dto.ChoiceDTO;
import com.springcooler.sgma.choice.query.repository.ChoiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChoiceServiceImpl implements ChoiceService {

    private final ChoiceMapper choiceMapper;

    @Autowired
    public ChoiceServiceImpl(ChoiceMapper choiceMapper) {
        this.choiceMapper = choiceMapper;
    }
    @Override
    public List<ChoiceDTO> findAllChoices() {
        return choiceMapper.findAllChoices();
    }
}
