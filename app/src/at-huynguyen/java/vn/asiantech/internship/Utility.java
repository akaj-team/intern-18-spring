package vn.asiantech.internship;

public class Utility {

    public static int getProgressPercentage(long currentTime, long totalTime) {
        Double percentage;
        long currentSeconds = (int) (currentTime / 1000);
        long totalSeconds = (int) (totalTime / 1000);

        // calculating percentage
        percentage = (((double) currentSeconds) / totalSeconds) * 100;

        // return percentage
        return percentage.intValue();
    }

    public static int progressToTimer(int progress, int totalTime) {
        int currentDuration;
        totalTime = totalTime / 1000;
        currentDuration = (int) ((((double) progress) / 100) * totalTime);

        // return current time in milliseconds
        return currentDuration * 1000;
    }

    public static String milliSecondsToTimer(long milliseconds) {
        String finalTimerString = "";
        String secondsString;

        // convert total duration into time
        int hours = (int) (milliseconds / (1000 * 60 * 60));
        int minutes = (int) (milliseconds % (1000 * 60 * 60)) / (1000 * 60);
        int seconds = (int) ((milliseconds % (1000 * 60 * 60)) % (1000 * 60) / 1000);
        // add hours
        if (hours > 0) {
            finalTimerString = hours + ":";
        }

        // add 0 if it have 1 number
        if (seconds < 10) {
            secondsString = "0" + seconds;
        } else {
            secondsString = "" + seconds;
        }

        finalTimerString = finalTimerString + minutes + ":" + secondsString;

        // return timer string
        return finalTimerString;
    }
}
