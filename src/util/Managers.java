import model.Contact;
import repository.ContactRepository;

import java.util.HashMap;

public class Managers {
    public static final ContactRepository contactRepository = new ContactRepository();

    public static ContactRepository getDefaultContactRepository() {
        return contactRepository;
    }
}
