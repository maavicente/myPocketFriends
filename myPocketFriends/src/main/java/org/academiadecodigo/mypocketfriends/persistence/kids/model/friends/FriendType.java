package org.academiadecodigo.mypocketfriends.persistence.kids.model.friends;

import java.util.Arrays;
import java.util.List;

public enum FriendType {

    CRISTIANO_RONALDO("https://pbs.twimg.com/profile_images/1144028125380186114/tedrd-Ay.png", "Cristiano"),
    TMNT_RAPHAEL("https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/614f33fc-4ff0-497a-af2e-aafe92beec4f/dxhlm4-aec59956-aa6f-4af8-a77c-bc87cb1dd7ab.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7InBhdGgiOiJcL2ZcLzYxNGYzM2ZjLTRmZjAtNDk3YS1hZjJlLWFhZmU5MmJlZWM0ZlwvZHhobG00LWFlYzU5OTU2LWFhNmYtNGFmOC1hNzdjLWJjODdjYjFkZDdhYi5qcGcifV1dLCJhdWQiOlsidXJuOnNlcnZpY2U6ZmlsZS5kb3dubG9hZCJdfQ.601HBb42etOaPMTkEtIZhuFIVXTEUGaPz8kKu2j6-5w", "Raphael"),
    DOLPHIN("https://cosmos-magazine.imgix.net/file/spina/photo/10088/170424_Dolphin2_Full.jpg?fit=clip&w=835", "Dolphin"),
    CATARINA_PERES("https://yt3.ggpht.com/a/AGF-l79QdNcVvgSz0hvE6HWDoncUvGX6Wbu0rtWV4A=s288-c-k-c0xffffffff-no-rj-mo", "Catarina"),
    BUMBLEBEE("https://www.sideshow.com/storage/product-images/904237/bumblebee_transformers_silo.png", "BumbleBee");

    private String path;
    private String name;

    FriendType(String path, String name) {
        this.path = path;
        this.name = name;
    }

    public static List<FriendType> getFriendTypeList() {
        return Arrays.asList(FriendType.values());
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }
}
