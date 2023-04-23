package com.clinic.veterinary.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

 @Getter
 @RequiredArgsConstructor
public enum Role {
    ALL("ROLE_ALL"),
    READ("ROLE_READ");

    private final String value;
}
