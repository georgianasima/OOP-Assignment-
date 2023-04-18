package Assignment4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

    public abstract class Phone {
        private String manufacturer;
        private String model;
        private int batteryLife; // in hours
        private String color;
        private String material;
        private String IMEI;
        private List<Contact> contacts;
        private Map<String, List<Message>> messages;
        private List<Call> callHistory;

        public Phone(String manufacturer, String model, int batteryLife, String color, String material) {
            this.manufacturer = manufacturer;
            this.model = model;
            this.batteryLife = batteryLife;
            this.color = color;
            this.material = material;
            this.contacts = new ArrayList<>();
            this.messages = new HashMap<>();
            this.callHistory = new ArrayList<>();
        }

        public void addContact(String number, String phoneNumber, String firstName, String lastName) {
            Contact contact = new Contact(phoneNumber, firstName, lastName);
            contacts.add(contact);
        }
        public Contact getFirstContact() {
            return contacts.get(0);
        }

        public Contact getLastContact() {
            return contacts.get(contacts.size() - 1);
        }
        public void sendMessage(String phoneNumber, String messageContent) {
            if (messageContent.length() > 100) {
                System.out.println("Error: The Message is longer than 100 characters.");
                return;
            }
            if (!messages.containsKey(phoneNumber)) {
                messages.put(phoneNumber, new ArrayList<>());
            }
            Message message = new Message(messageContent);
            messages.get(phoneNumber).add(message);
            batteryLife -= 1;
        }
        public Message getFirstMessage(String phoneNumber) {
            if (!messages.containsKey(phoneNumber) || messages.get(phoneNumber).isEmpty()) {
                return null;
            }
            return messages.get(phoneNumber).get(0);
        }
        public Message getSecondMessage(String phoneNumber) {
            if (!messages.containsKey(phoneNumber) || messages.get(phoneNumber).size() < 2) {
                return null;
            }
            return messages.get(phoneNumber).get(1);
        }
        public void call(String phoneNumber) {
            Call call = new Call(phoneNumber);
            callHistory.add(call);
            batteryLife -= 2;
        }
        public void viewHistory() {
            System.out.println("Call History:");
            for (Call call : callHistory) {
                System.out.println(call);
            }
        }
        public Map<String, List<Message>> getMessages() {
            return messages;
        }
    }