package boardgame.games.models;

public class BoardGame {
    private Integer id;
    private String name;
    private String year;
    private String ranking;
    private String rating;
    private String link;
    private String imgSrc;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public String getRanking() {
        return ranking;
    }
    public void setRanking(String ranking) {
        this.ranking = ranking;
    }
    public String getRating() {
        return rating;
    }
    public void setRating(String rating) {
        this.rating = rating;
    }
    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }
    public String getImgSrc() {
        return imgSrc;
    }
    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    
}
