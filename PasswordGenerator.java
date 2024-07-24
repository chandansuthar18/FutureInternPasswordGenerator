package org.example;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class PasswordGenerator {
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_+=<>?";

    public static String generatePassword(int length, boolean useUppercase, boolean useLowercase, boolean useNumbers, boolean useSpecialCharacters) {
        StringBuilder characterSet = new StringBuilder();
        if (useUppercase) characterSet.append(UPPERCASE);
        if (useLowercase) characterSet.append(LOWERCASE);
        if (useNumbers) characterSet.append(NUMBERS);
        if (useSpecialCharacters) characterSet.append(SPECIAL_CHARACTERS);

        if (characterSet.length() == 0) {
            throw new IllegalArgumentException("At least one character set must be selected");
        }

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characterSet.length());
            password.append(characterSet.charAt(index));
        }
        return password.toString();
    }
}
