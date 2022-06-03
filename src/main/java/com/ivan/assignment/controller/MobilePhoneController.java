package com.ivan.assignment.controller;

import com.ivan.assignment.controller.dto.BookingDto;
import com.ivan.assignment.controller.dto.PhoneDto;
import com.ivan.assignment.service.MobilePhoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class MobilePhoneController {

    private final MobilePhoneService mobilePhoneService;

    @GetMapping
    @RequestMapping("/phones")
    public Flux<PhoneDto> getPhones(@RequestParam(required = false, defaultValue = "true") boolean freeOnly) {
        return mobilePhoneService.getPhones(freeOnly);
    }

    @PostMapping
    @RequestMapping("/phones/{phoneId}")
    public Mono<BookingDto> bookPhone(@PathVariable int phoneId, @RequestParam String userName) {
        return mobilePhoneService.bookPhone(phoneId, userName);
    }

    @DeleteMapping
    @RequestMapping(value = "/phones/{phoneId}", method = RequestMethod.DELETE)
    public Mono<Void> returnPhone(@PathVariable int phoneId) {
        return mobilePhoneService.returnPhone(phoneId);
    }

}
