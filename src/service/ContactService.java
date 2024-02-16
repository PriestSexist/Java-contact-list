package service;

import model.Contact;

import java.util.HashMap;
import java.util.List;

public interface ContactService {
    Contact postContact(Contact contact);
    HashMap<Integer, Contact> getAllContacts();
    List<Contact> getContactsByName(String name);
    void deleteContactById(int id);
}
