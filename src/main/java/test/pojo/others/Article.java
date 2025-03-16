package test.pojo.others;

public class Article {

    String account;
    int tid;
    String title;
    String content;
    String time;

    public Article(String account, String title, String content, String time) {
        this.account = account;
        this.title = title;
        this.content = content;
        this.time = time;
    }

    public Article(String account, int tid, String title, String content, String time) {
        this.account = account;
        this.tid = tid;
        this.title = title;
        this.content = content;
        this.time = time;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Article{" +
                "account='" + account + '\'' +
                ", tid='" + tid + '\'' +
                ", tittle='" + title + '\'' +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
