package bank;

import com.github.javafaker.Faker;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts;
    private int nextId;

    public Bank() {
        accounts = new ArrayList<>();
        nextId = 1;
    }

    public void loadFromDatabase() {
        Faker faker = new Faker();
        for(int i = 0; i < 50; i++) {
            String name = faker.name().fullName();
            String address = faker.address().fullAddress();
            String phone = faker.phoneNumber().cellPhone();
            addAccount(name, address, phone);
        }
    }

    public void addAccount(String name, String address,
                           String phone) {
        Account account = new Account(nextId, name,
                address, phone);
        nextId++;
        accounts.add(account);
    }

    public Account getAccount(int id) {
        for(Account a : accounts) {
            if(a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    public String addCreditCard(int id) {
        Faker faker = new Faker();
        Account a = getAccount(id);
        if(a != null) {
            a.setCreditCard(faker.business().creditCardNumber());
            return "Success";
        }
        else {
            return "Error, account not found";
        }
    }
}
