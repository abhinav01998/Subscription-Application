package com.sub.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.sub.project.repository.SubscriptionRepository;
import com.sub.project.model.Subscription;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import java.time.LocalDate;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(SubscriptionRepository repository) {
		return args -> {
			// Only seed if the database is empty
			if (repository.count() == 0) {
				Subscription sub1 = new Subscription();
				sub1.setServiceName("Netflix");
				sub1.setPrice(15.99);
				sub1.setCurrency("USD");
				sub1.setPaymentPeriod("MONTHLY");
				sub1.setNextRenewalDate(LocalDate.now().plusDays(3)); // This will trigger our alert logic later!

				Subscription sub2 = new Subscription();
				sub2.setServiceName("Spotify");
				sub2.setPrice(9.99);
				sub2.setCurrency("USD");
				sub2.setPaymentPeriod("MONTHLY");
				sub2.setNextRenewalDate(LocalDate.now().plusWeeks(2));

				repository.save(sub1);
				repository.save(sub2);

				System.out.println("---------------------------------");
				System.out.println("Data Seeder: Added 2 Subscriptions");
				System.out.println("---------------------------------");
			}
		};
	}
}
