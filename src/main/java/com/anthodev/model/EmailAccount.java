package com.anthodev.model;

import org.immutables.value.Value;

import javax.mail.Store;
import java.util.Properties;

@Value.Immutable
public interface EmailAccount {

    String emailAddress();

    String password();

    /**
     * The properties object will hold the email
     * configurations (to be retrieved from the source)
     *
     **/
    @Value.Default
    default Properties properties() {
        final Properties properties = new Properties();

        // Properties for sending emails
        properties.put("incomingHost", "imap.gmail.com");
        properties.put("mail.store.protocol", "imaps");

        // Properties for recieving emails
        properties.put("mail.transport.protocol", "smtps");
        properties.put("mail.smtps.host", "smtp.gmail.com");
        properties.put("mail.smtps.auth", "true");
        properties.put("outgoingHost", "smtp.gmail.com");

        return properties;
    }

    /**
     * Used for sending and retrieving messages.
     *
     */
    Store store();
}
