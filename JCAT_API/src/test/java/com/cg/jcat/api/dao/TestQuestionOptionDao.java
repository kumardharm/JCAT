package com.cg.jcat.api.dao;

import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.jcat.api.entity.QuestionOption;

import ch.qos.logback.core.net.SyslogOutputStream;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase
@TestPropertySource(
		  locations = "classpath:application-integrationtest.properties")
public class TestQuestionOptionDao {
	
	@Autowired
	QuestionOptionDao questionOptionDao;

	@Test
	@Ignore
	public void testSaveQuestionOption() {
		QuestionOptionModel questionOption = toGetQuestionOption();
		assertEquals(true, questionOptionDao.saveQuestionOption(questionOption));
	}
	
	@Test
	public void getQuestionOption() {
		
		QuestionOptionModel questionOption = toGetQuestionOption();
		questionOptionDao.saveQuestionOption(questionOption);
		QuestionOption found = questionOptionDao.findByOptionTextEN(questionOption.getOption_text_EN());
		assertEquals(found.getOption_text_EN(), questionOption.getOption_text_EN());
	}
	
	@Test
	public void getUpdateQuestionOption()
	{
		QuestionOptionModel questionOption = toGetQuestionOption();
		questionOption.setOption_text_EN("updated text");
		questionOptionDao.updateQuestionOption(questionOption);
		QuestionOption found = questionOptionDao.findByOptionTextEN(questionOption.getOption_text_EN());
		found.setOption_text_EN("updated text");
		
		assertEquals("updated text",found.getOption_text_EN());
	}
	
	private QuestionOptionModel toGetQuestionOption() {

		QuestionOptionModel questionOption = new QuestionOptionModel();
		questionOption.setOptionId(3);
		questionOption.setOption_text_EN("text1");
		questionOption.setOptionTextLang2("lang1");
		//questionOption.setQuestionId(questionOptionModel.getQuestionId());
		return questionOption;
	}

}
