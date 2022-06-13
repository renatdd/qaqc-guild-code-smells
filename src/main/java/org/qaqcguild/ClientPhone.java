package org.qaqcguild;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientPhone {

    private String areaCode;
    private String number;

    public ClientPhone(String numberInput) {
        String sanitizedInput = sanitizeInput(numberInput);
        this.areaCode = sanitizedInput.substring(0,2);
        this.number = sanitizedInput.substring(2);
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFullNumber() {
        return areaCode + number;
    }

    private String sanitizeInput(String numberInput) {
        return removeZeroFromStart(getOnlyNumbers(numberInput));
    }

    private String removeZeroFromStart(String numberInput) {
        if (numberInput.startsWith("0")) {
            return numberInput.substring(1);
        }
        return numberInput;
    }

    private String getOnlyNumbers(String numberInput) {
        StringBuilder sanitizedNumber = new StringBuilder();
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(numberInput);
        while(m.find()) {
            sanitizedNumber.append(m.group());
        }
        return sanitizedNumber.toString();
    }

    @Override
    public String toString() {
        int lastFourIndex = number.length() - 4;
        return String.format("(%s) %s-%s",
                areaCode,
                number.substring(0, lastFourIndex),
                number.substring(lastFourIndex));
    }
}
