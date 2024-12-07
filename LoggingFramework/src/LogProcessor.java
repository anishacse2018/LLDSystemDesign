public abstract class LogProcessor {
    public static final Integer INFO = 1;
    public static final Integer DEBUG = 2;
    public static final Integer ERROR = 3;
    public LogProcessor nextLogProcessor;

    LogProcessor(LogProcessor nextLogProcessor) {
        this.nextLogProcessor = nextLogProcessor;
    }

    public void log(int logLevel, String message) {
        if (nextLogProcessor != null) {
            nextLogProcessor.log(logLevel, message);
        }
    }

}
