class Producer implements Runnable {
    private WareHouse wareHouse;
    private String name;

    public Producer(WareHouse wareHouse, String name) {
        this.wareHouse = wareHouse;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            try {
                wareHouse.put("尤梦雪");
                System.out.println(wareHouse.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("生产者:" + name + "产生了一条消息");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}