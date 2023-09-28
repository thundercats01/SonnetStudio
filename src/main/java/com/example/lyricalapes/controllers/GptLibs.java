package com.gptlibs.fullstackgptlibs.controllers;

import com.theokanning.openai.completion.chat.*;
import com.theokanning.openai.service.OpenAiService;

import java.util.ArrayList;
import java.util.List;

public class GptLibs {
    public static String genStory(String noun, String verb, String adj, String adv) {

        OpenAiService service = new OpenAiService(Auth.Token);

//        chat context
        List<ChatMessage> messages = new ArrayList<>();

        String promptString = String.format("#write a wacky silly one paragraph story replacing some nouns with %s, some adjs with %s, some advs with %s and some verbs with %s", noun, adj, adv, verb);

        ChatMessage userMessage = new ChatMessage(ChatMessageRole.USER.value(), promptString);
        messages.add(userMessage);

//        api options
        ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest
                .builder()
                .model("gpt-3.5-turbo-0613")
                .messages(messages)
                .maxTokens(256)
                .build();

//        get response
        ChatMessage responseMessage = service.createChatCompletion(chatCompletionRequest).getChoices().get(0).getMessage();

        return responseMessage.getContent();
    }
}
