package Alibaba_Taobao_20200301;

import java.util.Date;
import java.util.HashMap;

public class ali2 {
    private HashMap<String, API> map = new HashMap<>();
    int threshold = 0;

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    public void access(String ApiName) throws Exception {
        if (!map.containsKey(ApiName)) {
            map.put(ApiName, new API());
            return;
        } else {
            API apiEntry = map.get(ApiName);
            int count = apiEntry.getCount();

            Date nowDate = new Date();
            long timeDifference = (nowDate.getTime() - apiEntry.getDate().getTime()) / 1000;

            if (timeDifference > 60) {
                apiEntry.setDate(nowDate);
                apiEntry.setCount(1);
                return;
            }

            if (count < threshold) {
                apiEntry.setCount(count++);
                return;
            } else {
                throw new Exception("Exceeded threshold!");
            }
        }
    }

    public class API {
        private Date date;
        private int count;

        public API() {
            this.date = new Date();
            this.count = 1;
        }

        public Date getDate() {
            return date;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public void setDate(Date date) {
            this.date = date;
        }
    }
}
