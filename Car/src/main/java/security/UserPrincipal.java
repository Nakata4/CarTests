package security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import beans.CarBean;
import beans.UserBean;



public class UserPrincipal implements UserDetails {
	private UserBean user;
	private Set<GrantedAuthority> authorities;
	
	public UserPrincipal(UserBean user, Set<CarBean> cars) {
		this.user=user;
		authorities = new HashSet<GrantedAuthority>();
		insertCars(cars);
		
	}
	private void insertCars(Set<CarBean> cars) {
		for(CarBean car : cars) {
			authorities.add(new SimpleGrantedAuthority(car.getCode()));
		}
		if(authorities.isEmpty()) {
			authorities.add(new SimpleGrantedAuthority("CAR_USER"));
			authorities.add(new SimpleGrantedAuthority("CAR_ADMIN"));
		}
		
	}
	@Override
	public Collection<GrantedAuthority> getAuthorities() {
	
		return authorities;
	}

	@Override
	public String getPassword() {
		
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
	
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
	
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
	
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}
	public int getLoggedInUserId() {
		return user.getId();
	}
	public UserBean getLoggedInUser() {
		return user;
	}

} 