package de.codecentric.batch.job;
import org.springframework.batch.item.ItemProcessor;

import com.newrelic.api.agent.Trace;

public class PersonItemProcessor implements ItemProcessor<Person, Person> {

    @Override
    @Trace(dispatcher=true)
    public Person process(final Person person) throws Exception {
        final String firstName = person.getFirstName().toUpperCase();
        final String lastName = person.getLastName().toUpperCase();

        final Person transformedPerson = new Person(firstName, lastName);

        System.out.println("Converting (" + person + ") into (" + transformedPerson + ")");

        return transformedPerson;
    }

}