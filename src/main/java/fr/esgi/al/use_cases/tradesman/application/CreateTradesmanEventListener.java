package fr.esgi.al.use_cases.tradesman.application;

import fr.esgi.al.kernel.EventListener;

public class CreateTradesmanEventListener implements EventListener<CreateTradesmanEvent> {
    @Override
    public void listenTo(CreateTradesmanEvent createTradesmanEvent) {
        System.out.println("listening CreateTradesmanEvent.");
    }
}
