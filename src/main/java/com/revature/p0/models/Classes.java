package com.revature.p0.models;

public class Classes {

    private String id;
    private String subject;
    private String code;
    private String level;
    private String description;

    public Classes(String subject, String code, String level, String description) {
        this.subject = subject;
        this.code = code;
        this.level = level;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String number) {
        this.level = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
