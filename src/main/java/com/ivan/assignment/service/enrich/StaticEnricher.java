package com.ivan.assignment.service.enrich;

import com.ivan.assignment.repository.model.Phone;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class StaticEnricher implements Enricher {

    public static final String APPLE = "apple";
    public static final String NOKIA = "nokia";
    public static final String SAMSUNG = "samsung";

    @Override
    public Mono<Phone> enrich(Phone phone) {
        enrichTechnology(phone);
        enrichBand(phone);

        return Mono.just(phone);
    }

    private void enrichTechnology(Phone phone) {
        if (phone.getDeviceName().toLowerCase().contains(APPLE)) {
            phone.setTechnology(Phone.Technology.IOS);
        } else if (phone.getDeviceName().toLowerCase().contains(NOKIA)) {
            phone.setTechnology(Phone.Technology.WINDOWS);
        } else if (phone.getDeviceName().toLowerCase().contains(SAMSUNG)) {
            phone.setTechnology(Phone.Technology.ANDROID);
        } else {
            phone.setTechnology(Phone.Technology.UNKNOWN);
        }
    }

    private void enrichBand(Phone phone) {
        if (phone.getDeviceName().toLowerCase().contains("apple")) {
            phone.set_2gBands("1000Mz, 2000Mz");
            phone.set_3gBands("1000Mz, 3000Mz");
            phone.set_4gBands("1000Mz, 3000Mz, 4000Mz");
        } else if (phone.getDeviceName().toLowerCase().contains("nokia")) {
            phone.set_2gBands("1000Mz, 2000Mz");
            phone.set_3gBands("1000Mz, 2000Mz, 3000Mz");
            phone.set_4gBands("1000Mz, 2000Mz, 3000Mz, 4000Mz");
        } else if (phone.getDeviceName().toLowerCase().contains("samsung")) {
            phone.set_2gBands("1000Mz, 2000Mz");
            phone.set_3gBands("1000Mz, 2000Mz");
            phone.set_4gBands("1000Mz, 2000Mz");
        } else {
            phone.set_2gBands("1000Mz");
            phone.set_3gBands("2000Mz");
            phone.set_4gBands("3000Mz");
        }
    }

}
