package com.fomo.security.social;

import java.sql.PreparedStatement;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.stereotype.Component;

import com.fomo.dao.AccountRepository;
import com.fomo.model.Account;

@Component
public class SocialNetworkingSignUp implements ConnectionSignUp {

	@Autowired
	DataSource dataSource;

	@PostConstruct
	public void postConstruct() {
		System.err.println("Account repository created......................");
	}

	private void saveCustomer(Account account) {
		try {
			java.sql.Connection connnection = dataSource.getConnection();
			connnection.setAutoCommit(true);
			String SQL = "insert into Account(username, password, enabled) values (?,?,? )";
			PreparedStatement pst = connnection.prepareStatement(SQL);
			pst.setString(1, account.getUsername());
			pst.setString(2, account.getPassword());
			pst.setBoolean(3, true);
			pst.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String execute(Connection<?> connection) {
		Facebook facebook = (Facebook) connection.getApi();
		User userProfile = facebook.userOperations().getUserProfile();
		Account account = new Account();
		account.setUsername(connection.getDisplayName());
		account.setPassword("secret");
		account.setFirstName(userProfile.getFirstName() );
		account.setLastName(userProfile.getLastName());
		account.setEnabled(true);

		if (accountRepository != null) {

			accountRepository.save(account);
			System.err.println("Account Repository Created");
		} else {
			saveCustomer(account);
			System.err.println("accunt created .......via datasource.....................");
		}

		return account.getUsername();
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Autowired
	private AccountRepository accountRepository;

	public AccountRepository getAccountRepository() {
		return accountRepository;
	}

	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

}
