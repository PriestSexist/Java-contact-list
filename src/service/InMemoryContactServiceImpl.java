package service;

import model.Contact;
import util.Managers;
import repository.ContactRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class InMemoryContactService {
    ContactRepository contactRepository = Managers.getDefaultContactRepository();
    HashMap<Integer, Contact> contacts = contactRepository.getContacts();
    AtomicInteger counter = new AtomicInteger(0);
    public Contact postContact(Contact contact) {
        contacts.put(counter.incrementAndGet(), contact);
        return contact;
    }

    public HashMap<Integer, Contact> getAllContacts() {
        return contacts;
    }

    public List<Contact> getContactsByName(String name) {
        return contacts.values().stream().filter(contact -> contact.getName().equals(name)).collect(Collectors.toList());
    }

    public void deleteContactById(int id) {
        if (!contacts.containsKey(id)) {
            System.out.println("Данного контакта не существует");
        } else {
            contacts.remove(id);
            System.out.println("Контакт успешно удалён");
        }
    }
}
