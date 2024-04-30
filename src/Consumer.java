
import java.util.Random;

public class Consumer extends Thread
{
    private Random mRand = new Random();

    private Buffer mBuf;

    public Consumer(Buffer buf)
    {
        mBuf = buf;

    }

    public void run()
    {
        int result;
        System.out.println("Started thread " + super.getName());


        while(true)
        {
            synchronized(mBuf) {
                while (mBuf.getBufState() == BufState.RES_EMPTY) {
                    try {
                        mBuf.wait();
                    } catch (InterruptedException e) {
                    }
                }

                result = mBuf.getSharedBuf();
                if (result >= 0) {
                    System.out.println("*Consumed " + result);
                    mBuf.setBufState(BufState.RES_EMPTY);
                    mBuf.notifyAll();

                    if (result == 0) {
                        System.out.println("Consumed stopped");
                        return;
                    }
                }
            }

                // symulowanie obliczen
                try {
                    sleep(mRand.nextInt(40));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

        }
    }

}
