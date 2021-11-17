package dev.stocky37.example.core;

import dev.stocky37.example.data.Alias;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import java.util.Optional;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AliasRepository implements PanacheRepository<Alias> {

	public Optional<Alias> findByName(String name) {
		return find("from Alias where name = ?1", name).stream().findFirst();
	}
}
