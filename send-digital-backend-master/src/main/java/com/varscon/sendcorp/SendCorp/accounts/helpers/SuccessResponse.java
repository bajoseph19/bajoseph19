package com.varscon.sendcorp.SendCorp.accounts.helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import java.util.HashMap;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class SuccessResponse<T> extends GenericResponse<T>{
    public SuccessResponse(String message, T object){
        super();
        setSuccess(true);
        setMessage(message);
        setData(object);
//        LOGGER.error("Invalid Input Exception: ",ex.getMessage());
    }

    @SneakyThrows
    @Override
    public String toString() {
        var payload = new HashMap<>();
        payload.put("success", this.isSuccess());
        payload.put("message", this.getMessage());
        payload.put("data", this.getData());

        return new ObjectMapper().writeValueAsString(payload);
    }
}
