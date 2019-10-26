package pojo;

public class OrderedMenu_Menu {

    private int oId;            //  订单编号
    private int mId;            //  菜品编号
    private int omamot;         //已点该菜的数量
    private int deliver;        //是否已上菜
    private String mname;       //  菜名
    private int mclass;         //  类别
    private String className;   //  类别名称
    private double mprice;      //  单价
    private int mamot;          //  已点数量

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

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public int getMclass() {
        return mclass;
    }

    public void setMclass(int mclass) {
        this.mclass = mclass;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getMprice() {
        return mprice;
    }

    public void setMprice(double mprice) {
        this.mprice = mprice;
    }

    public int getMamot() {
        return mamot;
    }

    public void setMamot(int mamot) {
        this.mamot = mamot;
    }


}
