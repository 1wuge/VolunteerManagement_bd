package test.pojo.others;

public class Comments {

    String account;
    int tid;
    int cid;
    String comment;
    String ctime;

    public Comments(String account, int tid, String comment, String ctime) {
        this.account = account;
        this.tid = tid;
        this.comment = comment;
        this.ctime = ctime;
    }

    public Comments(String account, int tid, int cid, String comment, String ctime) {
        this.account = account;
        this.tid = tid;
        this.cid = cid;
        this.comment = comment;
        this.ctime = ctime;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "account='" + account + '\'' +
                ", tid=" + tid +
                ", cid=" + cid +
                ", comment='" + comment + '\'' +
                ", ctime='" + ctime + '\'' +
                '}';
    }
}
