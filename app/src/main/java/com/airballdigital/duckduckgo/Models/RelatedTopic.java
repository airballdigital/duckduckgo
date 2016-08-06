package com.airballdigital.duckduckgo.Models;

/**
 * Created by Allen Carden on 8/6/2016.
 */
import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;

public class RelatedTopic {
    @SerializedName("Result")
    private String result;

    @SerializedName("Icon")
    private Icon icon;

    @SerializedName("FirstURL")
    private String firstUrl;

    @SerializedName("Text")
    private String text;

    public String getResult() {
        return result;
    }

    public boolean hasIcon() {
        return !TextUtils.isEmpty(icon.getUrl());
    }

    public Icon getIcon() {
        return icon;
    }

    public String getFirstUrl() {
        return firstUrl;
    }

    public String getText() {
        return text;
    }

    public static class Icon {
        @SerializedName("URL")
        private String url;

        @SerializedName("Width")
        private String width;

        @SerializedName("Height")
        private String height;

        public String getUrl() {
            return url;
        }

        public Integer getWidth() {
            return TextUtils.isEmpty(width) ? null : Integer.parseInt(width);
        }

        public Integer getHeight() {
            return TextUtils.isEmpty(height) ? null : Integer.parseInt(height);
        }
    }

}