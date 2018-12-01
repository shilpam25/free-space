package com.adobe.codingchallenge.model;

import org.hibernate.validator.constraints.NotBlank;

public class Blog {
    private int blogId;

    @NotBlank(message = "Title should not be empty")
    private String title;

    @NotBlank(message = "Description should not be empty")
    private String desc;
}
