package com.springcooler.sgma.openai.dto;

import com.springcooler.sgma.openai.aggregate.Choice;
import com.springcooler.sgma.openai.aggregate.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
public class RequestChatDTO {
    private String model;
    private List<Message> messages;

    public RequestChatDTO(String model, String prompt) {
        this.model = model;
        this.messages =  new ArrayList<>();
        this.messages.add(new Message("user", prompt));
    }
}
