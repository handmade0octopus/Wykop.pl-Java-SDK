package com.crozin.wykop.sdk.domain;

import java.net.URL;

import com.crozin.wykop.sdk.AvatarQuality;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonIgnoreProperties({ "email", "is_observed", "sex" , "signup_date", "violation_url", "url", "is_blocked"})
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Profile {
	public enum Group {
		GREEN         (0, "Zielony", 0x339933),
		ORANGE        (1, "Pomarańczowy", 0xFF5917),
		RED           (2, "Bordowy", 0xBB0000),
		ADMINISTRATOR (5, "Administrator", 0x000000),
		BANNED        (1001, "Zbanowany", 0x999999),
		REMOVED       (1002, "Usunięty", 0x999999),
		CLIENT        (2001, "Klient", 0x3F6FA0);
		
		private final Integer id;
		private final String label;
		private final Integer color;
		
		Group(Integer id, String label, Integer color) {
			this.id = id;
			this.label = label;
			this.color = color;
		}

		public Integer getId() {
			return id;
		}

		public String getLabel() {
			return label;
		}
		
		public Integer getColor() {
			return color;
		}
		
		static Group valueOf(int id) {
			for (Group profileGroup : values()) {
				if (profileGroup.getId().equals(id)) {
					return profileGroup;
				}
			}
			
			throw new IllegalArgumentException("Invalid ID");
		}
	}
	
	@JsonProperty("login")
	private String username;

	@JsonProperty("email")
	private String privateEmail;

	@JsonProperty("public_email")
	private String email;

	@JsonProperty("name")
	private String name;

	@JsonProperty("www")
	private URL website;
	
	@JsonProperty("jabber")
	private String jabberAccount;
	
	@JsonProperty("gg")
	private Integer ggAccount;

	@JsonProperty("city")
	private String city;

	@JsonProperty("about")
	private String about;

	@JsonProperty("author_group")
	private Integer group;
	
	@JsonProperty("links_added")
	private Integer addedLinksCount;
	
	@JsonProperty("links_published")
	private Integer publishedLinksCount;
	
	@JsonProperty("comments")
	private Integer commentsCount;

	@JsonProperty("rank")
	private Integer rankPosition;

	@JsonProperty("followers")
	private Integer followersCount;

	@JsonProperty("following")
	private Integer followingCount;
	
	@JsonProperty("entries")
	private Integer entriesCount;

	@JsonProperty("entries_comments")
	private Integer entriesCommentsCount;
	
	@JsonProperty("diggs")
	private Integer diggsCount;
	
	@JsonProperty("buries")
	private Integer buriesCount;
	
	@JsonProperty("groups")
	private Integer groupsCount;

	@JsonProperty("related_links")
	private Integer related_links;

	@JsonProperty("singup_date")
	private String singupDate;

	@JsonProperty("avatar")
	private URL defaultAvatar;

	@JsonProperty("avatar_big")
	private URL highQualityAvatar;
	
	@JsonProperty("avatar_med")
	private URL mediumQualityAvatar;

	@JsonProperty("avatar_lo")
	private URL lowQualityAvatar;


	@JsonProperty("is_observed")
	private boolean isObserved;

	@JsonProperty("is_blocked")
	private boolean isBlocked;

	@JsonProperty("sex")
	private String sex;

	@JsonProperty("url")
	private URL url;

	@JsonProperty("violation_url")
	private URL violation_url;




	
	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public String getAbout() {
		return about;
	}

	public String getCity() {
		return city;
	}

	public URL getWebsite() {
		return website;
	}

	public String getJabberAccount() {
		return jabberAccount;
	}

	public Integer getGgAccount() {
		return ggAccount;
	}

	public Integer getAddedLinksCount() {
		return addedLinksCount;
	}

	public Integer getPublishedLinksCount() {
		return publishedLinksCount;
	}

	public Integer getCommentsCount() {
		return commentsCount;
	}

	public Integer getEntriesCount() {
		return entriesCount;
	}

	public Integer getDiggsCount() {
		return diggsCount;
	}

	public Integer getBuriesCount() {
		return buriesCount;
	}

	public Integer getFollowersCount() {
		return followersCount;
	}

	public Integer getFollowingCount() {
		return followingCount;
	}
	
	public Integer getGroupsCount() {
		return groupsCount;
	}

	public Integer getRankPosition() {
		return rankPosition;
	}
	
	public Group getGroup() {
		return Group.valueOf(group);
	}
	
	public URL getAvatar() {
		return getAvatar(AvatarQuality.DEFAULT);
	}
	
	public URL getAvatar(AvatarQuality avatarQuality) {
		switch (avatarQuality) {
		case LOW:
			return lowQualityAvatar;
		case MEDIUM:
			return mediumQualityAvatar;
		case HIGH:
			return highQualityAvatar;
		default:
			return defaultAvatar;
		}
	}


}
