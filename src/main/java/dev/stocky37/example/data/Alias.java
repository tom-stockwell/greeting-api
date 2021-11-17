package dev.stocky37.example.data;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="aliases")
public class Alias extends PanacheEntityBase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	@NotEmpty
	public String name;

	@NotEmpty
	public String alias;

	@PrePersist
	public void lowercaseKeys() {
		this.name = this.name.toLowerCase();
	}

	public String toString() {
		return this.getClass().getSimpleName() + "<" + this.id + ">";
	}
}
