package be.ordina.workshop.java8.exercises.tweeter.model;

import java.time.LocalDateTime;

/**
 * @author Yannick De Turck
 */
public class Tweet {
    private Long tweetId;
    private String username;
    private String name;
    private String text;
    private LocalDateTime creationDateTime;
    private Integer retweets;
    private Integer favourites;

    public Tweet(Long tweetId, String username, String name, String text, LocalDateTime creationDateTime, Integer retweets, Integer favourites) {
        this.tweetId = tweetId;
        this.username = username;
        this.name = name;
        this.text = text;
        this.creationDateTime = creationDateTime;
        this.retweets = retweets;
        this.favourites = favourites;
    }

    public Long getTweetId() {
        return tweetId;
    }

    public void setTweetId(Long tweetId) {
        this.tweetId = tweetId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public Integer getRetweets() {
        return retweets;
    }

    public void setRetweets(Integer retweets) {
        this.retweets = retweets;
    }

    public Integer getFavourites() {
        return favourites;
    }

    public void setFavourites(Integer favourites) {
        this.favourites = favourites;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "tweetId=" + tweetId +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", creationDateTime=" + creationDateTime +
                ", retweets=" + retweets +
                ", favourites=" + favourites +
                '}';
    }
}
