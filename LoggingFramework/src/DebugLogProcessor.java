public class DebugLogProcessor extends LogProcessor {

    private LogProcessor nextLogProcessor;

    public DebugLogProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

    @Override
    public void log(int logLevel, String message) {
        if (logLevel == 2) {
            System.out.println("This is a debug log");
        } else {
            super.log(logLevel, message);
        }
    }
}
