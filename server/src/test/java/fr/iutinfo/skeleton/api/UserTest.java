package fr.iutinfo.skeleton.api;

import static org.junit.Assert.*;

import javax.validation.constraints.AssertTrue;

import org.junit.Test;

public class UserTest {
	
	@Test
	public void PasswordIsGoodTest(){
		User u1 = new User(1,"Patrick");
		u1.setPassword("toto");
		assertTrue(u1.isGoodPassword("toto"));
	}
	
	@Test
	public void EqualsUserTest(){
		User u1 = new User(1,"Patrick");
		User u2 = new User(2,"Patrick");
		u1.setPassword("toto");
		u1.setEmail("a@a.fr");
		u2.setEmail("a@a.fr");
		u2.setPasswdHash(u1.getPasswdHash());
		assertTrue(u1.equals(u2));
	}
	
	@Test
    public void should_set_salt_at_build () {
        User user = new User();
        assertNotNull(user.getSalt());
        assertFalse(user.getSalt().isEmpty());
    }
	
	@Test
	public void isAnonymousTest(){
		User u1 = new User(-1,"Anonymous");
		User u2 = new User(1,"Pat");
		assertTrue(u1.isAnonymous());
		assertFalse(u2.isAnonymous());
	}
	
	@Test
	public void isInUserGroupTest(){
		User u1 = new User(-1,"Anonymous");
		User u2 = new User(1,"Pat");
		assertTrue(u2.isInUserGroup());
		assertFalse(u1.isInUserGroup());
	}
	
	
}
