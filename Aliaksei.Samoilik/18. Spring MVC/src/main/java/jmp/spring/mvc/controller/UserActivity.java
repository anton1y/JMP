package jmp.spring.mvc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserActivity implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<String> userActivities;

    public void addActivity(String activity) {
        if (userActivities == null) {
            userActivities = new ArrayList<>();
        }
        userActivities.add(activity);
    }

    public List<String> getUserActivities() {
        return userActivities;
    }

    public void setUserActivities(List<String> userActivities) {
        this.userActivities = userActivities;
    }

}
