package com.bohdan.services;

public class Anagram {
    public String make(String text) {
        StringBuilder result = new StringBuilder();
        String[] words = text.split(" ");
        for (int i = 0; i < words.length; i++) {
            result.append(revertWord(words[i]));
            result.append(" ");
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    private StringBuilder revertWord(String word) {
        StringBuilder result = new StringBuilder();
        char[] characters = word.toCharArray();
        int leftBorder = 0;
        int rightBorder = characters.length - 1;
        while (leftBorder < rightBorder) {
            if (Character.isLetter(characters[leftBorder]) && Character.isLetter(characters[rightBorder])) {
                swapCharacters(characters, leftBorder, rightBorder);
                leftBorder++;
                rightBorder--;
            } else if (!Character.isLetter(characters[leftBorder])) {
                leftBorder++;
            } else if (!Character.isLetter(characters[rightBorder])) {
                rightBorder--;
            }
        }
        return result.append(characters);
    }

    private void swapCharacters(char[] word, int firstCharacter, int secondCharacter) {
        char temp = word[firstCharacter];
        word[firstCharacter] = word[secondCharacter];
        word[secondCharacter] = temp;

    }

}
