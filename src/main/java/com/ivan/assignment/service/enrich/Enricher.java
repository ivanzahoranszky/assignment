package com.ivan.assignment.service.enrich;

import com.ivan.assignment.repository.model.Phone;
import reactor.core.publisher.Mono;

public interface Enricher {

    Mono<Phone> enrich(Phone phone);

}
