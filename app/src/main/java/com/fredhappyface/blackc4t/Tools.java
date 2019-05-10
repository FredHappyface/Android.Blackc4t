package com.fredhappyface.blackc4t;

import java.security.SecureRandom;

class Tools {

    static StringBuffer doOneTimePad(String keyString, final String messageString, final boolean decrypt){

        final StringBuffer outputString = new StringBuffer();
        int keyLength = keyString.length();
        final int messageLength = messageString.length();

        for (int index = 0; index < messageLength; index++) {
            if (index >= keyLength) {
                keyString += keyString;
                keyLength += keyLength;
            }
            final char keyChar = keyString.charAt(index);
            final char messageChar = messageString.charAt(index);
            final char outChar;
            if (decrypt) {
                outChar = (char) (messageChar - keyChar);
            } else {
                outChar = (char) (messageChar + keyChar);
            }
            outputString.append(outChar);


        }
        return outputString;

    }

    static StringBuffer doTwoKey(String keyString1, String keyString2, String messageString, boolean decrypt){

        final StringBuffer outputString = new StringBuffer();
        int keyLength1 = keyString1.length();
        int keyLength2 = keyString2.length();
        final int messageLength = messageString.length();

        for (int index = 0; index < messageLength; index++) {

            if (index >= keyLength1) {
                keyString1 += keyString1;
                keyLength1 += keyLength1;
            }
            if (index >= keyLength2) {
                keyString2 += keyString2;
                keyLength2 += keyLength2;
            }
            final int keyChar = keyString1.charAt(index) + keyString2.charAt(index);
            final char messageChar = messageString.charAt(index);
            final char outChar;
            if (decrypt) {
                outChar = (char) (messageChar - keyChar);
            } else {
                outChar = (char) (messageChar + keyChar);
            }
            outputString.append(outChar);
        }

        return outputString;

    }



    static StringBuffer doPassword(int wordsInt, int numbersInt, int symbolsInt, String[] allWords){

        final StringBuffer outputString = new StringBuffer();

        /*
        Populate arrays
        */
        final String[] wordsArray = Password.getRandomWord(wordsInt, allWords);
        final int[] digitArray = Password.getRandomDigit(numbersInt);
        final char[] symbolsArray = Password.getRandomSymbol(symbolsInt);
        /*
        Add contents to outputString
         */
        for (String word : wordsArray) {
            outputString.append(Password.capitaliseFirstLetter(word));
        }
        for (int digit : digitArray) {
            outputString.append(digit);
        }
        for (char symbol : symbolsArray) {
            outputString.append(symbol);
        }

        return outputString;

    }



    /*
   Returns random int between min and max (inclusive)
    */
    static int getRandomInt(final int min, final int max) {
        SecureRandom random = new SecureRandom();
        return (int) ((random.nextDouble() * (max - min)) + min);
    }

}
