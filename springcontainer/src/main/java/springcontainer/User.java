package springcontainer;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class User {
	//field
	private Long no;
	private String name;
	
	private Friend friend;
	
	private List<String> friends;
	
	public List<String> getFriends() {
		return friends;
	}
	public void setFriends(List<String> friends) {
		this.friends = friends;
	}
	//생성자
	public User() {
		
	}
	public User(String name) {
		this.name=name;
	}
	
	public User(Long no,String name) {
		this.no =no;
		this.name=name;
		
	}
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Friend getFriend() {
		return friend;
	}
	public void setFriend(Friend friend) {
		this.friend = friend;
	}
	@Override
	public String toString() {
		return "User [no=" + no + ", name=" + name + ", friend=" + friend + ", friends=" + friends + "]";
	}
	
	
	
}
