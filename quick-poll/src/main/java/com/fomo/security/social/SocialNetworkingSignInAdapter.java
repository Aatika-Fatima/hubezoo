package com.fomo.security.social;

import java.util.Arrays;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.NativeWebRequest;

@Component
public class SocialNetworkingSignInAdapter implements SignInAdapter {
 

	@Override
	public String signIn(String username, Connection<?> connection, NativeWebRequest request) {
		System.err.println("SocialNetworkingSignInAdapter....................    ");
		Facebook facebook = (Facebook) connection.getApi();
		System.err.println(facebook.userOperations().getUserProfile().getId());
		SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(connection.getDisplayName(), null,
				Arrays.asList(new SimpleGrantedAuthority("FACEBOOK_USER"))));
		return  null;
	}
	
 

}
