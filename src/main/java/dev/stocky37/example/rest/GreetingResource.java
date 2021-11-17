package dev.stocky37.example.rest;

import dev.stocky37.example.api.GreetingApi;
import dev.stocky37.example.core.GreetingService;
import dev.stocky37.example.json.Greeting;
import javax.inject.Inject;

public class GreetingResource implements GreetingApi {

	private final GreetingService greetings;

	@Inject
	public GreetingResource(GreetingService greetings) {
		this.greetings = greetings;
	}

	@Override
	public Greeting hello() {
		return new Greeting(greetings.hello());
	}

	@Override
	public Greeting hello(String name) {
		return new Greeting(greetings.hello(name));
	}
}
