package com.sarunas.errors;

import com.sarunas.model.PackageSize;
import com.sarunas.model.Provider;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class ErrorHandling {

    public boolean isCorrectInput(String[] shipping) {
        if (shipping.length != 3 || !isValidDate(shipping[0])) {
            return false;
        }
        if (shipping[1].equals(PackageSize.S.toString())
                || shipping[1].equals(PackageSize.M.toString())
                || shipping[1].equals(PackageSize.L.toString())
                && shipping[2].equals(Provider.LP.toString())
                || shipping[2].equals(Provider.MR.toString())) {
            return true;
        }
        return false;
    }

    public void printError(String[] shipping) {
        ErrorMessage errorMessage = null;
        if (shipping.length != 3) {
            errorMessage = ErrorMessage.builder()
                    .date(shipping[0])
                    .firstMessage(shipping[1])
                    .secondMessage("Ignored")
                    .thirdMessage("")
                    .build();
        } else if (!isValidDate(shipping[0]) ||!isValidPackage(shipping[1])
                || !isValidProvider(shipping[2])) {
            errorMessage = ErrorMessage.builder()
                    .date(shipping[0])
                    .firstMessage(shipping[1])
                    .secondMessage(shipping[2])
                    .thirdMessage("Ignored")
                    .build();
        }
        if (errorMessage != null) System.out.println(errorMessage);
    }

    private boolean isValidPackage(String packageSize) {
        return packageSize.equals(PackageSize.S.toString())
                || packageSize.equals(PackageSize.M.toString())
                || packageSize.equals(PackageSize.L.toString());
    }

    private boolean isValidProvider(String provider) {
        return provider.equals(Provider.LP.toString())
                || provider.equals(Provider.MR.toString());
    }

    private boolean isValidDate(String date) {
        String formatString = "yyyy-MM-dd";
        try {
            SimpleDateFormat format = new SimpleDateFormat(formatString);
            format.setLenient(false);
            format.parse(date);
        } catch (ParseException | IllegalArgumentException e) {
            return false;
        }
        return true;
    }
}
