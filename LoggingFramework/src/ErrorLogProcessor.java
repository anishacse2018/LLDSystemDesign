public class ErrorLogProcessor extends LogProcessor {
    private LogProcessor nextLogProcessor;


    ErrorLogProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

    public void log(int logLevel, String message) {
        if (logLevel == 3) {
            System.out.println("Log Level is ERROR");
        } else {
            super.log(logLevel, message);
        }
    }
}
