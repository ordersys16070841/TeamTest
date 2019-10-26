package pojo;

/**
 * 购物车
 */
public class OrderCar {
    private int mId;
    private String mname;
    private int omamot;
    private double mprice;
    private int deliver;

    public OrderCar() {
    }

    public OrderCar(int mId, String mname, int omamot, double mprice) {
        this.mId = mId;
        this.mname = mname;
        this.omamot = omamot;
        this.mprice = mprice;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public int getOmamot() {
        return omamot;
    }

    public void setOmamot(int omamot) {
        this.omamot = omamot;
    }

    public double getMprice() {
        return mprice;
    }

    public void setMprice(double mprice) {
        this.mprice = mprice;
    }

    public int getDeliver() {
        return deliver;
    }

    public void setDeliver(int deliver) {
        this.deliver = deliver;
    }
}
