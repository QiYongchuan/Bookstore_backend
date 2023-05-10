package edu.hue.jk.model;


import lombok.Data;

@Data
public class Notice {
    private Integer nId;  //注意首字母小写就可以，其次下划线不出现在命名中，使用驼峰命名法
    private String title;
    private String details;
    private String nTime;
}
