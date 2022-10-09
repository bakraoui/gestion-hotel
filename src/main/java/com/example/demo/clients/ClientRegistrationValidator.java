package com.example.demo.clients;

import java.util.function.Function;
import static com.example.demo.clients.ClientRegistrationValidator.ResultValidation;
import static com.example.demo.clients.ClientRegistrationValidator.ResultValidation.*;
public interface ClientRegistrationValidator extends Function<Client, ResultValidation> {

    static ClientRegistrationValidator isUsernameValid(){
        return client -> client.getUser().getUsername().length() > 8 ?
                SUCCESS : USERNAME_NOT_VALID;
    }

    static ClientRegistrationValidator isPhoneValid(){
        return client -> client.getTelephone().length() > 9 ? SUCCESS : PHONE_NOT_VALID;
    }

    static ClientRegistrationValidator isSomeFieldsEmpty() {
        return client -> client.getTelephone() == null
                || client.getCin() == null
                || client.getPrenom() == null
                || client.getNom() == null
                || client.getUser().getUsername() == null
                || client.getUser().getPassword() == null
                    ? ALL_FIELDS_ARE_REQUIRED : SUCCESS;
    }


    // combinator
    default ClientRegistrationValidator and (ClientRegistrationValidator other) {
        return client -> {
            ResultValidation result = this.apply(client);
            return result.equals(SUCCESS) ? other.apply(client) : result;
        };
    }
    enum ResultValidation {
        SUCCESS,
        USERNAME_NOT_VALID,
        PHONE_NOT_VALID,
        ALL_FIELDS_ARE_REQUIRED
    }
}
