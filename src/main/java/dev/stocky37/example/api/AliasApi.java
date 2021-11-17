package dev.stocky37.example.api;

import dev.stocky37.example.core.AliasRepository;
import dev.stocky37.example.data.Alias;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheRepositoryResource;
import io.quarkus.rest.data.panache.ResourceProperties;

@ResourceProperties(path = "aliases")
public interface AliasApi extends PanacheRepositoryResource<AliasRepository, Alias, Long> {}
