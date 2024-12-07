public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        LogProcessor logObj = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));
        logObj.log(LogProcessor.INFO, "INFO");
    }
}