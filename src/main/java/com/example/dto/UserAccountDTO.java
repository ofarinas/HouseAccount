package com.example.dto;

import com.example.entitys.Payment;
import com.example.entitys.UserAccount;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Osvaldo on 8/11/2016.
 */
public class UserAccountDTO {

    private GsonBuilder gsonBuilder;

    public UserAccountDTO() {
        gsonBuilder = getGsonBuilder();
    }

    public String getJsonUsserAccount(UserAccount userAccount) {
        return gsonBuilder.create().toJson(userAccount);
    }

    public String getJsonUsserAccountList(List<UserAccount> userAccountList) {

        return gsonBuilder.create().toJson(userAccountList);
    }

    private GsonBuilder getGsonBuilder() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(UserAccount.class, new UserAccountSerializer());
        gsonBuilder.registerTypeAdapter(Payment.class, new PaymentSerializer());
        return gsonBuilder;
    }

    private class UserAccountSerializer implements JsonSerializer<UserAccount> {
        @Override
        public JsonElement serialize(UserAccount userAccount, Type type, JsonSerializationContext jsonSerializationContext) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("id",new JsonPrimitive(userAccount.getId()));
            jsonObject.add("name",new JsonPrimitive(userAccount.getName()));
            jsonObject.add("password",new JsonPrimitive(userAccount.getPassword()));
            jsonObject.add("Payment",jsonSerializationContext.serialize(userAccount.getPaymentList()));
            return jsonObject;
        }
    }

    private class PaymentSerializer implements JsonSerializer<Payment> {

        @Override
        public JsonElement serialize(Payment payment, Type type, JsonSerializationContext jsonSerializationContext) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("id",new JsonPrimitive(payment.getId()));
            jsonObject.add("market",new JsonPrimitive(payment.getMarcket()));
            jsonObject.add("amount",new JsonPrimitive(payment.getAmount()));
            return jsonObject;
        }
    }
}
