package com.score.bean;

import lombok.Data;

import java.io.Serializable;
@Data

public class Count implements Serializable {
    private String name;
    private Integer value;
}
