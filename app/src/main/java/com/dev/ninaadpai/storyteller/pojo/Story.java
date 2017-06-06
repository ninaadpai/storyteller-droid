package com.dev.ninaadpai.storyteller.pojo;

/**
 * Created by ninaadpai on 6/5/17.
 */

public class Story {
    private final String creatorImgUrl, creatorName, storyTitle, startDate, hashTags, numOfAuthors;
    private final int bookmarked;

    public Story(String creatorImgUrl, String creatorName, String storyTitle, String startDate, String hashTags, String numOfAuthors, int bookmarked) {
        this.creatorImgUrl = creatorImgUrl;
        this.creatorName = creatorName;
        this.storyTitle = storyTitle;
        this.startDate = startDate;
        this.hashTags = hashTags;
        this.numOfAuthors = numOfAuthors;
        this.bookmarked = bookmarked;
    }

    public String getCreatorImgUrl() {
        return creatorImgUrl;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public String getStoryTitle() {
        return storyTitle;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getHashTags() {
        return hashTags;
    }

    public String getNumOfAuthors() {
        return numOfAuthors;
    }

    public int getBookmarked() {
        return bookmarked;
    }

    @Override
    public String toString() {
        return "Story{" +
                "creatorImgUrl='" + creatorImgUrl + '\'' +
                ", creatorName='" + creatorName + '\'' +
                ", storyTitle='" + storyTitle + '\'' +
                ", startDate='" + startDate + '\'' +
                ", hashTags='" + hashTags + '\'' +
                ", numOfAuthors='" + numOfAuthors + '\'' +
                ", bookmarked=" + bookmarked +
                '}';
    }
}
