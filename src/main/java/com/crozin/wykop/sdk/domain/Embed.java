package com.crozin.wykop.sdk.domain;
import java.net.URL;

import com.crozin.wykop.sdk.AvatarQuality;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Embed {
    @JsonProperty("type")
    private String type;

    @JsonProperty("preview")
    private URL preview;

    @JsonProperty("url")
    private URL url;

    @JsonProperty("source")
    private String source;

    @JsonProperty("plus18")
    private boolean plus18;


    public URL getUrl() {
        if (url != null) {
            return url;
        }
        return null;
    }
}
