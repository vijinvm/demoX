package com.example.demoX;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantService {
 @Autowired
 private MerchantRepository merchantRepository;
 
 public List<Merchant> getAllMerchants() {
     return merchantRepository.findAll();
 }
 
 public Merchant addMerchant(Merchant merchant) {
     return merchantRepository.save(merchant);
 }
 public Optional<Merchant> getMerchantById(Long id) {
     return merchantRepository.findById(id);
 }
 
 public void deleteMerchant(Long id) {
     merchantRepository.deleteById(id);
 }
}



