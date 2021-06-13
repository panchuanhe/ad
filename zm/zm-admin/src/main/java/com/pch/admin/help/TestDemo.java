package com.pch.admin.help;

public class TestDemo {

    public static void main(String[] args) throws InterruptedException {
      /*  ConcurrentHashMap<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(1, "panchuanhe");
        concurrentHashMap.put(2, "zengmi");
        concurrentHashMap.put(3, "malin");
        concurrentHashMap.put(4, "maer");


        ConcurrentHashMap.KeySetView<Integer, String> keySet = concurrentHashMap.keySet();

        for (Integer key : keySet) {
            if (key == 1){
                concurrentHashMap.remove(key);
            }
        }

        System.out.println(JSONObject.toJSONString(concurrentHashMap));*/
/*
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "panchuanhe");
        hashMap.put(2, "zengmi");
        hashMap.put(3, "malin");
        hashMap.put(4, "maer");

        for (Integer key : hashMap.keySet()) {
            if (key == 1){
                hashMap.remove(key);
            }
        }
        System.out.println(JSONObject.toJSONString(hashMap));*/

/*
        new Thread(() -> {
            System.out.println("线程1开始了");
            count+=1;
            System.out.println(count);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count +=1;
            System.out.println(count);

            System.out.println("线程1结束了");

        }).start();
        new Thread(() -> {
            System.out.println("线程2开始了");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count = 10;
            System.out.println("线程2结束了");
        }).start();*/



    }

    private static Integer count = 1;
}
