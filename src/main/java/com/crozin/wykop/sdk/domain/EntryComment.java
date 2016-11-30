package com.crozin.wykop.sdk.domain;

import java.net.URL;
import java.util.Date;

import com.crozin.wykop.sdk.json.DateDeserializer;
import com.crozin.wykop.sdk.util.DeserializationUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonIgnoreProperties({ "source", "entry_id", "deleted", "vote_count", "user_vote", "voters", "type", "app", "violation_url"})
public class EntryComment {
	private Integer id;
	
	@JsonIgnore
	private Author _author;
	
	@JsonDeserialize(using = DateDeserializer.class)
	private Date date;
	
	@JsonProperty("body")
	private String content;

	private Boolean blocked;
	
	@JsonProperty
	private String author, author_sex;
	
	@JsonProperty
	private Integer author_group;
	
	@JsonProperty
	private URL author_avatar, author_avatar_med, author_avatar_lo, author_avatar_big;

	@JsonProperty("embed")
	private Embed embed;

	private String source;


	public Integer getId() {
		return id;
	}

	public Author getAuthor() {
		if (_author == null) {
			_author = DeserializationUtils.readAuthor(this);
		}
		
		return _author;
	}

	public Date getDate() {
		return date;
	}

	public String getContent() {
		return content;
	}
	
	public Boolean isBlocked() {
		return blocked;
	}

	public URL getEmbedUrl() {
		if (embed != null) {
			return embed.getUrl();
		}
		return null;
	}

	public String getEmbedUrlAsString() {
		if (getEmbedUrl() != null) {
			return getEmbedUrl().toString();
		}
		return "";
	}
}
