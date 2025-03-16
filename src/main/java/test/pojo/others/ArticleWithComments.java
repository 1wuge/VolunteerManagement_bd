package test.pojo.others;

import java.util.List;

public class ArticleWithComments {

    Article article;
    List<Comments> comments;

    public ArticleWithComments(Article article, List<Comments> comments) {
        this.article = article;
        this.comments = comments;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "ArticleWithComments{" +
                "article=" + article +
                ", comments=" + comments +
                '}';
    }
}
