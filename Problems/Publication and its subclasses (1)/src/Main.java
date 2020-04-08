class Publication {

    private String title;

    public Publication(String title) {
        this.title = title;
    }

    public final String getInfo() {
        // write your code here
        return getType() + ": " + getDetails();
    }

    public String getType() {
        return "Publication";
    }

    public String getDetails() {
        return title;
    }

}

class Newspaper extends Publication {

    private String source;

    public Newspaper(String title, String source) {
        super(title);
        this.source = source;
    }

    @Override
    public String getType() {
        return String.format("Newspaper (source - %s)", source);
    }

    @Override
    public String getDetails() {
        return super.getDetails();
    }
    // write your code here

}

class Article extends Publication {

    private String author;

    public Article(String title, String author) {
        super(title);
        this.author = author;
    }

    @Override
    public String getType() {
        return String.format("Article (author - %s)", author);
    }

    @Override
    public String getDetails() {
        return super.getDetails();
    }
// write your code here

}

class Announcement extends Publication {

    private int daysToExpire;

    public Announcement(String title, int daysToExpire) {
        super(title);
        this.daysToExpire = daysToExpire;
    }

    @Override
    public String getType() {
        return String.format("Announcement (days to expire - %s)", daysToExpire);
    }

    @Override
    public String getDetails() {
        return super.getDetails();
    }
// write your code here

}