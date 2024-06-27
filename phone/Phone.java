package phone;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Phone {
    public static void main(String[] args) {
        Person person1 = new Person("홍길동");
        person1.addPhoneNumber(new PhoneNumber("010-1234-5678"));
        person1.addPhoneNumber(new PhoneNumber("010-2345-6789"));

        Person person2 = new Person("김철수");
        person2.addPhoneNumber(new PhoneNumber("010-2468-0246"));

        Person person3 = new Person("이영희");
        person3.addPhoneNumber(new PhoneNumber("010-1357-9135"));

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addPerson(person1);
        phoneBook.addPerson(person2);
        phoneBook.addPerson(person3);

        System.out.println(phoneBook.search(new PhoneNumber("01023456789")));
        System.out.println(phoneBook.search(new PhoneNumber("01024680246")));
        System.out.println(phoneBook.search(new PhoneNumber("01013579135")));
        System.out.println(phoneBook.search(new PhoneNumber("01000000000")));
    }

    private static class PhoneBook {
        private final Set<Person> people;

        private PhoneBook() {
            people = new HashSet<>();
        }

        public void addPerson(Person person) {
            this.people.add(person);
        }

        @Override
        public String toString() {
            return "{PhoneBook" + 
                    "people=" + people + 
                    "}";
        }

        public Person search(PhoneNumber number) {
            return this.people.stream()
                    .filter(p -> p.hasPhoneNumber(number))
                    .findFirst()
                    .orElse(null);
        }
    }

    private static class Person {
        public final String name;
        private final List<PhoneNumber> numbers;

        public Person(String name) {
            this.name = name;
            numbers = new ArrayList<>();
        }

        // number가 전화번호 형식이면 추가하고 true 반환
        // 전화번호 형식이 아니면 추가하지 않고 false 반환
        public boolean addPhoneNumber(PhoneNumber number) {
            for (char c : number.toCharArray() ) {
                if (!Character.isDigit(c)) return false;
            }

            numbers.add(number);
            return true;
        }

        @Override
        public String toString() {
            return "Person{" + 
                    "name='" + name + '\'' +
                    ", numbers='" + numbers + '\'' +
                    '}';
        }

        public boolean hasPhoneNumber(PhoneNumber number) {
            return this.numbers.contains(number);
        }
    }

    private static class PhoneNumber {
        public final String phoneNumber;

        public PhoneNumber(String rawPhoneNumber) {
            this.phoneNumber = rawPhoneNumber.replaceAll("[^0-9]", "");
        }

        @Override
        public String toString() {
            return "PhoneNumber{" + 
                    "phoneNumber='" + phoneNumber + '\'' + '}';
        }

        public char[] toCharArray() {
            char[] list = new char[this.phoneNumber.length()];
            for (int i = 0; i < list.length; i++) {
                list[i] = this.phoneNumber.charAt(i);
            }
            return list;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof PhoneNumber)) return false;
            return this.phoneNumber.equals(((PhoneNumber) o).phoneNumber);
        }
    }
}
