package dev.stocky37.example.core;

import dev.stocky37.example.data.Alias;
import java.util.Optional;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class GreetingService {

	private final AliasRepository aliases;
	private final String template;
	private final String defaultName;

	@Inject
	public GreetingService(
		AliasRepository aliases,
		@ConfigProperty(name = "greeting-template", defaultValue = "Hello, %s!") String template,
		@ConfigProperty(name = "default-name", defaultValue = "World") String defaultName
	) {
		this.aliases = aliases;
		this.template = template;
		this.defaultName = defaultName;
	}

	public String hello() {
		return String.format(template, defaultName);
	}

	public String hello(String name) {
		Optional<Alias> alias = aliases.findByName(name);
		return String.format(template, alias.isPresent() ? alias.get().alias : name);
	}
}
