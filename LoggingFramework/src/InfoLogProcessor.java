public class InfoLogProcessor extends LogProcessor {
    private LogProcessor nextLogProcessor;


    InfoLogProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

    public void log(int logLevel, String message) {
        if (logLevel == INFO) {
            System.out.println("Log Level is INFO");
        } else {
            super.log(logLevel, message);
        }
    }

}
