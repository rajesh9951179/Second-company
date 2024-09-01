package com.jsp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class MultiUserLoginLogout {
    private static Map<String, UserSession> userSessions = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter command (login <username>, logout <username>, show <username>, show_all, exit):");
            String input = scanner.nextLine();
            String[] parts = input.split(" ");

            if (parts.length < 1) {
                System.out.println("Invalid command.");
                continue;
            }
            String command = parts[0];

            switch (command) {
                case "login":
                    if (parts.length < 2) {
                        System.out.println("Username required.");
                    } else {
                        String username = parts[1];
                        login(username);
                    }
                    break;
                case "logout":
                    if (parts.length < 2) {
                        System.out.println("Username required.");
                    } else {
                        String username = parts[1];
                        logout(username);
                    }
                    break;
                case "show":
                    if (parts.length < 2) {
                        System.out.println("Username required.");
                    } else {
                        String username = parts[1];
                        show(username);
                    }
                    break;
                case "showall":
                    showAll();
                    break;
                case "exit":
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Unknown command.");
            }
        }
    }

    private static void login(String username) {
        if (userSessions.containsKey(username) && userSessions.get(username).getLogoutTime() == null) {
            System.out.println("User " + username + " is already logged in.");
        } else {
            userSessions.put(username, new UserSession(LocalDateTime.now()));
            System.out.println("User " + username + " logged in at: " + userSessions.get(username).getLoginTime());
        }
    }

    private static void logout(String username) {
        UserSession session = userSessions.get(username);
        if (session == null || session.getLogoutTime() != null) {
            System.out.println("User " + username + " is not logged in.");
        } else {
            session.setLogoutTime(LocalDateTime.now());
            System.out.println("User " + username + " logged out at: " + session.getLogoutTime());
        }
    }

    private static void show(String username) {
        UserSession session = userSessions.get(username);
        if (session == null) {
            System.out.println("No data for user " + username);
        } else {
            System.out.println("User " + username + ": " + session);
        }
    }

    private static void showAll() {
        int loggedInUsers = 0;
        int loggedOutUsers = 0;

        for (Map.Entry<String, UserSession> entry : userSessions.entrySet()) {
            String username = entry.getKey();
            UserSession session = entry.getValue();
            System.out.println("User " + username + ": " + session);
            
            if (session.getLogoutTime() == null) {
                loggedInUsers++;
            } else {
                loggedOutUsers++;
            }
        }

        System.out.println("Total users logged in: " + loggedInUsers);
        System.out.println("Total users logged out: " + loggedOutUsers);
    }
}