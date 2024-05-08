package GeneralPractice.TopQues;

import java.util.HashMap;
import java.util.Map;

public class Logger359 {

        Map<String, Integer> hm;
        public Logger359() {
            this.hm=new HashMap<>();
        }

        public boolean shouldPrintMessage(int value, String key) {
            if (!hm.containsKey(key)){
                hm.put(key,value+10);
                return true;
            }
            else {
                int val=hm.get(key);
                if(val<=value){
                    hm.put(key,value+10);
                    return true;
                }
                else
                    return false;
            }
        }

    public static void main(String[] args) {
        Logger359 logger = new Logger359();
        System.out.println(logger.shouldPrintMessage(1, "foo"));  // return true, next allowed timestamp for "foo" is 1 + 10 = 11
        System.out.println(logger.shouldPrintMessage(2, "bar"));  // return true, next allowed timestamp for "bar" is 2 + 10 = 12
        System.out.println(logger.shouldPrintMessage(3, "foo"));  // 3 < 11, return false
        System.out.println(logger.shouldPrintMessage(8, "bar"));  // 8 < 12, return false
        System.out.println(logger.shouldPrintMessage(10, "foo")); // 10 < 11, return false
        System.out.println(logger.shouldPrintMessage(11, "foo")); // 11 >= 11, return true, next allowed timestamp for "foo" is 11 + 10 = 21
    }
}
