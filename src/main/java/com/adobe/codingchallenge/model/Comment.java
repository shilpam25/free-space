package com.adobe.codingchallenge.model;

import org.hibernate.validator.constraints.NotBlank;

public class Comment {

    @NotBlank(message = "Comment should not be empty")
    private String comment;

}
