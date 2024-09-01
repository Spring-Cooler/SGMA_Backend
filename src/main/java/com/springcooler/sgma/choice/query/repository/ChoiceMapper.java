package com.springcooler.sgma.choice.query.repository;

import com.springcooler.sgma.choice.query.dto.ChoiceDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChoiceMapper {
    ChoiceDTO findChoiceById(Long problemChoiceId);
}
