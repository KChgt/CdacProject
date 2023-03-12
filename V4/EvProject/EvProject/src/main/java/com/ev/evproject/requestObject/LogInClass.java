package com.ev.evproject.requestObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class LogInClass {
    private String email;
    private String password;
}
