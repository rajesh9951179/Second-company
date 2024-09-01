package com.jsp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class UserSession {
    private LocalDateTime loginTime;
    private LocalDateTime logoutTime;

    public UserSession(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }

    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public void setLogoutTime(LocalDateTime logoutTime) {
        this.logoutTime = logoutTime;
    }

    public LocalDateTime getLogoutTime() {
        return logoutTime;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "Login: " + loginTime.format(formatter) + ", Logout: " + (logoutTime != null ? logoutTime.format(formatter) : "N/A");
    }
}