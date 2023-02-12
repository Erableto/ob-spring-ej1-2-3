package com.example.obspringej123;

import com.example.obspringej123.entities.Laptop;
import com.example.obspringej123.repositories.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ObSpringEj123Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ObSpringEj123Application.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);

		// Creamos ordenadores para que salgan en la base de datos.
		Laptop laptop1 = new Laptop(null, "Lenovo", "Legion Y540-15IRH-PG0", "16 GB", "1 TB", 1100.0, 2020);
		Laptop laptop2 = new Laptop(null, "Acer", "Aspire 3 A315", "8 GB", "512 GB", 473.15, 2020);

		repository.save(laptop1);
		repository.save(laptop2);

		System.out.println("Número de ordenadores en base de datos: " + repository.findAll().size());
	}

}
