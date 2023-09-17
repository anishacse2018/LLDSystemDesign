public class MainClass{
    public static void main(String args[]){
        LogProcessor logObj = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));
        logObj.log(LogProcessor.ERROR,"Exception occurred");
        logObj.log(LogProcessor.DEBUG,"Debugging statements");
        logObj.log(LogProcessor.INFO,"Info message"); 
    }
}