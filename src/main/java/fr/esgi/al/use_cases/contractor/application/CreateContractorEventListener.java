package fr.esgi.al.use_cases.contractor.application;

import fr.esgi.al.kernel.EventListener;

public class CreateContractorEventListener implements EventListener<CreateContractorEvent> {
    @Override
    public void listenTo(CreateContractorEvent createContractorEvent) {
        System.out.println("listening CreateContractorEvent.");
    }
}
