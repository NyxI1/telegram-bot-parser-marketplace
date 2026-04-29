package domain;

public class Product {

    private long id;
    private long userId;
    private String title;
    private String url;
    private Marketplace marketplace;
    private int targetPrice;
    private int lastPrice;

    public Product(long id, long userId, String title, String url, Marketplace marketplace, int targetPrice, int lastPrice) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.url = url;
        this.marketplace = marketplace;
        this.targetPrice = targetPrice;
        this.lastPrice = lastPrice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Marketplace getMarketplace() {
        return marketplace;
    }

    public void setMarketplace(Marketplace marketplace) {
        this.marketplace = marketplace;
    }

    public int getTargetPrice() {
        return targetPrice;
    }

    public void setTargetPrice(int targetPrice) {
        this.targetPrice = targetPrice;
    }

    public int getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(int lastPrice) {
        this.lastPrice = lastPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", marketplace=" + marketplace +
                ", targetPrice=" + targetPrice +
                ", lastPrice=" + lastPrice +
                '}';
    }
}
