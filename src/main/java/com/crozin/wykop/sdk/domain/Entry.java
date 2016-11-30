package com.crozin.wykop.sdk.domain;

import java.net.URL;
import java.util.Date;
import java.util.List;

import com.crozin.wykop.sdk.json.CommentsDeserializer;
import com.crozin.wykop.sdk.json.DateDeserializer;
import com.crozin.wykop.sdk.util.DeserializationUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Entry extends MyWykop {
	private Integer id;
	
	@JsonIgnore
	private Author _author;
	
	@JsonIgnore
	private Author _receiver;
	
	@JsonProperty("body")
	private String content;
	
	private URL url;
	
	@JsonDeserialize(using = DateDeserializer.class)
	private Date date;
	
	private Boolean blocked;

	@JsonDeserialize(using = CommentsDeserializer.class)
	private List<EntryComment> comments;
	
	@JsonProperty
	private String author, author_sex;
	
	@JsonProperty
	private Integer author_group;
	
	@JsonProperty
	private URL author_avatar, author_avatar_med, author_avatar_lo, author_avatar_big;
	
	@JsonProperty
	private String receiver, receiver_sex;
	
	@JsonProperty
	private Integer receiver_group;
	
	@JsonProperty
	private URL receiver_avatar, receiver_avatar_med, receiver_avatar_lo, receiver_avatar_big;


	private Entry entry;

	public Integer getId() {
		return id;
	}

	public Author getAuthor() {
		if (_author == null) {
			_author = DeserializationUtils.readAuthor(this);
		}
		
		return _author;
	}
	
	public Author getReceiver() {
		if (_receiver == null) {
			_receiver = DeserializationUtils.readAuthor(this, "receiver");
		}
		
		return _receiver;
	}

	public String getContent() {
		return content;
	}

	public URL getUrl() {
		return url;
	}

	public Date getDate() {
		return date;
	}
	
	public Boolean isBlocked() {
		return blocked;
	}
	
	public List<EntryComment> getComments() {
		return comments;
	}
}
