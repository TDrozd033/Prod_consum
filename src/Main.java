public class Main {
    public static void main(String[] args)
    {


        Buffer buf = new Buffer();
        Producer prod = new Producer( buf);

        Consumer cons = new Consumer(buf);

        prod.setName("Producer"); cons.setName("Consumer");

        cons.start();
        prod.start();


    }
}