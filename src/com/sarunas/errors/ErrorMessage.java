package com.sarunas.errors;


public class ErrorMessage {

    private final String date;
    private final String firstMessage;
    private final String secondMessage;
    private final String thirdMessage;


    public ErrorMessage(String date, String firstMessage, String secondMessage, String thirdMessage) {
        this.date = date;
        this.firstMessage = firstMessage;
        this.secondMessage = secondMessage;
        this.thirdMessage = thirdMessage;
    }

    public static ErrorMessageBuilder builder() {
        return new ErrorMessageBuilder();
    }

    public static class ErrorMessageBuilder {
        private String date;
        private String firstMessage;
        private String secondMessage;
        private String thirdMessage;

        public ErrorMessageBuilder() {}

        public ErrorMessageBuilder date(String date) {
            this.date = date;
            return this;
        }

        public ErrorMessageBuilder firstMessage(String firstMessage) {
            this.firstMessage = firstMessage;
            return this;
        }

        public ErrorMessageBuilder secondMessage(String secondMessage) {
            this.secondMessage = secondMessage;
            return this;
        }

        public ErrorMessageBuilder thirdMessage(String thirdMessage) {
            this.thirdMessage = thirdMessage;
            return this;
        }

        public ErrorMessage build() {
            return new ErrorMessage(date, firstMessage, secondMessage, thirdMessage);
        }
    }

    @Override
    public String toString() {
        return  date +
                " " + firstMessage +
                " " + secondMessage +
                " " + thirdMessage;
    }
}
