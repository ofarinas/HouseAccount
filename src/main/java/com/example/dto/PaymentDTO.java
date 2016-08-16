package com.example.dto;

import com.example.entitys.Payment;
import com.example.entitys.UserAccount;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Osvaldo on 8/16/2016.
 */
public class PaymentDTO {
    private GsonBuilder gsonBuilder;

    public PaymentDTO() {
        gsonBuilder = getGsonBuilder();
    }

    public String getJsonPayment(Payment userAccount) {
        return gsonBuilder.create().toJson(userAccount);
    }

    public String getJsonPaymentList(List<Payment> userAccountList) {
        return gsonBuilder.create().toJson(userAccountList);
    }

    private GsonBuilder getGsonBuilder() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Payment.class, new PaymentSerializer());
        return gsonBuilder;
    }


    private class PaymentSerializer implements JsonSerializer<Payment> {

        @Override
        public JsonElement serialize(Payment payment, Type type, JsonSerializationContext jsonSerializationContext) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("id",new JsonPrimitive(payment.getId()));
            jsonObject.add("amount",new JsonPrimitive(payment.getAmount()));
            jsonObject.add("name",new JsonPrimitive(payment.getUserAccount().getName()));
            jsonObject.add("market",new JsonPrimitive(payment.getMarcket()));
            return jsonObject;
        }
    }
}
