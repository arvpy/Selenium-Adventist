package utilities;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;

public class FakerUtility {
	Faker faker = new Faker();

	public String getFirstName() {
		return faker.name().fullName();
	}

	public String getPassword() {
		return faker.internet().password();
	}

	public Address getAddress() {
		return faker.address();
	}
	public String getEmail() {
		return faker.internet().emailAddress(getFirstName());
	}
	public PhoneNumber getPhone() {
		return faker.phoneNumber();
	}
}
