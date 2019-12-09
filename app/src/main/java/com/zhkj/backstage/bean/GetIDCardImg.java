package com.zhkj.backstage.bean;

import java.io.Serializable;

public class GetIDCardImg implements Serializable {

    /**
     * Id : 129
     * AccountIDCardPicID : 129
     * ImageUrl : 82dabea3699d4c3eb251345761c12bca.jpg
     * UserID : 15757964771
     * IsUse : Y
     * Sort : 1
     * page : 1
     * limit : 999
     * Version : 0
     */

    private int Id;
    private int AccountIDCardPicID;
    private String ImageUrl;
    private String UserID;
    private String IsUse;
    private String Sort;
    private int page;
    private int limit;
    private int Version;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getAccountIDCardPicID() {
        return AccountIDCardPicID;
    }

    public void setAccountIDCardPicID(int AccountIDCardPicID) {
        this.AccountIDCardPicID = AccountIDCardPicID;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String ImageUrl) {
        this.ImageUrl = ImageUrl;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public String getIsUse() {
        return IsUse;
    }

    public void setIsUse(String IsUse) {
        this.IsUse = IsUse;
    }

    public String getSort() {
        return Sort;
    }

    public void setSort(String Sort) {
        this.Sort = Sort;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getVersion() {
        return Version;
    }

    public void setVersion(int Version) {
        this.Version = Version;
    }
}
