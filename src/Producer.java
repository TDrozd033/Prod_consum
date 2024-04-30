import java.util.Random;

public class Producer extends Thread
{

    private Random mRand = new Random();
    private Buffer mBuf;


    public Producer( Buffer buf)
    {
        mBuf = buf;
    }

    public void run()
    {
        System.out.println("Started Thread " + super.getName());

        for( int i = 15; i>=0; i--) {
            synchronized (mBuf) {
                while (mBuf.getBufState() == BufState.RES_FULL) {
                    try {
                        mBuf.wait();
                    } catch (InterruptedException e) {

                    }
                }
                mBuf.setSharedBuf(i);
                System.out.println(" Produced " + 1);

                mBuf.setBufState(BufState.RES_FULL);
                mBuf.notifyAll();
            }

            try {
                sleep(mRand.nextInt(30));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            System.out.println("Producer stopped");



    }
}
