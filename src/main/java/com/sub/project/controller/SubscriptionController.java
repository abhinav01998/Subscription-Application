package com.sub.project.controller;

import com.sub.project.repository.SubscriptionRepository;
import com.sub.project.model.Subscription;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscriptions")
@CrossOrigin(origins = "https://localhost:4200") // This allows Angular access
public class SubscriptionController {
    private final SubscriptionRepository repository;
    public SubscriptionController(SubscriptionRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Subscription> getAllSubscriptions(){
        return repository.findAll();
    }

    @PostMapping
    public Subscription createSubscription(@RequestBody Subscription subscription){
        return repository.save(subscription);
    }

    @DeleteMapping("/{id}")
    public void deleteSubscription(@PathVariable Long id){
        repository.deleteById(id);
    }
}
