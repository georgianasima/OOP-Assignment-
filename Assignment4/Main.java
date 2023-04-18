package Assignment4;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
      //  Phone phone= new Samsung(); // shouldn't compile

        Phone phone = new SamsungGalaxyS6();

        phone.addContact("1", "0752663992", "Nicoleta", "Savin");

        phone.addContact("2", "2392351806", "Georgiana", "Sima");

        Contact firstContact = phone.getFirstContact();
        System.out.println("First contact details: " + firstContact.getPhoneNumber()+" "+ firstContact.getFirstName() + " " +firstContact.getLastName() );

        Contact lastContact = phone.getLastContact();
        System.out.println("Last contact details: " + lastContact.getPhoneNumber()+" "+ lastContact.getFirstName() + " " +lastContact.getLastName() );

// send a message to the first contact from the previously listed

// max number of characters - 100

        phone.sendMessage("0752663992", "message content");
        phone.sendMessage("0752663992", "second message content");

        Map<String, List<Message>> allMessages = phone.getMessages();
        System.out.println("-----------------------");

        for(Map.Entry<String, List<Message>> message : allMessages.entrySet()){
            System.out.println("All messages of number " + message.getKey());
            for(Message msg : message.getValue()){
                System.out.println("Message : " + msg.getContent());
            }
        }
        System.out.println("------------------------");

        Message firstMessage = phone.getFirstMessage("0752663992");
        System.out.println("First message: " +firstMessage.getContent());

        Message secondMessage = phone.getSecondMessage("0752663992");
        System.out.println("Second message :" + secondMessage.getContent());

// make a call to the second contact from the previously listed

        phone.call("2392351806");
        phone.viewHistory();
    }
}