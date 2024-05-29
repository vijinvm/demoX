package com.example.demoX;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/merchants")
public class MerchantController {
    @Autowired
    private MerchantService merchantService;

    @PostMapping
    public ResponseEntity<Merchant> addMerchant(@RequestBody Merchant merchant) {
        Merchant newMerchant = merchantService.addMerchant(merchant);
        return new ResponseEntity<>(newMerchant, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Merchant>> getAllMerchants() {
        List<Merchant> merchants = merchantService.getAllMerchants();
        return new ResponseEntity<>(merchants, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Merchant> getMerchantById(@PathVariable Long id) {
        Optional<Merchant> merchant = merchantService.getMerchantById(id);
        return merchant.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                       .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMerchant(@PathVariable Long id) {
        merchantService.deleteMerchant(id);
        return ResponseEntity.ok().body("Deleted successful");
    }
}
