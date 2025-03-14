package com.adminPanel.app.exception.responses;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductErrorResponse {
    private int code;
    private String msg;
    private long timestamp;
}
