public class Main {
    static private int num;
    static private boolean ifOk = false;

    public static void main(String[] args) {
        num = (int) (Math.random()*1000000+1);

        Thread thread1 = new Thread(new Runnable() {
            int timer = 0;
            @Override
            public void run() {
                try {
                    while (ifOk == false) {
                        System.out.println(timer);
                        timer++;
                        Thread.sleep(1);
                    }
                } catch (Exception e) {

                }
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (ifOk == false) {
                        int genRandom = (int) (Math.random() * 1000000 + 1);
                        if (genRandom == num) {
                            System.out.println(String.format("Ура, число: %s", genRandom));
                            ifOk = true;
                        }
                    }
                } catch (Exception e) {

                }
            }
        });
        thread2.start();
    }
}
