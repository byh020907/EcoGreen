package com.example.user.echogreen.Data;

import android.widget.Switch;

/**
 * Created by user on 2017-07-27.
 */

public class Subject_item {
    private Switch aSwitch;
    private String subject;

    public Subject_item(Switch aSwitch, String subject) {
        this.aSwitch = aSwitch;
        this.subject = subject;
    }

    public Switch getaSwitch() {
        return aSwitch;
    }

    public void setaSwitch(Switch aSwitch) {
        this.aSwitch = aSwitch;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
