package com.womenempowerment;

import static org.junit.jupiter.api.Assertions.assertEquals;


import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.womenempowerment.dao.IFeedBackDao;
import com.womenempowerment.dao.INGODao;
import com.womenempowerment.dao.ISchemeDao;
import com.womenempowerment.dao.ITraineeDao;
import com.womenempowerment.dao.ITrainingCourseDao;
import com.womenempowerment.exception.FeedbackNotFoundException;
import com.womenempowerment.exception.NGONotFoundException;
import com.womenempowerment.exception.SchemeNotFoundException;
import com.womenempowerment.exception.TraineeNotFoundException;
import com.womenempowerment.exception.TrainingCourseNotFoundException;
import com.womenempowerment.model.FeedBack;
import com.womenempowerment.model.NGO;
import com.womenempowerment.model.Scheme;
import com.womenempowerment.model.Trainee;
import com.womenempowerment.model.TrainingCourse;
import com.womenempowerment.model.User;
import com.womenempowerment.repository.IFeedbackRepository;
import com.womenempowerment.repository.INGORepository;
import com.womenempowerment.repository.ISchemeRepository;
import com.womenempowerment.repository.ITraineeRepository;
import com.womenempowerment.repository.ITrainingCourseRepository;
import com.womenempowerment.repository.IUserRepository;

@SpringBootTest
public class WomenEmpowermentApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private ITraineeDao tdao;
	@Autowired
	private ISchemeDao sdao;
	@Autowired
	private IFeedBackDao fdao;
	@Autowired
	private INGODao ndao;
	@Autowired
	private ITrainingCourseDao tcdao;

	@MockBean
	private ITraineeRepository trepos;
	@MockBean
	private ISchemeRepository srepos;
	@MockBean
	private IFeedbackRepository frepos;
	@MockBean
	private INGORepository nrepos;
	@MockBean
	private ITrainingCourseRepository tcrepos;
	@MockBean
	private IUserRepository urepos;

	/**
	 * 
	 * JUnit tests for all methods of ITraineeDao
	 * 
	 */
	@Test
	public void viewAllTraineeTest() throws TraineeNotFoundException {
		Trainee t1 = new Trainee();
		Trainee t2 = new Trainee();

		t1.setTraineeId(100);
		t1.setFirstName("siddhesh");
		t1.setLastName("wable");
		t2.setTraineeId(200);
		t2.setFirstName("siddhesh");
		t2.setLastName("wable");
		when(trepos.findAll()).thenReturn(Stream.of(t1, t2).collect(Collectors.toList()));
		assertEquals(2, tdao.viewAllTrainee().size());
	}

	@Test
	public void viewTraineeByAadharTest() throws TraineeNotFoundException {
		Trainee t = new Trainee();

		t.setTraineeId(100);
		t.setAadharNo(32701122);
		t.setFirstName("siddhesh");

		when(trepos.getTraineeByAadhar(32701122)).thenReturn(t);

		assertEquals(100, tdao.viewTraineeByAadhar(32701122).getTraineeId());
	}

	/**
	 * 
	 * JUnit tests for all methods of ISchemeDao
	 * 
	 */
	@Test
	public void viewAllScheme() throws SchemeNotFoundException {
		Scheme s1 = new Scheme();
		Scheme s2 = new Scheme();
		s1.setSchemeId(233);
		s1.setSchemeName("ABC");
		s2.setSchemeId(345);
		s2.setSchemeName("CG");
		when(srepos.findAll()).thenReturn(Stream.of(s1, s2).collect(Collectors.toList()));
		assertEquals(2, sdao.viewAllScheme().size());
	}

	@Test
	public void viewSchemeByTypeTest() throws SchemeNotFoundException {
		Scheme s1 = new Scheme();
		s1.setSchemeId(234);
		s1.setSchemeName("BETI BACHAO");
		s1.setSchemeType("GOVT");
		when(srepos.viewSchemesByType("GOVT")).thenReturn(Stream.of(s1).collect(Collectors.toList()));
		assertEquals(1, sdao.viewSchemesByType("GOVT").size());
	}

	/**
	 * 
	 * JUnit tests for all methods of ITrainingCourseDao
	 * 
	 */
	@Test
	public void viewAllTrainingCourseTest() throws TrainingCourseNotFoundException {

		TrainingCourse tc = new TrainingCourse();
		tc.setTrainingCourseId(100);
		tc.setCourseName("abc");
		tc.setCourseDuration("2 months");

		when(tcrepos.findAll()).thenReturn(Stream.of(tc).collect(Collectors.toList()));

		assertEquals(1, tcdao.viewAllTrainingCourse().size());

	}

	@Test
	public void viewByTrainingCourseNameTest() throws TrainingCourseNotFoundException {

		TrainingCourse tc = new TrainingCourse();
		tc.setTrainingCourseId(100);
		tc.setCourseName("abc");
		tc.setCourseDuration("2 months");

		when(tcrepos.findByName("abc")).thenReturn(Stream.of(tc).collect(Collectors.toList()));

		assertEquals(1, tcdao.viewByTrainingCourseName("abc").size());

	}

	// JUnit Test for View All Feedback method
	@Test
	public void viewAllFeedBackTest() throws FeedbackNotFoundException {
		FeedBack f = new FeedBack();
		f.setFeedBackId(100);
		f.setComments("good");
		f.setOverallRating(5);

		when(frepos.findAll()).thenReturn(Stream.of(f).collect(Collectors.toList()));

		assertEquals(1, fdao.viewAllFeedBack().size());

	}

	// JUnit Test for View All NGO method
	@Test
	public void viewAllNGOTest() throws NGONotFoundException {
		NGO n1 = new NGO();
		NGO n2 = new NGO();
		n1.setNgoId(15);
		n1.setDonation(1500);
		n2.setNgoId(45);
		n2.setDonation(8963);
		when(nrepos.findAll()).thenReturn(Stream.of(n1, n2).collect(Collectors.toList()));

		assertEquals(2, ndao.viewAllNGO().size());
	}

	@Test
	public void viewNGOByLocationTest() throws NGONotFoundException {

		NGO n1 = new NGO();
		n1.setNgoId(123);
		n1.setNgoLocation("hyd");
		when(nrepos.viewNGOByLocation("hyd")).thenReturn(Stream.of(n1).collect(Collectors.toList()));
		assertEquals(1, ndao.viewNGOByLocation("hyd").size());
	}

	@Test
	public void viewNGOByMotiveTest() throws NGONotFoundException {

		NGO ng = new NGO();
		ng.setNgoId(101);
		ng.setNgoMotive("abc");
		when(nrepos.viewNGOByMotive("abc")).thenReturn(Stream.of(ng).collect(Collectors.toList()));
		assertEquals(1, ndao.viewNGOByMotive("abc").size());

	}

	// JUnit Test for User Login Method
	@Test
	public void loginTest() {
		User u = new User();
		u.setId(100);
		u.setUsername("siddhesh");
		u.setPassword("Siddhesh@1190");
		u.setSecQuestion("Age?");
		u.setSecAnswer("22");

		when(urepos.getUserByUsername("siddhesh")).thenReturn(u);

		assertEquals("Siddhesh@1190", u.getPassword());
	}

}
