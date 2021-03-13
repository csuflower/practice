class Consumer implements Runnable {
    private final WareHouse wareHouse;
    private final String name;
    @Override
    public void run() {
        while (true) {
            String res = null;
            try {
                res = wareHouse.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("消费者" + name + "获取的一条消息");
            System.out.println("consumer:" + res);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Consumer(WareHouse wareHouse, String name) {
        this.wareHouse = wareHouse;
        this.name = name;
    }
}