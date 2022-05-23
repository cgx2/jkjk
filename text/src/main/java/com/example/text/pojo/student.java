package com.example.text.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class student {
    private Integer id;
    private String name;
    private String classname;
    private Integer age;
    private Integer sex;//0为女 1为男
}
