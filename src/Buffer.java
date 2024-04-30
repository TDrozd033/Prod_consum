public class Buffer
{
    private int mSharedBuf;
    private BufState mBufState;

    public int getSharedBuf() {
        return mSharedBuf;
    }

    public void setSharedBuf(int newBuf) {
        this.mSharedBuf = newBuf;
    }

    final public BufState getBufState() {
        return mBufState;
    }


    public void setBufState(BufState newState) {
        this.mBufState = newState;
    }

    public Buffer()
    {
        mSharedBuf = -1;
        mBufState = BufState.RES_EMPTY;
    }



}
