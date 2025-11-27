package apps.ucu.ooad.task2;

import java.util.concurrent.atomic.AtomicInteger;

public class Client {
	private static final AtomicInteger ID_SEQUENCE = new AtomicInteger();

	private final int id;
	private final String name;
	private final int age;
	private final Gender gender;

	public Client(String name, int age, Gender gender) {
		this.id = ID_SEQUENCE.getAndIncrement();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	static void resetIdSequenceForTests() {
		ID_SEQUENCE.set(0);
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public Gender getGender() {
		return gender;
	}
}
