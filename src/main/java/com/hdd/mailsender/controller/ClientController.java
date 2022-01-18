package com.hdd.mailsender.controller;

import com.hdd.mailsender.dto.ClientSdi;
import com.hdd.mailsender.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping(value = "create")
    public ResponseEntity<Boolean> create(@RequestBody ClientSdi sdi) {
        return ResponseEntity.ok(clientService.created(sdi));
    }
}
