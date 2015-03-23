package de.codecentric.batch.job;

import org.springframework.batch.item.ItemProcessor;

public class PersonItemProcessor implements ItemProcessor<Person, Person> {

	@Override
	public Person process(final Person person) throws Exception {

		System.out.println(Thread.currentThread().getName());

		final String firstName = person.getFirstName().toUpperCase();
		final String lastName = person.getLastName().toUpperCase();

		final Person transformedPerson = new Person(firstName, lastName);

		System.out.println("Converting (" + person + ") into (" + transformedPerson + ")");
		if (true)
			throw new MyProcessException();
		return transformedPerson;
	}

}