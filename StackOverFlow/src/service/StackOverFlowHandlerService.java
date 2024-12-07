package service;

import model.Questions;

import java.util.HashMap;
import java.util.Map;

public class StackOverFlowHandlerService {

    public static StackOverFlowHandlerService stackOverFlowHandlerService;
    private final Map<Integer, Questions> questionsMap;

    public StackOverFlowHandlerService() {
        questionsMap = new HashMap<>();
    }

    public StackOverFlowHandlerService getStackOverFlowHandlerService() {
        if (stackOverFlowHandlerService == null) {
            stackOverFlowHandlerService = new StackOverFlowHandlerService();
        }
        return stackOverFlowHandlerService;
    }

    public void searchQuestion() {

    }

    public void addQuestion(Questions questions) {
        questionsMap.put(questions.getId(), questions);
    }
}
