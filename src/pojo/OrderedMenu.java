package pojo;

public class OrderedMenu {
    private int oId;
    private int mId;
    private int omamot;   //已点该菜的数量
    private int deliver;  //是否已上菜

    public OrderedMenu() {
    }

    public OrderedMenu(int mId, int omamot) {
        this.mId = mId;
        this.omamot = omamot;
    }

    public int getoId() {
        return oId;
    }

    public void setoId(int oId) {
        this.oId = oId;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public int getOmamot() {
        return omamot;
    }

    public void setOmamot(int omamot) {
        this.omamot = omamot;
    }

    public int getDeliver() {
        return deliver;
    }

    public void setDeliver(int deliver) {
        this.deliver = deliver;
    }
}
